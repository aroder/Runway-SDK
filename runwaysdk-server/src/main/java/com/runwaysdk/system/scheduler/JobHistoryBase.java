package com.runwaysdk.system.scheduler;

@com.runwaysdk.business.ClassSignature(hash = -1591301675)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to JobHistory.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class JobHistoryBase extends com.runwaysdk.business.Business
{
  public final static String CLASS = "com.runwaysdk.system.scheduler.JobHistory";
  public static java.lang.String CREATEDATE = "createDate";
  public static java.lang.String CREATEDBY = "createdBy";
  public static java.lang.String ENDTIME = "endTime";
  public static java.lang.String ENTITYDOMAIN = "entityDomain";
  public static java.lang.String HISTORYCOMMENT = "historyComment";
  private com.runwaysdk.business.Struct historyComment = null;
  
  public static java.lang.String HISTORYINFORMATION = "historyInformation";
  private com.runwaysdk.business.Struct historyInformation = null;
  
  public static java.lang.String ID = "id";
  public static java.lang.String KEYNAME = "keyName";
  public static java.lang.String LASTUPDATEDATE = "lastUpdateDate";
  public static java.lang.String LASTUPDATEDBY = "lastUpdatedBy";
  public static java.lang.String LOCKEDBY = "lockedBy";
  public static java.lang.String OWNER = "owner";
  public static java.lang.String RETRIES = "retries";
  public static java.lang.String SEQ = "seq";
  public static java.lang.String SITEMASTER = "siteMaster";
  public static java.lang.String STARTTIME = "startTime";
  public static java.lang.String STATUS = "status";
  public static java.lang.String TYPE = "type";
  public static java.lang.String WORKPROGRESS = "workProgress";
  private static final long serialVersionUID = -1591301675;
  
  public JobHistoryBase()
  {
    super();
    historyComment = super.getStruct("historyComment");
    historyInformation = super.getStruct("historyInformation");
  }
  
  public java.util.Date getCreateDate()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(CREATEDATE));
  }
  
  public void validateCreateDate()
  {
    this.validateAttribute(CREATEDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCreateDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(CREATEDATE);
  }
  
  public com.runwaysdk.system.SingleActor getCreatedBy()
  {
    if (getValue(CREATEDBY).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.SingleActor.get(getValue(CREATEDBY));
    }
  }
  
  public String getCreatedById()
  {
    return getValue(CREATEDBY);
  }
  
  public void validateCreatedBy()
  {
    this.validateAttribute(CREATEDBY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCreatedByMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(CREATEDBY);
  }
  
  public java.util.Date getEndTime()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(ENDTIME));
  }
  
  public void validateEndTime()
  {
    this.validateAttribute(ENDTIME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getEndTimeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(ENDTIME);
  }
  
  public void setEndTime(java.util.Date value)
  {
    if(value == null)
    {
      setValue(ENDTIME, "");
    }
    else
    {
      setValue(ENDTIME, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATETIME_FORMAT).format(value));
    }
  }
  
  public com.runwaysdk.system.metadata.MdDomain getEntityDomain()
  {
    if (getValue(ENTITYDOMAIN).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdDomain.get(getValue(ENTITYDOMAIN));
    }
  }
  
  public String getEntityDomainId()
  {
    return getValue(ENTITYDOMAIN);
  }
  
  public void validateEntityDomain()
  {
    this.validateAttribute(ENTITYDOMAIN);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getEntityDomainMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(ENTITYDOMAIN);
  }
  
  public void setEntityDomain(com.runwaysdk.system.metadata.MdDomain value)
  {
    if(value == null)
    {
      setValue(ENTITYDOMAIN, "");
    }
    else
    {
      setValue(ENTITYDOMAIN, value.getId());
    }
  }
  
  public com.runwaysdk.system.scheduler.JobHistoryHistoryComment getHistoryComment()
  {
    return (com.runwaysdk.system.scheduler.JobHistoryHistoryComment) historyComment;
  }
  
  public void validateHistoryComment()
  {
    this.validateAttribute(HISTORYCOMMENT);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getHistoryCommentMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(HISTORYCOMMENT);
  }
  
  public com.runwaysdk.system.scheduler.JobHistoryHistoryInformation getHistoryInformation()
  {
    return (com.runwaysdk.system.scheduler.JobHistoryHistoryInformation) historyInformation;
  }
  
  public void validateHistoryInformation()
  {
    this.validateAttribute(HISTORYINFORMATION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getHistoryInformationMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(HISTORYINFORMATION);
  }
  
  public String getId()
  {
    return getValue(ID);
  }
  
  public void validateId()
  {
    this.validateAttribute(ID);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getIdMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(ID);
  }
  
  public String getKeyName()
  {
    return getValue(KEYNAME);
  }
  
  public void validateKeyName()
  {
    this.validateAttribute(KEYNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getKeyNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(KEYNAME);
  }
  
  public void setKeyName(String value)
  {
    if(value == null)
    {
      setValue(KEYNAME, "");
    }
    else
    {
      setValue(KEYNAME, value);
    }
  }
  
  public java.util.Date getLastUpdateDate()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(LASTUPDATEDATE));
  }
  
  public void validateLastUpdateDate()
  {
    this.validateAttribute(LASTUPDATEDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getLastUpdateDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(LASTUPDATEDATE);
  }
  
  public com.runwaysdk.system.SingleActor getLastUpdatedBy()
  {
    if (getValue(LASTUPDATEDBY).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.SingleActor.get(getValue(LASTUPDATEDBY));
    }
  }
  
  public String getLastUpdatedById()
  {
    return getValue(LASTUPDATEDBY);
  }
  
  public void validateLastUpdatedBy()
  {
    this.validateAttribute(LASTUPDATEDBY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getLastUpdatedByMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(LASTUPDATEDBY);
  }
  
  public com.runwaysdk.system.Users getLockedBy()
  {
    if (getValue(LOCKEDBY).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.Users.get(getValue(LOCKEDBY));
    }
  }
  
  public String getLockedById()
  {
    return getValue(LOCKEDBY);
  }
  
  public void validateLockedBy()
  {
    this.validateAttribute(LOCKEDBY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getLockedByMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(LOCKEDBY);
  }
  
  public com.runwaysdk.system.Actor getOwner()
  {
    if (getValue(OWNER).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.Actor.get(getValue(OWNER));
    }
  }
  
  public String getOwnerId()
  {
    return getValue(OWNER);
  }
  
  public void validateOwner()
  {
    this.validateAttribute(OWNER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getOwnerMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(OWNER);
  }
  
  public void setOwner(com.runwaysdk.system.Actor value)
  {
    if(value == null)
    {
      setValue(OWNER, "");
    }
    else
    {
      setValue(OWNER, value.getId());
    }
  }
  
  public Integer getRetries()
  {
    return com.runwaysdk.constants.MdAttributeIntegerUtil.getTypeSafeValue(getValue(RETRIES));
  }
  
  public void validateRetries()
  {
    this.validateAttribute(RETRIES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getRetriesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(RETRIES);
  }
  
  public void setRetries(Integer value)
  {
    if(value == null)
    {
      setValue(RETRIES, "");
    }
    else
    {
      setValue(RETRIES, java.lang.Integer.toString(value));
    }
  }
  
  public Long getSeq()
  {
    return com.runwaysdk.constants.MdAttributeLongUtil.getTypeSafeValue(getValue(SEQ));
  }
  
  public void validateSeq()
  {
    this.validateAttribute(SEQ);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSeqMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(SEQ);
  }
  
  public String getSiteMaster()
  {
    return getValue(SITEMASTER);
  }
  
  public void validateSiteMaster()
  {
    this.validateAttribute(SITEMASTER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSiteMasterMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(SITEMASTER);
  }
  
  public java.util.Date getStartTime()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(STARTTIME));
  }
  
  public void validateStartTime()
  {
    this.validateAttribute(STARTTIME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getStartTimeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(STARTTIME);
  }
  
  public void setStartTime(java.util.Date value)
  {
    if(value == null)
    {
      setValue(STARTTIME, "");
    }
    else
    {
      setValue(STARTTIME, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATETIME_FORMAT).format(value));
    }
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<com.runwaysdk.system.scheduler.AllJobStatus> getStatus()
  {
    return (java.util.List<com.runwaysdk.system.scheduler.AllJobStatus>) getEnumValues(STATUS);
  }
  
  public void addStatus(com.runwaysdk.system.scheduler.AllJobStatus value)
  {
    if(value != null)
    {
      addEnumItem(STATUS, value.getId());
    }
  }
  
  public void removeStatus(com.runwaysdk.system.scheduler.AllJobStatus value)
  {
    if(value != null)
    {
      removeEnumItem(STATUS, value.getId());
    }
  }
  
  public void clearStatus()
  {
    clearEnum(STATUS);
  }
  
  public void validateStatus()
  {
    this.validateAttribute(STATUS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getStatusMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(STATUS);
  }
  
  public String getType()
  {
    return getValue(TYPE);
  }
  
  public void validateType()
  {
    this.validateAttribute(TYPE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getTypeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(TYPE);
  }
  
  public Integer getWorkProgress()
  {
    return com.runwaysdk.constants.MdAttributeIntegerUtil.getTypeSafeValue(getValue(WORKPROGRESS));
  }
  
  public void validateWorkProgress()
  {
    this.validateAttribute(WORKPROGRESS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getWorkProgressMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.JobHistory.CLASS);
    return mdClassIF.definesAttribute(WORKPROGRESS);
  }
  
  public void setWorkProgress(Integer value)
  {
    if(value == null)
    {
      setValue(WORKPROGRESS, "");
    }
    else
    {
      setValue(WORKPROGRESS, java.lang.Integer.toString(value));
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.scheduler.JobHistoryRecord addJob(com.runwaysdk.system.scheduler.ExecutableJob executableJob)
  {
    return (com.runwaysdk.system.scheduler.JobHistoryRecord) addParent(executableJob, com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
  }
  
  public void removeJob(com.runwaysdk.system.scheduler.ExecutableJob executableJob)
  {
    removeAllParents(executableJob, com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.scheduler.ExecutableJob> getAllJob()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.scheduler.ExecutableJob>) getParents(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.scheduler.JobHistoryRecord> getAllJobRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.scheduler.JobHistoryRecord>) getParentRelationships(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.scheduler.JobHistoryRecord> getJobRel(com.runwaysdk.system.scheduler.ExecutableJob executableJob)
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.scheduler.JobHistoryRecord>) getRelationshipsWithParent(executableJob, com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
  }
  
  public static JobHistory get(String id)
  {
    return (JobHistory) com.runwaysdk.business.Business.get(id);
  }
  
  public static JobHistory getByKey(String key)
  {
    return (JobHistory) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static void clearHistory()
  {
    String msg = "This method should never be invoked.  It should be overwritten in com.runwaysdk.system.scheduler.JobHistory.java";
    throw new com.runwaysdk.dataaccess.metadata.ForbiddenMethodException(msg);
  }
  
  public static JobHistory lock(java.lang.String id)
  {
    JobHistory _instance = JobHistory.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static JobHistory unlock(java.lang.String id)
  {
    JobHistory _instance = JobHistory.get(id);
    _instance.unlock();
    
    return _instance;
  }
  
  public String toString()
  {
    if (this.isNew())
    {
      return "New: "+ this.getClassDisplayLabel();
    }
    else
    {
      return super.toString();
    }
  }
}
