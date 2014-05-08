package com.runwaysdk.system.scheduler;

@com.runwaysdk.business.ClassSignature(hash = 1761184687)
public abstract class QualifiedTypeJobDTOBase extends com.runwaysdk.system.scheduler.ExecutableJobDTO
{
  public final static String CLASS = "com.runwaysdk.system.scheduler.QualifiedTypeJob";
  private static final long serialVersionUID = 1761184687;
  
  protected QualifiedTypeJobDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected QualifiedTypeJobDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  public static java.lang.String CLASSNAME = "className";
  public String getClassName()
  {
    return getValue(CLASSNAME);
  }
  
  public void setClassName(String value)
  {
    if(value == null)
    {
      setValue(CLASSNAME, "");
    }
    else
    {
      setValue(CLASSNAME, value);
    }
  }
  
  public boolean isClassNameWritable()
  {
    return isWritable(CLASSNAME);
  }
  
  public boolean isClassNameReadable()
  {
    return isReadable(CLASSNAME);
  }
  
  public boolean isClassNameModified()
  {
    return isModified(CLASSNAME);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeCharacterMdDTO getClassNameMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeCharacterMdDTO) getAttributeDTO(CLASSNAME).getAttributeMdDTO();
  }
  
  public static com.runwaysdk.system.scheduler.QualifiedTypeJobDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.scheduler.QualifiedTypeJobDTO) dto;
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
  
  public static com.runwaysdk.system.scheduler.QualifiedTypeJobQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.scheduler.QualifiedTypeJobQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.scheduler.QualifiedTypeJobDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.scheduler.QualifiedTypeJobDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.QualifiedTypeJobDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.scheduler.QualifiedTypeJobDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.scheduler.QualifiedTypeJobDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.QualifiedTypeJobDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.scheduler.QualifiedTypeJobDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}
