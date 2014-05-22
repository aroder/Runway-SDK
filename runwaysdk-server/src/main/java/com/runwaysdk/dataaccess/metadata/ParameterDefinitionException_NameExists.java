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
package com.runwaysdk.dataaccess.metadata;

import com.runwaysdk.ServerExceptionMessageLocalizer;
import com.runwaysdk.dataaccess.MdParameterDAOIF;

public class ParameterDefinitionException_NameExists extends ParameterDefinitionException
{
  /**
   * 
   */
  private static final long serialVersionUID = 7812613324955293088L;
  private ParameterMarker marker;
  
  /**
   * Constructs a new ParameterDefinitionException_NameExists with the specified developer
   * message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data
   *          access layer information useful for application debugging. The
   *          developer message is saved for later retrieval by the
   *          {@link #getMessage()} method.
   * @param mdParameter
   *          Metadata containing the invalid parameter definition.
   * @param marker
   *          Metadata containing the invalid method definition.
   */
  public ParameterDefinitionException_NameExists(String devMessage, MdParameterDAOIF mdParameter, ParameterMarker marker)
  {
    super(devMessage, mdParameter);
    this.marker = marker;
  }

  /**
   * Constructs a new ParameterDefinitionException_NameExists with the specified developer
   * message and cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i>
   * automatically incorporated in this AttributeDefinitionException's detail
   * message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data
   *          access layer information useful for application debugging. The
   *          developer message is saved for later retrieval by the
   *          {@link #getMessage()} method.
   * @param cause
   *          the cause (which is saved for later retrieval by the
   *          {@link #getCause()} method). (A <tt>null</tt> value is
   *          permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   * @param mdParameter
   *          Metadata containing the invalid parameter definition.
   * @param marker
   *          Metadata containing the invalid method definition.
   */
  public ParameterDefinitionException_NameExists(String devMessage, Throwable cause, MdParameterDAOIF mdParameter, ParameterMarker marker)
  {
    super(devMessage, cause, mdParameter);
    this.marker = marker;
  }

  /**
   * Constructs a new ParameterDefinitionException_NameExists with the specified cause and
   * a developer message taken from the cause. This constructor is useful if the
   * AttributeDefinitionException is a wrapper for another throwable.
   * 
   * @param cause
   *          the cause (which is saved for later retrieval by the
   *          {@link #getCause()} method). (A <tt>null</tt> value is
   *          permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   * @param mdParameter
   *          Metadata containing the invalid parameter definition.
   * @param marker
   *          Metadata containing the invalid method definition.
   */
  public ParameterDefinitionException_NameExists(Throwable cause, MdParameterDAOIF mdParameter, ParameterMarker marker)
  {
    super(cause, mdParameter);
    this.marker = marker;
  }
  
  /**
   * Uses the stored parameters and the given Locale to produce an error message
   * suitable for display to end users.
   * 
   */
  public String getLocalizedMessage()
  {
    return ServerExceptionMessageLocalizer.parameterDefinitionException_InvalidType(this.getLocale(), this.mdParameter, this.marker);
  }
}
