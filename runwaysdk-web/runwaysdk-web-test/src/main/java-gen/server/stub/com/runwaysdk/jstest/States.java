/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
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
package com.runwaysdk.jstest;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = 1354021188)
public enum States implements com.runwaysdk.business.BusinessEnumeration, com.runwaysdk.generation.loader.Reloadable
{
  CA(),
  
  CO(),
  
  CT();
  
  public static final java.lang.String CLASS = "com.runwaysdk.jstest.States";
  private com.runwaysdk.jstest.StateEnum enumeration;
  
  private synchronized void loadEnumeration()
  {
    com.runwaysdk.jstest.StateEnum enu = com.runwaysdk.jstest.StateEnum.getEnumeration(this.name());
    setEnumeration(enu);
  }
  
  private synchronized void setEnumeration(com.runwaysdk.jstest.StateEnum enumeration)
  {
    this.enumeration = enumeration;
  }
  
  public Integer getEnumInt()
  {
    loadEnumeration();
    return enumeration.getEnumInt();
  }
  
  public String getStateCode()
  {
    loadEnumeration();
    return enumeration.getStateCode();
  }
  
  public String getStateName()
  {
    loadEnumeration();
    return enumeration.getStateName();
  }
  
  public com.runwaysdk.system.PhoneNumber getStatePhone()
  {
    loadEnumeration();
    return enumeration.getStatePhone();
  }
  
  public java.lang.String getId()
  {
    loadEnumeration();
    return enumeration.getId();
  }
  
  public java.lang.String getEnumName()
  {
    loadEnumeration();
    return enumeration.getEnumName();
  }
  
  public java.lang.String getDisplayLabel()
  {
    loadEnumeration();
    return enumeration.getDisplayLabel().getValue(com.runwaysdk.session.Session.getCurrentLocale());
  }
  
  public static States get(String id)
  {
    for (States e : States.values())
    {
      if (e.getId().equals(id))
      {
        return e;
      }
    }
    return null;
  }
  
}