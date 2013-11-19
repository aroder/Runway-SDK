package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -1246823649)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebText.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdWebTextQuery extends com.runwaysdk.system.metadata.MdWebPrimitiveQuery

{

  public MdWebTextQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdWebTextQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdWebText.CLASS;
  }
  public com.runwaysdk.query.SelectableInteger getHeight()
  {
    return getHeight(null);

  }
 
  public com.runwaysdk.query.SelectableInteger getHeight(String alias)
  {
    return (com.runwaysdk.query.SelectableInteger)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdWebText.HEIGHT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableInteger getHeight(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableInteger)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdWebText.HEIGHT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableInteger getWidth()
  {
    return getWidth(null);

  }
 
  public com.runwaysdk.query.SelectableInteger getWidth(String alias)
  {
    return (com.runwaysdk.query.SelectableInteger)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdWebText.WIDTH, alias, null);

  }
 
  public com.runwaysdk.query.SelectableInteger getWidth(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableInteger)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdWebText.WIDTH, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdWebText> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdWebText>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebTextQueryReferenceIF extends com.runwaysdk.system.metadata.MdWebPrimitiveQuery.MdWebPrimitiveQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableInteger getHeight();
    public com.runwaysdk.query.SelectableInteger getHeight(String alias);
    public com.runwaysdk.query.SelectableInteger getHeight(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableInteger getWidth();
    public com.runwaysdk.query.SelectableInteger getWidth(String alias);
    public com.runwaysdk.query.SelectableInteger getWidth(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebText mdWebText);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebText mdWebText);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebTextQueryReference extends com.runwaysdk.system.metadata.MdWebPrimitiveQuery.MdWebPrimitiveQueryReference
 implements MdWebTextQueryReferenceIF

  {

  public MdWebTextQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebText mdWebText)
    {
      if(mdWebText == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdWebText.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebText mdWebText)
    {
      if(mdWebText == null) return this.NE((java.lang.String)null);
      return this.NE(mdWebText.getId());
    }

  public com.runwaysdk.query.SelectableInteger getHeight()
  {
    return getHeight(null);

  }
 
  public com.runwaysdk.query.SelectableInteger getHeight(String alias)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdWebText.HEIGHT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableInteger getHeight(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdWebText.HEIGHT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableInteger getWidth()
  {
    return getWidth(null);

  }
 
  public com.runwaysdk.query.SelectableInteger getWidth(String alias)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdWebText.WIDTH, alias, null);

  }
 
  public com.runwaysdk.query.SelectableInteger getWidth(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdWebText.WIDTH, alias, displayLabel);

  }
  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebTextQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdWebPrimitiveQuery.MdWebPrimitiveQueryMultiReferenceIF
  {

    public com.runwaysdk.query.SelectableInteger getHeight();
    public com.runwaysdk.query.SelectableInteger getHeight(String alias);
    public com.runwaysdk.query.SelectableInteger getHeight(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableInteger getWidth();
    public com.runwaysdk.query.SelectableInteger getWidth(String alias);
    public com.runwaysdk.query.SelectableInteger getWidth(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebText ... mdWebText);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebText ... mdWebText);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebText ... mdWebText);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebText ... mdWebText);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebText ... mdWebText);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebTextQueryMultiReference extends com.runwaysdk.system.metadata.MdWebPrimitiveQuery.MdWebPrimitiveQueryMultiReference
 implements MdWebTextQueryMultiReferenceIF

  {

  public MdWebTextQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebText ... mdWebText)  {

      String[] itemIdArray = new String[mdWebText.length]; 

      for (int i=0; i<mdWebText.length; i++)
      {
        itemIdArray[i] = mdWebText[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebText ... mdWebText)  {

      String[] itemIdArray = new String[mdWebText.length]; 

      for (int i=0; i<mdWebText.length; i++)
      {
        itemIdArray[i] = mdWebText[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebText ... mdWebText)  {

      String[] itemIdArray = new String[mdWebText.length]; 

      for (int i=0; i<mdWebText.length; i++)
      {
        itemIdArray[i] = mdWebText[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebText ... mdWebText)  {

      String[] itemIdArray = new String[mdWebText.length]; 

      for (int i=0; i<mdWebText.length; i++)
      {
        itemIdArray[i] = mdWebText[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebText ... mdWebText)  {

      String[] itemIdArray = new String[mdWebText.length]; 

      for (int i=0; i<mdWebText.length; i++)
      {
        itemIdArray[i] = mdWebText[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.query.SelectableInteger getHeight()
  {
    return getHeight(null);

  }
 
  public com.runwaysdk.query.SelectableInteger getHeight(String alias)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdWebText.HEIGHT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableInteger getHeight(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdWebText.HEIGHT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableInteger getWidth()
  {
    return getWidth(null);

  }
 
  public com.runwaysdk.query.SelectableInteger getWidth(String alias)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdWebText.WIDTH, alias, null);

  }
 
  public com.runwaysdk.query.SelectableInteger getWidth(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdWebText.WIDTH, alias, displayLabel);

  }
  }
}
