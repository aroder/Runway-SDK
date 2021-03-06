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
package com.runwaysdk.query;

import com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF;
import com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF;
import com.runwaysdk.dataaccess.MdEntityDAOIF;

/**
 * All generated query classes extend this class. It delegates to a type unsafe EntityQuery to hide all of the type unsafe query methods.
 * 
 * @author nathan
 * 
 */
public abstract class GeneratedEntityQuery extends GeneratedTableClassQuery
{
  /**
   *
   */
  protected GeneratedEntityQuery()
  {
    super();
  }

  /**
   * Returns the {@link MdEntityDAOIF} of components that are queried by this object.
   * 
   * @return {@link MdEntityDAOIF} of components that are queried by this object.
   */
  @Override
  public MdEntityDAOIF getMdClassIF()
  {
    return (MdEntityDAOIF)super.getMdClassIF();
  }
  
  /**
   * Returns the {@link MdEntityDAOIF} of components that are queried by this object.
   * 
   * @return {@link MdEntityDAOIF} of components that are queried by this object.
   */
  public MdEntityDAOIF getMdEntityIF()
  {
    return (MdEntityDAOIF)super.getMdClassIF();
  }

  public Attribute id()
  {
    return this.getComponentQuery().id();
  }

  public SelectableChar getId()
  {
    return this.getComponentQuery().id();
  }
  
  /**
   * Compares this AttributeReference with another.
   * 
   * @param attributeIF
   * @return Condition object
   */
  public Condition EQ(SelectableReference _attributeIF)
  {
    AttributeCharacter idCharacter = this.getComponentQuery().id();

    MdAttributeCharacterDAOIF mdAttributeCharacterDAOIF = (MdAttributeCharacterDAOIF) idCharacter.getMdAttributeIF();
    MdAttributeReferenceDAOIF mdAttributeReferenceDAOIF = mdAttributeCharacterDAOIF.convertToReference();

    AttributeReference idReference = (AttributeReference) this.getComponentQuery().internalAttributeFactory(mdAttributeCharacterDAOIF.definesAttribute(), mdAttributeReferenceDAOIF, this, idCharacter.getUserDefinedAlias(), idCharacter.getUserDefinedDisplayLabel());

    return idReference.EQ(_attributeIF);
  }


  /**
   * Returns {@link EntityQuery} that all generated query methods delegate to.
   * 
   * @return {@link EntityQuery} that all generated query methods delegate to.
   */
  @Override
  protected EntityQuery getComponentQuery()
  {
    return (EntityQuery)super.getComponentQuery();
  }

  /**
   * Throws <code>QueryException</code> if this <code>EntityQuery</code> is used in a <code>ValueQuery</code>.
   */
  protected void checkNotUsedInValueQuery()
  {
    this.getComponentQuery().checkNotUsedInValueQuery();
  }

  /**
   * Sets the {@link EntityQuery} that all generated query methods delegate to.
   */
  protected void setComponentQuery(EntityQuery entityQuery)
  {
    super.setComponentQuery(entityQuery);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectable
   */
  public LeftJoinEq LEFT_JOIN_EQ(Selectable selectable)
  {
    return new LeftJoinEq(this.id(), selectable);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectableArray
   */
  public LeftJoinEq LEFT_JOIN_EQ(Selectable... selectableArray)
  {
    return new LeftJoinEq(this.id(), selectableArray);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectable
   */
  public LeftJoinNotEq LEFT_JOIN_NE(SelectableSingle selectable)
  {
    return new LeftJoinNotEq(this.id(), selectable);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectableArray
   */
  public LeftJoinNotEq LEFT_JOIN_NE(SelectableSingle... selectableArray)
  {
    return new LeftJoinNotEq(this.id(), selectableArray);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectable
   */
  public LeftJoinGt LEFT_JOIN_GT(SelectableSingle selectable)
  {
    return new LeftJoinGt(this.id(), selectable);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectableArray
   */
  public LeftJoinGt LEFT_JOIN_GT(SelectableSingle... selectableArray)
  {
    return new LeftJoinGt(this.id(), selectableArray);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectable
   */
  public LeftJoinGtEq LEFT_JOIN_GE(SelectableSingle selectable)
  {
    return new LeftJoinGtEq(this.id(), selectable);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectableArray
   */
  public LeftJoinGtEq LEFT_JOIN_GE(SelectableSingle... selectableArray)
  {
    return new LeftJoinGtEq(this.id(), selectableArray);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectable
   */
  public LeftJoinLt LEFT_JOIN_LT(SelectableSingle selectable)
  {
    return new LeftJoinLt(this.id(), selectable);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectableArray
   */
  public LeftJoinLt LEFT_JOIN_LT(SelectableSingle... selectableArray)
  {
    return new LeftJoinLt(this.id(), selectableArray);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectable
   */
  public LeftJoinLtEq LEFT_JOIN_LE(SelectableSingle selectable)
  {
    return new LeftJoinLtEq(this.id(), selectable);
  }

  /**
   * Represents a join between tables in the query.
   * 
   * @param selectableArray
   */
  public LeftJoinLtEq LEFT_JOIN_LE(SelectableSingle... selectableArray)
  {
    return new LeftJoinLtEq(this.id(), selectableArray);
  }

}
