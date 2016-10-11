/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Runway SDK GIS(tm).
 *
 * Runway SDK GIS(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Runway SDK GIS(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Runway SDK GIS(tm).  If not, see <http://www.gnu.org/licenses/>.
 */
package com.runwaysdk.system.gis.mapping;

@com.runwaysdk.business.ClassSignature(hash = 2079549518)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to PrimitiveRule.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class PrimitiveRuleQuery extends com.runwaysdk.system.gis.mapping.ThematicRuleQuery

{

  public PrimitiveRuleQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public PrimitiveRuleQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.gis.mapping.PrimitiveRule.CLASS;
  }
  public com.runwaysdk.query.SelectableChar getAttributeValue()
  {
    return getAttributeValue(null);

  }
 
  public com.runwaysdk.query.SelectableChar getAttributeValue(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.gis.mapping.PrimitiveRule.ATTRIBUTEVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getAttributeValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.gis.mapping.PrimitiveRule.ATTRIBUTEVALUE, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends PrimitiveRule> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<PrimitiveRule>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


  public com.runwaysdk.query.Condition compositeRule()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_compositeRule()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);

    return this.getBusinessQuery().isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition compositeRule(com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    return this.getBusinessQuery().isChildIn(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_compositeRule(com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    return this.getBusinessQuery().isChildIn_SUBSELECT(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(compositeRuleQuery));

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(compositeRuleQuery));

    return this.getBusinessQuery().isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    hasPrimitiveRuleQuery.AND(hasPrimitiveRuleQuery.hasParent(compositeRuleQuery));
    return this.getBusinessQuery().isChildIn(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    hasPrimitiveRuleQuery.AND(hasPrimitiveRuleQuery.hasParent(compositeRuleQuery));
    return this.getBusinessQuery().isChildIn_SUBSELECT(hasPrimitiveRuleQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_compositeRule()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);

    return this.getBusinessQuery().isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    return this.getBusinessQuery().isNotChildIn(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    return this.getBusinessQuery().isNotChildIn_SUBSELECT(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(compositeRuleQuery));

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(compositeRuleQuery));

    return this.getBusinessQuery().isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    hasPrimitiveRuleQuery.AND(hasPrimitiveRuleQuery.hasParent(compositeRuleQuery));
    return this.getBusinessQuery().isNotChildIn(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    hasPrimitiveRuleQuery.AND(hasPrimitiveRuleQuery.hasParent(compositeRuleQuery));
    return this.getBusinessQuery().isNotChildIn_SUBSELECT(hasPrimitiveRuleQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface PrimitiveRuleQueryReferenceIF extends com.runwaysdk.system.gis.mapping.ThematicRuleQuery.ThematicRuleQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getAttributeValue();
    public com.runwaysdk.query.SelectableChar getAttributeValue(String alias);
    public com.runwaysdk.query.SelectableChar getAttributeValue(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.gis.mapping.PrimitiveRule primitiveRule);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.gis.mapping.PrimitiveRule primitiveRule);


  public com.runwaysdk.query.Condition compositeRule();
  public com.runwaysdk.query.Condition compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery);

  public com.runwaysdk.query.Condition compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery);


  public com.runwaysdk.query.Condition SUBSELECT_compositeRule();
  public com.runwaysdk.query.Condition SUBSELECT_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery);

  public com.runwaysdk.query.Condition SUBSELECT_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery);


  public com.runwaysdk.query.Condition NOT_IN_compositeRule();
  public com.runwaysdk.query.Condition NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery);

  public com.runwaysdk.query.Condition NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery);


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule();
  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery);

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class PrimitiveRuleQueryReference extends com.runwaysdk.system.gis.mapping.ThematicRuleQuery.ThematicRuleQueryReference
 implements PrimitiveRuleQueryReferenceIF

  {

  public PrimitiveRuleQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.gis.mapping.PrimitiveRule primitiveRule)
    {
      if(primitiveRule == null) return this.EQ((java.lang.String)null);
      return this.EQ(primitiveRule.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.gis.mapping.PrimitiveRule primitiveRule)
    {
      if(primitiveRule == null) return this.NE((java.lang.String)null);
      return this.NE(primitiveRule.getId());
    }

  public com.runwaysdk.query.SelectableChar getAttributeValue()
  {
    return getAttributeValue(null);

  }
 
  public com.runwaysdk.query.SelectableChar getAttributeValue(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.gis.mapping.PrimitiveRule.ATTRIBUTEVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getAttributeValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.gis.mapping.PrimitiveRule.ATTRIBUTEVALUE, alias, displayLabel);

  }

  public com.runwaysdk.query.Condition compositeRule()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);

    return this.isChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_compositeRule()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);

    return this.isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition compositeRule(com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    return this.isChildIn(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_compositeRule(com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    return this.isChildIn_SUBSELECT(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(compositeRuleQuery));

    return this.isChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(compositeRuleQuery));

    return this.isChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    hasPrimitiveRuleQuery.AND(hasPrimitiveRuleQuery.hasParent(compositeRuleQuery));
    return this.isChildIn(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    hasPrimitiveRuleQuery.AND(hasPrimitiveRuleQuery.hasParent(compositeRuleQuery));
    return this.isChildIn_SUBSELECT(hasPrimitiveRuleQuery);
  }


  public com.runwaysdk.query.Condition NOT_IN_compositeRule()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);

    return this.isNotChildIn(relationshipQuery);
  }


  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);

    return this.isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    return this.isNotChildIn(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    return this.isNotChildIn_SUBSELECT(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(compositeRuleQuery));

    return this.isNotChildIn(relationshipQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery)
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.gis.mapping.HasPrimitiveRule.CLASS);
    relationshipQuery.AND(relationshipQuery.hasParent(compositeRuleQuery));

    return this.isNotChildIn_SUBSELECT(relationshipQuery);
  }

  public com.runwaysdk.query.Condition NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    hasPrimitiveRuleQuery.AND(hasPrimitiveRuleQuery.hasParent(compositeRuleQuery));
    return this.isNotChildIn(hasPrimitiveRuleQuery);
  }

  public com.runwaysdk.query.Condition SUBSELECT_NOT_IN_compositeRule(com.runwaysdk.system.gis.mapping.CompositeRuleQuery compositeRuleQuery, com.runwaysdk.system.gis.mapping.HasPrimitiveRuleQuery hasPrimitiveRuleQuery)
  {
    hasPrimitiveRuleQuery.AND(hasPrimitiveRuleQuery.hasParent(compositeRuleQuery));
    return this.isNotChildIn_SUBSELECT(hasPrimitiveRuleQuery);
  }

  }
}
