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

@com.runwaysdk.business.ClassSignature(hash = -756807562)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to Layer.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class LayerBase extends com.runwaysdk.business.Business
{
  public final static String CLASS = "com.runwaysdk.system.gis.mapping.Layer";
  public static java.lang.String CREATEDATE = "createDate";
  public static java.lang.String CREATEDBY = "createdBy";
  public static java.lang.String DEFAULTSTYLE = "defaultStyle";
  public static java.lang.String ENTITYDOMAIN = "entityDomain";
  public static java.lang.String FORCEREFRESH = "forceRefresh";
  public static java.lang.String ID = "id";
  public static java.lang.String KEYNAME = "keyName";
  public static java.lang.String LASTUPDATEDATE = "lastUpdateDate";
  public static java.lang.String LASTUPDATEDBY = "lastUpdatedBy";
  public static java.lang.String LAYERNAME = "layerName";
  private com.runwaysdk.business.Struct layerName = null;
  
  public static java.lang.String LOCKEDBY = "lockedBy";
  public static java.lang.String OWNER = "owner";
  public static java.lang.String PUBLISHED = "published";
  public static java.lang.String SEQ = "seq";
  public static java.lang.String SITEMASTER = "siteMaster";
  public static java.lang.String SQLBUILDER = "sqlBuilder";
  public static java.lang.String TYPE = "type";
  private static final long serialVersionUID = -756807562;
  
  public LayerBase()
  {
    super();
    layerName = super.getStruct("layerName");
  }
  
  public java.util.Date getCreateDate()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(CREATEDATE));
  }
  
  public void validateCreateDate()
  {
    this.validateAttribute(CREATEDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCreateDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(CREATEDATE);
  }
  
  public com.runwaysdk.system.SingleActor getCreatedBy()
  {
    if (getValue(CREATEDBY).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.SingleActor.get(getValue(CREATEDBY));
    }
  }
  
  public String getCreatedById()
  {
    return getValue(CREATEDBY);
  }
  
  public void validateCreatedBy()
  {
    this.validateAttribute(CREATEDBY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCreatedByMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(CREATEDBY);
  }
  
  public com.runwaysdk.system.gis.mapping.LayerStyle getDefaultStyle()
  {
    if (getValue(DEFAULTSTYLE).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.gis.mapping.LayerStyle.get(getValue(DEFAULTSTYLE));
    }
  }
  
  public String getDefaultStyleId()
  {
    return getValue(DEFAULTSTYLE);
  }
  
  public void validateDefaultStyle()
  {
    this.validateAttribute(DEFAULTSTYLE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDefaultStyleMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(DEFAULTSTYLE);
  }
  
  public void setDefaultStyle(com.runwaysdk.system.gis.mapping.LayerStyle value)
  {
    if(value == null)
    {
      setValue(DEFAULTSTYLE, "");
    }
    else
    {
      setValue(DEFAULTSTYLE, value.getId());
    }
  }
  
  public com.runwaysdk.system.metadata.MdDomain getEntityDomain()
  {
    if (getValue(ENTITYDOMAIN).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdDomain.get(getValue(ENTITYDOMAIN));
    }
  }
  
  public String getEntityDomainId()
  {
    return getValue(ENTITYDOMAIN);
  }
  
  public void validateEntityDomain()
  {
    this.validateAttribute(ENTITYDOMAIN);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getEntityDomainMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(ENTITYDOMAIN);
  }
  
  public void setEntityDomain(com.runwaysdk.system.metadata.MdDomain value)
  {
    if(value == null)
    {
      setValue(ENTITYDOMAIN, "");
    }
    else
    {
      setValue(ENTITYDOMAIN, value.getId());
    }
  }
  
  public Boolean getForceRefresh()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(FORCEREFRESH));
  }
  
  public void validateForceRefresh()
  {
    this.validateAttribute(FORCEREFRESH);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getForceRefreshMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(FORCEREFRESH);
  }
  
  public void setForceRefresh(Boolean value)
  {
    if(value == null)
    {
      setValue(FORCEREFRESH, "");
    }
    else
    {
      setValue(FORCEREFRESH, java.lang.Boolean.toString(value));
    }
  }
  
  public String getId()
  {
    return getValue(ID);
  }
  
  public void validateId()
  {
    this.validateAttribute(ID);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getIdMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(ID);
  }
  
  public String getKeyName()
  {
    return getValue(KEYNAME);
  }
  
  public void validateKeyName()
  {
    this.validateAttribute(KEYNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getKeyNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(KEYNAME);
  }
  
  public void setKeyName(String value)
  {
    if(value == null)
    {
      setValue(KEYNAME, "");
    }
    else
    {
      setValue(KEYNAME, value);
    }
  }
  
  public java.util.Date getLastUpdateDate()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(LASTUPDATEDATE));
  }
  
  public void validateLastUpdateDate()
  {
    this.validateAttribute(LASTUPDATEDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getLastUpdateDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(LASTUPDATEDATE);
  }
  
  public com.runwaysdk.system.SingleActor getLastUpdatedBy()
  {
    if (getValue(LASTUPDATEDBY).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.SingleActor.get(getValue(LASTUPDATEDBY));
    }
  }
  
  public String getLastUpdatedById()
  {
    return getValue(LASTUPDATEDBY);
  }
  
  public void validateLastUpdatedBy()
  {
    this.validateAttribute(LASTUPDATEDBY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getLastUpdatedByMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(LASTUPDATEDBY);
  }
  
  public com.runwaysdk.system.gis.mapping.LayerLayerName getLayerName()
  {
    return (com.runwaysdk.system.gis.mapping.LayerLayerName) layerName;
  }
  
  public void validateLayerName()
  {
    this.validateAttribute(LAYERNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getLayerNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(LAYERNAME);
  }
  
  public com.runwaysdk.system.Users getLockedBy()
  {
    if (getValue(LOCKEDBY).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.Users.get(getValue(LOCKEDBY));
    }
  }
  
  public String getLockedById()
  {
    return getValue(LOCKEDBY);
  }
  
  public void validateLockedBy()
  {
    this.validateAttribute(LOCKEDBY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getLockedByMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(LOCKEDBY);
  }
  
  public com.runwaysdk.system.Actor getOwner()
  {
    if (getValue(OWNER).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.Actor.get(getValue(OWNER));
    }
  }
  
  public String getOwnerId()
  {
    return getValue(OWNER);
  }
  
  public void validateOwner()
  {
    this.validateAttribute(OWNER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getOwnerMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(OWNER);
  }
  
  public void setOwner(com.runwaysdk.system.Actor value)
  {
    if(value == null)
    {
      setValue(OWNER, "");
    }
    else
    {
      setValue(OWNER, value.getId());
    }
  }
  
  public Boolean getPublished()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(PUBLISHED));
  }
  
  public void validatePublished()
  {
    this.validateAttribute(PUBLISHED);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getPublishedMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(PUBLISHED);
  }
  
  public void setPublished(Boolean value)
  {
    if(value == null)
    {
      setValue(PUBLISHED, "");
    }
    else
    {
      setValue(PUBLISHED, java.lang.Boolean.toString(value));
    }
  }
  
  public Long getSeq()
  {
    return com.runwaysdk.constants.MdAttributeLongUtil.getTypeSafeValue(getValue(SEQ));
  }
  
  public void validateSeq()
  {
    this.validateAttribute(SEQ);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSeqMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(SEQ);
  }
  
  public String getSiteMaster()
  {
    return getValue(SITEMASTER);
  }
  
  public void validateSiteMaster()
  {
    this.validateAttribute(SITEMASTER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSiteMasterMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(SITEMASTER);
  }
  
  public com.runwaysdk.system.gis.mapping.LayerSQLBuilder getSqlBuilder()
  {
    if (getValue(SQLBUILDER).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.gis.mapping.LayerSQLBuilder.get(getValue(SQLBUILDER));
    }
  }
  
  public String getSqlBuilderId()
  {
    return getValue(SQLBUILDER);
  }
  
  public void validateSqlBuilder()
  {
    this.validateAttribute(SQLBUILDER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSqlBuilderMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(SQLBUILDER);
  }
  
  public void setSqlBuilder(com.runwaysdk.system.gis.mapping.LayerSQLBuilder value)
  {
    if(value == null)
    {
      setValue(SQLBUILDER, "");
    }
    else
    {
      setValue(SQLBUILDER, value.getId());
    }
  }
  
  public String getType()
  {
    return getValue(TYPE);
  }
  
  public void validateType()
  {
    this.validateAttribute(TYPE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getTypeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.gis.mapping.Layer.CLASS);
    return mdClassIF.definesAttribute(TYPE);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.gis.mapping.HasThematicAttribute addHasThematicAttribute(com.runwaysdk.system.gis.mapping.ThematicAttribute thematicAttribute)
  {
    return (com.runwaysdk.system.gis.mapping.HasThematicAttribute) addChild(thematicAttribute, com.runwaysdk.system.gis.mapping.HasThematicAttribute.CLASS);
  }
  
  public void removeHasThematicAttribute(com.runwaysdk.system.gis.mapping.ThematicAttribute thematicAttribute)
  {
    removeAllChildren(thematicAttribute, com.runwaysdk.system.gis.mapping.HasThematicAttribute.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.ThematicAttribute> getAllHasThematicAttribute()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.ThematicAttribute>) getChildren(com.runwaysdk.system.gis.mapping.HasThematicAttribute.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.HasThematicAttribute> getAllHasThematicAttributeRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.HasThematicAttribute>) getChildRelationships(com.runwaysdk.system.gis.mapping.HasThematicAttribute.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.HasThematicAttribute> getHasThematicAttributeRel(com.runwaysdk.system.gis.mapping.ThematicAttribute thematicAttribute)
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.HasThematicAttribute>) getRelationshipsWithChild(thematicAttribute, com.runwaysdk.system.gis.mapping.HasThematicAttribute.CLASS);
  }
  
  public com.runwaysdk.system.gis.mapping.HasLayer addContainingMap(com.runwaysdk.system.gis.mapping.GeneratedMap generatedMap)
  {
    return (com.runwaysdk.system.gis.mapping.HasLayer) addParent(generatedMap, com.runwaysdk.system.gis.mapping.HasLayer.CLASS);
  }
  
  public void removeContainingMap(com.runwaysdk.system.gis.mapping.GeneratedMap generatedMap)
  {
    removeAllParents(generatedMap, com.runwaysdk.system.gis.mapping.HasLayer.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.GeneratedMap> getAllContainingMap()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.GeneratedMap>) getParents(com.runwaysdk.system.gis.mapping.HasLayer.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.HasLayer> getAllContainingMapRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.HasLayer>) getParentRelationships(com.runwaysdk.system.gis.mapping.HasLayer.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.HasLayer> getContainingMapRel(com.runwaysdk.system.gis.mapping.GeneratedMap generatedMap)
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.gis.mapping.HasLayer>) getRelationshipsWithParent(generatedMap, com.runwaysdk.system.gis.mapping.HasLayer.CLASS);
  }
  
  public static Layer get(String id)
  {
    return (Layer) com.runwaysdk.business.Business.get(id);
  }
  
  public static Layer getByKey(String key)
  {
    return (Layer) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static Layer lock(java.lang.String id)
  {
    Layer _instance = Layer.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static Layer unlock(java.lang.String id)
  {
    Layer _instance = Layer.get(id);
    _instance.unlock();
    
    return _instance;
  }
  
  public String toString()
  {
    if (this.isNew())
    {
      return "New: "+ this.getClassDisplayLabel();
    }
    else
    {
      return super.toString();
    }
  }
}
