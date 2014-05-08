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

@com.runwaysdk.business.ClassSignature(hash = 1391279658)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeLong.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdAttributeLongBase extends com.runwaysdk.system.metadata.MdAttributeInt
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdAttributeLong";
  public static java.lang.String DEFAULTVALUE = "defaultValue";
  public static java.lang.String ENDRANGE = "endRange";
  public static java.lang.String STARTRANGE = "startRange";
  private static final long serialVersionUID = 1391279658;
  
  public MdAttributeLongBase()
  {
    super();
  }
  
  public Long getDefaultValue()
  {
    return com.runwaysdk.constants.MdAttributeLongUtil.getTypeSafeValue(getValue(DEFAULTVALUE));
  }
  
  public void validateDefaultValue()
  {
    this.validateAttribute(DEFAULTVALUE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDefaultValueMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeLong.CLASS);
    return mdClassIF.definesAttribute(DEFAULTVALUE);
  }
  
  public void setDefaultValue(Long value)
  {
    if(value == null)
    {
      setValue(DEFAULTVALUE, "");
    }
    else
    {
      setValue(DEFAULTVALUE, java.lang.Long.toString(value));
    }
  }
  
  public Long getEndRange()
  {
    return com.runwaysdk.constants.MdAttributeLongUtil.getTypeSafeValue(getValue(ENDRANGE));
  }
  
  public void validateEndRange()
  {
    this.validateAttribute(ENDRANGE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getEndRangeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeLong.CLASS);
    return mdClassIF.definesAttribute(ENDRANGE);
  }
  
  public void setEndRange(Long value)
  {
    if(value == null)
    {
      setValue(ENDRANGE, "");
    }
    else
    {
      setValue(ENDRANGE, java.lang.Long.toString(value));
    }
  }
  
  public Long getStartRange()
  {
    return com.runwaysdk.constants.MdAttributeLongUtil.getTypeSafeValue(getValue(STARTRANGE));
  }
  
  public void validateStartRange()
  {
    this.validateAttribute(STARTRANGE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getStartRangeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeLong.CLASS);
    return mdClassIF.definesAttribute(STARTRANGE);
  }
  
  public void setStartRange(Long value)
  {
    if(value == null)
    {
      setValue(STARTRANGE, "");
    }
    else
    {
      setValue(STARTRANGE, java.lang.Long.toString(value));
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdAttributeLong get(String id)
  {
    return (MdAttributeLong) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdAttributeLong getByKey(String key)
  {
    return (MdAttributeLong) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdAttributeLong lock(java.lang.String id)
  {
    MdAttributeLong _instance = MdAttributeLong.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdAttributeLong unlock(java.lang.String id)
  {
    MdAttributeLong _instance = MdAttributeLong.get(id);
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
