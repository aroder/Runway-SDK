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

@com.runwaysdk.business.ClassSignature(hash = 2043568342)
public abstract class MdFormDTOBase extends com.runwaysdk.system.metadata.MdTypeDTO
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdForm";
  private static final long serialVersionUID = 2043568342;
  
  protected MdFormDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected MdFormDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  public static java.lang.String FORMMDCLASS = "formMdClass";
  public static java.lang.String FORMNAME = "formName";
  public com.runwaysdk.system.metadata.MdClassDTO getFormMdClass()
  {
    if(getValue(FORMMDCLASS) == null || getValue(FORMMDCLASS).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdClassDTO.get(getRequest(), getValue(FORMMDCLASS));
    }
  }
  
  public String getFormMdClassId()
  {
    return getValue(FORMMDCLASS);
  }
  
  public void setFormMdClass(com.runwaysdk.system.metadata.MdClassDTO value)
  {
    if(value == null)
    {
      setValue(FORMMDCLASS, "");
    }
    else
    {
      setValue(FORMMDCLASS, value.getId());
    }
  }
  
  public boolean isFormMdClassWritable()
  {
    return isWritable(FORMMDCLASS);
  }
  
  public boolean isFormMdClassReadable()
  {
    return isReadable(FORMMDCLASS);
  }
  
  public boolean isFormMdClassModified()
  {
    return isModified(FORMMDCLASS);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeReferenceMdDTO getFormMdClassMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeReferenceMdDTO) getAttributeDTO(FORMMDCLASS).getAttributeMdDTO();
  }
  
  public String getFormName()
  {
    return getValue(FORMNAME);
  }
  
  public void setFormName(String value)
  {
    if(value == null)
    {
      setValue(FORMNAME, "");
    }
    else
    {
      setValue(FORMNAME, value);
    }
  }
  
  public boolean isFormNameWritable()
  {
    return isWritable(FORMNAME);
  }
  
  public boolean isFormNameReadable()
  {
    return isReadable(FORMNAME);
  }
  
  public boolean isFormNameModified()
  {
    return isModified(FORMNAME);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeCharacterMdDTO getFormNameMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeCharacterMdDTO) getAttributeDTO(FORMNAME).getAttributeMdDTO();
  }
  
  public final com.runwaysdk.system.metadata.MdFieldDTO[] getOrderedMdFields()
  {
    String[] _declaredTypes = new String[]{};
    Object[] _parameters = new Object[]{};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdFormDTO.CLASS, "getOrderedMdFields", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdFieldDTO[]) getRequest().invokeMethod(_metadata, this, _parameters);
  }
  
  public static final com.runwaysdk.system.metadata.MdFieldDTO[] getOrderedMdFields(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdFormDTO.CLASS, "getOrderedMdFields", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdFieldDTO[]) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.MdFieldDTO> getAllMdFields()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdFieldDTO>) getRequest().getChildren(this.getId(), com.runwaysdk.system.metadata.FormFieldDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.MdFieldDTO> getAllMdFields(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.MdFieldDTO>) clientRequestIF.getChildren(id, com.runwaysdk.system.metadata.FormFieldDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.metadata.FormFieldDTO> getAllMdFieldsRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.FormFieldDTO>) getRequest().getChildRelationships(this.getId(), com.runwaysdk.system.metadata.FormFieldDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.metadata.FormFieldDTO> getAllMdFieldsRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.metadata.FormFieldDTO>) clientRequestIF.getChildRelationships(id, com.runwaysdk.system.metadata.FormFieldDTO.CLASS);
  }
  
  public com.runwaysdk.system.metadata.FormFieldDTO addMdFields(com.runwaysdk.system.metadata.MdFieldDTO child)
  {
    return (com.runwaysdk.system.metadata.FormFieldDTO) getRequest().addChild(this.getId(), child.getId(), com.runwaysdk.system.metadata.FormFieldDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.FormFieldDTO addMdFields(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.metadata.MdFieldDTO child)
  {
    return (com.runwaysdk.system.metadata.FormFieldDTO) clientRequestIF.addChild(id, child.getId(), com.runwaysdk.system.metadata.FormFieldDTO.CLASS);
  }
  
  public void removeMdFields(com.runwaysdk.system.metadata.FormFieldDTO relationship)
  {
    getRequest().deleteChild(relationship.getId());
  }
  
  public static void removeMdFields(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.metadata.FormFieldDTO relationship)
  {
    clientRequestIF.deleteChild(relationship.getId());
  }
  
  public void removeAllMdFields()
  {
    getRequest().deleteChildren(this.getId(), com.runwaysdk.system.metadata.FormFieldDTO.CLASS);
  }
  
  public static void removeAllMdFields(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteChildren(id, com.runwaysdk.system.metadata.FormFieldDTO.CLASS);
  }
  
  public static com.runwaysdk.system.metadata.MdFormDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.metadata.MdFormDTO) dto;
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
  
  public static com.runwaysdk.system.metadata.MdFormQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.metadata.MdFormQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.metadata.MdFormDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdFormDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdFormDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdFormDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdFormDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdFormDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdFormDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}
