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
package com.runwaysdk.constants;

public interface MdTransientInfo extends MdClassInfo
{
  /**
   * Class MdTransientInfo.
   */
  public static final String CLASS   = Constants.METADATA_PACKAGE+".MdTransient";
  
  /**
   * ID.
   */
  public static final String ID_VALUE  = "20071129NM000000000000000000000100000000000000000000000000000001"; 
  
  /**
   * Name of the attribute that indicates if this type is extendable or not.
   */
  public static final String EXTENDABLE                = "extendable";
  /**
   * Name of the attribute that indicates if this type is abstract or not.
   */
  public static final String ABSTRACT                  = "isAbstract";
}
