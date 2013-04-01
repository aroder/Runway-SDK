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

@com.runwaysdk.business.ClassSignature(hash = 1696811750)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeLocalText.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdAttributeLocalTextBase extends com.runwaysdk.system.metadata.MdAttributeLocal
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdAttributeLocalText";
  private static final long serialVersionUID = 1696811750;
  
  public MdAttributeLocalTextBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdAttributeLocalText get(String id)
  {
    return (MdAttributeLocalText) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdAttributeLocalText getByKey(String key)
  {
    return (MdAttributeLocalText) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdAttributeLocalText lock(java.lang.String id)
  {
    MdAttributeLocalText _instance = MdAttributeLocalText.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdAttributeLocalText unlock(java.lang.String id)
  {
    MdAttributeLocalText _instance = MdAttributeLocalText.get(id);
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
