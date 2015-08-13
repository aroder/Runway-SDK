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

@com.runwaysdk.business.ClassSignature(hash = -1847162271)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to ClassHasDimension.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class ClassHasDimensionBase extends com.runwaysdk.system.metadata.MetadataRelationship
{
  public final static String CLASS = "com.runwaysdk.system.metadata.ClassHasDimension";
  private static final long serialVersionUID = -1847162271;
  
  public ClassHasDimensionBase(String parentId, String childId)
  {
    super(parentId, childId);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.MdClass getParent()
  {
    return (com.runwaysdk.system.metadata.MdClass) super.getParent();
  }
  
  public com.runwaysdk.system.metadata.MdClassDimension getChild()
  {
    return (com.runwaysdk.system.metadata.MdClassDimension) super.getChild();
  }
  
  public static ClassHasDimension get(String id)
  {
    return (ClassHasDimension) com.runwaysdk.business.Relationship.get(id);
  }
  
  public static ClassHasDimension getByKey(String key)
  {
    return (ClassHasDimension) com.runwaysdk.business.Relationship.get(CLASS, key);
  }
  
  public static ClassHasDimension lock(java.lang.String id)
  {
    ClassHasDimension _instance = ClassHasDimension.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static ClassHasDimension unlock(java.lang.String id)
  {
    ClassHasDimension _instance = ClassHasDimension.get(id);
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
