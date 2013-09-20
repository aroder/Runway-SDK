/**
*
*/
package com.runwaysdk.business.ontology;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

import com.runwaysdk.constants.AssociationType;
import com.runwaysdk.constants.EntityCacheMaster;
import com.runwaysdk.constants.MdAttributeBooleanInfo;
import com.runwaysdk.constants.MdAttributeLocalInfo;
import com.runwaysdk.constants.MdTermInfo;
import com.runwaysdk.constants.MdTermRelationshipInfo;
import com.runwaysdk.constants.MdTreeInfo;
import com.runwaysdk.dataaccess.BusinessDAO;
import com.runwaysdk.generation.loader.LoaderDecorator;

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
public class OptimizationTest extends TestCase
{
  @Override
  public TestResult run()
  {
    return super.run();
  }

  @Override
  public void run(TestResult testResult)
  {
    super.run(testResult);
  }

  public static Test suite()
  {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(OptimizationTest.class);

    TestSetup wrapper = new TestSetup(suite)
    {
      protected void setUp() throws Exception
      {
        classSetUp();
      }

      protected void tearDown() throws Exception
      {
        classTearDown();
      }
    };

    return wrapper;
  }
  
  public static class TermHolder {
    public static String termAId;
    public static String termBId;
    public static String termCId;
    
    public static Term getTermA() { return getTerm(termAId); }
    public static Term getTermB() { return getTerm(termBId); }
    public static Term getTermC() { return getTerm(termCId); }
    
    public static Term getTerm(String id) {
      return (Term) Term.get(id);
    }
  }
  
  public static final String PACKAGE = "com.runwaysdk.test.business.ontology";
  public static MdTermDAO mdTerm;
  public static MdTermRelationshipDAO mdTermRelationship;
  public AbstractOntologyStrategy strategy = new DefaultStrategy();
  
  protected static void classSetUp() throws Exception
  {
    mdTerm = MdTermDAO.newInstance();
    mdTerm.setValue(MdTermInfo.NAME, "Alphabet");
    mdTerm.setValue(MdTermInfo.PACKAGE, PACKAGE);
    mdTerm.setStructValue(MdTermInfo.DISPLAY_LABEL, MdAttributeLocalInfo.DEFAULT_LOCALE, "JUnit Test Class");
    mdTerm.setStructValue(MdTermInfo.DESCRIPTION, MdAttributeLocalInfo.DEFAULT_LOCALE, "Temporary JUnit Test Class");
    mdTerm.setValue(MdTermInfo.EXTENDABLE, MdAttributeBooleanInfo.TRUE);
    mdTerm.setValue(MdTermInfo.ABSTRACT, MdAttributeBooleanInfo.FALSE);
    mdTerm.setValue(MdTermInfo.CACHE_ALGORITHM, EntityCacheMaster.CACHE_NOTHING.getId());
    mdTerm.apply();
    
    mdTermRelationship = MdTermRelationshipDAO.newInstance();
    mdTermRelationship.setValue(MdTreeInfo.NAME, "Sequential");
    mdTermRelationship.setValue(MdTreeInfo.PACKAGE, PACKAGE);
    mdTermRelationship.setStructValue(MdTreeInfo.DISPLAY_LABEL, MdAttributeLocalInfo.DEFAULT_LOCALE, "Sequential Relationship");
    mdTermRelationship.setValue(MdTreeInfo.PARENT_MD_BUSINESS, mdTerm.getId());
    mdTermRelationship.setValue(MdTreeInfo.PARENT_CARDINALITY, "*");
    mdTermRelationship.setStructValue(MdTreeInfo.PARENT_DISPLAY_LABEL, MdAttributeLocalInfo.DEFAULT_LOCALE, "Previous Letter");
    mdTermRelationship.setValue(MdTreeInfo.CHILD_MD_BUSINESS, mdTerm.getId());
    mdTermRelationship.setValue(MdTreeInfo.CHILD_CARDINALITY, "*");
    mdTermRelationship.setStructValue(MdTreeInfo.CHILD_DISPLAY_LABEL, MdAttributeLocalInfo.DEFAULT_LOCALE, "Next Letter");
    mdTermRelationship.setValue(MdTreeInfo.PARENT_METHOD, "ParentTerm");
    mdTermRelationship.setValue(MdTreeInfo.CHILD_METHOD, "ChildTerm");
    mdTermRelationship.setGenerateMdController(false);
    mdTermRelationship.addItem(MdTermRelationshipInfo.ASSOCIATION_TYPE, AssociationType.RELATIONSHIP.getId());
    mdTermRelationship.apply();
    
    BusinessDAO termA = BusinessDAO.newInstance(mdTerm.definesType());
    termA.apply();
    
    BusinessDAO termB = BusinessDAO.newInstance(mdTerm.definesType());
    termB.apply();
    termA.addChild(termB, mdTermRelationship.definesType()).apply();
    
    BusinessDAO termC = BusinessDAO.newInstance(mdTerm.definesType());
    termC.apply();
    termB.addChild(termC, mdTermRelationship.definesType()).apply();
    
    TermHolder.termAId = termA.getId();
    TermHolder.termBId = termB.getId();
    TermHolder.termCId = termC.getId();
  }

  protected static void classTearDown()
  {
    TermHolder.getTermA().delete();
    TermHolder.getTermB().delete();
    TermHolder.getTermC().delete();
    mdTermRelationship.delete();
    mdTerm.delete();
  }
  
  public void debugPrintTermTree(Term term) {
    System.out.println(term);
    
    if (term.getChildren(mdTermRelationship.definesType()).hasNext()) {
      System.out.println("^");
      debugPrintTermTree((Term) term.getChildren(mdTermRelationship.definesType()).next());
    }
  }
  
  public void testCopyTerm() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
  {
    Class<?> clazz = LoaderDecorator.load(mdTerm.definesType());
    Term termZ = (Term) clazz.newInstance();
    termZ.apply();
    
    debugPrintTermTree(TermHolder.getTermA());
    
    strategy.copyTerm(termZ, TermHolder.getTermA(), mdTermRelationship.definesType());
    
    System.out.println();
    debugPrintTermTree(termZ);
    
    Term ret = (Term) termZ.getChildren(mdTermRelationship.definesType()).next();
    assertNotNull(ret);
    
    assertNotNull(ret.getChildren(mdTermRelationship.definesType()).next());
    
    termZ.delete();
  }
  
  public void testIsLeafNode() throws InstantiationException, IllegalAccessException {
    Class<?> clazz = LoaderDecorator.load(mdTerm.definesType());
    Term termL = (Term) clazz.newInstance();
    termL.apply();
    
    assertTrue(strategy.isLeaf(termL, mdTermRelationship.definesType()));
    assertFalse(strategy.isLeaf(TermHolder.getTermA(), mdTermRelationship.definesType()));
    assertFalse(strategy.isLeaf(TermHolder.getTermB(), mdTermRelationship.definesType()));
    assertTrue(strategy.isLeaf(TermHolder.getTermC(), mdTermRelationship.definesType()));
    
    termL.delete();
  }
  
  public void testGetDirectDescendants() throws Exception {
    Class<?> clazz = LoaderDecorator.load(mdTerm.definesType());
    Term parent = (Term) clazz.newInstance();
    parent.apply();
    
    Term child1 = (Term) clazz.newInstance();
    child1.apply();
    parent.addChild(child1, mdTermRelationship.definesType()).apply();
    Term child2 = (Term) clazz.newInstance();
    child2.apply();
    parent.addChild(child2, mdTermRelationship.definesType()).apply();
    Term child3 = (Term) clazz.newInstance();
    child3.apply();
    parent.addChild(child3, mdTermRelationship.definesType()).apply();
    
    // Create a child of a child to make sure it doesn't get returned
    Term childOfChild = (Term) clazz.newInstance();
    childOfChild.apply();
    child3.addChild(childOfChild, mdTermRelationship.definesType()).apply();
    
    List<Term> descendants = strategy.getDirectDescendants(parent, mdTermRelationship.definesType());
    assertEquals(3, descendants.size());
    assertTrue(descendants.get(0) instanceof Term);
    assertTrue(descendants.get(1) instanceof Term);
    assertTrue(descendants.get(2) instanceof Term);
  }
  
  public void testGetDirectAncestors() throws Exception {
    Class<?> clazz = LoaderDecorator.load(mdTerm.definesType());
    Term child = (Term) clazz.newInstance();
    child.apply();
    
    Term parent1 = (Term) clazz.newInstance();
    parent1.apply();
    child.addParent(parent1, mdTermRelationship.definesType()).apply();
    Term parent2 = (Term) clazz.newInstance();
    parent2.apply();
    child.addParent(parent2, mdTermRelationship.definesType()).apply();
    Term parent3 = (Term) clazz.newInstance();
    parent3.apply();
    child.addParent(parent3, mdTermRelationship.definesType()).apply();
    
    // Create a parent of a parent to make sure it doesn't get returned
    Term parentOfParent = (Term) clazz.newInstance();
    parentOfParent.apply();
    parent3.addParent(parentOfParent, mdTermRelationship.definesType()).apply();
    
    List<Term> ancestors = strategy.getDirectAncestors(child, mdTermRelationship.definesType());
    assertEquals(3, ancestors.size());
    assertTrue(ancestors.get(0) instanceof Term);
    assertTrue(ancestors.get(1) instanceof Term);
    assertTrue(ancestors.get(2) instanceof Term);
  }
  
  public void testGetAllDescendants() throws Exception {
    List<Term> descendents = strategy.getAllDescendants(TermHolder.getTermA(), mdTermRelationship.definesType());
    Iterator<Term> it = descendents.iterator();
    assertEquals(it.next(), TermHolder.getTermB());
    assertEquals(it.next(), TermHolder.getTermC());
  }
  
  public void testGetAllAncestors() throws Exception {
    List<Term> ancestors = strategy.getAllAncestors(TermHolder.getTermC(), mdTermRelationship.definesType());
    Iterator<Term> it = ancestors.iterator();
    assertEquals(it.next(), TermHolder.getTermB());
    assertEquals(it.next(), TermHolder.getTermA());
  }
}
