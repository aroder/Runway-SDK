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

@com.runwaysdk.business.ClassSignature(hash = -1572015771)
public abstract class MdMobileFormDTOBase extends com.runwaysdk.system.metadata.MdFormDTO
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdMobileForm";
  private static final long serialVersionUID = -1572015771;
  
  protected MdMobileFormDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected MdMobileFormDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdMobileFieldDTO> getAllMdFields()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdMobileFieldDTO>) getRequest().getChildren(this.getId(), com.runwaysdk.system.metadata.MobileFormFieldDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdMobileFieldDTO> getAllMdFields(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdMobileFieldDTO>) clientRequestIF.getChildren(id, com.runwaysdk.system.metadata.MobileFormFieldDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MobileFormFieldDTO> getAllMdFieldsRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MobileFormFieldDTO>) getRequest().getChildRelationships(this.getId(), com.runwaysdk.system.metadata.MobileFormFieldDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MobileFormFieldDTO> getAllMdFieldsRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MobileFormFieldDTO>) clientRequestIF.getChildRelationships(id, com.runwaysdk.system.metadata.MobileFormFieldDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.MobileFormFieldDTO addMdFields(com.runwaysdk.system.metadata.MdMobileFieldDTO child)
  {
    return (com.runwaysdk.system.metadata.MobileFormFieldDTO) getRequest().addChild(this.getId(), child.getId(), com.runwaysdk.system.metadata.MobileFormFieldDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.MobileFormFieldDTO addMdFields(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdMobileFieldDTO child)
  {
    return (com.runwaysdk.system.metadata.MobileFormFieldDTO) clientRequestIF.addChild(id, child.getId(), com.runwaysdk.system.metadata.MobileFormFieldDTO.CLASS);
  }
  
  public void removeMdFields(com.runwaysdk.system.metadata.MobileFormFieldDTO relationship)
  {
    getRequest().deleteChild(relationship.getId());
  }
  
  public static void removeMdFields(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.MobileFormFieldDTO relationship)
  {
    clientRequestIF.deleteChild(relationship.getId());
  }
  
  public void removeAllMdFields()
  {
    getRequest().deleteChildren(this.getId(), com.runwaysdk.system.metadata.MobileFormFieldDTO.CLASS);
  }
  
  public static void removeAllMdFields(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteChildren(id, com.runwaysdk.system.metadata.MobileFormFieldDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.MdMobileFormDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.metadata.MdMobileFormDTO) dto;
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
  
  public static com.runwaysdk.system.metadata.MdMobileFormQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.metadata.MdMobileFormQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.metadata.MdMobileFormDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdMobileFormDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdMobileFormDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdMobileFormDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdMobileFormDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdMobileFormDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdMobileFormDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}