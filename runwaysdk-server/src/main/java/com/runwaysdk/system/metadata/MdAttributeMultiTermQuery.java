package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 663176290)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeMultiTerm.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdAttributeMultiTermQuery extends com.runwaysdk.system.metadata.MdAttributeMultiReferenceQuery

{

  public MdAttributeMultiTermQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdAttributeMultiTermQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdAttributeMultiTerm.CLASS;
  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdAttributeMultiTerm> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdAttributeMultiTerm>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeMultiTermQueryReferenceIF extends com.runwaysdk.system.metadata.MdAttributeMultiReferenceQuery.MdAttributeMultiReferenceQueryReferenceIF
  {


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeMultiTerm mdAttributeMultiTerm);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeMultiTerm mdAttributeMultiTerm);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeMultiTermQueryReference extends com.runwaysdk.system.metadata.MdAttributeMultiReferenceQuery.MdAttributeMultiReferenceQueryReference
 implements MdAttributeMultiTermQueryReferenceIF

  {

  public MdAttributeMultiTermQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeMultiTerm mdAttributeMultiTerm)
    {
      if(mdAttributeMultiTerm == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdAttributeMultiTerm.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeMultiTerm mdAttributeMultiTerm)
    {
      if(mdAttributeMultiTerm == null) return this.NE((java.lang.String)null);
      return this.NE(mdAttributeMultiTerm.getId());
    }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeMultiTermQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdAttributeMultiReferenceQuery.MdAttributeMultiReferenceQueryMultiReferenceIF
  {


    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeMultiTermQueryMultiReference extends com.runwaysdk.system.metadata.MdAttributeMultiReferenceQuery.MdAttributeMultiReferenceQueryMultiReference
 implements MdAttributeMultiTermQueryMultiReferenceIF

  {

  public MdAttributeMultiTermQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm)  {

      String[] itemIdArray = new String[mdAttributeMultiTerm.length]; 

      for (int i=0; i<mdAttributeMultiTerm.length; i++)
      {
        itemIdArray[i] = mdAttributeMultiTerm[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm)  {

      String[] itemIdArray = new String[mdAttributeMultiTerm.length]; 

      for (int i=0; i<mdAttributeMultiTerm.length; i++)
      {
        itemIdArray[i] = mdAttributeMultiTerm[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm)  {

      String[] itemIdArray = new String[mdAttributeMultiTerm.length]; 

      for (int i=0; i<mdAttributeMultiTerm.length; i++)
      {
        itemIdArray[i] = mdAttributeMultiTerm[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm)  {

      String[] itemIdArray = new String[mdAttributeMultiTerm.length]; 

      for (int i=0; i<mdAttributeMultiTerm.length; i++)
      {
        itemIdArray[i] = mdAttributeMultiTerm[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeMultiTerm ... mdAttributeMultiTerm)  {

      String[] itemIdArray = new String[mdAttributeMultiTerm.length]; 

      for (int i=0; i<mdAttributeMultiTerm.length; i++)
      {
        itemIdArray[i] = mdAttributeMultiTerm[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  }
}