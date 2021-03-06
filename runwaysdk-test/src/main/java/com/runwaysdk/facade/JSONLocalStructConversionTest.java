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
package com.runwaysdk.facade;

import java.util.Locale;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.json.JSONObject;

import com.runwaysdk.DoNotWeave;
import com.runwaysdk.business.BusinessDTO;
import com.runwaysdk.business.LocalStructDTO;
import com.runwaysdk.constants.CommonProperties;
import com.runwaysdk.constants.MdAttributeLocalInfo;
import com.runwaysdk.dataaccess.MdLocalStructDAOIF;
import com.runwaysdk.dataaccess.io.TestFixtureFactory;
import com.runwaysdk.dataaccess.metadata.MdAttributeLocalCharacterDAO;
import com.runwaysdk.dataaccess.metadata.MdAttributeTermDAO;
import com.runwaysdk.dataaccess.metadata.MdBusinessDAO;
import com.runwaysdk.dataaccess.metadata.MdTermDAO;
import com.runwaysdk.session.Request;
import com.runwaysdk.transport.conversion.json.ComponentDTOIFToJSON;
import com.runwaysdk.transport.conversion.json.JSONUtil;

public class JSONLocalStructConversionTest extends TestCase implements DoNotWeave
{
  private static MdBusinessDAO                mdBusiness;

  private static MdAttributeLocalCharacterDAO mdAttributeLocalCharacter;

  private static MdAttributeTermDAO           mdAttributeTerm;

  private static MdLocalStructDAOIF           mdLocalStruct;

  private static MdTermDAO                    mdTerm;

  protected String                            sessionId;

  protected static Locale                     locale = CommonProperties.getDefaultLocale();

  public static Test suite()
  {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(JSONLocalStructConversionTest.class);

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

  @Request
  public static void classSetUp()
  {
    mdTerm = TestFixtureFactory.createMdTerm();
    mdTerm.apply();

    mdBusiness = TestFixtureFactory.createMdBusiness1();
    mdBusiness.apply();

    mdAttributeLocalCharacter = TestFixtureFactory.addLocalCharacterAttribute(mdBusiness);
    mdAttributeLocalCharacter.apply();

    mdAttributeTerm = TestFixtureFactory.addTermAttribute(mdBusiness, mdTerm);
    mdAttributeTerm.apply();

    mdLocalStruct = mdAttributeLocalCharacter.getMdStructDAOIF();
  }

  @Request
  public static void classTearDown()
  {
    TestFixtureFactory.delete(mdAttributeLocalCharacter);
    TestFixtureFactory.delete(mdBusiness);
  }

  @Override
  protected void setUp() throws Exception
  {
    this.sessionId = Facade.login("SYSTEM", "SYSTEM", new Locale[] { ( Locale.US ) });
  }

  @Override
  protected void tearDown() throws Exception
  {
    Facade.logout(this.sessionId);
  }

  public void testNewLocalStruct() throws Exception
  {
    LocalStructDTO source = (LocalStructDTO) Facade.newMutable(sessionId, mdLocalStruct.definesType());
    source.setValue("Test Local Value");

    JSONObject json = ComponentDTOIFToJSON.getConverter(source).populate();
    LocalStructDTO test = (LocalStructDTO) JSONUtil.getComponentDTOFromJSON(this.sessionId, locale, json.toString());

    assertEquals(source.getType(), test.getType());
    assertEquals(source.getValue(), test.getValue());
    assertEquals(source.isNewInstance(), test.isNewInstance());
    assertEquals(source.getId(), test.getId());
  }

  public void testAppliedLocalStruct() throws Exception
  {
    LocalStructDTO source = (LocalStructDTO) Facade.newMutable(sessionId, mdLocalStruct.definesType());
    source.setValue("Update Local Value");

    // Create the struct
    source = (LocalStructDTO) Facade.createStruct(this.sessionId, source);

    try
    {
      JSONObject json = ComponentDTOIFToJSON.getConverter(source).populate();
      LocalStructDTO test = (LocalStructDTO) JSONUtil.getComponentDTOFromJSON(this.sessionId, locale, json.toString());

      assertEquals(source.getType(), test.getType());
      assertEquals(source.getValue(), test.getValue());
      assertEquals(source.isNewInstance(), test.isNewInstance());
      assertEquals(source.getId(), test.getId());
    }
    finally
    {
      Facade.delete(this.sessionId, source.getId());
    }
  }

  public void testLocalStructAttribute() throws Exception
  {
    String attributeName = mdAttributeLocalCharacter.definesAttribute();
    BusinessDTO source = (BusinessDTO) Facade.newMutable(sessionId, mdBusiness.definesType());

    JSONObject json = ComponentDTOIFToJSON.getConverter(source).populate();
    BusinessDTO test = (BusinessDTO) JSONUtil.getComponentDTOFromJSON(this.sessionId, locale, json.toString());

    assertTrue(source.hasAttribute(attributeName));
    assertTrue(test.hasAttribute(attributeName));

    assertEquals(source.getAttributeType(attributeName), test.getAttributeType(attributeName));

    String sourceValue = source.getStructValue(mdAttributeLocalCharacter.definesAttribute(), MdAttributeLocalInfo.DEFAULT_LOCALE);
    String testValue = test.getStructValue(mdAttributeLocalCharacter.definesAttribute(), MdAttributeLocalInfo.DEFAULT_LOCALE);

    assertEquals(sourceValue, testValue);
  }

  public void testAppliedLocalStructAttribute() throws Exception
  {
    String attributeName = mdAttributeLocalCharacter.definesAttribute();
    BusinessDTO source = (BusinessDTO) Facade.newMutable(sessionId, mdBusiness.definesType());
    source.setStructValue(attributeName, MdAttributeLocalInfo.DEFAULT_LOCALE, "My Value");

    source = Facade.createBusiness(this.sessionId, source);

    try
    {

      JSONObject json = ComponentDTOIFToJSON.getConverter(source).populate();
      BusinessDTO test = (BusinessDTO) JSONUtil.getComponentDTOFromJSON(this.sessionId, locale, json.toString());

      assertTrue(source.hasAttribute(attributeName));
      assertTrue(test.hasAttribute(attributeName));

      assertEquals(source.getAttributeType(attributeName), test.getAttributeType(attributeName));

      String sourceValue = source.getStructValue(attributeName, MdAttributeLocalInfo.DEFAULT_LOCALE);
      String testValue = test.getStructValue(attributeName, MdAttributeLocalInfo.DEFAULT_LOCALE);

      assertEquals(sourceValue, testValue);
    }
    finally
    {
      Facade.delete(this.sessionId, source.getId());
    }
  }

  public void testTerm() throws Exception
  {
    BusinessDTO term = (BusinessDTO) Facade.newMutable(sessionId, mdTerm.definesType());
    term = Facade.createBusiness(this.sessionId, term);

    try
    {

      String attributeName = mdAttributeTerm.definesAttribute();

      BusinessDTO source = (BusinessDTO) Facade.newMutable(sessionId, mdBusiness.definesType());
      source.setValue(attributeName, term.getId());
      source = Facade.createBusiness(this.sessionId, source);

      try
      {
        JSONObject json = ComponentDTOIFToJSON.getConverter(source).populate();
        BusinessDTO test = (BusinessDTO) JSONUtil.getComponentDTOFromJSON(this.sessionId, locale, json.toString());

        assertTrue(source.hasAttribute(attributeName));
        assertTrue(test.hasAttribute(attributeName));

        assertEquals(source.getAttributeType(attributeName), test.getAttributeType(attributeName));

        String sourceValue = source.getValue(attributeName);
        String testValue = test.getValue(attributeName);

        assertEquals(sourceValue, testValue);
      }
      finally
      {
        Facade.delete(this.sessionId, source.getId());
      }
    }
    finally
    {
      Facade.delete(this.sessionId, term.getId());
    }
  }

}
