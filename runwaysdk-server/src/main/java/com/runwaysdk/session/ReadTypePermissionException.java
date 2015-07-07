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
package com.runwaysdk.session;

import com.runwaysdk.ServerExceptionMessageLocalizer;
import com.runwaysdk.business.BusinessException;
import com.runwaysdk.business.rbac.UserDAOIF;
import com.runwaysdk.dataaccess.MdTypeDAOIF;

public class ReadTypePermissionException extends BusinessException
{
  /**
   * 
   */
  private static final long serialVersionUID = -6122086323725606606L;

  private MdTypeDAOIF mdTypeIF;
  
  /**
   * Constructs a new PermissionException with the specified developer message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data
   *          access layer information useful for application debugging. The
   *          developer message is saved for later retrieval by the
   *          {@link #getMessage()} method.
   * @param mdTypeIF
   *          Type being read
   * @param user
   *          The user attempting the operation
   */
  public ReadTypePermissionException(String devMessage, MdTypeDAOIF mdTypeIF, UserDAOIF user)
  {
    super(devMessage);
    this.mdTypeIF = mdTypeIF;
  }

  /**
   * Constructs a new PermissionException with the specified developer message
   * and cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i>
   * automatically incorporated in this PermissionException's detail message.
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
   * @param mdTypeIF
   *          Type being read
   * @param user
   *          The user attempting the operation
   */
  public ReadTypePermissionException(String devMessage, Throwable cause, MdTypeDAOIF mdTypeIF, UserDAOIF user)
  {
    super(devMessage, cause);
    this.mdTypeIF = mdTypeIF;
  }

  /**
   * Constructs a new PermissionException with the specified cause and a
   * developer message taken from the cause. This constructor is useful if the
   * PermissionException is a wrapper for another throwable.
   * 
   * @param cause
   *          the cause (which is saved for later retrieval by the
   *          {@link #getCause()} method). (A <tt>null</tt> value is
   *          permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   * @param mdTypeIF
   *          Type being read
   * @param user
   *          The user attempting the operation
   */
  public ReadTypePermissionException(Throwable cause, MdTypeDAOIF mdTypeIF, UserDAOIF user)
  {
    super(cause);
    this.mdTypeIF = mdTypeIF;
  }
  
  /**
   * Uses the stored parameters and the given Locale to produce an error message
   * suitable for display to end users.
   * 
   */
  public String getLocalizedMessage()
  {
    return ServerExceptionMessageLocalizer.readTypePermissionException(this.getLocale(), this.mdTypeIF.getDisplayLabel(this.getLocale()));
  }
}
