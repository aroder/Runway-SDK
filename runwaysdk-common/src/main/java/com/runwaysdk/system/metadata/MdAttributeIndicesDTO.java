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

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = -971978642)
public enum MdAttributeIndicesDTO implements com.runwaysdk.business.EnumerationDTOIF
{
  NON_UNIQUE_INDEX(),
  
  NO_INDEX(),
  
  UNIQUE_INDEX();
  
  public final static String CLASS = "com.runwaysdk.system.metadata.MdAttributeIndices";
  
  
  public com.runwaysdk.system.metadata.IndexTypesDTO item(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (com.runwaysdk.system.metadata.IndexTypesDTO) clientRequest.getEnumeration(com.runwaysdk.system.metadata.MdAttributeIndicesDTO.CLASS, this.name());
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.system.metadata.IndexTypesDTO> items(com.runwaysdk.constants.ClientRequestIF clientRequest, MdAttributeIndicesDTO ... items)
  {
    java.lang.String[] itemNames = new java.lang.String[items.length];
    for(int i=0; i<items.length; i++)
    {
      itemNames[i] = items[i].name();
    }
    return (java.util.List<com.runwaysdk.system.metadata.IndexTypesDTO>) clientRequest.getEnumerations(com.runwaysdk.system.metadata.MdAttributeIndicesDTO.CLASS, itemNames);
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.system.metadata.IndexTypesDTO> allItems(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (java.util.List<com.runwaysdk.system.metadata.IndexTypesDTO>) clientRequest.getAllEnumerations(com.runwaysdk.system.metadata.MdAttributeIndicesDTO.CLASS);
  }
  
  public java.lang.String getName()
  {
    return this.name();
  }
}