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

import java.util.List;

import com.runwaysdk.dataaccess.MdStructDAOIF;

public interface SelectableStruct extends Selectable
{
  /**
   * Creates an {@link Attribute} object on the struct with the given name.
   * @param attributeName name of the attribute.
   * @return {@link Attribute}  object on the struct with the given name.
   */
  public Attribute get(String attributeName);

  /**
   * Creates an {@link Attribute} object on the struct with the given name and alias.
   * @param attributeName name of the attribute.
   * @param attributeAlias user defined alias.
   * @return {@link Attribute} object on the struct with the given name and alias.
   */
  public Attribute get(String attributeName, String attributeAlias);


  public MdStructDAOIF getMdStructDAOIF();

  /**
   * Returns A {@link List} of newly created {@link Attribute} objects representing the attributes for this struct. 
   * 
   * @return A {@link List} of newly created {@link Attribute} objects representing the attributes for this struct. 
   */
  public List<Attribute> getStructAttributes();
}
