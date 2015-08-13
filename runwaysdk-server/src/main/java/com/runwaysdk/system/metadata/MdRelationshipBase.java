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

@com.runwaysdk.business.ClassSignature(hash = -1596212499)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdRelationship.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdRelationshipBase extends com.runwaysdk.system.metadata.MdElement
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdRelationship";
  public static java.lang.String CACHEALGORITHM = "cacheAlgorithm";
  public static java.lang.String CHILDCARDINALITY = "childCardinality";
  public static java.lang.String CHILDDISPLAYLABEL = "childDisplayLabel";
  private com.runwaysdk.business.Struct childDisplayLabel = null;
  
  public static java.lang.String CHILDMDBUSINESS = "childMdBusiness";
  public static java.lang.String CHILDMETHOD = "childMethod";
  public static java.lang.String CHILDVISIBILITY = "childVisibility";
  public static java.lang.String COMPOSITION = "composition";
  public static java.lang.String INDEX1NAME = "index1Name";
  public static java.lang.String INDEX2NAME = "index2Name";
  public static java.lang.String PARENTCARDINALITY = "parentCardinality";
  public static java.lang.String PARENTDISPLAYLABEL = "parentDisplayLabel";
  private com.runwaysdk.business.Struct parentDisplayLabel = null;
  
  public static java.lang.String PARENTMDBUSINESS = "parentMdBusiness";
  public static java.lang.String PARENTMETHOD = "parentMethod";
  public static java.lang.String PARENTVISIBILITY = "parentVisibility";
  public static java.lang.String SORTMDATTRIBUTE = "sortMdAttribute";
  public static java.lang.String SUPERMDRELATIONSHIP = "superMdRelationship";
  private static final long serialVersionUID = -1596212499;
  
  public MdRelationshipBase()
  {
    super();
    childDisplayLabel = super.getStruct("childDisplayLabel");
    parentDisplayLabel = super.getStruct("parentDisplayLabel");
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<com.runwaysdk.system.metadata.RelationshipCache> getCacheAlgorithm()
  {
    return (java.util.List<com.runwaysdk.system.metadata.RelationshipCache>) getEnumValues(CACHEALGORITHM);
  }
  
  public void addCacheAlgorithm(com.runwaysdk.system.metadata.RelationshipCache value)
  {
    if(value != null)
    {
      addEnumItem(CACHEALGORITHM, value.getId());
    }
  }
  
  public void removeCacheAlgorithm(com.runwaysdk.system.metadata.RelationshipCache value)
  {
    if(value != null)
    {
      removeEnumItem(CACHEALGORITHM, value.getId());
    }
  }
  
  public void clearCacheAlgorithm()
  {
    clearEnum(CACHEALGORITHM);
  }
  
  public void validateCacheAlgorithm()
  {
    this.validateAttribute(CACHEALGORITHM);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCacheAlgorithmMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(CACHEALGORITHM);
  }
  
  public String getChildCardinality()
  {
    return getValue(CHILDCARDINALITY);
  }
  
  public void validateChildCardinality()
  {
    this.validateAttribute(CHILDCARDINALITY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getChildCardinalityMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(CHILDCARDINALITY);
  }
  
  public void setChildCardinality(String value)
  {
    if(value == null)
    {
      setValue(CHILDCARDINALITY, "");
    }
    else
    {
      setValue(CHILDCARDINALITY, value);
    }
  }
  
  public com.runwaysdk.system.metadata.MetadataDisplayLabel getChildDisplayLabel()
  {
    return (com.runwaysdk.system.metadata.MetadataDisplayLabel) childDisplayLabel;
  }
  
  public void validateChildDisplayLabel()
  {
    this.validateAttribute(CHILDDISPLAYLABEL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getChildDisplayLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(CHILDDISPLAYLABEL);
  }
  
  public com.runwaysdk.system.metadata.MdBusiness getChildMdBusiness()
  {
    if (getValue(CHILDMDBUSINESS).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdBusiness.get(getValue(CHILDMDBUSINESS));
    }
  }
  
  public String getChildMdBusinessId()
  {
    return getValue(CHILDMDBUSINESS);
  }
  
  public void validateChildMdBusiness()
  {
    this.validateAttribute(CHILDMDBUSINESS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getChildMdBusinessMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(CHILDMDBUSINESS);
  }
  
  public void setChildMdBusiness(com.runwaysdk.system.metadata.MdBusiness value)
  {
    if(value == null)
    {
      setValue(CHILDMDBUSINESS, "");
    }
    else
    {
      setValue(CHILDMDBUSINESS, value.getId());
    }
  }
  
  public String getChildMethod()
  {
    return getValue(CHILDMETHOD);
  }
  
  public void validateChildMethod()
  {
    this.validateAttribute(CHILDMETHOD);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getChildMethodMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(CHILDMETHOD);
  }
  
  public void setChildMethod(String value)
  {
    if(value == null)
    {
      setValue(CHILDMETHOD, "");
    }
    else
    {
      setValue(CHILDMETHOD, value);
    }
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<com.runwaysdk.system.metadata.VisibilityModifier> getChildVisibility()
  {
    return (java.util.List<com.runwaysdk.system.metadata.VisibilityModifier>) getEnumValues(CHILDVISIBILITY);
  }
  
  public void addChildVisibility(com.runwaysdk.system.metadata.VisibilityModifier value)
  {
    if(value != null)
    {
      addEnumItem(CHILDVISIBILITY, value.getId());
    }
  }
  
  public void removeChildVisibility(com.runwaysdk.system.metadata.VisibilityModifier value)
  {
    if(value != null)
    {
      removeEnumItem(CHILDVISIBILITY, value.getId());
    }
  }
  
  public void clearChildVisibility()
  {
    clearEnum(CHILDVISIBILITY);
  }
  
  public void validateChildVisibility()
  {
    this.validateAttribute(CHILDVISIBILITY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getChildVisibilityMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(CHILDVISIBILITY);
  }
  
  public Boolean getComposition()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(COMPOSITION));
  }
  
  public void validateComposition()
  {
    this.validateAttribute(COMPOSITION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCompositionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(COMPOSITION);
  }
  
  public void setComposition(Boolean value)
  {
    if(value == null)
    {
      setValue(COMPOSITION, "");
    }
    else
    {
      setValue(COMPOSITION, java.lang.Boolean.toString(value));
    }
  }
  
  public String getIndex1Name()
  {
    return getValue(INDEX1NAME);
  }
  
  public void validateIndex1Name()
  {
    this.validateAttribute(INDEX1NAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getIndex1NameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(INDEX1NAME);
  }
  
  public String getIndex2Name()
  {
    return getValue(INDEX2NAME);
  }
  
  public void validateIndex2Name()
  {
    this.validateAttribute(INDEX2NAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getIndex2NameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(INDEX2NAME);
  }
  
  public String getParentCardinality()
  {
    return getValue(PARENTCARDINALITY);
  }
  
  public void validateParentCardinality()
  {
    this.validateAttribute(PARENTCARDINALITY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getParentCardinalityMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(PARENTCARDINALITY);
  }
  
  public void setParentCardinality(String value)
  {
    if(value == null)
    {
      setValue(PARENTCARDINALITY, "");
    }
    else
    {
      setValue(PARENTCARDINALITY, value);
    }
  }
  
  public com.runwaysdk.system.metadata.MetadataDisplayLabel getParentDisplayLabel()
  {
    return (com.runwaysdk.system.metadata.MetadataDisplayLabel) parentDisplayLabel;
  }
  
  public void validateParentDisplayLabel()
  {
    this.validateAttribute(PARENTDISPLAYLABEL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getParentDisplayLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(PARENTDISPLAYLABEL);
  }
  
  public com.runwaysdk.system.metadata.MdBusiness getParentMdBusiness()
  {
    if (getValue(PARENTMDBUSINESS).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdBusiness.get(getValue(PARENTMDBUSINESS));
    }
  }
  
  public String getParentMdBusinessId()
  {
    return getValue(PARENTMDBUSINESS);
  }
  
  public void validateParentMdBusiness()
  {
    this.validateAttribute(PARENTMDBUSINESS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getParentMdBusinessMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(PARENTMDBUSINESS);
  }
  
  public void setParentMdBusiness(com.runwaysdk.system.metadata.MdBusiness value)
  {
    if(value == null)
    {
      setValue(PARENTMDBUSINESS, "");
    }
    else
    {
      setValue(PARENTMDBUSINESS, value.getId());
    }
  }
  
  public String getParentMethod()
  {
    return getValue(PARENTMETHOD);
  }
  
  public void validateParentMethod()
  {
    this.validateAttribute(PARENTMETHOD);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getParentMethodMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(PARENTMETHOD);
  }
  
  public void setParentMethod(String value)
  {
    if(value == null)
    {
      setValue(PARENTMETHOD, "");
    }
    else
    {
      setValue(PARENTMETHOD, value);
    }
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<com.runwaysdk.system.metadata.VisibilityModifier> getParentVisibility()
  {
    return (java.util.List<com.runwaysdk.system.metadata.VisibilityModifier>) getEnumValues(PARENTVISIBILITY);
  }
  
  public void addParentVisibility(com.runwaysdk.system.metadata.VisibilityModifier value)
  {
    if(value != null)
    {
      addEnumItem(PARENTVISIBILITY, value.getId());
    }
  }
  
  public void removeParentVisibility(com.runwaysdk.system.metadata.VisibilityModifier value)
  {
    if(value != null)
    {
      removeEnumItem(PARENTVISIBILITY, value.getId());
    }
  }
  
  public void clearParentVisibility()
  {
    clearEnum(PARENTVISIBILITY);
  }
  
  public void validateParentVisibility()
  {
    this.validateAttribute(PARENTVISIBILITY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getParentVisibilityMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(PARENTVISIBILITY);
  }
  
  public com.runwaysdk.system.metadata.MdAttributePrimitive getSortMdAttribute()
  {
    if (getValue(SORTMDATTRIBUTE).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdAttributePrimitive.get(getValue(SORTMDATTRIBUTE));
    }
  }
  
  public String getSortMdAttributeId()
  {
    return getValue(SORTMDATTRIBUTE);
  }
  
  public void validateSortMdAttribute()
  {
    this.validateAttribute(SORTMDATTRIBUTE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSortMdAttributeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(SORTMDATTRIBUTE);
  }
  
  public void setSortMdAttribute(com.runwaysdk.system.metadata.MdAttributePrimitive value)
  {
    if(value == null)
    {
      setValue(SORTMDATTRIBUTE, "");
    }
    else
    {
      setValue(SORTMDATTRIBUTE, value.getId());
    }
  }
  
  public com.runwaysdk.system.metadata.MdRelationship getSuperMdRelationship()
  {
    if (getValue(SUPERMDRELATIONSHIP).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdRelationship.get(getValue(SUPERMDRELATIONSHIP));
    }
  }
  
  public String getSuperMdRelationshipId()
  {
    return getValue(SUPERMDRELATIONSHIP);
  }
  
  public void validateSuperMdRelationship()
  {
    this.validateAttribute(SUPERMDRELATIONSHIP);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSuperMdRelationshipMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdRelationship.CLASS);
    return mdClassIF.definesAttribute(SUPERMDRELATIONSHIP);
  }
  
  public void setSuperMdRelationship(com.runwaysdk.system.metadata.MdRelationship value)
  {
    if(value == null)
    {
      setValue(SUPERMDRELATIONSHIP, "");
    }
    else
    {
      setValue(SUPERMDRELATIONSHIP, value.getId());
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.RelationshipInheritance addSubRelationship(com.runwaysdk.system.metadata.MdRelationship mdRelationship)
  {
    return (com.runwaysdk.system.metadata.RelationshipInheritance) addChild(mdRelationship, com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
  }
  
  public void removeSubRelationship(com.runwaysdk.system.metadata.MdRelationship mdRelationship)
  {
    removeAllChildren(mdRelationship, com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdRelationship> getAllSubRelationship()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdRelationship>) getChildren(com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.RelationshipInheritance> getAllSubRelationshipRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.RelationshipInheritance>) getChildRelationships(com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.RelationshipInheritance getSubRelationshipRel(com.runwaysdk.system.metadata.MdRelationship mdRelationship)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.RelationshipInheritance> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.RelationshipInheritance>) getRelationshipsWithChild(mdRelationship, com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
    try
    {
      if (iterator.hasNext())
      {
        return iterator.next();
      }
      else
      {
        return null;
      }
    }
    finally
    {
      iterator.close();
    }
  }
  
  public com.runwaysdk.system.metadata.RelationshipInheritance addInheritsFromRelationship(com.runwaysdk.system.metadata.MdRelationship mdRelationship)
  {
    return (com.runwaysdk.system.metadata.RelationshipInheritance) addParent(mdRelationship, com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
  }
  
  public void removeInheritsFromRelationship(com.runwaysdk.system.metadata.MdRelationship mdRelationship)
  {
    removeAllParents(mdRelationship, com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdRelationship> getAllInheritsFromRelationship()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdRelationship>) getParents(com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.RelationshipInheritance> getAllInheritsFromRelationshipRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.RelationshipInheritance>) getParentRelationships(com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.RelationshipInheritance getInheritsFromRelationshipRel(com.runwaysdk.system.metadata.MdRelationship mdRelationship)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.RelationshipInheritance> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.RelationshipInheritance>) getRelationshipsWithParent(mdRelationship, com.runwaysdk.system.metadata.RelationshipInheritance.CLASS);
    try
    {
      if (iterator.hasNext())
      {
        return iterator.next();
      }
      else
      {
        return null;
      }
    }
    finally
    {
      iterator.close();
    }
  }
  
  public static MdRelationship get(String id)
  {
    return (MdRelationship) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdRelationship getByKey(String key)
  {
    return (MdRelationship) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdRelationship lock(java.lang.String id)
  {
    MdRelationship _instance = MdRelationship.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdRelationship unlock(java.lang.String id)
  {
    MdRelationship _instance = MdRelationship.get(id);
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
