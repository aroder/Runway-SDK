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

@com.runwaysdk.business.ClassSignature(hash = 553747800)
public abstract class MdWarningDTOBase extends com.runwaysdk.system.metadata.MdMessageDTO
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdWarning";
  private static final long serialVersionUID = 553747800;
  
  protected MdWarningDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected MdWarningDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  public static java.lang.String SUPERMDWARNING = "superMdWarning";
  public com.runwaysdk.system.metadata.MdMessageDTO getSuperMdWarning()
  {
    if(getValue(SUPERMDWARNING) == null || getValue(SUPERMDWARNING).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdMessageDTO.get(getRequest(), getValue(SUPERMDWARNING));
    }
  }
  
  public String getSuperMdWarningId()
  {
    return getValue(SUPERMDWARNING);
  }
  
  public void setSuperMdWarning(com.runwaysdk.system.metadata.MdMessageDTO value)
  {
    if(value == null)
    {
      setValue(SUPERMDWARNING, "");
    }
    else
    {
      setValue(SUPERMDWARNING, value.getId());
    }
  }
  
  public boolean isSuperMdWarningWritable()
  {
    return isWritable(SUPERMDWARNING);
  }
  
  public boolean isSuperMdWarningReadable()
  {
    return isReadable(SUPERMDWARNING);
  }
  
  public boolean isSuperMdWarningModified()
  {
    return isModified(SUPERMDWARNING);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeReferenceMdDTO getSuperMdWarningMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeReferenceMdDTO) getAttributeDTO(SUPERMDWARNING).getAttributeMdDTO();
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdWarningDTO> getAllChildMessages()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdWarningDTO>) getRequest().getChildren(this.getId(), com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdWarningDTO> getAllChildMessages(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdWarningDTO>) clientRequestIF.getChildren(id, com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.WarningInheritanceDTO> getAllChildMessagesRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.WarningInheritanceDTO>) getRequest().getChildRelationships(this.getId(), com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.WarningInheritanceDTO> getAllChildMessagesRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.WarningInheritanceDTO>) clientRequestIF.getChildRelationships(id, com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.WarningInheritanceDTO addChildMessages(com.runwaysdk.system.metadata.MdWarningDTO child)
  {
    return (com.runwaysdk.system.metadata.WarningInheritanceDTO) getRequest().addChild(this.getId(), child.getId(), com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.WarningInheritanceDTO addChildMessages(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdWarningDTO child)
  {
    return (com.runwaysdk.system.metadata.WarningInheritanceDTO) clientRequestIF.addChild(id, child.getId(), com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  public void removeChildMessages(com.runwaysdk.system.metadata.WarningInheritanceDTO relationship)
  {
    getRequest().deleteChild(relationship.getId());
  }
  
  public static void removeChildMessages(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.WarningInheritanceDTO relationship)
  {
    clientRequestIF.deleteChild(relationship.getId());
  }
  
  public void removeAllChildMessages()
  {
    getRequest().deleteChildren(this.getId(), com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  public static void removeAllChildMessages(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteChildren(id, com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdWarningDTO> getAllParentMessage()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdWarningDTO>) getRequest().getParents(this.getId(), com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdWarningDTO> getAllParentMessage(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdWarningDTO>) clientRequestIF.getParents(id, com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.WarningInheritanceDTO> getAllParentMessageRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.WarningInheritanceDTO>) getRequest().getParentRelationships(this.getId(), com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.WarningInheritanceDTO> getAllParentMessageRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.WarningInheritanceDTO>) clientRequestIF.getParentRelationships(id, com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.WarningInheritanceDTO addParentMessage(com.runwaysdk.system.metadata.MdWarningDTO parent)
  {
    return (com.runwaysdk.system.metadata.WarningInheritanceDTO) getRequest().addParent(parent.getId(), this.getId(), com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.WarningInheritanceDTO addParentMessage(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdWarningDTO parent)
  {
    return (com.runwaysdk.system.metadata.WarningInheritanceDTO) clientRequestIF.addParent(parent.getId(), id, com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  public void removeParentMessage(com.runwaysdk.system.metadata.WarningInheritanceDTO relationship)
  {
    getRequest().deleteParent(relationship.getId());
  }
  
  public static void removeParentMessage(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.WarningInheritanceDTO relationship)
  {
    clientRequestIF.deleteParent(relationship.getId());
  }
  
  public void removeAllParentMessage()
  {
    getRequest().deleteParents(this.getId(), com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  public static void removeAllParentMessage(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteParents(id, com.runwaysdk.system.metadata.WarningInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.MdWarningDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.metadata.MdWarningDTO) dto;
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
  
  public static com.runwaysdk.system.metadata.MdWarningQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.metadata.MdWarningQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.metadata.MdWarningDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdWarningDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdWarningDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdWarningDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdWarningDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdWarningDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdWarningDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}
