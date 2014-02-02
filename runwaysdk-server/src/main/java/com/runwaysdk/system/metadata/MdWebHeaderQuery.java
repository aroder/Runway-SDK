package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -2067852239)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebHeader.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdWebHeaderQuery extends com.runwaysdk.system.metadata.MdWebFieldQuery

{

  public MdWebHeaderQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdWebHeaderQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdWebHeader.CLASS;
  }
  public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText()
  {
    return getHeaderText(null);

  }
 
  public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT);

    return (com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT);

    return (com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeLocal localFactory( com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdLocalStructDAOIF mdLocalStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT)) 
    {
       return new com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStruct((com.runwaysdk.dataaccess.MdAttributeLocalDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.localFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdWebHeader> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdWebHeader>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebHeaderQueryReferenceIF extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryReferenceIF
  {

    public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText();
    public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias);
    public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebHeader mdWebHeader);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebHeader mdWebHeader);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebHeaderQueryReference extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryReference
 implements MdWebHeaderQueryReferenceIF

  {

  public MdWebHeaderQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebHeader mdWebHeader)
    {
      if(mdWebHeader == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdWebHeader.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebHeader mdWebHeader)
    {
      if(mdWebHeader == null) return this.NE((java.lang.String)null);
      return this.NE(mdWebHeader.getId());
    }

  public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText()
  {
    return getHeaderText(null);

  }
 
  public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias)
  {
    return (com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF)this.attributeFactory(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT, com.runwaysdk.system.metadata.MdAttributeLocalCharacter.CLASS, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF)this.attributeFactory(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT, com.runwaysdk.system.metadata.MdAttributeLocalCharacter.CLASS, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeLocal localFactory( com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdLocalStructDAOIF mdLocalStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT)) 
    {
       return new com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStruct((com.runwaysdk.dataaccess.MdAttributeLocalDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.localFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebHeaderQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryMultiReferenceIF
  {

    public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText();
    public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias);
    public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebHeaderQueryMultiReference extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryMultiReference
 implements MdWebHeaderQueryMultiReferenceIF

  {

  public MdWebHeaderQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader)  {

      String[] itemIdArray = new String[mdWebHeader.length]; 

      for (int i=0; i<mdWebHeader.length; i++)
      {
        itemIdArray[i] = mdWebHeader[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader)  {

      String[] itemIdArray = new String[mdWebHeader.length]; 

      for (int i=0; i<mdWebHeader.length; i++)
      {
        itemIdArray[i] = mdWebHeader[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader)  {

      String[] itemIdArray = new String[mdWebHeader.length]; 

      for (int i=0; i<mdWebHeader.length; i++)
      {
        itemIdArray[i] = mdWebHeader[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader)  {

      String[] itemIdArray = new String[mdWebHeader.length]; 

      for (int i=0; i<mdWebHeader.length; i++)
      {
        itemIdArray[i] = mdWebHeader[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebHeader ... mdWebHeader)  {

      String[] itemIdArray = new String[mdWebHeader.length]; 

      for (int i=0; i<mdWebHeader.length; i++)
      {
        itemIdArray[i] = mdWebHeader[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText()
  {
    return getHeaderText(null);

  }
 
  public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias)
  {
    return (com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF)this.attributeFactory(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT, com.runwaysdk.system.metadata.MdAttributeLocalCharacter.CLASS, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF getHeaderText(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStructIF)this.attributeFactory(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT, com.runwaysdk.system.metadata.MdAttributeLocalCharacter.CLASS, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeLocal localFactory( com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdLocalStructDAOIF mdLocalStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdWebHeader.HEADERTEXT)) 
    {
       return new com.runwaysdk.system.metadata.MdWebHeaderHeaderTextQuery.MdWebHeaderHeaderTextQueryStruct((com.runwaysdk.dataaccess.MdAttributeLocalDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.localFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
