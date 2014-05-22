package com.runwaysdk.system.scheduler;

@com.runwaysdk.business.ClassSignature(hash = 1006477827)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to AbstractJob.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class AbstractJobBase extends com.runwaysdk.business.Business
{
  public final static String CLASS = "com.runwaysdk.system.scheduler.AbstractJob";
  public static java.lang.String CANCELABLE = "cancelable";
  public static java.lang.String CANCELED = "canceled";
  public static java.lang.String COMPLETED = "completed";
  public static java.lang.String CREATEDATE = "createDate";
  public static java.lang.String CREATEDBY = "createdBy";
  public static java.lang.String CRONEXPRESSION = "cronExpression";
  public static java.lang.String ENDTIME = "endTime";
  public static java.lang.String ENTITYDOMAIN = "entityDomain";
  public static java.lang.String ID = "id";
  public static java.lang.String JOBOPERATION = "jobOperation";
  public static java.lang.String KEYNAME = "keyName";
  public static java.lang.String LASTRUN = "lastRun";
  public static java.lang.String LASTUPDATEDATE = "lastUpdateDate";
  public static java.lang.String LASTUPDATEDBY = "lastUpdatedBy";
  public static java.lang.String LOCKEDBY = "lockedBy";
  public static java.lang.String MAXRETRIES = "maxRetries";
  public static java.lang.String OWNER = "owner";
  public static java.lang.String PAUSEABLE = "pauseable";
  public static java.lang.String PAUSED = "paused";
  public static java.lang.String REMOVEONCOMPLETE = "removeOnComplete";
  public static java.lang.String REPEATED = "repeated";
  public static java.lang.String RETRIES = "retries";
  public static java.lang.String RUNNING = "running";
  public static java.lang.String SEQ = "seq";
  public static java.lang.String SITEMASTER = "siteMaster";
  public static java.lang.String STARTONCREATE = "startOnCreate";
  public static java.lang.String STARTTIME = "startTime";
  public static java.lang.String TIMEOUT = "timeout";
  public static java.lang.String TYPE = "type";
  public static java.lang.String WORKPROGRESS = "workProgress";
  public static java.lang.String WORKTOTAL = "workTotal";
  private static final long serialVersionUID = 1006477827;
  
  public AbstractJobBase()
  {
    super();
  }
  
  public Boolean getCancelable()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(CANCELABLE));
  }
  
  public void validateCancelable()
  {
    this.validateAttribute(CANCELABLE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCancelableMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(CANCELABLE);
  }
  
  public void setCancelable(Boolean value)
  {
    if(value == null)
    {
      setValue(CANCELABLE, "");
    }
    else
    {
      setValue(CANCELABLE, java.lang.Boolean.toString(value));
    }
  }
  
  public Boolean getCanceled()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(CANCELED));
  }
  
  public void validateCanceled()
  {
    this.validateAttribute(CANCELED);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCanceledMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(CANCELED);
  }
  
  public void setCanceled(Boolean value)
  {
    if(value == null)
    {
      setValue(CANCELED, "");
    }
    else
    {
      setValue(CANCELED, java.lang.Boolean.toString(value));
    }
  }
  
  public Boolean getCompleted()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(COMPLETED));
  }
  
  public void validateCompleted()
  {
    this.validateAttribute(COMPLETED);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCompletedMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(COMPLETED);
  }
  
  public void setCompleted(Boolean value)
  {
    if(value == null)
    {
      setValue(COMPLETED, "");
    }
    else
    {
      setValue(COMPLETED, java.lang.Boolean.toString(value));
    }
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(CREATEDBY);
  }
  
  public String getCronExpression()
  {
    return getValue(CRONEXPRESSION);
  }
  
  public void validateCronExpression()
  {
    this.validateAttribute(CRONEXPRESSION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCronExpressionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(CRONEXPRESSION);
  }
  
  public void setCronExpression(String value)
  {
    if(value == null)
    {
      setValue(CRONEXPRESSION, "");
    }
    else
    {
      setValue(CRONEXPRESSION, value);
    }
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(ID);
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<com.runwaysdk.system.scheduler.AllJobOperation> getJobOperation()
  {
    return (java.util.List<com.runwaysdk.system.scheduler.AllJobOperation>) getEnumValues(JOBOPERATION);
  }
  
  public void addJobOperation(com.runwaysdk.system.scheduler.AllJobOperation value)
  {
    if(value != null)
    {
      addEnumItem(JOBOPERATION, value.getId());
    }
  }
  
  public void removeJobOperation(com.runwaysdk.system.scheduler.AllJobOperation value)
  {
    if(value != null)
    {
      removeEnumItem(JOBOPERATION, value.getId());
    }
  }
  
  public void clearJobOperation()
  {
    clearEnum(JOBOPERATION);
  }
  
  public void validateJobOperation()
  {
    this.validateAttribute(JOBOPERATION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getJobOperationMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(JOBOPERATION);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
  
  public java.util.Date getLastRun()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(LASTRUN));
  }
  
  public void validateLastRun()
  {
    this.validateAttribute(LASTRUN);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getLastRunMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(LASTRUN);
  }
  
  public void setLastRun(java.util.Date value)
  {
    if(value == null)
    {
      setValue(LASTRUN, "");
    }
    else
    {
      setValue(LASTRUN, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATETIME_FORMAT).format(value));
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(LOCKEDBY);
  }
  
  public Integer getMaxRetries()
  {
    return com.runwaysdk.constants.MdAttributeIntegerUtil.getTypeSafeValue(getValue(MAXRETRIES));
  }
  
  public void validateMaxRetries()
  {
    this.validateAttribute(MAXRETRIES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getMaxRetriesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(MAXRETRIES);
  }
  
  public void setMaxRetries(Integer value)
  {
    if(value == null)
    {
      setValue(MAXRETRIES, "");
    }
    else
    {
      setValue(MAXRETRIES, java.lang.Integer.toString(value));
    }
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
  
  public Boolean getPauseable()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(PAUSEABLE));
  }
  
  public void validatePauseable()
  {
    this.validateAttribute(PAUSEABLE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getPauseableMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(PAUSEABLE);
  }
  
  public void setPauseable(Boolean value)
  {
    if(value == null)
    {
      setValue(PAUSEABLE, "");
    }
    else
    {
      setValue(PAUSEABLE, java.lang.Boolean.toString(value));
    }
  }
  
  public Boolean getPaused()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(PAUSED));
  }
  
  public void validatePaused()
  {
    this.validateAttribute(PAUSED);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getPausedMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(PAUSED);
  }
  
  public void setPaused(Boolean value)
  {
    if(value == null)
    {
      setValue(PAUSED, "");
    }
    else
    {
      setValue(PAUSED, java.lang.Boolean.toString(value));
    }
  }
  
  public Boolean getRemoveOnComplete()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(REMOVEONCOMPLETE));
  }
  
  public void validateRemoveOnComplete()
  {
    this.validateAttribute(REMOVEONCOMPLETE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getRemoveOnCompleteMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(REMOVEONCOMPLETE);
  }
  
  public void setRemoveOnComplete(Boolean value)
  {
    if(value == null)
    {
      setValue(REMOVEONCOMPLETE, "");
    }
    else
    {
      setValue(REMOVEONCOMPLETE, java.lang.Boolean.toString(value));
    }
  }
  
  public Boolean getRepeated()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(REPEATED));
  }
  
  public void validateRepeated()
  {
    this.validateAttribute(REPEATED);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getRepeatedMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(REPEATED);
  }
  
  public void setRepeated(Boolean value)
  {
    if(value == null)
    {
      setValue(REPEATED, "");
    }
    else
    {
      setValue(REPEATED, java.lang.Boolean.toString(value));
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
  
  public Boolean getRunning()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(RUNNING));
  }
  
  public void validateRunning()
  {
    this.validateAttribute(RUNNING);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getRunningMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(RUNNING);
  }
  
  public void setRunning(Boolean value)
  {
    if(value == null)
    {
      setValue(RUNNING, "");
    }
    else
    {
      setValue(RUNNING, java.lang.Boolean.toString(value));
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(SITEMASTER);
  }
  
  public Boolean getStartOnCreate()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(STARTONCREATE));
  }
  
  public void validateStartOnCreate()
  {
    this.validateAttribute(STARTONCREATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getStartOnCreateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(STARTONCREATE);
  }
  
  public void setStartOnCreate(Boolean value)
  {
    if(value == null)
    {
      setValue(STARTONCREATE, "");
    }
    else
    {
      setValue(STARTONCREATE, java.lang.Boolean.toString(value));
    }
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
  
  public Long getTimeout()
  {
    return com.runwaysdk.constants.MdAttributeLongUtil.getTypeSafeValue(getValue(TIMEOUT));
  }
  
  public void validateTimeout()
  {
    this.validateAttribute(TIMEOUT);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getTimeoutMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(TIMEOUT);
  }
  
  public void setTimeout(Long value)
  {
    if(value == null)
    {
      setValue(TIMEOUT, "");
    }
    else
    {
      setValue(TIMEOUT, java.lang.Long.toString(value));
    }
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
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
  
  public Integer getWorkTotal()
  {
    return com.runwaysdk.constants.MdAttributeIntegerUtil.getTypeSafeValue(getValue(WORKTOTAL));
  }
  
  public void validateWorkTotal()
  {
    this.validateAttribute(WORKTOTAL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getWorkTotalMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.scheduler.AbstractJob.CLASS);
    return mdClassIF.definesAttribute(WORKTOTAL);
  }
  
  public void setWorkTotal(Integer value)
  {
    if(value == null)
    {
      setValue(WORKTOTAL, "");
    }
    else
    {
      setValue(WORKTOTAL, java.lang.Integer.toString(value));
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static AbstractJob get(String id)
  {
    return (AbstractJob) com.runwaysdk.business.Business.get(id);
  }
  
  public static AbstractJob getByKey(String key)
  {
    return (AbstractJob) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static AbstractJob lock(java.lang.String id)
  {
    AbstractJob _instance = AbstractJob.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static AbstractJob unlock(java.lang.String id)
  {
    AbstractJob _instance = AbstractJob.get(id);
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
