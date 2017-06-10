package com.runwaysdk.system;

@com.runwaysdk.business.ClassSignature(hash = 562134237)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to Ratio.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class RatioQuery extends com.runwaysdk.system.RatioElementQuery

{

  public RatioQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public RatioQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.Ratio.CLASS;
  }
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand()
  {
    return getLeftOperand(null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Ratio.LEFTOPERAND);

    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Ratio.LEFTOPERAND, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Ratio.LEFTOPERAND);

    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Ratio.LEFTOPERAND, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator()
  {
    return getOperator(null);

  }
 
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Ratio.OPERATOR);

    return (com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Ratio.OPERATOR, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Ratio.OPERATOR);

    return (com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Ratio.OPERATOR, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand()
  {
    return getRightOperand(null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Ratio.RIGHTOPERAND);

    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Ratio.RIGHTOPERAND, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Ratio.RIGHTOPERAND);

    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Ratio.RIGHTOPERAND, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.Ratio.LEFTOPERAND)) 
    {
       return new com.runwaysdk.system.RatioElementQuery.RatioElementQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Ratio.RIGHTOPERAND)) 
    {
       return new com.runwaysdk.system.RatioElementQuery.RatioElementQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  protected com.runwaysdk.query.AttributeEnumeration enumerationFactory( com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  String mdEnumerationTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF masterListMdBusinessIF, String masterListTalbeAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.Ratio.OPERATOR)) 
    {
       return new com.runwaysdk.system.MathOperatorQuery.RatioOperatorQuery((com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.enumerationFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends Ratio> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<Ratio>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface RatioQueryReferenceIF extends com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF
  {

    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand();
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias);
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias, String displayLabel);
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator();
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias);
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias, String displayLabel);
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand();
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias);
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.Ratio ratio);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.Ratio ratio);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class RatioQueryReference extends com.runwaysdk.system.RatioElementQuery.RatioElementQueryReference
 implements RatioQueryReferenceIF

  {

  public RatioQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.Ratio ratio)
    {
      if(ratio == null) return this.EQ((java.lang.String)null);
      return this.EQ(ratio.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.Ratio ratio)
    {
      if(ratio == null) return this.NE((java.lang.String)null);
      return this.NE(ratio.getId());
    }

  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand()
  {
    return getLeftOperand(null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias)
  {
    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.get(com.runwaysdk.system.Ratio.LEFTOPERAND, alias, null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.get(com.runwaysdk.system.Ratio.LEFTOPERAND,  alias, displayLabel);

  }
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator()
  {
    return getOperator(null);

  }
 
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias)
  {
    return (com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF)this.get(com.runwaysdk.system.Ratio.OPERATOR, alias, null);

  }
 
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF)this.get(com.runwaysdk.system.Ratio.OPERATOR, alias, displayLabel);

  }
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand()
  {
    return getRightOperand(null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias)
  {
    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.get(com.runwaysdk.system.Ratio.RIGHTOPERAND, alias, null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.get(com.runwaysdk.system.Ratio.RIGHTOPERAND,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.Ratio.LEFTOPERAND)) 
    {
       return new com.runwaysdk.system.RatioElementQuery.RatioElementQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Ratio.RIGHTOPERAND)) 
    {
       return new com.runwaysdk.system.RatioElementQuery.RatioElementQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  protected com.runwaysdk.query.AttributeEnumeration enumerationFactory( com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  String mdEnumerationTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF masterListMdBusinessIF, String masterListTalbeAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.Ratio.OPERATOR)) 
    {
       return new com.runwaysdk.system.MathOperatorQuery.RatioOperatorQuery((com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.enumerationFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface RatioQueryMultiReferenceIF extends com.runwaysdk.system.RatioElementQuery.RatioElementQueryMultiReferenceIF
  {

    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand();
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias);
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias, String displayLabel);
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator();
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias);
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias, String displayLabel);
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand();
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias);
    public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.Ratio ... ratio);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.Ratio ... ratio);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.Ratio ... ratio);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.Ratio ... ratio);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.Ratio ... ratio);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class RatioQueryMultiReference extends com.runwaysdk.system.RatioElementQuery.RatioElementQueryMultiReference
 implements RatioQueryMultiReferenceIF

  {

  public RatioQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.Ratio ... ratio)  {

      String[] itemIdArray = new String[ratio.length]; 

      for (int i=0; i<ratio.length; i++)
      {
        itemIdArray[i] = ratio[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.Ratio ... ratio)  {

      String[] itemIdArray = new String[ratio.length]; 

      for (int i=0; i<ratio.length; i++)
      {
        itemIdArray[i] = ratio[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.Ratio ... ratio)  {

      String[] itemIdArray = new String[ratio.length]; 

      for (int i=0; i<ratio.length; i++)
      {
        itemIdArray[i] = ratio[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.Ratio ... ratio)  {

      String[] itemIdArray = new String[ratio.length]; 

      for (int i=0; i<ratio.length; i++)
      {
        itemIdArray[i] = ratio[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.Ratio ... ratio)  {

      String[] itemIdArray = new String[ratio.length]; 

      for (int i=0; i<ratio.length; i++)
      {
        itemIdArray[i] = ratio[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand()
  {
    return getLeftOperand(null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias)
  {
    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.get(com.runwaysdk.system.Ratio.LEFTOPERAND, alias, null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getLeftOperand(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.get(com.runwaysdk.system.Ratio.LEFTOPERAND,  alias, displayLabel);

  }
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator()
  {
    return getOperator(null);

  }
 
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias)
  {
    return (com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF)this.get(com.runwaysdk.system.Ratio.OPERATOR, alias, null);

  }
 
  public com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF getOperator(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.MathOperatorQuery.RatioOperatorQueryIF)this.get(com.runwaysdk.system.Ratio.OPERATOR, alias, displayLabel);

  }
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand()
  {
    return getRightOperand(null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias)
  {
    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.get(com.runwaysdk.system.Ratio.RIGHTOPERAND, alias, null);

  }
 
  public com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF getRightOperand(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.RatioElementQuery.RatioElementQueryReferenceIF)this.get(com.runwaysdk.system.Ratio.RIGHTOPERAND,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.Ratio.LEFTOPERAND)) 
    {
       return new com.runwaysdk.system.RatioElementQuery.RatioElementQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Ratio.RIGHTOPERAND)) 
    {
       return new com.runwaysdk.system.RatioElementQuery.RatioElementQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  protected com.runwaysdk.query.AttributeEnumeration enumerationFactory( com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  String mdEnumerationTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF masterListMdBusinessIF, String masterListTalbeAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.Ratio.OPERATOR)) 
    {
       return new com.runwaysdk.system.MathOperatorQuery.RatioOperatorQuery((com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.enumerationFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
