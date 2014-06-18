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

@com.runwaysdk.business.ClassSignature(hash = -1384289889)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeBlob.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdAttributeBlobBase extends com.runwaysdk.system.metadata.MdAttributeConcrete
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdAttributeBlob";
  private static final long serialVersionUID = -1384289889;
  
  public MdAttributeBlobBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdAttributeBlob get(String id)
  {
    return (MdAttributeBlob) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdAttributeBlob getByKey(String key)
  {
    return (MdAttributeBlob) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdAttributeBlob lock(java.lang.String id)
  {
    MdAttributeBlob _instance = MdAttributeBlob.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdAttributeBlob unlock(java.lang.String id)
  {
    MdAttributeBlob _instance = MdAttributeBlob.get(id);
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
