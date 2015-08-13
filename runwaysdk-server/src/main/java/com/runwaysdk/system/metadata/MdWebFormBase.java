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

@com.runwaysdk.business.ClassSignature(hash = -1416242015)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebForm.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdWebFormBase extends com.runwaysdk.system.metadata.MdForm
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdWebForm";
  private static final long serialVersionUID = -1416242015;
  
  public MdWebFormBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.WebFormField addMdFields(com.runwaysdk.system.metadata.MdWebField mdWebField)
  {
    return (com.runwaysdk.system.metadata.WebFormField) addChild(mdWebField, com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  public void removeMdFields(com.runwaysdk.system.metadata.MdWebField mdWebField)
  {
    removeAllChildren(mdWebField, com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdWebField> getAllMdFields()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdWebField>) getChildren(com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebFormField> getAllMdFieldsRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebFormField>) getChildRelationships(com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebFormField> getMdFieldsRel(com.runwaysdk.system.metadata.MdWebField mdWebField)
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebFormField>) getRelationshipsWithChild(mdWebField, com.runwaysdk.system.metadata.WebFormField.CLASS);
  }
  
  public static MdWebForm get(String id)
  {
    return (MdWebForm) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdWebForm getByKey(String key)
  {
    return (MdWebForm) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdWebForm lock(java.lang.String id)
  {
    MdWebForm _instance = MdWebForm.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdWebForm unlock(java.lang.String id)
  {
    MdWebForm _instance = MdWebForm.get(id);
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
