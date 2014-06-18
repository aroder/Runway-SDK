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

@com.runwaysdk.business.ClassSignature(hash = -120381488)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdFormFormDescription.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdFormFormDescriptionQuery extends com.runwaysdk.query.GeneratedStructQuery
{

  public MdFormFormDescriptionQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
     super();
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.StructQuery structQuery = componentQueryFactory.structQuery(this.getClassType());

       this.setStructQuery(structQuery);
    }
  }

  public MdFormFormDescriptionQuery(com.runwaysdk.query.ValueQuery valueQuery)
  {
     super();
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.StructQuery structQuery = new com.runwaysdk.business.StructQuery(valueQuery, this.getClassType());

       this.setStructQuery(structQuery);
    }
  }

  public String getClassType()
  {
    return com.runwaysdk.system.metadata.MdFormFormDescription.CLASS;
  }
  public com.runwaysdk.query.SelectableChar getDefaultLocale()
  {
    return getDefaultLocale(null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultLocale(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFormFormDescription.DEFAULTLOCALE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultLocale(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFormFormDescription.DEFAULTLOCALE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getId()
  {
    return getId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFormFormDescription.ID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFormFormDescription.ID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getKeyName()
  {
    return getKeyName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFormFormDescription.KEYNAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFormFormDescription.KEYNAME, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getSiteMaster()
  {
    return getSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFormFormDescription.SITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.metadata.MdFormFormDescription.SITEMASTER, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdFormFormDescription> getIterator()
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
    return new com.runwaysdk.business.StructIterator<MdFormFormDescription>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a struct attribute.
 **/
  public interface MdFormFormDescriptionQueryStructIF extends com.runwaysdk.query.AttributeLocalIF  {

    public com.runwaysdk.query.SelectableChar getDefaultLocale();
    public com.runwaysdk.query.SelectableChar getDefaultLocale(String alias);
    public com.runwaysdk.query.SelectableChar getDefaultLocale(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getId();
    public com.runwaysdk.query.SelectableChar getId(String alias);
    public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getKeyName();
    public com.runwaysdk.query.SelectableChar getKeyName(String alias);
    public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getSiteMaster();
    public com.runwaysdk.query.SelectableChar getSiteMaster(String alias);
    public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a struct attribute.
 **/
  public static class MdFormFormDescriptionQueryStruct extends com.runwaysdk.query.AttributeLocal implements MdFormFormDescriptionQueryStructIF  {

  public MdFormFormDescriptionQueryStruct(com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdLocalStructDAOIF mdStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdStructIF, structTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }

  public com.runwaysdk.query.SelectableChar getDefaultLocale()
  {
    return getDefaultLocale(null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultLocale(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFormFormDescription.DEFAULTLOCALE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getDefaultLocale(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFormFormDescription.DEFAULTLOCALE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getId()
  {
    return getId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFormFormDescription.ID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFormFormDescription.ID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getKeyName()
  {
    return getKeyName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFormFormDescription.KEYNAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFormFormDescription.KEYNAME, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getSiteMaster()
  {
    return getSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFormFormDescription.SITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.metadata.MdFormFormDescription.SITEMASTER, alias, displayLabel);

  }
  }
}
