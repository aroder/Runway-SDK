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
package com.runwaysdk.dataaccess.io;

import java.io.File;

import com.runwaysdk.CommonExceptionMessageLocalizer;
import com.runwaysdk.SystemException;


/**
 * Thrown when an error in encountered (almost always an
 * {@link java.io.IOException}) when trying to read from the filesystem.
 *
 * @author Eric Grunzke
 */
public class FileReadException extends SystemException
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = 2865366501617071911L;

  /**
   * The file that was being read
   */
  private File file;

  /**
   * Constructs a new FileReadException with the specified developer message.
   *
   * @param devMessage
   *          The non-localized developer error message. Contains specific data
   *          access layer information useful for application debugging. The
   *          developer message is saved for later retrieval by the
   *          {@link #getMessage()} method.
   * @param file
   *          The file that was being read
   */
  public FileReadException(String devMessage, File file)
  {
    super(devMessage);
    this.file = file;
  }

  /**
   * Constructs a new FileReadException with the specified developer message and
   * cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i>
   * automatically incorporated in this FileReadException's detail message.
   *
   * @param devMessage
   *          The non-localized developer error message. Contains specific data
   *          access layer information useful for application debugging. The
   *          developer message is saved for later retrieval by the
   *          {@link #getMessage()} method.
   * @param file
   *          The file that was being read
   * @param cause
   *          the cause (which is saved for later retrieval by the
   *          {@link #getCause()} method). (A <tt>null</tt> value is
   *          permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   */
  public FileReadException(String devMessage, File file, Throwable cause)
  {
    super(devMessage, cause);
    this.file = file;
  }

  /**
   * Constructs a new FileReadException with the specified cause and a developer
   * message taken from the cause. This constructor is useful if the
   * FileReadException is a wrapper for another throwable.
   *
   * @param file
   *          The file that was being read
   * @param cause
   *          the cause (which is saved for later retrieval by the
   *          {@link #getCause()} method). (A <tt>null</tt> value is
   *          permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   */
  public FileReadException(File file, Throwable cause)
  {
    super(cause);
    this.file = file;
  }

  /**
   * Fetches the localized message template and plugs in the correct parameters
   * to set the business error message.
   *
   */
  public String getLocalizedMessage()
  {
    return CommonExceptionMessageLocalizer.fileReadException(this.getLocale(), file);
  }
}
