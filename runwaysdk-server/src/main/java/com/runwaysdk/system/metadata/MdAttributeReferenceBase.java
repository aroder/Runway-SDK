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
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 1104886814)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeReference.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdAttributeReferenceBase extends com.runwaysdk.system.metadata.MdAttributeRef
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdAttributeReference";
  public static java.lang.String DEFAULTVALUE = "defaultValue";
  public static java.lang.String MDBUSINESS = "mdBusiness";
  private static final long serialVersionUID = 1104886814;
  
  public MdAttributeReferenceBase()
  {
    super();
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeReference.CLASS);
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
  
  public com.runwaysdk.system.metadata.MdBusiness getMdBusiness()
  {
    if (getValue(MDBUSINESS).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdBusiness.get(getValue(MDBUSINESS));
    }
  }
  
  public String getMdBusinessId()
  {
    return getValue(MDBUSINESS);
  }
  
  public void validateMdBusiness()
  {
    this.validateAttribute(MDBUSINESS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getMdBusinessMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeReference.CLASS);
    return mdClassIF.definesAttribute(MDBUSINESS);
  }
  
  public void setMdBusiness(com.runwaysdk.system.metadata.MdBusiness value)
  {
    if(value == null)
    {
      setValue(MDBUSINESS, "");
    }
    else
    {
      setValue(MDBUSINESS, value.getId());
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdAttributeReference get(String id)
  {
    return (MdAttributeReference) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdAttributeReference getByKey(String key)
  {
    return (MdAttributeReference) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdAttributeReference lock(java.lang.String id)
  {
    MdAttributeReference _instance = MdAttributeReference.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdAttributeReference unlock(java.lang.String id)
  {
    MdAttributeReference _instance = MdAttributeReference.get(id);
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