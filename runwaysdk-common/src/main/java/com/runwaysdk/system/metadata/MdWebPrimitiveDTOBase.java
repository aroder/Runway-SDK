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

@com.runwaysdk.business.ClassSignature(hash = -835862104)
public abstract class MdWebPrimitiveDTOBase extends com.runwaysdk.system.metadata.MdWebAttributeDTO
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdWebPrimitive";
  private static final long serialVersionUID = -835862104;
  
  protected MdWebPrimitiveDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected MdWebPrimitiveDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdWebSingleTermGridDTO> getAllGrid()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdWebSingleTermGridDTO>) getRequest().getParents(this.getId(), com.runwaysdk.system.metadata.WebGridFieldDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdWebSingleTermGridDTO> getAllGrid(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdWebSingleTermGridDTO>) clientRequestIF.getParents(id, com.runwaysdk.system.metadata.WebGridFieldDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.WebGridFieldDTO> getAllGridRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.WebGridFieldDTO>) getRequest().getParentRelationships(this.getId(), com.runwaysdk.system.metadata.WebGridFieldDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.WebGridFieldDTO> getAllGridRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.WebGridFieldDTO>) clientRequestIF.getParentRelationships(id, com.runwaysdk.system.metadata.WebGridFieldDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.WebGridFieldDTO addGrid(com.runwaysdk.system.metadata.MdWebSingleTermGridDTO parent)
  {
    return (com.runwaysdk.system.metadata.WebGridFieldDTO) getRequest().addParent(parent.getId(), this.getId(), com.runwaysdk.system.metadata.WebGridFieldDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.WebGridFieldDTO addGrid(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdWebSingleTermGridDTO parent)
  {
    return (com.runwaysdk.system.metadata.WebGridFieldDTO) clientRequestIF.addParent(parent.getId(), id, com.runwaysdk.system.metadata.WebGridFieldDTO.CLASS);
  }
  
  public void removeGrid(com.runwaysdk.system.metadata.WebGridFieldDTO relationship)
  {
    getRequest().deleteParent(relationship.getId());
  }
  
  public static void removeGrid(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.WebGridFieldDTO relationship)
  {
    clientRequestIF.deleteParent(relationship.getId());
  }
  
  public void removeAllGrid()
  {
    getRequest().deleteParents(this.getId(), com.runwaysdk.system.metadata.WebGridFieldDTO.CLASS);
  }
  
  public static void removeAllGrid(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteParents(id, com.runwaysdk.system.metadata.WebGridFieldDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.MdWebPrimitiveDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.metadata.MdWebPrimitiveDTO) dto;
  }
  
  public void apply()
  {
    if(isNewInstance())
    {
      getRequest().createBusiness(this);
    }
    else
    {
      getRequest().update(this);
    }
  }
  public void delete()
  {
    getRequest().delete(this.getId());
  }
  
  public static com.runwaysdk.system.metadata.MdWebPrimitiveQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.metadata.MdWebPrimitiveQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.metadata.MdWebPrimitiveDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdWebPrimitiveDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdWebPrimitiveDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdWebPrimitiveDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdWebPrimitiveDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdWebPrimitiveDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdWebPrimitiveDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}