/**
 * 
 */
package com.runwaysdk.configuration;

import java.net.URL;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;

import com.runwaysdk.configuration.ConfigurationManager.ConfigGroup;

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
public class CommonsConfigurationReader extends AbstractConfigurationReader implements ConfigurationReaderIF, ConfigurationListener
{
  private Configuration config;
  
  public CommonsConfigurationReader(ConfigGroup group, String config) {
    try
    {
      String path = group.getPath() + config;
      ClassLoader loader = CommonsConfigurationReader.class.getClassLoader();
      URL clPath = loader.getResource(path);
      
      if (clPath == null) {
        throw new RunwayConfigurationException("The configuration resource [" + path + "] does not exist on the classpath.");
      }
      
      CompositeConfiguration cconfig = new CompositeConfiguration();
      cconfig.addConfiguration(ConfigurationManager.getInMemoryConfigurator());
      cconfig.addConfiguration(new PropertiesConfiguration(clPath));
      this.config = cconfig;
    }
    catch (ConfigurationException e)
    {
      throw new RunwayConfigurationException(e);
    }
  }
  
  public CommonsConfigurationReader(String config) {
    this(ConfigGroup.ROOT, config);
  }

  /**
   * @see com.runwaysdk.configuration.ConfigurationReaderIF#getString(java.lang.String)
   */
  @Override
  public String getString(String key)
  {
    Configuration cfg = ((CompositeConfiguration) this.config).interpolatedConfiguration();
    return cfg.getString(key);
  }

  /**
   * @see com.runwaysdk.configuration.ConfigurationReaderIF#getBoolean(java.lang.String)
   */
  @Override
  public Boolean getBoolean(String key)
  {
    Configuration cfg = ((CompositeConfiguration) this.config).interpolatedConfiguration();
    return cfg.getBoolean(key);
  }

  /**
   * @see com.runwaysdk.configuration.ConfigurationReaderIF#getInteger(java.lang.String)
   */
  @Override
  public Integer getInteger(String key)
  {
    Configuration cfg = ((CompositeConfiguration) this.config).interpolatedConfiguration();
    return cfg.getInt(key);
  }
  
  /**
   * @see com.runwaysdk.configuration.ConfigurationReaderIF#getString(java.lang.String, java.lang.String)
   */
  @Override
  public String getString(String key, String defaultValue)
  {
    Configuration cfg = ((CompositeConfiguration) this.config).interpolatedConfiguration();
    return cfg.getString(key, defaultValue);
  }

  /**
   * @see com.runwaysdk.configuration.ConfigurationReaderIF#getBoolean(java.lang.String, java.lang.Boolean)
   */
  @Override
  public Boolean getBoolean(String key, Boolean defaultValue)
  {
    Configuration cfg = ((CompositeConfiguration) this.config).interpolatedConfiguration();
    return cfg.getBoolean(key, defaultValue);
  }

  /**
   * @see com.runwaysdk.configuration.ConfigurationReaderIF#getInteger(java.lang.String, java.lang.Integer)
   */
  @Override
  public Integer getInteger(String key, Integer defaultValue)
  {
    Configuration cfg = ((CompositeConfiguration) this.config).interpolatedConfiguration();
    return cfg.getInteger(key, defaultValue);
  }

  /**
   * @see org.apache.commons.configuration.event.ConfigurationListener#configurationChanged(org.apache.commons.configuration.event.ConfigurationEvent)
   */
  @Override
  public void configurationChanged(ConfigurationEvent event)
  {
//    if (!event.isBeforeUpdate()) {
//      this.config = ((CompositeConfiguration) this.config).interpolatedConfiguration();
//    }
  }
}