/*******************************************************************************
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
 ******************************************************************************/
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 1046293668)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to CompositeFieldCondition.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class CompositeFieldConditionQuery extends com.runwaysdk.system.metadata.FieldConditionQuery

{

  public CompositeFieldConditionQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public CompositeFieldConditionQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.CompositeFieldCondition.CLASS;
  }
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getFirstCondition()
  {
    return getFirstCondition(null);

  }
 
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getFirstCondition(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.CompositeFieldCondition.FIRSTCONDITION);

    return (com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.CompositeFieldCondition.FIRSTCONDITION, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getFirstCondition(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.CompositeFieldCondition.FIRSTCONDITION);

    return (com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.CompositeFieldCondition.FIRSTCONDITION, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getSecondCondition()
  {
    return getSecondCondition(null);

  }
 
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getSecondCondition(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.CompositeFieldCondition.SECONDCONDITION);

    return (com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.CompositeFieldCondition.SECONDCONDITION, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getSecondCondition(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.CompositeFieldCondition.SECONDCONDITION);

    return (com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.CompositeFieldCondition.SECONDCONDITION, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.CompositeFieldCondition.FIRSTCONDITION)) 
    {
       return new com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.CompositeFieldCondition.SECONDCONDITION)) 
    {
       return new com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public com.runwaysdk.query.OIterator<? extends CompositeFieldCondition> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<CompositeFieldCondition>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface CompositeFieldConditionQueryReferenceIF extends com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF
  {

    public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getFirstCondition();
    public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getFirstCondition(String alias);
    public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getFirstCondition(String alias, String displayLabel);
    public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getSecondCondition();
    public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getSecondCondition(String alias);
    public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getSecondCondition(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.CompositeFieldCondition compositeFieldCondition);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.CompositeFieldCondition compositeFieldCondition);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class CompositeFieldConditionQueryReference extends com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReference
 implements CompositeFieldConditionQueryReferenceIF

  {

  public CompositeFieldConditionQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.CompositeFieldCondition compositeFieldCondition)
    {
      if(compositeFieldCondition == null) return this.EQ((java.lang.String)null);
      return this.EQ(compositeFieldCondition.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.CompositeFieldCondition compositeFieldCondition)
    {
      if(compositeFieldCondition == null) return this.NE((java.lang.String)null);
      return this.NE(compositeFieldCondition.getId());
    }

  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getFirstCondition()
  {
    return getFirstCondition(null);

  }
 
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getFirstCondition(String alias)
  {
    return (com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF)this.get(com.runwaysdk.system.metadata.CompositeFieldCondition.FIRSTCONDITION, alias, null);

  }
 
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getFirstCondition(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF)this.get(com.runwaysdk.system.metadata.CompositeFieldCondition.FIRSTCONDITION,  alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getSecondCondition()
  {
    return getSecondCondition(null);

  }
 
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getSecondCondition(String alias)
  {
    return (com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF)this.get(com.runwaysdk.system.metadata.CompositeFieldCondition.SECONDCONDITION, alias, null);

  }
 
  public com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF getSecondCondition(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReferenceIF)this.get(com.runwaysdk.system.metadata.CompositeFieldCondition.SECONDCONDITION,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.CompositeFieldCondition.FIRSTCONDITION)) 
    {
       return new com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.metadata.CompositeFieldCondition.SECONDCONDITION)) 
    {
       return new com.runwaysdk.system.metadata.FieldConditionQuery.FieldConditionQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}