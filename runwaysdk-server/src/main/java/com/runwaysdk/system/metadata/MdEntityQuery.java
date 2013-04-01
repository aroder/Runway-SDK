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

@com.runwaysdk.business.ClassSignature(hash = 1102759420)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdEntity.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdEntityQuery extends com.runwaysdk.system.metadata.MdClassQuery

{

  public MdEntityQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdEntityQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdEntity.CLASS;
  }
  public com.runwaysdk.query.SelectableInteger getCacheSize()
  {
    return getCacheSize(null);

  }
 
  public com.runwaysdk.query.SelectableInteger getCacheSize(String alias)
  {
    return (com.runwaysdk.query.SelectableInteger)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.CACHESIZE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableInteger getCacheSize(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableInteger)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.CACHESIZE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getEnforceSiteMaster()
  {
    return getEnforceSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getEnforceSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.ENFORCESITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getEnforceSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.ENFORCESITEMASTER, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getQueryClass()
  {
    return getQueryClass(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getQueryClass(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.QUERYCLASS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getQueryClass(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.QUERYCLASS, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getQueryDTOclass()
  {
    return getQueryDTOclass(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getQueryDTOclass(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.QUERYDTOCLASS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getQueryDTOclass(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.QUERYDTOCLASS, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getQueryDTOsource()
  {
    return getQueryDTOsource(null);

  }
 
  public com.runwaysdk.query.SelectableChar getQueryDTOsource(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.QUERYDTOSOURCE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getQueryDTOsource(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.QUERYDTOSOURCE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getQuerySource()
  {
    return getQuerySource(null);

  }
 
  public com.runwaysdk.query.SelectableChar getQuerySource(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.QUERYSOURCE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getQuerySource(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.QUERYSOURCE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getTableName()
  {
    return getTableName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getTableName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.TABLENAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getTableName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdEntity.TABLENAME, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdEntity> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdEntity>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


  public com.runwaysdk.query.Condition index()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_index()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition index(com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    return this.getBusinessQuery().isParentIn(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_index(com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    return this.getBusinessQuery().isParentIn_SUBSELECT(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdIndexQuery));

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdIndexQuery));

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    entityIndexQuery.AND(entityIndexQuery.hasChild(mdIndexQuery));
    return this.getBusinessQuery().isParentIn(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    entityIndexQuery.AND(entityIndexQuery.hasChild(mdIndexQuery));
    return this.getBusinessQuery().isParentIn_SUBSELECT(entityIndexQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_index()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_index(com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    return this.getBusinessQuery().isNotParentIn(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index(com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdIndexQuery));

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdIndexQuery));

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    entityIndexQuery.AND(entityIndexQuery.hasChild(mdIndexQuery));
    return this.getBusinessQuery().isNotParentIn(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    entityIndexQuery.AND(entityIndexQuery.hasChild(mdIndexQuery));
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(entityIndexQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdEntityQueryReferenceIF extends com.runwaysdk.system.metadata.MdClassQuery.MdClassQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableInteger getCacheSize();
    public com.runwaysdk.query.SelectableInteger getCacheSize(String alias);
    public com.runwaysdk.query.SelectableInteger getCacheSize(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBoolean getEnforceSiteMaster();
    public com.runwaysdk.query.SelectableBoolean getEnforceSiteMaster(String alias);
    public com.runwaysdk.query.SelectableBoolean getEnforceSiteMaster(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBlob getQueryClass();
    public com.runwaysdk.query.SelectableBlob getQueryClass(String alias);
    public com.runwaysdk.query.SelectableBlob getQueryClass(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBlob getQueryDTOclass();
    public com.runwaysdk.query.SelectableBlob getQueryDTOclass(String alias);
    public com.runwaysdk.query.SelectableBlob getQueryDTOclass(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getQueryDTOsource();
    public com.runwaysdk.query.SelectableChar getQueryDTOsource(String alias);
    public com.runwaysdk.query.SelectableChar getQueryDTOsource(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getQuerySource();
    public com.runwaysdk.query.SelectableChar getQuerySource(String alias);
    public com.runwaysdk.query.SelectableChar getQuerySource(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getTableName();
    public com.runwaysdk.query.SelectableChar getTableName(String alias);
    public com.runwaysdk.query.SelectableChar getTableName(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdEntity mdEntity);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdEntity mdEntity);


  public com.runwaysdk.query.Condition index();

  public com.runwaysdk.query.Condition index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery);

  public com.runwaysdk.query.Condition index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery);


  public com.runwaysdk.query.Condition SUBSELECT_index();

  public com.runwaysdk.query.Condition SUBSELECT_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery);

  public com.runwaysdk.query.Condition SUBSELECT_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery);


  public com.runwaysdk.query.Condition NOT_IN_index();

  public com.runwaysdk.query.Condition NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery);

  public com.runwaysdk.query.Condition NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery);


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index();

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery);

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdEntityQueryReference extends com.runwaysdk.system.metadata.MdClassQuery.MdClassQueryReference
 implements MdEntityQueryReferenceIF

  {

  public MdEntityQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdEntity mdEntity)
    {
      if(mdEntity == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdEntity.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdEntity mdEntity)
    {
      if(mdEntity == null) return this.NE((java.lang.String)null);
      return this.NE(mdEntity.getId());
    }

  public com.runwaysdk.query.SelectableInteger getCacheSize()
  {
    return getCacheSize(null);

  }
 
  public com.runwaysdk.query.SelectableInteger getCacheSize(String alias)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdEntity.CACHESIZE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableInteger getCacheSize(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableInteger)this.get(com.runwaysdk.system.metadata.MdEntity.CACHESIZE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBoolean getEnforceSiteMaster()
  {
    return getEnforceSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getEnforceSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdEntity.ENFORCESITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBoolean getEnforceSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBoolean)this.get(com.runwaysdk.system.metadata.MdEntity.ENFORCESITEMASTER, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getQueryClass()
  {
    return getQueryClass(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getQueryClass(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdEntity.QUERYCLASS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getQueryClass(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdEntity.QUERYCLASS, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getQueryDTOclass()
  {
    return getQueryDTOclass(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getQueryDTOclass(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdEntity.QUERYDTOCLASS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getQueryDTOclass(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdEntity.QUERYDTOCLASS, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getQueryDTOsource()
  {
    return getQueryDTOsource(null);

  }
 
  public com.runwaysdk.query.SelectableChar getQueryDTOsource(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdEntity.QUERYDTOSOURCE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getQueryDTOsource(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdEntity.QUERYDTOSOURCE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getQuerySource()
  {
    return getQuerySource(null);

  }
 
  public com.runwaysdk.query.SelectableChar getQuerySource(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdEntity.QUERYSOURCE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getQuerySource(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdEntity.QUERYSOURCE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getTableName()
  {
    return getTableName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getTableName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdEntity.TABLENAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getTableName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdEntity.TABLENAME, alias, displayLabel);

  }

  public com.runwaysdk.query.Condition index()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);

    return this.isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_index()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition index(com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    return this.isParentIn(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_index(com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    return this.isParentIn_SUBSELECT(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdIndexQuery));

    return this.isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdIndexQuery));

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    entityIndexQuery.AND(entityIndexQuery.hasChild(mdIndexQuery));
    return this.isParentIn(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    entityIndexQuery.AND(entityIndexQuery.hasChild(mdIndexQuery));
    return this.isParentIn_SUBSELECT(entityIndexQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_index()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);

    return this.isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_index(com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    return this.isNotParentIn(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index(com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    return this.isNotParentIn_SUBSELECT(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdIndexQuery));

    return this.isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EntityIndex.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdIndexQuery));

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    entityIndexQuery.AND(entityIndexQuery.hasChild(mdIndexQuery));
    return this.isNotParentIn(entityIndexQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_index(com.runwaysdk.system.metadata.MdIndexQuery mdIndexQuery, com.runwaysdk.system.metadata.EntityIndexQuery entityIndexQuery)
  {
    entityIndexQuery.AND(entityIndexQuery.hasChild(mdIndexQuery));
    return this.isNotParentIn_SUBSELECT(entityIndexQuery);
  }

  }
}
