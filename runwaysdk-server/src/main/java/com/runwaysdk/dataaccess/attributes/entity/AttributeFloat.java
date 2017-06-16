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

import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.attributes.AttributeValueException;

public class AttributeFloat extends AttributeNumber
{

  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = 8660776493869223974L;

  /**
   * Inherited constrcutor, sets <code>name</code> and <code>definingEntityType</code>.
   * 
   * @param name The name of this float attribute.
   * @param mdAttributeKey key of the defining attribute metadata.
   * @param definingEntityType The class type that defines this attribute.
   */
  protected AttributeFloat(String name, String mdAttributeKey, String definingEntityType)
  {
    super(name, mdAttributeKey, definingEntityType);
  }

  /**
   * Inherited constrcutor, sets <code>name</code>, <code>definingEntityType</code>, and
   * <code>value</code>.
   * 
   * @param name The name of this float attribute.
   * @param mdAttributeKey key of the defining attribute metadata.
   * @param definingEntityType  The class type that defines this attribute.
   * @param value The value of this float. "<code>true</code>" or "<code>false</code>"
   */
  protected AttributeFloat(String name, String mdAttributeKey, String definingEntityType, String value)
  {
    super(name, mdAttributeKey, definingEntityType, value);
    
    // Oracle seems to prepend some numbers with a black space 
    this.value = this.value.trim();
  }
  
  /**
   * Some attributes store objects instead of strings.
   * 
   * @param name
   * @return object stored on the attribute.
   */
  public Float getObjectValue()
  {
    if (this.getValue().trim().equals(""))
    {
      return null;
    }
    else
    {
      return Float.parseFloat(this.getValue());
    }
  }
  
  /**
   * Test if the input String is a valid float.
   * 
   * <br/><b>Precondition: </b> valueToValidate != null 
   * <br/><b>Postcondition: </b> true
   * 
   * @param valueToValidate the primitive attribute value to be validated
   * @param mdAttribute the defining Metadata object of the class that contains this
   *          Attribute
   */
  protected void validate(String valueToValidate, MdAttributeDAOIF mdAttributeIF)
  {
    super.validate(valueToValidate, mdAttributeIF);
    if (!AttributeFloat.isValid(valueToValidate))
    {
      String error = "Attribute [" + getName() + "] on type [" + getDefiningClassType() + "] is invalid.";
      throw new AttributeValueException(error, this, valueToValidate); 
    }
  }

  /**
   * Test if the input String is a valid float.
   * 
   * <br/><b>Precondition: </b> valueToValidate != null 
   * <br/><b>Postcondition: </b> true
   * 
   * @param value the primitive attribute value to be validated
   * @return <code><b>true</b></code> if the value is a valid Float
   */
  public static boolean isValid(String value)
  {
    if (!value.trim().equals(""))
    {
      try
      {
        // parse as float first, then check for bounds
        float testFloat = Float.parseFloat(value);

        if (testFloat == Float.POSITIVE_INFINITY || testFloat == Float.NEGATIVE_INFINITY)
          return false;
        else
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
   * <br/><b>Precondition: </b> true <br/><b>Postcondition: </b> true
   * 
   * @return a deep clone of this Attribute
   */
  public AttributeFloat attributeClone()
  {
    return new AttributeFloat(this.getName(), this.mdAttributeKey, this.getDefiningClassType(), new String(this.getRawValue()));
  }
}
