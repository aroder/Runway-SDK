/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
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
 */
package com.runwaysdk.dataaccess.metadata;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.runwaysdk.business.generation.GenerationUtil;
import com.runwaysdk.business.generation.GeneratorIF;
import com.runwaysdk.business.generation.StructBaseGenerator;
import com.runwaysdk.business.generation.StructQueryAPIGenerator;
import com.runwaysdk.business.generation.StructStubGenerator;
import com.runwaysdk.business.generation.dto.StructDTOBaseGenerator;
import com.runwaysdk.business.generation.dto.StructDTOStubGenerator;
import com.runwaysdk.business.generation.dto.StructQueryDTOGenerator;
import com.runwaysdk.constants.EntityCacheMaster;
import com.runwaysdk.constants.MdAttributeStructInfo;
import com.runwaysdk.constants.MdBusinessInfo;
import com.runwaysdk.constants.MdElementInfo;
import com.runwaysdk.constants.MdStructInfo;
import com.runwaysdk.dataaccess.BusinessDAO;
import com.runwaysdk.dataaccess.BusinessDAOIF;
import com.runwaysdk.dataaccess.MdAttributeStructDAOIF;
import com.runwaysdk.dataaccess.MdEntityDAOIF;
import com.runwaysdk.dataaccess.MdStructDAOIF;
import com.runwaysdk.dataaccess.StructDAO;
import com.runwaysdk.dataaccess.StructDAOIF;
import com.runwaysdk.dataaccess.attributes.entity.Attribute;
import com.runwaysdk.dataaccess.attributes.entity.AttributeEnumeration;
import com.runwaysdk.dataaccess.cache.ObjectCache;
import com.runwaysdk.dataaccess.database.Database;
import com.runwaysdk.query.BusinessDAOQuery;
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.query.StructDAOQuery;


public class MdStructDAO extends MdEntityDAO implements MdStructDAOIF
{
  /**
   * Generated by Eclipse.
   */
  private static final long serialVersionUID = -1636396721349786638L;

  /**
   *
   *
   */
  public MdStructDAO()
  {
    super();
  }

  /**
   *
   * @param attributeMap
   * @param classType
   */
  public MdStructDAO(Map<String, Attribute> attributeMap, String classType)
  {
    super(attributeMap, classType);
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#create(java.util.Hashtable)
   */
  public MdStructDAO create(Map<String, Attribute> attributeMap, String classType)
  {
    return new MdStructDAO(attributeMap, MdStructInfo.CLASS);
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
   * Returns a EntityQuery object for instances of the given type.
   * @return EntityQuery object for instances of the given type.
   */
  public StructDAOQuery getEntityQuery()
  {
    QueryFactory queryFactory = new QueryFactory();
    return queryFactory.structDAOQuery(this.definesType());
  }

  /**
   * Returns the reference to this object, as an MdStruct is always the root
   * of its own hierarchy.
   *
   * @return reference to this object, as an MdStruct is always the root
   *         of its own hierarchy.
   */
  public MdStructDAOIF getRootMdClassDAO()
  {
    return this;
  }

  /**
   * Returns an empty list of MdStructIF, as an MdStruct cannot have any sub entity.
   *
   * @return empty list of MdStructIF, as an MdStruct cannot have any sub entity.
   */
  public List<MdStructDAOIF> getSubClasses()
  {
    return new LinkedList<MdStructDAOIF>();
  }

  /**
   * Returns a list of MdStructIF with this class as the only reference, as an MdStruct cannot have a super entity.
   *
   * @return list of MdStructIF with this class as the only reference, as an MdStruct cannot have a super entity.
   */
  public List<MdStructDAOIF> getSuperClasses()
  {
    List<MdStructDAOIF> list =  new LinkedList<MdStructDAOIF>();
    list.add(this);
    return list;
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
    return true;
  }

  /**
   * Returns true if the type is abstract, false otherwise.
   *
   * @return true if the type is abstract, false otherwise.
   */
  public boolean isAbstract()
  {
    return false;
  }

  /**
   * Returns true if the type is extendable, false otherwise.
   *
   * @return true if the type is extendable, false otherwise.
   */
  public boolean isExtendable()
  {
    return false;
  }

  /**
   * Returns a new MdStruct.
   * Some attributes will contain default values, as defined in the attribute
   * metadata. Otherwise, the attributes will be blank.
   *
   * @return MdStruct
   */
  public static MdStructDAO newInstance()
  {
    return (MdStructDAO) BusinessDAO.newInstance(MdStructInfo.CLASS);
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#get(java.lang.String, java.lang.String)
   */
  public static MdStructDAOIF get(String id)
  {
    return (MdStructDAOIF) BusinessDAO.get(id);
  }


  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#getBusinessDAO()
   */
  public MdStructDAO getBusinessDAO()
  {
    return (MdStructDAO) super.getBusinessDAO();
  }

  /**
   *Returns null, as a struct does not inherit from anything.
   *
   * @return null
   */
  public MdEntityDAOIF getSuperClass()
  {
    return null;
  }

  /**
   * Returns an empty list of MdStructIF objects, as MdStructs cannot be extended.
   * entity. Only non abstract entities are returned (i.e. entities that can be
   * instantiated)
   *
   * @return an empty list of MdStructIF objects, as MdStructs cannot be extended.
   *         entity. Only non abstract entities are returned (i.e. entities that can be
   *         instantiated)
   */
  public List<? extends MdStructDAOIF> getAllConcreteSubClasses()
  {
    return new LinkedList<MdStructDAOIF>();
  }

  /**
   *Returns a list of MdClassIF objects that represent classes
   * that are subclasses of the given class, including this class,
   * including all recursive entities.
   *
   * @return list of MdClassIF objects that represent classes
   * that are subclasses of the given class, including this class,
   * including all recursive entities.
   */
  public List<MdStructDAOIF> getAllSubClasses()
  {
    List<MdStructDAOIF> subClassList = new LinkedList<MdStructDAOIF>();
    subClassList.add(this);
    return subClassList;
  }

  /**
   *
   */
  public String save(boolean flag)
  {
    String id =  super.save(flag);
    // if cache is MRU and the size has changed, then remove current cache and create a new one.
    if(!this.isNew())
    {
      BusinessDAOIF algorithm = this.getCacheAlgorithm();
      int code = Integer.parseInt(algorithm.getAttributeIF(EntityCacheMaster.CACHE_CODE).getValue());
      if(code == EntityCacheMaster.CACHE_MOST_RECENTLY_USED.getCacheCode() && this.getAttributeIF(MdBusinessInfo.CACHE_SIZE).isModified())
      {
        ObjectCache.updateCacheStrategy(this);
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
    // Drop all struct attributes on other classes that use this class to store
    // those struct attributes.
    this.dropStructAttributes(businessContext);

    super.delete(businessContext);
  }

  /**
   * Creates at able for this entity.
   * <br/><b>Precondition</b>: table for this entity does not already exist.
   */
  protected void createEntityTable()
  {
    String tableName = this.getTableName();
    Database.createClassTable(tableName);
  }

  /**
   * Deletes all EntityDAO instances of this type.
   *
   * <br/><b>Postcondition:</b> All instances of this class are deleted.
   *
   * @param businessContext true if this is being called from a business context, false
   * otherwise. If true then cascading deletes of other Entity objects will happen at the Business
   * layer instead of the data access layer.
   */
  public void deleteInstances(boolean businessContext)
  {
    // delete all instances of the struct.
    QueryFactory queryFactory = new QueryFactory();
    StructDAOQuery structDAOQuery = queryFactory.structDAOQuery(this.definesType());
    OIterator<StructDAOIF> structDAOQueryIterator = structDAOQuery.getIterator();
    while (structDAOQueryIterator.hasNext())
    {
      StructDAO resultObject = (StructDAO)structDAOQueryIterator.next();
      resultObject.delete(businessContext);
    }
  }

  /**
   * Deletes the  table for this entity.
   * <br/><b>Precondition</b>: table for this entity must already exist.
   */
  protected void deleteEntityTable()
  {
    Database.dropClassTable(this.getTableName());
  }

  /**
   * Drop all struct attributes on other classes that use this class to store
   * those struct attributes.
   *
   * @param businessContext true if this is being called from a business context, false
   * otherwise. If true then cascading deletes of other Entity objects will happen at the Business
   * layer instead of the data access layer.
   *
   */
  private void dropStructAttributes(boolean businessContext)
  {
    QueryFactory qFactory = new QueryFactory();

    BusinessDAOQuery mdAttrStrQ = qFactory.businessDAOQuery(MdAttributeStructInfo.CLASS);
    mdAttrStrQ.WHERE(
      mdAttrStrQ.aReference(MdAttributeStructInfo.MD_STRUCT).EQ(this.getId()));
    OIterator<BusinessDAOIF> mdAttrStrIterator = mdAttrStrQ.getIterator();
    while (mdAttrStrIterator.hasNext())
    {
      MdAttributeStructDAO mdAttributeStruct = (MdAttributeStructDAO) mdAttrStrIterator.next();
      mdAttributeStruct.delete(businessContext);
    }
  }

  /**
   * Returns all MdAttributeStruct that reference this class.
   * @return all MdAttributeStruct that reference this class.
   */
  public List<? extends MdAttributeStructDAOIF> getMdAttributeStruct()
  {
    List<MdAttributeStructDAOIF> mdAttributeStructIFList = new LinkedList<MdAttributeStructDAOIF>();

    QueryFactory queryFactory = new QueryFactory();
    BusinessDAOQuery q1 = queryFactory.businessDAOQuery(MdAttributeStructInfo.CLASS);
    q1.WHERE(q1.aReference(MdAttributeStructInfo.MD_STRUCT).EQ(this.getId()));

    OIterator<BusinessDAOIF> iterator = q1.getIterator();

    for (BusinessDAOIF businessDAOIF : iterator)
    {
      mdAttributeStructIFList.add((MdAttributeStructDAOIF)businessDAOIF);
    }

    return mdAttributeStructIFList;
  }


  /**
   *Returns a MdStructIF instance of the metadata for the given class.
   *
   * <br/><b>Precondition:</b>  structType != null
   * <br/><b>Precondition:</b>  !structType.trim().equals("")
   * <br/><b>Precondition:</b>  structType is a valid class defined in the database
   * <br/><b>Postcondition:</b> return value is not null
   * <br/><b>Postcondition:</b> Returns a MdStructIF instance of the metadata for the
   *                            given class
   *                            (MdStructIF().definesType().equals(structType)
   *
   * @param  structType class type
   * @return MdStructIF instance of the metadata for the given class type.
   */
  public static MdStructDAOIF getMdStructDAO(String structType)
  {
    return ObjectCache.getMdStructDAO(structType);
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

    //Don't generate reserved types
    if (GenerationUtil.isReservedType(this))
    {
      return list;
    }

    list.add(new StructBaseGenerator(this));
    list.add(new StructStubGenerator(this));
    list.add(new StructDTOBaseGenerator(this));
    list.add(new StructDTOStubGenerator(this));

    if (!GenerationUtil.isHardcodedType(this))
    {
      list.add(new StructQueryAPIGenerator(this));
      list.add(new StructQueryDTOGenerator(this));
    }

    return list;
  }

}
