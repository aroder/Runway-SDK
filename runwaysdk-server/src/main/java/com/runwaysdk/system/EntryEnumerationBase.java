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
package com.runwaysdk.system;

@com.runwaysdk.business.ClassSignature(hash = 1162888214)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to EntryEnumeration.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class EntryEnumerationBase extends com.runwaysdk.system.EnumerationMaster
{
  public final static String CLASS = "com.runwaysdk.system.EntryEnumeration";
  private static final long serialVersionUID = 1162888214;
  
  public EntryEnumerationBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static EntryEnumeration get(String id)
  {
    return (EntryEnumeration) com.runwaysdk.business.Business.get(id);
  }
  
  public static EntryEnumeration getByKey(String key)
  {
    return (EntryEnumeration) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static EntryEnumeration getEnumeration(String enumName)
  {
    return (EntryEnumeration) com.runwaysdk.business.Business.getEnumeration(com.runwaysdk.system.EntryEnumeration.CLASS ,enumName);
  }
  
  public static EntryEnumeration lock(java.lang.String id)
  {
    EntryEnumeration _instance = EntryEnumeration.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static EntryEnumeration unlock(java.lang.String id)
  {
    EntryEnumeration _instance = EntryEnumeration.get(id);
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
