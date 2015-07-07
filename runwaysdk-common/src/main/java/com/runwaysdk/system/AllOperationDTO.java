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
package com.runwaysdk.system;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = -1760564178)
public enum AllOperationDTO implements com.runwaysdk.business.EnumerationDTOIF
{
  EQ(),
  
  GT(),
  
  GTE(),
  
  LT(),
  
  LTE(),
  
  NEQ();
  
  public final static String CLASS = "com.runwaysdk.system.AllOperation";
  
  
  public com.runwaysdk.system.FieldOperationDTO item(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (com.runwaysdk.system.FieldOperationDTO) clientRequest.getEnumeration(com.runwaysdk.system.AllOperationDTO.CLASS, this.name());
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.system.FieldOperationDTO> items(com.runwaysdk.constants.ClientRequestIF clientRequest, AllOperationDTO ... items)
  {
    java.lang.String[] itemNames = new java.lang.String[items.length];
    for(int i=0; i<items.length; i++)
    {
      itemNames[i] = items[i].name();
    }
    return (java.util.List<com.runwaysdk.system.FieldOperationDTO>) clientRequest.getEnumerations(com.runwaysdk.system.AllOperationDTO.CLASS, itemNames);
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.system.FieldOperationDTO> allItems(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (java.util.List<com.runwaysdk.system.FieldOperationDTO>) clientRequest.getAllEnumerations(com.runwaysdk.system.AllOperationDTO.CLASS);
  }
  
  public java.lang.String getName()
  {
    return this.name();
  }
}
