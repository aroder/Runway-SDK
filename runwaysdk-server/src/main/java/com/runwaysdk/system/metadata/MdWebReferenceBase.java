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

@com.runwaysdk.business.ClassSignature(hash = 134544683)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebReference.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdWebReferenceBase extends com.runwaysdk.system.metadata.MdWebAttribute
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdWebReference";
  private static final long serialVersionUID = 134544683;
  
  public MdWebReferenceBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdWebReference get(String id)
  {
    return (MdWebReference) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdWebReference getByKey(String key)
  {
    return (MdWebReference) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdWebReference lock(java.lang.String id)
  {
    MdWebReference _instance = MdWebReference.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdWebReference unlock(java.lang.String id)
  {
    MdWebReference _instance = MdWebReference.get(id);
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
