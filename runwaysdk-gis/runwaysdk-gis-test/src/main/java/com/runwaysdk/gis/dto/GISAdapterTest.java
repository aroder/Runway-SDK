/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Runway SDK GIS(tm).
 *
 * Runway SDK GIS(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Runway SDK GIS(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Runway SDK GIS(tm).  If not, see <http://www.gnu.org/licenses/>.
 */
package com.runwaysdk.gis.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.runwaysdk.ClientSession;
import com.runwaysdk.DoNotWeave;
import com.runwaysdk.business.BusinessDTO;
import com.runwaysdk.business.rbac.Operation;
import com.runwaysdk.constants.ClientRequestIF;
import com.runwaysdk.constants.CommonProperties;
import com.runwaysdk.constants.ServerConstants;
import com.runwaysdk.constants.TypeGeneratorInfo;
import com.runwaysdk.constants.UserInfo;
import com.runwaysdk.generation.loader.LoaderDecorator;
import com.runwaysdk.gis.AttributeLineStringParseExceptionDTO;
import com.runwaysdk.gis.AttributeMultiLineStringParseExceptionDTO;
import com.runwaysdk.gis.AttributeMultiPointParseExceptionDTO;
import com.runwaysdk.gis.AttributeMultiPolygonParseExceptionDTO;
import com.runwaysdk.gis.AttributePointParseExceptionDTO;
import com.runwaysdk.gis.AttributePolygonParseExceptionDTO;
import com.runwaysdk.gis.GISAbstractTest;
import com.runwaysdk.gis.GISMasterTestSetup;
import com.runwaysdk.session.AttributeReadPermissionExceptionDTO;
import com.runwaysdk.session.AttributeWritePermissionExceptionDTO;
import com.runwaysdk.session.Request;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.WKTReader;

public class GISAdapterTest extends GISAbstractTest implements DoNotWeave
{
  protected static BusinessDTO     tommyUser     = null;

  protected static ClientSession   systemSession = null;

  protected static ClientRequestIF clientRequest = null;

  @BeforeClass
  public static void classSetUp()
  {
    systemSession = ClientSession.createUserSession("default", ServerConstants.SYSTEM_USER_NAME, ServerConstants.SYSTEM_DEFAULT_PASSWORD, new Locale[] { CommonProperties.getDefaultLocale() });
    clientRequest = systemSession.getRequest();

    tommyUser = clientRequest.newBusiness(UserInfo.CLASS);
    tommyUser.setValue(UserInfo.USERNAME, "Tommy");
    tommyUser.setValue(UserInfo.PASSWORD, "music");
    clientRequest.createBusiness(tommyUser);
  }

  @AfterClass
  public static void classTearDown()
  {
    clientRequest.delete(tommyUser.getId());

    systemSession.logout();
  }

  protected ClientSession createSession(String userName, String password)
  {
    return ClientSession.createUserSession("default", userName, password, new Locale[] { CommonProperties.getDefaultLocale() });
  }

  protected ClientRequestIF getRequest(ClientSession clientSession)
  {
    return clientSession.getRequest();
  }

  /**
  *
  */
  @Test
  @Request
  public void testPointCRUDTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    GeometryFactory geometryFactory = new GeometryFactory();

    try
    {
      Point point = geometryFactory.createPoint(new Coordinate(191232, 243118));
      businessDTO.setValue("testPoint", point);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      point = (Point) businessDTO.getObjectValue("testPoint");

      assertEquals("X Coordinate on the point was not the expected value.", 191232d, point.getX(), 0.001);
      assertEquals("Y Coordinate on the point was not the expected value.", 243118d, point.getY(), 0.001);

      tommyRequest.lock(businessDTO);
      point = geometryFactory.createPoint(new Coordinate(191108, 243242));
      businessDTO.setValue("testPoint", point);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      point = (Point) businessDTO.getObjectValue("testPoint");

      assertEquals("X Coordinate on the point was not the expected value.", 191108d, point.getX(), 0.001);
      assertEquals("Y Coordinate on the point was not the expected value.", 243242d, point.getY(), 0.001);
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());
    }
  }

  /**
 *
 */
  public void testLineStringCRUDTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    GeometryFactory geometryFactory = new GeometryFactory();

    try
    {
      LineString lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(191232, 243118), new Coordinate(191108, 243242) });
      businessDTO.setValue("testLineString", lineString);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      LineString newLineString = (LineString) businessDTO.getObjectValue("testLineString");

      assertTrue("Returned LineString from the database does not match the LineString that was set on the object.", lineString.equalsExact(newLineString));

      tommyRequest.lock(businessDTO);
      lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(189141, 244158), new Coordinate(189265, 244817) });
      businessDTO.setValue("testLineString", lineString);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      newLineString = (LineString) businessDTO.getObjectValue("testLineString");

      assertTrue("Returned LineString from the database does not match the LineString that was set on the object.", lineString.equalsExact(newLineString));
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());
    }
  }

  public void testPolygonCRUDTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      String polygonText1 = "POLYGON (( 10 10, 10 20, 20 20, 20 15, 10 10))";

      WKTReader reader = new WKTReader();
      Polygon polygon = (Polygon) reader.read(polygonText1);

      businessDTO.setValue("testPolygon", polygon);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      Polygon newPolygon = (Polygon) businessDTO.getObjectValue("testPolygon");

      assertTrue("Returned Polygon from the database does not match the Polygon that was set on the object.", polygon.equalsExact(newPolygon));

      tommyRequest.lock(businessDTO);

      String polygonText2 = "POLYGON (( 10 10, 15 25, 40 40, 30 25, 10 10))";
      polygon = (Polygon) reader.read(polygonText2);

      businessDTO.setValue("testPolygon", polygon);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      newPolygon = (Polygon) businessDTO.getObjectValue("testPolygon");

      assertTrue("Returned Polygon from the database does not match the Polygon that was set on the object.", polygon.equalsExact(newPolygon));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());
    }
  }

  public void testMultiPointCRUDTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      String multiPointText1 = "MULTIPOINT(191232 243118, 10000 20000)";

      WKTReader reader = new WKTReader();
      MultiPoint multiPoint = (MultiPoint) reader.read(multiPointText1);

      businessDTO.setValue("testMultiPoint", multiPoint);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiPoint newMultiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");

      assertTrue("Returned MultiPoint from the database does not match the MultiPoint that was set on the object.", multiPoint.equalsExact(newMultiPoint));

      tommyRequest.lock(businessDTO);

      String polygonText2 = "MULTIPOINT(191108 243242, 30000 40000)";
      multiPoint = (MultiPoint) reader.read(polygonText2);

      businessDTO.setValue("testMultiPoint", multiPoint);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      newMultiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");

      assertTrue("Returned MultiPoint from the database does not match the MultiPoint that was set on the object.", multiPoint.equalsExact(newMultiPoint));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());
    }
  }

  public void testMultiLineStringCRUDTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      String multiLineStringText1 = "MULTILINESTRING ((191232 243118, 191108 243242, 200000 250000, 275000 300000))";

      WKTReader reader = new WKTReader();
      MultiLineString multiLineString = (MultiLineString) reader.read(multiLineStringText1);

      businessDTO.setValue("testMultiLineString", multiLineString);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiLineString newMultiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");

      assertTrue("Returned MultiLineString from the database does not match the MultiLineString that was set on the object.", multiLineString.equalsExact(newMultiLineString));

      tommyRequest.lock(businessDTO);

      String polygonText2 = "MULTILINESTRING ((189141 244158, 189265 244817, 100000 150000, 175000 200000))";
      multiLineString = (MultiLineString) reader.read(polygonText2);

      businessDTO.setValue("testMultiLineString", multiLineString);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      newMultiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");

      assertTrue("Returned MultiLineString from the database does not match the MultiLineString that was set on the object.", multiLineString.equalsExact(newMultiLineString));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());
    }
  }

  public void testMultiPolygonCRUDTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      String multiPolygon1 = "MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2, 3 2, 3 3, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";

      WKTReader reader = new WKTReader();
      MultiPolygon multiPolygon = (MultiPolygon) reader.read(multiPolygon1);

      businessDTO.setValue("testMultiPolygon", multiPolygon);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiPolygon newMultiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");

      assertTrue("Returned MultiPolygon from the database does not match the MultiPolygon that was set on the object.", multiPolygon.equalsExact(newMultiPolygon));

      tommyRequest.lock(businessDTO);

      String multiPolyton2 = "MULTIPOLYGON(((1 1,5 1,10 10,1 5,1 1),(2 2, 3 2, 6 6, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";
      multiPolygon = (MultiPolygon) reader.read(multiPolyton2);

      businessDTO.setValue("testMultiPolygon", multiPolygon);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      newMultiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");

      assertTrue("Returned MultiPolygon from the database does not match the MultiPolygon that was set on the object.", multiPolygon.equalsExact(newMultiPolygon));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
 *
 */
  public void testPointCRUDTypeUnsafe_WKT()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testPoint", "POINT(191232 243118)");
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      Point point = (Point) businessDTO.getObjectValue("testPoint");

      assertEquals("X Coordinate on the point was not the expected value.", 191232d, point.getX());
      assertEquals("Y Coordinate on the point was not the expected value.", 243118d, point.getY());

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testPoint", "POINT(191108 243242)");
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      point = (Point) businessDTO.getObjectValue("testPoint");

      assertEquals("X Coordinate on the point was not the expected value.", 191108d, point.getX());
      assertEquals("Y Coordinate on the point was not the expected value.", 243242d, point.getY());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testLineStringCRUDTypeUnsafe_WKT()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      String lineStringText1 = "LINESTRING (191232 243118, 191108 243242)";
      businessDTO.setValue("testLineString", lineStringText1);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      LineString lineString = (LineString) businessDTO.getObjectValue("testLineString");

      WKTReader reader = new WKTReader();
      LineString expectedLine = (LineString) reader.read(lineStringText1);

      assertTrue("LineString was not the expected value.", expectedLine.equalsExact(lineString));

      String lineStringText2 = "LINESTRING (189141 244158, 189265 244817)";

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testLineString", lineStringText2);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      lineString = (LineString) businessDTO.getObjectValue("testLineString");

      expectedLine = (LineString) reader.read(lineStringText2);

      assertTrue("LineString was not the expected value.", expectedLine.equalsExact(lineString));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testPolygonCRUDTypeUnsafe_WKT()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      String polygonText1 = "POLYGON (( 10 10, 10 20, 20 20, 20 15, 10 10))";
      businessDTO.setValue("testPolygon", polygonText1);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      Polygon polygon = (Polygon) businessDTO.getObjectValue("testPolygon");

      WKTReader reader = new WKTReader();
      Polygon expectedPolygon = (Polygon) reader.read(polygonText1);

      assertTrue("Polygon was not the expected value.", expectedPolygon.equalsExact(polygon));

      String polygonText2 = "POLYGON (( 10 10, 15 25, 40 40, 30 25, 10 10))";

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testPolygon", polygonText2);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      polygon = (Polygon) businessDTO.getObjectValue("testPolygon");

      expectedPolygon = (Polygon) reader.read(polygonText2);

      assertTrue("Polygon was not the expected value.", expectedPolygon.equalsExact(polygon));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testMultiPointCRUDTypeUnsafe_WKT()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      String multiPointText1 = "MULTIPOINT(191232 243118, 10000 20000)";
      businessDTO.setValue("testMultiPoint", multiPointText1);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiPoint multiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");

      WKTReader reader = new WKTReader();
      MultiPoint expectedMultiPoint = (MultiPoint) reader.read(multiPointText1);

      assertTrue("MultiPoint was not the expected value.", expectedMultiPoint.equalsExact(multiPoint));

      String multiPointText2 = "MULTIPOINT(191108 243242, 30000 40000)";

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testMultiPoint", multiPointText2);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      multiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");

      expectedMultiPoint = (MultiPoint) reader.read(multiPointText2);

      assertTrue("MultiPoint was not the expected value.", expectedMultiPoint.equalsExact(multiPoint));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testMultiLineStringCRUDTypeUnsafe_WKT()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      String multiLineStringText1 = "MULTILINESTRING ((191232 243118, 191108 243242, 200000 250000, 275000 300000))";
      businessDTO.setValue("testMultiLineString", multiLineStringText1);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiLineString multiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");

      WKTReader reader = new WKTReader();
      MultiLineString expectedMultiLineString = (MultiLineString) reader.read(multiLineStringText1);

      assertTrue("MultiLineString was not the expected value.", expectedMultiLineString.equalsExact(multiLineString));

      String multiLineStringText2 = "MULTILINESTRING ((189141 244158, 189265 244817, 100000 150000, 175000 200000))";

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testMultiLineString", multiLineStringText2);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      multiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");

      expectedMultiLineString = (MultiLineString) reader.read(multiLineStringText2);

      assertTrue("MultiLineString was not the expected value.", expectedMultiLineString.equalsExact(multiLineString));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testMultiPolygonCRUDTypeUnsafe_WKT()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      String multiPolygonText1 = "MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2, 3 2, 3 3, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";
      businessDTO.setValue("testMultiPolygon", multiPolygonText1);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiPolygon multiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");

      WKTReader reader = new WKTReader();
      MultiPolygon expectedMultiPolygon = (MultiPolygon) reader.read(multiPolygonText1);

      assertTrue("MultiPolygon was not the expected value.", expectedMultiPolygon.equalsExact(multiPolygon));

      String multiPolygonText2 = "MULTIPOLYGON(((1 1,5 1,10 10,1 5,1 1),(2 2, 3 2, 6 6, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testMultiPolygon", multiPolygonText2);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      multiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");

      expectedMultiPolygon = (MultiPolygon) reader.read(multiPolygonText2);

      assertTrue("MultiPolygon was not the expected value.", expectedMultiPolygon.equalsExact(multiPolygon));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
 *
 */
  public void testPointCRUDTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      GeometryFactory geometryFactory = new GeometryFactory();
      Point point = geometryFactory.createPoint(new Coordinate(191232, 243118));

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestPoint", Point.class).invoke(businessDTO, point);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      point = (Point) testClass.getMethod("getTestPoint").invoke(businessDTO);

      assertEquals("X Coordinate on the point was not the expected value.", 191232d, point.getX());
      assertEquals("Y Coordinate on the point was not the expected value.", 243118d, point.getY());

      testClass.getMethod("lock").invoke(businessDTO);

      point = geometryFactory.createPoint(new Coordinate(191108, 243242));

      testClass.getMethod("setTestPoint", Point.class).invoke(businessDTO, point);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      point = (Point) testClass.getMethod("getTestPoint").invoke(businessDTO);

      assertEquals("X Coordinate on the point was not the expected value.", 191108d, point.getX());
      assertEquals("Y Coordinate on the point was not the expected value.", 243242d, point.getY());
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testLineStringCRUDTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      GeometryFactory geometryFactory = new GeometryFactory();
      LineString lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(191232, 243118), new Coordinate(191108, 243242) });

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestLineString", LineString.class).invoke(businessDTO, lineString);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      LineString newLineString = (LineString) testClass.getMethod("getTestLineString").invoke(businessDTO);

      assertTrue("Returned LineString from the database does not match the LineString that was set on the object.", lineString.equalsExact(newLineString));

      testClass.getMethod("lock").invoke(businessDTO);

      lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(189141, 244158), new Coordinate(189265, 244817) });

      testClass.getMethod("setTestLineString", LineString.class).invoke(businessDTO, lineString);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      newLineString = (LineString) testClass.getMethod("getTestLineString").invoke(businessDTO);

      assertTrue("Returned LineString from the database does not match the LineString that was set on the object.", lineString.equalsExact(newLineString));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testPolygonCRUDTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      String polygonText1 = "POLYGON (( 10 10, 10 20, 20 20, 20 15, 10 10))";

      WKTReader reader = new WKTReader();
      Polygon polygon = (Polygon) reader.read(polygonText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestPolygon", Polygon.class).invoke(businessDTO, polygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      Polygon newPolygon = (Polygon) testClass.getMethod("getTestPolygon").invoke(businessDTO);

      assertTrue("Returned Polygon from the database does not match the Polygon that was set on the object.", polygon.equalsExact(newPolygon));

      testClass.getMethod("lock").invoke(businessDTO);

      String polygonText2 = "POLYGON (( 10 10, 15 25, 40 40, 30 25, 10 10))";
      polygon = (Polygon) reader.read(polygonText2);

      testClass.getMethod("setTestPolygon", Polygon.class).invoke(businessDTO, polygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      newPolygon = (Polygon) testClass.getMethod("getTestPolygon").invoke(businessDTO);

      assertTrue("Returned Polygon from the database does not match the Polygon that was set on the object.", polygon.equalsExact(newPolygon));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testMultiPointCRUDTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      String multiPointText1 = "MULTIPOINT(191232 243118, 10000 20000)";

      WKTReader reader = new WKTReader();
      MultiPoint multiPoint = (MultiPoint) reader.read(multiPointText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiPoint", MultiPoint.class).invoke(businessDTO, multiPoint);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiPoint newMultiPoint = (MultiPoint) testClass.getMethod("getTestMultiPoint").invoke(businessDTO);

      assertTrue("Returned MultiPoint from the database does not match the MultiPoint that was set on the object.", multiPoint.equalsExact(newMultiPoint));

      testClass.getMethod("lock").invoke(businessDTO);

      String polygonText2 = "MULTIPOINT(191108 243242, 30000 40000)";
      multiPoint = (MultiPoint) reader.read(polygonText2);

      testClass.getMethod("setTestMultiPoint", MultiPoint.class).invoke(businessDTO, multiPoint);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      newMultiPoint = (MultiPoint) testClass.getMethod("getTestMultiPoint").invoke(businessDTO);

      assertTrue("Returned MultiPoint from the database does not match the MultiPoint that was set on the object.", multiPoint.equalsExact(newMultiPoint));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testMultiLineStringCRUDTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      String multiPointText1 = "MULTILINESTRING ((191232 243118, 191108 243242, 200000 250000, 275000 300000))";

      WKTReader reader = new WKTReader();
      MultiLineString multiLineString = (MultiLineString) reader.read(multiPointText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiLineString", MultiLineString.class).invoke(businessDTO, multiLineString);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiLineString newMultiLineString = (MultiLineString) testClass.getMethod("getTestMultiLineString").invoke(businessDTO);

      assertTrue("Returned MultiLineString from the database does not match the MultiLineString that was set on the object.", multiLineString.equalsExact(newMultiLineString));

      testClass.getMethod("lock").invoke(businessDTO);

      String polygonText2 = "MULTILINESTRING ((189141 244158, 189265 244817, 100000 150000, 175000 200000))";
      multiLineString = (MultiLineString) reader.read(polygonText2);

      testClass.getMethod("setTestMultiLineString", MultiLineString.class).invoke(businessDTO, multiLineString);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      newMultiLineString = (MultiLineString) testClass.getMethod("getTestMultiLineString").invoke(businessDTO);

      assertTrue("Returned MultiLineString from the database does not match the MultiLineString that was set on the object.", multiLineString.equalsExact(newMultiLineString));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testMultiPolygonCRUDTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      String multiPointText1 = "MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2, 3 2, 3 3, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";

      WKTReader reader = new WKTReader();
      MultiPolygon multiPolygon = (MultiPolygon) reader.read(multiPointText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiPolygon", MultiPolygon.class).invoke(businessDTO, multiPolygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiPolygon newMultiPolygon = (MultiPolygon) testClass.getMethod("getTestMultiPolygon").invoke(businessDTO);

      assertTrue("Returned MultiPolygon from the database does not match the MultiPolygon that was set on the object.", multiPolygon.equalsExact(newMultiPolygon));

      testClass.getMethod("lock").invoke(businessDTO);

      String polygonText2 = "MULTIPOLYGON(((1 1,5 1,10 10,1 5,1 1),(2 2, 3 2, 6 6, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";
      multiPolygon = (MultiPolygon) reader.read(polygonText2);

      testClass.getMethod("setTestMultiPolygon", MultiPolygon.class).invoke(businessDTO, multiPolygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      newMultiPolygon = (MultiPolygon) testClass.getMethod("getTestMultiPolygon").invoke(businessDTO);

      assertTrue("Returned MultiPolygon from the database does not match the MultiPolygon that was set on the object.", multiPolygon.equalsExact(newMultiPolygon));
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testPointInvalidReadPermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      GeometryFactory geometryFactory = new GeometryFactory();
      Point point = geometryFactory.createPoint(new Coordinate(191232, 243118));

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestPoint", Point.class).invoke(businessDTO, point);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      point = (Point) testClass.getMethod("getTestPoint").invoke(businessDTO);

      assertEquals("User does not have adequate read permissions, yet was able to retreive the point.", null, point);
    }
    catch (Throwable e)
    {
      if (e instanceof InvocationTargetException)
      {
        InvocationTargetException inv = (InvocationTargetException) e;
        Throwable cause = inv.getCause();

        if (cause instanceof AttributeReadPermissionExceptionDTO)
        {
          // this is expected
        }
        else
        {
          fail(cause.getMessage());
        }
      }
      else
      {
        fail(e.getMessage());
      }
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
    }
  }

  /**
*
*/
  public void testLineStringInvalidReadPermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      GeometryFactory geometryFactory = new GeometryFactory();
      LineString lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(191232, 243118), new Coordinate(191108, 243242) });

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestLineString", LineString.class).invoke(businessDTO, lineString);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      lineString = (LineString) testClass.getMethod("getTestLineString").invoke(businessDTO);

      assertEquals("User does not have adequate read permissions, yet was able to retreive the LineString.", null, lineString);
    }
    catch (Throwable e)
    {
      if (e instanceof InvocationTargetException)
      {
        InvocationTargetException inv = (InvocationTargetException) e;
        Throwable cause = inv.getCause();

        if (cause instanceof AttributeReadPermissionExceptionDTO)
        {
          // this is expected
        }
        else
        {
          fail(cause.getMessage());
        }
      }
      else
      {
        fail(e.getMessage());
      }
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
    }
  }

  /**
*
*/
  public void testPolygonInvalidReadPermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      String polygonText1 = "POLYGON (( 10 10, 10 20, 20 20, 20 15, 10 10))";

      WKTReader reader = new WKTReader();
      Polygon polygon = (Polygon) reader.read(polygonText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestPolygon", Polygon.class).invoke(businessDTO, polygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      polygon = (Polygon) testClass.getMethod("getTestPolygon").invoke(businessDTO);

      assertEquals("User does not have adequate read permissions, yet was able to retreive the Polygon.", null, polygon);
    }
    catch (Throwable e)
    {
      if (e instanceof InvocationTargetException)
      {
        InvocationTargetException inv = (InvocationTargetException) e;
        Throwable cause = inv.getCause();

        if (cause instanceof AttributeReadPermissionExceptionDTO)
        {
          // this is expected
        }
        else
        {
          fail(cause.getMessage());
        }
      }
      else
      {
        fail(e.getMessage());
      }
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
    }
  }

  /**
*
*/
  public void testMultiPointInvalidReadPermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      String multiPointText1 = "MULTIPOINT(191232 243118, 10000 20000)";

      WKTReader reader = new WKTReader();
      MultiPoint multiPoint = (MultiPoint) reader.read(multiPointText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiPoint", MultiPoint.class).invoke(businessDTO, multiPoint);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      multiPoint = (MultiPoint) testClass.getMethod("getTestMultiPoint").invoke(businessDTO);

      assertEquals("User does not have adequate read permissions, yet was able to retreive the MultiPoint.", null, multiPoint);
    }
    catch (Throwable e)
    {
      if (e instanceof InvocationTargetException)
      {
        InvocationTargetException inv = (InvocationTargetException) e;
        Throwable cause = inv.getCause();

        if (cause instanceof AttributeReadPermissionExceptionDTO)
        {
          // this is expected
        }
        else
        {
          fail(cause.getMessage());
        }
      }
      else
      {
        fail(e.getMessage());
      }
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
    }
  }

  /**
*
*/
  public void testMultiLineStringInvalidReadPermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      String multiLineStringText1 = "MULTILINESTRING ((191232 243118, 191108 243242, 200000 250000, 275000 300000))";

      WKTReader reader = new WKTReader();
      MultiLineString multiPoint = (MultiLineString) reader.read(multiLineStringText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiLineString", MultiLineString.class).invoke(businessDTO, multiPoint);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      multiPoint = (MultiLineString) testClass.getMethod("getTestMultiLineString").invoke(businessDTO);

      assertEquals("User does not have adequate read permissions, yet was able to retreive the MultiLineString.", null, multiPoint);
    }
    catch (Throwable e)
    {
      if (e instanceof InvocationTargetException)
      {
        InvocationTargetException inv = (InvocationTargetException) e;
        Throwable cause = inv.getCause();

        if (cause instanceof AttributeReadPermissionExceptionDTO)
        {
          // this is expected
        }
        else
        {
          fail(cause.getMessage());
        }
      }
      else
      {
        fail(e.getMessage());
      }
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
    }
  }

  /**
*
*/
  public void testMultiPolygonInvalidReadPermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      String multiPolygonText1 = "MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2, 3 2, 3 3, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";

      WKTReader reader = new WKTReader();
      MultiPolygon multiPolygon = (MultiPolygon) reader.read(multiPolygonText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiPolygon", MultiPolygon.class).invoke(businessDTO, multiPolygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      multiPolygon = (MultiPolygon) testClass.getMethod("getTestMultiLineString").invoke(businessDTO);

      assertEquals("User does not have adequate read permissions, yet was able to retreive the MultiPolygon.", null, multiPolygon);
    }
    catch (Throwable e)
    {
      if (e instanceof InvocationTargetException)
      {
        InvocationTargetException inv = (InvocationTargetException) e;
        Throwable cause = inv.getCause();

        if (cause instanceof AttributeReadPermissionExceptionDTO)
        {
          // this is expected
        }
        else
        {
          fail(cause.getMessage());
        }
      }
      else
      {
        fail(e.getMessage());
      }
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
    }
  }

  /**
*
*/
  public void testPointInvalidWritePermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

    try
    {
      GeometryFactory geometryFactory = new GeometryFactory();
      Point point = geometryFactory.createPoint(new Coordinate(191232, 243118));

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestPoint", Point.class).invoke(businessDTO, point);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      point = (Point) testClass.getMethod("getTestPoint").invoke(businessDTO);

      assertEquals("X Coordinate on the point was not the expected value.", 191232d, point.getX());
      assertEquals("Y Coordinate on the point was not the expected value.", 243118d, point.getY());

      testClass.getMethod("lock").invoke(businessDTO);

      point = geometryFactory.createPoint(new Coordinate(191108, 243242));

      testClass.getMethod("setTestPoint", Point.class).invoke(businessDTO, point);
      testClass.getMethod("apply").invoke(businessDTO);

      fail("Able to write to a point attribute without write permission.");
    }
    catch (InvocationTargetException e)
    {
      Throwable cause = e.getCause();

      if (cause != null && cause instanceof AttributeWritePermissionExceptionDTO)
      {
        // this is expected
      }
      else
      {
        fail(cause.getMessage());
      }
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      if (businessDTO != null && !businessDTO.isNewInstance())
        ;
      {
        try
        {
          testClass.getMethod("unlock").invoke(businessDTO);
        }
        catch (Throwable e)
        {
          fail(e.getMessage());
        }
      }

      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testLineStringInvalidWritePermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

    try
    {
      GeometryFactory geometryFactory = new GeometryFactory();
      LineString lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(191232, 243118), new Coordinate(191108, 243242) });

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestLineString", LineString.class).invoke(businessDTO, lineString);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      LineString newLineString = (LineString) testClass.getMethod("getTestLineString").invoke(businessDTO);

      assertTrue("Returned LineString from the database does not match the LineString that was set on the object.", lineString.equalsExact(newLineString));

      testClass.getMethod("lock").invoke(businessDTO);

      lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(189141, 244158), new Coordinate(189265, 244817) });

      testClass.getMethod("setTestLineString", LineString.class).invoke(businessDTO, lineString);
      testClass.getMethod("apply").invoke(businessDTO);

      fail("Able to write to a LineString attribute without write permission.");
    }
    catch (InvocationTargetException e)
    {
      Throwable cause = e.getCause();

      if (cause != null && cause instanceof AttributeWritePermissionExceptionDTO)
      {
        // this is expected
      }
      else
      {
        fail(cause.getMessage());
      }
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      if (businessDTO != null && !businessDTO.isNewInstance())
        ;
      {
        try
        {
          testClass.getMethod("unlock").invoke(businessDTO);
        }
        catch (Throwable e)
        {
          fail(e.getMessage());
        }
      }

      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testPolygonInvalidWritePermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

    try
    {
      String polygonText1 = "POLYGON (( 10 10, 10 20, 20 20, 20 15, 10 10))";

      WKTReader reader = new WKTReader();
      Polygon polygon = (Polygon) reader.read(polygonText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestPolygon", Polygon.class).invoke(businessDTO, polygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      Polygon newPolygon = (Polygon) testClass.getMethod("getTestPolygon").invoke(businessDTO);

      assertTrue("Returned Polygon from the database does not match the Polygon that was set on the object.", polygon.equalsExact(newPolygon));

      testClass.getMethod("lock").invoke(businessDTO);

      String polygonText2 = "POLYGON (( 10 10, 15 25, 40 40, 30 25, 10 10))";
      polygon = (Polygon) reader.read(polygonText2);

      testClass.getMethod("setTestPolygon", Polygon.class).invoke(businessDTO, polygon);
      testClass.getMethod("apply").invoke(businessDTO);

      fail("Able to write to a Polygon attribute without write permission.");
    }
    catch (InvocationTargetException e)
    {
      Throwable cause = e.getCause();

      if (cause != null && cause instanceof AttributeWritePermissionExceptionDTO)
      {
        // this is expected
      }
      else
      {
        fail(cause.getMessage());
      }
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      if (businessDTO != null && !businessDTO.isNewInstance())
        ;
      {
        try
        {
          testClass.getMethod("unlock").invoke(businessDTO);
        }
        catch (Throwable e)
        {
          fail(e.getMessage());
        }
      }

      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testMultiPointInvalidWritePermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

    try
    {
      String multiPointText1 = "MULTIPOINT(191232 243118, 10000 20000)";

      WKTReader reader = new WKTReader();
      MultiPoint multiPoint = (MultiPoint) reader.read(multiPointText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiPoint", MultiPoint.class).invoke(businessDTO, multiPoint);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiPoint newMultiPoint = (MultiPoint) testClass.getMethod("getTestMultiPoint").invoke(businessDTO);

      assertTrue("Returned MultiPoint from the database does not match the MultiPoint that was set on the object.", multiPoint.equalsExact(newMultiPoint));

      testClass.getMethod("lock").invoke(businessDTO);

      String multiPointText2 = "MULTIPOINT(191108 243242, 30000 40000)";
      multiPoint = (MultiPoint) reader.read(multiPointText2);

      testClass.getMethod("setTestMultiPoint", MultiPoint.class).invoke(businessDTO, multiPoint);
      testClass.getMethod("apply").invoke(businessDTO);

      fail("Able to write to a MultiPoint attribute without write permission.");
    }
    catch (InvocationTargetException e)
    {
      Throwable cause = e.getCause();

      if (cause != null && cause instanceof AttributeWritePermissionExceptionDTO)
      {
        // this is expected
      }
      else
      {
        fail(cause.getMessage());
      }
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      if (businessDTO != null && !businessDTO.isNewInstance())
        ;
      {
        try
        {
          testClass.getMethod("unlock").invoke(businessDTO);
        }
        catch (Throwable e)
        {
          fail(e.getMessage());
        }
      }

      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testMultiLineStringInvalidWritePermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

    try
    {
      String multiLineStringText1 = "MULTILINESTRING ((191232 243118, 191108 243242, 200000 250000, 275000 300000))";

      WKTReader reader = new WKTReader();
      MultiLineString multiLineString = (MultiLineString) reader.read(multiLineStringText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiLineString", MultiLineString.class).invoke(businessDTO, multiLineString);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiLineString newMultiLineString = (MultiLineString) testClass.getMethod("getTestMultiLineString").invoke(businessDTO);

      assertTrue("Returned MultiLineString from the database does not match the MultiLineString that was set on the object.", multiLineString.equalsExact(newMultiLineString));

      testClass.getMethod("lock").invoke(businessDTO);

      String multiLineStringText2 = "MULTILINESTRING ((189141 244158, 189265 244817, 100000 150000, 175000 200000))";
      multiLineString = (MultiLineString) reader.read(multiLineStringText2);

      testClass.getMethod("setTestMultiLineString", MultiLineString.class).invoke(businessDTO, multiLineString);
      testClass.getMethod("apply").invoke(businessDTO);

      fail("Able to write to a MultiLineString attribute without write permission.");
    }
    catch (InvocationTargetException e)
    {
      Throwable cause = e.getCause();

      if (cause != null && cause instanceof AttributeWritePermissionExceptionDTO)
      {
        // this is expected
      }
      else
      {
        fail(cause.getMessage());
      }
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      if (businessDTO != null && !businessDTO.isNewInstance())
        ;
      {
        try
        {
          testClass.getMethod("unlock").invoke(businessDTO);
        }
        catch (Throwable e)
        {
          fail(e.getMessage());
        }
      }

      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testMultiPolygonInvalidWritePermissionTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

    try
    {
      String multiPolygonText1 = "MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2, 3 2, 3 3, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";

      WKTReader reader = new WKTReader();
      MultiPolygon multiPolygon = (MultiPolygon) reader.read(multiPolygonText1);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiPolygon", MultiPolygon.class).invoke(businessDTO, multiPolygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiPolygon newMultiLineString = (MultiPolygon) testClass.getMethod("getTestMultiPolygon").invoke(businessDTO);

      assertTrue("Returned MultiPolygon from the database does not match the MultiPolygon that was set on the object.", multiPolygon.equalsExact(newMultiLineString));

      testClass.getMethod("lock").invoke(businessDTO);

      String multiPolygonText2 = "MULTIPOLYGON(((1 1,5 1,10 10,1 5,1 1),(2 2, 3 2, 6 6, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";
      multiPolygon = (MultiPolygon) reader.read(multiPolygonText2);

      testClass.getMethod("setTestMultiPolygon", MultiPolygon.class).invoke(businessDTO, multiPolygon);
      testClass.getMethod("apply").invoke(businessDTO);

      fail("Able to write to a MultiPolygon attribute without write permission.");
    }
    catch (InvocationTargetException e)
    {
      Throwable cause = e.getCause();

      if (cause != null && cause instanceof AttributeWritePermissionExceptionDTO)
      {
        // this is expected
      }
      else
      {
        fail(cause.getMessage());
      }
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      if (businessDTO != null && !businessDTO.isNewInstance())
        ;
      {
        try
        {
          testClass.getMethod("unlock").invoke(businessDTO);
        }
        catch (Throwable e)
        {
          fail(e.getMessage());
        }
      }

      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
  *
  */
  @Test
  @Request
  public void testNullPointObjectTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    GeometryFactory geometryFactory = new GeometryFactory();

    try
    {
      businessDTO.setValue("testPoint", null);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      Point point = (Point) businessDTO.getObjectValue("testPoint");
      assertEquals("Object created.  Point object should be null.", null, point);

      tommyRequest.lock(businessDTO);
      point = geometryFactory.createPoint(new Coordinate(191108, 243242));
      businessDTO.setValue("testPoint", point);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      point = (Point) businessDTO.getObjectValue("testPoint");

      assertEquals("X Coordinate on the point was not the expected value.", 191108d, point.getX(), 0.001);
      assertEquals("Y Coordinate on the point was not the expected value.", 243242d, point.getY(), 0.001);

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testPoint", null);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      point = (Point) businessDTO.getObjectValue("testPoint");
      assertEquals("Object Updated. Point object should be null.", null, point);

    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());
    }
  }

  /**
 *
 */
  public void testNullLineStringObjectTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    GeometryFactory geometryFactory = new GeometryFactory();

    try
    {
      businessDTO.setValue("testLineString", null);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      LineString lineString = (LineString) businessDTO.getObjectValue("testLineString");
      assertEquals("Object created.  LineString object should be null.", null, lineString);

      tommyRequest.lock(businessDTO);
      lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(189141, 244158), new Coordinate(189265, 244817) });
      businessDTO.setValue("testLineString", lineString);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      LineString newLineString = (LineString) businessDTO.getObjectValue("testLineString");

      assertTrue("Returned LineString from the database does not match the LineString that was set on the object.", lineString.equalsExact(newLineString));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testLineString", null);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      lineString = (LineString) businessDTO.getObjectValue("testLineString");
      assertEquals("Object Updated. LineString object should be null.", null, lineString);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testNullPolygonObjectTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testPolygon", null);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      Polygon polygon = (Polygon) businessDTO.getObjectValue("testPolygon");
      assertEquals("Object created.  Polygon object should be null.", null, polygon);

      tommyRequest.lock(businessDTO);
      String polygonText1 = "POLYGON (( 10 10, 10 20, 20 20, 20 15, 10 10))";

      WKTReader reader = new WKTReader();
      polygon = (Polygon) reader.read(polygonText1);

      businessDTO.setValue("testPolygon", polygon);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      Polygon newPolygon = (Polygon) businessDTO.getObjectValue("testPolygon");

      assertTrue("Returned Polygon from the database does not match the Polygon that was set on the object.", polygon.equalsExact(newPolygon));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testPolygon", null);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      polygon = (Polygon) businessDTO.getObjectValue("testPolygon");
      assertEquals("Object Updated. Polygon object should be null.", null, polygon);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testNullMultiPointObjectTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testMultiPoint", null);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiPoint multiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");
      assertEquals("Object created.  MultiPoint object should be null.", null, multiPoint);

      tommyRequest.lock(businessDTO);
      String polygonText1 = "MULTIPOINT(191232 243118, 10000 20000)";

      WKTReader reader = new WKTReader();
      multiPoint = (MultiPoint) reader.read(polygonText1);

      businessDTO.setValue("testMultiPoint", multiPoint);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      MultiPoint newMultiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");

      assertTrue("Returned MultiPoint from the database does not match the MultiPoint that was set on the object.", multiPoint.equalsExact(newMultiPoint));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testMultiPoint", null);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      multiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");
      assertEquals("Object Updated. MultiPoint object should be null.", null, multiPoint);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testNullMultiLineStringObjectTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testMultiLineString", null);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiLineString multiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");
      assertEquals("Object created.  MultiLineString object should be null.", null, multiLineString);

      tommyRequest.lock(businessDTO);
      String polygonText1 = "MULTILINESTRING ((191232 243118, 191108 243242, 200000 250000, 275000 300000))";

      WKTReader reader = new WKTReader();
      multiLineString = (MultiLineString) reader.read(polygonText1);

      businessDTO.setValue("testMultiLineString", multiLineString);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      MultiLineString newMultiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");

      assertTrue("Returned MultiLineString from the database does not match the MultiLineString that was set on the object.", multiLineString.equalsExact(newMultiLineString));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testMultiLineString", null);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      multiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");
      assertEquals("Object Updated. MultiLineString object should be null.", null, multiLineString);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testNullMultiPolygonObjectTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testMultiPolygon", null);
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiPolygon multiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");
      assertEquals("Object created.  MultiPolygon object should be null.", null, multiPolygon);

      tommyRequest.lock(businessDTO);
      String polygonText1 = "MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2, 3 2, 3 3, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";

      WKTReader reader = new WKTReader();
      multiPolygon = (MultiPolygon) reader.read(polygonText1);

      businessDTO.setValue("testMultiPolygon", multiPolygon);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      MultiPolygon newMultiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");

      assertTrue("Returned MultiPolygon from the database does not match the MultiPolygon that was set on the object.", multiPolygon.equalsExact(newMultiPolygon));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testMultiPolygon", null);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      multiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");
      assertEquals("Object Updated. MultiPolygon object should be null.", null, multiPolygon);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
 *
 */
  public void testNullPointObjectTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      GeometryFactory geometryFactory = new GeometryFactory();

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestPoint", Point.class).invoke(businessDTO, (Point) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      Point point = (Point) testClass.getMethod("getTestPoint").invoke(businessDTO);

      assertEquals("Object created.  Point object should be null.", null, point);

      testClass.getMethod("lock").invoke(businessDTO);

      point = geometryFactory.createPoint(new Coordinate(191108, 243242));

      testClass.getMethod("setTestPoint", Point.class).invoke(businessDTO, point);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      point = (Point) testClass.getMethod("getTestPoint").invoke(businessDTO);

      assertEquals("X Coordinate on the point was not the expected value.", 191108d, point.getX());
      assertEquals("Y Coordinate on the point was not the expected value.", 243242d, point.getY());

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      testClass.getMethod("lock").invoke(businessDTO);
      testClass.getMethod("setTestPoint", Point.class).invoke(businessDTO, (Point) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      point = (Point) testClass.getMethod("getTestPoint").invoke(businessDTO);

      assertEquals("Object created.  Point object should be null.", null, point);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testNullLineStringObjectTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      GeometryFactory geometryFactory = new GeometryFactory();

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestLineString", LineString.class).invoke(businessDTO, (LineString) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      LineString lineString = (LineString) testClass.getMethod("getTestLineString").invoke(businessDTO);

      assertEquals("Object created.  LineString object should be null.", null, lineString);

      testClass.getMethod("lock").invoke(businessDTO);

      lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(189141, 244158), new Coordinate(189265, 244817) });

      testClass.getMethod("setTestLineString", LineString.class).invoke(businessDTO, lineString);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      LineString newLineString = (LineString) testClass.getMethod("getTestLineString").invoke(businessDTO);

      assertTrue("Returned LineString from the database does not match the LineString that was set on the object.", lineString.equalsExact(newLineString));

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      testClass.getMethod("lock").invoke(businessDTO);
      testClass.getMethod("setTestLineString", LineString.class).invoke(businessDTO, (LineString) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      lineString = (LineString) testClass.getMethod("getTestLineString").invoke(businessDTO);

      assertEquals("Object created.  LineString object should be null.", null, lineString);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testNullPolygonObjectTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestPolygon", Polygon.class).invoke(businessDTO, (Polygon) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      Polygon polygon = (Polygon) testClass.getMethod("getTestPolygon").invoke(businessDTO);

      assertEquals("Object created.  Polygon object should be null.", null, polygon);

      testClass.getMethod("lock").invoke(businessDTO);

      String polygonText1 = "POLYGON (( 10 10, 10 20, 20 20, 20 15, 10 10))";

      WKTReader reader = new WKTReader();
      polygon = (Polygon) reader.read(polygonText1);

      testClass.getMethod("setTestPolygon", Polygon.class).invoke(businessDTO, polygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      Polygon newPolygon = (Polygon) testClass.getMethod("getTestPolygon").invoke(businessDTO);

      assertTrue("Returned Polygon from the database does not match the Polygon that was set on the object.", polygon.equalsExact(newPolygon));

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      testClass.getMethod("lock").invoke(businessDTO);
      testClass.getMethod("setTestPolygon", Polygon.class).invoke(businessDTO, (Polygon) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      polygon = (Polygon) testClass.getMethod("getTestPolygon").invoke(businessDTO);

      assertEquals("Object created.  Polygon object should be null.", null, polygon);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testNullMultiPointObjectTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiPoint", MultiPoint.class).invoke(businessDTO, (MultiPoint) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiPoint multiPoint = (MultiPoint) testClass.getMethod("getTestMultiPoint").invoke(businessDTO);

      assertEquals("Object created.  MultiPoint object should be null.", null, multiPoint);

      testClass.getMethod("lock").invoke(businessDTO);

      String polygonText1 = "MULTIPOINT(191108 243242, 30000 40000)";

      WKTReader reader = new WKTReader();
      multiPoint = (MultiPoint) reader.read(polygonText1);

      testClass.getMethod("setTestMultiPoint", MultiPoint.class).invoke(businessDTO, multiPoint);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiPoint newMultiPoint = (MultiPoint) testClass.getMethod("getTestMultiPoint").invoke(businessDTO);

      assertTrue("Returned MultiPoint from the database does not match the MultiPoint that was set on the object.", multiPoint.equalsExact(newMultiPoint));

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      testClass.getMethod("lock").invoke(businessDTO);
      testClass.getMethod("setTestMultiPoint", MultiPoint.class).invoke(businessDTO, (MultiPoint) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      multiPoint = (MultiPoint) testClass.getMethod("getTestMultiPoint").invoke(businessDTO);

      assertEquals("Object created.  MultiPoint object should be null.", null, multiPoint);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testNullMultiLineStringObjectTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiLineString", MultiLineString.class).invoke(businessDTO, (MultiLineString) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiLineString multiLineString = (MultiLineString) testClass.getMethod("getTestMultiLineString").invoke(businessDTO);

      assertEquals("Object created.  MultiLineString object should be null.", null, multiLineString);

      testClass.getMethod("lock").invoke(businessDTO);

      String multiLineStringText1 = "MULTILINESTRING ((189141 244158, 189265 244817, 100000 150000, 175000 200000))";

      WKTReader reader = new WKTReader();
      multiLineString = (MultiLineString) reader.read(multiLineStringText1);

      testClass.getMethod("setTestMultiLineString", MultiLineString.class).invoke(businessDTO, multiLineString);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiLineString newMultiLineString = (MultiLineString) testClass.getMethod("getTestMultiLineString").invoke(businessDTO);

      assertTrue("Returned MultiLineString from the database does not match the MultiLineString that was set on the object.", multiLineString.equalsExact(newMultiLineString));

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      testClass.getMethod("lock").invoke(businessDTO);
      testClass.getMethod("setTestMultiLineString", MultiLineString.class).invoke(businessDTO, (MultiLineString) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      multiLineString = (MultiLineString) testClass.getMethod("getTestMultiLineString").invoke(businessDTO);

      assertEquals("Object created.  MultiLineString object should be null.", null, multiLineString);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testNullMultiPolygonObjectTypeSafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = null;

    try
    {
      Class<?> testClass = LoaderDecorator.load(GISMasterTestSetup.TEST_CLASS.getType() + TypeGeneratorInfo.DTO_SUFFIX);

      businessDTO = (BusinessDTO) testClass.getConstructor(ClientRequestIF.class).newInstance(tommyRequest);
      testClass.getMethod("setTestMultiPolygon", MultiPolygon.class).invoke(businessDTO, (MultiPolygon) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiPolygon multiPolygon = (MultiPolygon) testClass.getMethod("getTestMultiPolygon").invoke(businessDTO);

      assertEquals("Object created.  MultiPolygon object should be null.", null, multiPolygon);

      testClass.getMethod("lock").invoke(businessDTO);

      String multiPolygonText1 = "MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2, 3 2, 3 3, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";

      WKTReader reader = new WKTReader();
      multiPolygon = (MultiPolygon) reader.read(multiPolygonText1);

      testClass.getMethod("setTestMultiPolygon", MultiPolygon.class).invoke(businessDTO, multiPolygon);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      MultiPolygon newMultiPolygon = (MultiPolygon) testClass.getMethod("getTestMultiPolygon").invoke(businessDTO);

      assertTrue("Returned MultiPolygon from the database does not match the MultiPolygon that was set on the object.", multiPolygon.equalsExact(newMultiPolygon));

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      testClass.getMethod("lock").invoke(businessDTO);
      testClass.getMethod("setTestMultiPolygon", MultiPolygon.class).invoke(businessDTO, (MultiLineString) null);
      testClass.getMethod("apply").invoke(businessDTO);

      businessDTO = (BusinessDTO) testClass.getMethod("get", ClientRequestIF.class, String.class).invoke(null, tommyRequest, businessDTO.getId());
      multiPolygon = (MultiPolygon) testClass.getMethod("getTestMultiPolygon").invoke(businessDTO);

      assertEquals("Object created.  MultiPolygon object should be null.", null, multiPolygon);

    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
   *
   */
  @Test
  @Request
  public void testEmptyStringPointTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    GeometryFactory geometryFactory = new GeometryFactory();

    try
    {
      businessDTO.setValue("testPoint", "");
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      Point point = (Point) businessDTO.getObjectValue("testPoint");
      assertEquals("Object created.  Point object should be null.", null, point);

      tommyRequest.lock(businessDTO);
      point = geometryFactory.createPoint(new Coordinate(191108, 243242));
      businessDTO.setValue("testPoint", point);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      point = (Point) businessDTO.getObjectValue("testPoint");

      assertEquals("X Coordinate on the point was not the expected value.", 191108d, point.getX(), 0.001);
      assertEquals("Y Coordinate on the point was not the expected value.", 243242d, point.getY(), 0.001);

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testPoint", "");
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      point = (Point) businessDTO.getObjectValue("testPoint");
      assertEquals("Object Updated. Point object should be null.", null, point);
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());
    }
  }

  /**
  *
  */
  @Test
  @Request
  public void testEmptyStringLineStringTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    GeometryFactory geometryFactory = new GeometryFactory();

    try
    {
      businessDTO.setValue("testLineString", "");
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      LineString lineString = (LineString) businessDTO.getObjectValue("testLineString");
      assertEquals("Object created.  LineString object should be null.", null, lineString);

      tommyRequest.lock(businessDTO);
      lineString = geometryFactory.createLineString(new Coordinate[] { new Coordinate(189141, 244158), new Coordinate(189265, 244817) });
      businessDTO.setValue("testLineString", lineString);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      LineString newLineString = (LineString) businessDTO.getObjectValue("testLineString");

      assertTrue("Returned LineString from the database does not match the LineString that was set on the object.", lineString.equalsExact(newLineString));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testLineString", "");
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      lineString = (LineString) businessDTO.getObjectValue("testLineString");
      assertEquals("Object Updated. LineString object should be null.", null, lineString);
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
 *
 */
  public void testEmptyStringPolygonTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testPolygon", "");
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      Polygon polygon = (Polygon) businessDTO.getObjectValue("testPolygon");
      assertEquals("Object created.  Polygon object should be null.", null, polygon);

      tommyRequest.lock(businessDTO);
      String polygonText1 = "POLYGON (( 10 10, 10 20, 20 20, 20 15, 10 10))";

      WKTReader reader = new WKTReader();
      polygon = (Polygon) reader.read(polygonText1);
      businessDTO.setValue("testPolygon", polygon);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      Polygon newPolygon = (Polygon) businessDTO.getObjectValue("testPolygon");

      assertTrue("Returned Polygon from the database does not match the Polygon that was set on the object.", polygon.equalsExact(newPolygon));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testPolygon", "");
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      polygon = (Polygon) businessDTO.getObjectValue("testPolygon");
      assertEquals("Object Updated. Polygon object should be null.", null, polygon);
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testEmptyStringMultiPointTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testMultiPoint", "");
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiPoint multiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");
      assertEquals("Object created.  MultiPoint object should be null.", null, multiPoint);

      tommyRequest.lock(businessDTO);
      String multiPointText1 = "MULTIPOINT(191232 243118, 10000 20000)";

      WKTReader reader = new WKTReader();
      multiPoint = (MultiPoint) reader.read(multiPointText1);
      businessDTO.setValue("testMultiPoint", multiPoint);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      MultiPoint newMultiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");

      assertTrue("Returned MultiPoint from the database does not match the MultiPoint that was set on the object.", multiPoint.equalsExact(newMultiPoint));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testMultiPoint", "");
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      multiPoint = (MultiPoint) businessDTO.getObjectValue("testMultiPoint");
      assertEquals("Object Updated. MultiPoint object should be null.", null, multiPoint);
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testEmptyStringMultiLineStringTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testMultiLineString", "");
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiLineString multiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");
      assertEquals("Object created.  MultiLineString object should be null.", null, multiLineString);

      tommyRequest.lock(businessDTO);
      String multiLineString1 = "MULTILINESTRING ((191232 243118, 191108 243242, 200000 250000, 275000 300000))";

      WKTReader reader = new WKTReader();
      multiLineString = (MultiLineString) reader.read(multiLineString1);
      businessDTO.setValue("testMultiLineString", multiLineString);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      MultiLineString newMultiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");

      assertTrue("Returned MultiLineString from the database does not match the MultiLineString that was set on the object.", multiLineString.equalsExact(newMultiLineString));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testMultiLineString", "");
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      multiLineString = (MultiLineString) businessDTO.getObjectValue("testMultiLineString");
      assertEquals("Object Updated. MultiLineString object should be null.", null, multiLineString);
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());
    }
  }

  /**
*
*/
  public void testEmptyStringMultiPolygonTypeUnsafe()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testMultiPolygon", "");
      tommyRequest.createBusiness(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());

      MultiPolygon multiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");
      assertEquals("Object created.  MultiPolygon object should be null.", null, multiPolygon);

      tommyRequest.lock(businessDTO);
      String multiPolygon1 = "MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2, 3 2, 3 3, 2 3,2 2)),((3 3,6 2,6 4,3 3)))";

      WKTReader reader = new WKTReader();
      multiPolygon = (MultiPolygon) reader.read(multiPolygon1);
      businessDTO.setValue("testMultiPolygon", multiPolygon);
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      MultiPolygon newMultiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");

      assertTrue("Returned MultiPolygon from the database does not match the MultiPolygon that was set on the object.", multiPolygon.equalsExact(newMultiPolygon));

      tommyRequest.lock(businessDTO);
      businessDTO.setValue("testMultiPolygon", "");
      tommyRequest.update(businessDTO);

      businessDTO = (BusinessDTO) tommyRequest.get(businessDTO.getId());
      multiPolygon = (MultiPolygon) businessDTO.getObjectValue("testMultiPolygon");
      assertEquals("Object Updated. MultiPolygon object should be null.", null, multiPolygon);
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPolygonDAO.getId(), Operation.READ.name());
    }
  }

  @Test
  @Request
  public void testInvalidPointStringObject()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testPoint", "Total Garbage");
      tommyRequest.createBusiness(businessDTO);

      fail("An invalid WKT value was set on a point attribute.");
    }
    catch (AttributePointParseExceptionDTO e)
    {
      // this is expected
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePointDAO.getId(), Operation.READ.name());
    }
  }

  @Test
  @Request
  public void testInvalidLineStringStringObject()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testLineString", "Total Garbage");
      tommyRequest.createBusiness(businessDTO);

      fail("An invalid WKT value was set on a LineString attribute.");
    }
    catch (AttributeLineStringParseExceptionDTO e)
    {
      // this is expected
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeLineStringDAO.getId(), Operation.READ.name());
    }
  }

  @Test
  @Request
  public void testInvalidPolygonString()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testPolygon", "Total Garbage");
      tommyRequest.createBusiness(businessDTO);

      fail("An invalid WKT value was set on a Polygon attribute.");
    }
    catch (AttributePolygonParseExceptionDTO e)
    {
      // this is expected
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributePolygonDAO.getId(), Operation.READ.name());
    }
  }

  @Test
  @Request
  public void testInvalidMultiPointString()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testMultiPoint", "Total Garbage");
      tommyRequest.createBusiness(businessDTO);

      fail("An invalid WKT value was set on a MultiPoint attribute.");
    }
    catch (AttributeMultiPointParseExceptionDTO e)
    {
      // this is expected
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiPointDAO.getId(), Operation.READ.name());
    }
  }

  @Test
  @Request
  public void testInvalidMultiLineStringString()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testMultiLineString", "Total Garbage");
      tommyRequest.createBusiness(businessDTO);

      fail("An invalid WKT value was set on a MultiLineString attribute.");
    }
    catch (AttributeMultiLineStringParseExceptionDTO e)
    {
      // this is expected
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());
    }
  }

  @Test
  @Request
  public void testInvalidMultiPolygonString()
  {
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
    clientRequest.grantTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
    clientRequest.grantAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());

    ClientSession tommySession = this.createSession("Tommy", "music");
    ClientRequestIF tommyRequest = getRequest(tommySession);

    BusinessDTO businessDTO = tommyRequest.newBusiness(GISMasterTestSetup.testClassMdBusinessDAO.definesType());

    try
    {
      businessDTO.setValue("testMultiPolygon", "Total Garbage");
      tommyRequest.createBusiness(businessDTO);

      fail("An invalid WKT value was set on a MultiPolygon attribute.");
    }
    catch (AttributeMultiPolygonParseExceptionDTO e)
    {
      // this is expected
    }
    catch (Throwable e)
    {
      fail(e.getMessage());
    }
    finally
    {
      tommySession.logout();

      if (!businessDTO.isNewInstance())
      {
        clientRequest.delete(businessDTO.getId());
      }

      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.CREATE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeTypePermission(tommyUser.getId(), GISMasterTestSetup.testClassMdBusinessDAO.getId(), Operation.READ.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.WRITE.name());
      clientRequest.revokeAttributePermission(tommyUser.getId(), GISMasterTestSetup.mdAttributeMultiLineStringDAO.getId(), Operation.READ.name());
    }
  }
}
