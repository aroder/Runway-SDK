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

@com.runwaysdk.business.ClassSignature(hash = -478610458)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebGroup.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdWebGroupBase extends com.runwaysdk.system.metadata.MdWebField
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdWebGroup";
  private static final long serialVersionUID = -478610458;
  
  public MdWebGroupBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.WebGroupField addWebGroups(com.runwaysdk.system.metadata.MdWebField mdWebField)
  {
    return (com.runwaysdk.system.metadata.WebGroupField) addChild(mdWebField, com.runwaysdk.system.metadata.WebGroupField.CLASS);
  }
  
  public void removeWebGroups(com.runwaysdk.system.metadata.MdWebField mdWebField)
  {
    removeAllChildren(mdWebField, com.runwaysdk.system.metadata.WebGroupField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdWebField> getAllWebGroups()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdWebField>) getChildren(com.runwaysdk.system.metadata.WebGroupField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebGroupField> getAllWebGroupsRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebGroupField>) getChildRelationships(com.runwaysdk.system.metadata.WebGroupField.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.WebGroupField getWebGroupsRel(com.runwaysdk.system.metadata.MdWebField mdWebField)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebGroupField> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.WebGroupField>) getRelationshipsWithChild(mdWebField, com.runwaysdk.system.metadata.WebGroupField.CLASS);
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
  
  public static MdWebGroup get(String id)
  {
    return (MdWebGroup) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdWebGroup getByKey(String key)
  {
    return (MdWebGroup) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdWebGroup lock(java.lang.String id)
  {
    MdWebGroup _instance = MdWebGroup.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdWebGroup unlock(java.lang.String id)
  {
    MdWebGroup _instance = MdWebGroup.get(id);
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
