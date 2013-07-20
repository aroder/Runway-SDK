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
package com.runwaysdk;

import java.io.File;

import com.runwaysdk.constants.ExceptionConstants;
import com.runwaysdk.constants.TypeGeneratorInfo;
import com.runwaysdk.generation.loader.LoaderDecorator;

public class CommonExceptionProcessor
{
  /**
   * Used for exceptions that are thrown in the common directory.  Instantiates
   * the exception with the given class name using reflection.  Assumes that
   * the exception class is a subclass of RunwayException.  If the control flow
   * is called from the server, then the server exception is thrown.  If not
   * called from the server, then the DTO version is thrown.
   *
   * @param runwayExceptionType
   * @param developerMessage
   * @param locale null if not available.
   * @param throwable
   */
  public static void processException(String runwayExceptionType, String developerMessage) throws RuntimeException
  {
    processException(runwayExceptionType, developerMessage, null);
  }

  /**
   * Used for exceptions that are thrown in the common directory.  Instantiates
   * the exception with the given class name using reflection.  Assumes that
   * the exception class is a subclass of RunwayException.  If the control flow
   * is called from the server, then the server exception is thrown.  If not
   * called from the server, then the DTO version is thrown.
   *
   * @param runwayExceptionType
   * @param developerMessage
   * @param locale null if not available.
   * @param throwable
   */
  public static void processException(String runwayExceptionType, String developerMessage, Throwable throwable) throws RuntimeException
  {
    Class<?> runwayExceptionDTOclass = LoaderDecorator.load(runwayExceptionType+TypeGeneratorInfo.DTO_SUFFIX);

    RunwayExceptionDTO runwayExceptionDTO;

    try
    {
      if (throwable != null)
      {
        runwayExceptionDTO = (RunwayExceptionDTO)runwayExceptionDTOclass.getConstructor(String.class, String.class, String.class, Throwable.class).
        newInstance(runwayExceptionType, "", developerMessage, throwable);
      }
      else
      {
        runwayExceptionDTO = (RunwayExceptionDTO)runwayExceptionDTOclass.getConstructor(String.class, String.class, String.class).
          newInstance(runwayExceptionType, "", developerMessage);
      }
    }
    catch (Exception e)
    {
      // This is one of the few times in which it is acceptable to throw a runtime
      // exception in Runway.  This indicates a problem with the common
      // exception mechanism.
      throw new RuntimeException(e);
    }
    throw runwayExceptionDTO;
  }

  /**
   * Used for FileWriteExceptions that are thrown in the common directory.  Instantiates
   * the exception with the given class name using reflection.  Assumes that
   * the exception class is a subclass of RunwayException.  If the control flow
   * is called from the server, then the server exception is thrown.  If not
   * called from the server, then the DTO version is thrown.
   *
   * @param file
   * @param throwable
   */
  public static void fileWriteException(File file, Throwable throwable) throws RuntimeException
  {
    Class<?> fileWriteExceptionDTOclass = LoaderDecorator.load(ExceptionConstants.FileWriteException.getExceptionClass()+TypeGeneratorInfo.DTO_SUFFIX);

    RunwayExceptionDTO runwayExceptionDTO;

    try
    {
      runwayExceptionDTO = (RunwayExceptionDTO)fileWriteExceptionDTOclass.getConstructor(File.class, Throwable.class).
        newInstance(file, throwable);
    }
    catch (Exception e)
    {
      // This is one of the few times in which it is acceptable to throw a runtime
      // exception in Runway.  This indicates a problem with the common
      // exception mechanism.
      e.printStackTrace();
      throw new RuntimeException(e);
    }

    throw runwayExceptionDTO;
  }
}