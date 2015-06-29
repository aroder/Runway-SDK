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
package com.runwaysdk.system;

@com.runwaysdk.business.ClassSignature(hash = -614438215)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to Operations.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class OperationsBase extends com.runwaysdk.system.EnumerationMaster
{
  public final static String CLASS = "com.runwaysdk.system.Operations";
  private static final long serialVersionUID = -614438215;
  
  public OperationsBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static Operations get(String id)
  {
    return (Operations) com.runwaysdk.business.Business.get(id);
  }
  
  public static Operations getByKey(String key)
  {
    return (Operations) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static Operations getEnumeration(String enumName)
  {
    return (Operations) com.runwaysdk.business.Business.getEnumeration(com.runwaysdk.system.Operations.CLASS ,enumName);
  }
  
  public static Operations lock(java.lang.String id)
  {
    Operations _instance = Operations.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static Operations unlock(java.lang.String id)
  {
    Operations _instance = Operations.get(id);
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
