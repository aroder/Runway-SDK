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
package com.runwaysdk.system;

@com.runwaysdk.business.ClassSignature(hash = 1296475423)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to PhoneNumber.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class PhoneNumberBase extends com.runwaysdk.business.Struct
{
  public final static String CLASS = "com.runwaysdk.system.PhoneNumber";
  public static java.lang.String AREACODE = "areaCode";
  public static java.lang.String EXTENSION = "extension";
  public static java.lang.String ID = "id";
  public static java.lang.String KEYNAME = "keyName";
  public static java.lang.String PREFIX = "prefix";
  public static java.lang.String SITEMASTER = "siteMaster";
  public static java.lang.String SUFFIX = "suffix";
  private static final long serialVersionUID = 1296475423;
  
  public PhoneNumberBase()
  {
    super();
  }
  
  public PhoneNumberBase(com.runwaysdk.business.MutableWithStructs component, String structName)
  {
    super(component, structName);
  }
  
  public static PhoneNumber get(String id)
  {
    return (PhoneNumber) com.runwaysdk.business.Struct.get(id);
  }
  
  public static PhoneNumber getByKey(String key)
  {
    return (PhoneNumber) com.runwaysdk.business.Struct.get(CLASS, key);
  }
  
  public String getAreaCode()
  {
    return getValue(AREACODE);
  }
  
  public void validateAreaCode()
  {
    this.validateAttribute(AREACODE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getAreaCodeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.PhoneNumber.CLASS);
    return mdClassIF.definesAttribute(AREACODE);
  }
  
  public void setAreaCode(String value)
  {
    if(value == null)
    {
      setValue(AREACODE, "");
    }
    else
    {
      setValue(AREACODE, value);
    }
  }
  
  public String getExtension()
  {
    return getValue(EXTENSION);
  }
  
  public void validateExtension()
  {
    this.validateAttribute(EXTENSION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getExtensionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.PhoneNumber.CLASS);
    return mdClassIF.definesAttribute(EXTENSION);
  }
  
  public void setExtension(String value)
  {
    if(value == null)
    {
      setValue(EXTENSION, "");
    }
    else
    {
      setValue(EXTENSION, value);
    }
  }
  
  public String getId()
  {
    return getValue(ID);
  }
  
  public void validateId()
  {
    this.validateAttribute(ID);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getIdMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.PhoneNumber.CLASS);
    return mdClassIF.definesAttribute(ID);
  }
  
  public String getKeyName()
  {
    return getValue(KEYNAME);
  }
  
  public void validateKeyName()
  {
    this.validateAttribute(KEYNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getKeyNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.PhoneNumber.CLASS);
    return mdClassIF.definesAttribute(KEYNAME);
  }
  
  public void setKeyName(String value)
  {
    if(value == null)
    {
      setValue(KEYNAME, "");
    }
    else
    {
      setValue(KEYNAME, value);
    }
  }
  
  public String getPrefix()
  {
    return getValue(PREFIX);
  }
  
  public void validatePrefix()
  {
    this.validateAttribute(PREFIX);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getPrefixMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.PhoneNumber.CLASS);
    return mdClassIF.definesAttribute(PREFIX);
  }
  
  public void setPrefix(String value)
  {
    if(value == null)
    {
      setValue(PREFIX, "");
    }
    else
    {
      setValue(PREFIX, value);
    }
  }
  
  public String getSiteMaster()
  {
    return getValue(SITEMASTER);
  }
  
  public void validateSiteMaster()
  {
    this.validateAttribute(SITEMASTER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSiteMasterMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.PhoneNumber.CLASS);
    return mdClassIF.definesAttribute(SITEMASTER);
  }
  
  public String getSuffix()
  {
    return getValue(SUFFIX);
  }
  
  public void validateSuffix()
  {
    this.validateAttribute(SUFFIX);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSuffixMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.PhoneNumber.CLASS);
    return mdClassIF.definesAttribute(SUFFIX);
  }
  
  public void setSuffix(String value)
  {
    if(value == null)
    {
      setValue(SUFFIX, "");
    }
    else
    {
      setValue(SUFFIX, value);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
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
