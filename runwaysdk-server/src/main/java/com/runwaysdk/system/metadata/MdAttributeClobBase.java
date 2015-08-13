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
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -1145462201)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeClob.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdAttributeClobBase extends com.runwaysdk.system.metadata.MdAttributeChar
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdAttributeClob";
  public static java.lang.String DEFAULTVALUE = "defaultValue";
  private static final long serialVersionUID = -1145462201;
  
  public MdAttributeClobBase()
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeClob.CLASS);
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
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdAttributeClob get(String id)
  {
    return (MdAttributeClob) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdAttributeClob getByKey(String key)
  {
    return (MdAttributeClob) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdAttributeClob lock(java.lang.String id)
  {
    MdAttributeClob _instance = MdAttributeClob.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdAttributeClob unlock(java.lang.String id)
  {
    MdAttributeClob _instance = MdAttributeClob.get(id);
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
