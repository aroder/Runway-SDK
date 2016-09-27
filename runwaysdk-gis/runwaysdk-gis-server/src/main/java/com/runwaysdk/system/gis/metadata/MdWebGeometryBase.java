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
package com.runwaysdk.system.gis.metadata;

@com.runwaysdk.business.ClassSignature(hash = 940306901)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebGeometry.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdWebGeometryBase extends com.runwaysdk.system.metadata.MdWebAttribute
{
  public final static String CLASS = "com.runwaysdk.system.gis.metadata.MdWebGeometry";
  private static final long serialVersionUID = 940306901;
  
  public MdWebGeometryBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdWebGeometry get(String id)
  {
    return (MdWebGeometry) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdWebGeometry getByKey(String key)
  {
    return (MdWebGeometry) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdWebGeometry lock(java.lang.String id)
  {
    MdWebGeometry _instance = MdWebGeometry.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdWebGeometry unlock(java.lang.String id)
  {
    MdWebGeometry _instance = MdWebGeometry.get(id);
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
