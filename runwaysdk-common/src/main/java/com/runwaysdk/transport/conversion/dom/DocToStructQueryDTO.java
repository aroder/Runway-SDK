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
package com.runwaysdk.transport.conversion.dom;

import org.w3c.dom.Element;

import com.runwaysdk.business.StructQueryDTO;
import com.runwaysdk.constants.ClientRequestIF;

public class DocToStructQueryDTO extends DocToEntityQueryDTO
{

  /**
   * Constructor to set the Node containing the QueryDTO
   * 
   * @param clientRequest
   * @param rootElement
   * @param queryDTO
   */
  public DocToStructQueryDTO(ClientRequestIF clientRequest, Element rootElement, StructQueryDTO queryDTO)
  {
    super(clientRequest, rootElement, queryDTO);
  }

}
