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

@com.runwaysdk.business.ClassSignature(hash = -1602917870)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to AttributeIndicator.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class AttributeIndicatorBase extends com.runwaysdk.system.metadata.MetadataRelationship
{
  public final static String CLASS = "com.runwaysdk.system.metadata.AttributeIndicator";
  private static final long serialVersionUID = -1602917870;
  
  public AttributeIndicatorBase(String parentId, String childId)
  {
    super(parentId, childId);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.MdAttributeIndicator getParent()
  {
    return (com.runwaysdk.system.metadata.MdAttributeIndicator) super.getParent();
  }
  
  public com.runwaysdk.system.metadata.IndicatorComposite getChild()
  {
    return (com.runwaysdk.system.metadata.IndicatorComposite) super.getChild();
  }
  
  public static AttributeIndicator get(String id)
  {
    return (AttributeIndicator) com.runwaysdk.business.Relationship.get(id);
  }
  
  public static AttributeIndicator getByKey(String key)
  {
    return (AttributeIndicator) com.runwaysdk.business.Relationship.get(CLASS, key);
  }
  
  public static AttributeIndicator lock(java.lang.String id)
  {
    AttributeIndicator _instance = AttributeIndicator.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static AttributeIndicator unlock(java.lang.String id)
  {
    AttributeIndicator _instance = AttributeIndicator.get(id);
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
