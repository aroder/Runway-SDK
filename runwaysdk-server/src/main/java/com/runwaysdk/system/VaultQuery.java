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
package com.runwaysdk.system;

@com.runwaysdk.business.ClassSignature(hash = 1127770204)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to Vault.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class VaultQuery extends com.runwaysdk.query.GeneratedBusinessQuery

{

  public VaultQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
     super();
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public VaultQuery(com.runwaysdk.query.ValueQuery valueQuery)
  {
     super();
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = new com.runwaysdk.business.BusinessQuery(valueQuery, this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public String getClassType()
  {
    return com.runwaysdk.system.Vault.CLASS;
  }
  public com.runwaysdk.query.SelectableLong getByteCount()
  {
    return getByteCount(null);

  }
 
  public com.runwaysdk.query.SelectableLong getByteCount(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(com.runwaysdk.system.Vault.BYTECOUNT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getByteCount(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(com.runwaysdk.system.Vault.BYTECOUNT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getCreateDate()
  {
    return getCreateDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getCreateDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.Vault.CREATEDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getCreateDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.Vault.CREATEDATE, alias, displayLabel);

  }
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy()
  {
    return getCreatedBy(null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.CREATEDBY);

    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.CREATEDBY, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.CREATEDBY);

    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.CREATEDBY, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain()
  {
    return getEntityDomain(null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.ENTITYDOMAIN);

    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.ENTITYDOMAIN, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.ENTITYDOMAIN);

    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.ENTITYDOMAIN, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getId()
  {
    return getId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.ID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.ID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getKeyName()
  {
    return getKeyName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.KEYNAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.KEYNAME, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate()
  {
    return getLastUpdateDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.Vault.LASTUPDATEDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.getComponentQuery().get(com.runwaysdk.system.Vault.LASTUPDATEDATE, alias, displayLabel);

  }
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy()
  {
    return getLastUpdatedBy(null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.LASTUPDATEDBY);

    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.LASTUPDATEDBY, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.LASTUPDATEDBY);

    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.LASTUPDATEDBY, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy()
  {
    return getLockedBy(null);

  }
 
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.LOCKEDBY);

    return (com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.LOCKEDBY, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.LOCKEDBY);

    return (com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.LOCKEDBY, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner()
  {
    return getOwner(null);

  }
 
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.OWNER);

    return (com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.OWNER, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.Vault.OWNER);

    return (com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.Vault.OWNER, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getRootPath()
  {
    return getRootPath(null);

  }
 
  public com.runwaysdk.query.SelectableChar getRootPath(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.ROOTPATH, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getRootPath(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.ROOTPATH, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getSeq()
  {
    return getSeq(null);

  }
 
  public com.runwaysdk.query.SelectableLong getSeq(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(com.runwaysdk.system.Vault.SEQ, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getSeq(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(com.runwaysdk.system.Vault.SEQ, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getSiteMaster()
  {
    return getSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.SITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.SITEMASTER, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getType()
  {
    return getType(null);

  }
 
  public com.runwaysdk.query.SelectableChar getType(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.TYPE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getType(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(com.runwaysdk.system.Vault.TYPE, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.Vault.CREATEDBY)) 
    {
       return new com.runwaysdk.system.SingleActorQuery.SingleActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Vault.ENTITYDOMAIN)) 
    {
       return new com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Vault.LASTUPDATEDBY)) 
    {
       return new com.runwaysdk.system.SingleActorQuery.SingleActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Vault.LOCKEDBY)) 
    {
       return new com.runwaysdk.system.UsersQuery.UsersQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Vault.OWNER)) 
    {
       return new com.runwaysdk.system.ActorQuery.ActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      String error = "Attribute type ["+mdAttributeIF.getType()+"] is invalid.";
      throw new com.runwaysdk.query.QueryException(error);
    }
  }

  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends Vault> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<Vault>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface VaultQueryReferenceIF extends com.runwaysdk.query.SelectableReference
  {

    public com.runwaysdk.query.SelectableLong getByteCount();
    public com.runwaysdk.query.SelectableLong getByteCount(String alias);
    public com.runwaysdk.query.SelectableLong getByteCount(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableMoment getCreateDate();
    public com.runwaysdk.query.SelectableMoment getCreateDate(String alias);
    public com.runwaysdk.query.SelectableMoment getCreateDate(String alias, String displayLabel);
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy();
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias);
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias, String displayLabel);
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain();
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias);
    public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getId();
    public com.runwaysdk.query.SelectableChar getId(String alias);
    public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getKeyName();
    public com.runwaysdk.query.SelectableChar getKeyName(String alias);
    public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableMoment getLastUpdateDate();
    public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias);
    public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias, String displayLabel);
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy();
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias);
    public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias, String displayLabel);
    public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy();
    public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias);
    public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias, String displayLabel);
    public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner();
    public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias);
    public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getRootPath();
    public com.runwaysdk.query.SelectableChar getRootPath(String alias);
    public com.runwaysdk.query.SelectableChar getRootPath(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableLong getSeq();
    public com.runwaysdk.query.SelectableLong getSeq(String alias);
    public com.runwaysdk.query.SelectableLong getSeq(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getSiteMaster();
    public com.runwaysdk.query.SelectableChar getSiteMaster(String alias);
    public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getType();
    public com.runwaysdk.query.SelectableChar getType(String alias);
    public com.runwaysdk.query.SelectableChar getType(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.Vault vault);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.Vault vault);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class VaultQueryReference extends com.runwaysdk.query.AttributeReference
 implements VaultQueryReferenceIF

  {

  public VaultQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.Vault vault)
    {
      if(vault == null) return this.EQ((java.lang.String)null);
      return this.EQ(vault.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.Vault vault)
    {
      if(vault == null) return this.NE((java.lang.String)null);
      return this.NE(vault.getId());
    }

  public com.runwaysdk.query.SelectableLong getByteCount()
  {
    return getByteCount(null);

  }
 
  public com.runwaysdk.query.SelectableLong getByteCount(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(com.runwaysdk.system.Vault.BYTECOUNT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getByteCount(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(com.runwaysdk.system.Vault.BYTECOUNT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getCreateDate()
  {
    return getCreateDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getCreateDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.Vault.CREATEDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getCreateDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.Vault.CREATEDATE, alias, displayLabel);

  }
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy()
  {
    return getCreatedBy(null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias)
  {
    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.get(com.runwaysdk.system.Vault.CREATEDBY, alias, null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getCreatedBy(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.get(com.runwaysdk.system.Vault.CREATEDBY,  alias, displayLabel);

  }
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain()
  {
    return getEntityDomain(null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias)
  {
    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.get(com.runwaysdk.system.Vault.ENTITYDOMAIN, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF getEntityDomain(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReferenceIF)this.get(com.runwaysdk.system.Vault.ENTITYDOMAIN,  alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getId()
  {
    return getId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.ID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.ID, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getKeyName()
  {
    return getKeyName(null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.KEYNAME, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getKeyName(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.KEYNAME, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate()
  {
    return getLastUpdateDate(null);

  }
 
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.Vault.LASTUPDATEDATE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableMoment getLastUpdateDate(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableMoment)this.get(com.runwaysdk.system.Vault.LASTUPDATEDATE, alias, displayLabel);

  }
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy()
  {
    return getLastUpdatedBy(null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias)
  {
    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.get(com.runwaysdk.system.Vault.LASTUPDATEDBY, alias, null);

  }
 
  public com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF getLastUpdatedBy(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.SingleActorQuery.SingleActorQueryReferenceIF)this.get(com.runwaysdk.system.Vault.LASTUPDATEDBY,  alias, displayLabel);

  }
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy()
  {
    return getLockedBy(null);

  }
 
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias)
  {
    return (com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF)this.get(com.runwaysdk.system.Vault.LOCKEDBY, alias, null);

  }
 
  public com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF getLockedBy(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.UsersQuery.UsersQueryReferenceIF)this.get(com.runwaysdk.system.Vault.LOCKEDBY,  alias, displayLabel);

  }
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner()
  {
    return getOwner(null);

  }
 
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias)
  {
    return (com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF)this.get(com.runwaysdk.system.Vault.OWNER, alias, null);

  }
 
  public com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF getOwner(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.ActorQuery.ActorQueryReferenceIF)this.get(com.runwaysdk.system.Vault.OWNER,  alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getRootPath()
  {
    return getRootPath(null);

  }
 
  public com.runwaysdk.query.SelectableChar getRootPath(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.ROOTPATH, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getRootPath(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.ROOTPATH, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getSeq()
  {
    return getSeq(null);

  }
 
  public com.runwaysdk.query.SelectableLong getSeq(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(com.runwaysdk.system.Vault.SEQ, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getSeq(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(com.runwaysdk.system.Vault.SEQ, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getSiteMaster()
  {
    return getSiteMaster(null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.SITEMASTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getSiteMaster(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.SITEMASTER, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getType()
  {
    return getType(null);

  }
 
  public com.runwaysdk.query.SelectableChar getType(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.TYPE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getType(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(com.runwaysdk.system.Vault.TYPE, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.Vault.CREATEDBY)) 
    {
       return new com.runwaysdk.system.SingleActorQuery.SingleActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Vault.ENTITYDOMAIN)) 
    {
       return new com.runwaysdk.system.metadata.MdDomainQuery.MdDomainQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Vault.LASTUPDATEDBY)) 
    {
       return new com.runwaysdk.system.SingleActorQuery.SingleActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Vault.LOCKEDBY)) 
    {
       return new com.runwaysdk.system.UsersQuery.UsersQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(com.runwaysdk.system.Vault.OWNER)) 
    {
       return new com.runwaysdk.system.ActorQuery.ActorQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      String error = "Attribute type ["+mdAttributeIF.getType()+"] is invalid.";
      throw new com.runwaysdk.query.QueryException(error);
    }
  }

  }
}
