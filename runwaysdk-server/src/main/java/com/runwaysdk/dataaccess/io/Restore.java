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
package com.runwaysdk.dataaccess.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.runwaysdk.ServerExceptionMessageLocalizer;
import com.runwaysdk.business.Business;
import com.runwaysdk.business.BusinessQuery;
import com.runwaysdk.constants.DeployProperties;
import com.runwaysdk.constants.ServerProperties;
import com.runwaysdk.constants.VaultInfo;
import com.runwaysdk.constants.VaultProperties;
import com.runwaysdk.dataaccess.ProgrammingErrorException;
import com.runwaysdk.dataaccess.cache.globalcache.ehcache.CacheShutdown;
import com.runwaysdk.dataaccess.database.Database;
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.session.Request;
import com.runwaysdk.session.Session;
import com.runwaysdk.util.FileIO;

public class Restore
{
  private PrintStream        logPrintStream;

  private String             zipFileLocation;

  private File               restoreDirectory;

  private List<RestoreAgent> agents;

  private String             cacheDir;

  private Log                log;

  private String             cacheName;

  public Restore(PrintStream logPrintStream, String zipFileLocation)
  {
    log = LogFactory.getLog(this.getClass());

    this.logPrintStream = logPrintStream;

    this.zipFileLocation = zipFileLocation;

    File zipFile = new File(zipFileLocation);

    String zipFileName = zipFile.getName();

    String rootZipFileName = zipFileName.substring(0, zipFileName.indexOf(".zip"));

    String restoreDirectoryString = zipFile.getParent() + File.separator + rootZipFileName;

    this.restoreDirectory = new File(restoreDirectoryString);
    this.restoreDirectory.mkdir();

    this.cacheDir = ServerProperties.getGlobalCacheFileLocation();
    this.cacheName = ServerProperties.getGlobalCacheName();

    this.agents = new LinkedList<RestoreAgent>();
  }

  public void restore()
  {
    this.logPrintStream.println(ServerExceptionMessageLocalizer.restoringApplicationMessage(Session.getCurrentLocale()));
    this.logPrintStream.println("-----------------------------------------------");

    this.log.debug("Starting restore from [" + this.zipFileLocation + "]");

    for (RestoreAgent agent : agents)
    {
      agent.preRestore();
    }

    this.unzipFile();

    this.logPrintStream.println("\n" + ServerExceptionMessageLocalizer.droppingTablesMessage(Session.getCurrentLocale()));
    this.dropApplicationTabels();

    this.logPrintStream.println("\n" + ServerExceptionMessageLocalizer.importingDatabaseRecords(Session.getCurrentLocale()));
    this.importSQL();

    // restoreCacheFile();
    deleteCacheFile();

    restoreWebapp();
    
    restoreVault();
    
    /*
     * restoreProfiles();
     * 
     * restoreWebFilesVaults();
     */
    try
    {
      FileIO.deleteDirectory(this.restoreDirectory);
    }
    catch (IOException e)
    {
      throw new ProgrammingErrorException(e);
    }

    for (RestoreAgent agent : agents)
    {
      agent.postRestore();
    }

    this.log.trace("Finished restore from [" + this.zipFileLocation + "].");

    this.logPrintStream.println("\n" + ServerExceptionMessageLocalizer.restoreCompleteMessage(Session.getCurrentLocale()));
  }

  private void dropApplicationTabels()
  {
    List<String> tableNames = null;
    try
    {
      tableNames = Database.getAllApplicationTables();
    }
    catch (Throwable e)
    {
      // The framework has already been dropped.
    }

    if (tableNames != null)
    {
      Database.cascadeDropTables(tableNames);
    }
  }

  private void unzipFile()
  {
    this.logPrintStream.println(ServerExceptionMessageLocalizer.extractingFileMessage(Session.getCurrentLocale(), this.zipFileLocation));

    try
    {
      FileIO.write(new ZipFile(this.zipFileLocation), this.restoreDirectory.getAbsolutePath());
      this.log.debug("Unzipped from [" + this.zipFileLocation + "] to [" + this.restoreDirectory + "]");
    }
    catch (IOException e)
    {
      throw new ProgrammingErrorException(e);
    }
  }

  private void importSQL()
  {
    FilenameFilter filter = new FilenameFilter()
    {
      @Override
      public boolean accept(File dir, String name)
      {
        return name.endsWith(".sql");
      }
    };

    File sqlDir = new File(this.restoreDirectory.getAbsoluteFile() + File.separator + Backup.SQL + File.separator);

    this.log.debug("Importing SQL from directory [" + sqlDir + "]");

    File[] sqlFiles = sqlDir.listFiles(filter);

    if (sqlFiles != null)
    {
      for (File sqlFile : sqlFiles)
      {
        Database.importFromSQL(sqlFile.getAbsolutePath(), this.logPrintStream);
      }
    }
  }

  private void deleteCacheFile()
  {
    this.logPrintStream.println(ServerExceptionMessageLocalizer.backingUpCacheMessage(Session.getCurrentLocale()));
    try
    {
      File dataFile = new File(cacheDir + File.separator + cacheName + ".data");
      File indexFile = new File(cacheDir + File.separator + cacheName + ".index");
      
      // We don't even need to check if these files exist, that is done in the FileIO method.
      this.log.debug("Deleting cache data file [" + dataFile.getAbsolutePath() + "].");
      FileIO.deleteFile(dataFile);
      this.log.debug("Deleting cache index file [" + indexFile.getAbsolutePath() + "].");
      FileIO.deleteFile(indexFile);
    }
    catch (IOException e)
    {
      throw new ProgrammingErrorException(e);
    }

    this.log.trace("Finished backing up the cache files.");
  }

  // private void restoreCacheFile()
  // {
  // try
  // {
  // // Make the temp cache directory
  // File cacheDir = new File(this.restoreDirectory.getAbsoluteFile() +
  // File.separator + Backup.CACHE + File.separator);
  // this.log.trace("Restoring cache files from [" + cacheDir + "]");
  //
  // File[] files = cacheDir.listFiles();
  //
  // // the cache files might not exist if the backup was created without
  // // cache spooling up. Ignore these.
  // if (files != null)
  // {
  // for (File file : files)
  // {
  // String filename = this.cacheDir + File.separator + file.getName();
  // this.log.debug("Restoring cache file [" + filename + "]");
  //
  // FileInputStream iStream = new FileInputStream(file);
  // FileOutputStream oStream = new FileOutputStream(new File(filename));
  //
  // FileIO.write(oStream, iStream);
  // }
  // }
  // else
  // {
  // this.log.trace("There were no files in the cache directory [" + cacheDir +
  // "] to restore.");
  // }
  // }
  // catch (IOException e)
  // {
  // throw new ProgrammingErrorException(e);
  // }
  // }

  private void restoreWebapp()
  {
    File backupProfileLocationFile = new File(this.restoreDirectory.getPath() + File.separator + Backup.WEBAPP_DIR_NAME + File.separator);

    String webappRootDir = DeployProperties.getDeployPath();

    File webappRootFile = new File(webappRootDir);

    FilenameFilter filenameFilter = new FilenameFilter()
    {
      public boolean accept(File dir, String name)
      {
        if (name.endsWith(".svn") || dir.getName().startsWith("."))
        {
          return false;
        }

        return true;
      }
    };

    FileFilter fileFilter = new FileFilter()
    {
      public boolean accept(File pathname)
      {
        return true;
      }
    };

    try
    {
      this.logPrintStream.println("\n" + ServerExceptionMessageLocalizer.cleaningWebappFolderMessage(Session.getCurrentLocale(), webappRootFile));
      FileIO.deleteFolderContent(webappRootFile, fileFilter);
    }
    catch (IOException e)
    {
      // Some files might have already been deleted. We will copy anyway, as the
      // files should overwrite.
    }

    FileIO.copyFolder(backupProfileLocationFile, webappRootFile, filenameFilter, this.logPrintStream);
  }

  public void addAgent(RestoreAgent agent)
  {
    agents.add(agent);
  }
  
 
  private void restoreVault()
  {
    log.trace("Starting restore of vaults.");
    
    QueryFactory qf = new QueryFactory();
    BusinessQuery vaultQ = qf.businessQuery(VaultInfo.CLASS);

    String backupVaultFileLocation = this.restoreDirectory.getPath() + File.separator
        + Backup.VAULT_DIR_NAME + File.separator;

    OIterator<Business> i = vaultQ.getIterator();
    try
    {
      for (Business vault : i)
      {
        String vaultName = vault.getValue(VaultInfo.VAULT_NAME);
        String vaultLocation = VaultProperties.getPath(vaultName);
        String vaultInsideBackup = backupVaultFileLocation + File.separator + vault.getId() + File.separator;
        
        File vaultInsideBackupFile = new File(vaultInsideBackup);
        File vaultLocationFile = new File(vaultLocation);

        if (!vaultLocationFile.exists())
        {
          vaultLocationFile.mkdirs();
        }
        
        if (vaultInsideBackupFile.exists())
        {
          log.debug("Restoring vault [" + vaultName + "] from [" + vaultInsideBackup + "] to [" + vaultLocation + "].");
          
          FileIO.copyFolder(vaultInsideBackupFile, vaultLocationFile, this.logPrintStream);
        }
        else
        {
          log.warn("Skipped restore of vault [" + vaultName + "] from backup [" + vaultInsideBackup + "] to [" + vaultLocation + "] because the file in the backup does not exist.");
        }
      }
    }
    finally
    {
      i.close();
    }
  }
   

  /*
   * private void restoreProfiles() { File backupProfileLocationFile = new
   * File(this
   * .restoreDirectory.getPath()+File.separator+Backup.PROVILE_DIR_NAME+
   * File.separator);
   * 
   * String profileRootDir = ProfileManager.getProfileRootDir().toString();
   * 
   * File profileRootFile = new File(profileRootDir);
   * 
   * FilenameFilter filenameFilter = new FilenameFilter() { public boolean
   * accept(File dir, String name) { if (name.endsWith(".properties") ||
   * name.endsWith(".xml") || name.endsWith(".xsd") ) { return true; }
   * 
   * if (dir.isDirectory() && !dir.getName().startsWith(".")) { return true; }
   * 
   * return false; } };
   * 
   * FileIO.copyFolder(backupProfileLocationFile, profileRootFile,
   * filenameFilter, this.logPrintStream); }
   */
  /*
   * private void restoreWebFilesVaults() { QueryFactory qf = new
   * QueryFactory(); BusinessDAOQuery webFileQ =
   * qf.businessDAOQuery(WebFileInfo.CLASS);
   * 
   * String backupWebFileFileLocation =
   * this.restoreDirectory+File.separator+Backup
   * .WEBFILE_DIR_NAME+File.separator;
   * 
   * // Create the web file dir File backupWebFileFile = new
   * File(backupWebFileFileLocation); backupWebFileFile.mkdir();
   * 
   * OIterator<BusinessDAOIF> i = webFileQ.getIterator(); try { for
   * (BusinessDAOIF businessDAOIF : i) { WebFileDAOIF webFileDAOIF =
   * (WebFileDAOIF)businessDAOIF; File thisBackupWebFileFile = new
   * File(backupWebFileFileLocation+webFileDAOIF.getId()); try {
   * BufferedInputStream inputStream = new BufferedInputStream(new
   * FileInputStream(thisBackupWebFileFile)); webFileDAOIF.putFile(inputStream);
   * } catch (IOException e) { throw new
   * FileWriteException(thisBackupWebFileFile, e); } } } finally { i.close(); }
   * }
   */

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    try
    {
      Restore.start(args);
    }
    finally
    {
      CacheShutdown.shutdown();

    }
  }

  @Request
  private static void start(String[] args)
  {
    if (args.length != 1)
    {
      String errMessage = "Invalid number of arguments given.  Only one argument is required: the location of the backup file.";
      throw new RuntimeException(errMessage);
    }
    else
    {
      Restore restore = new Restore(System.out, args[0]);
      restore.restore();
    }
  }

}
