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
/*
 * Created on Jul 19, 2005
 * 
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package com.runwaysdk.dataaccess.transaction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.runwaysdk.business.LockException;
import com.runwaysdk.constants.ServerProperties;
import com.runwaysdk.dataaccess.EntityDAO;
import com.runwaysdk.session.RequestState;

/**
 * @author nathan
 * 
 */
public class LockObject
{
  private static LockObject   lockObject;

  private Map<String, Thread> transactionIDsMap;

  // Key: type+"."+key
  private Map<String, Thread> transactionTypeKeyMap;

  private Map<String, Thread> lockedIDsMap;

  private Thread              lockCache;

  private LockObject()
  {
    this.transactionIDsMap = new HashMap<String, Thread>(ServerProperties.getTransationIdBucketSize());
    this.transactionTypeKeyMap = new HashMap<String, Thread>(ServerProperties.getTransationIdBucketSize());

    this.lockedIDsMap = new HashMap<String, Thread>(ServerProperties.getLockedIdBucketSize());

    this.lockCache = null;
  }

  public synchronized static LockObject getLockObject()
  {
    if (lockObject == null)
    {
      lockObject = new LockObject();
      return lockObject;
    }
    else
    {
      return lockObject;
    }
  }

  /**
   * Tries to attain an application lock on an object with the given id. Goes to
   * sleep if the object is already locked.
   * 
   * @param id
   *          of an object.
   */
  public void appLock(String id)
  {
    while (true)
    {
      boolean breakLoop = tryAppLock(id);

      if (breakLoop == true)
      {
        break;
      }
    } // while (true)
  }

  private synchronized boolean tryAppLock(String id)
  {
    if (!this.lockedIDsMap.containsKey(id))
    {
      if (this.lockCache == null || ( ( this.lockCache != null ) && ( isLockedByThread(this.lockCache) ) ))
      {
        this.recordAppLock(id);
        return true;
      }
    }

    // block if the id is in the lockedIDsMap
    if (!isLockedByThread(this.lockedIDsMap.get(id)))
    {
      try
      {
        this.wait();
      }
      catch (Exception ex)
      {
        String error = "An error occured during the cache database synchronization routine for id [" + id + "]";
        throw new LockException(error);
      }
    }
    else
    {
      return true;
    }

    return false;
  }

  // Heads up: test
  // private synchronized boolean tryAppLock(String id)
  // {
  // if (!this.lockedIDsMap.containsKey(id) )
  // {
  // this.recordAppLock(id);
  // }
  // // block if the id is in the lockedIDsMap
  // if ( !isLockedByThread(this.lockedIDsMap.get(id)) )
  // {
  // try
  // {
  // this.wait();
  // }
  // catch (Exception ex)
  // {
  // String error =
  // "An error occured during the cache database synchronization routine for id ["
  // + id + "]";
  // throw new LockException(error);
  // }
  // }
  // else
  // {
  // return true;
  // }
  //
  // return false;
  // }

  // Hook method for an aspect
  private void recordAppLock(String id)
  {
    this.lockedIDsMap.put(id, getCurrentThread());
  }

  /**
   * Releases an application lock on the object with the given id, but only if
   * the current thread is the thread that holds the lock.
   * 
   * @param id
   *          id of an object.
   */
  public synchronized void releaseAppLock(String id)
  {
    if (this.lockedIDsMap.containsKey(id) && isLockedByThread(this.lockedIDsMap.get(id)))
    {
      this.lockedIDsMap.remove(id);
    }
    this.notifyAll();
  }

  /**
   * Releases application locks on all objects in the given set, but only if the
   * current thread owns the lock on the object.
   * 
   * @param unSetJavaLocksSet
   *          set of object ids.
   */
  public synchronized void releaseAppLocks(Set<String> unSetJavaLocksSet)
  {
    Iterator<String> setIterator = unSetJavaLocksSet.iterator();

    while (setIterator.hasNext())
    {
      String id = (String) setIterator.next();

      if (this.lockedIDsMap.containsKey(id) && isLockedByThread(this.lockedIDsMap.get(id)))
      {
        this.lockedIDsMap.remove(id);
      }
    }

    this.notifyAll();
  }

  /**
   * Returns a reference to the thread that has a lock on the object with the
   * given id.
   * 
   * @param id
   *          id of an object.
   * @return reference to the thread that has a lock on the object with the
   *         given id.
   */
  public synchronized Thread getThreadForAppLock(String id)
  {
    return this.lockedIDsMap.get(id);
  }

  /**
   * Adds transaction locks on the objects with the ids that are the keys for
   * the items in the given map. Lock is added if it is not already locked by a
   * different thread.
   * 
   * @param entityDAOidMap
   *          the keys are ids of objects to attain a transaction lock.
   */
  public synchronized void addTransactionLocks(Map<String, TransactionItemEntityDAOAction> entityDAOidMap)
  {
    for (String id : entityDAOidMap.keySet())
    {
      if (this.transactionIDsMap.get(id) != null && !isLockedByThread(this.transactionIDsMap.get(id)))
      {
        this.transactionIDsMap.put(id, getCurrentThread());
      }

      TransactionItemAction transactionItemAction = entityDAOidMap.get(id);

      if (transactionItemAction instanceof TransactionItemEntityDAOAction)
      {
        TransactionItemEntityDAOAction transactionItemEntityDAOAction = (TransactionItemEntityDAOAction) transactionItemAction;

        EntityDAO entityDAO = (EntityDAO) transactionItemEntityDAOAction.getEntityDAO();

        if (entityDAO != null)
        {
          String keyString = entityDAO.getType() + "." + entityDAO.getKey();

          if (this.transactionTypeKeyMap.get(keyString) != null && !isLockedByThread(this.transactionTypeKeyMap.get(keyString)))
          {
            this.transactionTypeKeyMap.put(keyString, getCurrentThread());
          }
        }
      }
    }
  }

  /**
   * Releases transaction locks on the objects with the ids that are the keys
   * for the items in the given map. Lock is released if it is not already
   * locked by a different thread.
   * 
   * @param entityDAOidMap
   *          the keys are ids of objects to release a transaction lock.
   */
  public synchronized void releaseTransactionLocks(Map<String, TransactionItemEntityDAOAction> entityDAOidMap)
  {
    for (String id : entityDAOidMap.keySet())
    {
      if (this.transactionIDsMap.containsKey(id) && isLockedByThread(this.transactionIDsMap.get(id)))
      {
        this.transactionIDsMap.remove(id);
      }

      TransactionItemAction transactionItemAction = entityDAOidMap.get(id);

      if (transactionItemAction instanceof TransactionItemEntityDAOAction)
      {
        TransactionItemEntityDAOAction transactionItemEntityDAOAction = (TransactionItemEntityDAOAction) transactionItemAction;

        EntityDAO entityDAO = (EntityDAO) transactionItemEntityDAOAction.getEntityDAO();
        String keyString = entityDAO.getType() + "." + entityDAO.getKey();

        if (this.transactionTypeKeyMap.containsKey(keyString) && isLockedByThread(this.transactionTypeKeyMap.get(keyString)))
        {
          this.transactionTypeKeyMap.remove(keyString);
        }
      }

    }
    this.notifyAll();
  }

  /**
   * Puts the current thread to sleep if a transaction lock exists on the object
   * with the given id.
   * 
   * @param id
   *          id of an object that my have a transaction lock.
   */
  public void checkTransactionLock(String id)
  {
    while (true)
    {
      boolean breakLoop = tryCheckTransLock(id);

      if (breakLoop == true)
      {
        break;
      }
    } // while (true)
  }

  private synchronized boolean tryCheckTransLock(String id)
  {
    // Put the thread to sleep if there is a transaction lock on the object id
    // or the entire cache is locked
    if ( ( this.transactionIDsMap.containsKey(id) && ( !isLockedByThread(this.transactionIDsMap.get(id)) ) ) || ( ( this.lockCache != null ) && ( !isLockedByThread(this.lockCache) ) ))
    {
      try
      {
        // System.out.println("Dang it!  I have to wait on a write lock for "+id);
        this.wait();
      }
      catch (Exception ex)
      {
        String error = "An error occured during the cache database synchronization routine for id [" + id + "]";
        throw new LockException(error);
      }
    }
    else
    {
      return true;
    }

    return false;
  }

  /**
   * Puts the current thread to sleep if a transaction lock exists on the object
   * with the given id.
   * 
   * @param id
   *          id of an object that my have a transaction lock.
   */
  public void checkTransactionLock(String type, String key)
  {
    while (true)
    {
      boolean breakLoop = tryCheckTransLock(type, key);

      if (breakLoop == true)
      {
        break;
      }
    } // while (true)
  }

  private synchronized boolean tryCheckTransLock(String type, String key)
  {
    String keyString = type + "." + key;

    // Put the thread to sleep if there is a transaction lock on the object key
    // or the entire cache is locked
    if ( ( this.transactionTypeKeyMap.containsKey(keyString) && ( !isLockedByThread(this.transactionTypeKeyMap.get(keyString)) ) ) || ( ( this.lockCache != null ) && ( !isLockedByThread(this.lockCache) ) ))
    {
      try
      {
        // System.out.println("Dang it!  I have to wait on a write lock for "+id);
        this.wait();
      }
      catch (Exception ex)
      {
        String error = "An error occured during the cache database synchronization routine for type [" + type + "] with key[" + key + "]";
        throw new LockException(error);
      }
    }
    else
    {
      return true;
    }

    return false;
  }

  // //////////////////////////////////////////////////////////////////////////////////////

  /**
   *
   */
  public synchronized void lockCache()
  {
    while (true)
    {
      boolean breakLoop = tryCacheLock();

      if (breakLoop == true)
      {
        break;
      }
    } // while (true)
  }

  /**
   * 
   * @param type
   * @return
   */
  private synchronized boolean tryCacheLock()
  {
    if (this.lockCache == null)
    {
      this.lockCache = getCurrentThread();
    }

    if ( ( this.lockCache != null ) && ( !isLockedByThread(this.lockCache) ))
    {
      try
      {
        this.wait();
      }
      catch (Exception ex)
      {
        String error = "An error occured while trying to lock the system cache.";
        throw new LockException(error);
      }

      return false;
    }
    else
    {
      return true;
    }
  }

  /**
   *
   *
   */
  public synchronized void unlockCache()
  {
    // this.lockCache = null;
    if ( ( this.lockCache != null ) && ( isLockedByThread(this.lockCache) ))
    {
      this.lockCache = null;
      this.notifyAll();
    }
  }

  /**
   * 
   * @param type
   */
  public void checkTransactionTypeLock(String type)
  {
    while (true)
    {
      boolean breakLoop = tryProceedType(type);

      if (breakLoop == true)
      {
        break;
      }
    } // while (true)
  }

  /**
   * 
   * @param type
   * @return
   */
  private synchronized boolean tryProceedType(String type)
  {
    if ( ( this.lockCache != null ) && ( !isLockedByThread(this.lockCache) ))
    {
      try
      {
        this.wait();
      }
      catch (Exception ex)
      {
        String error = "An error occured during the cache database synchronization routine for type [" + type + "]";
        throw new LockException(error);
      }

      return false;
    }
    else
    {
      return true;
    }
  }

  /**
   * Returns true if the given object's thread is locked by the current thread,
   * false otherwise.
   * 
   * @param objectThread
   * @return true if the given object's thread is locked by the current thread,
   *         false otherwise.
   */
  protected static boolean isLockedByThread(Thread objectThread)
  {
    RequestState currentRequestState = RequestState.getCurrentRequestState();
    Thread mainThread = currentRequestState.getMainThread();

    if (objectThread == mainThread)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   * Returns the current Thread.
   * 
   * @return current Thread.
   */
  protected static Thread getCurrentThread()
  {
    RequestState currentRequestState = RequestState.getCurrentRequestState();

    return currentRequestState.getMainThread();
  }

}
