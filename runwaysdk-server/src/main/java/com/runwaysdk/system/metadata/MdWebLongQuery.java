package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 708612319)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebLong.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdWebLongQuery extends com.runwaysdk.system.metadata.MdWebNumberQuery

{

  public MdWebLongQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdWebLongQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdWebLong.CLASS;
  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdWebLong> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdWebLong>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebLongQueryReferenceIF extends com.runwaysdk.system.metadata.MdWebNumberQuery.MdWebNumberQueryReferenceIF
  {


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebLong mdWebLong);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebLong mdWebLong);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebLongQueryReference extends com.runwaysdk.system.metadata.MdWebNumberQuery.MdWebNumberQueryReference
 implements MdWebLongQueryReferenceIF

  {

  public MdWebLongQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebLong mdWebLong)
    {
      if(mdWebLong == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdWebLong.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebLong mdWebLong)
    {
      if(mdWebLong == null) return this.NE((java.lang.String)null);
      return this.NE(mdWebLong.getId());
    }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebLongQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdWebNumberQuery.MdWebNumberQueryMultiReferenceIF
  {


    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebLongQueryMultiReference extends com.runwaysdk.system.metadata.MdWebNumberQuery.MdWebNumberQueryMultiReference
 implements MdWebLongQueryMultiReferenceIF

  {

  public MdWebLongQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong)  {

      String[] itemIdArray = new String[mdWebLong.length]; 

      for (int i=0; i<mdWebLong.length; i++)
      {
        itemIdArray[i] = mdWebLong[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong)  {

      String[] itemIdArray = new String[mdWebLong.length]; 

      for (int i=0; i<mdWebLong.length; i++)
      {
        itemIdArray[i] = mdWebLong[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong)  {

      String[] itemIdArray = new String[mdWebLong.length]; 

      for (int i=0; i<mdWebLong.length; i++)
      {
        itemIdArray[i] = mdWebLong[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong)  {

      String[] itemIdArray = new String[mdWebLong.length]; 

      for (int i=0; i<mdWebLong.length; i++)
      {
        itemIdArray[i] = mdWebLong[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebLong ... mdWebLong)  {

      String[] itemIdArray = new String[mdWebLong.length]; 

      for (int i=0; i<mdWebLong.length; i++)
      {
        itemIdArray[i] = mdWebLong[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  }
}