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
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.session.Request;
import com.runwaysdk.system.gis.geo.AllowedIn;
import com.runwaysdk.system.gis.geo.GeoEntity;
import com.runwaysdk.system.gis.geo.InvalidGeoEntityUniversalException;
import com.runwaysdk.system.gis.geo.InvalidUniversalRemoveLinkException;
import com.runwaysdk.system.gis.geo.LocatedIn;
import com.runwaysdk.system.gis.geo.LocatedInQuery;
import com.runwaysdk.system.gis.geo.Universal;
import com.runwaysdk.system.ontology.ImmutableRootException;
import com.runwaysdk.system.ontology.TermUtil;

public class GeoEntityTest
{
  // Universal Tree:
  // Path 1: A -> B -> C -> E
  // Path 2: A -> B -> D

  private static Universal uA;

  private static Universal uB;

  private static Universal uC;

  private static Universal uD;

  private static Universal uE;

  @BeforeClass
  @Request
  public static void classSetUp()
  {
    /*
     * Initialize the GeoEntity strategy
     */
    OntologyStrategyIF geoEntityStrategy = GeoEntity.getStrategy();

    if (!geoEntityStrategy.isInitialized())
    {
      geoEntityStrategy.initialize(LocatedIn.CLASS);
    }

    /*
     * Initialize the Universal strategy
     */
    OntologyStrategyIF universalStrategy = Universal.getStrategy();

    if (!universalStrategy.isInitialized())
    {
      universalStrategy.initialize(AllowedIn.CLASS);
    }

    /*
     * Create the universal ontology structure
     */
    uA = GISTestFactory.createAndApplyUniversal("A");
    uB = GISTestFactory.createAndApplyUniversal("B");
    uC = GISTestFactory.createAndApplyUniversal("C");
    uD = GISTestFactory.createAndApplyUniversal("D");
    uE = GISTestFactory.createAndApplyUniversal("E");

    Universal root = Universal.getRoot();

    uA.addLink(uB, AllowedIn.CLASS);
    uB.addLink(uC, AllowedIn.CLASS);
    uB.addLink(uD, AllowedIn.CLASS);
    uC.addLink(uE, AllowedIn.CLASS);
    uD.addLink(root, AllowedIn.CLASS);
    uE.addLink(root, AllowedIn.CLASS);
  }

  @AfterClass
  @Request
  public static void classTearDown()
  {
    /*
     * Delete the universal tree structure
     */
    GISTestFactory.deleteUniversals("A", "B", "C", "D", "E");

    /*
     * Delete the universal strategy
     */
    Universal.getStrategy().shutdown();

    /*
     * Delete the geo entity strategy
     */
    GeoEntity.getStrategy().shutdown();
  }

  @Test
  @Request
  public void testGetRoot()
  {
    GeoEntity root = GeoEntity.getRoot();

    Assert.assertNotNull(root);
    Assert.assertEquals(GeoEntity.ROOT, root.getGeoId());
    Assert.assertEquals(Universal.ROOT, root.getUniversal().getUniversalId());
  }

  @Test
  @Request
  public void testGeoEntityCRUD()
  {
    GeoEntity entity = new GeoEntity();
    entity.setGeoId("Test");
    entity.getDisplayLabel().setValue("Test Name");
    entity.setUniversal(uB);
    entity.apply();

    try
    {
      GeoEntity test = GeoEntity.get(entity.getId());

      Assert.assertNotNull(test);
      Assert.assertEquals(entity.getGeoId(), test.getGeoId());
      Assert.assertEquals(entity.getUniversalId(), test.getUniversalId());
      Assert.assertEquals(entity.getDisplayLabel().getValue(), test.getDisplayLabel().getValue());
    }
    finally
    {
      entity.delete();
    }
  }

  @Test
  @Request
  public void testLocatedInCRUD()
  {
    GeoEntity parent = new GeoEntity();
    parent.setGeoId("Parent");
    parent.getDisplayLabel().setValue("Parent Name");
    parent.setUniversal(uB);
    parent.apply();

    try
    {
      GeoEntity child = new GeoEntity();
      child.setGeoId("Child");
      child.getDisplayLabel().setValue("Child Name");
      child.setUniversal(uA);
      child.apply();

      try
      {
        LocatedIn locatedIn = new LocatedIn(parent, child);
        locatedIn.apply();

        List<? extends GeoEntity> children = parent.getAllContains().getAll();

        Assert.assertEquals(1, children.size());
        Assert.assertEquals(child.getId(), children.get(0).getId());

        List<? extends GeoEntity> parents = child.getAllLocatedIn().getAll();

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
  public void testLocatedInCycle()
  {
    GeoEntity parent = new GeoEntity();
    parent.setGeoId("Parent");
    parent.getDisplayLabel().setValue("Parent Name");
    parent.setUniversal(uB);
    parent.apply();

    try
    {
      GeoEntity child = new GeoEntity();
      child.setGeoId("Child");
      child.getDisplayLabel().setValue("Child Name");
      child.setUniversal(uA);
      child.apply();

      try
      {
        new LocatedIn(parent, child).apply();

        try
        {
          new LocatedIn(child, parent).apply();

          Assert.fail("Able to create a located in cycle between two nodes");
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
   * Tests that multiple parents are supported.
   */
  @Test
  @Request
  public void testMulitpleParents()
  {
    try
    {
      GeoEntity gA = GISTestFactory.createAndApplyGeoEntity("A", uA);
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gC = GISTestFactory.createAndApplyGeoEntity("C", uC);

      // Path 1: A -> B
      // Path 2: A -> C
      gA.addLink(gB, LocatedIn.CLASS);
      gA.addLink(gC, LocatedIn.CLASS);

      Assert.assertEquals(2, gA.getDirectAncestors(LocatedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("A", "B", "C");
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
      GeoEntity gA = GISTestFactory.createAndApplyGeoEntity("A", uA);
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gC = GISTestFactory.createAndApplyGeoEntity("C", uC);
      GeoEntity gD = GISTestFactory.createAndApplyGeoEntity("D", uD);
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      gA.addLink(gB, LocatedIn.CLASS);
      gB.addLink(gC, LocatedIn.CLASS);
      gB.addLink(gD, LocatedIn.CLASS);
      gC.addLink(gE, LocatedIn.CLASS);

      Assert.assertEquals(3, gE.getAllDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(2, gD.getAllDescendants(LocatedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("A", "B", "C", "D", "E");
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
      GeoEntity gA = GISTestFactory.createAndApplyGeoEntity("A", uA);
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gC = GISTestFactory.createAndApplyGeoEntity("C", uC);
      GeoEntity gD = GISTestFactory.createAndApplyGeoEntity("D", uD);
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      gA.addLink(gB, LocatedIn.CLASS);
      gB.addLink(gC, LocatedIn.CLASS);
      gB.addLink(gD, LocatedIn.CLASS);
      gC.addLink(gE, LocatedIn.CLASS);

      Assert.assertEquals(4, gA.getAllAncestors(LocatedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("A", "B", "C", "D", "E");
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
      GeoEntity gA = GISTestFactory.createAndApplyGeoEntity("A", uA);
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gC = GISTestFactory.createAndApplyGeoEntity("C", uC);
      GeoEntity gD = GISTestFactory.createAndApplyGeoEntity("D", uD);
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      gA.addLink(gB, LocatedIn.CLASS);
      gB.addLink(gC, LocatedIn.CLASS);
      gB.addLink(gD, LocatedIn.CLASS);
      gC.addLink(gE, LocatedIn.CLASS);

      Assert.assertEquals(1, gA.getDirectAncestors(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(2, gB.getDirectAncestors(LocatedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("A", "B", "C", "D", "E");
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
      GeoEntity gA = GISTestFactory.createAndApplyGeoEntity("A", uA);
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gC = GISTestFactory.createAndApplyGeoEntity("C", uC);
      GeoEntity gD = GISTestFactory.createAndApplyGeoEntity("D", uD);
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      gA.addLink(gB, LocatedIn.CLASS);
      gB.addLink(gC, LocatedIn.CLASS);
      gB.addLink(gD, LocatedIn.CLASS);
      gC.addLink(gE, LocatedIn.CLASS);

      Assert.assertEquals(0, gA.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(1, gB.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(1, gE.getDirectDescendants(LocatedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("A", "B", "C", "D", "E");
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
      GeoEntity gA = GISTestFactory.createAndApplyGeoEntity("A", uA);
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gC = GISTestFactory.createAndApplyGeoEntity("C", uC);
      GeoEntity gD = GISTestFactory.createAndApplyGeoEntity("D", uD);
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      gA.addLink(gB, LocatedIn.CLASS);
      gB.addLink(gC, LocatedIn.CLASS);
      gB.addLink(gD, LocatedIn.CLASS);
      gC.addLink(gE, LocatedIn.CLASS);

      Assert.assertEquals(0, gA.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(1, gB.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(1, gE.getDirectDescendants(LocatedIn.CLASS).getAll().size());

      gA.delete();

      Assert.assertEquals(0, gB.getDirectDescendants(LocatedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("A", "B", "C", "D", "E");
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
      GeoEntity gA = GISTestFactory.createAndApplyGeoEntity("A", uA);
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gC = GISTestFactory.createAndApplyGeoEntity("C", uC);
      GeoEntity gD = GISTestFactory.createAndApplyGeoEntity("D", uD);
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);
      GeoEntity root = GeoEntity.getRoot();

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      gA.addLink(gB, LocatedIn.CLASS);
      gB.addLink(gC, LocatedIn.CLASS);
      gB.addLink(gD, LocatedIn.CLASS);
      gC.addLink(gE, LocatedIn.CLASS);
      gD.addLink(root, LocatedIn.CLASS);
      gE.addLink(root, LocatedIn.CLASS);

      Assert.assertEquals(0, gA.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(1, gB.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(1, gE.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(2, root.getDirectDescendants(LocatedIn.CLASS).getAll().size());

      gB.delete();

      Assert.assertEquals(2, root.getDirectDescendants(LocatedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("A", "B", "C", "D", "E");
    }
  }

  @Test
  @Request
  public void testMove()
  {
    try
    {
      GeoEntity gA = GISTestFactory.createAndApplyGeoEntity("A", uA);
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gC = GISTestFactory.createAndApplyGeoEntity("C", uC);
      GeoEntity gD = GISTestFactory.createAndApplyGeoEntity("D", uD);
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);
      GeoEntity root = GeoEntity.getRoot();

      // Path 1: A -> B -> C -> E
      // Path 2: D
      gA.addLink(gB, LocatedIn.CLASS);
      gB.addLink(gC, LocatedIn.CLASS);
      gC.addLink(gE, LocatedIn.CLASS);
      gD.addLink(root, LocatedIn.CLASS);
      gE.addLink(root, LocatedIn.CLASS);

      Assert.assertEquals(0, gA.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(1, gB.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(1, gE.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(2, root.getDirectDescendants(LocatedIn.CLASS).getAll().size());
      Assert.assertEquals(0, gD.getDirectDescendants(LocatedIn.CLASS).getAll().size());

      // This is a semantic move operation
      gB.removeLink(gC, LocatedIn.CLASS);
      gB.addLink(gD, LocatedIn.CLASS);

      Assert.assertEquals(2, gD.getAllDescendants(LocatedIn.CLASS).getAll().size());
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("A", "B", "C", "D", "E");
    }
  }

  /**
   * Tests the direct parent of a universal.
   */
  @Test
  @Request
  public void testDirectParents()
  {
    try
    {
      GeoEntity gA = GISTestFactory.createAndApplyGeoEntity("A", uA);
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gC = GISTestFactory.createAndApplyGeoEntity("C", uC);
      GeoEntity gD = GISTestFactory.createAndApplyGeoEntity("D", uD);
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);
      GeoEntity root = GeoEntity.getRoot();

      // Path 1: A -> B -> C -> E
      // Path 2: A -> B -> D
      gA.addLink(gB, LocatedIn.CLASS);
      gB.addLink(gC, LocatedIn.CLASS);
      gB.addLink(gD, LocatedIn.CLASS);
      gC.addLink(gE, LocatedIn.CLASS);
      gD.addLink(root, LocatedIn.CLASS);
      gE.addLink(root, LocatedIn.CLASS);

      this.assertLocatedIn(gB, gC);
      this.assertLocatedIn(gB, gD);
      this.assertLocatedIn(gA, gB);
      this.assertLocatedIn(gC, gE);
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("A", "B", "C", "D", "E");
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
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);
      GeoEntity root = GeoEntity.getRoot();

      try
      {
        root.addLink(gE, LocatedIn.CLASS);

        Assert.fail("Able to add a parent to root");
      }
      catch (ImmutableRootException e)
      {
        // This is expected
      }
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("E");
    }
  }

  /**
   * Ensures that the node cannot be changed.
   */
  @Test(expected = ImmutableRootException.class)
  @Request
  public void testRootImmutable()
  {
    GeoEntity root = GeoEntity.getRoot();
    root.appLock();

    root.setGeoId("Different");
    root.apply();
  }

  /**
   * Ensures that the Root class behaves as a singleton and cannot be deleted.
   */
  @Test(expected = ImmutableRootException.class)
  @Request
  public void testRootCannotDelete()
  {
    GeoEntity.getRoot().delete();
  }

  /**
   * Ensures a child geo entity must reference a universal which is a child of
   * the parent geo entity's universal
   */
  @Test(expected = InvalidGeoEntityUniversalException.class)
  @Request
  public void testInvalidUniversal()
  {
    try
    {
      GeoEntity parent = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity child = GISTestFactory.createAndApplyGeoEntity("E", uE);

      child.addLink(parent, LocatedIn.CLASS);
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("B", "E");
    }
  }

  /**
   * Test to ensure that a geo entity can be assigned to a parent with a
   * non-direct descendant universal of the parent's universal
   */
  @Test
  @Request
  public void testDescendantUniversal()
  {
    try
    {
      GeoEntity gB = GISTestFactory.createAndApplyGeoEntity("B", uB);
      GeoEntity gE = GISTestFactory.createAndApplyGeoEntity("E", uE);

      gB.addLink(gE, LocatedIn.CLASS);

      this.assertLocatedIn(gB, gE);
    }
    finally
    {
      GISTestFactory.deleteGeoEntities("B", "E");
    }
  }
  
  /**
   * This test attempts to invalidate the GeoEntity tree by modifying the Universal tree, and asserts that a proper exception is thrown
   */
  @Test
  @Request
  public void testInvalidateGeoEntityTree() {
    try {
      Universal uUSA = GISTestFactory.createAndApplyUniversal("USA", Universal.getRoot());
      Universal uState = GISTestFactory.createAndApplyUniversal("State", uUSA);
      Universal uCity = GISTestFactory.createAndApplyUniversal("City", uState);
      Universal uUganda = GISTestFactory.createAndApplyUniversal("Uganda", Universal.getRoot());
  //    uState.addLink(uUganda, AllowedIn.CLASS);
      
      GeoEntity gUSA = GISTestFactory.createAndApplyGeoEntity("USA", uUSA, GeoEntity.getRoot());
      GeoEntity gColorado = GISTestFactory.createAndApplyGeoEntity("Colorado", uState, gUSA);
      GeoEntity gDenver = GISTestFactory.createAndApplyGeoEntity("Denver", uCity, gColorado);
      
      // Test 1) Most basic remove link that should fail.
      try {
        uCity.removeLink(uState, AllowedIn.CLASS);
        Assert.fail("An exception was not thrown on the 1st removeLink test.");
      }
      catch (InvalidUniversalRemoveLinkException e) {
        // Expected
      }
      
      // Test 2) Move Denver under USA. We should then be able to move the City Universal under USA and the enforcement check should pass.
      TermUtil.addAndRemoveLink(gDenver.getId(), gColorado.getId(), LocatedIn.CLASS, gUSA.getId(), LocatedIn.CLASS);
      TermUtil.addAndRemoveLink(uCity.getId(), uState.getId(), AllowedIn.CLASS, uUSA.getId(), AllowedIn.CLASS);
      TermUtil.addAndRemoveLink(uCity.getId(), uUSA.getId(), AllowedIn.CLASS, uState.getId(), AllowedIn.CLASS); // Undo it
      TermUtil.addAndRemoveLink(gDenver.getId(), gUSA.getId(), LocatedIn.CLASS, gColorado.getId(), LocatedIn.CLASS); // Undo it
      
      // Test 3) Moving the State Universal to Uganda should fail.
      try {
        TermUtil.addAndRemoveLink(uState.getId(), uUSA.getId(), AllowedIn.CLASS, uUganda.getId(), AllowedIn.CLASS);
        Assert.fail("An exception was not thrown on the 3rd removeLink test.");
      }
      catch (InvalidUniversalRemoveLinkException e) {
        // Expected
      }
      
      // Test 4) Moving the City Universal to Uganda should fail.
      try {
        TermUtil.addAndRemoveLink(uCity.getId(), uState.getId(), AllowedIn.CLASS, uUganda.getId(), AllowedIn.CLASS);
        Assert.fail("An exception was not thrown on the 4th removeLink test.");
      }
      catch (InvalidUniversalRemoveLinkException e) {
        // Expected
      }
    }
    finally {
      GISTestFactory.deleteUniversals("USA", "State", "City", "Uganda");
    }
  }

  /**
   * Checks if the given parent and child are related directly through the
   * LocatedIn relationship.
   * 
   * @param child
   * @param parent
   */
  private void assertLocatedIn(GeoEntity child, GeoEntity parent)
  {
    LocatedInQuery q = new LocatedInQuery(new QueryFactory());
    q.WHERE(q.childId().EQ(child.getId()));
    q.AND(q.parentId().EQ(parent.getId()));

    OIterator<? extends LocatedIn> iter = q.getIterator();
    try
    {
      if (!iter.hasNext())
      {
        // error...no parent/child record found
        Assert.fail("The LocatedIn relationship with child [" + child + "] and parent [" + parent + "] does not exist.");
      }
    }
    finally
    {
      iter.close();
    }
  }
}
