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
package com.runwaysdk.transport.conversion.json;

import java.util.Locale;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.runwaysdk.business.ComponentDTOFacade;
import com.runwaysdk.business.StructDTO;
import com.runwaysdk.transport.attributes.AttributeDTO;

public class JSONToStructDTO extends JSONToEntityDTO
{

  /**
   * 
   * @param json
   * @param structDTO
   * @throws JSONException
   */
  protected JSONToStructDTO(String sessionId, Locale locale, String json) throws JSONException
  {
    super(sessionId, locale, json);
  }
  
  
  /**
   * 
   * @param jsonObject
   * @param entityDTOIF
   * @throws JSONException
   */
  protected JSONToStructDTO(String sessionId, Locale locale, JSONObject jsonObject) throws JSONException
  {
    super(sessionId, locale, jsonObject);
  }

  /**
   * Instantiates StructDTO (not type safe)
   * @param type
   * @param attributeMap
   * @param newInstance
   * @param readable
   * @param writable
   * @param modified
   * @return StructDTO (not type safe)
   */
  protected StructDTO factoryMethod(String toString, String type, Map<String, AttributeDTO> attributeMap,
      boolean newInstance, boolean readable, boolean writable, boolean modified) throws JSONException
  {
    return ComponentDTOFacade.buildStructDTO(null, type, attributeMap,
        newInstance, readable, writable, modified,  toString);
  }
  
  @Override
  public StructDTO populate()
  {
    return (StructDTO) super.populate();
  }
}
