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
package com.runwaysdk.dataaccess.database;

import com.runwaysdk.RunwayException;

/**
 * Represents errors that arise from direct interaction with the database.
 * 
 * @author Eric Grunzke
 */
public class DatabaseException extends RunwayException
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = 8186834392855412103L;
  
  /**
   * Generated by Eclipse.
   */
  
  @SuppressWarnings("unused")
  /**
   * The SQL statement that caused the error
   */
  private String            statement;
  
  /**
   * Constructs a new DatabaseException with the specified developer message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data access
   *          layer information useful for application debugging. The developer message is
   *          saved for later retrieval by the {@link #getMessage()} method.
   */
  public DatabaseException(String devMessage)
  {
    super(devMessage);
  }

  /**
   * Constructs a new DatabaseException with the specified developer message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data access
   *          layer information useful for application debugging. The developer message is
   *          saved for later retrieval by the {@link #getMessage()} method.
   * @param statement
   *          The SQL statement that caused the error
   */
  public DatabaseException(String devMessage, String statement)
  {
    super(addStatement(devMessage, statement));
    this.statement = statement;
  }

  private static String addStatement(String devMessage, String statement)
  {
    return devMessage + " - The statement that caused the error was [" + statement + "]";
  }

  /**
   * Constructs a new DatabaseException with the specified developer message and cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i>
   * automatically incorporated in this DatabaseException's detail message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data access
   *          layer information useful for application debugging. The developer message is
   *          saved for later retrieval by the {@link #getMessage()} method.
   * @param cause
   *          the cause (which is saved for later retrieval by the {@link #getCause()}
   *          method). (A <tt>null</tt> value is permitted, and indicates that the cause
   *          is nonexistent or unknown.)
   */
  public DatabaseException(String devMessage, Throwable cause)
  {
    super(devMessage, cause);
  }

  /**
   * Constructs a new DatabaseException with the specified developer message and cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i>
   * automatically incorporated in this DatabaseException's detail message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data access
   *          layer information useful for application debugging. The developer message is
   *          saved for later retrieval by the {@link #getMessage()} method.
   * @param cause
   *          the cause (which is saved for later retrieval by the {@link #getCause()}
   *          method). (A <tt>null</tt> value is permitted, and indicates that the cause
   *          is nonexistent or unknown.)
   * @param statement
   *          The SQL statement that caused the error
   */
  public DatabaseException(String devMessage, Throwable cause, String statement)
  {
    super(addStatement(devMessage, statement), cause);
    this.statement = statement;
  }

  /**
   * Constructs a new DatabaseException with the specified cause and a developer message
   * taken from the cause. This constructor is useful if the DatabaseException is a
   * wrapper for another throwable.
   * 
   * @param cause
   *          the cause (which is saved for later retrieval by the {@link #getCause()}
   *          method). (A <tt>null</tt> value is permitted, and indicates that the cause
   *          is nonexistent or unknown.)
   */
  public DatabaseException(Throwable cause)
  {
    super(cause);
  }

  /**
   * Constructs a new DatabaseException with the specified cause and a developer message
   * taken from the cause. This constructor is useful if the DatabaseException is a
   * wrapper for another throwable.
   * 
   * @param cause
   *          the cause (which is saved for later retrieval by the {@link #getCause()}
   *          method). (A <tt>null</tt> value is permitted, and indicates that the cause
   *          is nonexistent or unknown.)
   * @param statement
   *          The SQL statement that caused the error
   */
  public DatabaseException(Throwable cause, String statement)
  {
    super(cause);
    this.statement = statement;
  }
}
