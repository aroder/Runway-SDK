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
package com.runwaysdk.jstest;

@com.runwaysdk.business.ClassSignature(hash = 1453594677)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to TestView.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class TestViewBase extends com.runwaysdk.business.View implements com.runwaysdk.generation.loader.Reloadable
{
  public final static String CLASS = "com.runwaysdk.jstest.TestView";
  public static java.lang.String ID = "id";
  public static java.lang.String VIEWCHARACTER = "viewCharacter";
  public static java.lang.String VIEWPHONE = "viewPhone";
  private com.runwaysdk.business.Struct viewPhone = null;
  
  public static java.lang.String VIEWREFERENCEOBJECT = "viewReferenceObject";
  public static java.lang.String VIEWSINGLESTATE = "viewSingleState";
  private static final long serialVersionUID = 1453594677;
  
  public TestViewBase()
  {
    super();
    viewPhone = super.getStruct("viewPhone");
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.jstest.TestView.CLASS);
    return mdClassIF.definesAttribute(ID);
  }
  
  public String getViewCharacter()
  {
    return getValue(VIEWCHARACTER);
  }
  
  public void validateViewCharacter()
  {
    this.validateAttribute(VIEWCHARACTER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getViewCharacterMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.jstest.TestView.CLASS);
    return mdClassIF.definesAttribute(VIEWCHARACTER);
  }
  
  public void setViewCharacter(String value)
  {
    if(value == null)
    {
      setValue(VIEWCHARACTER, "");
    }
    else
    {
      setValue(VIEWCHARACTER, value);
    }
  }
  
  public com.runwaysdk.system.PhoneNumber getViewPhone()
  {
    return (com.runwaysdk.system.PhoneNumber) viewPhone;
  }
  
  public void validateViewPhone()
  {
    this.validateAttribute(VIEWPHONE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getViewPhoneMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.jstest.TestView.CLASS);
    return mdClassIF.definesAttribute(VIEWPHONE);
  }
  
  public com.runwaysdk.jstest.RefClass getViewReferenceObject()
  {
    if (getValue(VIEWREFERENCEOBJECT).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.jstest.RefClass.get(getValue(VIEWREFERENCEOBJECT));
    }
  }
  
  public String getViewReferenceObjectId()
  {
    return getValue(VIEWREFERENCEOBJECT);
  }
  
  public void validateViewReferenceObject()
  {
    this.validateAttribute(VIEWREFERENCEOBJECT);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getViewReferenceObjectMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.jstest.TestView.CLASS);
    return mdClassIF.definesAttribute(VIEWREFERENCEOBJECT);
  }
  
  public void setViewReferenceObject(com.runwaysdk.jstest.RefClass value)
  {
    if(value == null)
    {
      setValue(VIEWREFERENCEOBJECT, "");
    }
    else
    {
      setValue(VIEWREFERENCEOBJECT, value.getId());
    }
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<com.runwaysdk.jstest.States> getViewSingleState()
  {
    return (java.util.List<com.runwaysdk.jstest.States>) getEnumValues(VIEWSINGLESTATE);
  }
  
  public void addViewSingleState(com.runwaysdk.jstest.States value)
  {
    if(value != null)
    {
      addEnumItem(VIEWSINGLESTATE, value.getId());
    }
  }
  
  public void removeViewSingleState(com.runwaysdk.jstest.States value)
  {
    if(value != null)
    {
      removeEnumItem(VIEWSINGLESTATE, value.getId());
    }
  }
  
  public void clearViewSingleState()
  {
    clearEnum(VIEWSINGLESTATE);
  }
  
  public void validateViewSingleState()
  {
    this.validateAttribute(VIEWSINGLESTATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getViewSingleStateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.jstest.TestView.CLASS);
    return mdClassIF.definesAttribute(VIEWSINGLESTATE);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static TestView get(String id)
  {
    return (TestView) com.runwaysdk.business.View.get(id);
  }
  
  public static java.lang.Integer doubleAnInt(java.lang.Integer num)
  {
    String msg = "This method should never be invoked.  It should be overwritten in com.runwaysdk.jstest.TestView.java";
    throw new com.runwaysdk.dataaccess.metadata.ForbiddenMethodException(msg);
  }
  
  public com.runwaysdk.jstest.TestView returnView(com.runwaysdk.jstest.TestView input)
  {
    String msg = "This method should never be invoked.  It should be overwritten in com.runwaysdk.jstest.TestView.java";
    throw new com.runwaysdk.dataaccess.metadata.ForbiddenMethodException(msg);
  }
  
  public static final com.runwaysdk.jstest.TestView returnView(java.lang.String id, com.runwaysdk.jstest.TestView input)
  {
    TestView _instance = TestView.get(id);
    return _instance.returnView(input);
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
