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
package com.runwaysdk.dataaccess.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.runwaysdk.dataaccess.BusinessDAOIF;
import com.runwaysdk.dataaccess.EntityDAO;
import com.runwaysdk.dataaccess.EntityDAOIF;
import com.runwaysdk.dataaccess.RelationshipDAO;
import com.runwaysdk.dataaccess.RelationshipDAOIF;
import com.runwaysdk.dataaccess.cache.globalcache.ehcache.CachedBusinessDAOinfo;
import com.runwaysdk.dataaccess.cache.globalcache.ehcache.CachedEntityDAOinfo;

public class Memorystore implements ObjectStore
{
  /**
   * Key:{@link EntityDAOIF} id Value: {@link CachedEntityDAOinfo}
   */
  Map<String, CachedEntityDAOinfo> entityMap;

  public Memorystore()
  {
    this.entityMap = Collections.synchronizedMap(new HashMap<String, CachedEntityDAOinfo>());
  }

  /**
   * Initializes the global cache.
   */
  public void removeAll()
  {
    this.entityMap.clear();
  }
  
  /**
   * Returns the number of items stored in the cache.
   */
  public int cacheSize()
  {
    return this.entityMap.size();
  }

  /**
   * Shuts down the cache and flushes memory contents to a persistent store.
   */
  public void shutdown()
  {
  }

  /**
   * Returns true if the cache is initialized, false otherwise.
   */
  public boolean isCacheInitialized()
  {
    return true;
  }

  /**
   * Initializes the cache.
   */
  public void initializeCache()
  {
    this.removeAll();
  }

  /**
   * Returns the name of the cache.
   * 
   * @return name of the cache.
   */
  public String getCacheName()
  {
    return "MAIN_MEMORY_CACHE";
  }

  /**
   * Returns a list of parent relationships of the given type from the cache for
   * a {@link BusinessDAOIF} with the given id.
   * 
   * @param id
   * @param relationshipType
   * @return
   */
  public List<RelationshipDAOIF> getParentRelationshipsFromCache(String id, String relationshipType)
  {
    synchronized (id)
    {
      CachedEntityDAOinfo cachedEntityDAOinfo = this.entityMap.get(id);

      if (cachedEntityDAOinfo == null)
      {
        return new LinkedList<RelationshipDAOIF>();
      }
      else
      {
        CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) cachedEntityDAOinfo;
        return cachedBusinessDAOinfo.getParentRelationshipDAOlist(relationshipType);
      }
    }
  }

  /**
   * Returns a list of child relationships of the given type from the cache for
   * a {@link BusinessDAOIF} with the given id.
   * 
   * @param id
   * @param relationshipType
   * 
   * @return
   */
  public List<RelationshipDAOIF> getChildRelationshipsFromCache(String id, String relationshipType)
  {
    synchronized (id)
    {
      CachedEntityDAOinfo cachedEntityDAOinfo = this.entityMap.get(id);

      if (cachedEntityDAOinfo == null)
      {
        return new LinkedList<RelationshipDAOIF>();
      }
      else
      {
        CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) cachedEntityDAOinfo;
        return cachedBusinessDAOinfo.getChildRelationshipDAOlist(relationshipType);
      }
    }
  }

  /**
   * Adds the {@link RelationshipDAOIF} to the parent and child relationships of
   * the parent and child objects in the cache.
   * 
   * @param relationshipDAOIF
   */
  public void addRelationshipDAOIFtoCache(RelationshipDAOIF relationshipDAOIF)
  {
    synchronized (relationshipDAOIF.getParentId())
    {
      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(relationshipDAOIF.getParentId());
      if (cachedBusinessDAOinfo == null)
      {
        cachedBusinessDAOinfo = new CachedBusinessDAOinfo();
        this.entityMap.put(relationshipDAOIF.getParentId(), cachedBusinessDAOinfo);
      }
      cachedBusinessDAOinfo.addChildRelationship(relationshipDAOIF);
    }

    synchronized (relationshipDAOIF.getChildId())
    {
      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(relationshipDAOIF.getChildId());
      if (cachedBusinessDAOinfo == null)
      {
        cachedBusinessDAOinfo = new CachedBusinessDAOinfo();
        this.entityMap.put(relationshipDAOIF.getChildId(), cachedBusinessDAOinfo);
      }
      cachedBusinessDAOinfo.addParentRelationship(relationshipDAOIF);
    }
  }
  
  /**
   * Updates the stored id if it has changed for the {@link RelationshipDAOIF} to the 
   * parent and child relationships of the parent and child objects in the cache.
   * 
   * @param relationshipDAOIF
   */
  public void updateRelationshipDAOIFinCache(RelationshipDAOIF relationshipDAOIF)
  {
    RelationshipDAO relationshipDAO = (RelationshipDAO)relationshipDAOIF;
    
    synchronized (relationshipDAO.getParentId())
    {
      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(relationshipDAO.getParentId());

      if (cachedBusinessDAOinfo == null)
      {
        cachedBusinessDAOinfo = new CachedBusinessDAOinfo();
        this.entityMap.put(relationshipDAO.getParentId(), cachedBusinessDAOinfo);
      }

      if (relationshipDAO.hasIdChanged())
      {
        cachedBusinessDAOinfo.updateChildRelationship(relationshipDAO);
      }
      else
      {
        cachedBusinessDAOinfo.addChildRelationship(relationshipDAO);        
      }
    }

    synchronized (relationshipDAOIF.getChildId())
    {
      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(relationshipDAO.getChildId()); 

      if (cachedBusinessDAOinfo == null)
      {
        cachedBusinessDAOinfo = new CachedBusinessDAOinfo();
        this.entityMap.put(relationshipDAOIF.getChildId(), cachedBusinessDAOinfo);
      }
      
      if (relationshipDAO.hasIdChanged())
      {
        cachedBusinessDAOinfo.updateParentRelationship(relationshipDAO);
      }
      else
      {
        cachedBusinessDAOinfo.addParentRelationship(relationshipDAO);        
      }
    }
  }
//  Heads up: test
//  /**
//   * Updates the parent id if it has changed for the {@link RelationshipDAOIF} to the 
//   * parent relationships of the parent objects in the cache.
//   * 
//   * <br/><b>Precondition:</b> Calling method has checked if the parent id has changed<br/>
//   * 
//   * @param relationshipDAOIF
//   */
//  public void updateParentIdRelationshipDAOIFinCache(RelationshipDAOIF relationshipDAOIF)
//  {
//    RelationshipDAO relationshipDAO = (RelationshipDAO)relationshipDAOIF;
//    synchronized (relationshipDAO.getOldParentId())
//    {
//      String newParentId = relationshipDAOIF.getParentId();
//      String oldParentId = relationshipDAO.getOldParentId();
//      
//      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(oldParentId);
//      if (cachedBusinessDAOinfo == null)
//      {
//        cachedBusinessDAOinfo = new CachedBusinessDAOinfo();
//      }
//      this.entityMap.remove(oldParentId);
//      this.entityMap.put(newParentId, cachedBusinessDAOinfo);
//    }
//  }
//
//  /**
//   * Updates the child id if it has changed for the {@link RelationshipDAOIF} to the 
//   * child relationships of the child objects in the cache.
//   * 
//   * <br/><b>Precondition:</b> Calling method has checked if the child id has changed<br/>
//   * 
//   * @param relationshipDAOIF
//   */
//  public void updatChildIdRelationshipDAOIFinCache(RelationshipDAOIF relationshipDAOIF)
//  {
//    RelationshipDAO relationshipDAO = (RelationshipDAO)relationshipDAOIF;
//    synchronized (relationshipDAO.getOldChildId())
//    {
//      String newChildId = relationshipDAOIF.getChildId();
//      String oldChildId = relationshipDAO.getOldChildId();
//      
//      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(oldChildId);
//      if (cachedBusinessDAOinfo == null)
//      {
//        cachedBusinessDAOinfo = new CachedBusinessDAOinfo();
//      }
//      this.entityMap.remove(oldChildId);
//      this.entityMap.put(newChildId, cachedBusinessDAOinfo);
//    }
//  }
  
  /**
   * Updates the changed id for the given {@link EntityDAOIF} in the cache.
   * 
   * <br/><b>Precondition:</b> Calling method has checked whether the id has changed.
   * 
   * @param oldEntityId
   * @param entityDAOIF
   */
  public void updateIdEntityDAOIFinCache(String oldEntityId, EntityDAOIF entityDAOIF)
  {
    synchronized (oldEntityId)
    {      
      CachedEntityDAOinfo cachedEntityDAOinfo = (CachedEntityDAOinfo) this.entityMap.get(oldEntityId);
      if (cachedEntityDAOinfo != null)
      {       
        cachedEntityDAOinfo.addEntityDAOIF(entityDAOIF);
        this.entityMap.remove(oldEntityId);
        this.entityMap.put(entityDAOIF.getId(), cachedEntityDAOinfo);
      }

    }
  }
  
  /**
   * Removes the {@link RelationshipDAOIF} from the parent relationship of the
   * child object in the cache.
   * 
   * @param relationshipDAO
   * @param deletedObject
   *          indicates the object is being deleted from the application.
   * 
   * @return True if the child object still has parent relationships of this
   *         type.
   */
  public boolean removeParentRelationshipDAOIFtoCache(RelationshipDAO relationshipDAO, boolean deletedObject)
  {
    synchronized (relationshipDAO.getChildId())
    {
      boolean stillHasParents = false;

      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(relationshipDAO.getChildId());
      if (cachedBusinessDAOinfo != null)
      {
        stillHasParents = cachedBusinessDAOinfo.removeParentRelationship(relationshipDAO);

        if (cachedBusinessDAOinfo.removeFromGlobalCache())
        {
          this.entityMap.remove(relationshipDAO.getChildId());
        }
      }
      
//      if (relationshipDAO.hasChildIdChanged())
//      {
//        cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(relationshipDAO.getOldChildId());
//        if (cachedBusinessDAOinfo != null)
//        {
//          this.entityMap.remove(relationshipDAO.getOldChildId());
//        }
//      }

      return stillHasParents;
    }
  }

  /**
   * Removes all parent relationships of the given type for the
   * {@link BusinessDAOIF} with the given id.
   * 
   * @param childId
   * @param relationshipType
   * @param deletedObject
   *          indicates the object is being deleted from the application.
   */
  public void removeAllParentRelationshipsOfType(String childId, String relationshipType, boolean deletedObject)
  {
    synchronized (childId)
    {
      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(childId);
      if (cachedBusinessDAOinfo != null)
      {
        cachedBusinessDAOinfo.removeAllParentRelationshipsOfType(relationshipType);

        if (cachedBusinessDAOinfo.removeFromGlobalCache())
        {
          this.entityMap.remove(childId);
        }
      }
    }
  }

  /**
   * Removes the {@link RelationshipDAOIF} from the child relationship of the
   * parent object in the cache.
   * 
   * @param relationshipDAO
   * @param deletedObject
   *          indicates the object is being deleted from the application.
   * 
   * @return True if the parent object still has children relationships of this
   *         type.
   */
  public boolean removeChildRelationshipDAOIFtoCache(RelationshipDAOIF relationshipDAO, boolean deletedObject)
  {
    synchronized (relationshipDAO.getParentId())
    {
      boolean stillHasChildren = false;

      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(relationshipDAO.getParentId());
      if (cachedBusinessDAOinfo != null)
      {
        stillHasChildren = cachedBusinessDAOinfo.removeChildRelationship(relationshipDAO);

        if (cachedBusinessDAOinfo.removeFromGlobalCache())
        {
          this.entityMap.remove(relationshipDAO.getParentId());
        }
      }

      return stillHasChildren;
    }
  }

  /**
   * Removes all child relationships of the given type for the
   * {@link BusinessDAOIF} with the given id.
   * 
   * @param parentId
   * @param relationshipType
   * @param deletedObject
   *          indicates the object is being deleted from the application.
   */
  public void removeAllChildRelationshipsOfType(String parentId, String relationshipType, boolean deletedObject)
  {
    synchronized (parentId)
    {
      CachedBusinessDAOinfo cachedBusinessDAOinfo = (CachedBusinessDAOinfo) this.entityMap.get(parentId);
      if (cachedBusinessDAOinfo != null)
      {
        cachedBusinessDAOinfo.removeAllChildRelationshipsOfType(relationshipType);

        if (cachedBusinessDAOinfo.removeFromGlobalCache())
        {
          this.entityMap.remove(parentId);
        }
      }
    }
  }

  /**
   * Returns the {@link EntityDAOIF} from the cache with the given id or null if
   * the object with the given id is not in the cache.
   * 
   * @param id
   * @return {@link EntityDAOIF} from the cache with the given id or null if the
   *         object with the given id is not in the cache.
   */
  public EntityDAOIF getEntityDAOIFfromCache(String id)
  {
    synchronized (id)
    {
      CachedEntityDAOinfo cachedEntityDAOinfo = this.entityMap.get(id);

      if (cachedEntityDAOinfo == null)
      {
        return null;
      }
      else
      {
        return cachedEntityDAOinfo.getEntityDAOIF();
      }
    }
  }

  /**
   * Puts the given {@link EntityDAOIF} into the global cache.
   * 
   * @param entityDAOIF
   *          {@link EntityDAOIF} that goes into the the global cache.
   */
  public void putEntityDAOIFintoCache(EntityDAOIF entityDAOIF)
  {
    synchronized (entityDAOIF.getId())
    {
      CachedEntityDAOinfo cachedEntityDAOinfo = this.entityMap.get(entityDAOIF.getId());

      if (cachedEntityDAOinfo == null)
      {
        // Cast is OK because we are not modifying the state of the object.
        cachedEntityDAOinfo = ( (EntityDAO) entityDAOIF ).createGlobalCacheWrapper();
        this.entityMap.put(entityDAOIF.getId(), cachedEntityDAOinfo);
      }
      cachedEntityDAOinfo.addEntityDAOIF(entityDAOIF);
    }
  }

  /**
   * Removes the item from the cache with the given key
   * 
   * @param entityDAOIFid
   *          key of the item to be removed from the cache.
   * @param deletedObject
   *          indicates the object is being deleted from the application.
   */
  public void removeEntityDAOIFfromCache(String id, boolean deletedObject)
  {
    synchronized (id)
    {
      CachedEntityDAOinfo cachedEntityDAOinfo = this.entityMap.get(id);

      if (cachedEntityDAOinfo != null)
      {
        cachedEntityDAOinfo.removeEntityDAOIF();
        if (cachedEntityDAOinfo.removeFromGlobalCache())
        {
          this.entityMap.remove(id);
        }
      }
      // else do nothing
    }
  }

  /**
   * Returns a {@link Set} of the keys that are in the cache. The keys may or
   * may not represent {@link EntityDAOIF} ids.
   * 
   * @return {@link Set} of the keys that are in the cache.
   */
  public Set<String> getCacheKeys()
  {
    return this.entityMap.keySet();
  }

  /**
   * Persists the collections to the cache so that it can be persisted to the
   * disk store.
   * 
   * @param collectionMap
   */
  public void backupCollectionClasses(Map<String, CacheStrategy> collectionMap)
  {
  }

  /**
   * Returns the collections from the cache.
   * 
   */
  public Map<String, CacheStrategy> restoreCollectionClasses()
  {
    return null;
  }

  /**
   * Removes the set of collection classes from the cache.
   * 
   */
  public void removeCollectionClasses()
  {
  }

  /**
   * Starts transaction for the current thread.
   */
  public void beginTransaction()
  {
  }

  /**
   * Commits transaction for the current thread.
   */
  public void commitTransaction()
  {
  }

  /**
   * Rollback transaction for the current thread.
   */
  public void rollbackTransaction()
  {
  }

  public void flush()
  {
  }
}
