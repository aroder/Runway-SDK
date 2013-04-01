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
package com.runwaysdk.transport.conversion.json;

import org.json.JSONObject;

import com.runwaysdk.business.EntityDTO;

public abstract class EntityDTOToJSON extends MutableDTOToJSON
{
  
  /**
   * 
   * @param entityDTO
   */
  protected EntityDTOToJSON(EntityDTO entityDTO)
  {
    super(entityDTO);
  }
  
  /**
   * Constructor to set the source EntityDTO and destination JSONObject.
   * 
   * @param entityDTO
   * @param entityJSON
   */
  protected EntityDTOToJSON(EntityDTO entityDTO, JSONObject json)
  {
    super(entityDTO, json);
  }

}
