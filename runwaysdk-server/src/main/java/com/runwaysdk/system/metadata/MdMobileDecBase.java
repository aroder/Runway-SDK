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

@com.runwaysdk.business.ClassSignature(hash = 785076832)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdMobileDec.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdMobileDecBase extends com.runwaysdk.system.metadata.MdMobileNumber
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdMobileDec";
  public static java.lang.String DECPRECISION = "decPrecision";
  public static java.lang.String DECSCALE = "decScale";
  private static final long serialVersionUID = 785076832;
  
  public MdMobileDecBase()
  {
    super();
  }
  
  public Integer getDecPrecision()
  {
    return com.runwaysdk.constants.MdAttributeIntegerUtil.getTypeSafeValue(getValue(DECPRECISION));
  }
  
  public void validateDecPrecision()
  {
    this.validateAttribute(DECPRECISION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDecPrecisionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdMobileDec.CLASS);
    return mdClassIF.definesAttribute(DECPRECISION);
  }
  
  public void setDecPrecision(Integer value)
  {
    if(value == null)
    {
      setValue(DECPRECISION, "");
    }
    else
    {
      setValue(DECPRECISION, java.lang.Integer.toString(value));
    }
  }
  
  public Integer getDecScale()
  {
    return com.runwaysdk.constants.MdAttributeIntegerUtil.getTypeSafeValue(getValue(DECSCALE));
  }
  
  public void validateDecScale()
  {
    this.validateAttribute(DECSCALE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDecScaleMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdMobileDec.CLASS);
    return mdClassIF.definesAttribute(DECSCALE);
  }
  
  public void setDecScale(Integer value)
  {
    if(value == null)
    {
      setValue(DECSCALE, "");
    }
    else
    {
      setValue(DECSCALE, java.lang.Integer.toString(value));
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdMobileDec get(String id)
  {
    return (MdMobileDec) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdMobileDec getByKey(String key)
  {
    return (MdMobileDec) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdMobileDec lock(java.lang.String id)
  {
    MdMobileDec _instance = MdMobileDec.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdMobileDec unlock(java.lang.String id)
  {
    MdMobileDec _instance = MdMobileDec.get(id);
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
