package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -1703627475)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeMultiReference.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdAttributeMultiReferenceQuery extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery

{

  public MdAttributeMultiReferenceQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdAttributeMultiReferenceQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdAttributeMultiReference.CLASS;
  }
  public com.runwaysdk.query.SelectableChar getDefaultValue()
  {
    return getDefaultValue(null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdAttributeMultiReference.DEFAULTVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdAttributeMultiReference.DEFAULTVALUE, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness()
  {
    return getMdBusiness(null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdAttributeMultiReference.MDBUSINESS);

    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdAttributeMultiReference.MDBUSINESS, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdAttributeMultiReference.MDBUSINESS);

    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdAttributeMultiReference.MDBUSINESS, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getTableName()
  {
    return getTableName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getTableName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdAttributeMultiReference.TABLENAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getTableName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdAttributeMultiReference.TABLENAME, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeMultiReference.MDBUSINESS)) 
    {
       return new com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public com.runwaysdk.query.OIterator<? extends MdAttributeMultiReference> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdAttributeMultiReference>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeMultiReferenceQueryReferenceIF extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getDefaultValue();
    public com.runwaysdk.query.SelectableChar getDefaultValue(String alias);
    public com.runwaysdk.query.SelectableChar getDefaultValue(String alias, String displayLabel);
    public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness();
    public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias);
    public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getTableName();
    public com.runwaysdk.query.SelectableChar getTableName(String alias);
    public com.runwaysdk.query.SelectableChar getTableName(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeMultiReference mdAttributeMultiReference);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeMultiReference mdAttributeMultiReference);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeMultiReferenceQueryReference extends com.runwaysdk.system.metadata.MdAttributeConcreteQuery.MdAttributeConcreteQueryReference
 implements MdAttributeMultiReferenceQueryReferenceIF

  {

  public MdAttributeMultiReferenceQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeMultiReference mdAttributeMultiReference)
    {
      if(mdAttributeMultiReference == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdAttributeMultiReference.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeMultiReference mdAttributeMultiReference)
    {
      if(mdAttributeMultiReference == null) return this.NE((java.lang.String)null);
      return this.NE(mdAttributeMultiReference.getId());
    }

  public com.runwaysdk.query.SelectableChar getDefaultValue()
  {
    return getDefaultValue(null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdAttributeMultiReference.DEFAULTVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdAttributeMultiReference.DEFAULTVALUE, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness()
  {
    return getMdBusiness(null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias)
  {
    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeMultiReference.MDBUSINESS, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeMultiReference.MDBUSINESS,  alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getTableName()
  {
    return getTableName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getTableName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdAttributeMultiReference.TABLENAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getTableName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdAttributeMultiReference.TABLENAME, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeMultiReference.MDBUSINESS)) 
    {
       return new com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
