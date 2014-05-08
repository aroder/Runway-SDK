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

@com.runwaysdk.business.ClassSignature(hash = -1146751901)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdMobileAttribute.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdMobileAttributeBase extends com.runwaysdk.system.metadata.MdMobileField
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdMobileAttribute";
  public static java.lang.String DEFININGMDATTRIBUTE = "definingMdAttribute";
  private static final long serialVersionUID = -1146751901;
  
  public MdMobileAttributeBase()
  {
    super();
  }
  
  public com.runwaysdk.system.metadata.MdAttribute getDefiningMdAttribute()
  {
    if (getValue(DEFININGMDATTRIBUTE).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdAttribute.get(getValue(DEFININGMDATTRIBUTE));
    }
  }
  
  public String getDefiningMdAttributeId()
  {
    return getValue(DEFININGMDATTRIBUTE);
  }
  
  public void validateDefiningMdAttribute()
  {
    this.validateAttribute(DEFININGMDATTRIBUTE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDefiningMdAttributeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdMobileAttribute.CLASS);
    return mdClassIF.definesAttribute(DEFININGMDATTRIBUTE);
  }
  
  public void setDefiningMdAttribute(com.runwaysdk.system.metadata.MdAttribute value)
  {
    if(value == null)
    {
      setValue(DEFININGMDATTRIBUTE, "");
    }
    else
    {
      setValue(DEFININGMDATTRIBUTE, value.getId());
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdMobileAttribute get(String id)
  {
    return (MdMobileAttribute) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdMobileAttribute getByKey(String key)
  {
    return (MdMobileAttribute) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdMobileAttribute lock(java.lang.String id)
  {
    MdMobileAttribute _instance = MdMobileAttribute.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdMobileAttribute unlock(java.lang.String id)
  {
    MdMobileAttribute _instance = MdMobileAttribute.get(id);
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
