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

@com.runwaysdk.business.ClassSignature(hash = -1331840038)
public abstract class MdExceptionDTOBase extends com.runwaysdk.system.metadata.MdLocalizableDTO
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdException";
  private static final long serialVersionUID = -1331840038;
  
  protected MdExceptionDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected MdExceptionDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  public static java.lang.String SUPERMDEXCEPTION = "superMdException";
  public com.runwaysdk.system.metadata.MdExceptionDTO getSuperMdException()
  {
    if(getValue(SUPERMDEXCEPTION) == null || getValue(SUPERMDEXCEPTION).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdExceptionDTO.get(getRequest(), getValue(SUPERMDEXCEPTION));
    }
  }
  
  public String getSuperMdExceptionId()
  {
    return getValue(SUPERMDEXCEPTION);
  }
  
  public void setSuperMdException(com.runwaysdk.system.metadata.MdExceptionDTO value)
  {
    if(value == null)
    {
      setValue(SUPERMDEXCEPTION, "");
    }
    else
    {
      setValue(SUPERMDEXCEPTION, value.getId());
    }
  }
  
  public boolean isSuperMdExceptionWritable()
  {
    return isWritable(SUPERMDEXCEPTION);
  }
  
  public boolean isSuperMdExceptionReadable()
  {
    return isReadable(SUPERMDEXCEPTION);
  }
  
  public boolean isSuperMdExceptionModified()
  {
    return isModified(SUPERMDEXCEPTION);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeReferenceMdDTO getSuperMdExceptionMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeReferenceMdDTO) getAttributeDTO(SUPERMDEXCEPTION).getAttributeMdDTO();
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdExceptionDTO> getAllChildExceptions()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdExceptionDTO>) getRequest().getChildren(this.getId(), com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdExceptionDTO> getAllChildExceptions(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdExceptionDTO>) clientRequestIF.getChildren(id, com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.ExceptionInheritanceDTO> getAllChildExceptionsRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.ExceptionInheritanceDTO>) getRequest().getChildRelationships(this.getId(), com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.ExceptionInheritanceDTO> getAllChildExceptionsRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.ExceptionInheritanceDTO>) clientRequestIF.getChildRelationships(id, com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.ExceptionInheritanceDTO addChildExceptions(com.runwaysdk.system.metadata.MdExceptionDTO child)
  {
    return (com.runwaysdk.system.metadata.ExceptionInheritanceDTO) getRequest().addChild(this.getId(), child.getId(), com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.ExceptionInheritanceDTO addChildExceptions(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdExceptionDTO child)
  {
    return (com.runwaysdk.system.metadata.ExceptionInheritanceDTO) clientRequestIF.addChild(id, child.getId(), com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  public void removeChildExceptions(com.runwaysdk.system.metadata.ExceptionInheritanceDTO relationship)
  {
    getRequest().deleteChild(relationship.getId());
  }
  
  public static void removeChildExceptions(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.ExceptionInheritanceDTO relationship)
  {
    clientRequestIF.deleteChild(relationship.getId());
  }
  
  public void removeAllChildExceptions()
  {
    getRequest().deleteChildren(this.getId(), com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  public static void removeAllChildExceptions(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteChildren(id, com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdExceptionDTO> getAllParentException()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdExceptionDTO>) getRequest().getParents(this.getId(), com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdExceptionDTO> getAllParentException(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdExceptionDTO>) clientRequestIF.getParents(id, com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.ExceptionInheritanceDTO> getAllParentExceptionRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.ExceptionInheritanceDTO>) getRequest().getParentRelationships(this.getId(), com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.ExceptionInheritanceDTO> getAllParentExceptionRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.ExceptionInheritanceDTO>) clientRequestIF.getParentRelationships(id, com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.ExceptionInheritanceDTO addParentException(com.runwaysdk.system.metadata.MdExceptionDTO parent)
  {
    return (com.runwaysdk.system.metadata.ExceptionInheritanceDTO) getRequest().addParent(parent.getId(), this.getId(), com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.ExceptionInheritanceDTO addParentException(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdExceptionDTO parent)
  {
    return (com.runwaysdk.system.metadata.ExceptionInheritanceDTO) clientRequestIF.addParent(parent.getId(), id, com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  public void removeParentException(com.runwaysdk.system.metadata.ExceptionInheritanceDTO relationship)
  {
    getRequest().deleteParent(relationship.getId());
  }
  
  public static void removeParentException(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.ExceptionInheritanceDTO relationship)
  {
    clientRequestIF.deleteParent(relationship.getId());
  }
  
  public void removeAllParentException()
  {
    getRequest().deleteParents(this.getId(), com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  public static void removeAllParentException(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteParents(id, com.runwaysdk.system.metadata.ExceptionInheritanceDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.MdExceptionDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.metadata.MdExceptionDTO) dto;
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
  
  public static com.runwaysdk.system.metadata.MdExceptionQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.metadata.MdExceptionQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.metadata.MdExceptionDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdExceptionDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdExceptionDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdExceptionDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdExceptionDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdExceptionDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdExceptionDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}
