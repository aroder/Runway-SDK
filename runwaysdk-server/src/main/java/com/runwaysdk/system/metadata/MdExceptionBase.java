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

@com.runwaysdk.business.ClassSignature(hash = 676313690)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdException.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdExceptionBase extends com.runwaysdk.system.metadata.MdLocalizable
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdException";
  public static java.lang.String SUPERMDEXCEPTION = "superMdException";
  private static final long serialVersionUID = 676313690;
  
  public MdExceptionBase()
  {
    super();
  }
  
  public com.runwaysdk.system.metadata.MdException getSuperMdException()
  {
    if (getValue(SUPERMDEXCEPTION).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdException.get(getValue(SUPERMDEXCEPTION));
    }
  }
  
  public String getSuperMdExceptionId()
  {
    return getValue(SUPERMDEXCEPTION);
  }
  
  public void validateSuperMdException()
  {
    this.validateAttribute(SUPERMDEXCEPTION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getSuperMdExceptionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdException.CLASS);
    return mdClassIF.definesAttribute(SUPERMDEXCEPTION);
  }
  
  public void setSuperMdException(com.runwaysdk.system.metadata.MdException value)
  {
    if(value == null)
    {
      setValue(SUPERMDEXCEPTION, "");
    }
    else
    {
      setValue(SUPERMDEXCEPTION, value.getId());
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.metadata.ExceptionInheritance addChildExceptions(com.runwaysdk.system.metadata.MdException mdException)
  {
    return (com.runwaysdk.system.metadata.ExceptionInheritance) addChild(mdException, com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
  }
  
  public void removeChildExceptions(com.runwaysdk.system.metadata.MdException mdException)
  {
    removeAllChildren(mdException, com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdException> getAllChildExceptions()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdException>) getChildren(com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ExceptionInheritance> getAllChildExceptionsRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ExceptionInheritance>) getChildRelationships(com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.ExceptionInheritance getChildExceptionsRel(com.runwaysdk.system.metadata.MdException mdException)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ExceptionInheritance> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ExceptionInheritance>) getRelationshipsWithChild(mdException, com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
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
  
  public com.runwaysdk.system.metadata.ExceptionInheritance addParentException(com.runwaysdk.system.metadata.MdException mdException)
  {
    return (com.runwaysdk.system.metadata.ExceptionInheritance) addParent(mdException, com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
  }
  
  public void removeParentException(com.runwaysdk.system.metadata.MdException mdException)
  {
    removeAllParents(mdException, com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdException> getAllParentException()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.MdException>) getParents(com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ExceptionInheritance> getAllParentExceptionRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ExceptionInheritance>) getParentRelationships(com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.metadata.ExceptionInheritance getParentExceptionRel(com.runwaysdk.system.metadata.MdException mdException)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ExceptionInheritance> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.metadata.ExceptionInheritance>) getRelationshipsWithParent(mdException, com.runwaysdk.system.metadata.ExceptionInheritance.CLASS);
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
  
  public static MdException get(String id)
  {
    return (MdException) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdException getByKey(String key)
  {
    return (MdException) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdException lock(java.lang.String id)
  {
    MdException _instance = MdException.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdException unlock(java.lang.String id)
  {
    MdException _instance = MdException.get(id);
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
