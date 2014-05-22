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

@com.runwaysdk.business.ClassSignature(hash = -220911643)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebField.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdWebFieldBase extends com.runwaysdk.system.metadata.MdField
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdWebField";
  public static java.lang.String DEFININGMDFORM = "definingMdForm";
  private static final long serialVersionUID = -220911643;
  
  public MdWebFieldBase()
  {
    super();
  }
  
  public com.runwaysdk.system.metadata.MdWebForm getDefiningMdForm()
  {
    if (getValue(DEFININGMDFORM).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdWebForm.get(getValue(DEFININGMDFORM));
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdWebField.CLASS);
    return mdClassIF.definesAttribute(DEFININGMDFORM);
  }
  
  public void setDefiningMdForm(com.runwaysdk.system.metadata.MdWebForm value)
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
  
  public com.runwaysdk.system.metadata.WebGroupField addGroupFields(com.runwaysdk.system.metadata.MdWebGroup mdWebGroup)
  {
    return (com.runwaysdk.system.metadata.WebGroupField) addParent(mdWebGroup, com.runwaysdk.system.metadata.WebGroupField.CLASS);
  }
  
  public void removeGroupFields(com.runwaysdk.system.metadata.MdWebGroup mdWebGroup)
  {
    removeAllParents(mdWebGroup, com.runwaysdk.system.metadata.WebGroupField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdWebGroup> getAllGroupFields()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdWebGroup>) getParents(com.runwaysdk.system.metadata.WebGroupField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebGroupField> getAllGroupFieldsRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebGroupField>) getParentRelationships(com.runwaysdk.system.metadata.WebGroupField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.WebGroupField getGroupFieldsRel(com.runwaysdk.system.metadata.MdWebGroup mdWebGroup)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebGroupField> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebGroupField>) getRelationshipsWithParent(mdWebGroup, com.runwaysdk.system.metadata.WebGroupField.CLASS);
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
  
  public com.runwaysdk.system.metadata.WebFormField addMdForm(com.runwaysdk.system.metadata.MdWebForm mdWebForm)
  {
    return (com.runwaysdk.system.metadata.WebFormField) addParent(mdWebForm, com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  public void removeMdForm(com.runwaysdk.system.metadata.MdWebForm mdWebForm)
  {
    removeAllParents(mdWebForm, com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdWebForm> getAllMdForm()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdWebForm>) getParents(com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebFormField> getAllMdFormRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebFormField>) getParentRelationships(com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebFormField> getMdFormRel(com.runwaysdk.system.metadata.MdWebForm mdWebForm)
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebFormField>) getRelationshipsWithParent(mdWebForm, com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  public static MdWebField get(String id)
  {
    return (MdWebField) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdWebField getByKey(String key)
  {
    return (MdWebField) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdWebField lock(java.lang.String id)
  {
    MdWebField _instance = MdWebField.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdWebField unlock(java.lang.String id)
  {
    MdWebField _instance = MdWebField.get(id);
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
