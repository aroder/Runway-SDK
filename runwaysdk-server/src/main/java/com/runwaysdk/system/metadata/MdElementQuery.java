package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -112376017)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdElement.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdElementQuery extends com.runwaysdk.system.metadata.MdEntityQuery

{

  public MdElementQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdElementQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdElement.CLASS;
  }
  public com.runwaysdk.query.SelectableBoolean getExtendable()
  {
    return getExtendable(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getExtendable(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdElement.EXTENDABLE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getExtendable(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdElement.EXTENDABLE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getIsAbstract()
  {
    return getIsAbstract(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdElement.ISABSTRACT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdElement.ISABSTRACT, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdElement> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdElement>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdElementQueryReferenceIF extends com.runwaysdk.system.metadata.MdEntityQuery.MdEntityQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableBoolean getExtendable();
    public com.runwaysdk.query.SelectableBoolean getExtendable(String alias);
    public com.runwaysdk.query.SelectableBoolean getExtendable(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBoolean getIsAbstract();
    public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias);
    public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdElement mdElement);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdElement mdElement);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdElementQueryReference extends com.runwaysdk.system.metadata.MdEntityQuery.MdEntityQueryReference
 implements MdElementQueryReferenceIF

  {

  public MdElementQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdElement mdElement)
    {
      if(mdElement == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdElement.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdElement mdElement)
    {
      if(mdElement == null) return this.NE((java.lang.String)null);
      return this.NE(mdElement.getId());
    }

  public com.runwaysdk.query.SelectableBoolean getExtendable()
  {
    return getExtendable(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getExtendable(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdElement.EXTENDABLE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getExtendable(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdElement.EXTENDABLE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getIsAbstract()
  {
    return getIsAbstract(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdElement.ISABSTRACT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdElement.ISABSTRACT, alias, displayLabel);

  }
  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdElementQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdEntityQuery.MdEntityQueryMultiReferenceIF
  {

    public com.runwaysdk.query.SelectableBoolean getExtendable();
    public com.runwaysdk.query.SelectableBoolean getExtendable(String alias);
    public com.runwaysdk.query.SelectableBoolean getExtendable(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBoolean getIsAbstract();
    public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias);
    public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdElement ... mdElement);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdElement ... mdElement);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdElement ... mdElement);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdElement ... mdElement);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdElement ... mdElement);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdElementQueryMultiReference extends com.runwaysdk.system.metadata.MdEntityQuery.MdEntityQueryMultiReference
 implements MdElementQueryMultiReferenceIF

  {

  public MdElementQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdElement ... mdElement)  {

      String[] itemIdArray = new String[mdElement.length]; 

      for (int i=0; i<mdElement.length; i++)
      {
        itemIdArray[i] = mdElement[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdElement ... mdElement)  {

      String[] itemIdArray = new String[mdElement.length]; 

      for (int i=0; i<mdElement.length; i++)
      {
        itemIdArray[i] = mdElement[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdElement ... mdElement)  {

      String[] itemIdArray = new String[mdElement.length]; 

      for (int i=0; i<mdElement.length; i++)
      {
        itemIdArray[i] = mdElement[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdElement ... mdElement)  {

      String[] itemIdArray = new String[mdElement.length]; 

      for (int i=0; i<mdElement.length; i++)
      {
        itemIdArray[i] = mdElement[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdElement ... mdElement)  {

      String[] itemIdArray = new String[mdElement.length]; 

      for (int i=0; i<mdElement.length; i++)
      {
        itemIdArray[i] = mdElement[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.query.SelectableBoolean getExtendable()
  {
    return getExtendable(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getExtendable(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdElement.EXTENDABLE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getExtendable(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdElement.EXTENDABLE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getIsAbstract()
  {
    return getIsAbstract(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdElement.ISABSTRACT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getIsAbstract(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdElement.ISABSTRACT, alias, displayLabel);

  }
  }
}
