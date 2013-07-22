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

@com.runwaysdk.business.ClassSignature(hash = -535884676)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to WebGroupField.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class WebGroupFieldQuery extends com.runwaysdk.system.metadata.MetadataRelationshipQuery
{

  public WebGroupFieldQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
     super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.RelationshipQuery relationshipQuery = componentQueryFactory.relationshipQuery(this.getClassType());

       this.setRelationshipQuery(relationshipQuery);
    }
  }

  public WebGroupFieldQuery(com.runwaysdk.query.ValueQuery valueQuery)
  {
    super(valueQuery);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.RelationshipQuery relationshipQuery = new com.runwaysdk.business.RelationshipQuery(valueQuery, this.getClassType());

       this.setRelationshipQuery(relationshipQuery);
    }
  }

  public String getClassType()
  {
    return com.runwaysdk.system.metadata.WebGroupField.CLASS;
  }
  /**
   * Restricts the query to include objects that are children in this relationship.
   * @param mdWebFieldQuery
   * @return Condition restricting objects that are children in this relationship.
   */
   public com.runwaysdk.query.Condition hasChild(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
   {
     return this.getRelationshipQuery().hasChild(mdWebFieldQuery);
   }
  /**
   * Restricts the query to include objects that are children in this relationship.
   * @param mdWebFieldQuery
   * @return Condition restricting objects that are children in this relationship.
   */
   public com.runwaysdk.query.Condition doesNotHaveChild(com.runwaysdk.system.metadata.MdWebFieldQuery mdWebFieldQuery)
   {
     return this.getRelationshipQuery().doesNotHaveChild(mdWebFieldQuery);
   }
  /**
   * Restricts the query to include objects that are parents in this relationship.
   * @param mdWebGroupQuery
   * @return Condition restricting objects that are parents in this relationship.
   */
   public com.runwaysdk.query.Condition hasParent(com.runwaysdk.system.metadata.MdWebGroupQuery mdWebGroupQuery)
   {
     return this.getRelationshipQuery().hasParent(mdWebGroupQuery);
   }
  /**
   * Restricts the query to include objects that are parents in this relationship.
   * @param mdWebGroupQuery
   * @return Condition restricting objects that are parents in this relationship.
   */
   public com.runwaysdk.query.Condition doesNotHaveParent(com.runwaysdk.system.metadata.MdWebGroupQuery mdWebGroupQuery)
   {
     return this.getRelationshipQuery().doesNotHaveParent(mdWebGroupQuery);
   }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends WebGroupField> getIterator()
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
    return new com.runwaysdk.business.RelationshipIterator<WebGroupField>(this.getComponentQuery().getMdEntityIF(), this.getRelationshipQuery(), columnInfoMap, results);
  }

}