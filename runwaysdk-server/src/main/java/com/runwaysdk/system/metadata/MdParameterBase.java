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

@com.runwaysdk.business.ClassSignature(hash = 1094546547)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdParameter.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdParameterBase extends com.runwaysdk.system.metadata.Metadata
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdParameter";
  public static java.lang.String DISPLAYLABEL = "displayLabel";
  private com.runwaysdk.business.Struct displayLabel = null;
  
  public static java.lang.String METADATA = "metadata";
  public static java.lang.String PARAMETERNAME = "parameterName";
  public static java.lang.String PARAMETERORDER = "parameterOrder";
  public static java.lang.String PARAMETERTYPE = "parameterType";
  private static final long serialVersionUID = 1094546547;
  
  public MdParameterBase()
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdParameter.CLASS);
    return mdClassIF.definesAttribute(DISPLAYLABEL);
  }
  
  public com.runwaysdk.system.metadata.Metadata getMetadata()
  {
    if (getValue(METADATA).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.Metadata.get(getValue(METADATA));
    }
  }
  
  public String getMetadataId()
  {
    return getValue(METADATA);
  }
  
  public void validateMetadata()
  {
    this.validateAttribute(METADATA);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getMetadataMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdParameter.CLASS);
    return mdClassIF.definesAttribute(METADATA);
  }
  
  public void setMetadata(com.runwaysdk.system.metadata.Metadata value)
  {
    if(value == null)
    {
      setValue(METADATA, "");
    }
    else
    {
      setValue(METADATA, value.getId());
    }
  }
  
  public String getParameterName()
  {
    return getValue(PARAMETERNAME);
  }
  
  public void validateParameterName()
  {
    this.validateAttribute(PARAMETERNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getParameterNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdParameter.CLASS);
    return mdClassIF.definesAttribute(PARAMETERNAME);
  }
  
  public void setParameterName(String value)
  {
    if(value == null)
    {
      setValue(PARAMETERNAME, "");
    }
    else
    {
      setValue(PARAMETERNAME, value);
    }
  }
  
  public Integer getParameterOrder()
  {
    return com.runwaysdk.constants.MdAttributeIntegerUtil.getTypeSafeValue(getValue(PARAMETERORDER));
  }
  
  public void validateParameterOrder()
  {
    this.validateAttribute(PARAMETERORDER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getParameterOrderMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdParameter.CLASS);
    return mdClassIF.definesAttribute(PARAMETERORDER);
  }
  
  public void setParameterOrder(Integer value)
  {
    if(value == null)
    {
      setValue(PARAMETERORDER, "");
    }
    else
    {
      setValue(PARAMETERORDER, java.lang.Integer.toString(value));
    }
  }
  
  public String getParameterType()
  {
    return getValue(PARAMETERTYPE);
  }
  
  public void validateParameterType()
  {
    this.validateAttribute(PARAMETERTYPE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getParameterTypeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdParameter.CLASS);
    return mdClassIF.definesAttribute(PARAMETERTYPE);
  }
  
  public void setParameterType(String value)
  {
    if(value == null)
    {
      setValue(PARAMETERTYPE, "");
    }
    else
    {
      setValue(PARAMETERTYPE, value);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.MetadataParameter addMetadata(com.runwaysdk.system.metadata.Metadata metadata)
  {
    return (com.runwaysdk.system.MetadataParameter) addParent(metadata, com.runwaysdk.system.MetadataParameter.CLASS);
  }
  
  public void removeMetadata(com.runwaysdk.system.metadata.Metadata metadata)
  {
    removeAllParents(metadata, com.runwaysdk.system.MetadataParameter.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.Metadata> getAllMetadata()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.Metadata>) getParents(com.runwaysdk.system.MetadataParameter.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.MetadataParameter> getAllMetadataRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.MetadataParameter>) getParentRelationships(com.runwaysdk.system.MetadataParameter.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.MetadataParameter getMetadataRel(com.runwaysdk.system.metadata.Metadata metadata)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.MetadataParameter> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.MetadataParameter>) getRelationshipsWithParent(metadata, com.runwaysdk.system.MetadataParameter.CLASS);
    try
    {
      if (iterator.hasNext())
      {
        return iterator.next();
      }
      else
      {
        return null;
      }
    }
    finally
    {
      iterator.close();
    }
  }
  
  public static MdParameter get(String id)
  {
    return (MdParameter) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdParameter getByKey(String key)
  {
    return (MdParameter) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdParameter lock(java.lang.String id)
  {
    MdParameter _instance = MdParameter.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdParameter unlock(java.lang.String id)
  {
    MdParameter _instance = MdParameter.get(id);
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
