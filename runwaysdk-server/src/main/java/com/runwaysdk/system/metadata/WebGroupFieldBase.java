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

@com.runwaysdk.business.ClassSignature(hash = 1059377427)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to WebGroupField.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class WebGroupFieldBase extends com.runwaysdk.system.metadata.MetadataRelationship
{
  public final static String CLASS = "com.runwaysdk.system.metadata.WebGroupField";
  private static final long serialVersionUID = 1059377427;
  
  public WebGroupFieldBase(String parentId, String childId)
  {
    super(parentId, childId);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.MdWebGroup getParent()
  {
    return (com.runwaysdk.system.metadata.MdWebGroup) super.getParent();
  }
  
  public com.runwaysdk.system.metadata.MdWebField getChild()
  {
    return (com.runwaysdk.system.metadata.MdWebField) super.getChild();
  }
  
  public static WebGroupField get(String id)
  {
    return (WebGroupField) com.runwaysdk.business.Relationship.get(id);
  }
  
  public static WebGroupField getByKey(String key)
  {
    return (WebGroupField) com.runwaysdk.business.Relationship.get(CLASS, key);
  }
  
  public static WebGroupField lock(java.lang.String id)
  {
    WebGroupField _instance = WebGroupField.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static WebGroupField unlock(java.lang.String id)
  {
    WebGroupField _instance = WebGroupField.get(id);
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
