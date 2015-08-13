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
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 589740397)
public abstract class MdUtilDTOBase extends com.runwaysdk.system.metadata.MdSessionDTO
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdUtil";
  private static final long serialVersionUID = 589740397;
  
  protected MdUtilDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected MdUtilDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  public static java.lang.String SUPERMDUTIL = "superMdUtil";
  public com.runwaysdk.system.metadata.MdUtilDTO getSuperMdUtil()
  {
    if(getValue(SUPERMDUTIL) == null || getValue(SUPERMDUTIL).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdUtilDTO.get(getRequest(), getValue(SUPERMDUTIL));
    }
  }
  
  public String getSuperMdUtilId()
  {
    return getValue(SUPERMDUTIL);
  }
  
  public void setSuperMdUtil(com.runwaysdk.system.metadata.MdUtilDTO value)
  {
    if(value == null)
    {
      setValue(SUPERMDUTIL, "");
    }
    else
    {
      setValue(SUPERMDUTIL, value.getId());
    }
  }
  
  public boolean isSuperMdUtilWritable()
  {
    return isWritable(SUPERMDUTIL);
  }
  
  public boolean isSuperMdUtilReadable()
  {
    return isReadable(SUPERMDUTIL);
  }
  
  public boolean isSuperMdUtilModified()
  {
    return isModified(SUPERMDUTIL);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeReferenceMdDTO getSuperMdUtilMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeReferenceMdDTO) getAttributeDTO(SUPERMDUTIL).getAttributeMdDTO();
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdUtilDTO> getAllChildClasses()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdUtilDTO>) getRequest().getChildren(this.getId(), com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdUtilDTO> getAllChildClasses(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdUtilDTO>) clientRequestIF.getChildren(id, com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.UtilInheritanceDTO> getAllChildClassesRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.UtilInheritanceDTO>) getRequest().getChildRelationships(this.getId(), com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.UtilInheritanceDTO> getAllChildClassesRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.UtilInheritanceDTO>) clientRequestIF.getChildRelationships(id, com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.UtilInheritanceDTO addChildClasses(com.runwaysdk.system.metadata.MdUtilDTO child)
  {
    return (com.runwaysdk.system.metadata.UtilInheritanceDTO) getRequest().addChild(this.getId(), child.getId(), com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.UtilInheritanceDTO addChildClasses(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdUtilDTO child)
  {
    return (com.runwaysdk.system.metadata.UtilInheritanceDTO) clientRequestIF.addChild(id, child.getId(), com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  public void removeChildClasses(com.runwaysdk.system.metadata.UtilInheritanceDTO relationship)
  {
    getRequest().deleteChild(relationship.getId());
  }
  
  public static void removeChildClasses(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.UtilInheritanceDTO relationship)
  {
    clientRequestIF.deleteChild(relationship.getId());
  }
  
  public void removeAllChildClasses()
  {
    getRequest().deleteChildren(this.getId(), com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  public static void removeAllChildClasses(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteChildren(id, com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdUtilDTO> getAllSuperClass()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdUtilDTO>) getRequest().getParents(this.getId(), com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdUtilDTO> getAllSuperClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdUtilDTO>) clientRequestIF.getParents(id, com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.UtilInheritanceDTO> getAllSuperClassRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.UtilInheritanceDTO>) getRequest().getParentRelationships(this.getId(), com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.UtilInheritanceDTO> getAllSuperClassRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.UtilInheritanceDTO>) clientRequestIF.getParentRelationships(id, com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.UtilInheritanceDTO addSuperClass(com.runwaysdk.system.metadata.MdUtilDTO parent)
  {
    return (com.runwaysdk.system.metadata.UtilInheritanceDTO) getRequest().addParent(parent.getId(), this.getId(), com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.UtilInheritanceDTO addSuperClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdUtilDTO parent)
  {
    return (com.runwaysdk.system.metadata.UtilInheritanceDTO) clientRequestIF.addParent(parent.getId(), id, com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  public void removeSuperClass(com.runwaysdk.system.metadata.UtilInheritanceDTO relationship)
  {
    getRequest().deleteParent(relationship.getId());
  }
  
  public static void removeSuperClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.UtilInheritanceDTO relationship)
  {
    clientRequestIF.deleteParent(relationship.getId());
  }
  
  public void removeAllSuperClass()
  {
    getRequest().deleteParents(this.getId(), com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  public static void removeAllSuperClass(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteParents(id, com.runwaysdk.system.metadata.UtilInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.MdUtilDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.metadata.MdUtilDTO) dto;
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
  
  public static com.runwaysdk.system.metadata.MdUtilQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.metadata.MdUtilQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.metadata.MdUtilDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdUtilDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdUtilDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdUtilDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdUtilDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdUtilDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdUtilDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}
