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
package com.runwaysdk.business;

import java.lang.reflect.Method;

import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.runwaysdk.constants.MdAttributeBooleanInfo;
import com.runwaysdk.constants.MdBusinessInfo;
import com.runwaysdk.dataaccess.io.TestFixtureFactory;
import com.runwaysdk.dataaccess.metadata.MdAttributeEnumerationDAO;
import com.runwaysdk.dataaccess.metadata.MdAttributeLocalCharacterDAO;
import com.runwaysdk.dataaccess.metadata.MdAttributeMultiReferenceDAO;
import com.runwaysdk.dataaccess.metadata.MdAttributeReferenceDAO;
import com.runwaysdk.dataaccess.metadata.MdAttributeStructDAO;
import com.runwaysdk.dataaccess.metadata.MdBusinessDAO;
import com.runwaysdk.dataaccess.metadata.MdEnumerationDAO;
import com.runwaysdk.dataaccess.metadata.MdLocalStructDAO;
import com.runwaysdk.dataaccess.metadata.MdRelationshipDAO;
import com.runwaysdk.dataaccess.metadata.MdStructDAO;
import com.runwaysdk.generation.loader.LoaderDecorator;

public class NoSourceGenTest extends TestCase
{
  public static Test suite()
  {
    TestSuite suite = new TestSuite(NoSourceGenTest.class.getSimpleName());
    suite.addTestSuite(NoSourceGenTest.class);

    return suite;
  }

  public void testReferenceNoSource() throws Exception
  {
    MdBusinessDAO referenceMdBusiness = TestFixtureFactory.createMdBusiness1();
    referenceMdBusiness.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
    referenceMdBusiness.apply();

    try
    {
      MdBusinessDAO mdBusiness = TestFixtureFactory.createMdBusiness2();
      mdBusiness.apply();

      try
      {
        MdAttributeReferenceDAO mdAttributeReference = TestFixtureFactory.addReferenceAttribute(mdBusiness, referenceMdBusiness, "testReference");
        mdAttributeReference.apply();

        Class<?> clazz = LoaderDecorator.load(mdBusiness.definesType());
        Method method = clazz.getMethod("getTestReference");
        Class<?> returnType = method.getReturnType();

        Assert.assertEquals(Business.class.getName(), returnType.getName());
      }
      finally
      {
        TestFixtureFactory.delete(mdBusiness);
      }

    }
    finally
    {
      TestFixtureFactory.delete(referenceMdBusiness);
    }
  }

  public void testMultiReferenceNoSource() throws Exception
  {
    MdBusinessDAO referenceMdBusiness = TestFixtureFactory.createMdBusiness1();
    referenceMdBusiness.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
    referenceMdBusiness.apply();

    try
    {
      MdBusinessDAO mdBusiness = TestFixtureFactory.createMdBusiness2();
      mdBusiness.apply();

      try
      {
        MdAttributeMultiReferenceDAO mdAttributeMultiReference = TestFixtureFactory.addMultiReferenceAttribute(mdBusiness, referenceMdBusiness);
        mdAttributeMultiReference.apply();
      }
      finally
      {
        TestFixtureFactory.delete(mdBusiness);
      }

    }
    finally
    {
      TestFixtureFactory.delete(referenceMdBusiness);
    }
  }

  public void testStructNoSource() throws Exception
  {
    MdStructDAO mdStruct = TestFixtureFactory.createMdStruct1();
    mdStruct.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
    mdStruct.apply();

    try
    {
      MdBusinessDAO mdBusiness = TestFixtureFactory.createMdBusiness2();
      mdBusiness.apply();

      try
      {
        MdAttributeStructDAO mdAttributeStruct = TestFixtureFactory.addStructAttribute(mdBusiness, mdStruct, "testStruct");
        mdAttributeStruct.apply();

        Class<?> clazz = LoaderDecorator.load(mdBusiness.definesType());
        Method method = clazz.getMethod("getTestStruct");
        Class<?> returnType = method.getReturnType();

        Assert.assertEquals(Struct.class.getName(), returnType.getName());
      }
      finally
      {
        TestFixtureFactory.delete(mdBusiness);
      }

    }
    finally
    {
      TestFixtureFactory.delete(mdStruct);
    }
  }

  public void testLocalStructNoSource() throws Exception
  {
    MdLocalStructDAO mdStruct = TestFixtureFactory.createMdLocalStruct();
    mdStruct.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
    mdStruct.apply();

    try
    {
      MdBusinessDAO mdBusiness = TestFixtureFactory.createMdBusiness2();
      mdBusiness.apply();

      try
      {
        MdAttributeLocalCharacterDAO mdAttributeLocalCharacter = TestFixtureFactory.addLocalCharacterAttribute(mdBusiness, mdStruct, "testStruct");
        mdAttributeLocalCharacter.apply();

        Class<?> clazz = LoaderDecorator.load(mdBusiness.definesType());
        Method method = clazz.getMethod("getTestStruct");
        Class<?> returnType = method.getReturnType();

        Assert.assertEquals(LocalStruct.class.getName(), returnType.getName());
      }
      finally
      {
        TestFixtureFactory.delete(mdBusiness);
      }

    }
    finally
    {
      TestFixtureFactory.delete(mdStruct);
    }
  }

  public void testParentAndChildNoSource() throws Exception
  {
    MdBusinessDAO referenceMdBusiness = TestFixtureFactory.createMdBusiness1();
    referenceMdBusiness.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
    referenceMdBusiness.apply();

    try
    {
      MdRelationshipDAO mdRelationship = TestFixtureFactory.createMdRelationship1(referenceMdBusiness, referenceMdBusiness);
      mdRelationship.apply();

      try
      {
        Class<?> clazz = LoaderDecorator.load(mdRelationship.definesType());
        Class<?> returnParent = clazz.getMethod("getParent").getReturnType();
        Class<?> returnChild = clazz.getMethod("getChild").getReturnType();

        Assert.assertEquals(Business.class.getName(), returnParent.getName());
        Assert.assertEquals(Business.class.getName(), returnChild.getName());
      }
      finally
      {
        TestFixtureFactory.delete(mdRelationship);
      }
    }
    finally
    {
      TestFixtureFactory.delete(referenceMdBusiness);
    }
  }

  public void testRelationshipNoSource() throws Exception
  {
    MdBusinessDAO parentMdBusiness = TestFixtureFactory.createMdBusiness1();
    parentMdBusiness.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
    parentMdBusiness.apply();

    try
    {
      MdBusinessDAO childMdBusiness = TestFixtureFactory.createMdBusiness2();
      childMdBusiness.apply();

      try
      {
        MdRelationshipDAO mdRelationship = TestFixtureFactory.createMdRelationship1(parentMdBusiness, childMdBusiness);
        mdRelationship.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
        mdRelationship.apply();

        try
        {
        }
        finally
        {
          TestFixtureFactory.delete(mdRelationship);
        }
      }
      finally
      {
        TestFixtureFactory.delete(childMdBusiness);
      }
    }
    finally
    {
      TestFixtureFactory.delete(parentMdBusiness);
    }
  }

  public void testEnumerationNoSource() throws Exception
  {
    MdBusinessDAO enumMaster = TestFixtureFactory.createEnumClass1();
    enumMaster.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
    enumMaster.apply();

    try
    {
      MdEnumerationDAO mdEnumeration = TestFixtureFactory.createMdEnumeation1(enumMaster);
      mdEnumeration.apply();

      try
      {
        MdBusinessDAO mdBusiness = TestFixtureFactory.createMdBusiness1();
        mdBusiness.apply();

        try
        {
          MdAttributeEnumerationDAO mdAttributeEnumeration = TestFixtureFactory.addEnumerationAttribute(mdBusiness, mdEnumeration);
          mdAttributeEnumeration.apply();
        }
        finally
        {
          TestFixtureFactory.delete(mdBusiness);
        }
      }
      finally
      {
        TestFixtureFactory.delete(mdEnumeration);
      }
    }
    finally
    {
      TestFixtureFactory.delete(enumMaster);
    }
  }

  public void testEnumerationAttributeNoSource() throws Exception
  {
    MdBusinessDAO enumMaster = TestFixtureFactory.createEnumClass1();
    enumMaster.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
    enumMaster.apply();

    try
    {
      MdEnumerationDAO mdEnumeration = TestFixtureFactory.createMdEnumeation1(enumMaster);
      mdEnumeration.setValue(MdBusinessInfo.GENERATE_SOURCE, MdAttributeBooleanInfo.FALSE);
      mdEnumeration.apply();

      try
      {
        MdBusinessDAO mdBusiness = TestFixtureFactory.createMdBusiness1();
        mdBusiness.apply();

        try
        {
          MdAttributeEnumerationDAO mdAttributeEnumeration = TestFixtureFactory.addEnumerationAttribute(mdBusiness, mdEnumeration);
          mdAttributeEnumeration.apply();
        }
        finally
        {
          TestFixtureFactory.delete(mdBusiness);
        }
      }
      finally
      {
        TestFixtureFactory.delete(mdEnumeration);
      }
    }
    finally
    {
      TestFixtureFactory.delete(enumMaster);
    }
  }

}
