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
package com.runwaysdk.system;

@com.runwaysdk.business.ClassSignature(hash = 408744965)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to EmailKey.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class EmailKeyQuery extends com.runwaysdk.query.GeneratedStructQuery
{

  public EmailKeyQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
     super();
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.StructQuery structQuery = componentQueryFactory.structQuery(this.getClassType());

       this.setStructQuery(structQuery);
    }
  }

  public EmailKeyQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return com.runwaysdk.system.EmailKey.CLASS;
  }
  public com.runwaysdk.query.SelectableChar getEmail()
  {
    return getEmail(null);

  }
 
  public com.runwaysdk.query.SelectableChar getEmail(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.EMAIL, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getEmail(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.EMAIL, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getId()
  {
    return getId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.ID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.ID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getIssuedOnDate()
  {
    return getIssuedOnDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getIssuedOnDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.ISSUEDONDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getIssuedOnDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.ISSUEDONDATE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getKeyName()
  {
    return getKeyName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.KEYNAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.KEYNAME, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getSiteMaster()
  {
    return getSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.SITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.SITEMASTER, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getUniqueKey()
  {
    return getUniqueKey(null);

  }
 
  public com.runwaysdk.query.SelectableChar getUniqueKey(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.UNIQUEKEY, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getUniqueKey(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.EmailKey.UNIQUEKEY, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends EmailKey> getIterator()
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
    return new com.runwaysdk.business.StructIterator<EmailKey>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a struct attribute.
 **/
  public interface EmailKeyQueryStructIF extends com.runwaysdk.query.SelectableStruct  {

    public com.runwaysdk.query.SelectableChar getEmail();
    public com.runwaysdk.query.SelectableChar getEmail(String alias);
    public com.runwaysdk.query.SelectableChar getEmail(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getId();
    public com.runwaysdk.query.SelectableChar getId(String alias);
    public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableMoment getIssuedOnDate();
    public com.runwaysdk.query.SelectableMoment getIssuedOnDate(String alias);
    public com.runwaysdk.query.SelectableMoment getIssuedOnDate(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getKeyName();
    public com.runwaysdk.query.SelectableChar getKeyName(String alias);
    public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getSiteMaster();
    public com.runwaysdk.query.SelectableChar getSiteMaster(String alias);
    public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getUniqueKey();
    public com.runwaysdk.query.SelectableChar getUniqueKey(String alias);
    public com.runwaysdk.query.SelectableChar getUniqueKey(String alias, String displayLabel);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a struct attribute.
 **/
  public static class EmailKeyQueryStruct extends com.runwaysdk.query.AttributeStruct implements EmailKeyQueryStructIF  {

  public EmailKeyQueryStruct(com.runwaysdk.dataaccess.MdAttributeStructDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdStructDAOIF mdStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdStructIF, structTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }

  public com.runwaysdk.query.SelectableChar getEmail()
  {
    return getEmail(null);

  }
 
  public com.runwaysdk.query.SelectableChar getEmail(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.EMAIL, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getEmail(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.EMAIL, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getId()
  {
    return getId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.ID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.ID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getIssuedOnDate()
  {
    return getIssuedOnDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getIssuedOnDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.EmailKey.ISSUEDONDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getIssuedOnDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.EmailKey.ISSUEDONDATE, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getKeyName()
  {
    return getKeyName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.KEYNAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.KEYNAME, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getSiteMaster()
  {
    return getSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.SITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.SITEMASTER, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getUniqueKey()
  {
    return getUniqueKey(null);

  }
 
  public com.runwaysdk.query.SelectableChar getUniqueKey(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.UNIQUEKEY, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getUniqueKey(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.EmailKey.UNIQUEKEY, alias, displayLabel);

  }
  }
}
