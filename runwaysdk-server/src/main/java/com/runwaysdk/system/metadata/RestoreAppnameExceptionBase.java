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

@com.runwaysdk.business.ClassSignature(hash = 1807231496)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to RestoreAppnameException.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class RestoreAppnameExceptionBase extends com.runwaysdk.business.SmartException
{
  public final static String CLASS = "com.runwaysdk.system.metadata.RestoreAppnameException";
  public static java.lang.String CURRENTAPPNAME = "currentAppname";
  public static java.lang.String ID = "id";
  public static java.lang.String RESTOREAPPNAME = "restoreAppname";
  private static final long serialVersionUID = 1807231496;
  
  public RestoreAppnameExceptionBase()
  {
    super();
  }
  
  public RestoreAppnameExceptionBase(java.lang.String developerMessage)
  {
    super(developerMessage);
  }
  
  public RestoreAppnameExceptionBase(java.lang.String developerMessage, java.lang.Throwable cause)
  {
    super(developerMessage, cause);
  }
  
  public RestoreAppnameExceptionBase(java.lang.Throwable cause)
  {
    super(cause);
  }
  
  public String getCurrentAppname()
  {
    return getValue(CURRENTAPPNAME);
  }
  
  public void validateCurrentAppname()
  {
    this.validateAttribute(CURRENTAPPNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF getCurrentAppnameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.RestoreAppnameException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(CURRENTAPPNAME);
  }
  
  public void setCurrentAppname(String value)
  {
    if(value == null)
    {
      setValue(CURRENTAPPNAME, "");
    }
    else
    {
      setValue(CURRENTAPPNAME, value);
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
  
  public static com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF getIdMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.RestoreAppnameException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(ID);
  }
  
  public String getRestoreAppname()
  {
    return getValue(RESTOREAPPNAME);
  }
  
  public void validateRestoreAppname()
  {
    this.validateAttribute(RESTOREAPPNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF getRestoreAppnameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.RestoreAppnameException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(RESTOREAPPNAME);
  }
  
  public void setRestoreAppname(String value)
  {
    if(value == null)
    {
      setValue(RESTOREAPPNAME, "");
    }
    else
    {
      setValue(RESTOREAPPNAME, value);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public java.lang.String localize(java.util.Locale locale)
  {
    java.lang.String message = super.localize(locale);
    message = replace(message, "{currentAppname}", this.getCurrentAppname());
    message = replace(message, "{id}", this.getId());
    message = replace(message, "{restoreAppname}", this.getRestoreAppname());
    return message;
  }
  
}