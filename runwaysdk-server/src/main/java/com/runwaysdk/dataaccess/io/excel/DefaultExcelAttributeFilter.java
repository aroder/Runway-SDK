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
package com.runwaysdk.dataaccess.io.excel;

import com.runwaysdk.constants.ElementInfo;
import com.runwaysdk.dataaccess.MdAttributeBlobDAOIF;
import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.MdAttributeEncryptionDAOIF;
import com.runwaysdk.dataaccess.MdAttributeRefDAOIF;

public class DefaultExcelAttributeFilter implements MdAttributeFilter
{
  @Override
  public boolean accept(MdAttributeDAOIF mdAttribute)
  {
    return ! ( mdAttribute.isSystem() || mdAttribute.definesAttribute().equals(ElementInfo.DOMAIN) || mdAttribute.definesAttribute().equals(ElementInfo.OWNER) || mdAttribute.definesAttribute().equals(ElementInfo.KEY) || mdAttribute instanceof MdAttributeRefDAOIF || mdAttribute instanceof MdAttributeEncryptionDAOIF || mdAttribute instanceof MdAttributeBlobDAOIF );
  }
}