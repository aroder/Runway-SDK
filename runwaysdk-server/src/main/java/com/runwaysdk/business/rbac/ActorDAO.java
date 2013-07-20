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
package com.runwaysdk.business.rbac;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.runwaysdk.business.state.MdStateMachineDAO;
import com.runwaysdk.business.state.MdStateMachineDAOIF;
import com.runwaysdk.constants.MdStateMachineInfo;
import com.runwaysdk.constants.RelationshipTypes;
import com.runwaysdk.dataaccess.AttributeEnumerationIF;
import com.runwaysdk.dataaccess.BusinessDAO;
import com.runwaysdk.dataaccess.BusinessDAOIF;
import com.runwaysdk.dataaccess.DataAccessException;
import com.runwaysdk.dataaccess.MdBusinessDAOIF;
import com.runwaysdk.dataaccess.MdClassDAOIF;
import com.runwaysdk.dataaccess.MetadataDAOIF;
import com.runwaysdk.dataaccess.RelationshipDAO;
import com.runwaysdk.dataaccess.RelationshipDAOIF;
import com.runwaysdk.dataaccess.SpecializedDAOImplementationIF;
import com.runwaysdk.dataaccess.attributes.entity.Attribute;
import com.runwaysdk.dataaccess.cache.DataNotFoundException;
import com.runwaysdk.dataaccess.metadata.MdClassDAO;
import com.runwaysdk.dataaccess.transaction.Transaction;
import com.runwaysdk.session.PermissionBuilder;
import com.runwaysdk.session.PermissionMap;
import com.runwaysdk.session.PermissionObserver;
import com.runwaysdk.util.IdParser;

public abstract class ActorDAO extends BusinessDAO implements ActorDAOIF, SpecializedDAOImplementationIF
{
  /**
   *
   */
  private static final long serialVersionUID = 8045487596677485250L;

  public ActorDAO()
  {
    super();
  }

  public ActorDAO(Map<String, Attribute> attributeMap, String type)
  {
    super(attributeMap, type);
  }

  public PermissionMap getOperations()
  {
    return new PermissionBuilder(this).build();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.business.rbac.ActorIF#permissions()
   */
  public Set<RelationshipDAOIF> getPermissions()
  {
    Set<RelationshipDAOIF> perm = new TreeSet<RelationshipDAOIF>();

    List<RelationshipDAOIF> list = this.getChildren(RelationshipTypes.TYPE_PERMISSION.getType());

    perm.addAll(list);

    return perm;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.business.rbac.ActorIF#permissions()
   */
  public Set<RelationshipDAOIF> getAllPermissions()
  {
    return this.getPermissions();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.runwaysdk.business.rbac.ActorIF#operationsOnObject(java.lang.String)
   */
  public Set<Operation> getAllPermissions(MetadataDAOIF metadata)
  {
    return this.getAssignedPermissions(metadata);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.runwaysdk.business.rbac.ActorDAOIF#getAssignedPermissions(com.runwaysdk
   * .dataaccess.MetaDataDAOIF)
   */
  public Set<Operation> getAssignedPermissions(MetadataDAOIF metadata)
  {
    try
    {
      Set<Operation> operations = new TreeSet<Operation>();

      List<RelationshipDAOIF> list = RelationshipDAO.get(this.getId(), metadata.getId(), RelationshipTypes.TYPE_PERMISSION.getType());

      if (list != null && list.size() > 0)
      {
        RelationshipDAOIF relationship = list.get(0);

        AttributeEnumerationIF attribute = (AttributeEnumerationIF) relationship.getAttributeIF(ActorDAO.OPERATION_ATTR);

        // Get a list of all the operations on the enumeration
        BusinessDAOIF[] ops = attribute.dereference();

        for (BusinessDAOIF op : ops)
        {
          // Add the proper operation
          operations.add(OperationManager.getOperation(op.getId()));
        }
      }

      return operations;
    }
    catch (DataAccessException e)
    {
      return new TreeSet<Operation>();
    }
  }

  /**
   * Grants permission to a role or user to execute a set of operations on an
   * object
   * 
   * @pre: get(mdTypeId)instanceof MdType
   * 
   * @param operations
   *          A list of the operations to grant permission on
   * @param metadataId
   *          The id of the metadata
   */
  @Transaction
  public void grantPermission(List<Operation> operations, String metadataId)
  {
    validateId(metadataId);

    RelationshipDAO permission = getPermissions(this.getId(), metadataId, RelationshipTypes.TYPE_PERMISSION.getType());

    for (Operation o : operations)
    {
      validateOperation(o, metadataId);

      permission.addItem(ActorDAO.OPERATION_ATTR, o.getId());
    }

    permission.apply();

    // Notify the PermissionManager that a change in permissions has occured
    PermissionObserver.notify(this);
  }

  /**
   * Grants permission to a role or user to execute a operation on a type.
   * 
   * @pre: get(mdTypeId) instance of MdType
   * 
   * @param operation
   *          The operation to
   * @param metadataId
   *          The id of the metadata
   */
  @Transaction
  public void grantPermission(Operation operation, String metadataId)
  {
    validateId(metadataId);

    validateOperation(operation, metadataId);

    RelationshipDAO permission = getPermissions(this.getId(), metadataId, RelationshipTypes.TYPE_PERMISSION.getType());

    permission.addItem(ActorDAO.OPERATION_ATTR, operation.getId());

    permission.apply();

    // Notify the PermissionManager that a change in permissions has occurred
    PermissionObserver.notify(this);
  }

  /**
   * Removes an operation permission from a user or role on a type. Does nothing
   * if the operation is not in the permission set.
   * 
   * @pre: get(mdTypeId) instance of MetaData
   * @pre: getRelationship(actorId, mdTypeId, ActorIF.TYPE_PERMISSION) != null
   * 
   * @param operation
   *          The operation to remove from the permisison set
   * @param metadataId
   *          The id of the metadata
   */
  @Transaction
  public void revokePermission(Operation operation, String metadataId)
  {
    // Ensure that a permission relationship between the actor and the mdType
    // exists
    List<RelationshipDAOIF> list;

    try
    {
      list = RelationshipDAO.get(super.getId(), metadataId, RelationshipTypes.TYPE_PERMISSION.getType());
    }
    catch (DataAccessException e)
    {
      list = null;
    }

    if (list != null && list.size() == 1)
    {
      RelationshipDAO permission = list.get(0).getRelationshipDAO();

      permission.removeItem(ActorDAOIF.OPERATION_ATTR, operation.getId());

      permission.apply();

      // IF there are no items in the permission relationship delete the
      // relationship
      AttributeEnumerationIF attribute = (AttributeEnumerationIF) permission.getAttributeIF(ActorDAOIF.OPERATION_ATTR);

      if (attribute.dereference().length == 0)
      {
        permission.delete();
      }

      // Notify the PermissionManager that a change in permissions has occured
      PermissionObserver.notify(this);
    }
  }

  /**
   * Removes an operation permission from a user or role on a type. Does nothing
   * if the operation is not in the permission set.
   * 
   * @pre: get(mdTypeId) instance of MetaData
   * @pre: getRelationship(actorId, mdTypeId, ActorIF.TYPE_PERMISSION) != null
   * 
   * @param operation
   *          The operation to remove from the permisison set
   * @param metadataId
   *          The id of the metadata
   */
  @Transaction
  public void revokePermission(Operation[] operations, String metadataId)
  {
    // Ensure that a permission relationship between the actor and the mdType
    // exists
    List<RelationshipDAOIF> list;

    try
    {
      list = RelationshipDAO.get(super.getId(), metadataId, RelationshipTypes.TYPE_PERMISSION.getType());
    }
    catch (DataAccessException e)
    {
      list = null;
    }

    if (list != null && list.size() == 1)
    {
      RelationshipDAO permission = list.get(0).getRelationshipDAO();

      // remove all operations in the list
      for (Operation operation : operations)
      {
        permission.removeItem(ActorDAOIF.OPERATION_ATTR, operation.getId());
      }

      permission.apply();

      // IF there are no items in the permission relationship delete the
      // relationship
      AttributeEnumerationIF attribute = (AttributeEnumerationIF) permission.getAttributeIF(ActorDAOIF.OPERATION_ATTR);

      if (attribute.dereference().length == 0)
      {
        permission.delete();
      }

      // Notify the PermissionManager that a change in permissions has occured
      PermissionObserver.notify(this);
    }
  }

  /**
   * Removes all the permission an actor has for a given MetaData
   * 
   * @pre: get(mdTypeId) instance of MetaData
   * 
   * @param metadataId
   *          The id of the MetaData
   */
  @Transaction
  public void revokeAllPermissions(String metadataId)
  {
    try
    {
      List<RelationshipDAOIF> list = RelationshipDAO.get(super.getId(), metadataId, RelationshipTypes.TYPE_PERMISSION.getType());

      if (list != null && list.size() > 0)
      {
        RelationshipDAO permission = list.get(0).getRelationshipDAO();
        permission.delete();
      }
    }
    catch (DataNotFoundException e)
    {
      // Do nothing if the relationship does not exist
    }

    // Notify the PermissionManager that a change in permissions has occured
    PermissionObserver.notify(this);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.dataaccess.BusinessDAO#getBusinessDAO()
   */
  public ActorDAO getBusinessDAO()
  {
    return (ActorDAO) super.getBusinessDAO();
  }

  /**
   * Validate the given mdTypeId, throws an exception if the id is not valid
   * 
   * @param metadataId
   *          The id to a MetaDataType
   */
  private void validateId(String metadataId)
  {
    MdClassDAOIF mdClassIF = MdClassDAO.getMdClassByRootId(IdParser.parseMdTypeRootIdFromId(metadataId));

    // Not allowed to set permissions on an MdState, set the permissions on the
    // MdRelationship that defines the MdState
    if (mdClassIF.definesType().equals(MdStateMachineInfo.CLASS))
    {
      MdStateMachineDAOIF machine = MdStateMachineDAO.get(metadataId);

      MdBusinessDAOIF stateMachineOwner = machine.getStateMachineOwner();

      String error = "State Machine [" + machine.definesType() + "] cannot have permissions. Add them to [" + stateMachineOwner.definesType() + "] instead.";
      throw new RBACExceptionInvalidStateMachine(error, machine, machine.getStateMachineOwner());
    }
  }

  /**
   * Validate that the operation is valid for a given id
   * 
   * @param operation
   *          The operation to validate
   * @param businessId
   *          the id to validate against
   */
  private void validateOperation(Operation operation, String businessId)
  {
    BusinessDAOIF businessDAO = BusinessDAO.get(businessId);

    OperationManager operationManager = OperationManager.getOperationManager();

    Set<Operation> validOperations = operationManager.getValidOperations(businessDAO);

    if (!validOperations.contains(operation))
    {
      MdClassDAOIF mdClassIF = MdClassDAO.getMdClassByRootId(IdParser.parseMdTypeRootIdFromId(businessId));

      String error = "Operation [" + operation + "] is not applicable for type [" + mdClassIF.definesType() + "]";
      throw new RBACExceptionInvalidOperation(error, operation, mdClassIF);
    }

    if (businessDAO instanceof MetadataDAOIF)
    {
      // Ensure that the actor is not already assigned the negation of the
      // operations
      Set<Operation> permissions = this.getAssignedPermissions((MetadataDAOIF) businessDAO);
      
     if(PermissionMap.negates(permissions, operation))
     {
       MdClassDAOIF mdClassIF = MdClassDAO.getMdClassByRootId(IdParser.parseMdTypeRootIdFromId(businessId));

       String error = "Operation [" + operation + "] is not applicable for type [" + mdClassIF.definesType() + "]";
       throw new RBACExceptionInvalidOperation(error, operation, mdClassIF);
     }
    }
  }

  /**
   * Gets the permission relationship between an actor and an object of a given
   * type If the permission does not exist then it creates an new relationship
   * 
   * @param parentId
   *          The id to the parent object
   * @param childId
   *          The id ot the child object
   * @param type
   *          The type of relationship
   * @return The relationship of the given type with the respective parent and
   *         child id
   */
  private RelationshipDAO getPermissions(String parentId, String childId, String type)
  {
    RelationshipDAO permission = null;

    // If the permission relationship does not already exist then create it
    try
    {
      permission = RelationshipDAO.get(parentId, childId, type).get(0).getRelationshipDAO();
    }
    catch (DataAccessException e)
    {
      permission = RelationshipDAO.newInstance(parentId, childId, type);
    }

    return permission;
  }

  /**
   * Creates a key: [Actor Type Name].[Actor Name].
   * 
   * @param actorTypeName
   * @param actorName
   * @return
   */
  public static String buildKey(String actorTypeName, String actorName)
  {
    return actorTypeName + "." + actorName;
  }

  public int hashCode()
  {
    return this.getId().hashCode();
  }
}