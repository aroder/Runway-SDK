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

@com.runwaysdk.business.ClassSignature(hash = -511055329)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdMobileField.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdMobileFieldBase extends com.runwaysdk.system.metadata.MdField
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdMobileField";
  public static java.lang.String DEFININGMDFORM = "definingMdForm";
  private static final long serialVersionUID = -511055329;
  
  public MdMobileFieldBase()
  {
    super();
  }
  
  public com.runwaysdk.system.metadata.MdMobileForm getDefiningMdForm()
  {
    if (getValue(DEFININGMDFORM).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdMobileForm.get(getValue(DEFININGMDFORM));
    }
  }
  
  public String getDefiningMdFormId()
  {
    return getValue(DEFININGMDFORM);
  }
  
  public void validateDefiningMdForm()
  {
    this.validateAttribute(DEFININGMDFORM);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDefiningMdFormMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdMobileField.CLASS);
    return mdClassIF.definesAttribute(DEFININGMDFORM);
  }
  
  public void setDefiningMdForm(com.runwaysdk.system.metadata.MdMobileForm value)
  {
    if(value == null)
    {
      setValue(DEFININGMDFORM, "");
    }
    else
    {
      setValue(DEFININGMDFORM, value.getId());
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.MobileGroupField addGroupFields(com.runwaysdk.system.metadata.MdMobileGroup mdMobileGroup)
  {
    return (com.runwaysdk.system.metadata.MobileGroupField) addParent(mdMobileGroup, com.runwaysdk.system.metadata.MobileGroupField.CLASS);
  }
  
  public void removeGroupFields(com.runwaysdk.system.metadata.MdMobileGroup mdMobileGroup)
  {
    removeAllParents(mdMobileGroup, com.runwaysdk.system.metadata.MobileGroupField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdMobileGroup> getAllGroupFields()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdMobileGroup>) getParents(com.runwaysdk.system.metadata.MobileGroupField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MobileGroupField> getAllGroupFieldsRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MobileGroupField>) getParentRelationships(com.runwaysdk.system.metadata.MobileGroupField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.MobileGroupField getGroupFieldsRel(com.runwaysdk.system.metadata.MdMobileGroup mdMobileGroup)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MobileGroupField> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MobileGroupField>) getRelationshipsWithParent(mdMobileGroup, com.runwaysdk.system.metadata.MobileGroupField.CLASS);
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
  
  public com.runwaysdk.system.metadata.MobileFormField addMdForm(com.runwaysdk.system.metadata.MdMobileForm mdMobileForm)
  {
    return (com.runwaysdk.system.metadata.MobileFormField) addParent(mdMobileForm, com.runwaysdk.system.metadata.MobileFormField.CLASS);
  }
  
  public void removeMdForm(com.runwaysdk.system.metadata.MdMobileForm mdMobileForm)
  {
    removeAllParents(mdMobileForm, com.runwaysdk.system.metadata.MobileFormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdMobileForm> getAllMdForm()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdMobileForm>) getParents(com.runwaysdk.system.metadata.MobileFormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MobileFormField> getAllMdFormRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MobileFormField>) getParentRelationships(com.runwaysdk.system.metadata.MobileFormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MobileFormField> getMdFormRel(com.runwaysdk.system.metadata.MdMobileForm mdMobileForm)
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MobileFormField>) getRelationshipsWithParent(mdMobileForm, com.runwaysdk.system.metadata.MobileFormField.CLASS);
  }
  
  public static MdMobileField get(String id)
  {
    return (MdMobileField) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdMobileField getByKey(String key)
  {
    return (MdMobileField) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdMobileField lock(java.lang.String id)
  {
    MdMobileField _instance = MdMobileField.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdMobileField unlock(java.lang.String id)
  {
    MdMobileField _instance = MdMobileField.get(id);
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
