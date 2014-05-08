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
package com.runwaysdk.business.state;

import com.runwaysdk.ServerExceptionMessageLocalizer;

public class DefaultStateExistsException extends StateException
{
 
  /**
   * 
   */
  private static final long serialVersionUID = 5851584425905594484L;
  /**
   * Type that has a state machine.
   */
  private String type;
  
  /**
   * Thrown when a default state is defined on a state machine that already has a default state.
   * Constructs a new StateException with the specified developer message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data access
   *          layer information useful for application debugging. The developer message is
   *          saved for later retrieval by the {@link #getMessage()} method.
   * @param newState
   *          Name of the new state to be defined.
   * @param type
   *          Type that has a state machine.
   */
  public DefaultStateExistsException(String devMessage, String type)
  {
    super(devMessage);
    this.type = type;
  }

  /**
   * Thrown when a default state is defined on a state machine that already has a default state.
   * Constructs a new StateException with the specified developer message and
   * cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i>
   * automatically incorporated in this StateException's detail message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data access
   *          layer information useful for application debugging. The developer message is
   *          saved for later retrieval by the {@link #getMessage()} method.
   * @param cause
   *          the cause (which is saved for later retrieval by the {@link #getCause()}
   *          method). (A <tt>null</tt> value is permitted, and indicates that the cause
   *          is nonexistent or unknown.)
   * @param type
   *          Type that has a state machine.
   */
  public DefaultStateExistsException(String devMessage, Throwable cause, String type)
  {
    super(devMessage, cause);
    this.type = type;
  }
  
  /**
   * Thrown when a default state is defined on a state machine that already has a default state.e.
   * Constructs a new StateException with the specified cause and a developer
   * message taken from the cause. This constructor is useful if the
   * StateException is a wrapper for another throwable.
   * 
   * @param cause
   *          the cause (which is saved for later retrieval by the {@link #getCause()}
   *          method). (A <tt>null</tt> value is permitted, and indicates that the cause
   *          is nonexistent or unknown.)
   * @param newState
   *          Name of the new state to be defined.
   * @param type
   *          Type that has a state machine.
   */
  public DefaultStateExistsException(Throwable cause, String type)
  {
    super(cause);
    this.type = type;
  }
  
  /**
   * Uses the stored parameters and the given Locale to produce an error message
   * suitable for display to end users.
   * 
   */
  public String getLocalizedMessage()
  {
    return ServerExceptionMessageLocalizer.defaultStateExistsException(this.getLocale(), this.type);
  }
}
