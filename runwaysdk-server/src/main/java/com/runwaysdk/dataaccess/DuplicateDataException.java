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
package com.runwaysdk.dataaccess;

import java.util.LinkedList;
import java.util.List;

import com.runwaysdk.ServerExceptionMessageLocalizer;

/**
 * Thrown when a new instance would conflict with existing data.
 * 
 * @author Eric Grunzke
 */
public class DuplicateDataException extends DataAccessException
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = -2807424816759278871L;

  /**
   * The type of the attribute being set.
   */
  protected MdEntityDAOIF mdEntityIF;
  
  /**
   * The attribute being set
   */
  protected List<AttributeIF> attributeIFList;

  /**
   * The duplicate value
   */
  protected List<String>      valueList;

  /**
   * Constructs a new DuplicateDataException with the specified developer
   * message.
   * 
   * @param devMessage
   *          The non-localized developer error message. Contains specific data
   *          access layer information useful for application debugging. The
   *          developer message is saved for later retrieval by the
   *          {@link #getMessage()} method.
   * @param mdEntityIF
   *          The object type being set. 
   * @param attributeIFList
   *          The attributes being set.
   * @param valueList
   *          The invalid values.
   */
  public DuplicateDataException(String devMessage, MdEntityDAOIF mdEntityIF, List<AttributeIF> attributeIFList, List<String> valueList)
  {
    super(devMessage);
    this.mdEntityIF = mdEntityIF;
    this.attributeIFList = attributeIFList;
    this.valueList = valueList;
  }

  /**
   * Constructs a new DuplicateDataException with the specified developer
   * message and cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i>
   * automatically incorporated in this DuplicateDataException's detail message.
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
   * @param mdEntityIF
   *          The object type being set. 
   * @param attributeIFList
   *          The attributes being set.
   * @param valueList
   *          The invalid values.
   */
  public DuplicateDataException(String devMessage, Throwable cause, MdEntityDAOIF mdEntityIF, List<AttributeIF> attributeIFList, List<String> valueList)
  {
    super(devMessage, cause);
    this.mdEntityIF = mdEntityIF;
    this.attributeIFList = attributeIFList;
    this.valueList = valueList;
  }
  
  
  /**
   * Constructs a new DuplicateDataException with the specified developer
   * message and cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i>
   * automatically incorporated in this DuplicateDataException's detail message.
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
   */
  protected DuplicateDataException(String devMessage, Throwable cause)
  {
    super(devMessage, cause);
    this.valueList = new LinkedList<String>();
  }

  /**
   * Constructs a new DuplicateDataException with the specified cause and a
   * developer message taken from the cause. This constructor is useful if the
   * DuplicateDataException is a wrapper for another throwable.
   * 
   * @param cause
   *          the cause (which is saved for later retrieval by the
   *          {@link #getCause()} method). (A <tt>null</tt> value is
   *          permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   * @param mdEntityIF
   *          The object type being set. 
   * @param attributeIFList
   *          The attributes being set.
   * @param valueList
   *          The invalid values.
   */
  public DuplicateDataException(Throwable cause, MdElementDAOIF mdEntityIF, List<AttributeIF> attributeIFList, List<String> valueList)
  {
    super(cause);
    this.mdEntityIF = mdEntityIF;
    this.attributeIFList = attributeIFList;
    this.valueList = valueList;
  }

  /**
   * Fetches the localized message template and plugs in the correct parameters
   * to set the business error message.
   * 
   */
  public String getLocalizedMessage()
  {
    if (attributeIFList.size() == 1)
    {
      String displayLabel = attributeIFList.get(0).getDisplayLabel(this.getLocale());
      String value = attributeIFList.get(0).getValue();
      return ServerExceptionMessageLocalizer.duplicateDataExceptionSingle(this.getLocale(), this.mdEntityIF.getDisplayLabel(this.getLocale()), displayLabel, value);
    }
    else
    {
      String displayLabels = "";
      String values = "";
      
      boolean firstIteration = true;
      for (AttributeIF attributeIF : attributeIFList)
      {
        if (!firstIteration)
        {
          displayLabels += ", ";
        }
        else
        {
          firstIteration = false;
        }
        displayLabels += "["+attributeIF.getDisplayLabel(this.getLocale())+"]";
      }
      
      firstIteration = true;
      for (String value : valueList)
      {
        if (!firstIteration)
        {
          values += ", ";
        }
        else
        {
          firstIteration = false;
        }
        values += "["+value+"]";
      }
            
      return ServerExceptionMessageLocalizer.duplicateDataExceptionMultiple(this.getLocale(), this.mdEntityIF.getDisplayLabel(this.getLocale()), displayLabels, values);
    }
    

  }
}
