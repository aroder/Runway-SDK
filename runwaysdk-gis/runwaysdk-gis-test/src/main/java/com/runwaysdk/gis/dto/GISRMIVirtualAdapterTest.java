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

import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.runwaysdk.ClientSession;
import com.runwaysdk.constants.CommonProperties;
import com.runwaysdk.constants.ServerConstants;
import com.runwaysdk.facade.RemoteAdapterServer;
import com.runwaysdk.request.RMIClientRequest;

public class GISRMIVirtualAdapterTest extends GISVirtualAdapterTest
{
  @BeforeClass
  public static void setUp()
  {
    RemoteAdapterServer.startServer();
  }

  @AfterClass
  public static void tearDown()
  {
    RemoteAdapterServer.stopServer();
  }

  protected ClientSession createSession(String userName, String password)
  {
    return ClientSession.createUserSession("rmiDefault", userName, password,
        new Locale[] { CommonProperties.getDefaultLocale() });
  }
}