/*******************************************************************************
 * Copyright (c) 2013 TerraFrame, Inc. All rights reserved.
 * 
 * This file is part of Runway SDK(tm).
 * 
 * Runway SDK(tm) is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Runway SDK(tm) is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Runway SDK(tm). If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
/**
 * Created on Aug 12, 2005
 * 
 */
package com.runwaysdk.dataaccess.metadata;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.runwaysdk.business.ComponentDTOIF;
import com.runwaysdk.business.generation.BusinessBaseGenerator;
import com.runwaysdk.business.generation.BusinessQueryAPIGenerator;
import com.runwaysdk.business.generation.BusinessStubGenerator;
import com.runwaysdk.business.generation.GenerationUtil;
import com.runwaysdk.business.generation.GeneratorIF;
import com.runwaysdk.business.generation.dto.BusinessDTOBaseGenerator;
import com.runwaysdk.business.generation.dto.BusinessDTOStubGenerator;
import com.runwaysdk.business.generation.dto.BusinessQueryDTOGenerator;
import com.runwaysdk.business.state.MdStateMachineDAOIF;
import com.runwaysdk.constants.EntityCacheMaster;
import com.runwaysdk.constants.EnumerationMasterInfo;
import com.runwaysdk.constants.MdAttributeConcreteInfo;
import com.runwaysdk.constants.MdAttributeReferenceInfo;
import com.runwaysdk.constants.MdBusinessInfo;
import com.runwaysdk.constants.MdClassInfo;
import com.runwaysdk.constants.MdElementInfo;
import com.runwaysdk.constants.MdRelationshipInfo;
import com.runwaysdk.constants.MdStateMachineInfo;
import com.runwaysdk.constants.RelationshipTypes;
import com.runwaysdk.dataaccess.BusinessDAO;
import com.runwaysdk.dataaccess.BusinessDAOIF;
import com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF;
import com.runwaysdk.dataaccess.MdBusinessDAOIF;
import com.runwaysdk.dataaccess.MdEnumerationDAOIF;
import com.runwaysdk.dataaccess.MdRelationshipDAOIF;
import com.runwaysdk.dataaccess.RelationshipDAO;
import com.runwaysdk.dataaccess.RelationshipDAOIF;
import com.runwaysdk.dataaccess.attributes.entity.Attribute;
import com.runwaysdk.dataaccess.attributes.entity.AttributeEnumeration;
import com.runwaysdk.dataaccess.cache.DataNotFoundException;
import com.runwaysdk.dataaccess.cache.ObjectCache;
import com.runwaysdk.dataaccess.database.Database;
import com.runwaysdk.dataaccess.transaction.LockObject;
import com.runwaysdk.query.BusinessDAOQuery;
import com.runwaysdk.query.Condition;
import com.runwaysdk.query.EntityQuery;
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.OR;
import com.runwaysdk.query.QueryFactory;

/**
 * @author nathan
 * 
 */
public class MdBusinessDAO extends MdElementDAO implements MdBusinessDAOIF
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = 2870116355251028814L;

  /**
   * The default constructor, does not set any attributes
   */
  public MdBusinessDAO()
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
    String signature = super.getSignature() + " ParentMethods[";

    boolean firstIteration = true;
    for (MdRelationshipDAOIF mdRelationshipDAOIF : this.getChildMdRelationshipsOrdered())
    {
      if (!firstIteration)
      {
        signature += ", ";
      }
      else
      {
        firstIteration = false;
      }

      String relationshipVisibility = Boolean.toString(mdRelationshipDAOIF.isPublished());
      String parentType = mdRelationshipDAOIF.getParentMdBusiness().definesType();
      String parentTypeVisibility = Boolean.toString(mdRelationshipDAOIF.getParentMdBusiness().isPublished());
      String parentMethod = mdRelationshipDAOIF.getParentMethod();
      String parentGetterVisibility = mdRelationshipDAOIF.getParentVisibility().getJavaModifier();

      signature += "RelationshipVisibility: " + relationshipVisibility + " Type:" + parentType + " TypeVisibility: " + parentTypeVisibility + " Method:" + parentMethod + " ParentGetterVisibility:" + parentGetterVisibility;
    }
    signature += "]";

    signature += " ChildMethods[";
    firstIteration = true;
    for (MdRelationshipDAOIF mdRelationshipDAOIF : this.getParentMdRelationshipsOrdered())
    {
      if (!firstIteration)
      {
        signature += ", ";
      }
      else
      {
        firstIteration = false;
      }

      String relationshipVisibility = Boolean.toString(mdRelationshipDAOIF.isPublished());
      String childType = mdRelationshipDAOIF.getChildMdBusiness().definesType();
      String childTypeVisibility = Boolean.toString(mdRelationshipDAOIF.getChildMdBusiness().isPublished());
      String childMethod = mdRelationshipDAOIF.getChildMethod();
      String childGetterVisibility = mdRelationshipDAOIF.getChildVisibility().getJavaModifier();

      signature += "RelationshipVisibility: " + relationshipVisibility + " Type:" + childType + " TypeVisibility: " + childTypeVisibility + " Method:" + childMethod + " ChildGetterVisibility:" + childGetterVisibility;
    }
    signature += "]";

    signature += " Enumerations[";

    firstIteration = true;
    for (MdEnumerationDAOIF mdEnumerationDAOIF : this.getMdEnumerationDAOs())
    {
      if (!firstIteration)
      {
        signature += ", ";
      }
      else
      {
        firstIteration = false;
      }

      signature += mdEnumerationDAOIF.getSignature();
    }

    signature += "]";

    if (this.hasStateMachine())
    {
      signature += this.definesMdStateMachine().getSignature();
    }

    return signature;
  }

  /**
   * Constructs a <code>MdBusinessDAO</code> from the given hashtable of
   * Attributes.
   * 
   * <br/>
   * <b>Precondition:</b> attributeMap != null <br/>
   * <b>Precondition:</b> type != null <br/>
   * 
   * 
   * @param attributeMap
   * @param type
   * @param useCache
   */
  public MdBusinessDAO(Map<String, Attribute> attributeMap, String type)
  {
    super(attributeMap, type);
  }

  /**
   * @see com.runwaysdk.dataaccess.BusinessDAO#create(java.util.Hashtable,
   *      java.util.String, ComponentDTOIF, Map)
   */
  public MdBusinessDAO create(Map<String, Attribute> attributeMap, String classType)
  {
    return new MdBusinessDAO(attributeMap, MdBusinessInfo.CLASS);
  }

  /**
   * Returns a new <code>MdBusinessDAO</code>. Some attributes will contain
   * default values, as defined in the attribute metadata. Otherwise, the
   * attributes will be blank.
   * 
   * @return instance of <code>MdBusinessDAO</code>.
   */
  public static MdBusinessDAO newInstance()
  {
    return (MdBusinessDAO) BusinessDAO.newInstance(MdBusinessInfo.CLASS);
  }

  /**
   * Returns true if this class defines an enumeration master list (a subclass
   * of the EnumerationMaster), false otherwise.
   * 
   * @return true if this class defines an enumeration master list (a subclass
   *         of the EnumerationMaster), false otherwise.
   */
  public boolean isEnumerationMasterMdBusiness()
  {
    return ( MdBusinessDAO.isSubEntity(this.definesType(), EnumerationMasterInfo.CLASS) );
  }

  /**
   * Returns a list of all MdEnumerations that use this class to define the
   * master list of options.
   * 
   * @return list of all MdEnumerations that use this class to define the master
   *         list of options.
   */
  public List<MdEnumerationDAOIF> getMdEnumerationDAOs()
  {
    List<MdEnumerationDAOIF> mdEnumerationIFList = new LinkedList<MdEnumerationDAOIF>();
    List<RelationshipDAOIF> relationshipIFList = this.getChildren(RelationshipTypes.ENUMERATION_ATTRIBUTE.getType());

    for (RelationshipDAOIF relationshipIF : relationshipIFList)
    {
      mdEnumerationIFList.add((MdEnumerationDAOIF) relationshipIF.getChild());
    }

    Collections.sort(mdEnumerationIFList, new Comparator<MdEnumerationDAOIF>()
    {
      public int compare(MdEnumerationDAOIF o1, MdEnumerationDAOIF o2)
      {
        return o1.definesEnumeration().compareTo(o2.definesEnumeration());
      }
    });

    return mdEnumerationIFList;
  }

  /**
   * Returns the DataAccessIF object that specifies the cache algorithm used by
   * this type.
   * 
   * @return DataAccessIF object that specifies the cache algorithm used by this
   *         type.
   */
  public BusinessDAOIF getCacheAlgorithm()
  {
    return ( (AttributeEnumeration) this.getAttributeIF(MdElementInfo.CACHE_ALGORITHM) ).dereference()[0];
  }

  /**
   * Returns an array of MdBusinessIF that defines immediate sub-entities of
   * this entity.
   * 
   * @return an array of MdBusinessIF that defines immediate sub-entities of
   *         this entity.
   */
  public List<MdBusinessDAOIF> getSubClasses()
  {
    List<RelationshipDAOIF> subClassRelationshipArray = this.getChildren(RelationshipTypes.BUSINESS_INHERITANCE.getType());

    List<MdBusinessDAOIF> mdBusinessList = new LinkedList<MdBusinessDAOIF>();
    for (RelationshipDAOIF relationship : subClassRelationshipArray)
    {
      mdBusinessList.add((MdBusinessDAOIF) relationship.getChild());
    }

    return mdBusinessList;
  }

  /**
   * Returns a list of MdClassIF objects that represent classes that are
   * subclasses of the given class, including this class, including all
   * recursive entities.
   * 
   * @return list of MdClassIF objects that represent classes that are
   *         subclasses of the given class, including this class, including all
   *         recursive entities.
   */
  @SuppressWarnings("unchecked")
  public List<MdBusinessDAOIF> getAllSubClasses()
  {
    return (List<MdBusinessDAOIF>) super.getAllSubClasses();
  }

  /**
   * Returns a list of MdBusinessIF objects that are subclasses of the given
   * entity. Only non abstract entities are returned (i.e. entities that can be
   * instantiated)
   * 
   * @return list of MdBusinessIF objects that are subclasses of the given
   *         entity. Only non abstract entities are returned (i.e. entities that
   *         can be instantiated)
   */
  @SuppressWarnings("unchecked")
  public List<MdBusinessDAOIF> getAllConcreteSubClasses()
  {
    return (List<MdBusinessDAOIF>) super.getAllConcreteSubClasses();
  }

  /**
   * Returns a list of MdBusinessIF object representing every parent of this
   * MdBusinessIF partaking in an inheritance relationship, including this
   * class.
   * 
   * @return a list of parent MdBusinessIF objects, including this class.
   */
  @SuppressWarnings("unchecked")
  public List<MdBusinessDAOIF> getSuperClasses()
  {
    return (List<MdBusinessDAOIF>) super.getSuperClasses();
  }

  /**
   * Returns an MdBusinessIF representing the super entity of this entity, or
   * null if it does not have one.
   * 
   * @return an MdBusinessIF representing the super entity of this entity, or
   *         null if it does not have one.
   */
  public MdBusinessDAOIF getSuperClass()
  {
    if (!this.isRootOfHierarchy())
    {
      String superMdBusinessId = this.getAttributeIF(MdBusinessInfo.SUPER_MD_BUSINESS).getValue();
      return MdBusinessDAO.get(superMdBusinessId);
    }
    else
    {
      return null;
    }
  }

  /**
   * Returns true if this class is the root class of a hierarchy, false
   * otherwise.
   * 
   * @return true if this class is the root class of a hierarchy, false
   *         otherwise.
   */
  public boolean isRootOfHierarchy()
  {
    String superMdEntityId = this.getAttributeIF(MdBusinessInfo.SUPER_MD_BUSINESS).getValue();
    if (superMdEntityId.trim().equals(""))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   *
   *
   */
  protected void validateExisting()
  {
    super.validateExisting();

    // Make sure classes used to define enumeration master lists cannot be
    // extended
    MdBusinessDAOIF superMdBusinessIF = this.getSuperClass();
    if (superMdBusinessIF != null && this.getAttributeIF(MdBusinessInfo.EXTENDABLE).isModified())
    {
      if (superMdBusinessIF.definesType().equals(EnumerationMasterInfo.CLASS))
      {
        this.validateClassForEnumeration(superMdBusinessIF);
      }
    }
  }

  /**
   * Validates this MdBusiness.
   */
  protected void validate()
  {
    super.validate();

    if (this.isNew())
    {
      // make sure an MdBusiness cannot extend MdAttribute.
      List<MdBusinessDAOIF> parentMdBusinessIFList = this.getSuperClasses();
      for (MdBusinessDAOIF parentMdBusinessIF : parentMdBusinessIFList)
      {
        if (parentMdBusinessIF.definesType().equals(MdAttributeConcreteInfo.CLASS))
        {
          String error = "Error in [" + definesType() + "] definition - New types cannot extend [" + MdAttributeConcreteInfo.CLASS + "].";
          throw new InheritanceException(error);
        }
      }
    }

    // if MRU caching is being used, there must be a valid cache size set
    BusinessDAOIF cacheAlgorithm = this.getCacheAlgorithm();
    int cacheCode = Integer.parseInt(cacheAlgorithm.getValue(EntityCacheMaster.CACHE_CODE));
    if (cacheCode == EntityCacheMaster.CACHE_MOST_RECENTLY_USED.getCacheCode() && getCacheSize() <= 0)
    {
      String error = "The MdBusiness that defines type [" + this.definesType() + "] can't define a [" + MdBusinessInfo.CACHE_ALGORITHM + "]" + " that is a Most Recently Used Cache Algorithm and also define a [" + MdBusinessInfo.CACHE_SIZE + "] less than or equal to 0.";
      throw new InvalidMRUCacheSizeException(error, this);
    }

  }

  /**
   * 
   * @return
   */
  protected boolean createInheritanceRelationship()
  {
    MdBusinessDAOIF superMdBusinessIF = this.getSuperClass();
    // Create an inheritance relationship, if one is specified.
    if (superMdBusinessIF != null)
    {
      validateClassForEnumeration(superMdBusinessIF);
    }

    return super.createInheritanceRelationship();
  }

  /**
   * 
   * @param superMdBusinessIF
   */
  private void validateClassForEnumeration(MdBusinessDAOIF superMdBusinessIF)
  {
    // If this is an Enumeration Master and this is extendable, throw an error
    if (superMdBusinessIF.definesType().equals(EnumerationMasterInfo.CLASS) && this.isExtendable())
    {
      String error = "Class [" + this.definesType() + "] cannot be extendable because it is a [" + EnumerationMasterInfo.CLASS + "]";
      throw new InheritanceException(error);
    }

    MdBusinessDAOIF superSuperMdBusinessIF = superMdBusinessIF.getSuperClass();

    if (superSuperMdBusinessIF != null && superSuperMdBusinessIF.definesType().equals(EnumerationMasterInfo.CLASS))
    {
      String error = "Cannot extend Class [" + superMdBusinessIF.definesType() + "] cannot be extendable because it is a [" + EnumerationMasterInfo.CLASS + "]";

      throw new InheritanceException(error);
    }
  }

  /**
   * Updates the key on the inheritance relationship.
   * 
   * <br/>
   * <b>Precondition:</b>the key has been modified
   */
  protected void updateInheritanceRelationshipKey()
  {
    List<RelationshipDAOIF> parentInheritances = this.getParents(RelationshipTypes.BUSINESS_INHERITANCE.getType());

    for (RelationshipDAOIF parentInheritanceDAOIF : parentInheritances)
    {
      RelationshipDAO parentInheritanceDAO = parentInheritanceDAOIF.getRelationshipDAO();
      parentInheritanceDAO.setKey(this.getKey());
      parentInheritanceDAO.save(true);
    }
  }

  /**
   *
   *
   */
  protected void createInheritanceNew()
  {
    // extend the new class with the given super class
    MdBusinessDAO superMdBusiness = this.getSuperClass().getBusinessDAO();
    superMdBusiness.addSubMdBusiness(this);
  }

  /**
   * Creates the relationship such that this class becomes superclass of the
   * given class.
   * 
   * @param mdElementIF
   *          to become a subclass of this class.
   */
  protected void addSubMdBusiness(MdBusinessDAOIF mdBusinessDAOIF)
  {
    RelationshipDAO newChildRelDAO = this.addChild(mdBusinessDAOIF, RelationshipTypes.BUSINESS_INHERITANCE.getType());
    newChildRelDAO.setKey(mdBusinessDAOIF.getKey());
    newChildRelDAO.save(true);
  }

  /**
   * Deletes this class. Consequently all instances of this class are deleted as
   * well. Deletes all parent and child relationships with the every instance of
   * this class. The BusinessDAOs and relationships are removed from the
   * database and from the cache. <b>All subclasses and instances of subclasses
   * are likewise deleted</b>
   * 
   * <br/>
   * <b>Postcondition:</b> Table that defines this className (and tables that
   * define all classes) are dropped from the database. For all sub className
   * tables.
   * 
   * <br/>
   * <b>Postcondition:</b> child relationships are removed
   * (RelationshipFactory.getChildren(this.getId(), "")).length == 0 <br/>
   * <b>Postcondition:</b> parent relationships are removed
   * (RelationshipFactory.getParents(this.getId(), "")).length == 0
   * 
   * @param businessContext
   *          true if this is being called from a business context, false
   *          otherwise. If true then cascading deletes of other Entity objects
   *          will happen at the Business layer instead of the data access
   *          layer.
   * 
   */
  @Override
  public void delete(boolean businessContext)
  {
    // Delete the MdState this owns
    if (this.hasStateMachine())
    {
      definesMdStateMachine().getBusinessDAO().delete(businessContext);
    }

    // We're deleting a type. Find all reference attributes that point to this
    // type,
    // and delete them, too
    List<MdAttributeReferenceDAOIF> mdAttrRefList = this.getMdAttributeReferences();

    for (MdAttributeReferenceDAOIF mdAttributeReferenceIF : mdAttrRefList)
    {
      mdAttributeReferenceIF.getBusinessDAO().delete(businessContext);
    }

    // If this is subclassing enumerationmaster, then drop all MdEnumerations
    // that use this class to define
    // their master list of options
    List<RelationshipDAOIF> mdEnumerations = this.getChildren(RelationshipTypes.ENUMERATION_ATTRIBUTE.getType());
    for (RelationshipDAOIF mdEnumRelationship : mdEnumerations)
    {
      MdEnumerationDAOIF mdEnumerationIF = (MdEnumerationDAOIF) mdEnumRelationship.getChild();
      mdEnumerationIF.getBusinessDAO().delete(businessContext);
    }

    super.delete(businessContext);
  }

  public List<MdAttributeReferenceDAOIF> getMdAttributeReferences()
  {
    List<MdAttributeReferenceDAOIF> mdAttrRefList = new LinkedList<MdAttributeReferenceDAOIF>();

    QueryFactory queryFactory = new QueryFactory();
    BusinessDAOQuery mdAttributeReferenceQuery = queryFactory.businessDAOQuery(MdAttributeReferenceInfo.CLASS);

    mdAttributeReferenceQuery.WHERE(mdAttributeReferenceQuery.aReference(MdAttributeReferenceInfo.REF_MD_ENTITY).EQ(this.getId()));

    OIterator<BusinessDAOIF> mdAttrRefIterator = mdAttributeReferenceQuery.getIterator();

    try
    {
      while (mdAttrRefIterator.hasNext())
      {
        mdAttrRefList.add((MdAttributeReferenceDAOIF) mdAttrRefIterator.next());
      }

      return mdAttrRefList;
    }
    finally
    {
      mdAttrRefIterator.close();
    }
  }

  /**
   * Deletes all BusinessDAO instances of this type.
   * 
   * <br/>
   * <b>Postcondition:</b> All instances of this class are deleted.
   * 
   * @param businessContext
   *          true if this is being called from a business context, false
   *          otherwise. If true then cascading deletes of other Entity objects
   *          will happen at the Business layer instead of the data access
   *          layer.
   * 
   */
  @Override
  public void deleteInstances(boolean businessContext)
  {
    // delete all instances of the struct.
    QueryFactory queryFactory = new QueryFactory();
    BusinessDAOQuery businessDAOquery = queryFactory.businessDAOQuery(this.definesType());
    OIterator<BusinessDAOIF> businessDAOiterator = businessDAOquery.getIterator();
    while (businessDAOiterator.hasNext())
    {
      BusinessDAO resultObject = (BusinessDAO) businessDAOiterator.next();
      resultObject.delete(businessContext);
    }
  }

  /**
   * Deletes the table for this entity. <br/>
   * <b>Precondition</b>: table for this entity must already exist.
   */
  protected void deleteEntityTable()
  {
    Database.dropClassTable(this.getTableName());
  }

  protected void removeDependencies(boolean businessContext)
  {
    // 3. Deletes all relationship types that this type participates in.
    this.deleteMdRelationships(businessContext);
  }

  /**
   * Returns a list of MdRelationships that reference this class for the child
   * objects.
   * 
   * @return list of MdRelationships that reference this class for the child
   *         objects.
   */
  public List<MdRelationshipDAOIF> getChildMdRelationships()
  {
    List<MdRelationshipDAOIF> mdRelationships = new LinkedList<MdRelationshipDAOIF>();

    for (String mdRelationshipDAOid : ObjectCache.getChildMdRelationshipDAOids(this.getId()))
    {
      mdRelationships.add(MdRelationshipDAO.get(mdRelationshipDAOid));
    }

    return mdRelationships;
  }

  /**
   * Returns a list of MdRelationships that reference this class for the child
   * objects, ordered by the name of the parent method.
   * 
   * @return list of MdRelationships that reference this class for the child
   *         objects, ordered by the name of the parentMethod.
   */
  public List<MdRelationshipDAOIF> getChildMdRelationshipsOrdered()
  {
    List<MdRelationshipDAOIF> mdRelationships = this.getChildMdRelationships();

    Collections.sort(mdRelationships, new Comparator<MdRelationshipDAOIF>()
    {
      public int compare(MdRelationshipDAOIF o1, MdRelationshipDAOIF o2)
      {
        return o1.getParentMethod().compareTo(o2.getParentMethod());
      }
    });

    return mdRelationships;
  }

  /**
   * Returns a list of MdRelationships that reference this class for the parent
   * objects.
   * 
   * @return list of MdRelationships that reference this class for the parent
   *         objects.
   */
  public List<MdRelationshipDAOIF> getParentMdRelationships()
  {
    List<MdRelationshipDAOIF> mdRelationships = new LinkedList<MdRelationshipDAOIF>();

    for (String mdRelationshipDAOid : ObjectCache.getParentMdRelationshipDAOids(this.getId()))
    {
      mdRelationships.add(MdRelationshipDAO.get(mdRelationshipDAOid));
    }

    return mdRelationships;
  }

  /**
   * Returns a list of MdRelationships that reference this class for the parent
   * objects, ordered by the child method.
   * 
   * @return list of MdRelationships that reference this class for the parent
   *         objects, ordered by the child method.
   */
  public List<MdRelationshipDAOIF> getParentMdRelationshipsOrdered()
  {
    List<MdRelationshipDAOIF> mdRelationships = this.getParentMdRelationships();

    Collections.sort(mdRelationships, new Comparator<MdRelationshipDAOIF>()
    {
      public int compare(MdRelationshipDAOIF o1, MdRelationshipDAOIF o2)
      {
        return o1.getChildMethod().compareTo(o2.getChildMethod());
      }
    });

    return mdRelationships;
  }

  /**
   * Returns a list of concrete MdRelationships that reference this class or a
   * superclass for the child objects.
   * 
   * @return list of concrete MdRelationships that reference this class or a
   *         superclass for the child objects.
   */
  public List<MdRelationshipDAOIF> getAllChildMdRelationships()
  {
    List<MdRelationshipDAOIF> mdRelationships = new LinkedList<MdRelationshipDAOIF>();

    List<MdBusinessDAOIF> superMdBusinessIFList = this.getSuperClasses();

    for (MdBusinessDAOIF superMdBusinessDAOIF : superMdBusinessIFList)
    {
      for (String mdRelationshipDAOid : ObjectCache.getChildMdRelationshipDAOids(superMdBusinessDAOIF.getId()))
      {
        mdRelationships.add(MdRelationshipDAO.get(mdRelationshipDAOid));
      }
    }

    return mdRelationships;
  }

  /**
   * Returns a list of concrete MdRelationships that reference this class or a
   * superclass for the parent objects.
   * 
   * @return list of concrete MdRelationships that reference this class or a
   *         superclass for the parent objects.
   */
  public List<MdRelationshipDAOIF> getAllParentMdRelationships()
  {
    List<MdRelationshipDAOIF> mdRelationships = new LinkedList<MdRelationshipDAOIF>();

    List<MdBusinessDAOIF> superMdBusinessIFList = this.getSuperClasses();

    for (MdBusinessDAOIF superMdBusinessDAOIF : superMdBusinessIFList)
    {
      for (String mdRelationshipDAOid : ObjectCache.getParentMdRelationshipDAOids(superMdBusinessDAOIF.getId()))
      {
        mdRelationships.add(MdRelationshipDAO.get(mdRelationshipDAOid));
      }
    }

    return mdRelationships;
  }

  /**
   * Returns reference attributes that reference this type either directly or
   * indirectly (via inheritance) reference the given type. Remember to close
   * the iterator!!!
   * 
   * @param mdBusinessDAOIF
   * @return iterator of {@link MdAttributeReferenceDAOIF}
   */
  public static OIterator<BusinessDAOIF> getAllReferenceAttributes(MdBusinessDAOIF mdBusinessDAOIF)
  {
    List<MdBusinessDAOIF> superMdBusinessList = mdBusinessDAOIF.getSuperClasses();

    QueryFactory queryFactory = new QueryFactory();
    BusinessDAOQuery mdAttrRefQ = queryFactory.businessDAOQuery(MdAttributeReferenceInfo.CLASS);

    Condition[] refConditions = new Condition[superMdBusinessList.size()];
    for (int i = 0; i < superMdBusinessList.size(); i++)
    {
      MdBusinessDAOIF superMdBusiness = superMdBusinessList.get(i);
      refConditions[i] = mdAttrRefQ.aReference(MdAttributeReferenceInfo.REF_MD_ENTITY).EQ(superMdBusiness.getId());
    }
    mdAttrRefQ.WHERE(OR.get(refConditions));

    return mdAttrRefQ.getIterator();
  }

  /**
   * Returns reference attributes that reference this type either directly or
   * indirectly (via inheritance) reference the given type. Remember to close
   * the iterator!!!
   * 
   * @param mdBusinessDAOIF
   * @return {@link List} of {@link MdAttributeReferenceDAOIF}
   */
  public List<MdAttributeReferenceDAOIF> getAllReferenceAttributes()
  {
    List<MdAttributeReferenceDAOIF> mdAttrRefList = new LinkedList<MdAttributeReferenceDAOIF>();

    OIterator<BusinessDAOIF> mdAttrRefIerator = getAllReferenceAttributes(this);

    try
    {
      while (mdAttrRefIerator.hasNext())
      {
        mdAttrRefList.add((MdAttributeReferenceDAOIF) mdAttrRefIerator.next());
      }

      return mdAttrRefList;
    }
    finally
    {
      mdAttrRefIerator.close();
    }
  }

  /**
   * Deletes relationship types that this class participates in.
   * 
   * @param businessContext
   *          true if this is being called from a business context, false
   *          otherwise. If true then cascading deletes of other Entity objects
   *          will happen at the Business layer instead of the data access
   *          layer.
   * 
   */
  private void deleteMdRelationships(boolean businessContext)
  {
    // Delete all relationship types where the parent is of this class we are
    // deleting
    QueryFactory queryFactory = new QueryFactory();
    BusinessDAOQuery mdRelationshipQuery = queryFactory.businessDAOQuery(MdRelationshipInfo.CLASS);

    mdRelationshipQuery.WHERE(mdRelationshipQuery.aReference(MdRelationshipInfo.PARENT_MD_BUSINESS).EQ(this.getId()).OR(mdRelationshipQuery.aReference(MdRelationshipInfo.CHILD_MD_BUSINESS).EQ(this.getId())));

    OIterator<BusinessDAOIF> mdRelationshipIterator = mdRelationshipQuery.getIterator();

    while (mdRelationshipIterator.hasNext())
    {
      MdRelationshipDAO mdRelationship = (MdRelationshipDAO) mdRelationshipIterator.next();
      // If a relaitonship inherits from another, it may have already been
      // deleted
      // earlier in this iteration
      if (mdRelationship.isDefined())
      {
        mdRelationship.delete(businessContext);
      }
    }

  }

  public String apply()
  {
    // Set the value of the published attribute to all of the children.
    // This block only needs to happen on MdBusiness. MdStructs are at the
    // root of their own hierarchy. MdRelationships only allow concrete clases
    // at the bottom of the hierarchy.
    if (this.getAttributeIF(MdClassInfo.PUBLISH).isModified() && !this.isImport())
    {
      if (!this.isRootOfHierarchy())
      {
        String errMsg = "Class [" + this.definesType() + "] is not the root of a hierarchy.  " + "Only hierarchy root classes can set the [" + MdClassInfo.PUBLISH + "] field.";
        throw new ClassPublishException(errMsg, this);
      }

      for (MdBusinessDAOIF subMdBusinessIF : this.getAllSubClasses())
      {
        if (subMdBusinessIF.getId() == this.getId())
        {
          continue;
        }

        LockObject.getLockObject().appLock(subMdBusinessIF.getId());

        MdBusinessDAO subMdBusiness = subMdBusinessIF.getBusinessDAO();
        subMdBusiness.setIsPublished(this.isPublished());
        subMdBusiness.save(true);

        LockObject.getLockObject().releaseAppLock(subMdBusinessIF.getId());
      }
    }

    return super.apply();
  }

  /**
   *
   */
  public String save(boolean flag)
  {
    String id = super.save(flag);

    if (this.getAttributeIF(MdClassInfo.PUBLISH).isModified() && !this.isImport())
    {
      for (MdRelationshipDAOIF mdRelationshipIF : this.getChildMdRelationships())
      {
        LockObject.getLockObject().appLock(mdRelationshipIF.getId());

        MdRelationshipDAO mdRelationship = mdRelationshipIF.getBusinessDAO();
        mdRelationship.setIsPublished(this.isPublished());
        mdRelationship.save(true);

        LockObject.getLockObject().releaseAppLock(mdRelationshipIF.getId());
      }

      for (MdRelationshipDAOIF mdRelationshipIF : this.getParentMdRelationships())
      {
        LockObject.getLockObject().appLock(mdRelationshipIF.getId());

        MdRelationshipDAO mdRelationship = mdRelationshipIF.getBusinessDAO();
        mdRelationship.setIsPublished(this.isPublished());
        mdRelationship.save(true);

        LockObject.getLockObject().releaseAppLock(mdRelationshipIF.getId());
      }
    }

    // if cache is MRU and the size has changed, then remove current cache and
    // create a new one.
    if (!this.isNew())
    {
      BusinessDAOIF algorithm = this.getCacheAlgorithm();
      int code = Integer.parseInt(algorithm.getAttributeIF(EntityCacheMaster.CACHE_CODE).getValue());
      if (code == EntityCacheMaster.CACHE_MOST_RECENTLY_USED.getCacheCode() && this.getAttributeIF(MdBusinessInfo.CACHE_SIZE).isModified())
      {
        ObjectCache.updateCacheStrategy(this);
      }
    }
    return id;
  }

  /**
   * Creates at able for this entity. <br/>
   * <b>Precondition</b>: table for this entity does not already exist.
   */
  protected void createEntityTable()
  {
    String tableName = this.getTableName();
    Database.createClassTable(tableName);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.dataaccess.MdBusinessIF#getMdState()
   */
  public MdStateMachineDAOIF definesMdStateMachine()
  {
    List<RelationshipDAOIF> list = this.getChildren(MdStateMachineInfo.DEFINES_STATE_MACHINE_RELATIONSHIP);

    if (list.size() != 0)
    {
      return (MdStateMachineDAOIF) list.get(0).getChild();
    }

    String msg = "There is no state machine defined for type [" + definesType() + "]";
    throw new DataNotFoundException(msg, this.getMdBusinessDAO());
  }

  public boolean hasStateMachine()
  {
    List<RelationshipDAOIF> list = this.getChildren(MdStateMachineInfo.DEFINES_STATE_MACHINE_RELATIONSHIP);

    if (list.size() > 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   * Returns a EntityQuery object for instances of the given type.
   * 
   * @return EntityQuery object for instances of the given type.
   */
  public EntityQuery getEntityQuery()
  {
    QueryFactory queryFactory = new QueryFactory();
    return queryFactory.businessDAOQuery(this.definesType());
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.dataaccess.BusinessDAO#get(java.lang.String)
   */
  public static MdBusinessDAOIF get(String id)
  {
    return (MdBusinessDAOIF) BusinessDAO.get(id);
  }

  /**
   * @see com.runwaysdk.dataaccess.BusinessDAO#getBusinessDAO()
   */
  public MdBusinessDAO getBusinessDAO()
  {
    return (MdBusinessDAO) super.getBusinessDAO();
  }

  /**
   * Returns a MdBusinessIF instance of the metadata for the given class.
   * 
   * <br/>
   * <b>Precondition:</b> classType != null <br/>
   * <b>Precondition:</b> !classType.trim().equals("") <br/>
   * <b>Precondition:</b> classType is a valid class defined in the database <br/>
   * <b>Postcondition:</b> return value is not null <br/>
   * <b>Postcondition:</b> Returns a MdBusinessIF instance of the metadata for
   * the given class (MdBusinessIF().definesType().equals(classType)
   * 
   * @param classType
   *          class type
   * @return MdBusinessIF instance of the metadata for the given class type.
   */
  public static MdBusinessDAOIF getMdBusinessDAO(String classType)
  {
    return ObjectCache.getMdBusinessDAO(classType);
  }

  /**
   * Returns a list of all generators used to generate source for this MdType.
   * 
   * @return
   */
  public List<GeneratorIF> getGenerators()
  {
    List<GeneratorIF> list = new LinkedList<GeneratorIF>();

    // Don't generate reserved types
    if (GenerationUtil.isReservedType(this))
    {
      return list;
    }

    list.add(new BusinessBaseGenerator(this));
    list.add(new BusinessStubGenerator(this));
    list.add(new BusinessDTOBaseGenerator(this));
    list.add(new BusinessDTOStubGenerator(this));

    if (!GenerationUtil.isHardcodedType(this))
    {
      list.add(new BusinessQueryAPIGenerator(this));
      list.add(new BusinessQueryDTOGenerator(this));
    }

    return list;
  }

  public String toString()
  {
    return '[' + this.definesType() + " definition]";
  }
}
