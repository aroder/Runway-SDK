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

@com.runwaysdk.business.ClassSignature(hash = 1824927443)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdMobileText.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdMobileTextBase extends com.runwaysdk.system.metadata.MdMobilePrimitive
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdMobileText";
  private static final long serialVersionUID = 1824927443;
  
  public MdMobileTextBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdMobileText get(String id)
  {
    return (MdMobileText) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdMobileText getByKey(String key)
  {
    return (MdMobileText) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdMobileText lock(java.lang.String id)
  {
    MdMobileText _instance = MdMobileText.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdMobileText unlock(java.lang.String id)
  {
    MdMobileText _instance = MdMobileText.get(id);
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
