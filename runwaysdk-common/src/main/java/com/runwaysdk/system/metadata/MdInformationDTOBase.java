/**
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
 */
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 1328254899)
public abstract class MdInformationDTOBase extends com.runwaysdk.system.metadata.MdMessageDTO
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdInformation";
  private static final long serialVersionUID = 1328254899;
  
  protected MdInformationDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected MdInformationDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  public static java.lang.String SUPERMDINFORMATION = "superMdInformation";
  public com.runwaysdk.system.metadata.MdInformationDTO getSuperMdInformation()
  {
    if(getValue(SUPERMDINFORMATION) == null || getValue(SUPERMDINFORMATION).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdInformationDTO.get(getRequest(), getValue(SUPERMDINFORMATION));
    }
  }
  
  public String getSuperMdInformationId()
  {
    return getValue(SUPERMDINFORMATION);
  }
  
  public void setSuperMdInformation(com.runwaysdk.system.metadata.MdInformationDTO value)
  {
    if(value == null)
    {
      setValue(SUPERMDINFORMATION, "");
    }
    else
    {
      setValue(SUPERMDINFORMATION, value.getId());
    }
  }
  
  public boolean isSuperMdInformationWritable()
  {
    return isWritable(SUPERMDINFORMATION);
  }
  
  public boolean isSuperMdInformationReadable()
  {
    return isReadable(SUPERMDINFORMATION);
  }
  
  public boolean isSuperMdInformationModified()
  {
    return isModified(SUPERMDINFORMATION);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeReferenceMdDTO getSuperMdInformationMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeReferenceMdDTO) getAttributeDTO(SUPERMDINFORMATION).getAttributeMdDTO();
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdInformationDTO> getAllChildInformationClass()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdInformationDTO>) getRequest().getChildren(this.getId(), com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdInformationDTO> getAllChildInformationClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdInformationDTO>) clientRequestIF.getChildren(id, com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.InformationInheritanceDTO> getAllChildInformationClassRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.InformationInheritanceDTO>) getRequest().getChildRelationships(this.getId(), com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.InformationInheritanceDTO> getAllChildInformationClassRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.InformationInheritanceDTO>) clientRequestIF.getChildRelationships(id, com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.InformationInheritanceDTO addChildInformationClass(com.runwaysdk.system.metadata.MdInformationDTO child)
  {
    return (com.runwaysdk.system.metadata.InformationInheritanceDTO) getRequest().addChild(this.getId(), child.getId(), com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.InformationInheritanceDTO addChildInformationClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdInformationDTO child)
  {
    return (com.runwaysdk.system.metadata.InformationInheritanceDTO) clientRequestIF.addChild(id, child.getId(), com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  public void removeChildInformationClass(com.runwaysdk.system.metadata.InformationInheritanceDTO relationship)
  {
    getRequest().deleteChild(relationship.getId());
  }
  
  public static void removeChildInformationClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.InformationInheritanceDTO relationship)
  {
    clientRequestIF.deleteChild(relationship.getId());
  }
  
  public void removeAllChildInformationClass()
  {
    getRequest().deleteChildren(this.getId(), com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  public static void removeAllChildInformationClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteChildren(id, com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdInformationDTO> getAllSuperInformationClass()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdInformationDTO>) getRequest().getParents(this.getId(), com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdInformationDTO> getAllSuperInformationClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdInformationDTO>) clientRequestIF.getParents(id, com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.InformationInheritanceDTO> getAllSuperInformationClassRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.InformationInheritanceDTO>) getRequest().getParentRelationships(this.getId(), com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.InformationInheritanceDTO> getAllSuperInformationClassRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.InformationInheritanceDTO>) clientRequestIF.getParentRelationships(id, com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.InformationInheritanceDTO addSuperInformationClass(com.runwaysdk.system.metadata.MdInformationDTO parent)
  {
    return (com.runwaysdk.system.metadata.InformationInheritanceDTO) getRequest().addParent(parent.getId(), this.getId(), com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.InformationInheritanceDTO addSuperInformationClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdInformationDTO parent)
  {
    return (com.runwaysdk.system.metadata.InformationInheritanceDTO) clientRequestIF.addParent(parent.getId(), id, com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  public void removeSuperInformationClass(com.runwaysdk.system.metadata.InformationInheritanceDTO relationship)
  {
    getRequest().deleteParent(relationship.getId());
  }
  
  public static void removeSuperInformationClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.InformationInheritanceDTO relationship)
  {
    clientRequestIF.deleteParent(relationship.getId());
  }
  
  public void removeAllSuperInformationClass()
  {
    getRequest().deleteParents(this.getId(), com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  public static void removeAllSuperInformationClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteParents(id, com.runwaysdk.system.metadata.InformationInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.MdInformationDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.metadata.MdInformationDTO) dto;
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
  
  public static com.runwaysdk.system.metadata.MdInformationQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.metadata.MdInformationQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.metadata.MdInformationDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdInformationDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdInformationDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdInformationDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdInformationDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdInformationDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdInformationDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}
