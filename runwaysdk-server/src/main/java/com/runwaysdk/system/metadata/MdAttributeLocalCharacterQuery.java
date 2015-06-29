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

@com.runwaysdk.business.ClassSignature(hash = 841698645)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeLocalCharacter.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdAttributeLocalCharacterQuery extends com.runwaysdk.system.metadata.MdAttributeLocalQuery

{

  public MdAttributeLocalCharacterQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdAttributeLocalCharacterQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdAttributeLocalCharacter.CLASS;
  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdAttributeLocalCharacter> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdAttributeLocalCharacter>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeLocalCharacterQueryReferenceIF extends com.runwaysdk.system.metadata.MdAttributeLocalQuery.MdAttributeLocalQueryReferenceIF
  {


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeLocalCharacter mdAttributeLocalCharacter);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeLocalCharacter mdAttributeLocalCharacter);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeLocalCharacterQueryReference extends com.runwaysdk.system.metadata.MdAttributeLocalQuery.MdAttributeLocalQueryReference
 implements MdAttributeLocalCharacterQueryReferenceIF

  {

  public MdAttributeLocalCharacterQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeLocalCharacter mdAttributeLocalCharacter)
    {
      if(mdAttributeLocalCharacter == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdAttributeLocalCharacter.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeLocalCharacter mdAttributeLocalCharacter)
    {
      if(mdAttributeLocalCharacter == null) return this.NE((java.lang.String)null);
      return this.NE(mdAttributeLocalCharacter.getId());
    }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeLocalCharacterQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdAttributeLocalQuery.MdAttributeLocalQueryMultiReferenceIF
  {


    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeLocalCharacterQueryMultiReference extends com.runwaysdk.system.metadata.MdAttributeLocalQuery.MdAttributeLocalQueryMultiReference
 implements MdAttributeLocalCharacterQueryMultiReferenceIF

  {

  public MdAttributeLocalCharacterQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter)  {

      String[] itemIdArray = new String[mdAttributeLocalCharacter.length]; 

      for (int i=0; i<mdAttributeLocalCharacter.length; i++)
      {
        itemIdArray[i] = mdAttributeLocalCharacter[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter)  {

      String[] itemIdArray = new String[mdAttributeLocalCharacter.length]; 

      for (int i=0; i<mdAttributeLocalCharacter.length; i++)
      {
        itemIdArray[i] = mdAttributeLocalCharacter[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter)  {

      String[] itemIdArray = new String[mdAttributeLocalCharacter.length]; 

      for (int i=0; i<mdAttributeLocalCharacter.length; i++)
      {
        itemIdArray[i] = mdAttributeLocalCharacter[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter)  {

      String[] itemIdArray = new String[mdAttributeLocalCharacter.length]; 

      for (int i=0; i<mdAttributeLocalCharacter.length; i++)
      {
        itemIdArray[i] = mdAttributeLocalCharacter[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeLocalCharacter ... mdAttributeLocalCharacter)  {

      String[] itemIdArray = new String[mdAttributeLocalCharacter.length]; 

      for (int i=0; i<mdAttributeLocalCharacter.length; i++)
      {
        itemIdArray[i] = mdAttributeLocalCharacter[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  }
}
