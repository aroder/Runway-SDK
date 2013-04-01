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

@com.runwaysdk.business.ClassSignature(hash = 769115754)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdInformation.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdInformationQuery extends com.runwaysdk.system.metadata.MdMessageQuery

{

  public MdInformationQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdInformationQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdInformation.CLASS;
  }
  public com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF getSuperMdInformation()
  {
    return getSuperMdInformation(null);

  }
 
  public com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF getSuperMdInformation(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdInformation.SUPERMDINFORMATION);

    return (com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdInformation.SUPERMDINFORMATION, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF getSuperMdInformation(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdInformation.SUPERMDINFORMATION);

    return (com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdInformation.SUPERMDINFORMATION, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdInformation.SUPERMDINFORMATION)) 
    {
       return new com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public com.runwaysdk.query.OIterator<? extends MdInformation> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdInformation>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


  public com.runwaysdk.query.Condition superInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.getBusinessQuery().isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition superInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.getBusinessQuery().isChildIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.getBusinessQuery().isChildIn_SUBSELECT(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdInformationQuery));

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdInformationQuery));

    return this.getBusinessQuery().isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasParent(mdInformationQuery));
    return this.getBusinessQuery().isChildIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasParent(mdInformationQuery));
    return this.getBusinessQuery().isChildIn_SUBSELECT(informationInheritanceQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_superInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.getBusinessQuery().isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_superInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.getBusinessQuery().isNotChildIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.getBusinessQuery().isNotChildIn_SUBSELECT(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdInformationQuery));

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdInformationQuery));

    return this.getBusinessQuery().isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasParent(mdInformationQuery));
    return this.getBusinessQuery().isNotChildIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasParent(mdInformationQuery));
    return this.getBusinessQuery().isNotChildIn_SUBSELECT(informationInheritanceQuery);
  }


  public com.runwaysdk.query.Condition childInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition childInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.getBusinessQuery().isParentIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.getBusinessQuery().isParentIn_SUBSELECT(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdInformationQuery));

    return this.getBusinessQuery().isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdInformationQuery));

    return this.getBusinessQuery().isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasChild(mdInformationQuery));
    return this.getBusinessQuery().isParentIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasChild(mdInformationQuery));
    return this.getBusinessQuery().isParentIn_SUBSELECT(informationInheritanceQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_childInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_childInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.getBusinessQuery().isNotParentIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdInformationQuery));

    return this.getBusinessQuery().isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdInformationQuery));

    return this.getBusinessQuery().isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasChild(mdInformationQuery));
    return this.getBusinessQuery().isNotParentIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasChild(mdInformationQuery));
    return this.getBusinessQuery().isNotParentIn_SUBSELECT(informationInheritanceQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdInformationQueryReferenceIF extends com.runwaysdk.system.metadata.MdMessageQuery.MdMessageQueryReferenceIF
  {

    public com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF getSuperMdInformation();
    public com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF getSuperMdInformation(String alias);
    public com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF getSuperMdInformation(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdInformation mdInformation);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdInformation mdInformation);


  public com.runwaysdk.query.Condition childInformationClass();

  public com.runwaysdk.query.Condition childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery);

  public com.runwaysdk.query.Condition childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery);


  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass();

  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery);

  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery);


  public com.runwaysdk.query.Condition NOT_IN_childInformationClass();

  public com.runwaysdk.query.Condition NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery);

  public com.runwaysdk.query.Condition NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery);


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass();

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery);

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery);


  public com.runwaysdk.query.Condition superInformationClass();
  public com.runwaysdk.query.Condition superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery);

  public com.runwaysdk.query.Condition superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery);


  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass();
  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery);

  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery);


  public com.runwaysdk.query.Condition NOT_IN_superInformationClass();
  public com.runwaysdk.query.Condition NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery);

  public com.runwaysdk.query.Condition NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery);


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass();
  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery);

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdInformationQueryReference extends com.runwaysdk.system.metadata.MdMessageQuery.MdMessageQueryReference
 implements MdInformationQueryReferenceIF

  {

  public MdInformationQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdInformation mdInformation)
    {
      if(mdInformation == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdInformation.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdInformation mdInformation)
    {
      if(mdInformation == null) return this.NE((java.lang.String)null);
      return this.NE(mdInformation.getId());
    }

  public com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF getSuperMdInformation()
  {
    return getSuperMdInformation(null);

  }
 
  public com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF getSuperMdInformation(String alias)
  {
    return (com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdInformation.SUPERMDINFORMATION, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF getSuperMdInformation(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdInformation.SUPERMDINFORMATION,  alias, displayLabel);

  }

  public com.runwaysdk.query.Condition childInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.isParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition childInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.isParentIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.isParentIn_SUBSELECT(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdInformationQuery));

    return this.isParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdInformationQuery));

    return this.isParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasChild(mdInformationQuery));
    return this.isParentIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasChild(mdInformationQuery));
    return this.isParentIn_SUBSELECT(informationInheritanceQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_childInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.isNotParentIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_childInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.isNotParentIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.isNotParentIn_SUBSELECT(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdInformationQuery));

    return this.isNotParentIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasChild(mdInformationQuery));

    return this.isNotParentIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasChild(mdInformationQuery));
    return this.isNotParentIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_childInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasChild(mdInformationQuery));
    return this.isNotParentIn_SUBSELECT(informationInheritanceQuery);
  }


  public com.runwaysdk.query.Condition superInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.isChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition superInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.isChildIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.isChildIn_SUBSELECT(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdInformationQuery));

    return this.isChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdInformationQuery));

    return this.isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasParent(mdInformationQuery));
    return this.isChildIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasParent(mdInformationQuery));
    return this.isChildIn_SUBSELECT(informationInheritanceQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_superInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.isNotChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);

    return this.isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_superInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.isNotChildIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass(com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    return this.isNotChildIn_SUBSELECT(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdInformationQuery));

    return this.isNotChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.InformationInheritance.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(mdInformationQuery));

    return this.isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasParent(mdInformationQuery));
    return this.isNotChildIn(informationInheritanceQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_superInformationClass(com.runwaysdk.system.metadata.MdInformationQuery mdInformationQuery, com.runwaysdk.system.metadata.InformationInheritanceQuery informationInheritanceQuery)
  {
    informationInheritanceQuery.AND(informationInheritanceQuery.hasParent(mdInformationQuery));
    return this.isNotChildIn_SUBSELECT(informationInheritanceQuery);
  }

  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdInformation.SUPERMDINFORMATION)) 
    {
       return new com.runwaysdk.system.metadata.MdInformationQuery.MdInformationQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
