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
package com.runwaysdk.form.web;

import com.runwaysdk.form.FormMd;
import com.runwaysdk.system.metadata.MdFormDTO;


public class WebFormMd extends FormMd
{

  protected WebFormMd()
  {
    super();
  }
  
  public static WebFormMd newInstance(MdFormDTO mdForm)
  {
    WebFormMd md = new WebFormMd();
    md.setDisplayLabel(mdForm.getDisplayLabel().getValue());
    md.setDescription(mdForm.getDescription().getValue());
    md.setFormMdClass(mdForm.getFormMdClassId());
    md.setFormName(mdForm.getFormName());
    md.setId(mdForm.getId());
    
    return md;
  }

}
