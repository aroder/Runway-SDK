package com.runwaysdk.system.scheduler;

@com.runwaysdk.business.ClassSignature(hash = 1106864153)
public abstract class ExecutableJobDTOBase extends com.runwaysdk.system.scheduler.AbstractJobDTO
{
  public final static String CLASS = "com.runwaysdk.system.scheduler.ExecutableJob";
  private static final long serialVersionUID = 1106864153;
  
  protected ExecutableJobDTOBase(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected ExecutableJobDTOBase(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
  protected java.lang.String getDeclaredType()
  {
    return CLASS;
  }
  
  public static java.lang.String DESCRIPTION = "description";
  public static java.lang.String ENTRYDATE = "entryDate";
  public static java.lang.String JOBID = "jobId";
  public static java.lang.String RECORDHISTORY = "recordHistory";
  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionDTO getDescription()
  {
    return (com.runwaysdk.system.scheduler.ExecutableJobDescriptionDTO) this.getAttributeStructDTO(DESCRIPTION).getStructDTO();
  }
  
  public boolean isDescriptionWritable()
  {
    return isWritable(DESCRIPTION);
  }
  
  public boolean isDescriptionReadable()
  {
    return isReadable(DESCRIPTION);
  }
  
  public boolean isDescriptionModified()
  {
    return isModified(DESCRIPTION);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeLocalCharacterMdDTO getDescriptionMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeLocalCharacterMdDTO) getAttributeDTO(DESCRIPTION).getAttributeMdDTO();
  }
  
  public java.util.Date getEntryDate()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(ENTRYDATE));
  }
  
  public void setEntryDate(java.util.Date value)
  {
    if(value == null)
    {
      setValue(ENTRYDATE, "");
    }
    else
    {
      setValue(ENTRYDATE, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATETIME_FORMAT).format(value));
    }
  }
  
  public boolean isEntryDateWritable()
  {
    return isWritable(ENTRYDATE);
  }
  
  public boolean isEntryDateReadable()
  {
    return isReadable(ENTRYDATE);
  }
  
  public boolean isEntryDateModified()
  {
    return isModified(ENTRYDATE);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeDateTimeMdDTO getEntryDateMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeDateTimeMdDTO) getAttributeDTO(ENTRYDATE).getAttributeMdDTO();
  }
  
  public String getJobId()
  {
    return getValue(JOBID);
  }
  
  public void setJobId(String value)
  {
    if(value == null)
    {
      setValue(JOBID, "");
    }
    else
    {
      setValue(JOBID, value);
    }
  }
  
  public boolean isJobIdWritable()
  {
    return isWritable(JOBID);
  }
  
  public boolean isJobIdReadable()
  {
    return isReadable(JOBID);
  }
  
  public boolean isJobIdModified()
  {
    return isModified(JOBID);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeCharacterMdDTO getJobIdMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeCharacterMdDTO) getAttributeDTO(JOBID).getAttributeMdDTO();
  }
  
  public Boolean getRecordHistory()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(RECORDHISTORY));
  }
  
  public void setRecordHistory(Boolean value)
  {
    if(value == null)
    {
      setValue(RECORDHISTORY, "");
    }
    else
    {
      setValue(RECORDHISTORY, java.lang.Boolean.toString(value));
    }
  }
  
  public boolean isRecordHistoryWritable()
  {
    return isWritable(RECORDHISTORY);
  }
  
  public boolean isRecordHistoryReadable()
  {
    return isReadable(RECORDHISTORY);
  }
  
  public boolean isRecordHistoryModified()
  {
    return isModified(RECORDHISTORY);
  }
  
  public final com.runwaysdk.transport.metadata.AttributeBooleanMdDTO getRecordHistoryMd()
  {
    return (com.runwaysdk.transport.metadata.AttributeBooleanMdDTO) getAttributeDTO(RECORDHISTORY).getAttributeMdDTO();
  }
  
  public final void cancel()
  {
    String[] _declaredTypes = new String[]{};
    Object[] _parameters = new Object[]{};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "cancel", _declaredTypes);
    getRequest().invokeMethod(_metadata, this, _parameters);
  }
  
  public static final void cancel(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "cancel", _declaredTypes);
    clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public final void pause()
  {
    String[] _declaredTypes = new String[]{};
    Object[] _parameters = new Object[]{};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "pause", _declaredTypes);
    getRequest().invokeMethod(_metadata, this, _parameters);
  }
  
  public static final void pause(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "pause", _declaredTypes);
    clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public final void resume()
  {
    String[] _declaredTypes = new String[]{};
    Object[] _parameters = new Object[]{};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "resume", _declaredTypes);
    getRequest().invokeMethod(_metadata, this, _parameters);
  }
  
  public static final void resume(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "resume", _declaredTypes);
    clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public final void start()
  {
    String[] _declaredTypes = new String[]{};
    Object[] _parameters = new Object[]{};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "start", _declaredTypes);
    getRequest().invokeMethod(_metadata, this, _parameters);
  }
  
  public static final void start(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "start", _declaredTypes);
    clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public final void stop()
  {
    String[] _declaredTypes = new String[]{};
    Object[] _parameters = new Object[]{};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "stop", _declaredTypes);
    getRequest().invokeMethod(_metadata, this, _parameters);
  }
  
  public static final void stop(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "stop", _declaredTypes);
    clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.scheduler.JobHistoryDTO> getAllJobHistory()
  {
    return (java.util.List<? extends com.runwaysdk.system.scheduler.JobHistoryDTO>) getRequest().getChildren(this.getId(), com.runwaysdk.system.scheduler.JobHistoryRecordDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.scheduler.JobHistoryDTO> getAllJobHistory(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.scheduler.JobHistoryDTO>) clientRequestIF.getChildren(id, com.runwaysdk.system.scheduler.JobHistoryRecordDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<? extends com.runwaysdk.system.scheduler.JobHistoryRecordDTO> getAllJobHistoryRelationships()
  {
    return (java.util.List<? extends com.runwaysdk.system.scheduler.JobHistoryRecordDTO>) getRequest().getChildRelationships(this.getId(), com.runwaysdk.system.scheduler.JobHistoryRecordDTO.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public static java.util.List<? extends com.runwaysdk.system.scheduler.JobHistoryRecordDTO> getAllJobHistoryRelationships(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    return (java.util.List<? extends com.runwaysdk.system.scheduler.JobHistoryRecordDTO>) clientRequestIF.getChildRelationships(id, com.runwaysdk.system.scheduler.JobHistoryRecordDTO.CLASS);
  }
  
  public com.runwaysdk.system.scheduler.JobHistoryRecordDTO addJobHistory(com.runwaysdk.system.scheduler.JobHistoryDTO child)
  {
    return (com.runwaysdk.system.scheduler.JobHistoryRecordDTO) getRequest().addChild(this.getId(), child.getId(), com.runwaysdk.system.scheduler.JobHistoryRecordDTO.CLASS);
  }
  
  public static com.runwaysdk.system.scheduler.JobHistoryRecordDTO addJobHistory(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id, com.runwaysdk.system.scheduler.JobHistoryDTO child)
  {
    return (com.runwaysdk.system.scheduler.JobHistoryRecordDTO) clientRequestIF.addChild(id, child.getId(), com.runwaysdk.system.scheduler.JobHistoryRecordDTO.CLASS);
  }
  
  public void removeJobHistory(com.runwaysdk.system.scheduler.JobHistoryRecordDTO relationship)
  {
    getRequest().deleteChild(relationship.getId());
  }
  
  public static void removeJobHistory(com.runwaysdk.constants.ClientRequestIF clientRequestIF, com.runwaysdk.system.scheduler.JobHistoryRecordDTO relationship)
  {
    clientRequestIF.deleteChild(relationship.getId());
  }
  
  public void removeAllJobHistory()
  {
    getRequest().deleteChildren(this.getId(), com.runwaysdk.system.scheduler.JobHistoryRecordDTO.CLASS);
  }
  
  public static void removeAllJobHistory(com.runwaysdk.constants.ClientRequestIF clientRequestIF, String id)
  {
    clientRequestIF.deleteChildren(id, com.runwaysdk.system.scheduler.JobHistoryRecordDTO.CLASS);
  }
  
  public static com.runwaysdk.system.scheduler.ExecutableJobDTO get(com.runwaysdk.constants.ClientRequestIF clientRequest, String id)
  {
    com.runwaysdk.business.EntityDTO dto = (com.runwaysdk.business.EntityDTO)clientRequest.get(id);
    
    return (com.runwaysdk.system.scheduler.ExecutableJobDTO) dto;
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
  
  public static com.runwaysdk.system.scheduler.ExecutableJobQueryDTO getAllInstances(com.runwaysdk.constants.ClientRequestIF clientRequest, String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    return (com.runwaysdk.system.scheduler.ExecutableJobQueryDTO) clientRequest.getAllInstances(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, sortAttribute, ascending, pageSize, pageNumber);
  }
  
  public void lock()
  {
    getRequest().lock(this);
  }
  
  public static com.runwaysdk.system.scheduler.ExecutableJobDTO lock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "lock", _declaredTypes);
    return (com.runwaysdk.system.scheduler.ExecutableJobDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
  public void unlock()
  {
    getRequest().unlock(this);
  }
  
  public static com.runwaysdk.system.scheduler.ExecutableJobDTO unlock(com.runwaysdk.constants.ClientRequestIF clientRequest, java.lang.String id)
  {
    String[] _declaredTypes = new String[]{"java.lang.String"};
    Object[] _parameters = new Object[]{id};
    com.runwaysdk.business.MethodMetaData _metadata = new com.runwaysdk.business.MethodMetaData(com.runwaysdk.system.scheduler.ExecutableJobDTO.CLASS, "unlock", _declaredTypes);
    return (com.runwaysdk.system.scheduler.ExecutableJobDTO) clientRequest.invokeMethod(_metadata, null, _parameters);
  }
  
}
