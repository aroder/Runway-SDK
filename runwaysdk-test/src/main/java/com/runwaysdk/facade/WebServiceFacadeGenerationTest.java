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
package com.runwaysdk.facade;
import java.util.Locale;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

import com.runwaysdk.ClientSession;
import com.runwaysdk.constants.CommonProperties;
import com.runwaysdk.constants.ServerConstants;
import com.runwaysdk.constants.TestProperties;
import com.runwaysdk.generation.loader.WebTestGeneratedClassLoader;


public class WebServiceFacadeGenerationTest extends FacadeGenerationTest
{
  private static final String address = TestProperties.getWebtestAddress()+"/"+TestProperties.getWebtestWebapp()+"/services/";

  public static void main(String[] args)
  {
    junit.textui.TestRunner.run(WebServiceFacadeGenerationTest.suite());
  }

  public static Test suite()
  {
    TestSuite suite = new TestSuite();

    suite.addTestSuite(WebServiceFacadeGenerationTest.class);

    TestSetup wrapper = new TestSetup(suite)
    {
      protected void setUp() throws Exception
      {
        label = "facadeGenerationTest";
        systemSession =
          ClientSession.createUserSession(label, ServerConstants.SYSTEM_USER_NAME, ServerConstants.SYSTEM_DEFAULT_PASSWORD, new Locale[]{CommonProperties.getDefaultLocale()});
        clientRequest = systemSession.getRequest();
        clientRequest.setKeepMessages(false);

        classSetUp();
        finalizeSetup();

        // Bind the remote controller to the RMI Server
        String clientRequestName = pack + ".WebService" + facadeName + "Proxy";

        // Load the clientRequest with the new
        facadeProxyClass = WebTestGeneratedClassLoader.load(clientRequestName);
        generatedProxy = facadeProxyClass.getConstructor(String.class, String.class).newInstance(label, address);
      }

      protected void tearDown()
      {
        classTearDown();
      }
    };

    return wrapper;
  }

}