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

import java.io.IOException;

import javax.servlet.ServletException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.runwaysdk.business.ontology.TermAndRelDTO;
import com.runwaysdk.controller.ErrorUtility;
import com.runwaysdk.system.ontology.TermUtilDTO;
import com.runwaysdk.transport.conversion.json.BusinessDTOToJSON;
import com.runwaysdk.transport.conversion.json.JSONReturnObject;

public class UniversalController extends UniversalControllerBase
{
  public static final String JSP_DIR = "/WEB-INF/com/runwaysdk/system/gis/geo/Universal/";

  public static final String LAYOUT  = "WEB-INF/templates/layout.jsp";

  public UniversalController(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp, java.lang.Boolean isAsynchronous)
  {
    super(req, resp, isAsynchronous, JSP_DIR, LAYOUT);
  }

  @Override
  public void create(com.runwaysdk.system.gis.geo.UniversalDTO dto, String parentId, String relationshipType) throws java.io.IOException, javax.servlet.ServletException
  {
    try
    {
      TermAndRelDTO tnr = UniversalDTO.create(super.getClientRequest(), dto, parentId, relationshipType);

      this.resp.getWriter().print(new JSONReturnObject(tnr.toJSON()).toString());
    }
    catch (Throwable t)
    {
      boolean needsRedirect = ErrorUtility.handleFormError(t, req, resp);

      if (needsRedirect)
      {
        this.failCreate(dto, parentId, relationshipType);
      }
    }
  }

  @Override
  public void cancel(UniversalDTO dto) throws IOException, ServletException
  {
    dto.unlock();
  }

  @Override
  public void getDirectDescendants(String parentId, String[] relationshipTypes, Integer pageNum, Integer pageSize) throws java.io.IOException, javax.servlet.ServletException
  {
    try
    {
      JSONArray array = new JSONArray();

      TermAndRelDTO[] tnrs = TermUtilDTO.getDirectDescendants(getClientRequest(), parentId, relationshipTypes);
      
      JSONObject page = new JSONObject();

      if (pageNum != null && pageSize != null && pageNum > 0 && pageSize > 0)
      {
        int startIndex = Math.max(0, (( pageNum - 1 ) * pageSize));
        int endIndex = Math.min( ( pageNum * pageSize ), tnrs.length);
        int maxPages = ( (int) tnrs.length / pageSize ) + 1;

        for (int i = startIndex; i < endIndex; i++)
        {
          TermAndRelDTO tnr = tnrs[i];

          array.put(tnr.toJSON());
        }

        page.put("pageNumber", pageNum);
        page.put("maxPages", maxPages);
      }
      else
      {
        for (TermAndRelDTO tnr : tnrs)
        {
          array.put(tnr.toJSON());
        }

        page.put("pageNumber", pageNum);
        page.put("maxPages", 0);
      }

      page.put("values", array);

      resp.getWriter().print(new JSONReturnObject(page).toString());
    }
    catch (Throwable t)
    {
      ErrorUtility.prepareAjaxThrowable(t, resp);
    }
  }

  public void delete(com.runwaysdk.system.gis.geo.UniversalDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    try
    {
      dto.delete();
    }
    catch (Throwable t)
    {
      ErrorUtility.prepareAjaxThrowable(t, resp);
    }
  }

  @Override
  public void update(com.runwaysdk.system.gis.geo.UniversalDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    try
    {
      dto.apply();

      String ret = BusinessDTOToJSON.getConverter(dto).populate().toString();
      this.resp.getWriter().print(new JSONReturnObject(ret).toString());
    }
    catch (Throwable t)
    {
      boolean needsRedirect = ErrorUtility.handleFormError(t, req, resp);

      if (needsRedirect)
      {
        this.viewUpdate(dto.getId());
      }
    }
  }

  @Override
  public void viewCreate() throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.constants.ClientRequestIF clientRequest = super.getClientRequest();
    com.runwaysdk.system.gis.geo.UniversalDTO dto = new com.runwaysdk.system.gis.geo.UniversalDTO(clientRequest);
    req.setAttribute("item", dto);
    render("createComponent.jsp");
  }

  @Override
  public void viewUpdate(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.system.gis.geo.UniversalDTO dto = com.runwaysdk.system.gis.geo.UniversalDTO.lock(super.getClientRequest(), id);
    req.setAttribute("item", dto);
    render("editComponent.jsp");
  }

  public void failEdit(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    this.view(id);
  }

  public void failNewInstance() throws java.io.IOException, javax.servlet.ServletException
  {
    this.viewAll();
  }

  public void failUpdate(com.runwaysdk.system.gis.geo.UniversalDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    req.setAttribute("item", dto);
    render("editComponent.jsp");
  }

  public void view(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.constants.ClientRequestIF clientRequest = super.getClientRequest();
    req.setAttribute("item", com.runwaysdk.system.gis.geo.UniversalDTO.get(clientRequest, id));
    render("viewComponent.jsp");
  }

  public void failView(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    this.viewAll();
  }

  public void viewAll() throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.constants.ClientRequestIF clientRequest = super.getClientRequest();
    com.runwaysdk.system.gis.geo.UniversalQueryDTO query = com.runwaysdk.system.gis.geo.UniversalDTO.getAllInstances(clientRequest, null, true, 20, 1);
    req.setAttribute("query", query);
    render("viewAllComponent.jsp");
  }

  public void failViewAll() throws java.io.IOException, javax.servlet.ServletException
  {
    resp.sendError(500);
  }

  public void viewPage(java.lang.String sortAttribute, java.lang.Boolean isAscending, java.lang.Integer pageSize, java.lang.Integer pageNumber) throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.constants.ClientRequestIF clientRequest = super.getClientRequest();
    com.runwaysdk.system.gis.geo.UniversalQueryDTO query = com.runwaysdk.system.gis.geo.UniversalDTO.getAllInstances(clientRequest, sortAttribute, isAscending, pageSize, pageNumber);
    req.setAttribute("query", query);
    render("viewAllComponent.jsp");
  }

  public void failViewPage(java.lang.String sortAttribute, java.lang.String isAscending, java.lang.String pageSize, java.lang.String pageNumber) throws java.io.IOException, javax.servlet.ServletException
  {
    resp.sendError(500);
  }

  public void failCreate(com.runwaysdk.system.gis.geo.UniversalDTO dto, String parentId, String relationshipType) throws java.io.IOException, javax.servlet.ServletException
  {
    req.setAttribute("item", dto);
    render("createComponent.jsp");
  }

  public void failCancel(com.runwaysdk.system.gis.geo.UniversalDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    this.viewUpdate(dto.getId());
  }

  public void failDelete(com.runwaysdk.system.gis.geo.UniversalDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    req.setAttribute("item", dto);
    render("editComponent.jsp");
  }
}
