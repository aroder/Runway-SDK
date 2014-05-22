package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 102218597)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeStruct.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdAttributeStructQuery extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery

{

  public MdAttributeStructQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdAttributeStructQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdAttributeStruct.CLASS;
  }
  public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct()
  {
    return getMdStruct(null);

  }
 
  public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT);

    return (com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT);

    return (com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT)) 
    {
       return new com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public com.runwaysdk.query.OIterator<? extends MdAttributeStruct> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdAttributeStruct>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeStructQueryReferenceIF extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryReferenceIF
  {

    public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct();
    public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias);
    public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeStruct mdAttributeStruct);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeStruct mdAttributeStruct);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeStructQueryReference extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryReference
 implements MdAttributeStructQueryReferenceIF

  {

  public MdAttributeStructQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeStruct mdAttributeStruct)
    {
      if(mdAttributeStruct == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdAttributeStruct.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeStruct mdAttributeStruct)
    {
      if(mdAttributeStruct == null) return this.NE((java.lang.String)null);
      return this.NE(mdAttributeStruct.getId());
    }

  public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct()
  {
    return getMdStruct(null);

  }
 
  public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias)
  {
    return (com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT)) 
    {
       return new com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public interface MdAttributeStructQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryMultiReferenceIF
  {

    public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct();
    public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias);
    public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeStructQueryMultiReference extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryMultiReference
 implements MdAttributeStructQueryMultiReferenceIF

  {

  public MdAttributeStructQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct)  {

      String[] itemIdArray = new String[mdAttributeStruct.length]; 

      for (int i=0; i<mdAttributeStruct.length; i++)
      {
        itemIdArray[i] = mdAttributeStruct[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct)  {

      String[] itemIdArray = new String[mdAttributeStruct.length]; 

      for (int i=0; i<mdAttributeStruct.length; i++)
      {
        itemIdArray[i] = mdAttributeStruct[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct)  {

      String[] itemIdArray = new String[mdAttributeStruct.length]; 

      for (int i=0; i<mdAttributeStruct.length; i++)
      {
        itemIdArray[i] = mdAttributeStruct[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct)  {

      String[] itemIdArray = new String[mdAttributeStruct.length]; 

      for (int i=0; i<mdAttributeStruct.length; i++)
      {
        itemIdArray[i] = mdAttributeStruct[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeStruct ... mdAttributeStruct)  {

      String[] itemIdArray = new String[mdAttributeStruct.length]; 

      for (int i=0; i<mdAttributeStruct.length; i++)
      {
        itemIdArray[i] = mdAttributeStruct[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct()
  {
    return getMdStruct(null);

  }
 
  public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias)
  {
    return (com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF getMdStruct(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeStruct.MDSTRUCT)) 
    {
       return new com.runwaysdk.system.metadata.MdStructQuery.MdStructQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
