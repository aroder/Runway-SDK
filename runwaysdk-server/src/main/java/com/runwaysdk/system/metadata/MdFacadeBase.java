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

@com.runwaysdk.business.ClassSignature(hash = -1463523697)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdFacade.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdFacadeBase extends com.runwaysdk.system.metadata.MdType
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdFacade";
  public static java.lang.String CLIENTCLASSES = "clientClasses";
  public static java.lang.String COMMONCLASSES = "commonClasses";
  public static java.lang.String SERVERCLASSES = "serverClasses";
  public static java.lang.String STUBCLASS = "stubClass";
  public static java.lang.String STUBSOURCE = "stubSource";
  private static final long serialVersionUID = -1463523697;
  
  public MdFacadeBase()
  {
    super();
  }
  
  public byte[] getClientClasses()
  {
    return getBlob(CLIENTCLASSES);
  }
  
  public void validateClientClasses()
  {
    this.validateAttribute(CLIENTCLASSES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getClientClassesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdFacade.CLASS);
    return mdClassIF.definesAttribute(CLIENTCLASSES);
  }
  
  public byte[] getCommonClasses()
  {
    return getBlob(COMMONCLASSES);
  }
  
  public void validateCommonClasses()
  {
    this.validateAttribute(COMMONCLASSES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCommonClassesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdFacade.CLASS);
    return mdClassIF.definesAttribute(COMMONCLASSES);
  }
  
  public byte[] getServerClasses()
  {
    return getBlob(SERVERCLASSES);
  }
  
  public void validateServerClasses()
  {
    this.validateAttribute(SERVERCLASSES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getServerClassesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdFacade.CLASS);
    return mdClassIF.definesAttribute(SERVERCLASSES);
  }
  
  public byte[] getStubClass()
  {
    return getBlob(STUBCLASS);
  }
  
  public void validateStubClass()
  {
    this.validateAttribute(STUBCLASS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getStubClassMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdFacade.CLASS);
    return mdClassIF.definesAttribute(STUBCLASS);
  }
  
  public String getStubSource()
  {
    return getValue(STUBSOURCE);
  }
  
  public void validateStubSource()
  {
    this.validateAttribute(STUBSOURCE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getStubSourceMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdFacade.CLASS);
    return mdClassIF.definesAttribute(STUBSOURCE);
  }
  
  public void setStubSource(String value)
  {
    if(value == null)
    {
      setValue(STUBSOURCE, "");
    }
    else
    {
      setValue(STUBSOURCE, value);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdFacade get(String id)
  {
    return (MdFacade) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdFacade getByKey(String key)
  {
    return (MdFacade) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdFacade lock(java.lang.String id)
  {
    MdFacade _instance = MdFacade.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdFacade unlock(java.lang.String id)
  {
    MdFacade _instance = MdFacade.get(id);
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
