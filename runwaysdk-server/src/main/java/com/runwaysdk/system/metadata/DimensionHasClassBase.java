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

@com.runwaysdk.business.ClassSignature(hash = -1992305101)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to DimensionHasClass.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class DimensionHasClassBase extends com.runwaysdk.system.metadata.MetadataRelationship
{
  public final static String CLASS = "com.runwaysdk.system.metadata.DimensionHasClass";
  private static final long serialVersionUID = -1992305101;
  
  public DimensionHasClassBase(String parentId, String childId)
  {
    super(parentId, childId);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.MdDimension getParent()
  {
    return (com.runwaysdk.system.metadata.MdDimension) super.getParent();
  }
  
  public com.runwaysdk.system.metadata.MdClassDimension getChild()
  {
    return (com.runwaysdk.system.metadata.MdClassDimension) super.getChild();
  }
  
  public static DimensionHasClass get(String id)
  {
    return (DimensionHasClass) com.runwaysdk.business.Relationship.get(id);
  }
  
  public static DimensionHasClass getByKey(String key)
  {
    return (DimensionHasClass) com.runwaysdk.business.Relationship.get(CLASS, key);
  }
  
  public static DimensionHasClass lock(java.lang.String id)
  {
    DimensionHasClass _instance = DimensionHasClass.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static DimensionHasClass unlock(java.lang.String id)
  {
    DimensionHasClass _instance = DimensionHasClass.get(id);
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
