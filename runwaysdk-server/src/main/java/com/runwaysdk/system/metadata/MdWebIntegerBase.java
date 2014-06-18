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

@com.runwaysdk.business.ClassSignature(hash = 1506265432)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebInteger.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdWebIntegerBase extends com.runwaysdk.system.metadata.MdWebNumber
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdWebInteger";
  private static final long serialVersionUID = 1506265432;
  
  public MdWebIntegerBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdWebInteger get(String id)
  {
    return (MdWebInteger) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdWebInteger getByKey(String key)
  {
    return (MdWebInteger) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdWebInteger lock(java.lang.String id)
  {
    MdWebInteger _instance = MdWebInteger.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdWebInteger unlock(java.lang.String id)
  {
    MdWebInteger _instance = MdWebInteger.get(id);
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
