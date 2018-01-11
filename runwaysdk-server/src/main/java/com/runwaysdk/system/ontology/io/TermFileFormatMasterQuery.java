/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
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
package com.runwaysdk.system.ontology.io;

@com.runwaysdk.business.ClassSignature(hash = -458349410)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to TermFileFormatMaster.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class TermFileFormatMasterQuery extends com.runwaysdk.system.EnumerationMasterQuery

{

  public TermFileFormatMasterQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public TermFileFormatMasterQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.ontology.io.TermFileFormatMaster.CLASS;
  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends TermFileFormatMaster> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<TermFileFormatMaster>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * 
 **/

  public com.runwaysdk.query.Condition enum_TermFileFormat()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EnumerationAttributeItem.CLASS);

    com.runwaysdk.business.BusinessQuery businessQuery = queryFactory.businessQuery(com.runwaysdk.system.metadata.MdEnumeration.CLASS);
    com.runwaysdk.dataaccess.MdEnumerationDAOIF mdEnumerationIF = com.runwaysdk.dataaccess.metadata.MdEnumerationDAO.getMdEnumerationDAO(com.runwaysdk.system.ontology.io.TermFileFormat.CLASS); 
    businessQuery.WHERE(businessQuery.id().EQ(mdEnumerationIF.getId()));

    relationshipQuery.WHERE(relationshipQuery.hasParent(businessQuery));

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }


/**
 * 
 **/

  public com.runwaysdk.query.Condition notEnum_TermFileFormat()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EnumerationAttributeItem.CLASS);

    com.runwaysdk.business.BusinessQuery businessQuery = queryFactory.businessQuery(com.runwaysdk.system.metadata.MdEnumeration.CLASS);
    com.runwaysdk.dataaccess.MdEnumerationDAOIF mdEnumerationIF = com.runwaysdk.dataaccess.metadata.MdEnumerationDAO.getMdEnumerationDAO(com.runwaysdk.system.ontology.io.TermFileFormat.CLASS); 
    businessQuery.WHERE(businessQuery.id().EQ(mdEnumerationIF.getId()));

    relationshipQuery.WHERE(relationshipQuery.hasParent(businessQuery));

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface TermFileFormatMasterQueryReferenceIF extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryReferenceIF
  {


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.ontology.io.TermFileFormatMaster termFileFormatMaster);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.ontology.io.TermFileFormatMaster termFileFormatMaster);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class TermFileFormatMasterQueryReference extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryReference
 implements TermFileFormatMasterQueryReferenceIF

  {

  public TermFileFormatMasterQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.ontology.io.TermFileFormatMaster termFileFormatMaster)
    {
      if(termFileFormatMaster == null) return this.EQ((java.lang.String)null);
      return this.EQ(termFileFormatMaster.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.ontology.io.TermFileFormatMaster termFileFormatMaster)
    {
      if(termFileFormatMaster == null) return this.NE((java.lang.String)null);
      return this.NE(termFileFormatMaster.getId());
    }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as an enumeration.
 **/
  public interface TermFileFormatMasterQueryEnumerationIF extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryEnumerationIF
  {


  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as an enumeration.
 **/
  public static class TermFileFormatMasterQueryEnumeration extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryEnumeration
 implements TermFileFormatMasterQueryEnumerationIF
  {

  public TermFileFormatMasterQueryEnumeration(com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdEnumerationTableName,com.runwaysdk.dataaccess.MdBusinessDAOIF masterMdBusinessIF, String masterTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterMdBusinessIF, masterTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }

  }

/**
 * Specifies type safe query methods for the enumeration com.runwaysdk.system.ontology.io.TermFileFormat.
 * This type is used when a join is performed on this class as an enumeration.
 **/
  public interface TermFileFormatQueryIF extends TermFileFormatMasterQueryEnumerationIF  {

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat);
  }

/**
 * Implements type safe query methods for the enumeration com.runwaysdk.system.ontology.io.TermFileFormat.
 * This type is used when a join is performed on this class as an enumeration.
 **/
  public static class TermFileFormatQuery extends TermFileFormatMasterQueryEnumeration implements  TermFileFormatQueryIF
  {
  public TermFileFormatQuery(com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdEnumerationTableName,com.runwaysdk.dataaccess.MdBusinessDAOIF masterMdBusinessIF, String masterTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterMdBusinessIF, masterTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat)  {

      String[] enumIdArray = new String[termFileFormat.length]; 

      for (int i=0; i<termFileFormat.length; i++)
      {
        enumIdArray[i] = termFileFormat[i].getId();
      }

      return this.containsAny(enumIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat)  {

      String[] enumIdArray = new String[termFileFormat.length]; 

      for (int i=0; i<termFileFormat.length; i++)
      {
        enumIdArray[i] = termFileFormat[i].getId();
      }

      return this.notContainsAny(enumIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat)  {

      String[] enumIdArray = new String[termFileFormat.length]; 

      for (int i=0; i<termFileFormat.length; i++)
      {
        enumIdArray[i] = termFileFormat[i].getId();
      }

      return this.containsAll(enumIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat)  {

      String[] enumIdArray = new String[termFileFormat.length]; 

      for (int i=0; i<termFileFormat.length; i++)
      {
        enumIdArray[i] = termFileFormat[i].getId();
      }

      return this.notContainsAll(enumIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.ontology.io.TermFileFormat ... termFileFormat)  {

      String[] enumIdArray = new String[termFileFormat.length]; 

      for (int i=0; i<termFileFormat.length; i++)
      {
        enumIdArray[i] = termFileFormat[i].getId();
      }

      return this.containsExactly(enumIdArray);
  }
  }
/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface TermFileFormatMasterQueryMultiReferenceIF extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryMultiReferenceIF
  {


    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class TermFileFormatMasterQueryMultiReference extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryMultiReference
 implements TermFileFormatMasterQueryMultiReferenceIF

  {

  public TermFileFormatMasterQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster)  {

      String[] itemIdArray = new String[termFileFormatMaster.length]; 

      for (int i=0; i<termFileFormatMaster.length; i++)
      {
        itemIdArray[i] = termFileFormatMaster[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster)  {

      String[] itemIdArray = new String[termFileFormatMaster.length]; 

      for (int i=0; i<termFileFormatMaster.length; i++)
      {
        itemIdArray[i] = termFileFormatMaster[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster)  {

      String[] itemIdArray = new String[termFileFormatMaster.length]; 

      for (int i=0; i<termFileFormatMaster.length; i++)
      {
        itemIdArray[i] = termFileFormatMaster[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster)  {

      String[] itemIdArray = new String[termFileFormatMaster.length]; 

      for (int i=0; i<termFileFormatMaster.length; i++)
      {
        itemIdArray[i] = termFileFormatMaster[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.ontology.io.TermFileFormatMaster ... termFileFormatMaster)  {

      String[] itemIdArray = new String[termFileFormatMaster.length]; 

      for (int i=0; i<termFileFormatMaster.length; i++)
      {
        itemIdArray[i] = termFileFormatMaster[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  }
}