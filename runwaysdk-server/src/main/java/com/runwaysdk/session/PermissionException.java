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

import com.runwaysdk.ComponentIF;
import com.runwaysdk.business.BusinessException;
import com.runwaysdk.business.rbac.Operation;
import com.runwaysdk.business.rbac.UserDAOIF;

/**
 * Thrown when a user does not have permission for an operation
 *
 * @author Eric Grunzke
 */
public abstract class PermissionException extends BusinessException
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = -5148193233262848537L;

  /**
   * The entity that was being read/written/etc
   */
  private ComponentIF componentIF;

  /**
   * The failed operation (read/write/promote/etc)
   */
  protected Operation      operation;

  /**
   * The user attempting the operation
   */
  protected UserDAOIF         user;

  /**
   * Constructs a new PermissionException with the specified developer message.
   *
   * @param devMessage
   *          The non-localized developer error message. Contains specific data
   *          access layer information useful for application debugging. The
   *          developer message is saved for later retrieval by the
   *          {@link #getMessage()} method.
   * @param componentIF
   *          The entity that was being read/written/etc
   * @param operation
   *          The failed operation (read/write/promote/etc)
   * @param user
   *          The user attempting the operation
   */
  public PermissionException(String devMessage, ComponentIF componentIF, Operation operation, UserDAOIF user)
  {
    super(devMessage);
    this.componentIF = componentIF;
    this.operation = operation;
    this.user = user;
  }

  /**
   * Returns the component of this exception, but may return null, as
   * some subclasses do not need, or have access to, the component.
   *
   * @return component of this exception, but may return null, as
   * some subclasses do not need, or have access to, the component.
   */
  protected ComponentIF getComponentIF()
  {
    return this.componentIF;
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
   * @param componentIF
   *          The entity that was being read/written/etc
   * @param operation
   *          The failed operation (read/write/promote/etc)
   * @param user
   *          The user attempting the operation
   */
  public PermissionException(String devMessage, Throwable cause, ComponentIF componentIF,
      Operation operation, UserDAOIF user)
  {
    super(devMessage, cause);
    this.componentIF = componentIF;
    this.operation = operation;
    this.user = user;
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
   * @param componentIF
   *          The entity that was being read/written/etc
   * @param operation
   *          The failed operation (read/write/promote/etc)
   * @param user
   *          The user attempting the operation
   */
  public PermissionException(Throwable cause, ComponentIF componentIF, Operation operation, UserDAOIF user)
  {
    super(cause);
    this.componentIF = componentIF;
    this.operation = operation;
    this.user = user;
  }

}
