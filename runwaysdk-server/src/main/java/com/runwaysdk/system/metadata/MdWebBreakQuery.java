package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 1798610720)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebBreak.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdWebBreakQuery extends com.runwaysdk.system.metadata.MdWebFieldQuery

{

  public MdWebBreakQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdWebBreakQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdWebBreak.CLASS;
  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdWebBreak> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdWebBreak>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebBreakQueryReferenceIF extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryReferenceIF
  {


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebBreak mdWebBreak);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebBreak mdWebBreak);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebBreakQueryReference extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryReference
 implements MdWebBreakQueryReferenceIF

  {

  public MdWebBreakQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebBreak mdWebBreak)
    {
      if(mdWebBreak == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdWebBreak.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebBreak mdWebBreak)
    {
      if(mdWebBreak == null) return this.NE((java.lang.String)null);
      return this.NE(mdWebBreak.getId());
    }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebBreakQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryMultiReferenceIF
  {


    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebBreakQueryMultiReference extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryMultiReference
 implements MdWebBreakQueryMultiReferenceIF

  {

  public MdWebBreakQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak)  {

      String[] itemIdArray = new String[mdWebBreak.length]; 

      for (int i=0; i<mdWebBreak.length; i++)
      {
        itemIdArray[i] = mdWebBreak[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak)  {

      String[] itemIdArray = new String[mdWebBreak.length]; 

      for (int i=0; i<mdWebBreak.length; i++)
      {
        itemIdArray[i] = mdWebBreak[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak)  {

      String[] itemIdArray = new String[mdWebBreak.length]; 

      for (int i=0; i<mdWebBreak.length; i++)
      {
        itemIdArray[i] = mdWebBreak[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak)  {

      String[] itemIdArray = new String[mdWebBreak.length]; 

      for (int i=0; i<mdWebBreak.length; i++)
      {
        itemIdArray[i] = mdWebBreak[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebBreak ... mdWebBreak)  {

      String[] itemIdArray = new String[mdWebBreak.length]; 

      for (int i=0; i<mdWebBreak.length; i++)
      {
        itemIdArray[i] = mdWebBreak[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  }
}
