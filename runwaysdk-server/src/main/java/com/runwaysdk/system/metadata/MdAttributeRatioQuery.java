package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -2076174286)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeRatio.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdAttributeRatioQuery extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery

{

  public MdAttributeRatioQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdAttributeRatioQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdAttributeRatio.CLASS;
  }
  public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio()
  {
    return getRatio(null);

  }
 
  public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO);

    return (com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO);

    return (com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO)) 
    {
       return new com.runwaysdk.system.RatioQuery.RatioQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public com.runwaysdk.query.OIterator<? extends MdAttributeRatio> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdAttributeRatio>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


  public com.runwaysdk.query.Condition getReferencedRatio()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition getReferencedRatio(com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    return this.getBusinessQuery().isParentIn(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio(com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    return this.getBusinessQuery().isParentIn_SUBSELECT(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(ratioQuery));

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(ratioQuery));

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    attributeRatioQuery.AND(attributeRatioQuery.hasChild(ratioQuery));
    return this.getBusinessQuery().isParentIn(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    attributeRatioQuery.AND(attributeRatioQuery.hasChild(ratioQuery));
    return this.getBusinessQuery().isParentIn_SUBSELECT(attributeRatioQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio(com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    return this.getBusinessQuery().isNotParentIn(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio(com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(ratioQuery));

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(ratioQuery));

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    attributeRatioQuery.AND(attributeRatioQuery.hasChild(ratioQuery));
    return this.getBusinessQuery().isNotParentIn(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    attributeRatioQuery.AND(attributeRatioQuery.hasChild(ratioQuery));
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(attributeRatioQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeRatioQueryReferenceIF extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryReferenceIF
  {

    public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio();
    public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias);
    public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeRatio mdAttributeRatio);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeRatio mdAttributeRatio);


  public com.runwaysdk.query.Condition getReferencedRatio();

  public com.runwaysdk.query.Condition getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery);

  public com.runwaysdk.query.Condition getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery);


  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio();

  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery);

  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery);


  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio();

  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery);

  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery);


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio();

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery);

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeRatioQueryReference extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryReference
 implements MdAttributeRatioQueryReferenceIF

  {

  public MdAttributeRatioQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeRatio mdAttributeRatio)
    {
      if(mdAttributeRatio == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdAttributeRatio.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeRatio mdAttributeRatio)
    {
      if(mdAttributeRatio == null) return this.NE((java.lang.String)null);
      return this.NE(mdAttributeRatio.getId());
    }

  public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio()
  {
    return getRatio(null);

  }
 
  public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias)
  {
    return (com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO, alias, null);

  }
 
  public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO,  alias, displayLabel);

  }

  public com.runwaysdk.query.Condition getReferencedRatio()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);

    return this.isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition getReferencedRatio(com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    return this.isParentIn(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio(com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    return this.isParentIn_SUBSELECT(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(ratioQuery));

    return this.isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(ratioQuery));

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    attributeRatioQuery.AND(attributeRatioQuery.hasChild(ratioQuery));
    return this.isParentIn(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    attributeRatioQuery.AND(attributeRatioQuery.hasChild(ratioQuery));
    return this.isParentIn_SUBSELECT(attributeRatioQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);

    return this.isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio(com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    return this.isNotParentIn(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio(com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    return this.isNotParentIn_SUBSELECT(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(ratioQuery));

    return this.isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.AttributeRatio.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(ratioQuery));

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    attributeRatioQuery.AND(attributeRatioQuery.hasChild(ratioQuery));
    return this.isNotParentIn(attributeRatioQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_getReferencedRatio(com.runwaysdk.system.RatioQuery ratioQuery, com.runwaysdk.system.metadata.AttributeRatioQuery attributeRatioQuery)
  {
    attributeRatioQuery.AND(attributeRatioQuery.hasChild(ratioQuery));
    return this.isNotParentIn_SUBSELECT(attributeRatioQuery);
  }

  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO)) 
    {
       return new com.runwaysdk.system.RatioQuery.RatioQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public interface MdAttributeRatioQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryMultiReferenceIF
  {

    public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio();
    public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias);
    public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeRatioQueryMultiReference extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryMultiReference
 implements MdAttributeRatioQueryMultiReferenceIF

  {

  public MdAttributeRatioQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio)  {

      String[] itemIdArray = new String[mdAttributeRatio.length]; 

      for (int i=0; i<mdAttributeRatio.length; i++)
      {
        itemIdArray[i] = mdAttributeRatio[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio)  {

      String[] itemIdArray = new String[mdAttributeRatio.length]; 

      for (int i=0; i<mdAttributeRatio.length; i++)
      {
        itemIdArray[i] = mdAttributeRatio[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio)  {

      String[] itemIdArray = new String[mdAttributeRatio.length]; 

      for (int i=0; i<mdAttributeRatio.length; i++)
      {
        itemIdArray[i] = mdAttributeRatio[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio)  {

      String[] itemIdArray = new String[mdAttributeRatio.length]; 

      for (int i=0; i<mdAttributeRatio.length; i++)
      {
        itemIdArray[i] = mdAttributeRatio[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeRatio ... mdAttributeRatio)  {

      String[] itemIdArray = new String[mdAttributeRatio.length]; 

      for (int i=0; i<mdAttributeRatio.length; i++)
      {
        itemIdArray[i] = mdAttributeRatio[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio()
  {
    return getRatio(null);

  }
 
  public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias)
  {
    return (com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO, alias, null);

  }
 
  public com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF getRatio(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.RatioQuery.RatioQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeRatio.RATIO)) 
    {
       return new com.runwaysdk.system.RatioQuery.RatioQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
