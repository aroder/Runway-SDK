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

@com.runwaysdk.business.ClassSignature(hash = 615226145)
public abstract class MdStructDTOBase extends com.runwaysdk.system.metadata.MdEntityDTO
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdStruct";
  private static final long serialVersionUID = 615226145;
  
  protected MdStructDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected MdStructDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  public static java.lang.String CACHEALGORITHM = "cacheAlgorithm";
  @SuppressWarnings("unchecked")
  public java.util.List<com.runwaysdk.system.metadata.StructCacheDTO> getCacheAlgorithm()
  {
    return (java.util.List<com.runwaysdk.system.metadata.StructCacheDTO>) com.runwaysdk.transport.conversion.ConversionFacade.convertEnumDTOsFromEnumNames(getRequest(), com.runwaysdk.system.metadata.StructCacheDTO.CLASS, getEnumNames(CACHEALGORITHM));
  }
  
  public java.util.List<String> getCacheAlgorithmEnumNames()
  {
    return getEnumNames(CACHEALGORITHM);
  }
  
  public void addCacheAlgorithm(com.runwaysdk.system.metadata.StructCacheDTO enumDTO)
  {
    addEnumItem(CACHEALGORITHM, enumDTO.toString());
  }
  
  public void removeCacheAlgorithm(com.runwaysdk.system.metadata.StructCacheDTO enumDTO)
  {
    removeEnumItem(CACHEALGORITHM, enumDTO.toString());
  }
  
  public void clearCacheAlgorithm()
  {
    clearEnum(CACHEALGORITHM);
  }
  
  public boolean isCacheAlgorithmWritable()
  {
    return isWritable(CACHEALGORITHM);
  }
  
  public boolean isCacheAlgorithmReadable()
  {
    return isReadable(CACHEALGORITHM);
  }
  
  public boolean isCacheAlgorithmModified()
  {
    return isModified(CACHEALGORITHM);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeEnumerationMdDTO getCacheAlgorithmMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeEnumerationMdDTO) getAttributeDTO(CACHEALGORITHM).getAttributeMdDTO();
  }
  
  public static com.runwaysdk.system.metadata.MdStructDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.metadata.MdStructDTO) dto;
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
  
  public static com.runwaysdk.system.metadata.MdStructQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.metadata.MdStructQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.metadata.MdStructDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdStructDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdStructDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdStructDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.metadata.MdStructDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.metadata.MdStructDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.metadata.MdStructDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}
