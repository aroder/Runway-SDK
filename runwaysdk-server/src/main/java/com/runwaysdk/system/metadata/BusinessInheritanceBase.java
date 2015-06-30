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

@com.runwaysdk.business.ClassSignature(hash = -598433549)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to BusinessInheritance.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class BusinessInheritanceBase extends com.runwaysdk.system.metadata.ClassInheritance
{
  public final static String CLASS = "com.runwaysdk.system.metadata.BusinessInheritance";
  private static final long serialVersionUID = -598433549;
  
  public BusinessInheritanceBase(String parentId, String childId)
  {
    super(parentId, childId);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.MdBusiness getParent()
  {
    return (com.runwaysdk.system.metadata.MdBusiness) super.getParent();
  }
  
  public com.runwaysdk.system.metadata.MdBusiness getChild()
  {
    return (com.runwaysdk.system.metadata.MdBusiness) super.getChild();
  }
  
  public static BusinessInheritance get(String id)
  {
    return (BusinessInheritance) com.runwaysdk.business.Relationship.get(id);
  }
  
  public static BusinessInheritance getByKey(String key)
  {
    return (BusinessInheritance) com.runwaysdk.business.Relationship.get(CLASS, key);
  }
  
  public static BusinessInheritance lock(java.lang.String id)
  {
    BusinessInheritance _instance = BusinessInheritance.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static BusinessInheritance unlock(java.lang.String id)
  {
    BusinessInheritance _instance = BusinessInheritance.get(id);
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
