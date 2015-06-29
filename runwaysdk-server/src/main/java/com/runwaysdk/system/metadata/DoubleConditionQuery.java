/**
 * Copyright (c) 2013 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Runway SDK(tm).
 *
 * Runway SDK(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Runway SDK(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Runway SDK(tm).  If not, see <http://www.gnu.org/licenses/>.
 */
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 30545616)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to DoubleCondition.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class DoubleConditionQuery extends com.runwaysdk.system.metadata.FieldConditionQuery

{

  public DoubleConditionQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public DoubleConditionQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.DoubleCondition.CLASS;
  }
  public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField()
  {
    return getDefiningMdField(null);

  }
 
  public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD);

    return (com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD);

    return (com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation()
  {
    return getOperation(null);

  }
 
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.DoubleCondition.OPERATION);

    return (com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.DoubleCondition.OPERATION, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.DoubleCondition.OPERATION);

    return (com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.DoubleCondition.OPERATION, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableDouble getValue()
  {
    return getValue(null);

  }
 
  public com.runwaysdk.query.SelectableDouble getValue(String alias)
  {
    return (com.runwaysdk.query.SelectableDouble)this.getComponentQuery().get(com.runwaysdk.system.metadata.DoubleCondition.VALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableDouble getValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableDouble)this.getComponentQuery().get(com.runwaysdk.system.metadata.DoubleCondition.VALUE, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD)) 
    {
       return new com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  protected com.runwaysdk.query.AttributeEnumeration enumerationFactory( com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  String mdEnumerationTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF masterListMdBusinessIF, String masterListTalbeAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.DoubleCondition.OPERATION)) 
    {
       return new com.runwaysdk.system.FieldOperationQuery.AllOperationQuery((com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public com.runwaysdk.query.OIterator<? extends DoubleCondition> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<DoubleCondition>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface DoubleConditionQueryReferenceIF extends com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF
  {

    public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField();
    public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias);
    public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias, String displayLabel);
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation();
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias);
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableDouble getValue();
    public com.runwaysdk.query.SelectableDouble getValue(String alias);
    public com.runwaysdk.query.SelectableDouble getValue(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.DoubleCondition doubleCondition);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.DoubleCondition doubleCondition);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class DoubleConditionQueryReference extends com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReference
 implements DoubleConditionQueryReferenceIF

  {

  public DoubleConditionQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.DoubleCondition doubleCondition)
    {
      if(doubleCondition == null) return this.EQ((java.lang.String)null);
      return this.EQ(doubleCondition.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.DoubleCondition doubleCondition)
    {
      if(doubleCondition == null) return this.NE((java.lang.String)null);
      return this.NE(doubleCondition.getId());
    }

  public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField()
  {
    return getDefiningMdField(null);

  }
 
  public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias)
  {
    return (com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF)this.get(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF)this.get(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD,  alias, displayLabel);

  }
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation()
  {
    return getOperation(null);

  }
 
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias)
  {
    return (com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF)this.get(com.runwaysdk.system.metadata.DoubleCondition.OPERATION, alias, null);

  }
 
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF)this.get(com.runwaysdk.system.metadata.DoubleCondition.OPERATION, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableDouble getValue()
  {
    return getValue(null);

  }
 
  public com.runwaysdk.query.SelectableDouble getValue(String alias)
  {
    return (com.runwaysdk.query.SelectableDouble)this.get(com.runwaysdk.system.metadata.DoubleCondition.VALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableDouble getValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableDouble)this.get(com.runwaysdk.system.metadata.DoubleCondition.VALUE, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD)) 
    {
       return new com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  protected com.runwaysdk.query.AttributeEnumeration enumerationFactory( com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  String mdEnumerationTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF masterListMdBusinessIF, String masterListTalbeAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.DoubleCondition.OPERATION)) 
    {
       return new com.runwaysdk.system.FieldOperationQuery.AllOperationQuery((com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public interface DoubleConditionQueryMultiReferenceIF extends com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryMultiReferenceIF
  {

    public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField();
    public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias);
    public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias, String displayLabel);
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation();
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias);
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableDouble getValue();
    public com.runwaysdk.query.SelectableDouble getValue(String alias);
    public com.runwaysdk.query.SelectableDouble getValue(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class DoubleConditionQueryMultiReference extends com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryMultiReference
 implements DoubleConditionQueryMultiReferenceIF

  {

  public DoubleConditionQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition)  {

      String[] itemIdArray = new String[doubleCondition.length]; 

      for (int i=0; i<doubleCondition.length; i++)
      {
        itemIdArray[i] = doubleCondition[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition)  {

      String[] itemIdArray = new String[doubleCondition.length]; 

      for (int i=0; i<doubleCondition.length; i++)
      {
        itemIdArray[i] = doubleCondition[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition)  {

      String[] itemIdArray = new String[doubleCondition.length]; 

      for (int i=0; i<doubleCondition.length; i++)
      {
        itemIdArray[i] = doubleCondition[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition)  {

      String[] itemIdArray = new String[doubleCondition.length]; 

      for (int i=0; i<doubleCondition.length; i++)
      {
        itemIdArray[i] = doubleCondition[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.DoubleCondition ... doubleCondition)  {

      String[] itemIdArray = new String[doubleCondition.length]; 

      for (int i=0; i<doubleCondition.length; i++)
      {
        itemIdArray[i] = doubleCondition[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField()
  {
    return getDefiningMdField(null);

  }
 
  public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias)
  {
    return (com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF)this.get(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF getDefiningMdField(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReferenceIF)this.get(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD,  alias, displayLabel);

  }
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation()
  {
    return getOperation(null);

  }
 
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias)
  {
    return (com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF)this.get(com.runwaysdk.system.metadata.DoubleCondition.OPERATION, alias, null);

  }
 
  public com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF getOperation(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.FieldOperationQuery.AllOperationQueryIF)this.get(com.runwaysdk.system.metadata.DoubleCondition.OPERATION, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableDouble getValue()
  {
    return getValue(null);

  }
 
  public com.runwaysdk.query.SelectableDouble getValue(String alias)
  {
    return (com.runwaysdk.query.SelectableDouble)this.get(com.runwaysdk.system.metadata.DoubleCondition.VALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableDouble getValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableDouble)this.get(com.runwaysdk.system.metadata.DoubleCondition.VALUE, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.DoubleCondition.DEFININGMDFIELD)) 
    {
       return new com.runwaysdk.system.metadata.MdFieldQuery.MdFieldQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  protected com.runwaysdk.query.AttributeEnumeration enumerationFactory( com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  String mdEnumerationTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF masterListMdBusinessIF, String masterListTalbeAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.DoubleCondition.OPERATION)) 
    {
       return new com.runwaysdk.system.FieldOperationQuery.AllOperationQuery((com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.enumerationFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
