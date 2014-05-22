package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 251161096)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebAttribute.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdWebAttributeQuery extends com.runwaysdk.system.metadata.MdWebFieldQuery

{

  public MdWebAttributeQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdWebAttributeQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdWebAttribute.CLASS;
  }
  public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute()
  {
    return getDefiningMdAttribute(null);

  }
 
  public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE);

    return (com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE);

    return (com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE)) 
    {
       return new com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public com.runwaysdk.query.OIterator<? extends MdWebAttribute> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdWebAttribute>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebAttributeQueryReferenceIF extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryReferenceIF
  {

    public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute();
    public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias);
    public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebAttribute mdWebAttribute);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebAttribute mdWebAttribute);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebAttributeQueryReference extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryReference
 implements MdWebAttributeQueryReferenceIF

  {

  public MdWebAttributeQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebAttribute mdWebAttribute)
    {
      if(mdWebAttribute == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdWebAttribute.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebAttribute mdWebAttribute)
    {
      if(mdWebAttribute == null) return this.NE((java.lang.String)null);
      return this.NE(mdWebAttribute.getId());
    }

  public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute()
  {
    return getDefiningMdAttribute(null);

  }
 
  public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias)
  {
    return (com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE)) 
    {
       return new com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public interface MdWebAttributeQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryMultiReferenceIF
  {

    public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute();
    public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias);
    public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebAttributeQueryMultiReference extends com.runwaysdk.system.metadata.MdWebFieldQuery.MdWebFieldQueryMultiReference
 implements MdWebAttributeQueryMultiReferenceIF

  {

  public MdWebAttributeQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute)  {

      String[] itemIdArray = new String[mdWebAttribute.length]; 

      for (int i=0; i<mdWebAttribute.length; i++)
      {
        itemIdArray[i] = mdWebAttribute[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute)  {

      String[] itemIdArray = new String[mdWebAttribute.length]; 

      for (int i=0; i<mdWebAttribute.length; i++)
      {
        itemIdArray[i] = mdWebAttribute[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute)  {

      String[] itemIdArray = new String[mdWebAttribute.length]; 

      for (int i=0; i<mdWebAttribute.length; i++)
      {
        itemIdArray[i] = mdWebAttribute[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute)  {

      String[] itemIdArray = new String[mdWebAttribute.length]; 

      for (int i=0; i<mdWebAttribute.length; i++)
      {
        itemIdArray[i] = mdWebAttribute[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdWebAttribute ... mdWebAttribute)  {

      String[] itemIdArray = new String[mdWebAttribute.length]; 

      for (int i=0; i<mdWebAttribute.length; i++)
      {
        itemIdArray[i] = mdWebAttribute[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute()
  {
    return getDefiningMdAttribute(null);

  }
 
  public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias)
  {
    return (com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF getDefiningMdAttribute(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdWebAttribute.DEFININGMDATTRIBUTE)) 
    {
       return new com.runwaysdk.system.metadata.MdAttributeQuery.MdAttributeQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
