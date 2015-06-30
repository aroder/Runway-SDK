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

@com.runwaysdk.business.ClassSignature(hash = 372783775)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdDomain.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdDomainBase extends com.runwaysdk.system.metadata.Metadata
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdDomain";
  public static java.lang.String DISPLAYLABEL = "displayLabel";
  private com.runwaysdk.business.Struct displayLabel = null;
  
  public static java.lang.String DOMAINNAME = "domainName";
  private static final long serialVersionUID = 372783775;
  
  public MdDomainBase()
  {
    super();
    displayLabel = super.getStruct("displayLabel");
  }
  
  public com.runwaysdk.system.metadata.MetadataDisplayLabel getDisplayLabel()
  {
    return (com.runwaysdk.system.metadata.MetadataDisplayLabel) displayLabel;
  }
  
  public void validateDisplayLabel()
  {
    this.validateAttribute(DISPLAYLABEL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDisplayLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdDomain.CLASS);
    return mdClassIF.definesAttribute(DISPLAYLABEL);
  }
  
  public String getDomainName()
  {
    return getValue(DOMAINNAME);
  }
  
  public void validateDomainName()
  {
    this.validateAttribute(DOMAINNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDomainNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdDomain.CLASS);
    return mdClassIF.definesAttribute(DOMAINNAME);
  }
  
  public void setDomainName(String value)
  {
    if(value == null)
    {
      setValue(DOMAINNAME, "");
    }
    else
    {
      setValue(DOMAINNAME, value);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdDomain get(String id)
  {
    return (MdDomain) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdDomain getByKey(String key)
  {
    return (MdDomain) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdDomain lock(java.lang.String id)
  {
    MdDomain _instance = MdDomain.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdDomain unlock(java.lang.String id)
  {
    MdDomain _instance = MdDomain.get(id);
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
      return this.getClassDisplayLabel();
    }
  }
}
