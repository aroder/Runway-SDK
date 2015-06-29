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

@com.runwaysdk.business.ClassSignature(hash = 470351765)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeReference.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdAttributeReferenceQuery extends com.runwaysdk.system.metadata.MdAttributeRefQuery

{

  public MdAttributeReferenceQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdAttributeReferenceQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdAttributeReference.CLASS;
  }
  public com.runwaysdk.query.SelectableChar getDefaultValue()
  {
    return getDefaultValue(null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdAttributeReference.DEFAULTVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdAttributeReference.DEFAULTVALUE, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness()
  {
    return getMdBusiness(null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS);

    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS);

    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS)) 
    {
       return new com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
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
  public com.runwaysdk.query.OIterator<? extends MdAttributeReference> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdAttributeReference>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeReferenceQueryReferenceIF extends com.runwaysdk.system.metadata.MdAttributeRefQuery.MdAttributeRefQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getDefaultValue();
    public com.runwaysdk.query.SelectableChar getDefaultValue(String alias);
    public com.runwaysdk.query.SelectableChar getDefaultValue(String alias, String displayLabel);
    public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness();
    public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias);
    public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeReference mdAttributeReference);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeReference mdAttributeReference);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeReferenceQueryReference extends com.runwaysdk.system.metadata.MdAttributeRefQuery.MdAttributeRefQueryReference
 implements MdAttributeReferenceQueryReferenceIF

  {

  public MdAttributeReferenceQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdAttributeReference mdAttributeReference)
    {
      if(mdAttributeReference == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdAttributeReference.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdAttributeReference mdAttributeReference)
    {
      if(mdAttributeReference == null) return this.NE((java.lang.String)null);
      return this.NE(mdAttributeReference.getId());
    }

  public com.runwaysdk.query.SelectableChar getDefaultValue()
  {
    return getDefaultValue(null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdAttributeReference.DEFAULTVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdAttributeReference.DEFAULTVALUE, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness()
  {
    return getMdBusiness(null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias)
  {
    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS)) 
    {
       return new com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdAttributeReferenceQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdAttributeRefQuery.MdAttributeRefQueryMultiReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getDefaultValue();
    public com.runwaysdk.query.SelectableChar getDefaultValue(String alias);
    public com.runwaysdk.query.SelectableChar getDefaultValue(String alias, String displayLabel);
    public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness();
    public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias);
    public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdAttributeReferenceQueryMultiReference extends com.runwaysdk.system.metadata.MdAttributeRefQuery.MdAttributeRefQueryMultiReference
 implements MdAttributeReferenceQueryMultiReferenceIF

  {

  public MdAttributeReferenceQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference)  {

      String[] itemIdArray = new String[mdAttributeReference.length]; 

      for (int i=0; i<mdAttributeReference.length; i++)
      {
        itemIdArray[i] = mdAttributeReference[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference)  {

      String[] itemIdArray = new String[mdAttributeReference.length]; 

      for (int i=0; i<mdAttributeReference.length; i++)
      {
        itemIdArray[i] = mdAttributeReference[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference)  {

      String[] itemIdArray = new String[mdAttributeReference.length]; 

      for (int i=0; i<mdAttributeReference.length; i++)
      {
        itemIdArray[i] = mdAttributeReference[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference)  {

      String[] itemIdArray = new String[mdAttributeReference.length]; 

      for (int i=0; i<mdAttributeReference.length; i++)
      {
        itemIdArray[i] = mdAttributeReference[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdAttributeReference ... mdAttributeReference)  {

      String[] itemIdArray = new String[mdAttributeReference.length]; 

      for (int i=0; i<mdAttributeReference.length; i++)
      {
        itemIdArray[i] = mdAttributeReference[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.query.SelectableChar getDefaultValue()
  {
    return getDefaultValue(null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdAttributeReference.DEFAULTVALUE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultValue(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdAttributeReference.DEFAULTVALUE, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness()
  {
    return getMdBusiness(null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias)
  {
    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF getMdBusiness(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReferenceIF)this.get(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS,  alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdAttributeReference.MDBUSINESS)) 
    {
       return new com.runwaysdk.system.metadata.MdBusinessQuery.MdBusinessQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
