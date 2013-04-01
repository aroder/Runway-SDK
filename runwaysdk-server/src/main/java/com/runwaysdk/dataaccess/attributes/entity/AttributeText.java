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
/*
 * Created January 12, 2006
 */
package com.runwaysdk.dataaccess.attributes.entity;

import com.runwaysdk.dataaccess.AttributeIF;
import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.attributes.AttributeLengthCharacterException;
import com.runwaysdk.dataaccess.attributes.AttributeValueException;
import com.runwaysdk.dataaccess.metadata.MdAttributeTextDAO;


public class AttributeText extends Attribute
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = -7053663014634979091L;

  /**
   * Inherited constructor, sets <code>name</code> and
   * <code>definingEntityType</code>.
   *
   * @param name The name of this text attribute.
   * @param mdAttributeKey key of the defining attribute metadata.
   * @param definingEntityType Name of the class that defines this attribute.
   */
  protected AttributeText(String name, String mdAttributeKey, String definingEntityType)
  {
    super(name, mdAttributeKey, definingEntityType);
  }

  /**
   * Inherited constructor, sets <code>name</code>, <code>definingEntityType</code>,
   * and <code>value</code>.
   *
   * @param name
   *          The name of this text attribute.
   * @param mdAttributeKey key of the defining attribute metadata.
   * @param definingEntityType
   *          Name of the class that defines this attribute.
   * @param value
   *          The value of this text. "<code>true</code>" or "<code>false</code>"
   */
  protected AttributeText(String name, String mdAttributeKey, String definingEntityType, String value)
  {
    super(name, mdAttributeKey, definingEntityType, value);
  }

  /**
   * Test if the input String is valid.
   *
   * <br/><b>Precondition: </b> valueToValidate != null <br/><b>Postcondition:
   * </b> true
   *
   * @param valueToValidate the primitive attribute value to be validated
   * @param mdAttribute the defining Metadata object of the class that contains this
   *          Attribute
   */
  protected void validate(String valueToValidate, MdAttributeDAOIF mdAttribute)
  {
    super.validate(valueToValidate, mdAttribute);
    if (!isValid(valueToValidate, this))
    {
      String error = "Value [" + valueToValidate + "] is invalid for attribute [" + getName()
          + "] on type [" + getDefiningClassType() + "]";
      throw new AttributeValueException(error, this, valueToValidate);
    }
  }

  /**
   * Test if the input String is valid.
   *
   * <br/><b>Precondition: </b> valueToValidate != null <br/><b>Postcondition:
   * </b> true
   *
   * @param value the primitive attribute value to be validated
   * @return <code><b>true</b></code> if the value is a valid Text
   */
  public static boolean isValid(String value, AttributeIF attributeIF)
  {
    int charLength = value.length();
    int maxCharLength = 0;

    maxCharLength = MdAttributeTextDAO.getMaxLength();
    if (charLength > maxCharLength)
    {
      String error = "Attribute [" + attributeIF.getName() + "] on type [" + attributeIF.getDefiningClassType()
          + "] is too long.";
      throw new AttributeLengthCharacterException(error, attributeIF, maxCharLength);
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
  public AttributeText attributeClone()
  {
    return new AttributeText(this.getName(), this.mdAttributeKey, this.getDefiningClassType(), new String(this.getRawValue()));
  }
}
