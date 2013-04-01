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

@com.runwaysdk.business.ClassSignature(hash = 355445336)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebForm.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdWebFormQuery extends com.runwaysdk.system.metadata.MdFormQuery

{

  public MdWebFormQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdWebFormQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdWebForm.CLASS;
  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdWebForm> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdWebForm>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


  public com.runwaysdk.query.Condition mdFields()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_mdFields()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition mdFields(com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    return this.getBusinessQuery().isParentIn(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_mdFields(com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    return this.getBusinessQuery().isParentIn_SUBSELECT(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdWebFieldQuery));

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdWebFieldQuery));

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    webFormFieldQuery.AND(webFormFieldQuery.hasChild(mdWebFieldQuery));
    return this.getBusinessQuery().isParentIn(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    webFormFieldQuery.AND(webFormFieldQuery.hasChild(mdWebFieldQuery));
    return this.getBusinessQuery().isParentIn_SUBSELECT(webFormFieldQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_mdFields()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_mdFields(com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    return this.getBusinessQuery().isNotParentIn(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields(com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdWebFieldQuery));

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdWebFieldQuery));

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    webFormFieldQuery.AND(webFormFieldQuery.hasChild(mdWebFieldQuery));
    return this.getBusinessQuery().isNotParentIn(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    webFormFieldQuery.AND(webFormFieldQuery.hasChild(mdWebFieldQuery));
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(webFormFieldQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdWebFormQueryReferenceIF extends com.runwaysdk.system.metadata.MdFormQuery.MdFormQueryReferenceIF
  {


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebForm mdWebForm);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebForm mdWebForm);


  public com.runwaysdk.query.Condition mdFields();

  public com.runwaysdk.query.Condition mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery);

  public com.runwaysdk.query.Condition mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery);


  public com.runwaysdk.query.Condition SUBSELECT_mdFields();

  public com.runwaysdk.query.Condition SUBSELECT_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery);

  public com.runwaysdk.query.Condition SUBSELECT_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery);


  public com.runwaysdk.query.Condition NOT_IN_mdFields();

  public com.runwaysdk.query.Condition NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery);

  public com.runwaysdk.query.Condition NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery);


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields();

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery);

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdWebFormQueryReference extends com.runwaysdk.system.metadata.MdFormQuery.MdFormQueryReference
 implements MdWebFormQueryReferenceIF

  {

  public MdWebFormQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdWebForm mdWebForm)
    {
      if(mdWebForm == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdWebForm.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdWebForm mdWebForm)
    {
      if(mdWebForm == null) return this.NE((java.lang.String)null);
      return this.NE(mdWebForm.getId());
    }


  public com.runwaysdk.query.Condition mdFields()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);

    return this.isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_mdFields()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition mdFields(com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    return this.isParentIn(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_mdFields(com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    return this.isParentIn_SUBSELECT(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdWebFieldQuery));

    return this.isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdWebFieldQuery));

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    webFormFieldQuery.AND(webFormFieldQuery.hasChild(mdWebFieldQuery));
    return this.isParentIn(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    webFormFieldQuery.AND(webFormFieldQuery.hasChild(mdWebFieldQuery));
    return this.isParentIn_SUBSELECT(webFormFieldQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_mdFields()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);

    return this.isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_mdFields(com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    return this.isNotParentIn(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields(com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    return this.isNotParentIn_SUBSELECT(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdWebFieldQuery));

    return this.isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.WebFormField.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdWebFieldQuery));

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    webFormFieldQuery.AND(webFormFieldQuery.hasChild(mdWebFieldQuery));
    return this.isNotParentIn(webFormFieldQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_mdFields(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery, com.runwaysdk.system.metadata.WebFormFieldQuery webFormFieldQuery)
  {
    webFormFieldQuery.AND(webFormFieldQuery.hasChild(mdWebFieldQuery));
    return this.isNotParentIn_SUBSELECT(webFormFieldQuery);
  }

  }
}
