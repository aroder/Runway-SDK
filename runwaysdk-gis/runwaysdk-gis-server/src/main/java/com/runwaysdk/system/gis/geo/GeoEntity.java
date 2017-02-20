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
package com.runwaysdk.system.gis.geo;

import java.util.List;

import com.runwaysdk.business.Business;
import com.runwaysdk.business.Relationship;
import com.runwaysdk.business.ontology.OntologyStrategyIF;
import com.runwaysdk.business.ontology.Term;
import com.runwaysdk.business.ontology.TermAndRel;
import com.runwaysdk.dataaccess.InvalidIdException;
import com.runwaysdk.dataaccess.ValueObject;
import com.runwaysdk.dataaccess.transaction.AbortIfProblem;
import com.runwaysdk.dataaccess.transaction.Transaction;
import com.runwaysdk.gis.geometry.GeometryHelper;
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.query.ValueQuery;
import com.runwaysdk.system.metadata.ontology.DatabaseAllPathsStrategy;
import com.runwaysdk.system.ontology.TermUtil;
import com.vividsolutions.jts.geom.Geometry;

public class GeoEntity extends GeoEntityBase
{
  private static final long  serialVersionUID = -231179219;

  public static final String ROOT             = "ROOT";

  public GeoEntity()
  {
    super();
  }

  public static GeoEntity getRoot()
  {
    return (GeoEntity) Term.getRoot(GeoEntity.CLASS);
  }

  /**
   * Constructs the a GeoID from the given Country Code and Country ID.
   * 
   * @param countryCode
   * @param countryId
   * @return GeoID from the given Country Code and Country ID.
   */
  public static String buildGeoIdFromCountryId(String _countryCode, String _countryId)
  {
    return _countryCode + " " + _countryId;
  }

  /**
   * Returns the country code from the GeoId
   * 
   * @param _geoId
   * @return
   */
  public static String parseCountryCodeFromGeoId(String _geoId)
  {
    int countryCodeIndex = _geoId.indexOf(" ");

    return _geoId.substring(countryCodeIndex, _geoId.length());
  }

  @Override
  @Transaction
  public void beforeDeleteTerm()
  {
    GeoEntityProblem.deleteProblems(this);
  }

  @Override
  public void apply()
  {
    applyInternal(true);
  }

  /**
   * Persists this GeoEntity and performs validation on its values.
   * 
   * @param validate
   *          TODO
   */
  @Transaction
  public void applyInternal(boolean validate)
  {
    if ( ( this.getGeoId() == null ) || ( this.getGeoId().length() == 0 ))
    {
      boolean unique = false;
      String generatedGeoId = null;

      // This check exists in case the user has manually created a geoentity
      // with the same id as what we've generated.
      while (!unique)
      {
        generatedGeoId = ReadableIdGenerator.getNextId();

        try
        {
          searchByGeoId(generatedGeoId);
        }
        catch (InvalidIdException e)
        {
          unique = true;
        }
      }

      this.setGeoId(generatedGeoId);
    }

    // Read WKT and generate a GeoPoint and a GeoMultiPolygon from it.
    GeometryHelper geometryHelper = new GeometryHelper();
    String wkt = this.getWkt();
    if (wkt != null && wkt.length() > 0)
    {
      try
      {
        Geometry geo = geometryHelper.parseGeometry(wkt);
        this.setGeoPoint(geometryHelper.getGeoPoint(geo));
        this.setGeoMultiPolygon(geometryHelper.getGeoMultiPolygon(geo));

        // reset the geoData to the filtered WKT as parsed by JTS
        this.setWkt(geo.toText());
      }
      catch (Exception e)
      {
        String msg = "Error parsing WKT";

        WKTParsingProblem p = new WKTParsingProblem(msg);
        p.setNotification(this, GeoEntity.WKT);
        p.setReason(e.getLocalizedMessage());
        p.apply();
        p.throwIt();
      }

    }
    // allow new instances to set geoPoint and geoMultiPolygon directly because
    // the values may have been set via the geo entity importer. Otherwise, null
    // the
    // values out if geoData is empty.
    else if (!this.isNew())
    {
      this.setGeoPoint(null);
      this.setGeoMultiPolygon(null);
    }

    boolean isNew = this.isNew() && !this.isAppliedToDB();

    if (validate)
    {
      this.validateUniversal();
    }

    super.apply();

    if (isNew)
    {
      /*
       * Add the term to the ontology strategy
       */
      this.addTerm(LocatedIn.CLASS);
    }

    // If geo multipolygon is null then add an entry into the problems page if
    // one doesn't already exist
    if (this.getGeoMultiPolygon() == null && !GeoEntityProblem.hasEntry(this, GeoEntityProblemType.MISSING_GEOM))
    {
      GeoEntityProblem.createProblems(this, GeoEntityProblemType.MISSING_GEOM);
    }
    else if (this.getGeoMultiPolygon() != null && GeoEntityProblem.hasEntry(this, GeoEntityProblemType.MISSING_GEOM))
    {
      GeoEntityProblem.deleteProblems(this, GeoEntityProblemType.MISSING_GEOM);
    }

  }

  public static GeoEntity searchByGeoId(String geoId)
  {
    QueryFactory queryFactory = new QueryFactory();

    ValueQuery valueQuery = new ValueQuery(queryFactory);

    GeoEntityQuery geoEntityQ = new GeoEntityQuery(queryFactory);

    valueQuery.SELECT(geoEntityQ.getId(GeoEntity.ID));
    valueQuery.WHERE(geoEntityQ.getGeoId().EQ(geoId));

    OIterator<? extends ValueObject> iterator = valueQuery.getIterator();
    try
    {
      if (iterator.hasNext())
      {
        ValueObject valueObject = iterator.next();

        String id = valueObject.getValue(GeoEntity.ID);

        return (GeoEntity) Business.get(id);
      }
      else
      {
        String msg = "A GeoEntity with the geoId [" + geoId + "] does not exist";
        throw new InvalidIdException(msg, geoId);
      }
    }
    finally
    {
      iterator.close();
    }
  }

  /**
   * Deletes this Universal, which removes the associated MdBusiness and all the
   * GeoEntity objects defined by that type.
   */
  // @Override
  // @Transaction
  // @com.runwaysdk.logging.Log(level = LogLevel.DEBUG)
  // public void delete()
  // {
  // // 1. Delete this entity from the all paths strategy
  // this.removeTerm(LocatedIn.CLASS);
  //
  // // 2. Recursively delete all children.
  // if (!this.isLeaf(LocatedIn.CLASS))
  // {
  // @SuppressWarnings("unchecked")
  // Iterator<Term> children =
  // this.getDirectDescendants(LocatedIn.CLASS).iterator();
  //
  // while (children.hasNext())
  // {
  // Term child = children.next();
  //
  // boolean hasSingleParent =
  // child.getDirectAncestors(LocatedIn.CLASS).getAll().size() == 1;
  //
  // if (hasSingleParent)
  // {
  // children.remove();
  // child.delete();
  // }
  // }
  // }
  //
  // // 3. Delete this.
  // super.delete();
  // }

  @Override
  protected String buildKey()
  {
    return this.getGeoId();
  }

  /**
   * This MdMethod will apply the GeoEntity dto and append it to parentId with
   * relationshipType.
   * 
   * @param dto
   * @param parentId
   * @param relationshipType
   * @return JSON {term, relType, relId}.
   */
  @Transaction
  public static GeoEntityView create(GeoEntity dto, String parentId, String relationshipType)
  {
    return GeoEntity.doCreate(dto, parentId, relationshipType);
  }

  @AbortIfProblem
  private static GeoEntityView doCreate(GeoEntity child, String parentId, String relationshipType)
  {
    // if (child.getGeoId() == null || child.getGeoId().equals(""))
    // {
    // child.setGeoId(child.getDisplayLabel().getValue());
    // }

    child.apply();

    GeoEntity parent = GeoEntity.get(parentId);

    Relationship rel = child.addLink(parent, relationshipType);

    Boolean canCreateChildren = calculateCanCreateChildren(child);

    GeoEntityView view = new GeoEntityView();
    view.setCanCreateChildren(canCreateChildren);
    view.setGeoEntityId(child.getId());
    view.setUniversalDisplayLabel(child.getUniversal().getDisplayLabel().getValue());
    view.setGeoEntityDisplayLabel(child.getDisplayLabel().getValue());
    view.setRelationshipId(rel.getId());
    view.setRelationshipType(relationshipType);
    return view;
  }

  private static boolean calculateCanCreateChildren(GeoEntity geo)
  {
    Universal uni = geo.getUniversal();

    return uni.getDirectDescendants(AllowedIn.CLASS).hasNext();
  }

  @Override
  public Relationship addLink(Term parent, String relationshipType)
  {
    if (!parent.getId().equals(GeoEntity.getRoot().getId()))
    {
      validateUniversal(this.getUniversal(), ( (GeoEntity) parent ).getUniversal());
    }

    return super.addLink(parent, relationshipType);
  }

  private void validateUniversal(Universal childUniversal, Universal parentUniversal)
  {
    /*
     * Ensure that the child's universal is a descendant of the parent's
     * universal
     */
    List<Term> ancestors = childUniversal.getAllAncestors(AllowedIn.CLASS).getAll();

    if (!ancestors.contains(parentUniversal))
    {
      InvalidGeoEntityUniversalException exception = new InvalidGeoEntityUniversalException();
      exception.setChildUniversal(childUniversal.getDisplayLabel().getValue());
      exception.setParentUniversal(parentUniversal.getDisplayLabel().getValue());
      exception.apply();

      throw exception;
    }
  }

  /**
   * @see com.runwaysdk.system.gis.geo.GeoEntityBase#validateUniversal()
   */
  public void validateUniversal()
  {
    super.validateUniversal();

    // Make sure that we're allowed within our parent GeoEntity
    OIterator<? extends Business> pareI = this.getParents(LocatedIn.CLASS);
    try
    {
      while (pareI.hasNext())
      {
        GeoEntity parent = (GeoEntity) pareI.next();
        this.validateUniversal(this.getUniversal(), parent.getUniversal());
      }
    }
    finally
    {
      pareI.close();
    }

    // Make sure that our children GeoEntities are allowed within us.
    OIterator<? extends Business> cit = this.getChildren(LocatedIn.CLASS);
    try
    {
      while (cit.hasNext())
      {
        GeoEntity child = (GeoEntity) cit.next();
        child.validateUniversal(child.getUniversal(), this.getUniversal());
      }
    }
    finally
    {
      cit.close();
    }
  }

  public static GeoEntityView[] getDirectDescendants(String parentId, String[] relationshipTypes, Integer pageNum, Integer pageSize)
  {
    TermAndRel[] tnrs = TermUtil.getDirectDescendants(parentId, relationshipTypes);
    GeoEntityView[] views = new GeoEntityView[tnrs.length];

    int i = 0;
    for (TermAndRel tnr : tnrs)
    {
      GeoEntity geo = (GeoEntity) GeoEntity.get(tnr.getTerm().getId());

      // Calculate whether or not the GeoEntity can have children, which is true
      // iff it has universals
      Boolean canCreate = GeoEntity.calculateCanCreateChildren(geo);

      GeoEntityView view = new GeoEntityView();
      view.setCanCreateChildren(canCreate);
      view.setGeoEntityId(geo.getId());
      view.setUniversalDisplayLabel(geo.getUniversal().getDisplayLabel().getValue());
      view.setGeoEntityDisplayLabel(geo.getDisplayLabel().getValue());
      view.setRelationshipId(tnr.getRelationshipId());
      view.setRelationshipType(tnr.getRelationshipType());
      views[i] = view;
      ++i;
    }

    return views;
  }

  /**
   * The strategy to manage the GeoEntity allpaths behavior.
   */
  public static OntologyStrategyIF createStrategy()
  {
    return new DatabaseAllPathsStrategy();
  }
}
