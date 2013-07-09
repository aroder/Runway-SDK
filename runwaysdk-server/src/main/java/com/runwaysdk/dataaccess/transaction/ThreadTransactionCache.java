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
package com.runwaysdk.dataaccess.transaction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import com.runwaysdk.business.rbac.ActorDAOIF;
import com.runwaysdk.business.rbac.RoleDAOIF;
import com.runwaysdk.business.state.StateMasterDAO;
import com.runwaysdk.business.state.StateMasterDAOIF;
import com.runwaysdk.dataaccess.EntityDAO;
import com.runwaysdk.dataaccess.EntityDAOIF;
import com.runwaysdk.dataaccess.EnumerationAttributeItem;
import com.runwaysdk.dataaccess.MdAttributeConcreteDAOIF;
import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.MdClassDAOIF;
import com.runwaysdk.dataaccess.MdEnumerationDAOIF;
import com.runwaysdk.dataaccess.MdFacadeDAOIF;
import com.runwaysdk.dataaccess.MdIndexDAOIF;
import com.runwaysdk.dataaccess.MdTypeDAOIF;
import com.runwaysdk.dataaccess.RelationshipDAO;
import com.runwaysdk.dataaccess.RelationshipDAOIF;
import com.runwaysdk.dataaccess.TransientDAO;
import com.runwaysdk.dataaccess.TransitionDAO;
import com.runwaysdk.dataaccess.TransitionDAOIF;
import com.runwaysdk.dataaccess.cache.CacheStrategy;
import com.runwaysdk.dataaccess.metadata.MdActionDAO;
import com.runwaysdk.dataaccess.metadata.MdAttributeConcreteDAO;
import com.runwaysdk.dataaccess.metadata.MdAttributeDAO;
import com.runwaysdk.dataaccess.metadata.MdMethodDAO;
import com.runwaysdk.dataaccess.metadata.MdParameterDAO;
import com.runwaysdk.dataaccess.metadata.MdRelationshipDAO;
import com.runwaysdk.dataaccess.metadata.MdTypeDAO;
import com.runwaysdk.session.PermissionEntity;

public class ThreadTransactionCache extends AbstractTransactionCache
{
  private TransactionCache transactionCache;
  
  /**
   * Key: {@link EntityDAO} id. Value: {@link EntityDAO}
   */
  protected Map<String, EntityDAO> transactionObjectCache;

  protected ThreadTransactionCache(ReentrantLock transactionStateLock, TransactionCache transactionCache)
  {
    super(transactionStateLock);
    this.transactionCache = transactionCache;
    this.transactionObjectCache = new HashMap<String, EntityDAO>();
  }

  /**
   * Returns the reference to the main transaction cache.
   *
   * @return
   */
  protected TransactionCache getTransactionCache()
  {
    return this.transactionCache;
  }

  @Override
  public void addDMLTableName(String tableName)
  {
    super.addDMLTableName(tableName);
  }

  @Override
  public void addRelationship(RelationshipDAO relationshipDAO)
  {
    super.addRelationship(relationshipDAO);
  }

  @Override
  public void deleteEntityDAO(EntityDAO entityDAO)
  {
    super.deleteEntityDAO(entityDAO);
  }

  @Override
  public void deleteEntityDAOCollection(String type, CacheStrategy entityDAOCollection)
  {
    super.deleteEntityDAOCollection(type, entityDAOCollection);
  }

  @Override
  public void deleteRelationship(RelationshipDAO relationshipDAO)
  {
    super.deleteRelationship(relationshipDAO);
  }

  @Override
  public void deletedEnumerationAttributeItem_CodeGen(EnumerationAttributeItem enumerationAttributeItem)
  {
    super.deletedEnumerationAttributeItem_CodeGen(enumerationAttributeItem);
  }

  @Override
  public void deletedMdAttribute_CodeGen(MdAttributeDAO mdAttribute)
  {
    super.deletedMdAttribute_CodeGen(mdAttribute);
  }

  @Override
  public void deletedMdRelationship_CodeGen(MdRelationshipDAO mdRelationship)
  {
    super.deletedMdRelationship_CodeGen(mdRelationship);
  }

  @Override
  public void deletedMdType(MdTypeDAOIF mdTypeIF)
  {
    super.deletedMdType(mdTypeIF);
  }
// Heads up: clean up
//
//  @Override
//  public boolean hasAddedChildren(String businessDAOid, String relationshipType)
//  {
//    return (super.hasAddedChildren(businessDAOid, relationshipType)
//    || this.getTransactionCache().hasAddedChildren(businessDAOid, relationshipType));
//  }
//
//  @Override
//  public boolean hasRemovedChildren(String businessDAOid, String relationshipType)
//  {
//    return (super.hasRemovedChildren(businessDAOid, relationshipType)
//        || this.getTransactionCache().hasRemovedChildren(businessDAOid, relationshipType));
//  }
//
//  @Override
//  public boolean hasAddedParents(String businessDAOid, String relationshipType)
//  {
//    return (super.hasAddedParents(businessDAOid, relationshipType)
//        || this.getTransactionCache().hasAddedParents(businessDAOid, relationshipType));
//  }
//  
//  @Override
//  public boolean hasRemovedParents(String businessDAOid, String relationshipType)
//  {
//    return (super.hasRemovedParents(businessDAOid, relationshipType)
//        || this.getTransactionCache().hasRemovedParents(businessDAOid, relationshipType));
//  }
  
  @Override
  public boolean hasAddedChildren(String businessDAOid, String relationshipType)
  {
    return super.hasAddedChildren(businessDAOid, relationshipType);
  }

  @Override
  public boolean hasRemovedChildren(String businessDAOid, String relationshipType)
  {
    return super.hasRemovedChildren(businessDAOid, relationshipType);
  }

  @Override
  public boolean hasAddedParents(String businessDAOid, String relationshipType)
  {
    return super.hasAddedParents(businessDAOid, relationshipType);
  }
  
  @Override
  public boolean hasRemovedParents(String businessDAOid, String relationshipType)
  {
    return super.hasRemovedParents(businessDAOid, relationshipType);
  }


  /**
   * Returns child relationships for the object with the given id in the transaction.
   * 
   * @param relationshipList relationships returned from the global source.
   * @param businessDAOid
   * @param relationshipType
   * 
   * @return relationships modified based on what occurred in this transaction.
   */
  public List<RelationshipDAOIF> getChildren(List<RelationshipDAOIF> relationshipList, String businessDAOid, String relationshipType)
  {
    return super.getChildren(this.getTransactionCache().getChildren(relationshipList, businessDAOid, relationshipType), businessDAOid, relationshipType);
  }
  /**
   * Returns parent relationships for the object with the given id in the transaction.
   * 
   * @param relationshipList relationships returned from the global source.
   * @param businessDAOid
   * @param relationshipType
   * 
   * @return relationships modified based on what occurred in this transaction.
   */
  public List<RelationshipDAOIF> getParents(List<RelationshipDAOIF> relationshipList, String businessDAOid, String relationshipType)
  {
    return super.getParents(this.getTransactionCache().getParents(relationshipList, businessDAOid, relationshipType), businessDAOid, relationshipType);
  }
  
  @Override
  public MdAttributeDAOIF getAddedMdAttribute(String mdAttributeKey)
  {
    MdAttributeDAOIF mdAttribute = super.getAddedMdAttribute(mdAttributeKey);
    if (mdAttribute == null)
    {
      mdAttribute = this.getTransactionCache().getAddedMdAttribute(mdAttributeKey);
    }
    return mdAttribute;
  }

  @Override
  public Map<String, MdAttributeDAO> getAddedMdAttributes()
  {
    Map<String, MdAttributeDAO> mdAttributeMap = new HashMap<String, MdAttributeDAO>();
    mdAttributeMap.putAll(super.getAddedMdAttributes());
    mdAttributeMap.putAll(this.getTransactionCache().getAddedMdAttributes());
    return mdAttributeMap;
  }

  @Override
  public Set<String> getChildMdRelationshipDAOids(String mdBusinessDAOid)
  {
    Set<String> childMdRelationshipDAOidSet = new HashSet<String>();
    childMdRelationshipDAOidSet.addAll(super.getChildMdRelationshipDAOids(mdBusinessDAOid));
    childMdRelationshipDAOidSet.addAll(this.getTransactionCache().getChildMdRelationshipDAOids(mdBusinessDAOid));
    return childMdRelationshipDAOidSet;
  }

  /**
   * @see com.runwaysdk.dataaccess.transaction.TransactionCacheIF#getEntityDAO(java.lang.String)
   */
  @Override
  public EntityDAOIF getEntityDAO(String id)
  {
    EntityDAOIF entityDAOIF = null;
    
    this.transactionStateLock.lock();
    try
    {
      TransactionItemAction transactionCacheItem = this.updatedEntityDAOIdMap.get(id);
      if (transactionCacheItem != null)
      {
        entityDAOIF = (EntityDAOIF)this.transactionObjectCache.get(id);
      }
      
      if (entityDAOIF == null)
      {
        entityDAOIF = this.getTransactionCache().getEntityDAO(id);
      }

      return entityDAOIF;
      
    }
    finally
    {
      this.transactionStateLock.unlock();
    }
  }
 
  /**
   * Stores an {@link EntityDAO} that was modified in this transaction in a transaction cache.
   * 
   * @param entityDAO
   */
  @Override
  protected void storeTransactionEntityDAO(EntityDAO entityDAO)
  {
    this.transactionStateLock.lock();
    try
    {
      this.transactionObjectCache.put(entityDAO.getId(), entityDAO);
    }
    finally
    {
      this.transactionStateLock.unlock();
    }
  }
  
  @Override
  public EntityDAO getEntityDAO(String type, String key)
  {
    EntityDAO entityDAO = super.getEntityDAO(type, key);

    if (entityDAO == null)
    {
      entityDAO = this.getTransactionCache().getEntityDAO(type, key);
    }

    return entityDAO;
  }

  @Override
  public MdAttributeConcreteDAOIF getMdAttributeWithIndex(String indexName)
  {
    MdAttributeConcreteDAOIF mdAttributeConcrete = super.getMdAttributeWithIndex(indexName);

    if (mdAttributeConcrete == null)
    {
      mdAttributeConcrete = this.getTransactionCache().getMdAttributeWithIndex(indexName);
    }

    return mdAttributeConcrete;
  }

  @Override
  public MdClassDAOIF getMdClass(String type)
  {
    MdClassDAOIF mdClass = super.getMdClass(type);

    if (mdClass == null)
    {
      mdClass = this.getTransactionCache().getMdClass(type);
    }

    return mdClass;
  }

  @Override
  public MdClassDAOIF getMdClassDAOByRootId(String mdClassRootId)
  {
    MdClassDAOIF mdClass = super.getMdClassDAOByRootId(mdClassRootId);

    if (mdClass == null)
    {
      mdClass = this.getTransactionCache().getMdClassDAOByRootId(mdClassRootId);
    }

    return mdClass;
  }

  @Override
  public MdEnumerationDAOIF getMdEnumerationDAO(String enumerationType)
  {
    MdEnumerationDAOIF mdEnumerationDAO = super.getMdEnumerationDAO(enumerationType);

    if (mdEnumerationDAO == null)
    {
      mdEnumerationDAO = this.getTransactionCache().getMdEnumerationDAO(enumerationType);
    }

    return mdEnumerationDAO;
  }

  @Override
  public MdFacadeDAOIF getMdFacade(String type)
  {
    MdFacadeDAOIF mdFacadeDAO = super.getMdFacade(type);

    if (mdFacadeDAO == null)
    {
      mdFacadeDAO = this.getTransactionCache().getMdFacade(type);
    }

    return mdFacadeDAO;
  }

  @Override
  public Set<MdFacadeDAOIF> getMdFacadesForServicesDeploy()
  {
    Set<MdFacadeDAOIF> mdFacadeSet = new HashSet<MdFacadeDAOIF>();

    mdFacadeSet.addAll(super.getMdFacadesForServicesDeploy());
    mdFacadeSet.addAll(this.getTransactionCache().getMdFacadesForServicesDeploy());

    return mdFacadeSet;
  }

  @Override
  public Set<MdFacadeDAOIF> getMdFacadesForServicesUndeploy()
  {
    Set<MdFacadeDAOIF> mdFacadeSet = new HashSet<MdFacadeDAOIF>();

    mdFacadeSet.addAll(super.getMdFacadesForServicesUndeploy());
    mdFacadeSet.addAll(this.getTransactionCache().getMdFacadesForServicesUndeploy());

    return mdFacadeSet;
  }

  @Override
  public MdIndexDAOIF getMdIndexDAO(String indexName)
  {
    MdIndexDAOIF mdIndexDAOIF = super.getMdIndexDAO(indexName);

    if (mdIndexDAOIF == null)
    {
      mdIndexDAOIF = this.getTransactionCache().getMdIndexDAO(indexName);
    }

    return mdIndexDAOIF;
  }

  @Override
  public Set<String> getParentMdRelationshipDAOids(String mdBusinessDAOid)
  {
    Set<String> parentMdRelationshipDAOidsSet = new HashSet<String>();

    parentMdRelationshipDAOidsSet.addAll(super.getParentMdRelationshipDAOids(mdBusinessDAOid));
    parentMdRelationshipDAOidsSet.addAll(this.getTransactionCache().getParentMdRelationshipDAOids(mdBusinessDAOid));

    return parentMdRelationshipDAOidsSet;
  }

  @Override
  public RoleDAOIF getRoleIF(String roleName)
  {
    RoleDAOIF roleDAO = super.getRoleIF(roleName);

    if (roleDAO == null)
    {
      roleDAO = this.getTransactionCache().getRoleIF(roleName);
    }

    return roleDAO;
  }

  @Override
  public List<StateMasterDAOIF> getUpdatedStateMasters(String type)
  {
    Set<StateMasterDAOIF> stateMasterSet = new HashSet<StateMasterDAOIF>();
    stateMasterSet.addAll(super.getUpdatedStateMasters(type));
    stateMasterSet.addAll(this.getTransactionCache().getUpdatedStateMasters(type));

    List<StateMasterDAOIF> stateMasterList = new LinkedList<StateMasterDAOIF>();

    stateMasterList.addAll(stateMasterSet);

    return stateMasterList;
  }

  @Override
  public Set<TransitionDAOIF> getUpdatedTransitions(String type)
  {
    Set<TransitionDAOIF> updatedTransitionSet = new HashSet<TransitionDAOIF>();

    updatedTransitionSet.addAll(super.getUpdatedTransitions(type));
    updatedTransitionSet.addAll(this.getTransactionCache().getUpdatedTransitions(type));

    return updatedTransitionSet;
  }

  @Override
  public boolean hasExecutedEntityDeleteMethod(String id, String signature)
  {
    return (super.hasExecutedEntityDeleteMethod(id,signature) ||
            this.getTransactionCache().hasExecutedEntityDeleteMethod(id,signature));
  }

  @Override
  public void modifiedMdAttribute_CodeGen(MdAttributeDAO mdAttribute)
  {
    super.modifiedMdAttribute_CodeGen(mdAttribute);
  }

  @Override
  public void newEnumerationAttributeItem_CodeGen(EnumerationAttributeItem enumerationAttributeItem)
  {
    super.newEnumerationAttributeItem_CodeGen(enumerationAttributeItem);
  }

  @Override
  public void newMdAttribute(MdAttributeDAO mdAttribute)
  {
    super.newMdAttribute(mdAttribute);
  }

  @Override
  public void newMdRelationship_CodeGen(MdRelationshipDAO mdRelationship)
  {
    super.newMdRelationship_CodeGen(mdRelationship);
  }

  @Override
  public void notifyActors(ActorDAOIF actorIF)
  {
    super.notifyActors(actorIF);
  }

  @Override
  public void performDDLTable(String tableName)
  {
    super.performDDLTable(tableName);
    this.getTransactionCache().performDDLTable(tableName);
  }

  @Override
  public void setExecutedEntityDeleteMethod(String id, String signature)
  {
    super.setExecutedEntityDeleteMethod(id, signature);
  }

  @Override
  public void setMdAttributeWithIndex(MdAttributeConcreteDAO mdAttributeConcreteDAO)
  {
    super.setMdAttributeWithIndex(mdAttributeConcreteDAO);
  }

  @Override
  public void unregisterPermissionEntity(PermissionEntity permissionEntity)
  {
    super.unregisterPermissionEntity(permissionEntity);
  }

  @Override
  public void updateEntityDAO(EntityDAO entityDAO)
  {
    super.updateEntityDAO(entityDAO);
  }

  @Override
  public void updateEntityDAOCollection(String type, CacheStrategy entityDAOCollectoin)
  {
    super.updateEntityDAOCollection(type, entityDAOCollectoin);
  }

  @Override
  public void updateTransientDAO(TransientDAO transientDAO)
  {
    super.updateTransientDAO(transientDAO);
  }

  @Override
  public void updatedMdAction_CodeGen(MdActionDAO mdAction)
  {
    super.updatedMdAction_CodeGen(mdAction);
  }

  @Override
  public void updatedMdMethod_CodeGen(MdMethodDAO mdMethod)
  {
    super.updatedMdMethod_CodeGen(mdMethod);
  }

  @Override
  public void updatedMdMethod_WebServiceDeploy(MdMethodDAO mdMethod)
  {
    super.updatedMdMethod_WebServiceDeploy(mdMethod);
  }

  @Override
  public void updatedMdParameter_CodeGen(MdParameterDAO mdParameter)
  {
    super.updatedMdParameter_CodeGen(mdParameter);
  }

  @Override
  public void updatedMdParameter_WebServiceDeploy(MdParameterDAO mdParameter)
  {
    super.updatedMdParameter_WebServiceDeploy(mdParameter);
  }

  @Override
  public void updatedMdType(MdTypeDAO mdType)
  {
    super.updatedMdType(mdType);
  }

  @Override
  public void updatedStateMaster(StateMasterDAO stateMasterDAO)
  {
    super.updatedStateMaster(stateMasterDAO);
  }

  @Override
  public void updatedTransition(TransitionDAO transitionDAO)
  {
    super.updatedTransition(transitionDAO);
  }
  
  @Override
  public void close()
  {
  }

}