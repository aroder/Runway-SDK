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

@com.runwaysdk.business.ClassSignature(hash = 135114662)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to OrRule.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class OrRuleBase extends com.runwaysdk.system.gis.mapping.CompositeRule
{
  public final static String CLASS = "com.runwaysdk.system.gis.mapping.OrRule";
  private static final long serialVersionUID = 135114662;
  
  public OrRuleBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static OrRule get(String id)
  {
    return (OrRule) com.runwaysdk.business.Business.get(id);
  }
  
  public static OrRule getByKey(String key)
  {
    return (OrRule) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static OrRule lock(java.lang.String id)
  {
    OrRule _instance = OrRule.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static OrRule unlock(java.lang.String id)
  {
    OrRule _instance = OrRule.get(id);
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
