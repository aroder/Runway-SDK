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

@com.runwaysdk.business.ClassSignature(hash = -1876013026)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeMultiPolygon.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdAttributeMultiPolygonBase extends com.runwaysdk.system.gis.metadata.MdAttributeGeometry
{
  public final static String CLASS = "com.runwaysdk.system.gis.metadata.MdAttributeMultiPolygon";
  private static final long serialVersionUID = -1876013026;
  
  public MdAttributeMultiPolygonBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdAttributeMultiPolygon get(String id)
  {
    return (MdAttributeMultiPolygon) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdAttributeMultiPolygon getByKey(String key)
  {
    return (MdAttributeMultiPolygon) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdAttributeMultiPolygon lock(java.lang.String id)
  {
    MdAttributeMultiPolygon _instance = MdAttributeMultiPolygon.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdAttributeMultiPolygon unlock(java.lang.String id)
  {
    MdAttributeMultiPolygon _instance = MdAttributeMultiPolygon.get(id);
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
