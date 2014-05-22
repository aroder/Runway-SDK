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

@com.runwaysdk.business.ClassSignature(hash = 1532951998)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdAction.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdActionBase extends com.runwaysdk.system.metadata.Metadata
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdAction";
  public static java.lang.String ACTIONNAME = "actionName";
  public static java.lang.String DISPLAYLABEL = "displayLabel";
  private com.runwaysdk.business.Struct displayLabel = null;
  
  public static java.lang.String ENCLOSINGMDCONTROLLER = "enclosingMdController";
  public static java.lang.String ISPOST = "isPost";
  public static java.lang.String ISQUERY = "isQuery";
  private static final long serialVersionUID = 1532951998;
  
  public MdActionBase()
  {
    super();
    displayLabel = super.getStruct("displayLabel");
  }
  
  public String getActionName()
  {
    return getValue(ACTIONNAME);
  }
  
  public void validateActionName()
  {
    this.validateAttribute(ACTIONNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getActionNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAction.CLASS);
    return mdClassIF.definesAttribute(ACTIONNAME);
  }
  
  public void setActionName(String value)
  {
    if(value == null)
    {
      setValue(ACTIONNAME, "");
    }
    else
    {
      setValue(ACTIONNAME, value);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAction.CLASS);
    return mdClassIF.definesAttribute(DISPLAYLABEL);
  }
  
  public com.runwaysdk.system.metadata.MdController getEnclosingMdController()
  {
    if (getValue(ENCLOSINGMDCONTROLLER).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdController.get(getValue(ENCLOSINGMDCONTROLLER));
    }
  }
  
  public String getEnclosingMdControllerId()
  {
    return getValue(ENCLOSINGMDCONTROLLER);
  }
  
  public void validateEnclosingMdController()
  {
    this.validateAttribute(ENCLOSINGMDCONTROLLER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getEnclosingMdControllerMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAction.CLASS);
    return mdClassIF.definesAttribute(ENCLOSINGMDCONTROLLER);
  }
  
  public void setEnclosingMdController(com.runwaysdk.system.metadata.MdController value)
  {
    if(value == null)
    {
      setValue(ENCLOSINGMDCONTROLLER, "");
    }
    else
    {
      setValue(ENCLOSINGMDCONTROLLER, value.getId());
    }
  }
  
  public Boolean getIsPost()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(ISPOST));
  }
  
  public void validateIsPost()
  {
    this.validateAttribute(ISPOST);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getIsPostMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAction.CLASS);
    return mdClassIF.definesAttribute(ISPOST);
  }
  
  public void setIsPost(Boolean value)
  {
    if(value == null)
    {
      setValue(ISPOST, "");
    }
    else
    {
      setValue(ISPOST, java.lang.Boolean.toString(value));
    }
  }
  
  public Boolean getIsQuery()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(ISQUERY));
  }
  
  public void validateIsQuery()
  {
    this.validateAttribute(ISQUERY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getIsQueryMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdAction.CLASS);
    return mdClassIF.definesAttribute(ISQUERY);
  }
  
  public void setIsQuery(Boolean value)
  {
    if(value == null)
    {
      setValue(ISQUERY, "");
    }
    else
    {
      setValue(ISQUERY, java.lang.Boolean.toString(value));
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.ControllerAction addMdContoller(com.runwaysdk.system.metadata.MdController mdController)
  {
    return (com.runwaysdk.system.ControllerAction) addParent(mdController, com.runwaysdk.system.ControllerAction.CLASS);
  }
  
  public void removeMdContoller(com.runwaysdk.system.metadata.MdController mdController)
  {
    removeAllParents(mdController, com.runwaysdk.system.ControllerAction.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdController> getAllMdContoller()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdController>) getParents(com.runwaysdk.system.ControllerAction.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ControllerAction> getAllMdContollerRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ControllerAction>) getParentRelationships(com.runwaysdk.system.ControllerAction.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.ControllerAction getMdContollerRel(com.runwaysdk.system.metadata.MdController mdController)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ControllerAction> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ControllerAction>) getRelationshipsWithParent(mdController, com.runwaysdk.system.ControllerAction.CLASS);
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
  
  public static MdAction get(String id)
  {
    return (MdAction) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdAction getByKey(String key)
  {
    return (MdAction) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdAction lock(java.lang.String id)
  {
    MdAction _instance = MdAction.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdAction unlock(java.lang.String id)
  {
    MdAction _instance = MdAction.get(id);
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
