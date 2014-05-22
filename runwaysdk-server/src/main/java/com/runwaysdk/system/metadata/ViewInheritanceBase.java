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

@com.runwaysdk.business.ClassSignature(hash = 837114318)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to ViewInheritance.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class ViewInheritanceBase extends com.runwaysdk.system.metadata.ClassInheritance
{
  public final static String CLASS = "com.runwaysdk.system.metadata.ViewInheritance";
  private static final long serialVersionUID = 837114318;
  
  public ViewInheritanceBase(String parentId, String childId)
  {
    super(parentId, childId);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.MdView getParent()
  {
    return (com.runwaysdk.system.metadata.MdView) super.getParent();
  }
  
  public com.runwaysdk.system.metadata.MdView getChild()
  {
    return (com.runwaysdk.system.metadata.MdView) super.getChild();
  }
  
  public static ViewInheritance get(String id)
  {
    return (ViewInheritance) com.runwaysdk.business.Relationship.get(id);
  }
  
  public static ViewInheritance getByKey(String key)
  {
    return (ViewInheritance) com.runwaysdk.business.Relationship.get(CLASS, key);
  }
  
  public static ViewInheritance lock(java.lang.String id)
  {
    ViewInheritance _instance = ViewInheritance.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static ViewInheritance unlock(java.lang.String id)
  {
    ViewInheritance _instance = ViewInheritance.get(id);
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
