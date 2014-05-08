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
/**
 * Created on Aug 21, 2005
 *
 */
package com.runwaysdk.dataaccess;

import com.runwaysdk.dataaccess.metadata.MdAttributeReferenceDAO;


/**
 * References another attribute from another BusinessDAO, possibly of another class.
 *
 * @author nathan
 *
 */
public interface MdAttributeReferenceDAOIF extends MdAttributeRefDAOIF
{
  /**
   * Name of the table used to store intances of this class.
   */
  public static final String TABLE                        = "md_attribute_reference";

  /**
   *Returns the metadata object that defines the MdBusiness type that this attribute referenes,
   * or null if it does not reference anything.
   *
   * @return the metadata object that defines the MdBusiness type that this attribute referenes,
   * or null if it does not reference anything.
   */
  public MdBusinessDAOIF getReferenceMdBusinessDAO();

  /**
   * Special case for generating an id getter for reference attributes.
   *
   * @return reference id getter.
   */
  public String generatedServerGetterRefId();

  /**
   * Special case for generating an id getter for reference attributes.
   *
   * @return reference id getter.
   */
  public String generatedClientGetterRefId();

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#getBusinessDAO()
   */
  public MdAttributeReferenceDAO getBusinessDAO();
}
