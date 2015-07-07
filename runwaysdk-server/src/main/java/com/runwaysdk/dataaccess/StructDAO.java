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
package com.runwaysdk.dataaccess;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.runwaysdk.constants.StructInfo;
import com.runwaysdk.dataaccess.attributes.entity.Attribute;
import com.runwaysdk.dataaccess.cache.ObjectCache;
import com.runwaysdk.dataaccess.database.StructDAOFactory;
import com.runwaysdk.dataaccess.metadata.MdStructDAO;

public class StructDAO extends EntityDAO implements StructDAOIF
{

  /**
   * Generated by Eclipse.
   */
  private static final long serialVersionUID = -9137065185503056822L;

  public StructDAO()
  {
    super();
  }

  /**
   * Constructs a StructDAO from the given {@link HashMap} of Attributes.
   * 
   * <br/>
   * <b>Precondition:</b> attributeMap != null <br/>
   * <b>Precondition:</b> classType != null
   * 
   * @param attributeMap
   * @param classType
   */
  public StructDAO(Map<String, Attribute> attributeMap, String classType)
  {
    super(attributeMap, classType);
  }

  /**
   * Creates an empty StructDAO. For subclasses creates a subtype based on the
   * type, and fills the attributes with the attribute map
   * 
   * @param attributeMap
   *          The attribute mappings of the class
   * @return The new class created
   */
  public StructDAO create(Map<String, Attribute> attributeMap, String classType)
  {
    return new StructDAO(attributeMap, classType);
  }

  /**
   *
   */
  public String apply()
  {
    return super.apply();
  }

  /**
   * Returns a clone of the given StructDAO instance. The cloned instance can be
   * applied to the database.
   * 
   * <br/>
   * <b>Precondition:</b> true <br/>
   * <b>Postcondition:</b> Clone (deep copy) of this StructDAO instance is
   * returned.
   * 
   * @return a clone of the given StructDAO instance.
   */
  public StructDAO clone()
  {
    HashMap<String, Attribute> newAttrList = new HashMap<String, Attribute>();

    // clone all of the attributes
    for (Attribute attrOld : attributeMap.values())
    {
      Attribute attrNew = attrOld.attributeClone();
      newAttrList.put(attrNew.getName(), attrNew);
    }
    StructDAO clonedObject = (StructDAO) StructDAOFactory.factoryMethod(newAttrList, new String(this.componentType));

    clonedObject.setIsNew(this.isNew());
    clonedObject.setAppliedToDB(this.isAppliedToDB());
    return clonedObject;
  }

  /**
   * Returns true if any attribute on this object has been modified, false
   * otherwise.
   * 
   * @return true if any attribute on this object has been modified, false
   *         otherwise.
   */
  public boolean isModified()
  {
    for (AttributeIF attributeIF : this.getAttributeArrayIF())
    {
      if (attributeIF.isModified())
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns true if any attribute on this object has been modified, false
   * otherwise.
   * 
   * @return true if any attribute on this object has been modified, false
   *         otherwise.
   */
  public boolean isNonSystemAttributeModified()
  {
    for (AttributeIF attributeIF : this.getAttributeArrayIF())
    {
      boolean modified = attributeIF.isModified();
      boolean system = attributeIF.getMdAttribute().isSystem();

      if (modified && ! ( system || attributeIF.getName().equals(StructInfo.KEY) ))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns a copy of the given StructDAO instance, with a new id and mastered
   * at the current site. The state of the object is new and has not been
   * applied to the database.
   * 
   * @return a copy of the given StructDAO instance
   */
  public StructDAO copy()
  {
    HashMap<String, Attribute> newAttrMap = new HashMap<String, Attribute>();

    StructDAO copiedObject = StructDAO.newInstance(this.getType());

    // clone all of the attributes
    for (Attribute attrOld : attributeMap.values())
    {
      MdAttributeConcreteDAOIF mdAttribute = ( attrOld ).getMdAttribute();

      if (!mdAttribute.isSystem())
      {
        Attribute attrNew = attrOld.attributeCopy();
        attrNew.setContainingComponent(copiedObject);
        newAttrMap.put(attrNew.getName(), attrNew);
      }
    }

    // This should overwrite the non-system attributes, such as id and site
    // master
    copiedObject.attributeMap.putAll(newAttrMap);

    return copiedObject;
  }

  /**
   * Returns a deep cloned-copy of this StructDAO.
   */
  public StructDAO getStructDAO()
  {
    // Only clone the object if this object comes from a cache.
    if (this.isFromCache())
    {
      return this.clone();
    }
    else
    {
      return this;
    }
  }

  /**
   * Returns a MdStruct object that defines this object's type.
   * 
   * <br/>
   * <b>Precondition:</b> true <br/>
   * <b>Postcondition:</b> true
   * 
   * @return a MdStruct object that defines this object's type.
   */
  public MdStructDAOIF getMdStructDAO()
  {
    return MdStructDAO.getMdStructDAO(this.getType());
  }

  /**
   * Returns a new StructDAO with the attributes defined for the class with the
   * given type. Some attributes will contain default values, as defined in the
   * attribute metadata. Otherwise, the attributes will be blank.
   * 
   * <br/>
   * <b>Precondition:</b> structType parameter represents a valid structType in
   * the database. <br/>
   * <b>Precondition:</b> structType must not be abstract, otherwise a
   * DataAccess exception will be thrown <br/>
   * <b>Postcondition:</b> StructDAO returned is an instance of the given
   * structType. The StructDAO contains all attributes defined for that
   * structType.
   * 
   * @param structType
   *          Valid structType
   * @return StructDAO instance of the given class
   * @throws com.runwaysdk.dataaccess.DataAccessException
   *           if the class is not valid or is abstract
   */
  public static StructDAO newInstance(String structType)
  {
    return StructDAOFactory.newInstance(structType);
  }

  /**
   * Returns a StructDAOIF of the given id in the database.
   * 
   * <br/>
   * <b>Precondition:</b> id != null <br/>
   * <b>Precondition:</b> !id.trim().equals("") <br/>
   * <b>Precondition:</b> given id represents a valid item in the database <br/>
   * <b>Postcondition:</b> return value may not be null <br/>
   * <b>Postcondition:</b> StructDAOIF representing the item in the database of
   * the given id is returned
   * 
   * @param id
   *          element id of an item in the database
   * @return StructDAOIF instance of the given id, of the given type
   */
  public static StructDAOIF get(String id)
  {
    return ObjectCache.getSructObject(id);
  }

  /**
   * Does nothing, as struct objects do not have sequence numbers.
   */
  protected void staleObjectCheck()
  {
  }

  /**
   * Structs do not have a sequence number, hence this method always returns
   * false.
   * 
   * @return false.
   */
  public boolean isStale()
  {
    return false;
  }

  /**
   * Returns non system attributes.
   * 
   * @return non system attributes.
   */
  public List<AttributeIF> getNonSystemAttributes()
  {
    List<AttributeIF> attributeList = new LinkedList<AttributeIF>();

    AttributeIF[] attributeArray = this.getAttributeArrayIF();

    for (AttributeIF attributeIF : attributeArray)
    {
      if (!attributeIF.getMdAttribute().isSystem())
      {
        attributeList.add(attributeIF);
      }
    }

    return attributeList;
  }

  /**
   * Returns a StructDAO of the given type with the given key in the database.
   * This method does the same thing as get(String id), but is faster. If you
   * know the type of the id, use this method. Otherwise use the get(String id)
   * method.
   * 
   * <br/>
   * <b>Precondition:</b> key != null <br/>
   * <b>Precondition:</b> !key.trim().equals("") <br/>
   * <b>Precondition:</b> type != null <br/>
   * <b>Precondition:</b> !type.trim().equals("") <br/>
   * <b>Postcondition:</b> BusinessDAO representing the item in the database of
   * the given key and type is returned
   * 
   * @param type
   *          fully qualified type of an item in the database
   * @param key
   *          key of an item in the database
   * 
   * @return StructDAO instance of the given type and key
   */
  public static StructDAOIF get(String type, String key)
  {
    return (StructDAOIF) EntityDAO.get(type, key);
  }

}
