package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 880383807)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to OntologyStrategy.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class OntologyStrategyQuery extends com.runwaysdk.query.GeneratedBusinessQuery

{

  public OntologyStrategyQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
     super();
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public OntologyStrategyQuery(com.runwaysdk.query.ValueQuery valueQuery)
  {
     super();
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = new com.runwaysdk.business.BusinessQuery(valueQuery, this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public String getClassType()
  {
    return com.runwaysdk.system.metadata.OntologyStrategy.CLASS;
  }
  public com.runwaysdk.query.SelectableMoment getCreateDate()
  {
    return getCreateDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getCreateDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getCreateDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDATE, alias, displayLabel);

  }
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy()
  {
    return getCreatedBy(null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDBY);

    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDBY, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDBY);

    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDBY, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain()
  {
    return getEntityDomain(null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.ENTITYDOMAIN);

    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.ENTITYDOMAIN, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.ENTITYDOMAIN);

    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.ENTITYDOMAIN, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getId()
  {
    return getId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.ID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.ID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getKeyName()
  {
    return getKeyName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.KEYNAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.KEYNAME, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate()
  {
    return getLastUpdateDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDATE, alias, displayLabel);

  }
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy()
  {
    return getLastUpdatedBy(null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDBY);

    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDBY, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDBY);

    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDBY, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy()
  {
    return getLockedBy(null);

  }
 
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.LOCKEDBY);

    return (com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.LOCKEDBY, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.LOCKEDBY);

    return (com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.LOCKEDBY, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner()
  {
    return getOwner(null);

  }
 
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.OWNER);

    return (com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.OWNER, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.OWNER);

    return (com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.OWNER, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getSeq()
  {
    return getSeq(null);

  }
 
  public com.runwaysdk.query.SelectableLong getSeq(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.SEQ, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getSeq(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.SEQ, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getSiteMaster()
  {
    return getSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.SITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.SITEMASTER, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF getStrategy()
  {
    return getStrategy(null);

  }
 
  public com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF getStrategy(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.STRATEGY);

    return (com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.STRATEGY, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF getStrategy(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.OntologyStrategy.STRATEGY);

    return (com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.OntologyStrategy.STRATEGY, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getType()
  {
    return getType(null);

  }
 
  public com.runwaysdk.query.SelectableChar getType(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.TYPE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getType(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.OntologyStrategy.TYPE, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDBY)) 
    {
       return new com.runwaysdk.system.SingleActorQuery.SingleActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.ENTITYDOMAIN)) 
    {
       return new com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDBY)) 
    {
       return new com.runwaysdk.system.SingleActorQuery.SingleActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.LOCKEDBY)) 
    {
       return new com.runwaysdk.system.UsersQuery.UsersQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.OWNER)) 
    {
       return new com.runwaysdk.system.ActorQuery.ActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.STRATEGY)) 
    {
       return new com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      String error = "Attribute type ["+mdAttributeIF.getType()+"] is invalid.";
      throw new com.runwaysdk.query.QueryException(error);
    }
  }

  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends OntologyStrategy> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<OntologyStrategy>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface OntologyStrategyQueryReferenceIF extends com.runwaysdk.query.SelectableReference
  {

    public com.runwaysdk.query.SelectableMoment getCreateDate();
    public com.runwaysdk.query.SelectableMoment getCreateDate(String alias);
    public com.runwaysdk.query.SelectableMoment getCreateDate(String alias, String displayLabel);
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy();
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias);
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias, String displayLabel);
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain();
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias);
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getId();
    public com.runwaysdk.query.SelectableChar getId(String alias);
    public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getKeyName();
    public com.runwaysdk.query.SelectableChar getKeyName(String alias);
    public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableMoment getLastUpdateDate();
    public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias);
    public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias, String displayLabel);
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy();
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias);
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias, String displayLabel);
    public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy();
    public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias);
    public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias, String displayLabel);
    public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner();
    public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias);
    public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableLong getSeq();
    public com.runwaysdk.query.SelectableLong getSeq(String alias);
    public com.runwaysdk.query.SelectableLong getSeq(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getSiteMaster();
    public com.runwaysdk.query.SelectableChar getSiteMaster(String alias);
    public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel);
    public com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF getStrategy();
    public com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF getStrategy(String alias);
    public com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF getStrategy(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getType();
    public com.runwaysdk.query.SelectableChar getType(String alias);
    public com.runwaysdk.query.SelectableChar getType(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.OntologyStrategy ontologyStrategy);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.OntologyStrategy ontologyStrategy);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class OntologyStrategyQueryReference extends com.runwaysdk.query.AttributeReference
 implements OntologyStrategyQueryReferenceIF

  {

  public OntologyStrategyQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.OntologyStrategy ontologyStrategy)
    {
      if(ontologyStrategy == null) return this.EQ((java.lang.String)null);
      return this.EQ(ontologyStrategy.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.OntologyStrategy ontologyStrategy)
    {
      if(ontologyStrategy == null) return this.NE((java.lang.String)null);
      return this.NE(ontologyStrategy.getId());
    }

  public com.runwaysdk.query.SelectableMoment getCreateDate()
  {
    return getCreateDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getCreateDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getCreateDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDATE, alias, displayLabel);

  }
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy()
  {
    return getCreatedBy(null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias)
  {
    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDBY, alias, null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDBY,  alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain()
  {
    return getEntityDomain(null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias)
  {
    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.ENTITYDOMAIN, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.ENTITYDOMAIN,  alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getId()
  {
    return getId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.OntologyStrategy.ID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.OntologyStrategy.ID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getKeyName()
  {
    return getKeyName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.OntologyStrategy.KEYNAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.OntologyStrategy.KEYNAME, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate()
  {
    return getLastUpdateDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDATE, alias, displayLabel);

  }
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy()
  {
    return getLastUpdatedBy(null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias)
  {
    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDBY, alias, null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDBY,  alias, displayLabel);

  }
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy()
  {
    return getLockedBy(null);

  }
 
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias)
  {
    return (com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.LOCKEDBY, alias, null);

  }
 
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.LOCKEDBY,  alias, displayLabel);

  }
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner()
  {
    return getOwner(null);

  }
 
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias)
  {
    return (com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.OWNER, alias, null);

  }
 
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.OWNER,  alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getSeq()
  {
    return getSeq(null);

  }
 
  public com.runwaysdk.query.SelectableLong getSeq(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(com.runwaysdk.system.metadata.OntologyStrategy.SEQ, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getSeq(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(com.runwaysdk.system.metadata.OntologyStrategy.SEQ, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getSiteMaster()
  {
    return getSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.OntologyStrategy.SITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.OntologyStrategy.SITEMASTER, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF getStrategy()
  {
    return getStrategy(null);

  }
 
  public com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF getStrategy(String alias)
  {
    return (com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.STRATEGY, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF getStrategy(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReferenceIF)this.get(com.runwaysdk.system.metadata.OntologyStrategy.STRATEGY,  alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getType()
  {
    return getType(null);

  }
 
  public com.runwaysdk.query.SelectableChar getType(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.OntologyStrategy.TYPE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getType(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.OntologyStrategy.TYPE, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.CREATEDBY)) 
    {
       return new com.runwaysdk.system.SingleActorQuery.SingleActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.ENTITYDOMAIN)) 
    {
       return new com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.LASTUPDATEDBY)) 
    {
       return new com.runwaysdk.system.SingleActorQuery.SingleActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.LOCKEDBY)) 
    {
       return new com.runwaysdk.system.UsersQuery.UsersQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.OWNER)) 
    {
       return new com.runwaysdk.system.ActorQuery.ActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.OntologyStrategy.STRATEGY)) 
    {
       return new com.runwaysdk.system.metadata.MdTermQuery.MdTermQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      String error = "Attribute type ["+mdAttributeIF.getType()+"] is invalid.";
      throw new com.runwaysdk.query.QueryException(error);
    }
  }

  }
}
