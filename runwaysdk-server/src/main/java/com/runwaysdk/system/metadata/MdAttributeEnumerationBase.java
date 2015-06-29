/**
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
 */
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -631791968)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeEnumeration.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdAttributeEnumerationBase extends com.runwaysdk.system.metadata.MdAttributeRef
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdAttributeEnumeration";
  public static java.lang.String CACHECOLUMNNAME = "cacheColumnName";
  public static java.lang.String DEFAULTVALUE = "defaultValue";
  public static java.lang.String MDENUMERATION = "mdEnumeration";
  public static java.lang.String SELECTMULTIPLE = "selectMultiple";
  private static final long serialVersionUID = -631791968;
  
  public MdAttributeEnumerationBase()
  {
    super();
  }
  
  public String getCacheColumnName()
  {
    return getValue(CACHECOLUMNNAME);
  }
  
  public void validateCacheColumnName()
  {
    this.validateAttribute(CACHECOLUMNNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCacheColumnNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeEnumeration.CLASS);
    return mdClassIF.definesAttribute(CACHECOLUMNNAME);
  }
  
  public String getDefaultValue()
  {
    return getValue(DEFAULTVALUE);
  }
  
  public void validateDefaultValue()
  {
    this.validateAttribute(DEFAULTVALUE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDefaultValueMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeEnumeration.CLASS);
    return mdClassIF.definesAttribute(DEFAULTVALUE);
  }
  
  public void setDefaultValue(String value)
  {
    if(value == null)
    {
      setValue(DEFAULTVALUE, "");
    }
    else
    {
      setValue(DEFAULTVALUE, value);
    }
  }
  
  public com.runwaysdk.system.metadata.MdEnumeration getMdEnumeration()
  {
    if (getValue(MDENUMERATION).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdEnumeration.get(getValue(MDENUMERATION));
    }
  }
  
  public String getMdEnumerationId()
  {
    return getValue(MDENUMERATION);
  }
  
  public void validateMdEnumeration()
  {
    this.validateAttribute(MDENUMERATION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getMdEnumerationMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeEnumeration.CLASS);
    return mdClassIF.definesAttribute(MDENUMERATION);
  }
  
  public void setMdEnumeration(com.runwaysdk.system.metadata.MdEnumeration value)
  {
    if(value == null)
    {
      setValue(MDENUMERATION, "");
    }
    else
    {
      setValue(MDENUMERATION, value.getId());
    }
  }
  
  public Boolean getSelectMultiple()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(SELECTMULTIPLE));
  }
  
  public void validateSelectMultiple()
  {
    this.validateAttribute(SELECTMULTIPLE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSelectMultipleMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeEnumeration.CLASS);
    return mdClassIF.definesAttribute(SELECTMULTIPLE);
  }
  
  public void setSelectMultiple(Boolean value)
  {
    if(value == null)
    {
      setValue(SELECTMULTIPLE, "");
    }
    else
    {
      setValue(SELECTMULTIPLE, java.lang.Boolean.toString(value));
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdAttributeEnumeration get(String id)
  {
    return (MdAttributeEnumeration) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdAttributeEnumeration getByKey(String key)
  {
    return (MdAttributeEnumeration) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdAttributeEnumeration lock(java.lang.String id)
  {
    MdAttributeEnumeration _instance = MdAttributeEnumeration.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdAttributeEnumeration unlock(java.lang.String id)
  {
    MdAttributeEnumeration _instance = MdAttributeEnumeration.get(id);
    _instance.unlock();
    
    return _instance;
  }
  
  public String toString()
  {
    if (this.isNew())
    {
      return "New: "+ this.getClassDisplayLabel();
    }
    else
    {
      return super.toString();
    }
  }
}
