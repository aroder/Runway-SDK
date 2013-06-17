/**
*
*/
package com.runwaysdk.format;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

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
public class LocalizedFormatTest extends AbstractFormatTest
{
  
  public static Test suite()
  {
    TestSuite suite = new TestSuite(LocalizedFormatTest.class.getSimpleName());
    suite.addTestSuite(LocalizedFormatTest.class);
    
    TestSetup wrapper = new TestSetup(suite)
    {
      protected void setUp()
      {
        classSetUp();
      }

      protected void tearDown()
      {
        classTearDown();
      }
    };

    return wrapper;
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getLocale()
   */
  @Override
  protected Locale getLocale()
  {
    return Locale.GERMANY;
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getIntegerObject()
   */
  @Override
  protected Integer getIntegerObject()
  {
    return new Integer(4500);
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getIntegerString()
   */
  @Override
  protected String getIntegerString()
  {
    return "4.500";
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getLongObject()
   */
  @Override
  protected Long getLongObject()
  {
    return new Long(989999000);
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getLongString()
   */
  @Override
  protected String getLongString()
  {
    return "989.999.000";
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getDecimalObject()
   */
  @Override
  protected BigDecimal getDecimalObject()
  {
    return new BigDecimal("207913490.101");
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getDecimalString()
   */
  @Override
  protected String getDecimalString()
  {
    return "207.913.490,101";
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getDoubleObject()
   */
  @Override
  protected Double getDoubleObject()
  {
    return new Double("714104.008");
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getDoubleString()
   */
  @Override
  protected String getDoubleString()
  {
    return "714.104,008";
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getFloatObject()
   */
  @Override
  protected Float getFloatObject()
  {
    return new Float("2507.123");
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getFloatString()
   */
  @Override
  protected String getFloatString()
  {
    return "2.507,123";
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getDateObject()
   */
  @Override
  protected Date getDateObject()
  {
    Calendar cal = Calendar.getInstance();
    cal.set(1984, 4, 17, 10, 9, 8);
    
    return cal.getTime();
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.format.FormatTest#getDateString()
   */
  @Override
  protected String getDateString()
  {
    return "1984-05-17 10:09:08";
  }

}
