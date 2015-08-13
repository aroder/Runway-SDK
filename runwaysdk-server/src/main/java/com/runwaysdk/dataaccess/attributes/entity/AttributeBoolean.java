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
 * Created on Jun 17, 2005
 */
package com.runwaysdk.dataaccess.attributes.entity;

import com.runwaysdk.constants.MdAttributeBooleanInfo;
import com.runwaysdk.constants.MdAttributeBooleanUtil;
import com.runwaysdk.dataaccess.AttributeBooleanIF;
import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.attributes.AttributeValueException;


/**
 * <code>AttributeBoolean</code> represents <code><b>boolean</b></code> attributes in
 * classes in the database. It standardizes database-level boolean representation through
 * Strings, and translates results to Java <code><b>boolean</code></b>s.
 * 
 * @author Eric
 * @version $Revision 1.0 $
 * @since
 */
public class AttributeBoolean extends Attribute implements AttributeBooleanIF
{

  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = -8176997715088266656L;

  /**
   * Inherited constrcutor, sets <code>name</code> and <code>definingEntityType</code>.
   * 
   * @param name The name of this boolean attribute.
   * @param mdAttributeKey key of the defining attribute metadata
   * @param definingEntityType The class that defines this attribute.
   */
  public AttributeBoolean(String name, String mdAttributeKey, String definingEntityType)
  {
    super(name, mdAttributeKey, definingEntityType);
  }

  /**
   * Inherited constructor, sets <code>name</code>, <code>definingEntityType</code>, and
   * <code>value</code>.
   * 
   * @param name The name of this boolean attribute.
   * @param mdAttributeKey key of the defining attribute metadata
   * @param definingEntityType The class that defines this attribute.
   * @param value The value of this boolean. "<code>true</code>" or "<code>false</code>"
   */
  public AttributeBoolean(String name, String mdAttributeKey, String definingEntityType, String value)
  {
    super(name, mdAttributeKey, definingEntityType);

    if ( !( value.trim().length() == 0 ))
    {
      String formattedValue = formatAndValidate(value);
      this.value = formatAndValidate(formattedValue);
    }
  }

  /**
   * Tests the string value of the bolean, and returns a primitive
   * <code><b>boolean</b></code>.
   * 
   * @return <code><b>true</b></code> if the boolean attribute is MdAttributeBooleanIF.TRUE
   */
  public boolean isTrue()
  {  
    if (this.value.equals("1"))
    {
      return true;
    }
    return false;
  }

  /**
   * Tests the string value of the bolean, and returns a primitive
   * <code><b>boolean</b></code>.  Equivalent to <code>!value</code>.
   * 
   * @return <code><b>true</b></code> if the boolean attribute is MdAttributeBooleanIF.FALSE
   */
  public boolean isFalse()
  {
    if (this.value.equals("0"))
    {
      return false;
    }
    return true;
  }

  /**
   * Returns the boolean value of this attribute.
   * @return boolean value of this attribute.
   */
  public boolean getBooleanValue()
  {
    if (this.value.equals("1"))
    {
      return true;
    }
    return false;
  }
  
  /**
   * @see com.runwaysdk.dataaccess.attributes.entity.Attribute#setValue(java.lang.String)
   */
  public void setValue(boolean value)
  {
    if (value)
    {
      this.setValue(MdAttributeBooleanInfo.TRUE);
    }
    else
    {
      this.setValue(MdAttributeBooleanInfo.FALSE);
    }
  }
  
  /**
   * Calls toLowerCase on the String before passing it back to the overridden abstract
   * parent method.
   * 
   * @see com.runwaysdk.dataaccess.attributes.entity.Attribute#setValue(java.lang.String)
   */
  public void setValue(String value)
  {
    super.setValue(MdAttributeBooleanUtil.format(value));
  }

  /**
   * Returns the formatted value of the attribute.  Some attributes format
   * this value to something other than what is stored in the database.
   * 
   * <br>
   * <b>Precondition: </b> true <br>
   * <b>Postcondition: </b> return value != null
   * 
   * @return value of the attribute.
   */
  public String getValue()
  {
    return MdAttributeBooleanUtil.convertIntToString(this.value);
  }

  /**
   * Test if the input String is valid as a value in an AttributeBoolen (either MdAttributeBooleanIF.TRUE or
   * MdAttributeBooleanIF.FALSE).
   * 
   * <br/><b>Precondition: </b> valueToValidate != null 
   * <br/><b>Postcondition: </b> true
   * 
   * @param valueToValidate the primitive attribute value to be validated
   * @param mdAttribute the defining Metadata object of the class that contains this
   *          Attribute
   */
  protected void validate(String valueToValidate, MdAttributeDAOIF mdAttribute)
  {
    super.validate(valueToValidate, mdAttribute);
    if (!validateValue(valueToValidate))
    {
      String error = "[" + valueToValidate + "] is an invalid value for the Boolean attribute ["
          + getName() + "] on type [" + getDefiningClassType() + "].";
      throw new AttributeValueException(error, this, value);
    }
  }

  
  /**
   * Test if the input String is valid as a value in an AttributeBoolen (either MdAttributeBooleanIF.TRUE,
   * MdAttributeBooleanIF.FALSE, 1, or 0).
   * 
   * <br/><b>Precondition: </b> valueToValidate != null 
   * <br/><b>Postcondition: </b> true
   * 
   * @param valueToValidate the primitive attribute value to be validated
   */
  public static void validate(String valueToValidate)
  {
    if (!validateValue(valueToValidate))
    {
      String error = "[" + valueToValidate + "] is an invalid value for Boolean attributes";
      throw new AttributeValueException(error, valueToValidate);
    }
  }
  
  public static boolean validateValue(String valueToValidate)
  {
    if (!valueToValidate.equalsIgnoreCase(MdAttributeBooleanInfo.TRUE) && 
        !valueToValidate.equals("1") && 
        !valueToValidate.equalsIgnoreCase(MdAttributeBooleanInfo.FALSE) &&
        !valueToValidate.equals("0") &&
        !valueToValidate.equals(""))
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  
  public static String formatAndValidate(String value)
  {
    validate(value);
    return MdAttributeBooleanUtil.format(value);
  }
  
  /**
   *Returns true if the given attributeBoolean is MdAttributeBooleanIF.TRUE, false if the value is MdAttributeBooleanIF.FALSE
   *
   * <br/><b>Precondition: </b> attributeBoolean.getValue().equalsIgnoreCase(MdAttributeBooleanIF.TRUE) ||
   *                            attributeBoolean.getValue().equalsIgnoreCase(MdAttributeBooleanIF.FALSE)
   *
   * @param attributeBoolean boolean attribute object
   * @return
   */
  public static boolean getBooleanValue(AttributeBooleanIF attributeBoolean)
  {
    if (attributeBoolean.isTrue())
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  /**
   *Returns 1 if the given attributeBoolean is true, 0.
   *
   * @param attributeBoolean boolean attribute object
   * @return 1 if the given attributeBoolean is true, 0.
   */
  public static int getBooleanValueInt(AttributeBooleanIF attributeBoolean)
  {
    return attributeBoolean.getBooleanValueInt();
  }
  
  /**
   *Returns 1 if the given attributeBoolean is true, 0.
   *
   * @return 1 if the given attributeBoolean is true, 0.
   */
  public int getBooleanValueInt()
  {
    return Integer.parseInt(this.value);
  }
  
  /**
   * Returns a deep clone of this attribute.
   * 
   * <br/><b>Precondition: </b> true <br/><b>Postcondition: </b> true
   * 
   * @return a deep clone of this Attribute
   */
  public AttributeBoolean attributeClone()
  {
    return new AttributeBoolean(this.getName(), this.mdAttributeKey, this.getDefiningClassType(),  new String(this.getRawValue()));
  }

}
