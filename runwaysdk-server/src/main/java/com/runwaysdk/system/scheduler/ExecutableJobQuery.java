package com.runwaysdk.system.scheduler;

@com.runwaysdk.business.ClassSignature(hash = -1218765886)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to ExecutableJob.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class ExecutableJobQuery extends com.runwaysdk.system.scheduler.AbstractJobQuery

{

  public ExecutableJobQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public ExecutableJobQuery(com.runwaysdk.query.ValueQuery valueQuery)
  {
    super(valueQuery);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = new com.runwaysdk.business.BusinessQuery(valueQuery, this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public String getClassType()
  {
    return com.runwaysdk.system.scheduler.ExecutableJob.CLASS;
  }
  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription()
  {
    return getDescription(null);

  }
 
  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION);

    return (com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION);

    return (com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getEntryDate()
  {
    return getEntryDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getEntryDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.scheduler.ExecutableJob.ENTRYDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getEntryDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.scheduler.ExecutableJob.ENTRYDATE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getJobId()
  {
    return getJobId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getJobId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.scheduler.ExecutableJob.JOBID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getJobId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.scheduler.ExecutableJob.JOBID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getRecordHistory()
  {
    return getRecordHistory(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.scheduler.ExecutableJob.RECORDHISTORY, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.scheduler.ExecutableJob.RECORDHISTORY, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeLocal localFactory( com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdLocalStructDAOIF mdLocalStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION)) 
    {
       return new com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStruct((com.runwaysdk.dataaccess.MdAttributeLocalDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.localFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends ExecutableJob> getIterator()
  {
    this.checkNotUsedInValueQuery();
    String sqlStmt;
    if (_limit != null && _skip != null)
    {
      sqlStmt = this.getComponentQuery().getSQL(_limit, _skip);
    }
    else
    {
      sqlStmt = this.getComponentQuery().getSQL();
    }
    java.util.Map<String, com.runwaysdk.query.ColumnInfo> columnInfoMap = this.getComponentQuery().getColumnInfoMap();

    java.sql.ResultSet results = com.runwaysdk.dataaccess.database.Database.query(sqlStmt);
    return new com.runwaysdk.business.BusinessIterator<ExecutableJob>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


  public com.runwaysdk.query.Condition jobHistory()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_jobHistory()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition jobHistory(com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    return this.getBusinessQuery().isParentIn(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_jobHistory(com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    return this.getBusinessQuery().isParentIn_SUBSELECT(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(jobHistoryQuery));

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(jobHistoryQuery));

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    jobHistoryRecordQuery.AND(jobHistoryRecordQuery.hasChild(jobHistoryQuery));
    return this.getBusinessQuery().isParentIn(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    jobHistoryRecordQuery.AND(jobHistoryRecordQuery.hasChild(jobHistoryQuery));
    return this.getBusinessQuery().isParentIn_SUBSELECT(jobHistoryRecordQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_jobHistory()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    return this.getBusinessQuery().isNotParentIn(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(jobHistoryQuery));

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(jobHistoryQuery));

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    jobHistoryRecordQuery.AND(jobHistoryRecordQuery.hasChild(jobHistoryQuery));
    return this.getBusinessQuery().isNotParentIn(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    jobHistoryRecordQuery.AND(jobHistoryRecordQuery.hasChild(jobHistoryQuery));
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(jobHistoryRecordQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface ExecutableJobQueryReferenceIF extends com.runwaysdk.system.scheduler.AbstractJobQuery.AbstractJobQueryReferenceIF
  {

    public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription();
    public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias);
    public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableMoment getEntryDate();
    public com.runwaysdk.query.SelectableMoment getEntryDate(String alias);
    public com.runwaysdk.query.SelectableMoment getEntryDate(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getJobId();
    public com.runwaysdk.query.SelectableChar getJobId(String alias);
    public com.runwaysdk.query.SelectableChar getJobId(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBoolean getRecordHistory();
    public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias);
    public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.scheduler.ExecutableJob executableJob);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.scheduler.ExecutableJob executableJob);


  public com.runwaysdk.query.Condition jobHistory();

  public com.runwaysdk.query.Condition jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery);

  public com.runwaysdk.query.Condition jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery);


  public com.runwaysdk.query.Condition SUBSELECT_jobHistory();

  public com.runwaysdk.query.Condition SUBSELECT_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery);

  public com.runwaysdk.query.Condition SUBSELECT_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery);


  public com.runwaysdk.query.Condition NOT_IN_jobHistory();

  public com.runwaysdk.query.Condition NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery);

  public com.runwaysdk.query.Condition NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery);


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory();

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery);

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class ExecutableJobQueryReference extends com.runwaysdk.system.scheduler.AbstractJobQuery.AbstractJobQueryReference
 implements ExecutableJobQueryReferenceIF

  {

  public ExecutableJobQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.scheduler.ExecutableJob executableJob)
    {
      if(executableJob == null) return this.EQ((java.lang.String)null);
      return this.EQ(executableJob.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.scheduler.ExecutableJob executableJob)
    {
      if(executableJob == null) return this.NE((java.lang.String)null);
      return this.NE(executableJob.getId());
    }

  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription()
  {
    return getDescription(null);

  }
 
  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias)
  {
    return (com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF)this.attributeFactory(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION, com.runwaysdk.system.metadata.MdAttributeLocalCharacter.CLASS, alias, null);

  }
 
  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF)this.attributeFactory(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION, com.runwaysdk.system.metadata.MdAttributeLocalCharacter.CLASS, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getEntryDate()
  {
    return getEntryDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getEntryDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.scheduler.ExecutableJob.ENTRYDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getEntryDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.scheduler.ExecutableJob.ENTRYDATE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getJobId()
  {
    return getJobId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getJobId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.scheduler.ExecutableJob.JOBID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getJobId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.scheduler.ExecutableJob.JOBID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getRecordHistory()
  {
    return getRecordHistory(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.scheduler.ExecutableJob.RECORDHISTORY, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.scheduler.ExecutableJob.RECORDHISTORY, alias, displayLabel);

  }

  public com.runwaysdk.query.Condition jobHistory()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);

    return this.isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_jobHistory()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition jobHistory(com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    return this.isParentIn(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_jobHistory(com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    return this.isParentIn_SUBSELECT(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(jobHistoryQuery));

    return this.isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(jobHistoryQuery));

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    jobHistoryRecordQuery.AND(jobHistoryRecordQuery.hasChild(jobHistoryQuery));
    return this.isParentIn(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    jobHistoryRecordQuery.AND(jobHistoryRecordQuery.hasChild(jobHistoryQuery));
    return this.isParentIn_SUBSELECT(jobHistoryRecordQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_jobHistory()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);

    return this.isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    return this.isNotParentIn(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    return this.isNotParentIn_SUBSELECT(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(jobHistoryQuery));

    return this.isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.scheduler.JobHistoryRecord.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(jobHistoryQuery));

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    jobHistoryRecordQuery.AND(jobHistoryRecordQuery.hasChild(jobHistoryQuery));
    return this.isNotParentIn(jobHistoryRecordQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_jobHistory(com.runwaysdk.system.scheduler.JobHistoryQuery jobHistoryQuery, com.runwaysdk.system.scheduler.JobHistoryRecordQuery jobHistoryRecordQuery)
  {
    jobHistoryRecordQuery.AND(jobHistoryRecordQuery.hasChild(jobHistoryQuery));
    return this.isNotParentIn_SUBSELECT(jobHistoryRecordQuery);
  }

  protected com.runwaysdk.query.AttributeLocal localFactory( com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdLocalStructDAOIF mdLocalStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION)) 
    {
       return new com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStruct((com.runwaysdk.dataaccess.MdAttributeLocalDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.localFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface ExecutableJobQueryMultiReferenceIF extends com.runwaysdk.system.scheduler.AbstractJobQuery.AbstractJobQueryMultiReferenceIF
  {

    public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription();
    public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias);
    public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableMoment getEntryDate();
    public com.runwaysdk.query.SelectableMoment getEntryDate(String alias);
    public com.runwaysdk.query.SelectableMoment getEntryDate(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getJobId();
    public com.runwaysdk.query.SelectableChar getJobId(String alias);
    public com.runwaysdk.query.SelectableChar getJobId(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBoolean getRecordHistory();
    public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias);
    public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class ExecutableJobQueryMultiReference extends com.runwaysdk.system.scheduler.AbstractJobQuery.AbstractJobQueryMultiReference
 implements ExecutableJobQueryMultiReferenceIF

  {

  public ExecutableJobQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob)  {

      String[] itemIdArray = new String[executableJob.length]; 

      for (int i=0; i<executableJob.length; i++)
      {
        itemIdArray[i] = executableJob[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob)  {

      String[] itemIdArray = new String[executableJob.length]; 

      for (int i=0; i<executableJob.length; i++)
      {
        itemIdArray[i] = executableJob[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob)  {

      String[] itemIdArray = new String[executableJob.length]; 

      for (int i=0; i<executableJob.length; i++)
      {
        itemIdArray[i] = executableJob[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob)  {

      String[] itemIdArray = new String[executableJob.length]; 

      for (int i=0; i<executableJob.length; i++)
      {
        itemIdArray[i] = executableJob[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.scheduler.ExecutableJob ... executableJob)  {

      String[] itemIdArray = new String[executableJob.length]; 

      for (int i=0; i<executableJob.length; i++)
      {
        itemIdArray[i] = executableJob[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription()
  {
    return getDescription(null);

  }
 
  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias)
  {
    return (com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF)this.attributeFactory(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION, com.runwaysdk.system.metadata.MdAttributeLocalCharacter.CLASS, alias, null);

  }
 
  public com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF getDescription(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStructIF)this.attributeFactory(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION, com.runwaysdk.system.metadata.MdAttributeLocalCharacter.CLASS, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getEntryDate()
  {
    return getEntryDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getEntryDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.scheduler.ExecutableJob.ENTRYDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getEntryDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.scheduler.ExecutableJob.ENTRYDATE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getJobId()
  {
    return getJobId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getJobId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.scheduler.ExecutableJob.JOBID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getJobId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.scheduler.ExecutableJob.JOBID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getRecordHistory()
  {
    return getRecordHistory(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.scheduler.ExecutableJob.RECORDHISTORY, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getRecordHistory(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.scheduler.ExecutableJob.RECORDHISTORY, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeLocal localFactory( com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdLocalStructDAOIF mdLocalStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.scheduler.ExecutableJob.DESCRIPTION)) 
    {
       return new com.runwaysdk.system.scheduler.ExecutableJobDescriptionQuery.ExecutableJobDescriptionQueryStruct((com.runwaysdk.dataaccess.MdAttributeLocalDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.localFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
