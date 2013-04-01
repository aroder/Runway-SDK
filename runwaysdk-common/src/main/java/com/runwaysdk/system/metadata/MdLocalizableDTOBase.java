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

@com.runwaysdk.business.ClassSignature(hash = -84847138)
public abstract class MdLocalizableDTOBase extends com.runwaysdk.system.metadata.MdTransientDTO
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdLocalizable";
  private static final long serialVersionUID = -84847138;
  
  protected MdLocalizableDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected MdLocalizableDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  public static java.lang.String MESSAGE = "message";
  public com.runwaysdk.system.metadata.MdLocalizableMessageDTO getMessage()
  {
    return (com.runwaysdk.system.metadata.MdLocalizableMessageDTO) this.getAttributeStructDTO(MESSAGE).getStructDTO();
  }
  
  public boolean isMessageWritable()
  {
    return isWritable(MESSAGE);
  }
  
  public boolean isMessageReadable()
  {
    return isReadable(MESSAGE);
  }
  
  public boolean isMessageModified()
  {
    return isModified(MESSAGE);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeLocalTextMdDTO getMessageMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeLocalTextMdDTO) getAttributeDTO(MESSAGE).getAttributeMdDTO();
  }
  
  public static com.runwaysdk.system.metadata.MdLocalizableDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.metadata.MdLocalizableDTO) dto;
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
  
  public static com.runwaysdk.system.metadata.MdLocalizableQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.metadata.MdLocalizableQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.metadata.MdLocalizableDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdLocalizableDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdLocalizableDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdLocalizableDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdLocalizableDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdLocalizableDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdLocalizableDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}
