/**
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
 */

package com.runwaysdk.business.generation.maven;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sonatype.aether.transfer.AbstractTransferListener;
import org.sonatype.aether.transfer.TransferEvent;
import org.sonatype.aether.transfer.TransferResource;

/**
 * Based on code from:
 * 
 * https://github.com/sonatype/sonatype-aether/blob/master/aether-demo/src/main/java/demo/util/ConsoleTransferListener.java
 */
public class TransferListener extends AbstractTransferListener
{
  private Log                         log       = LogFactory.getLog(TransferListener.class);

  private Map<TransferResource, Long> downloads = new ConcurrentHashMap<TransferResource, Long>();

  private int                         lastLength;

  public TransferListener()
  {
  }

  @Override
  public void transferInitiated(TransferEvent event)
  {
    String message = event.getRequestType() == TransferEvent.RequestType.PUT ? "Uploading"
        : "Downloading";

    log.info(message + ": " + event.getResource().getRepositoryUrl()
        + event.getResource().getResourceName());
  }

  @Override
  public void transferProgressed(TransferEvent event)
  {
    TransferResource resource = event.getResource();
    downloads.put(resource, Long.valueOf(event.getTransferredBytes()));

    StringBuilder buffer = new StringBuilder(64);

    for (Map.Entry<TransferResource, Long> entry : downloads.entrySet())
    {
      long total = entry.getKey().getContentLength();
      long complete = entry.getValue().longValue();

      buffer.append(getStatus(complete, total)).append("  ");
    }

    int pad = lastLength - buffer.length();
    lastLength = buffer.length();
    pad(buffer, pad);
    buffer.append('\r');

    log.trace(buffer);
  }

  private String getStatus(long complete, long total)
  {
    if (total >= 1024)
    {
      return toKB(complete) + "/" + toKB(total) + " KB ";
    }
    else if (total >= 0)
    {
      return complete + "/" + total + " B ";
    }
    else if (complete >= 1024)
    {
      return toKB(complete) + " KB ";
    }
    else
    {
      return complete + " B ";
    }
  }

  private void pad(StringBuilder buffer, int spaces)
  {
    String block = "                                        ";
    while (spaces > 0)
    {
      int n = Math.min(spaces, block.length());
      buffer.append(block, 0, n);
      spaces -= n;
    }
  }

  @Override
  public void transferSucceeded(TransferEvent event)
  {
    transferCompleted(event);

    TransferResource resource = event.getResource();
    long contentLength = event.getTransferredBytes();
    if (contentLength >= 0)
    {
      String type = ( event.getRequestType() == TransferEvent.RequestType.PUT ? "Uploaded"
          : "Downloaded" );
      String len = contentLength >= 1024 ? toKB(contentLength) + " KB" : contentLength + " B";

      String throughput = "";
      long duration = System.currentTimeMillis() - resource.getTransferStartTime();
      if (duration > 0)
      {
        DecimalFormat format = new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.ENGLISH));
        double kbPerSec = ( contentLength / 1024.0 ) / ( duration / 1000.0 );
        throughput = " at " + format.format(kbPerSec) + " KB/sec";
      }

      log.info(type + ": " + resource.getRepositoryUrl() + resource.getResourceName() + " (" + len
          + throughput + ")");
    }
  }

  @Override
  public void transferFailed(TransferEvent event)
  {
    transferCompleted(event);

    log.fatal(event.getException());
  }

  private void transferCompleted(TransferEvent event)
  {
    downloads.remove(event.getResource());

    StringBuilder buffer = new StringBuilder(64);
    pad(buffer, lastLength);
    buffer.append('\r');
    log.info(buffer);
  }

  public void transferCorrupted(TransferEvent event)
  {
    log.fatal(event.getException());
  }

  protected long toKB(long bytes)
  {
    return ( bytes + 1023 ) / 1024;
  }
}
