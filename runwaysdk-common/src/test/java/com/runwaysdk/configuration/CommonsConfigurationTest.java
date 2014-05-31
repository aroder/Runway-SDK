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

package com.runwaysdk.configuration;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.CompositeConfiguration;
import org.junit.Assert;
import org.junit.Test;

import com.runwaysdk.configuration.ConfigurationManager.ConfigResolver;
import com.runwaysdk.constants.CommonProperties;
import com.runwaysdk.constants.LocalProperties;

public class CommonsConfigurationTest extends AbstractTestConfiguration
{
  @Override
  ConfigResolver getConfigResolver()
  {
    return ConfigResolver.COMMONS_CONFIG;
  }

  @Test
  public void testValueReplace()
  {
    String timeZone = CommonProperties.getJSONRMIService();

    Assert.assertEquals("testValue/testValue2/testValue3", timeZone);
  }

  @Test
  public void testSimpleInheritance()
  {
    String clientBin = LocalProperties.getClientGenBin();

    Assert.assertEquals("testValue", clientBin);
  }

  @Test
  public void testInheritance()
  {
    String serverBin = LocalProperties.getServerGenBin();

    Assert.assertEquals("testValue/testValue2/testValue3", serverBin);
  }

  @Test
  public void testCommonsConfigOverride()
  {
    BaseConfiguration bc = new BaseConfiguration();
    BaseConfiguration bc2 = new BaseConfiguration();

    bc2.addProperty("test.prop", 52);

    CompositeConfiguration cconfig = new CompositeConfiguration();
    cconfig.addConfiguration(bc);
    cconfig.addConfiguration(bc2);

    bc.addProperty("test.prop", 112);

    Assert.assertEquals(112, cconfig.getInt("test.prop"));
  }

  @Test
  public void testCommonsConfigOverrideSetVsAdd()
  {
    BaseConfiguration bc = new BaseConfiguration();
    BaseConfiguration bc2 = new BaseConfiguration();

    bc2.addProperty("test.prop", 52);

    CompositeConfiguration cconfig = new CompositeConfiguration();
    cconfig.addConfiguration(bc);
    cconfig.addConfiguration(bc2);

    bc.setProperty("test.prop", 112);

    Assert.assertEquals(112, cconfig.getInt("test.prop"));
  }
  //
  // public static void main(String[] args)
  // {
  // System.out.println(new ConfigurationManager().log.getClass().getName());
  // }

  // @Test
  // public void testSimpleOverrideInMemoryConfigurator() {
  // Configuration bc = ConfigurationManager.getInMemoryConfigurator();
  // bc.setProperty("rmi.port", 53);
  //
  // int rmiPort = CommonProperties.getRMIPort();
  //
  // assertEquals(53, rmiPort);
  // }

  // This test should theoretically work (it passes in eclipse and on my box
  // when executed via maven), but
  // there's some weird non-determinism going on (it fails on linux machines
  // only when executed in maven).
  // @Test
  // public void testInMemoryConfigurator() throws InterruptedException {
  // Configuration bc = ConfigurationManager.getInMemoryConfigurator();
  // bc.setProperty("test.prop.two", "overridden");
  //
  // String timeZone = CommonProperties.getJSONRMIService();
  //
  // assertTrue(bc.containsKey("test.prop.two"));
  // assertEquals("overridden", bc.getProperty("test.prop.two"));
  // assertTrue(bc.equals(ConfigurationManager.getInMemoryConfigurator()));
  // assertEquals("overridden/testValue3", timeZone);
  // }
}