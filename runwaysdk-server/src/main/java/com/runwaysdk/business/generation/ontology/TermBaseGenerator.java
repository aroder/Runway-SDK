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
package com.runwaysdk.business.generation.ontology;

import com.runwaysdk.business.generation.BusinessBaseGenerator;
import com.runwaysdk.business.ontology.Term;
import com.runwaysdk.dataaccess.MdBusinessDAOIF;
import com.runwaysdk.dataaccess.MdClassDAOIF;

public class TermBaseGenerator extends BusinessBaseGenerator
{
  public TermBaseGenerator(MdBusinessDAOIF mdBusinessIF)
  {
    super(mdBusinessIF);
  }
  
  @Override
  protected String getExtends(MdClassDAOIF parent)
  {
    if (parent==null)
    {
      return Term.class.getName();
    }
    else
    {
      return getParentClass(parent);
    }
  }
  
//  @Override
//  protected void addStaticInitializerBlock() {
//    getWriter().writeLine("static ");
//    getWriter().openBracket();
//    getWriter().writeLine(Term.class.getName() + ".assignStrategy(\"" + this.getMdTypeDAOIF().getPackage() + "." + this.getSubClassName() + "\");");
//    getWriter().closeBracket();
//  }
  
//  @Override
//  protected void addConstructor()
//  {
//    String baseTypeName = this.getBaseClassName();
//    
//    //Constructor for the base class
//    getWriter().writeLine("public " + baseTypeName + "()");
//    getWriter().openBracket();
//    getWriter().writeLine("super();");
//    addStructInitializers();
//    getWriter().writeLine("");
//    getWriter().closeBracket();
//    getWriter().writeLine("");
//  }
}
