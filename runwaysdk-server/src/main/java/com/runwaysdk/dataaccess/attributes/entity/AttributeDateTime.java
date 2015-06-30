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

import java.util.regex.Pattern;

import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.attributes.AttributeValueException;


public class AttributeDateTime extends AttributeMoment
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = 7050731318701539715L;

  /**
   * Regex pattern to match times.
   */
  private static final Pattern datetimePattern = Pattern.compile("(\\d){4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) (\\d){2}:[0-5][0-9]:[0-5][0-9]");
  
  /**
   * Inherited constructor, sets <code>name</code> and <code>definingEntityType</code>.
   * 
   * @param name The name of this time attribute.
   * @param mdAttributeKey key of the defining attribute metadata
   * @param definingEntityType the name of the class that defines this attribute.
   */
  protected AttributeDateTime(String name, String mdAttributeKey, String definingEntityType)
  {
    super(name, mdAttributeKey, definingEntityType);
  }

  /**
   * Inherited constrcutor, sets <code>name</code>, <code>definingEntityType</code>, and
   * <code>value</code>.
   * 
   * @param name The name of this datetime attribute.
   * @param mdAttributeKey key of the defining attribute metadata
   * @param definingEntityType the name of the class that defines this attribute.
   * @param value The value of this datetime. "<code>true</code>" or "<code>false</code>"
   */
  protected AttributeDateTime(String name, String mdAttributeKey, String definingEntityType, String value)
  {
    super(name, mdAttributeKey, definingEntityType, value);
    
    this.value = AttributeTime.removeMillisecondDelimiter(value);
  }
  
  /**
   * Test if the input String is a valid date and time.
   * 
   * <br/><b>Precondition: </b> valueToValidate != null 
   * <br/><b>Postcondition: </b> true
   * 
   * @param mdAttribute the defining Metadata object of the class that contains this
   *          Attribute
   */
  protected void validate(String valueToValidate, MdAttributeDAOIF mdAttribute)
  {
    super.validate(valueToValidate, mdAttribute);
    if (!isValid(valueToValidate))
    {
      String error = "Value [" + valueToValidate + "] is invalid for attribute [" + getName()
          + "] on type [" + getDefiningClassType() + "]";
      throw new AttributeValueException(error, this, valueToValidate);
    }
  }

  /**
   * Test if the input String is a valid date and time.
   * 
   * <br/><b>Precondition: </b> valueToValidate != null 
   * <br/><b>Postcondition: </b> true
   * 
   */
  public static boolean isValid(String valueToValidate)
  {
    // regex check
    if (!valueToValidate.trim().equals("") &&
        (!datetimePattern.matcher(valueToValidate).matches()
        || !AttributeMoment.checkDateBounds(valueToValidate.split(" ")[0])
        || !AttributeMoment.checkTimeBounds(valueToValidate.split(" ")[1])))
    {
      return false;
    }
    return true;
  }
  
  /**
   * Returns a deep clone of this attribute.
   * 
   * <br/><b>Precondition: </b> true <br/><b>Postcondition: </b> true
   * 
   * @return a deep clone of this Attribute
   */
  public AttributeDateTime attributeClone()
  {
    return new AttributeDateTime(this.getName(), this.mdAttributeKey, this.getDefiningClassType(), new String(this.getRawValue()));
  }
}
