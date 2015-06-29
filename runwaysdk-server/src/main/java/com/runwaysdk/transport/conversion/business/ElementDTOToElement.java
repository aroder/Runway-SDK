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
package com.runwaysdk.transport.conversion.business;

import com.runwaysdk.business.BusinessFacade;
import com.runwaysdk.business.Element;
import com.runwaysdk.business.ElementDTO;

public abstract class ElementDTOToElement extends EntityDTOToEntity
{

  private ElementDTO      elementDTO;

  private Element element;

  public ElementDTOToElement(String sessionId, ElementDTO elementDTO, Element element)
  {
    super(sessionId, elementDTO, element);
    
    this.element = element;
    this.elementDTO = elementDTO;
  }

  public Element populate()
  {
    // only set the attributes if the DTO is locked or if it's a new instance
    if(BusinessFacade.getLockedByDAO(element) != null || elementDTO.isNewInstance())
    {
      return (Element) super.populate();
    }
    else
    {
      return element;
    }
  }
}
