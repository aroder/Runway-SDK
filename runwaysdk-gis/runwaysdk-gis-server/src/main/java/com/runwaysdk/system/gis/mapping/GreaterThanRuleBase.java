/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Runway SDK GIS(tm).
 *
 * Runway SDK GIS(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Runway SDK GIS(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Runway SDK GIS(tm).  If not, see <http://www.gnu.org/licenses/>.
 */
package com.runwaysdk.system.gis.mapping;

@com.runwaysdk.business.ClassSignature(hash = 354486302)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to GreaterThanRule.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class GreaterThanRuleBase extends com.runwaysdk.system.gis.mapping.PrimitiveRule
{
  public final static String CLASS = "com.runwaysdk.system.gis.mapping.GreaterThanRule";
  private static final long serialVersionUID = 354486302;
  
  public GreaterThanRuleBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static GreaterThanRule get(String id)
  {
    return (GreaterThanRule) com.runwaysdk.business.Business.get(id);
  }
  
  public static GreaterThanRule getByKey(String key)
  {
    return (GreaterThanRule) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static GreaterThanRule lock(java.lang.String id)
  {
    GreaterThanRule _instance = GreaterThanRule.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static GreaterThanRule unlock(java.lang.String id)
  {
    GreaterThanRule _instance = GreaterThanRule.get(id);
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