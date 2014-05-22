package com.runwaysdk.system.ontology;

@com.runwaysdk.business.ClassSignature(hash = -1359064580)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to Classifier.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class ClassifierBase extends com.runwaysdk.business.ontology.Term
{
  private static final com.runwaysdk.business.ontology.OntologyStrategyIF strategy;
  static 
  {
    strategy =  com.runwaysdk.business.ontology.Term.assignStrategy("com.runwaysdk.system.ontology.Classifier");
  }
  public final static String CLASS = "com.runwaysdk.system.ontology.Classifier";
  public static java.lang.String CLASSIFIERID = "classifierId";
  public static java.lang.String CLASSIFIERPACKAGE = "classifierPackage";
  public static java.lang.String CREATEDATE = "createDate";
  public static java.lang.String CREATEDBY = "createdBy";
  public static java.lang.String DISPLAYLABEL = "displayLabel";
  private com.runwaysdk.business.Struct displayLabel = null;
  
  public static java.lang.String ENTITYDOMAIN = "entityDomain";
  public static java.lang.String ID = "id";
  public static java.lang.String KEYNAME = "keyName";
  public static java.lang.String LASTUPDATEDATE = "lastUpdateDate";
  public static java.lang.String LASTUPDATEDBY = "lastUpdatedBy";
  public static java.lang.String LOCKEDBY = "lockedBy";
  public static java.lang.String OWNER = "owner";
  public static java.lang.String SEQ = "seq";
  public static java.lang.String SITEMASTER = "siteMaster";
  public static java.lang.String TYPE = "type";
  private static final long serialVersionUID = -1359064580;
  
  public ClassifierBase()
  {
    super();
    displayLabel = super.getStruct("displayLabel");
  }
  
  public String getClassifierId()
  {
    return getValue(CLASSIFIERID);
  }
  
  public void validateClassifierId()
  {
    this.validateAttribute(CLASSIFIERID);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getClassifierIdMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
    return mdClassIF.definesAttribute(CLASSIFIERID);
  }
  
  public void setClassifierId(String value)
  {
    if(value == null)
    {
      setValue(CLASSIFIERID, "");
    }
    else
    {
      setValue(CLASSIFIERID, value);
    }
  }
  
  public String getClassifierPackage()
  {
    return getValue(CLASSIFIERPACKAGE);
  }
  
  public void validateClassifierPackage()
  {
    this.validateAttribute(CLASSIFIERPACKAGE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getClassifierPackageMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
    return mdClassIF.definesAttribute(CLASSIFIERPACKAGE);
  }
  
  public void setClassifierPackage(String value)
  {
    if(value == null)
    {
      setValue(CLASSIFIERPACKAGE, "");
    }
    else
    {
      setValue(CLASSIFIERPACKAGE, value);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
    return mdClassIF.definesAttribute(CREATEDBY);
  }
  
  public com.runwaysdk.system.ontology.ClassifierDisplayLabel getDisplayLabel()
  {
    return (com.runwaysdk.system.ontology.ClassifierDisplayLabel) displayLabel;
  }
  
  public void validateDisplayLabel()
  {
    this.validateAttribute(DISPLAYLABEL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDisplayLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
    return mdClassIF.definesAttribute(DISPLAYLABEL);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
    return mdClassIF.definesAttribute(SITEMASTER);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.ontology.Classifier.CLASS);
    return mdClassIF.definesAttribute(TYPE);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.ontology.ClassifierIsARelationship addIsAChild(com.runwaysdk.system.ontology.Classifier classifier)
  {
    return (com.runwaysdk.system.ontology.ClassifierIsARelationship) addChild(classifier, com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
  }
  
  public void removeIsAChild(com.runwaysdk.system.ontology.Classifier classifier)
  {
    removeAllChildren(classifier, com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.Classifier> getAllIsAChild()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.Classifier>) getChildren(com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.ClassifierIsARelationship> getAllIsAChildRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.ClassifierIsARelationship>) getChildRelationships(com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.ontology.ClassifierIsARelationship getIsAChildRel(com.runwaysdk.system.ontology.Classifier classifier)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.ClassifierIsARelationship> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.ClassifierIsARelationship>) getRelationshipsWithChild(classifier, com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
    try
    {
      if (iterator.hasNext())
      {
        return iterator.next();
      }
      else
      {
        return null;
      }
    }
    finally
    {
      iterator.close();
    }
  }
  
  public com.runwaysdk.system.ontology.ClassifierIsARelationship addIsAParent(com.runwaysdk.system.ontology.Classifier classifier)
  {
    return (com.runwaysdk.system.ontology.ClassifierIsARelationship) addParent(classifier, com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
  }
  
  public void removeIsAParent(com.runwaysdk.system.ontology.Classifier classifier)
  {
    removeAllParents(classifier, com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.Classifier> getAllIsAParent()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.Classifier>) getParents(com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.ClassifierIsARelationship> getAllIsAParentRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.ClassifierIsARelationship>) getParentRelationships(com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.ontology.ClassifierIsARelationship getIsAParentRel(com.runwaysdk.system.ontology.Classifier classifier)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.ClassifierIsARelationship> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ontology.ClassifierIsARelationship>) getRelationshipsWithParent(classifier, com.runwaysdk.system.ontology.ClassifierIsARelationship.CLASS);
    try
    {
      if (iterator.hasNext())
      {
        return iterator.next();
      }
      else
      {
        return null;
      }
    }
    finally
    {
      iterator.close();
    }
  }
  
  public static Classifier get(String id)
  {
    return (Classifier) com.runwaysdk.business.Business.get(id);
  }
  
  public static Classifier getByKey(String key)
  {
    return (Classifier) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static com.runwaysdk.business.ontology.OntologyStrategyIF getStrategy()
  {
    return strategy;
  }
  
  public static com.runwaysdk.business.ontology.TermAndRel create(com.runwaysdk.system.ontology.Classifier dto, java.lang.String parentId)
  {
    String msg = "This method should never be invoked.  It should be overwritten in com.runwaysdk.system.ontology.Classifier.java";
    throw new com.runwaysdk.dataaccess.metadata.ForbiddenMethodException(msg);
  }
  
  public static com.runwaysdk.system.ontology.Classifier getRoot()
  {
    String msg = "This method should never be invoked.  It should be overwritten in com.runwaysdk.system.ontology.Classifier.java";
    throw new com.runwaysdk.dataaccess.metadata.ForbiddenMethodException(msg);
  }
  
  public static Classifier lock(java.lang.String id)
  {
    Classifier _instance = Classifier.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static Classifier unlock(java.lang.String id)
  {
    Classifier _instance = Classifier.get(id);
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
