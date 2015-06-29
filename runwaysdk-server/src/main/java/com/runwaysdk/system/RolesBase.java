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
package com.runwaysdk.system;

@com.runwaysdk.business.ClassSignature(hash = -1883304567)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to Roles.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class RolesBase extends com.runwaysdk.system.Actor
{
  public final static String CLASS = "com.runwaysdk.system.Roles";
  public static java.lang.String DISPLAYLABEL = "displayLabel";
  private com.runwaysdk.business.Struct displayLabel = null;
  
  public static java.lang.String ROLENAME = "roleName";
  private static final long serialVersionUID = -1883304567;
  
  public RolesBase()
  {
    super();
    displayLabel = super.getStruct("displayLabel");
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.Roles.CLASS);
    return mdClassIF.definesAttribute(DISPLAYLABEL);
  }
  
  public String getRoleName()
  {
    return getValue(ROLENAME);
  }
  
  public void validateRoleName()
  {
    this.validateAttribute(ROLENAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getRoleNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.Roles.CLASS);
    return mdClassIF.definesAttribute(ROLENAME);
  }
  
  public void setRoleName(String value)
  {
    if(value == null)
    {
      setValue(ROLENAME, "");
    }
    else
    {
      setValue(ROLENAME, value);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public com.runwaysdk.system.ConflictingRoles addRole(com.runwaysdk.system.SDuty sDuty)
  {
    return (com.runwaysdk.system.ConflictingRoles) addChild(sDuty, com.runwaysdk.system.ConflictingRoles.CLASS);
  }
  
  public void removeRole(com.runwaysdk.system.SDuty sDuty)
  {
    removeAllChildren(sDuty, com.runwaysdk.system.ConflictingRoles.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.SDuty> getAllRole()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.SDuty>) getChildren(com.runwaysdk.system.ConflictingRoles.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ConflictingRoles> getAllRoleRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ConflictingRoles>) getChildRelationships(com.runwaysdk.system.ConflictingRoles.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.ConflictingRoles getRoleRel(com.runwaysdk.system.SDuty sDuty)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ConflictingRoles> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.ConflictingRoles>) getRelationshipsWithChild(sDuty, com.runwaysdk.system.ConflictingRoles.CLASS);
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
  
  public com.runwaysdk.system.RoleInheritance addchildRole(com.runwaysdk.system.Roles roles)
  {
    return (com.runwaysdk.system.RoleInheritance) addChild(roles, com.runwaysdk.system.RoleInheritance.CLASS);
  }
  
  public void removechildRole(com.runwaysdk.system.Roles roles)
  {
    removeAllChildren(roles, com.runwaysdk.system.RoleInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.Roles> getAllchildRole()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.Roles>) getChildren(com.runwaysdk.system.RoleInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.RoleInheritance> getAllchildRoleRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.RoleInheritance>) getChildRelationships(com.runwaysdk.system.RoleInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.RoleInheritance getchildRoleRel(com.runwaysdk.system.Roles roles)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.RoleInheritance> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.RoleInheritance>) getRelationshipsWithChild(roles, com.runwaysdk.system.RoleInheritance.CLASS);
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
  
  public com.runwaysdk.system.RoleInheritance addParentRole(com.runwaysdk.system.Roles roles)
  {
    return (com.runwaysdk.system.RoleInheritance) addParent(roles, com.runwaysdk.system.RoleInheritance.CLASS);
  }
  
  public void removeParentRole(com.runwaysdk.system.Roles roles)
  {
    removeAllParents(roles, com.runwaysdk.system.RoleInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.Roles> getAllParentRole()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.Roles>) getParents(com.runwaysdk.system.RoleInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.RoleInheritance> getAllParentRoleRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.RoleInheritance>) getParentRelationships(com.runwaysdk.system.RoleInheritance.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.RoleInheritance getParentRoleRel(com.runwaysdk.system.Roles roles)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.RoleInheritance> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.RoleInheritance>) getRelationshipsWithParent(roles, com.runwaysdk.system.RoleInheritance.CLASS);
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
  
  public com.runwaysdk.system.Assignments addSingleActor(com.runwaysdk.system.SingleActor singleActor)
  {
    return (com.runwaysdk.system.Assignments) addParent(singleActor, com.runwaysdk.system.Assignments.CLASS);
  }
  
  public void removeSingleActor(com.runwaysdk.system.SingleActor singleActor)
  {
    removeAllParents(singleActor, com.runwaysdk.system.Assignments.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.SingleActor> getAllSingleActor()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.SingleActor>) getParents(com.runwaysdk.system.Assignments.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.Assignments> getAllSingleActorRel()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.Assignments>) getParentRelationships(com.runwaysdk.system.Assignments.CLASS);
  }
  
  @SuppressWarnings("unchecked")
  public com.runwaysdk.system.Assignments getSingleActorRel(com.runwaysdk.system.SingleActor singleActor)
  {
    com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.Assignments> iterator = (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.Assignments>) getRelationshipsWithParent(singleActor, com.runwaysdk.system.Assignments.CLASS);
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
  
  public static Roles get(String id)
  {
    return (Roles) com.runwaysdk.business.Business.get(id);
  }
  
  public static Roles getByKey(String key)
  {
    return (Roles) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static Roles lock(java.lang.String id)
  {
    Roles _instance = Roles.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static Roles unlock(java.lang.String id)
  {
    Roles _instance = Roles.get(id);
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
