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
package com.runwaysdk.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.runwaysdk.constants.EntityInfo;
import com.runwaysdk.dataaccess.MdAttributeConcreteDAOIF;
import com.runwaysdk.dataaccess.MdEntityDAOIF;
import com.runwaysdk.dataaccess.RelationshipDAO;
import com.runwaysdk.dataaccess.database.Database;
import com.runwaysdk.dataaccess.database.RelationshipDAOFactory;
import com.runwaysdk.dataaccess.metadata.MdElementDAO;


public class RelationshipDAOIterator<T> extends ComponentIterator<T>
{
  private RelationshipDAOQuery relationshipQuery;

  protected MdEntityDAOIF  rootMdEntityIF;
  
  /**
   * Initializes the iterator.
   * @param columnInfoMap
   * @param resultSet
   */
  @SuppressWarnings("unchecked")
  protected RelationshipDAOIterator(MdEntityDAOIF mdEntityIF, RelationshipDAOQuery relationshipQuery, Map<String, ColumnInfo> columnInfoMap, ResultSet resultSet)
  {
    super(columnInfoMap, resultSet);

    this.rootMdEntityIF = mdEntityIF.getRootMdClassDAO();
    this.relationshipQuery = relationshipQuery;
  }

  /**
   * Returns the next component on the iterator, or null
   * if there are no more Components left on the iterator.
   * 
   * @return next component on the iterator.
   */
  @SuppressWarnings("unchecked")
  public T next()
  {
    RelationshipDAO relationshipDAO = null;
    
    if (this.hasNext)
    {
      try
      {   
        String typeColumnAlias = columnInfoMap.get(this.rootMdEntityIF.definesType()+"."+EntityInfo.TYPE).getColumnAlias();
        String relationshipType = this.resultSet.getString(typeColumnAlias);
        
        List<? extends MdAttributeConcreteDAOIF> mdAttributeIFList = (List<? extends MdAttributeConcreteDAOIF>)this.mdEntityMdAttributeMap.get(relationshipType);
        if (mdAttributeIFList == null)
        {
          mdAttributeIFList = MdElementDAO.getMdElementDAO(relationshipType).getAllDefinedMdAttributes();
          this.mdEntityMdAttributeMap.put(relationshipType, mdAttributeIFList);
        }
               
        relationshipDAO = RelationshipDAOFactory.buildRelationshipFromQuery(relationshipType, this.relationshipQuery, this.columnInfoMap, 
            this.definedByMdEntityMap, mdAttributeIFList, this.resultSet);
        
        this.hasNext = this.resultSet.next();
        if (!this.hasNext)
        {
          this.close();
        }
      }
      catch(SQLException sqlEx)
      {
        // close the connection
        this.close();
        Database.throwDatabaseException(sqlEx);
      }
      
      // do something 
      return (T)relationshipDAO;
    }
    else
    {
      throw new NoSuchElementException();
    }
  }

  /**
   * @throws UnsupportedOperationException iterators should not allow one to remove an object from the underlying collection.
   */
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * Needed to implement the Iterable interface.
   */
  public Iterator<T> iterator()
  {
    return this;
  }
}
