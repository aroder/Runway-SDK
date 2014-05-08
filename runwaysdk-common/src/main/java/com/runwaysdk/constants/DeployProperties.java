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
package com.runwaysdk.constants;

import java.io.File;

import com.runwaysdk.configuration.ConfigurationManager;
import com.runwaysdk.configuration.ConfigurationManager.ConfigGroup;
import com.runwaysdk.configuration.ConfigurationReaderIF;


public class DeployProperties
{
  private ConfigurationReaderIF props;

  private DeployProperties()
  {
    props = ConfigurationManager.getReader(ConfigGroup.COMMON, "deploy.properties");
  }
  
  /**
   * A holder class for access to the singleton. Allows for lazy instantiation and thread
   * safety because the class is not loaded until the first access to INSTANCE.
   */
  private static class Singleton
  {
    private static final DeployProperties INSTANCE = new DeployProperties();
  }

  /**
   * The admin username for the container.
   * 
   * @return
   */
  public static String getContainerUsername()
  {
    return Singleton.INSTANCE.props.getString("deploy.username");
  }
  
  /**
   * The path to the deployed webapp
   * 
   * @return
   */
  public static String getDeployPath()
  {
    return Singleton.INSTANCE.props.getString("deploy.path");
  }

  /**
   * @return The directory for generated jsp files
   */
  public static String getJspDir()
  {
    return Singleton.INSTANCE.props.getString("deploy.webinf");
  }
  
  /**
   * The admin password for the container.
   * @return
   */
  public static String getContainerPassword()
  {
    return Singleton.INSTANCE.props.getString("deploy.password");
  }
  
  /**
   * Returns the container app url.
   */
//  public static String getContainerAppUrl()
//  {
//    return Singleton.INSTANCE.props.getString("container.app.url");
//  }
  
  public static String getDeployLib()
  {
    return Singleton.INSTANCE.props.getString("deploy.lib");
  }
  
  public static String getDeployBin()
  {
    return Singleton.INSTANCE.props.getString("deploy.bin");
  }
  
  public static String getContainerServletAPIJarLocation()
  {
    return Singleton.INSTANCE.props.getString("deploy.servlet.jar");
  }
  
  public static String getApplicationURL()
  {
    return Singleton.INSTANCE.props.getString("container.app.url");
  }
  
  public static String getStoredTransactionAppFiles()
  {
    return Singleton.INSTANCE.props.getString("deploy.webinf") + File.separator + "storedAppFiles" + File.separator;
  }
  
  public static String getDeployRoot() {
    return Singleton.INSTANCE.props.getString("deploy.root");
  }
  
  public static String getAppName() {
    return Singleton.INSTANCE.props.getString("deploy.appname");
  }
}
