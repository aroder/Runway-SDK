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

@com.runwaysdk.business.ClassSignature(hash = 1521065814)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdForm.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdFormBase extends com.runwaysdk.system.metadata.MdType
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdForm";
  public static java.lang.String FORMMDCLASS = "formMdClass";
  public static java.lang.String FORMNAME = "formName";
  private static final long serialVersionUID = 1521065814;
  
  public MdFormBase()
  {
    super();
  }
  
  public com.runwaysdk.system.metadata.MdClass getFormMdClass()
  {
    if (getValue(FORMMDCLASS).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdClass.get(getValue(FORMMDCLASS));
    }
  }
  
  public String getFormMdClassId()
  {
    return getValue(FORMMDCLASS);
  }
  
  public void validateFormMdClass()
  {
    this.validateAttribute(FORMMDCLASS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getFormMdClassMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdForm.CLASS);
    return mdClassIF.definesAttribute(FORMMDCLASS);
  }
  
  public void setFormMdClass(com.runwaysdk.system.metadata.MdClass value)
  {
    if(value == null)
    {
      setValue(FORMMDCLASS, "");
    }
    else
    {
      setValue(FORMMDCLASS, value.getId());
    }
  }
  
  public String getFormName()
  {
    return getValue(FORMNAME);
  }
  
  public void validateFormName()
  {
    this.validateAttribute(FORMNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getFormNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdForm.CLASS);
    return mdClassIF.definesAttribute(FORMNAME);
  }
  
  public void setFormName(String value)
  {
    if(value == null)
    {
      setValue(FORMNAME, "");
    }
    else
    {
      setValue(FORMNAME, value);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.FormField addMdFields(com.runwaysdk.system.metadata.MdField mdField)
  {
    return (com.runwaysdk.system.metadata.FormField) addChild(mdField, com.runwaysdk.system.metadata.FormField.CLASS);
  }
  
  public void removeMdFields(com.runwaysdk.system.metadata.MdField mdField)
  {
    removeAllChildren(mdField, com.runwaysdk.system.metadata.FormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdField> getAllMdFields()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdField>) getChildren(com.runwaysdk.system.metadata.FormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.FormField> getAllMdFieldsRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.FormField>) getChildRelationships(com.runwaysdk.system.metadata.FormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.FormField> getMdFieldsRel(com.runwaysdk.system.metadata.MdField mdField)
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.FormField>) getRelationshipsWithChild(mdField, com.runwaysdk.system.metadata.FormField.CLASS);
  }
  
  public static MdForm get(String id)
  {
    return (MdForm) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdForm getByKey(String key)
  {
    return (MdForm) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public com.runwaysdk.system.metadata.MdField[] getOrderedMdFields()
  {
    String msg = "This method should never be invoked.  It should be overwritten in com.runwaysdk.system.metadata.MdForm.java";
    throw new com.runwaysdk.dataaccess.metadata.ForbiddenMethodException(msg);
  }
  
  public static final com.runwaysdk.system.metadata.MdField[] getOrderedMdFields(java.lang.String id)
  {
    MdForm _instance = MdForm.get(id);
    return _instance.getOrderedMdFields();
  }
  
  public static MdForm lock(java.lang.String id)
  {
    MdForm _instance = MdForm.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdForm unlock(java.lang.String id)
  {
    MdForm _instance = MdForm.get(id);
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
