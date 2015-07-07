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

@com.runwaysdk.business.ClassSignature(hash = 84621679)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to ClassAttributeConcrete.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class ClassAttributeConcreteBase extends com.runwaysdk.system.metadata.ClassAttribute
{
  public final static String CLASS = "com.runwaysdk.system.metadata.ClassAttributeConcrete";
  private static final long serialVersionUID = 84621679;
  
  public ClassAttributeConcreteBase(String parentId, String childId)
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
  
  public com.runwaysdk.system.metadata.MdAttributeConcrete getChild()
  {
    return (com.runwaysdk.system.metadata.MdAttributeConcrete) super.getChild();
  }
  
  public static ClassAttributeConcrete get(String id)
  {
    return (ClassAttributeConcrete) com.runwaysdk.business.Relationship.get(id);
  }
  
  public static ClassAttributeConcrete getByKey(String key)
  {
    return (ClassAttributeConcrete) com.runwaysdk.business.Relationship.get(CLASS, key);
  }
  
  public static ClassAttributeConcrete lock(java.lang.String id)
  {
    ClassAttributeConcrete _instance = ClassAttributeConcrete.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static ClassAttributeConcrete unlock(java.lang.String id)
  {
    ClassAttributeConcrete _instance = ClassAttributeConcrete.get(id);
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
