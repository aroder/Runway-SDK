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
package com.runwaysdk.transport.conversion.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.runwaysdk.business.EntityDTO;

/**
 * Converts an EntityDTO into a Document.
 */
public abstract class EntityDTOtoDoc extends MutableDTOtoDoc
{
  
  /**
   * Constructor.
   * 
   * @param entityDTO
   * @param document
   * @param root
   * @param convertMetaData
   */
  public EntityDTOtoDoc(EntityDTO entityDTO, Document document, Node root, boolean convertMetaData)
  {
    super(entityDTO, document, root, convertMetaData);
  }
  
  /**
   * Returns the componentDTO being converted to a document.
   * @return componentDTO being converted to a document.
   */
  protected EntityDTO getComponentDTO()
  {
    return (EntityDTO)super.getComponentDTO();
  }

}
