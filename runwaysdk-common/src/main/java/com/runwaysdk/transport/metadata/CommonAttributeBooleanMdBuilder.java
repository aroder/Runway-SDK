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
package com.runwaysdk.transport.metadata;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;

import com.runwaysdk.CommonExceptionProcessor;
import com.runwaysdk.constants.ExceptionConstants;
import com.runwaysdk.transport.conversion.ConversionFacade;
import com.runwaysdk.transport.conversion.dom.Elements;

public class CommonAttributeBooleanMdBuilder extends CommonAttributeMdBuilder
{
  /**
   * The positive display label of the attribute.
   */
  private String positiveDisplayLabel;

  /**
   * The negative display label of the attribute.
   */
  private String negativeDisplayLabel;

  /**
   * Constructor
   */
  protected CommonAttributeBooleanMdBuilder(AttributeBooleanMdDTO source, AttributeBooleanMdDTO dest)
  {
    super(source, dest);

    positiveDisplayLabel = ((AttributeBooleanMdDTO)source).getPositiveDisplayLabel();

    negativeDisplayLabel = ((AttributeBooleanMdDTO)source).getNegativeDisplayLabel();
  }

  /**
   * Constructor
   */
  protected CommonAttributeBooleanMdBuilder(Node metadata, Node properties, AttributeBooleanMdDTO dest)
  {
    super(metadata, properties, dest);

    try
    {
      positiveDisplayLabel = (String)ConversionFacade.getXPath().evaluate(Elements.BOOLEAN_METADATA_POSITIVE.getLabel(), metadata, XPathConstants.STRING);
      negativeDisplayLabel = (String)ConversionFacade.getXPath().evaluate(Elements.BOOLEAN_METADATA_NEGATIVE.getLabel(), metadata, XPathConstants.STRING);
    }
    catch(XPathExpressionException ex)
    {
      String errString = "Improper XPath expression: "+ex.getMessage();
      CommonExceptionProcessor.processException(ExceptionConstants.ConversionException.getExceptionClass(), errString, ex);
    }
  }

  /**
   * Builds and returns an AttributeCharacterMdDTO
   *
   * @return
   */
  protected void build()
  {
    super.build();

    AttributeBooleanMdDTO destSafe = (AttributeBooleanMdDTO) dest;

    destSafe.setPositiveDisplayLabel(this.positiveDisplayLabel);

    destSafe.setNegativeDisplayLabel(this.negativeDisplayLabel);
  }
}
