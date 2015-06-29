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

@com.runwaysdk.business.ClassSignature(hash = 324582584)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdFacade.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdFacadeQuery extends com.runwaysdk.system.metadata.MdTypeQuery

{

  public MdFacadeQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdFacadeQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.metadata.MdFacade.CLASS;
  }
  public com.runwaysdk.query.SelectableBlob getClientClasses()
  {
    return getClientClasses(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getClientClasses(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.CLIENTCLASSES, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getClientClasses(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.CLIENTCLASSES, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getCommonClasses()
  {
    return getCommonClasses(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.COMMONCLASSES, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.COMMONCLASSES, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getServerClasses()
  {
    return getServerClasses(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getServerClasses(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.SERVERCLASSES, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getServerClasses(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.SERVERCLASSES, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getStubClass()
  {
    return getStubClass(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getStubClass(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.STUBCLASS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getStubClass(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.STUBCLASS, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getStubSource()
  {
    return getStubSource(null);

  }
 
  public com.runwaysdk.query.SelectableChar getStubSource(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.STUBSOURCE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getStubSource(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFacade.STUBSOURCE, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdFacade> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<MdFacade>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdFacadeQueryReferenceIF extends com.runwaysdk.system.metadata.MdTypeQuery.MdTypeQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableBlob getClientClasses();
    public com.runwaysdk.query.SelectableBlob getClientClasses(String alias);
    public com.runwaysdk.query.SelectableBlob getClientClasses(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBlob getCommonClasses();
    public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias);
    public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBlob getServerClasses();
    public com.runwaysdk.query.SelectableBlob getServerClasses(String alias);
    public com.runwaysdk.query.SelectableBlob getServerClasses(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBlob getStubClass();
    public com.runwaysdk.query.SelectableBlob getStubClass(String alias);
    public com.runwaysdk.query.SelectableBlob getStubClass(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getStubSource();
    public com.runwaysdk.query.SelectableChar getStubSource(String alias);
    public com.runwaysdk.query.SelectableChar getStubSource(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdFacade mdFacade);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdFacade mdFacade);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdFacadeQueryReference extends com.runwaysdk.system.metadata.MdTypeQuery.MdTypeQueryReference
 implements MdFacadeQueryReferenceIF

  {

  public MdFacadeQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdFacade mdFacade)
    {
      if(mdFacade == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdFacade.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdFacade mdFacade)
    {
      if(mdFacade == null) return this.NE((java.lang.String)null);
      return this.NE(mdFacade.getId());
    }

  public com.runwaysdk.query.SelectableBlob getClientClasses()
  {
    return getClientClasses(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getClientClasses(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.CLIENTCLASSES, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getClientClasses(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.CLIENTCLASSES, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getCommonClasses()
  {
    return getCommonClasses(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.COMMONCLASSES, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.COMMONCLASSES, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getServerClasses()
  {
    return getServerClasses(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getServerClasses(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.SERVERCLASSES, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getServerClasses(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.SERVERCLASSES, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getStubClass()
  {
    return getStubClass(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getStubClass(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.STUBCLASS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getStubClass(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.STUBCLASS, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getStubSource()
  {
    return getStubSource(null);

  }
 
  public com.runwaysdk.query.SelectableChar getStubSource(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFacade.STUBSOURCE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getStubSource(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFacade.STUBSOURCE, alias, displayLabel);

  }
  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdFacadeQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdTypeQuery.MdTypeQueryMultiReferenceIF
  {

    public com.runwaysdk.query.SelectableBlob getClientClasses();
    public com.runwaysdk.query.SelectableBlob getClientClasses(String alias);
    public com.runwaysdk.query.SelectableBlob getClientClasses(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBlob getCommonClasses();
    public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias);
    public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBlob getServerClasses();
    public com.runwaysdk.query.SelectableBlob getServerClasses(String alias);
    public com.runwaysdk.query.SelectableBlob getServerClasses(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableBlob getStubClass();
    public com.runwaysdk.query.SelectableBlob getStubClass(String alias);
    public com.runwaysdk.query.SelectableBlob getStubClass(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getStubSource();
    public com.runwaysdk.query.SelectableChar getStubSource(String alias);
    public com.runwaysdk.query.SelectableChar getStubSource(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdFacade ... mdFacade);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdFacade ... mdFacade);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdFacade ... mdFacade);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdFacade ... mdFacade);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdFacade ... mdFacade);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdFacadeQueryMultiReference extends com.runwaysdk.system.metadata.MdTypeQuery.MdTypeQueryMultiReference
 implements MdFacadeQueryMultiReferenceIF

  {

  public MdFacadeQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdFacade ... mdFacade)  {

      String[] itemIdArray = new String[mdFacade.length]; 

      for (int i=0; i<mdFacade.length; i++)
      {
        itemIdArray[i] = mdFacade[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdFacade ... mdFacade)  {

      String[] itemIdArray = new String[mdFacade.length]; 

      for (int i=0; i<mdFacade.length; i++)
      {
        itemIdArray[i] = mdFacade[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdFacade ... mdFacade)  {

      String[] itemIdArray = new String[mdFacade.length]; 

      for (int i=0; i<mdFacade.length; i++)
      {
        itemIdArray[i] = mdFacade[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdFacade ... mdFacade)  {

      String[] itemIdArray = new String[mdFacade.length]; 

      for (int i=0; i<mdFacade.length; i++)
      {
        itemIdArray[i] = mdFacade[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdFacade ... mdFacade)  {

      String[] itemIdArray = new String[mdFacade.length]; 

      for (int i=0; i<mdFacade.length; i++)
      {
        itemIdArray[i] = mdFacade[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.query.SelectableBlob getClientClasses()
  {
    return getClientClasses(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getClientClasses(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.CLIENTCLASSES, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getClientClasses(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.CLIENTCLASSES, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getCommonClasses()
  {
    return getCommonClasses(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.COMMONCLASSES, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getCommonClasses(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.COMMONCLASSES, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getServerClasses()
  {
    return getServerClasses(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getServerClasses(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.SERVERCLASSES, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getServerClasses(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.SERVERCLASSES, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableBlob getStubClass()
  {
    return getStubClass(null);

  }
 
  public com.runwaysdk.query.SelectableBlob getStubClass(String alias)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.STUBCLASS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableBlob getStubClass(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableBlob)this.get(com.runwaysdk.system.metadata.MdFacade.STUBCLASS, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getStubSource()
  {
    return getStubSource(null);

  }
 
  public com.runwaysdk.query.SelectableChar getStubSource(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFacade.STUBSOURCE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getStubSource(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFacade.STUBSOURCE, alias, displayLabel);

  }
  }
}
