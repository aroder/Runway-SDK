package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 1663317636)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebPrimitive.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdWebPrimitiveQuery extends com.runwaysdk.system.metadata.MdWebAttributeQuery

{

  public MdWebPrimitiveQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdWebPrimitiveQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdWebPrimitive.CLASS;
  }
  public com.runwaysdk.query.SelectableChar getExpression()
  {
    return getExpression(null);

  }
 
  public com.runwaysdk.query.SelectableChar getExpression(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdWebPrimitive.EXPRESSION, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getExpression(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdWebPrimitive.EXPRESSION, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getIsExpression()
  {
    return getIsExpression(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdWebPrimitive.ISEXPRESSION, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdWebPrimitive.ISEXPRESSION, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdWebPrimitive> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdWebPrimitive>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


  public com.runwaysdk.query.Condition grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);

    return this.getBusinessQuery().isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    return this.getBusinessQuery().isChildIn(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    return this.getBusinessQuery().isChildIn_SUBSELECT(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdWebSingleTermGridQuery));

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdWebSingleTermGridQuery));

    return this.getBusinessQuery().isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    webGridFieldQuery.AND(webGridFieldQuery.hasParent(mdWebSingleTermGridQuery));
    return this.getBusinessQuery().isChildIn(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    webGridFieldQuery.AND(webGridFieldQuery.hasParent(mdWebSingleTermGridQuery));
    return this.getBusinessQuery().isChildIn_SUBSELECT(webGridFieldQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);

    return this.getBusinessQuery().isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    return this.getBusinessQuery().isNotChildIn(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    return this.getBusinessQuery().isNotChildIn_SUBSELECT(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdWebSingleTermGridQuery));

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdWebSingleTermGridQuery));

    return this.getBusinessQuery().isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    webGridFieldQuery.AND(webGridFieldQuery.hasParent(mdWebSingleTermGridQuery));
    return this.getBusinessQuery().isNotChildIn(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    webGridFieldQuery.AND(webGridFieldQuery.hasParent(mdWebSingleTermGridQuery));
    return this.getBusinessQuery().isNotChildIn_SUBSELECT(webGridFieldQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebPrimitiveQueryReferenceIF extends com.runwaysdk.system.metadata.MdWebAttributeQuery.MdWebAttributeQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getExpression();
    public com.runwaysdk.query.SelectableChar getExpression(String alias);
    public com.runwaysdk.query.SelectableChar getExpression(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBoolean getIsExpression();
    public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias);
    public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebPrimitive mdWebPrimitive);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebPrimitive mdWebPrimitive);


  public com.runwaysdk.query.Condition grid();
  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery);

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery);


  public com.runwaysdk.query.Condition SUBSELECT_grid();
  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery);

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery);


  public com.runwaysdk.query.Condition NOT_IN_grid();
  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery);

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery);


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid();
  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery);

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebPrimitiveQueryReference extends com.runwaysdk.system.metadata.MdWebAttributeQuery.MdWebAttributeQueryReference
 implements MdWebPrimitiveQueryReferenceIF

  {

  public MdWebPrimitiveQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebPrimitive mdWebPrimitive)
    {
      if(mdWebPrimitive == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdWebPrimitive.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebPrimitive mdWebPrimitive)
    {
      if(mdWebPrimitive == null) return this.NE((java.lang.String)null);
      return this.NE(mdWebPrimitive.getId());
    }

  public com.runwaysdk.query.SelectableChar getExpression()
  {
    return getExpression(null);

  }
 
  public com.runwaysdk.query.SelectableChar getExpression(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdWebPrimitive.EXPRESSION, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getExpression(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdWebPrimitive.EXPRESSION, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getIsExpression()
  {
    return getIsExpression(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdWebPrimitive.ISEXPRESSION, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdWebPrimitive.ISEXPRESSION, alias, displayLabel);

  }

  public com.runwaysdk.query.Condition grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);

    return this.isChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);

    return this.isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    return this.isChildIn(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    return this.isChildIn_SUBSELECT(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdWebSingleTermGridQuery));

    return this.isChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdWebSingleTermGridQuery));

    return this.isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    webGridFieldQuery.AND(webGridFieldQuery.hasParent(mdWebSingleTermGridQuery));
    return this.isChildIn(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    webGridFieldQuery.AND(webGridFieldQuery.hasParent(mdWebSingleTermGridQuery));
    return this.isChildIn_SUBSELECT(webGridFieldQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);

    return this.isNotChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);

    return this.isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    return this.isNotChildIn(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    return this.isNotChildIn_SUBSELECT(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdWebSingleTermGridQuery));

    return this.isNotChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebGridField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdWebSingleTermGridQuery));

    return this.isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    webGridFieldQuery.AND(webGridFieldQuery.hasParent(mdWebSingleTermGridQuery));
    return this.isNotChildIn(webGridFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_grid(com.runwaysdk.system.metadata.MdWebSingleTermGridQuery mdWebSingleTermGridQuery, com.runwaysdk.system.metadata.WebGridFieldQuery webGridFieldQuery)
  {
    webGridFieldQuery.AND(webGridFieldQuery.hasParent(mdWebSingleTermGridQuery));
    return this.isNotChildIn_SUBSELECT(webGridFieldQuery);
  }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebPrimitiveQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdWebAttributeQuery.MdWebAttributeQueryMultiReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getExpression();
    public com.runwaysdk.query.SelectableChar getExpression(String alias);
    public com.runwaysdk.query.SelectableChar getExpression(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBoolean getIsExpression();
    public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias);
    public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebPrimitiveQueryMultiReference extends com.runwaysdk.system.metadata.MdWebAttributeQuery.MdWebAttributeQueryMultiReference
 implements MdWebPrimitiveQueryMultiReferenceIF

  {

  public MdWebPrimitiveQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive)  {

      String[] itemIdArray = new String[mdWebPrimitive.length]; 

      for (int i=0; i<mdWebPrimitive.length; i++)
      {
        itemIdArray[i] = mdWebPrimitive[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive)  {

      String[] itemIdArray = new String[mdWebPrimitive.length]; 

      for (int i=0; i<mdWebPrimitive.length; i++)
      {
        itemIdArray[i] = mdWebPrimitive[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive)  {

      String[] itemIdArray = new String[mdWebPrimitive.length]; 

      for (int i=0; i<mdWebPrimitive.length; i++)
      {
        itemIdArray[i] = mdWebPrimitive[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive)  {

      String[] itemIdArray = new String[mdWebPrimitive.length]; 

      for (int i=0; i<mdWebPrimitive.length; i++)
      {
        itemIdArray[i] = mdWebPrimitive[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebPrimitive ... mdWebPrimitive)  {

      String[] itemIdArray = new String[mdWebPrimitive.length]; 

      for (int i=0; i<mdWebPrimitive.length; i++)
      {
        itemIdArray[i] = mdWebPrimitive[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.query.SelectableChar getExpression()
  {
    return getExpression(null);

  }
 
  public com.runwaysdk.query.SelectableChar getExpression(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdWebPrimitive.EXPRESSION, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getExpression(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdWebPrimitive.EXPRESSION, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getIsExpression()
  {
    return getIsExpression(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdWebPrimitive.ISEXPRESSION, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsExpression(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdWebPrimitive.ISEXPRESSION, alias, displayLabel);

  }
  }
}
