/*******************************************************************************
 * Copyright (c) 2013 TerraFrame, Inc. All rights reserved. 
 * 
 * This file is part of Runway SDK(tm).
 * 
 * Runway SDK(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * Runway SDK(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Runway SDK(tm).  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
/**
 * Created on Aug 14, 2005
 *
 */
package com.runwaysdk.dataaccess.metadata;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.runwaysdk.SystemException;
import com.runwaysdk.business.generation.ClassManager;
import com.runwaysdk.business.generation.GenerationFacade;
import com.runwaysdk.business.generation.GenerationUtil;
import com.runwaysdk.business.generation.GeneratorIF;
import com.runwaysdk.business.generation.JavaArtifactMdEnumerationCommand;
import com.runwaysdk.business.generation.JavaArtifactMdTypeCommand;
import com.runwaysdk.business.generation.MdEnumerationGenerator;
import com.runwaysdk.business.generation.TypeGenerator;
import com.runwaysdk.business.generation.dto.EnumerationDTOGenerator;
import com.runwaysdk.constants.ComponentInfo;
import com.runwaysdk.constants.EnumerationMasterInfo;
import com.runwaysdk.constants.MdAttributeEnumerationInfo;
import com.runwaysdk.constants.MdEnumerationInfo;
import com.runwaysdk.constants.MdTypeInfo;
import com.runwaysdk.constants.RelationshipTypes;
import com.runwaysdk.dataaccess.AttributeBooleanIF;
import com.runwaysdk.dataaccess.BusinessDAO;
import com.runwaysdk.dataaccess.BusinessDAOIF;
import com.runwaysdk.dataaccess.Command;
import com.runwaysdk.dataaccess.DataAccessException;
import com.runwaysdk.dataaccess.EntityDAO;
import com.runwaysdk.dataaccess.EnumerationItemDAO;
import com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF;
import com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF;
import com.runwaysdk.dataaccess.MdBusinessDAOIF;
import com.runwaysdk.dataaccess.MdEnumerationDAOIF;
import com.runwaysdk.dataaccess.RelationshipDAO;
import com.runwaysdk.dataaccess.RelationshipDAOIF;
import com.runwaysdk.dataaccess.attributes.InvalidReferenceException;
import com.runwaysdk.dataaccess.attributes.entity.Attribute;
import com.runwaysdk.dataaccess.attributes.entity.AttributeReference;
import com.runwaysdk.dataaccess.cache.DataNotFoundException;
import com.runwaysdk.dataaccess.cache.ObjectCache;
import com.runwaysdk.dataaccess.database.Database;
import com.runwaysdk.dataaccess.database.EntityDAOFactory;
import com.runwaysdk.dataaccess.transaction.Transaction;
import com.runwaysdk.query.BusinessDAOQuery;
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.util.FileIO;


/**
 * @author nathan
 *
 */
public class MdEnumerationDAO extends MdTypeDAO implements MdEnumerationDAOIF
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = 1474092289397210001L;

  /**
   * The default constructor, does not set any attributes
   */
  public MdEnumerationDAO()
  {
    super();
  }

  /**
   * Returns the signature of the metadata.
   *
   * @return signature of the metadata.
   */
  public String getSignature()
  {
    String signature = super.getSignature();
    signature += " MasterType:"+this.getMasterListMdBusinessDAO().definesType();
    signature += " Enums[";
    boolean firstIteration = true;
    for (BusinessDAOIF businessDAOIF : getAllEnumItemsOrdered())
    {
      if (!firstIteration)
      {
        signature += ", ";
      }
      else
      {
        firstIteration = false;
      }
      signature += businessDAOIF.getAttributeIF(EnumerationMasterInfo.NAME).getValue();
    }
    signature += "]";

    return signature;
  }

  /**
   * Constructs a MdEnumeration from the given hashtable of Attributes.
   *
   * <br/><b>Precondition:</b>   attributeMap != null
   * <br/><b>Precondition:</b>   type != null
   *
   * @param attributeMap
   * @param type
   */
  public MdEnumerationDAO(Map<String, Attribute> attributeMap, String type)
  {
    super(attributeMap, type);
  }

  /**
   * Returns the name of the table used to store instances of the class that
   * this object defines.
   *
   * @return name of the table used to store instances of the class that this
   *         object defines.
   */
  public String getTableName()
  {
    return this.getAttributeIF(MdEnumerationInfo.TABLE_NAME).getValue();
  }

  /**
   * Sets the name of the table.
   *
   */
  public void setTableName(String tableName)
  {
    this.getAttribute(MdEnumerationInfo.TABLE_NAME).setValue(tableName);
  }

  /**
   *Returns the type of the enumeration that this object defines.
   * @return the type of the enumeration that this object defines.
   */
  public String definesEnumeration()
  {
    return EntityDAOFactory.buildType(this.getPackage(), this.getEnumerationName());
  }

  /**
   *Returns the name of the enumeration that this object defines.
   * @return the name of the enumeration that this object defines.
   */
  public String getEnumerationName()
  {
    return this.getAttributeIF(MdTypeInfo.NAME).getValue();
  }

  /**
   * Returns the name of the package of the enumeration that this object defines.
   * @return name of the package of the emumeration that this object defines.
   */
  public String getPackage()
  {
    return this.getAttributeIF(MdTypeInfo.PACKAGE).getValue();
  }

  /**
   *True if this enumeration includes all items from the master enumeration list,
   * false otherwise.
   *
   * @return True if this enumeration includes all items from the master enumeration list,
   *         false otherwise.
   */
  public boolean includeAllEnumerationItems()
  {
    AttributeBooleanIF attributeBoolean = (AttributeBooleanIF)this.getAttributeIF(MdEnumerationInfo.INCLUDE_ALL);

    if (attributeBoolean.isTrue())
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   *Returns the MdBusinessIF that defines the master list of
   * items used buy this enumeration.  If this enumeration does not
   * reference any such type, then null is returned.
   *
   *
   * @return the MdBusinessIF that defines the master list of
   *         items used buy this enumeration.  If this enumeration does not
   *         reference any such type, then null is returned.
   */
  public MdBusinessDAOIF getMasterListMdBusinessDAO()
  {
    String attributeMdBusinessRef = this.getAttributeIF(MdEnumerationInfo.MASTER_MD_BUSINESS).getValue();

    if (!attributeMdBusinessRef.trim().equals(""))
    {
      AttributeReference attributeReference = (AttributeReference)this.getAttributeIF(MdEnumerationInfo.MASTER_MD_BUSINESS);
      return (MdBusinessDAOIF)attributeReference.dereference();
    }
    else
    {
      return null;
    }
  }

  /**
   *
   * @return
   */
  public List<BusinessDAOIF> getAllEnumItems()
  {
    List<RelationshipDAOIF> relationshipArray = this.getChildren(RelationshipTypes.ENUMERATION_ATTRIBUTE_ITEM.getType());
    List<BusinessDAOIF> businessDAOlist = new LinkedList<BusinessDAOIF>();

    for (int i=0; i<relationshipArray.size(); i++)
    {
      businessDAOlist.add(relationshipArray.get(i).getChild());
    }

    return businessDAOlist;
  }

  /**
   *
   * @return
   */
  public List<BusinessDAOIF> getAllEnumItemsOrdered()
  {
    List<BusinessDAOIF> businessDAOlist = this.getAllEnumItems();

    Collections.sort(businessDAOlist,  new Comparator<BusinessDAOIF>()
        {
      public int compare(BusinessDAOIF o1, BusinessDAOIF o2)
      {
        return o1.getAttributeIF(EnumerationMasterInfo.NAME).getValue().compareTo(o2.getAttributeIF(EnumerationMasterInfo.NAME).getValue());
      }
    });

    return businessDAOlist;
  }


  /**
   * Returns the name of the method used on the generated master list query class to find
   * items that participate in this enumeration.
   * @return name of the method used on the generated master list query class to find
   * items that participate in this enumeration.
   */
  public String getQueryMethodName()
  {
    return "enum_"+this.getTypeName();
  }


  /**
   * Returns the name of the method used on the generated master list query class to find
   * items that do not participate in this enumeration.
   * @return name of the method used on the generated master list query class to find
   * items that do not participate in this enumeration.
   */
  public String getNegatedQueryMethodName()
  {
    return "notEnum_"+this.getTypeName();
  }

  /**
   *
   * @param enumItemId
   * @return
   */
  public boolean isValidEnumerationItem(String enumItemId)
  {
    List<BusinessDAOIF> businessDAOlist = this.getAllEnumItems();
    for (BusinessDAOIF businessDAOIF : businessDAOlist)
    {
      if (businessDAOIF.getId().equals(enumItemId))
      {
        return true;
      }
    }
    return false;
  }

  /**
   *Validates this metadata object.
   *
   * @throws DataAccessException when this MetaData object is not valid.
   */
  protected void validate()
  {
    if (this.isNew())
    {
      this.validateNew();
    }

    if (this.getAttributeIF(MdEnumerationInfo.NAME).isModified())
    {
      String mdMasterClassId = this.getAttributeIF(MdEnumerationInfo.MASTER_MD_BUSINESS).getValue();

      QueryFactory queryFactory = new QueryFactory();
      BusinessDAOQuery mdEnumQuery = queryFactory.businessDAOQuery(MdEnumerationInfo.CLASS);

      mdEnumQuery.
           WHERE(mdEnumQuery.aCharacter(MdEnumerationInfo.NAME).EQ(this.getTypeName()).
           AND(mdEnumQuery.aReference(MdEnumerationInfo.MASTER_MD_BUSINESS).EQ(mdMasterClassId)).
           AND(mdEnumQuery.id().NE(this.getId()))
      );

      OIterator<BusinessDAOIF> mdEnumIterator = mdEnumQuery.getIterator();

      if (mdEnumIterator.hasNext())
      {
        MdBusinessDAOIF masterClass = this.getMasterListMdBusinessDAO();
        String errMsg = "A ["+this.getType()+"] is already defined for enumeration master class ["+masterClass.definesType()+"] with name ["+this.getTypeName()+"]" ;
        throw new DuplicateMdEnumerationDefinitionException(errMsg, this, masterClass);
      }
    }

  }

  /**
   *
   *
   */
  protected void validateNew()
  {
    super.validateNew();

    MdBusinessDAOIF mdBusinessIF  = this.getMasterListMdBusinessDAO();
    String attribClassType = mdBusinessIF.definesType();

    if (!MdElementDAO.isSubEntity(attribClassType, EnumerationMasterInfo.CLASS))
    {

      MdAttributeReferenceDAOIF mdAttribute = (MdAttributeReferenceDAOIF)getAttributeIF(MdEnumerationInfo.MASTER_MD_BUSINESS).getMdAttribute();
      String error = "Attribute [" + mdAttribute.definesAttribute() + "] on type [" + definesType()
          + "] must reference a subclass of [" + EnumerationMasterInfo.CLASS+ "]";
      throw new InvalidReferenceException(error, mdAttribute);
    }

    // check for reserved words
    if (ReservedWords.javaContains(this.getTypeName()))
    {
      throw new ReservedWordException("The name [" + this.getTypeName() + "] is reserved.", this.getTypeName(), ReservedWordException.Origin.TYPE);
    }
    if (ReservedWords.sqlContains(this.getTableName()))
    {
      throw new ReservedWordException("The name [" + this.getTableName() + "] is reserved.", this.getTableName(), ReservedWordException.Origin.TABLE);
    }
  }

  /**
   * Adds the given enumeration item to this enumeration.
   * @param enumerationItem item to add.
   */
  public void addEnumItem(EnumerationItemDAO enumerationItem)
  {
    this.addEnumItem(enumerationItem.getId());
  }

  /**
   * Adds the given enumeration item to this enumeration.
   * @param id id of the enumerationItem item to add.
   */
  @Transaction
  public void addEnumItem(String id)
  {
    RelationshipDAO newChildRelDAO = this.addChild(id, RelationshipTypes.ENUMERATION_ATTRIBUTE_ITEM.getType());
    newChildRelDAO.save(true);
  }

  @Transaction
  public void removeEnumItem(String id)
  {
    List<RelationshipDAOIF> children = this.getChildren(id, RelationshipTypes.ENUMERATION_ATTRIBUTE_ITEM.getType());

    RelationshipDAO relationshipDAO = children.get(0).getRelationshipDAO();
    relationshipDAO.delete();
  }

  @Transaction
  public void cleanEnumItems()
  {
    List<RelationshipDAOIF> children = this.getChildren(RelationshipTypes.ENUMERATION_ATTRIBUTE_ITEM.getType());

    for(RelationshipDAOIF relationshipDAO : children)
    {
      relationshipDAO.getRelationshipDAO().delete();
    }
  }

  public boolean containsEnumItem(String id)
  {
    List<RelationshipDAOIF> children = this.getChildren(RelationshipTypes.ENUMERATION_ATTRIBUTE_ITEM.getType());

    for(RelationshipDAOIF relationshipDAO : children)
    {
      if(id.equals(relationshipDAO.getChildId()))
      {
        return true;
      }
    }

    return false;
  }

  /**
   *Applies the state of this BusinessDAO to the database.  If this is a new BusinessDAO,
   * then records are created in the database and an ID is created.  If this is not a
   * new BusinessDAO, then records are modified in the database.
   *
   * <br/><b>Precondition:</b>   Attribues must have correct values as defined in their meta data.
   * <br/><b>Postcondition:</b>  state of the BusinessDAO is preserved in the database.
   * <br/><b>Postcondition:</b>  return value is not null
   *
   * @param validateRequired ture if attributes should be checked for required values,
   *                         false otherwise.  StructDAOs used by struct attributes may or
   *                         may not need required attributes validated.
   * @return ID of the BusinessDAO.
   * @throws DataAccessException if an attribute contains a value that is not
   *         correct with respect to the metadata.
   */
  public String save(boolean validateRequired)
  {
    String id = new String("");

    this.validate();

    boolean oldAppliedToDBValue = this.isAppliedToDB();

    if (this.isNew() && !this.isAppliedToDB())
    {
      // Supply a table name if one was not provided
      Attribute tableNameAttribute = this.getAttribute(MdEnumerationInfo.TABLE_NAME);
      if (!tableNameAttribute.isModified() || tableNameAttribute.getValue().trim().length() == 0)
      {
        // Create a table name
        tableNameAttribute.setValue(MdTypeDAO.createTableName(this.getTypeName()));
      }
      else
      {
        tableNameAttribute.setValue(tableNameAttribute.getValue().toLowerCase());
      }
    }

    id = super.save(validateRequired);

    // Do not create new relationships if this has already been applied to the database.
    if (this.isNew())
    {
      MdBusinessDAOIF masterMdBusinessIF  = this.getMasterListMdBusinessDAO();

      // Add a relationship between the Constants.MD_ENUMERATION BusinessDAO to
      // the class created above
      if (!this.isImport())
      {
        if (!oldAppliedToDBValue)
        {
          RelationshipDAO newChildRelDAO = this.addParent(masterMdBusinessIF.getId(), RelationshipTypes.ENUMERATION_ATTRIBUTE.getType());
          newChildRelDAO.getAttribute(ComponentInfo.KEY).setValue(this.getKey());
          newChildRelDAO.save(true);
        }

        if (this.includeAllEnumerationItems())
        {
          List<String> referenceIds = EntityDAO.getEntityIdsFromDB(masterMdBusinessIF);
          Set<String> enumeratedIds = new TreeSet<String>();

          //Get a list of all existing enumerated items
          for (BusinessDAOIF enumeratedItem : this.getAllEnumItems())
          {
            enumeratedIds.add(enumeratedItem.getId());
          }

          for (String instanceId : referenceIds)
          {
            //If the enumerated attribute item relationship has not already been created then do so
            if (!enumeratedIds.contains(instanceId))
            {
              RelationshipDAO newChildRelDAO = this.addChild(instanceId, RelationshipTypes.ENUMERATION_ATTRIBUTE_ITEM.getType());
              newChildRelDAO.save(true);
            }
          }
        }
      }

      if(!oldAppliedToDBValue)
      {
        Database.createEnumerationTable(this.getTableName(), id);
      }
    }

    return id;
  }

  /**
   *
   * @param businessContext true if this is being called from a business context, false
   * otherwise. If true then cascading deletes of other Entity objects will happen at the Business
   * layer instead of the data access layer.
   *
   */
  public void delete(boolean businessContext)
  {
    // Drop all MdAttributeEnumerations that use this MdEnumeration
    QueryFactory queryFactory = new QueryFactory();
    BusinessDAOQuery mdAttrEnumQuery = queryFactory.businessDAOQuery(MdAttributeEnumerationInfo.CLASS);
    mdAttrEnumQuery.WHERE(
        mdAttrEnumQuery.aReference(MdAttributeEnumerationInfo.MD_ENUMERATION).EQ(this.getId()));

    OIterator<BusinessDAOIF> mdAttrEnumIterator = mdAttrEnumQuery.getIterator();
    while (mdAttrEnumIterator.hasNext())
    {
      // Since we are dropping the mapping instance table for this enumeration, there is no need to delete instances
      // from that table.  It will cause a database deadlock on some databases.
      MdAttributeEnumerationDAOIF mdAttributeEnumerationIF = (MdAttributeEnumerationDAOIF) mdAttrEnumIterator.next();
      (mdAttributeEnumerationIF.getBusinessDAO()).deleteButDoNotDeleteMappingInstances(businessContext);
    }

    super.delete(businessContext);

    Database.dropEnumerationTable(this.getTableName(), this.getId());
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#create(java.util.Hashtable)
   */
  public MdEnumerationDAO create(Map<String, Attribute> attributeMap, String classType)
  {
    return new MdEnumerationDAO(attributeMap, MdEnumerationInfo.CLASS);
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#getBusinessDAO()
   */
  public MdEnumerationDAO getBusinessDAO()
  {
    return (MdEnumerationDAO) super.getBusinessDAO();
  }

  /**
   * Returns the a list of all MdEnumerationIF objects in the database, including system enumerations
   *
   * @return A list of MdEnumerationIF objects
   */
  public static List<MdEnumerationDAOIF> getAllMdEnumerations()
  {
    List<MdEnumerationDAOIF> returnList = new LinkedList<MdEnumerationDAOIF>();

    QueryFactory qFactory = new QueryFactory();
    BusinessDAOQuery mdEnumerationQ = qFactory.businessDAOQuery(MdEnumerationInfo.CLASS);

    OIterator<BusinessDAOIF> mdEnumerationIterator = mdEnumerationQ.getIterator();
    while (mdEnumerationIterator.hasNext())
    {
      MdEnumerationDAOIF mdEnumerationIF = (MdEnumerationDAOIF)mdEnumerationIterator.next();
      returnList.add(mdEnumerationIF);
    }

    return returnList;
  }


  /**
   *Returns the MdEnumerationIF object that describes the enumeration with the given type.
   *
   * <b>Precondition:</b> !enumerationType.trim().equals("")
   * <b>Precondition:</b> enumerationType != null
   *
   * @param enumerationType name of the enumeration type.
   * @return MdEnumerationIF object that describes the enumeration with the given type.
   */
  public static MdEnumerationDAOIF getMdEnumerationDAO(String enumerationType)
  {
    MdEnumerationDAOIF mdEnumeration = ObjectCache.getMdEnumerationDAO(enumerationType);

    if (mdEnumeration==null)
    {
      String error = "MdEnumeration [" + enumerationType + "] was not found";
      throw new DataNotFoundException(error, MdTypeDAO.getMdTypeDAO(MdEnumerationInfo.CLASS));
    }

    return mdEnumeration;
  }

  /**
   * Returns a command object that either creates or updates Java artifacts for this type.
   *
   * @param conn database connection object.
   *
   * @return command object that either creates or updates Java artifacts for this type.
   */
  public Command getCreateUpdateJavaArtifactCommand(Connection conn)
  {
    Command command;

    if (this.isNew())
    {
      command = new JavaArtifactMdEnumerationCommand(this, JavaArtifactMdTypeCommand.Operation.CREATE, conn);
    }
    else
    {
      command = new JavaArtifactMdEnumerationCommand(this, JavaArtifactMdTypeCommand.Operation.UPDATE, conn);
    }

    return command;
  }

  /**
   * Returns a command object that deletes Java artifacts for this type.
   *
   * @param conn database connection object.
   *
   * @return command object that deletes Java artifacts for this type.
   */
  public Command getDeleteJavaArtifactCommand(Connection conn)
  {
    return new JavaArtifactMdEnumerationCommand(this, JavaArtifactMdTypeCommand.Operation.DELETE, conn);
  }

  /**
   * Returns a command object that cleans Java artifacts for this type.
   *
   * @param conn database connection object.
   *
   * @return command object that cleans Java artifacts for this type.
   */
  public Command getCleanJavaArtifactCommand(Connection conn)
  {
    return new JavaArtifactMdEnumerationCommand(this, JavaArtifactMdTypeCommand.Operation.CLEAN, conn);
  }

  /**
   * Copies all Java source and class files from this object into files on the file system.
   */
  public void writeJavaToFile()
  {
    // Write the .class file and the dto .class file to the filesystem
    byte[] baseclass = this.getBlob(MdTypeInfo.BASE_CLASS);
    ClassManager.writeClasses(TypeGenerator.getStubClassDirectory(this), baseclass);

    // Write the dto .class file to the filesystem
    byte[] dtoClass = this.getBlob(MdTypeInfo.DTO_BASE_CLASS);
    ClassManager.writeClasses(TypeGenerator.getDTOstubClassDirectory(this), dtoClass);

    try
    {
      // Write the stub .java file to the filesystem
      String basesource = this.getAttribute(MdEnumerationInfo.BASE_SOURCE).getValue();
      FileIO.write(TypeGenerator.getJavaSrcFilePath(this), basesource);

      // Write the dto .java file to the filesystem
      String dtoSource = this.getAttribute(MdEnumerationInfo.DTO_BASE_SOURCE).getValue();
      FileIO.write(TypeGenerator.getDTOstubSrcFilePath(this), dtoSource);
    }
    catch(IOException e)
    {
      throw new SystemException(e);
    }
  }

  /**
   * Copies all Java source and class files from the file system and stores them
   * in the database.
   *
   * @param conn
   *            database connection object. This method is used during the a
   *            transaction. Consequently, the transaction must be managed
   *            manually.
   */
  public void writeFileArtifactsToDatabaseAndObjects(Connection conn)
  {
    if (!this.isSystemPackage())
    {
      String baseSource = null;

      File baseSourceFile = new File(TypeGenerator.getBaseSrcFilePath(this));

      try
      {
        baseSource = FileIO.readString(baseSourceFile);
      }
      catch (IOException e)
      {
        throw new SystemException(e);
      }

      // Update the business and dto base class and source
      byte[] baseClassBytes = GenerationFacade.getStubClass(this);
      byte[] dtoBaseClass = GenerationFacade.getDTOstubClass(this);

      String dtoBaseSource = GenerationFacade.getDTOstubSource(this);

      this.updateBaseClassAndSource(conn, baseSource, baseClassBytes, dtoBaseClass, dtoBaseSource);

      // Only update the source. The blob attributes just point to the database
      // anyway.
      this.getAttribute(MdEnumerationInfo.BASE_SOURCE).setValue(baseSource);
      this.getAttribute(MdEnumerationInfo.DTO_BASE_SOURCE).setValue(dtoBaseSource);

      // Mark the class artifiacts as modified, so that their values will be logged (if enabled)
      this.getAttribute(MdEnumerationInfo.BASE_CLASS).setModified(true);
      this.getAttribute(MdEnumerationInfo.DTO_BASE_CLASS).setModified(true);
    }
  }

  /**
   * Returns true if an attribute that stores source or class has been modified.
   *
   * @return true if an attribute that stores source or class has been modified.
   */
  @Override
  public boolean javaArtifactsModifiedOnObject()
  {
    if (!this.isSystemPackage())
    {
      if (this.getAttribute(MdEnumerationInfo.BASE_SOURCE).isModified()     ||
          this.getAttribute(MdEnumerationInfo.DTO_BASE_SOURCE).isModified() ||
          this.getAttribute(MdEnumerationInfo.BASE_CLASS).isModified()      ||
          this.getAttribute(MdEnumerationInfo.DTO_BASE_CLASS).isModified())
      {
        return true;
      }
    }

    return false;
  }

  /**
   * Returns a new MdEnumeration.
   * Some attributes will contain default values, as defined in the attribute
   * metadata. Otherwise, the attributes will be blank.
   *
   * @return MdEnumeration.
   */
  public static MdEnumerationDAO newInstance()
  {
    return (MdEnumerationDAO) BusinessDAO.newInstance(MdEnumerationInfo.CLASS);
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#get(java.lang.String)
   */
  public static MdEnumerationDAOIF get(String id)
  {
    return (MdEnumerationDAOIF) BusinessDAO.get(id);
  }

  /**
   * Returns a list of all generators used to generate source
   * for this MdType.
   *
   * @return
   */
  public List<GeneratorIF> getGenerators()
  {
    List<GeneratorIF> list = new LinkedList<GeneratorIF>();

    //Dont generate reserved types
    if (GenerationUtil.isReservedType(this))
    {
      return list;
    }

    list.add(new MdEnumerationGenerator(this));
    list.add(new EnumerationDTOGenerator(this));

    return list;
  }

}
