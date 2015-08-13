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
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = 664721116)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeTime.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdAttributeTimeQuery extends com.runwaysdk.system.metadata.MdAttributeMomentQuery

{

  public MdAttributeTimeQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdAttributeTimeQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdAttributeTime.CLASS;
  }
  public com.runwaysdk.query.SelectableMoment getDefaultValue()
  {
    return getDefaultValue(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdAttributeTime.DEFAULTVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdAttributeTime.DEFAULTVALUE, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdAttributeTime> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdAttributeTime>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeTimeQueryReferenceIF extends com.runwaysdk.system.metadata.MdAttributeMomentQuery.MdAttributeMomentQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableMoment getDefaultValue();
    public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias);
    public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeTime mdAttributeTime);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeTime mdAttributeTime);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeTimeQueryReference extends com.runwaysdk.system.metadata.MdAttributeMomentQuery.MdAttributeMomentQueryReference
 implements MdAttributeTimeQueryReferenceIF

  {

  public MdAttributeTimeQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeTime mdAttributeTime)
    {
      if(mdAttributeTime == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdAttributeTime.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeTime mdAttributeTime)
    {
      if(mdAttributeTime == null) return this.NE((java.lang.String)null);
      return this.NE(mdAttributeTime.getId());
    }

  public com.runwaysdk.query.SelectableMoment getDefaultValue()
  {
    return getDefaultValue(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.metadata.MdAttributeTime.DEFAULTVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.metadata.MdAttributeTime.DEFAULTVALUE, alias, displayLabel);

  }
  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeTimeQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdAttributeMomentQuery.MdAttributeMomentQueryMultiReferenceIF
  {

    public com.runwaysdk.query.SelectableMoment getDefaultValue();
    public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias);
    public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeTimeQueryMultiReference extends com.runwaysdk.system.metadata.MdAttributeMomentQuery.MdAttributeMomentQueryMultiReference
 implements MdAttributeTimeQueryMultiReferenceIF

  {

  public MdAttributeTimeQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime)  {

      String[] itemIdArray = new String[mdAttributeTime.length]; 

      for (int i=0; i<mdAttributeTime.length; i++)
      {
        itemIdArray[i] = mdAttributeTime[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime)  {

      String[] itemIdArray = new String[mdAttributeTime.length]; 

      for (int i=0; i<mdAttributeTime.length; i++)
      {
        itemIdArray[i] = mdAttributeTime[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime)  {

      String[] itemIdArray = new String[mdAttributeTime.length]; 

      for (int i=0; i<mdAttributeTime.length; i++)
      {
        itemIdArray[i] = mdAttributeTime[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime)  {

      String[] itemIdArray = new String[mdAttributeTime.length]; 

      for (int i=0; i<mdAttributeTime.length; i++)
      {
        itemIdArray[i] = mdAttributeTime[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeTime ... mdAttributeTime)  {

      String[] itemIdArray = new String[mdAttributeTime.length]; 

      for (int i=0; i<mdAttributeTime.length; i++)
      {
        itemIdArray[i] = mdAttributeTime[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.query.SelectableMoment getDefaultValue()
  {
    return getDefaultValue(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.metadata.MdAttributeTime.DEFAULTVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getDefaultValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.metadata.MdAttributeTime.DEFAULTVALUE, alias, displayLabel);

  }
  }
}
