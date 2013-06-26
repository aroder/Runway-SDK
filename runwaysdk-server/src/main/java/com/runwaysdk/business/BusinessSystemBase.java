/**
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
 */

package com.runwaysdk.business;

@com.runwaysdk.business.ClassSignature(hash = -1944827653)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to Business.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class BusinessSystemBase extends com.runwaysdk.business.ElementSystem
{
  public final static String CLASS = "com.runwaysdk.business.Business";
  private static final long serialVersionUID = -1944827653;
  
  public BusinessSystemBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.MetadataRelationship addParentMetadata(com.runwaysdk.system.metadata.Metadata metadata)
  {
    return (com.runwaysdk.system.metadata.MetadataRelationship) addParent(metadata, com.runwaysdk.system.metadata.MetadataRelationship.CLASS);
  }
  
  public void removeParentMetadata(com.runwaysdk.system.metadata.Metadata metadata)
  {
    removeAllParents(metadata, com.runwaysdk.system.metadata.MetadataRelationship.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.Metadata> getAllParentMetadata()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.Metadata>) getParents(com.runwaysdk.system.metadata.MetadataRelationship.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MetadataRelationship> getAllParentMetadataRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MetadataRelationship>) getParentRelationships(com.runwaysdk.system.metadata.MetadataRelationship.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.MetadataRelationship getParentMetadataRel(com.runwaysdk.system.metadata.Metadata metadata)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MetadataRelationship> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MetadataRelationship>) getRelationshipsWithParent(metadata, com.runwaysdk.system.metadata.MetadataRelationship.CLASS);
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
  
  public static BusinessSystem get(String id)
  {
    return (BusinessSystem) com.runwaysdk.business.Business.get(id);
  }
  
  public static BusinessSystem getByKey(String key)
  {
    return (BusinessSystem) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static BusinessSystem lock(java.lang.String id)
  {
    BusinessSystem _instance = BusinessSystem.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static BusinessSystem unlock(java.lang.String id)
  {
    BusinessSystem _instance = BusinessSystem.get(id);
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
