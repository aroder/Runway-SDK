package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -987664721)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdLocalStruct.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdLocalStructQuery extends com.runwaysdk.system.metadata.MdStructQuery

{

  public MdLocalStructQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdLocalStructQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdLocalStruct.CLASS;
  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdLocalStruct> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdLocalStruct>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdLocalStructQueryReferenceIF extends com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF
  {


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdLocalStruct mdLocalStruct);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdLocalStruct mdLocalStruct);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdLocalStructQueryReference extends com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReference
 implements MdLocalStructQueryReferenceIF

  {

  public MdLocalStructQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdLocalStruct mdLocalStruct)
    {
      if(mdLocalStruct == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdLocalStruct.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdLocalStruct mdLocalStruct)
    {
      if(mdLocalStruct == null) return this.NE((java.lang.String)null);
      return this.NE(mdLocalStruct.getId());
    }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdLocalStructQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryMultiReferenceIF
  {


    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdLocalStructQueryMultiReference extends com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryMultiReference
 implements MdLocalStructQueryMultiReferenceIF

  {

  public MdLocalStructQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct)  {

      String[] itemIdArray = new String[mdLocalStruct.length]; 

      for (int i=0; i<mdLocalStruct.length; i++)
      {
        itemIdArray[i] = mdLocalStruct[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct)  {

      String[] itemIdArray = new String[mdLocalStruct.length]; 

      for (int i=0; i<mdLocalStruct.length; i++)
      {
        itemIdArray[i] = mdLocalStruct[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct)  {

      String[] itemIdArray = new String[mdLocalStruct.length]; 

      for (int i=0; i<mdLocalStruct.length; i++)
      {
        itemIdArray[i] = mdLocalStruct[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct)  {

      String[] itemIdArray = new String[mdLocalStruct.length]; 

      for (int i=0; i<mdLocalStruct.length; i++)
      {
        itemIdArray[i] = mdLocalStruct[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdLocalStruct ... mdLocalStruct)  {

      String[] itemIdArray = new String[mdLocalStruct.length]; 

      for (int i=0; i<mdLocalStruct.length; i++)
      {
        itemIdArray[i] = mdLocalStruct[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  }
}
