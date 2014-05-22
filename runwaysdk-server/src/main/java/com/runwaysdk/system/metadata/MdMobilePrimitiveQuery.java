package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 1723104087)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdMobilePrimitive.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdMobilePrimitiveQuery extends com.runwaysdk.system.metadata.MdMobileAttributeQuery

{

  public MdMobilePrimitiveQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdMobilePrimitiveQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdMobilePrimitive.CLASS;
  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdMobilePrimitive> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdMobilePrimitive>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


  public com.runwaysdk.query.Condition grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);

    return this.getBusinessQuery().isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    return this.getBusinessQuery().isChildIn(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    return this.getBusinessQuery().isChildIn_SUBSELECT(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdMobileSingleTermGridQuery));

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdMobileSingleTermGridQuery));

    return this.getBusinessQuery().isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    mobileGridFieldQuery.AND(mobileGridFieldQuery.hasParent(mdMobileSingleTermGridQuery));
    return this.getBusinessQuery().isChildIn(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    mobileGridFieldQuery.AND(mobileGridFieldQuery.hasParent(mdMobileSingleTermGridQuery));
    return this.getBusinessQuery().isChildIn_SUBSELECT(mobileGridFieldQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);

    return this.getBusinessQuery().isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    return this.getBusinessQuery().isNotChildIn(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    return this.getBusinessQuery().isNotChildIn_SUBSELECT(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdMobileSingleTermGridQuery));

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdMobileSingleTermGridQuery));

    return this.getBusinessQuery().isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    mobileGridFieldQuery.AND(mobileGridFieldQuery.hasParent(mdMobileSingleTermGridQuery));
    return this.getBusinessQuery().isNotChildIn(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    mobileGridFieldQuery.AND(mobileGridFieldQuery.hasParent(mdMobileSingleTermGridQuery));
    return this.getBusinessQuery().isNotChildIn_SUBSELECT(mobileGridFieldQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdMobilePrimitiveQueryReferenceIF extends com.runwaysdk.system.metadata.MdMobileAttributeQuery.MdMobileAttributeQueryReferenceIF
  {


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdMobilePrimitive mdMobilePrimitive);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdMobilePrimitive mdMobilePrimitive);


  public com.runwaysdk.query.Condition grid();
  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery);

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery);


  public com.runwaysdk.query.Condition SUBSELECT_grid();
  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery);

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery);


  public com.runwaysdk.query.Condition NOT_IN_grid();
  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery);

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery);


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid();
  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery);

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdMobilePrimitiveQueryReference extends com.runwaysdk.system.metadata.MdMobileAttributeQuery.MdMobileAttributeQueryReference
 implements MdMobilePrimitiveQueryReferenceIF

  {

  public MdMobilePrimitiveQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdMobilePrimitive mdMobilePrimitive)
    {
      if(mdMobilePrimitive == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdMobilePrimitive.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdMobilePrimitive mdMobilePrimitive)
    {
      if(mdMobilePrimitive == null) return this.NE((java.lang.String)null);
      return this.NE(mdMobilePrimitive.getId());
    }


  public com.runwaysdk.query.Condition grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);

    return this.isChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);

    return this.isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    return this.isChildIn(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    return this.isChildIn_SUBSELECT(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdMobileSingleTermGridQuery));

    return this.isChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdMobileSingleTermGridQuery));

    return this.isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    mobileGridFieldQuery.AND(mobileGridFieldQuery.hasParent(mdMobileSingleTermGridQuery));
    return this.isChildIn(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    mobileGridFieldQuery.AND(mobileGridFieldQuery.hasParent(mdMobileSingleTermGridQuery));
    return this.isChildIn_SUBSELECT(mobileGridFieldQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);

    return this.isNotChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);

    return this.isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    return this.isNotChildIn(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    return this.isNotChildIn_SUBSELECT(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdMobileSingleTermGridQuery));

    return this.isNotChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.MobileGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdMobileSingleTermGridQuery));

    return this.isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    mobileGridFieldQuery.AND(mobileGridFieldQuery.hasParent(mdMobileSingleTermGridQuery));
    return this.isNotChildIn(mobileGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdMobileSingleTermGridQuery mdMobileSingleTermGridQuery, com.runwaysdk.system.metadata.MobileGridFieldQuery mobileGridFieldQuery)
  {
    mobileGridFieldQuery.AND(mobileGridFieldQuery.hasParent(mdMobileSingleTermGridQuery));
    return this.isNotChildIn_SUBSELECT(mobileGridFieldQuery);
  }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdMobilePrimitiveQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdMobileAttributeQuery.MdMobileAttributeQueryMultiReferenceIF
  {


    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdMobilePrimitiveQueryMultiReference extends com.runwaysdk.system.metadata.MdMobileAttributeQuery.MdMobileAttributeQueryMultiReference
 implements MdMobilePrimitiveQueryMultiReferenceIF

  {

  public MdMobilePrimitiveQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive)  {

      String[] itemIdArray = new String[mdMobilePrimitive.length]; 

      for (int i=0; i<mdMobilePrimitive.length; i++)
      {
        itemIdArray[i] = mdMobilePrimitive[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive)  {

      String[] itemIdArray = new String[mdMobilePrimitive.length]; 

      for (int i=0; i<mdMobilePrimitive.length; i++)
      {
        itemIdArray[i] = mdMobilePrimitive[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive)  {

      String[] itemIdArray = new String[mdMobilePrimitive.length]; 

      for (int i=0; i<mdMobilePrimitive.length; i++)
      {
        itemIdArray[i] = mdMobilePrimitive[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive)  {

      String[] itemIdArray = new String[mdMobilePrimitive.length]; 

      for (int i=0; i<mdMobilePrimitive.length; i++)
      {
        itemIdArray[i] = mdMobilePrimitive[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdMobilePrimitive ... mdMobilePrimitive)  {

      String[] itemIdArray = new String[mdMobilePrimitive.length]; 

      for (int i=0; i<mdMobilePrimitive.length; i++)
      {
        itemIdArray[i] = mdMobilePrimitive[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  }
}
