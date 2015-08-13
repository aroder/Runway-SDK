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

@com.runwaysdk.business.ClassSignature(hash = 293875284)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAttributeVirtual.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdAttributeVirtualBase extends com.runwaysdk.system.metadata.MdAttribute
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdAttributeVirtual";
  public static java.lang.String ATTRIBUTENAME = "attributeName";
  public static java.lang.String DEFININGMDVIEW = "definingMdView";
  public static java.lang.String DISPLAYLABEL = "displayLabel";
  private com.runwaysdk.business.Struct displayLabel = null;
  
  public static java.lang.String MDATTRIBUTECONCRETE = "mdAttributeConcrete";
  public static java.lang.String REQUIRED = "required";
  private static final long serialVersionUID = 293875284;
  
  public MdAttributeVirtualBase()
  {
    super();
    displayLabel = super.getStruct("displayLabel");
  }
  
  public String getAttributeName()
  {
    return getValue(ATTRIBUTENAME);
  }
  
  public void validateAttributeName()
  {
    this.validateAttribute(ATTRIBUTENAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getAttributeNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeVirtual.CLASS);
    return mdClassIF.definesAttribute(ATTRIBUTENAME);
  }
  
  public void setAttributeName(String value)
  {
    if(value == null)
    {
      setValue(ATTRIBUTENAME, "");
    }
    else
    {
      setValue(ATTRIBUTENAME, value);
    }
  }
  
  public com.runwaysdk.system.metadata.MdView getDefiningMdView()
  {
    if (getValue(DEFININGMDVIEW).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdView.get(getValue(DEFININGMDVIEW));
    }
  }
  
  public String getDefiningMdViewId()
  {
    return getValue(DEFININGMDVIEW);
  }
  
  public void validateDefiningMdView()
  {
    this.validateAttribute(DEFININGMDVIEW);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDefiningMdViewMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeVirtual.CLASS);
    return mdClassIF.definesAttribute(DEFININGMDVIEW);
  }
  
  public void setDefiningMdView(com.runwaysdk.system.metadata.MdView value)
  {
    if(value == null)
    {
      setValue(DEFININGMDVIEW, "");
    }
    else
    {
      setValue(DEFININGMDVIEW, value.getId());
    }
  }
  
  public com.runwaysdk.system.metadata.MetadataDisplayLabel getDisplayLabel()
  {
    return (com.runwaysdk.system.metadata.MetadataDisplayLabel) displayLabel;
  }
  
  public void validateDisplayLabel()
  {
    this.validateAttribute(DISPLAYLABEL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDisplayLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeVirtual.CLASS);
    return mdClassIF.definesAttribute(DISPLAYLABEL);
  }
  
  public com.runwaysdk.system.metadata.MdAttributeConcrete getMdAttributeConcrete()
  {
    if (getValue(MDATTRIBUTECONCRETE).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdAttributeConcrete.get(getValue(MDATTRIBUTECONCRETE));
    }
  }
  
  public String getMdAttributeConcreteId()
  {
    return getValue(MDATTRIBUTECONCRETE);
  }
  
  public void validateMdAttributeConcrete()
  {
    this.validateAttribute(MDATTRIBUTECONCRETE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getMdAttributeConcreteMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeVirtual.CLASS);
    return mdClassIF.definesAttribute(MDATTRIBUTECONCRETE);
  }
  
  public void setMdAttributeConcrete(com.runwaysdk.system.metadata.MdAttributeConcrete value)
  {
    if(value == null)
    {
      setValue(MDATTRIBUTECONCRETE, "");
    }
    else
    {
      setValue(MDATTRIBUTECONCRETE, value.getId());
    }
  }
  
  public Boolean getRequired()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(REQUIRED));
  }
  
  public void validateRequired()
  {
    this.validateAttribute(REQUIRED);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getRequiredMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAttributeVirtual.CLASS);
    return mdClassIF.definesAttribute(REQUIRED);
  }
  
  public void setRequired(Boolean value)
  {
    if(value == null)
    {
      setValue(REQUIRED, "");
    }
    else
    {
      setValue(REQUIRED, java.lang.Boolean.toString(value));
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.VirtualizeAttribute addConcreteAttribute(com.runwaysdk.system.metadata.MdAttributeConcrete mdAttributeConcrete)
  {
    return (com.runwaysdk.system.metadata.VirtualizeAttribute) addParent(mdAttributeConcrete, com.runwaysdk.system.metadata.VirtualizeAttribute.CLASS);
  }
  
  public void removeConcreteAttribute(com.runwaysdk.system.metadata.MdAttributeConcrete mdAttributeConcrete)
  {
    removeAllParents(mdAttributeConcrete, com.runwaysdk.system.metadata.VirtualizeAttribute.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdAttributeConcrete> getAllConcreteAttribute()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdAttributeConcrete>) getParents(com.runwaysdk.system.metadata.VirtualizeAttribute.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.VirtualizeAttribute> getAllConcreteAttributeRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.VirtualizeAttribute>) getParentRelationships(com.runwaysdk.system.metadata.VirtualizeAttribute.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.VirtualizeAttribute getConcreteAttributeRel(com.runwaysdk.system.metadata.MdAttributeConcrete mdAttributeConcrete)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.VirtualizeAttribute> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.VirtualizeAttribute>) getRelationshipsWithParent(mdAttributeConcrete, com.runwaysdk.system.metadata.VirtualizeAttribute.CLASS);
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
  
  public com.runwaysdk.system.metadata.ClassAttributeVirtual addDefiningView(com.runwaysdk.system.metadata.MdView mdView)
  {
    return (com.runwaysdk.system.metadata.ClassAttributeVirtual) addParent(mdView, com.runwaysdk.system.metadata.ClassAttributeVirtual.CLASS);
  }
  
  public void removeDefiningView(com.runwaysdk.system.metadata.MdView mdView)
  {
    removeAllParents(mdView, com.runwaysdk.system.metadata.ClassAttributeVirtual.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdView> getAllDefiningView()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdView>) getParents(com.runwaysdk.system.metadata.ClassAttributeVirtual.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ClassAttributeVirtual> getAllDefiningViewRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ClassAttributeVirtual>) getParentRelationships(com.runwaysdk.system.metadata.ClassAttributeVirtual.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.ClassAttributeVirtual getDefiningViewRel(com.runwaysdk.system.metadata.MdView mdView)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ClassAttributeVirtual> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ClassAttributeVirtual>) getRelationshipsWithParent(mdView, com.runwaysdk.system.metadata.ClassAttributeVirtual.CLASS);
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
  
  public static MdAttributeVirtual get(String id)
  {
    return (MdAttributeVirtual) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdAttributeVirtual getByKey(String key)
  {
    return (MdAttributeVirtual) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdAttributeVirtual lock(java.lang.String id)
  {
    MdAttributeVirtual _instance = MdAttributeVirtual.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdAttributeVirtual unlock(java.lang.String id)
  {
    MdAttributeVirtual _instance = MdAttributeVirtual.get(id);
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
      return this.getClassDisplayLabel();
    }
  }
}
