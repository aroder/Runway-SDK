package com.runwaysdk.system;

@com.runwaysdk.business.ClassSignature(hash = 766074588)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to DomainTuple.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class DomainTupleQuery extends com.runwaysdk.system.metadata.TypeTupleQuery

{

  public DomainTupleQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public DomainTupleQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.DomainTuple.CLASS;
  }
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain()
  {
    return getPermissionDomain(null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN);

    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN);

    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN)) 
    {
       return new com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends DomainTuple> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<DomainTuple>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface DomainTupleQueryReferenceIF extends com.runwaysdk.system.metadata.TypeTupleQuery.TypeTupleQueryReferenceIF
  {

    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain();
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias);
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.DomainTuple domainTuple);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.DomainTuple domainTuple);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class DomainTupleQueryReference extends com.runwaysdk.system.metadata.TypeTupleQuery.TypeTupleQueryReference
 implements DomainTupleQueryReferenceIF

  {

  public DomainTupleQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.DomainTuple domainTuple)
    {
      if(domainTuple == null) return this.EQ((java.lang.String)null);
      return this.EQ(domainTuple.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.DomainTuple domainTuple)
    {
      if(domainTuple == null) return this.NE((java.lang.String)null);
      return this.NE(domainTuple.getId());
    }

  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain()
  {
    return getPermissionDomain(null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias)
  {
    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.get(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.get(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN)) 
    {
       return new com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface DomainTupleQueryMultiReferenceIF extends com.runwaysdk.system.metadata.TypeTupleQuery.TypeTupleQueryMultiReferenceIF
  {

    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain();
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias);
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.DomainTuple ... domainTuple);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.DomainTuple ... domainTuple);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.DomainTuple ... domainTuple);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.DomainTuple ... domainTuple);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.DomainTuple ... domainTuple);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class DomainTupleQueryMultiReference extends com.runwaysdk.system.metadata.TypeTupleQuery.TypeTupleQueryMultiReference
 implements DomainTupleQueryMultiReferenceIF

  {

  public DomainTupleQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.DomainTuple ... domainTuple)  {

      String[] itemIdArray = new String[domainTuple.length]; 

      for (int i=0; i<domainTuple.length; i++)
      {
        itemIdArray[i] = domainTuple[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.DomainTuple ... domainTuple)  {

      String[] itemIdArray = new String[domainTuple.length]; 

      for (int i=0; i<domainTuple.length; i++)
      {
        itemIdArray[i] = domainTuple[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.DomainTuple ... domainTuple)  {

      String[] itemIdArray = new String[domainTuple.length]; 

      for (int i=0; i<domainTuple.length; i++)
      {
        itemIdArray[i] = domainTuple[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.DomainTuple ... domainTuple)  {

      String[] itemIdArray = new String[domainTuple.length]; 

      for (int i=0; i<domainTuple.length; i++)
      {
        itemIdArray[i] = domainTuple[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.DomainTuple ... domainTuple)  {

      String[] itemIdArray = new String[domainTuple.length]; 

      for (int i=0; i<domainTuple.length; i++)
      {
        itemIdArray[i] = domainTuple[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain()
  {
    return getPermissionDomain(null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias)
  {
    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.get(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getPermissionDomain(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.get(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.DomainTuple.PERMISSIONDOMAIN)) 
    {
       return new com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
