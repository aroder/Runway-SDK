/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Runway SDK GIS(tm).
 *
 * Runway SDK GIS(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Runway SDK GIS(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Runway SDK GIS(tm).  If not, see <http://www.gnu.org/licenses/>.
 */
package com.runwaysdk.gis.geo;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.runwaysdk.business.ontology.OntologyStrategyIF;
import com.runwaysdk.dataaccess.RelationshipRecursionException;
import com.runwaysdk.dataaccess.transaction.Transaction;
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.session.Request;
import com.runwaysdk.system.gis.geo.AllowedIn;
import com.runwaysdk.system.gis.geo.AllowedInQuery;
import com.runwaysdk.system.gis.geo.Universal;
import com.runwaysdk.system.ontology.ImmutableRootException;

public class UniversalTest
{
  @BeforeClass
  @Request
  public static void classSetup()
  {
    classSetupInTransaction();
  }

  @Transaction
  public static void classSetupInTransaction()
  {
    OntologyStrategyIF strategy = Universal.getStrategy();

    if (!strategy.isInitialized())
    {
      strategy.initialize(AllowedIn.CLASS);
    }
  }

  @AfterClass
  @Request
  public static void classTearDown()
  {
    OntologyStrategyIF strategy = Universal.getStrategy();
    strategy.shutdown();
  }

  @Test
  @Request
  public void testGetRoot()
  {
    Universal root = Universal.getRoot();

    Assert.assertNotNull(root);
    Assert.assertEquals(Universal.ROOT, root.getUniversalId());
  }

  @Test
  @Request
  public void testUniversalCRUD()
  {
    Universal universal = new Universal();
    universal.setUniversalId("TestUniversal");
    universal.getDisplayLabel().setValue("Test Universal");
    universal.getDescription().setValue("Test Description");
    universal.apply();

    try
    {
      Universal test = Universal.get(universal.getId());

      // TEST THE VALUE FROM THE READ
      Assert.assertNotNull(test);
      Assert.assertEquals(universal.getUniversalId(), test.getUniversalId());
      Assert.assertEquals(universal.getDisplayLabel().getValue(), test.getDisplayLabel().getValue());
      Assert.assertEquals(universal.getDescription().getValue(), test.getDescription().getValue());
    }
    finally
    {
      universal.delete();
    }
  }

  @Test
  @Request
  public void testAllowedInCRUD()
  {
    Universal parent = new Universal();
    parent.setUniversalId("Parent");
    parent.getDisplayLabel().setValue("Parent");
    parent.getDescription().setValue("Parent");
    parent.apply();

    try
    {
      Universal child = new Universal();
      child.setUniversalId("Child");
      child.getDisplayLabel().setValue("Child");
      child.getDescription().setValue("Child");
      child.apply();

      try
      {
        AllowedIn allowedIn = new AllowedIn(parent, child);
        allowedIn.apply();

        List<? extends Universal> children = parent.getAllContains().getAll();

        Assert.assertEquals(1, children.size());
        Assert.assertEquals(child.getId(), children.get(0).getId());

        List<? extends Universal> parents = child.getAllAllowedIn().getAll();

        Assert.assertEquals(1, parents.size());
        Assert.assertEquals(parent.getId(), parents.get(0).getId());
      }
      finally
      {
        child.delete();
      }
    }
    finally
    {
      parent.delete();
    }
  }

  @Test
  @Request
  public void testCycle()
  {
    Universal parent = new Universal();
    parent.setUniversalId("Parent");
    parent.getDisplayLabel().setValue("Parent");
    parent.getDescription().setValue("Parent");
    parent.apply();

    try
    {
      Universal child = new Universal();
      child.setUniversalId("Child");
      child.getDisplayLabel().setValue("Child");
      child.getDescription().setValue("Child");
      child.apply();

      try
      {
        AllowedIn allowedIn = new AllowedIn(parent, child);
        allowedIn.apply();

        try
        {
          new AllowedIn(child, parent).apply();

          Assert.fail("Able to create an allowed in cycle between two nodes");
        }
        catch (RelationshipRecursionException e)
        {
          // This is expected
        }
      }
      finally
      {
        child.delete();
      }
    }
    finally
    {
      parent.delete();
    }
  }

  /**
   * Tests all recursive descendants of a universal.
   */
  @Test
  @Request
  public void testAllDescendants()
  {
    try
    {
      Universal uA = GISTestFactory.createAndApplyUniversal("A");

      Universal uB = GISTestFactory.createAndApplyUniversal("B");

      Universal uC = GISTestFactory.createAndApplyUniversal("C");

      Universal uD = GISTestFactory.createAndApplyUniversal("D");

      Universal uE = GISTestFactory.createAndApplyUniversal("E");

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      uA.addLink(uB, AllowedIn.CLASS);
      uB.addLink(uC, AllowedIn.CLASS);
      uB.addLink(uD, AllowedIn.CLASS);
      uC.addLink(uE, AllowedIn.CLASS);

      Assert.assertEquals(3, uE.getAllDescendants(AllowedIn.CLASS).getAll().size());
      Assert.assertEquals(2, uD.getAllDescendants(AllowedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteUniversals("A", "B", "C", "D", "E");
    }
  }

  /**
   * Tests all recursive ancestors of a universal.
   */
  @Test
  @Request
  public void testAllAncestors()
  {
    try
    {
      Universal uA = GISTestFactory.createAndApplyUniversal("A");

      Universal uB = GISTestFactory.createAndApplyUniversal("B");

      Universal uC = GISTestFactory.createAndApplyUniversal("C");

      Universal uD = GISTestFactory.createAndApplyUniversal("D");

      Universal uE = GISTestFactory.createAndApplyUniversal("E");

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      uA.addLink(uB, AllowedIn.CLASS);
      uB.addLink(uC, AllowedIn.CLASS);
      uB.addLink(uD, AllowedIn.CLASS);
      uC.addLink(uE, AllowedIn.CLASS);

      Assert.assertEquals(4, uA.getAllAncestors(AllowedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteUniversals("A", "B", "C", "D", "E");
    }
  }

  /**
   * Tests all direct ancestors of a universal.
   */
  @Test
  @Request
  public void testDirectAncestors()
  {
    try
    {
      Universal uA = GISTestFactory.createAndApplyUniversal("A");

      Universal uB = GISTestFactory.createAndApplyUniversal("B");

      Universal uC = GISTestFactory.createAndApplyUniversal("C");

      Universal uD = GISTestFactory.createAndApplyUniversal("D");

      Universal uE = GISTestFactory.createAndApplyUniversal("E");

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      uA.addLink(uB, AllowedIn.CLASS);
      uB.addLink(uC, AllowedIn.CLASS);
      uB.addLink(uD, AllowedIn.CLASS);
      uC.addLink(uE, AllowedIn.CLASS);

      Assert.assertEquals(1, uA.getDirectAncestors(AllowedIn.CLASS).getAll().size());
      Assert.assertEquals(2, uB.getDirectAncestors(AllowedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteUniversals("A", "B", "C", "D", "E");
    }
  }

  /**
   * Tests all direct descendants of a universal.
   */
  @Test
  @Request
  public void testDirectDescendants()
  {
    try
    {
      Universal uA = GISTestFactory.createAndApplyUniversal("A");

      Universal uB = GISTestFactory.createAndApplyUniversal("B");

      Universal uC = GISTestFactory.createAndApplyUniversal("C");

      Universal uD = GISTestFactory.createAndApplyUniversal("D");

      Universal uE = GISTestFactory.createAndApplyUniversal("E");

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      uA.addLink(uB, AllowedIn.CLASS);
      uB.addLink(uC, AllowedIn.CLASS);
      uB.addLink(uD, AllowedIn.CLASS);
      uC.addLink(uE, AllowedIn.CLASS);

      Assert.assertEquals(0, uA.getDirectDescendants(AllowedIn.CLASS).getAll().size());
      Assert.assertEquals(1, uB.getDirectDescendants(AllowedIn.CLASS).getAll().size());
      Assert.assertEquals(1, uE.getDirectDescendants(AllowedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteUniversals("A", "B", "C", "D", "E");
    }
  }

  /**
   * Tests that multiple parents are supported.
   */
  @Test
  @Request
  public void testMulitpleParents()
  {
    try
    {
      Universal uA = GISTestFactory.createAndApplyUniversal("A");

      Universal uB = GISTestFactory.createAndApplyUniversal("B");

      Universal uC = GISTestFactory.createAndApplyUniversal("C");

      // Path 1: A -> B
      // Path 2: A -> C
      uA.addLink(uB, AllowedIn.CLASS);
      uA.addLink(uC, AllowedIn.CLASS);

      Assert.assertEquals(2, uA.getDirectAncestors(AllowedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteUniversals("A", "B", "C");
    }
  }

  /**
   * Appends a Universal leaf node to D that is then deleted.
   */
  @Test
  @Request
  public void testDeleteLeaf()
  {
    try
    {
      Universal uA = GISTestFactory.createAndApplyUniversal("A");

      Universal uB = GISTestFactory.createAndApplyUniversal("B");

      Universal uC = GISTestFactory.createAndApplyUniversal("C");

      Universal uD = GISTestFactory.createAndApplyUniversal("D");

      Universal uE = GISTestFactory.createAndApplyUniversal("E");

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      uA.addLink(uB, AllowedIn.CLASS);
      uB.addLink(uC, AllowedIn.CLASS);
      uB.addLink(uD, AllowedIn.CLASS);
      uC.addLink(uE, AllowedIn.CLASS);

      Assert.assertEquals(0, uA.getDirectDescendants(AllowedIn.CLASS).getAll().size());
      Assert.assertEquals(1, uB.getDirectDescendants(AllowedIn.CLASS).getAll().size());
      Assert.assertEquals(1, uE.getDirectDescendants(AllowedIn.CLASS).getAll().size());

      uA.delete();

      Assert.assertEquals(0, uB.getDirectDescendants(AllowedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteUniversals("A", "B", "C", "D", "E");
    }
  }

  /**
   * Appends a sub tree whose root is deleted then checks to make sure the
   * orphaned Universal objects are placed beneath the root.
   */
  @Test
  @Request
  public void testDeleteNonLeaf()
  {
    try
    {
      Universal uA = GISTestFactory.createAndApplyUniversal("A");

      Universal uB = GISTestFactory.createAndApplyUniversal("B");

      Universal uC = GISTestFactory.createAndApplyUniversal("C");

      Universal uD = GISTestFactory.createAndApplyUniversal("D");

      Universal uE = GISTestFactory.createAndApplyUniversal("E");

      Universal root = Universal.getRoot();

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      uA.addLink(uB, AllowedIn.CLASS);
      uB.addLink(uC, AllowedIn.CLASS);
      uB.addLink(uD, AllowedIn.CLASS);
      uC.addLink(uE, AllowedIn.CLASS);
      uD.addLink(root, AllowedIn.CLASS);
      uE.addLink(root, AllowedIn.CLASS);

      Assert.assertEquals(0, uA.getDirectDescendants(AllowedIn.CLASS).getAll().size());
      Assert.assertEquals(1, uB.getDirectDescendants(AllowedIn.CLASS).getAll().size());
      Assert.assertEquals(1, uE.getDirectDescendants(AllowedIn.CLASS).getAll().size());
      Assert.assertEquals(2, root.getDirectDescendants(AllowedIn.CLASS).getAll().size());

      uB.delete();

      Assert.assertEquals(3, root.getDirectDescendants(AllowedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteUniversals("A", "B", "C", "D", "E");
    }
  }

//  /**
//   * Ensures that the Root universal exists as the default parent of created
//   * Universals A and E.
//   */
//  @Test
//  @Request
//  public void tesRootUniversalAsDefault()
//  {
//    try
//    {
//      Universal uA = GISTestFactory.createAndApplyUniversal("A");
//
//      Universal root = Universal.getRoot();
//
//      List<Term> ancestors = uA.getAllAncestors(AllowedIn.CLASS);
//
//      Assert.assertEquals(1, ancestors.size());
//      Assert.assertEquals(root.getId(), ancestors.get(0).getId());
//    }
//    finally
//    {
//      GISTestFactory.deleteUniversals("A", "B", "C", "D", "E");
//    }
//  }

  /**
   * Tests the direct parent of a universal.
   */
  @Test
  @Request
  public void testDirectParents()
  {
    try
    {
      Universal uA = GISTestFactory.createAndApplyUniversal("A");

      Universal uB = GISTestFactory.createAndApplyUniversal("B");

      Universal uC = GISTestFactory.createAndApplyUniversal("C");

      Universal uD = GISTestFactory.createAndApplyUniversal("D");

      Universal uE = GISTestFactory.createAndApplyUniversal("E");

      Universal root = Universal.getRoot();

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      uA.addLink(uB, AllowedIn.CLASS);
      uB.addLink(uC, AllowedIn.CLASS);
      uB.addLink(uD, AllowedIn.CLASS);
      uC.addLink(uE, AllowedIn.CLASS);
      uD.addLink(root, AllowedIn.CLASS);
      uE.addLink(root, AllowedIn.CLASS);

      this.assertAllowedIn(uB, uC);
      this.assertAllowedIn(uB, uD);
      this.assertAllowedIn(uA, uB);
      this.assertAllowedIn(uC, uE);
    }
    finally
    {
      GISTestFactory.deleteUniversals("A", "B", "C", "D", "E");
    }
  }

  /**
   * Tests that the root universal cannot have a parent.
   */
  @Test
  @Request
  public void testAddParentToRoot()
  {
    try
    {
      Universal uA = GISTestFactory.createAndApplyUniversal("A");

      Universal root = Universal.getRoot();

      try
      {
        root.addLink(uA, AllowedIn.CLASS);

        Assert.fail("Able to add a parent to root");
      }
      catch (ImmutableRootException e)
      {
        // This is expected
      }
    }
    finally
    {
      GISTestFactory.deleteUniversals("A");
    }
  }

  /**
   * Ensures that the Root class behaves as a singleton and cannot be deleted.
   */
  @Test(expected = ImmutableRootException.class)
  @Request
  public void testRootCannotDelete()
  {
    Universal.getRoot().delete();
  }

  /**
   * Ensures that the node cannot be changed.
   */
  @Test(expected = ImmutableRootException.class)
  @Request
  public void testRootImmutable()
  {
    Universal root = Universal.getRoot();
    root.appLock();

    root.setUniversalId("Different");
    root.apply();
  }

  /**
   * Checks if the given parent and child are related directly through the
   * AllowedIn relationship.
   * 
   * @param child
   * @param parent
   */
  private void assertAllowedIn(Universal child, Universal parent)
  {
    AllowedInQuery q = new AllowedInQuery(new QueryFactory());
    q.WHERE(q.childId().EQ(child.getId()));
    q.AND(q.parentId().EQ(parent.getId()));

    OIterator<? extends AllowedIn> iter = q.getIterator();
    try
    {
      if (!iter.hasNext())
      {
        // error...no parent/child record found
        Assert.fail("The AllowedIn relationship with child [" + child + "] and parent [" + parent + "] does not exist.");
      }
    }
    finally
    {
      iter.close();
    }
  }
  
}
