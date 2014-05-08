/*******************************************************************************
 * Copyright (c) 2013 TerraFrame, Inc. All rights reserved.
 * 
 * This file is part of Runway SDK(tm).
 * 
 * Runway SDK(tm) is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Runway SDK(tm) is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Runway SDK(tm). If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
/*
 * Created on Jun 17, 2005
 */
package com.runwaysdk.dataaccess.attributes.entity;

import com.runwaysdk.dataaccess.AttributeLongIF;
import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.attributes.AttributeValueException;

public class AttributeLong extends AttributeNumber implements AttributeLongIF
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = 608579832957982942L;

  /**
   * Inherited constrcutor, sets <code>name</code> and
   * <code>definingEntityType</code>.
   * 
   * @param name
   *          The name of this long attribute.
   * @param mdAttributeKey
   *          key of the defining attribute metadata.
   * @param definingEntityType
   *          Name of the class that defines this attribute.
   */
  protected AttributeLong(String name, String mdAttributeKey, String definingEntityType)
  {
    super(name, mdAttributeKey, definingEntityType);
  }

  /**
   * Inherited constrcutor, sets <code>name</code>,
   * <code>definingEntityType</code>, and <code>value</code>.
   * 
   * @param name
   *          The name of this long attribute.
   * @param mdAttributeKey
   *          key of the defining attribute metadata.
   * @param definingEntityType
   *          Name of the class that defines this attribute.
   * @param value
   *          The value of this long. "<code>true</code>" or "<code>false</code>
   *          "
   */
  protected AttributeLong(String name, String mdAttributeKey, String definingEntityType, String value)
  {
    super(name, mdAttributeKey, definingEntityType, value);
  }

  /**
   * Test if the input String is a valid Long
   * 
   * <br/>
   * <b>Precondition: </b> valueToValidate != null <br/>
   * <b>Postcondition: </b> true
   * 
   * @param mdAttributeIF
   *          the defining Metadata object of the class that contains this
   *          Attribute
   */
  protected void validate(String valueToValidate, MdAttributeDAOIF mdAttributeIF)
  {
    super.validate(valueToValidate, mdAttributeIF);

    if (!isValid(valueToValidate))
    {
      String error = "Value [" + valueToValidate + "] is invalid for attribute [" + getName() + "] on type [" + getDefiningClassType() + "]";
      throw new AttributeValueException(error, this, valueToValidate);
    }
  }

  /**
   * <b>Precondition:</b> value is already a valid Long or is an empty string.
   * 
   * @return value is already a valid Long or is an empty string.
   */
  public Long getLongValue()
  {
    return com.runwaysdk.dataaccess.attributes.entity.AttributeLong.getLongValue(this.getValue());
  }

  /**
   * <b>Precondition:</b> value is already a valid Long or is an empty string.
   * 
   * @return value is already a valid Long or is an empty string.
   */
  public static Long getLongValue(String value)
  {
    if (value.trim().length() == 0)
    {
      return null;
    }
    else
    {
      return Long.parseLong(value);
    }
  }

  /**
   * Test if the input String is a valid Long
   * 
   * <br/>
   * <b>Precondition: </b> valueToValidate != null <br/>
   * <b>Postcondition: </b> true
   * 
   * @param value
   *          value to validate.
   * @return <code><b>true</b></code> if the value is a valid Long
   */
  public static boolean isValid(String value)
  {
    if (!value.trim().equals(""))
    {
      try
      {
        Long.parseLong(value);
        return true;
      }
      catch (NumberFormatException ex)
      {
        return false;
      }
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
  public AttributeLong attributeClone()
  {
    return new AttributeLong(this.getName(), this.mdAttributeKey, this.getDefiningClassType(), new String(this.getRawValue()));
  }
}
