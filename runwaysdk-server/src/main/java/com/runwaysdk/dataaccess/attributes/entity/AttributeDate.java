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
/*
 * Created January 12, 2006
 */
package com.runwaysdk.dataaccess.attributes.entity;

import java.util.Date;
import java.util.regex.Pattern;

import com.runwaysdk.constants.MdAttributeDateInfo;
import com.runwaysdk.constants.MdAttributeDateUtil;
import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.MdAttributeDateDAOIF;
import com.runwaysdk.dataaccess.attributes.AttributeValueException;
import com.runwaysdk.dataaccess.database.Database;

public class AttributeDate extends AttributeMoment
{
  /**
   * Generated by Eclipse
   */
  private static final long    serialVersionUID = -7541031337094287497L;

  /**
   * Regex pattern to match dates.
   */
  private static final Pattern datePattern      = Pattern.compile("(\\d){4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])");

  /**
   * Inherited constrcutor, sets <code>name</code> and
   * <code>definingEntityType</code>.
   * 
   * @param name
   *          The name of this time attribute.
   * @param mdAttributeKey
   *          key of the defining attribute metadata
   * @param definingEntityType
   *          The type that defines this attribute.
   */
  protected AttributeDate(String name, String mdAttributeKey, String definingEntityType)
  {
    super(name, mdAttributeKey, definingEntityType);
  }

  /**
   * Inherited constrcutor, sets <code>name</code>,
   * <code>definingEntityType</code>, and <code>value</code>.
   * 
   * @param name
   *          The name of this date attribute.
   * @param mdAttributeKey
   *          key of the defining attribute metadata
   * @param definingEntityType
   *          The name of the class that defines this attribute.
   * @param value
   *          The value of this date. "<code>true</code>" or "<code>false</code>
   *          "
   */
  protected AttributeDate(String name, String mdAttributeKey, String definingEntityType, String value)
  {
    super(name, mdAttributeKey, definingEntityType, value);

    this.value = formatSQLToJavaDate(this.value);
  }

  /**
   * 
   * @param value
   * @return
   */
  public static String formatSQLToJavaDate(String value)
  {
    String returnValue = value;
    // Some databases (like Oracle) will store the full date and time.
    // Consequently, the
    // database will return the full date and time. We need to strip off the
    // time and
    // only store the date.
    if (returnValue != null && !returnValue.trim().equals("") && returnValue.contains(":"))
    {
      returnValue = Database.formatSQLToJavaDate(returnValue);
    }

    return returnValue;
  }

  /**
   * Test if the input String is valid as a Date.
   * 
   * <br/>
   * <b>Precondition: </b> valueToValidate != null <br/>
   * <b>Postcondition: </b> true
   * 
   * @param valueToValidate
   *          the date attribute value to be validated
   * @param mdAttribute
   *          the defining Metadata object of the class that contains this
   *          Attribute
   */
  protected void validate(String valueToValidate, MdAttributeDAOIF mdAttribute)
  {
    super.validate(valueToValidate, mdAttribute);

    if (!isValid(valueToValidate))
    {
      String error = "Value [" + valueToValidate + "] is invalid for attribute [" + getName() + "] on type [" + getDefiningClassType() + "]";
      throw new AttributeValueException(error, this, valueToValidate);
    }

    Date date = MdAttributeDateUtil.getTypeSafeValue(valueToValidate);

    if (date != null)
    {
      MdAttributeDateDAOIF mdAttributeDate = (MdAttributeDateDAOIF) mdAttribute.getMdAttributeConcrete();

      // Ensure that that the date is greater than the start date
      String startValue = mdAttributeDate.getValue(MdAttributeDateInfo.START_DATE);

      if (startValue != null && startValue.length() > 0)
      {
        Date startDate = MdAttributeDateUtil.getTypeSafeValue(startValue);

        if (! ( startDate.before(date) || startDate.equals(date) ))
        {
          String msg = "Value [" + valueToValidate + "] must be after the date [" + startValue + "]";

          throw new AttributeValueException(msg, valueToValidate);
        }
      }

      // Ensure that the date is less than the end date
      String endValue = mdAttributeDate.getValue(MdAttributeDateInfo.END_DATE);

      if (endValue != null && endValue.length() > 0)
      {
        Date endDate = MdAttributeDateUtil.getTypeSafeValue(endValue);

        if (! ( endDate.after(date) || endDate.equals(date) ))
        {
          String msg = "Value [" + valueToValidate + "] must be before the date [" + endValue + "]";

          throw new AttributeValueException(msg, valueToValidate);
        }
      }

      // Ensure that the date is before today inclusive
      String beforeTodayInclusive = mdAttributeDate.getValue(MdAttributeDateInfo.BEFORE_TODAY_INCLUSIVE);

      if (beforeTodayInclusive != null && beforeTodayInclusive.length() > 0 && Boolean.parseBoolean(beforeTodayInclusive))
      {
        Date today = MdAttributeDateUtil.getDate();
        if (! ( date.before(today) || date.equals(today) ))
        {
          String msg = "Value [" + valueToValidate + "] must be before or equal to today's date";

          throw new AttributeValueException(msg, valueToValidate);
        }
      }

      // Ensure that the date is before today exlusive
      String beforeTodayExclusive = mdAttributeDate.getValue(MdAttributeDateInfo.BEFORE_TODAY_EXCLUSIVE);

      if (beforeTodayExclusive != null && beforeTodayExclusive.length() > 0 && Boolean.parseBoolean(beforeTodayExclusive))
      {
        Date today = MdAttributeDateUtil.getDate();

        if (!date.before(today))
        {
          String msg = "Value [" + valueToValidate + "] must be before today's date";

          throw new AttributeValueException(msg, valueToValidate);
        }
      }

      // Ensure that the date is after today inclusive
      String afterTodayInclusive = mdAttributeDate.getValue(MdAttributeDateInfo.AFTER_TODAY_INCLUSIVE);

      if (afterTodayInclusive != null && afterTodayInclusive.length() > 0 && Boolean.parseBoolean(afterTodayInclusive))
      {
        Date today = MdAttributeDateUtil.getDate();
        if (! ( date.after(today) || date.equals(today) ))
        {
          String msg = "Value [" + valueToValidate + "] must be after or equal to today's date";

          throw new AttributeValueException(msg, valueToValidate);
        }
      }

      // Ensure that the date is after today exlusive
      String afterTodayExclusive = mdAttributeDate.getValue(MdAttributeDateInfo.AFTER_TODAY_EXCLUSIVE);

      if (afterTodayExclusive != null && afterTodayExclusive.length() > 0 && Boolean.parseBoolean(afterTodayExclusive))
      {
        Date today = MdAttributeDateUtil.getDate();
        if (!date.after(today))
        {
          String msg = "Value [" + valueToValidate + "] must be after today's date";

          throw new AttributeValueException(msg, valueToValidate);
        }
      }
    }
  }

  /**
   * Test if the input String is valid as a Date.
   * 
   * <br/>
   * <b>Precondition: </b> valueToValidate != null <br/>
   * <b>Postcondition: </b> true
   * 
   * @param value
   *          the date attribute value to be validated
   * @return <code><b>true</b></code> if the value is a valid Date
   */
  public static boolean isValid(String value)
  {
    // regex check
    if (!value.trim().equals("") && ( !datePattern.matcher(value).matches() || !AttributeMoment.checkDateBounds(value) ))
    {
      return false;
    }

    return true;
  }

  /**
   * Returns a deep clone of this attribute.
   * 
   * <br/>
   * <b>Precondition: </b> true <br/>
   * <b>Postcondition: </b> true
   * 
   * @return a deep clone of this Attribute
   */
  public AttributeDate attributeClone()
  {
    return new AttributeDate(this.getName(), this.mdAttributeKey, this.getDefiningClassType(), new String(this.getRawValue()));
  }
}
