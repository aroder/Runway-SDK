package com.runwaysdk.system.ontology;

import org.json.JSONArray;

import com.runwaysdk.business.ontology.TermAndRelDTO;
import com.runwaysdk.controller.ErrorUtility;
import com.runwaysdk.transport.conversion.json.BusinessDTOToJSON;
import com.runwaysdk.transport.conversion.json.JSONReturnObject;

public class ClassifierController extends ClassifierControllerBase
{
  public static final String JSP_DIR = "/WEB-INF/com/runwaysdk/system/ontology/Classifier/";
  public static final String LAYOUT = "WEB-INF/templates/layout.jsp";
  
  public ClassifierController(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp, java.lang.Boolean isAsynchronous)
  {
    super(req, resp, isAsynchronous, JSP_DIR, LAYOUT);
  }
  
  public void cancel(com.runwaysdk.system.ontology.ClassifierDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    dto.unlock();
    this.view(dto.getId());
  }
  public void failCancel(com.runwaysdk.system.ontology.ClassifierDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    this.edit(dto.getId());
  }
  public void create(com.runwaysdk.system.ontology.ClassifierDTO dto, java.lang.String parentId) throws java.io.IOException, javax.servlet.ServletException
  {
    try
    {
      TermAndRelDTO tnr = ClassifierDTO.create(super.getClientRequest(), dto, parentId);
      
      this.resp.getWriter().print(new JSONReturnObject(tnr.toJSON().toString()).toString());
    }
    catch(Throwable t)
    {
      boolean needsRedirect = ErrorUtility.handleFormError(t, req, resp);

      if (needsRedirect)
      {
        this.failCreate(dto, parentId);
      }
    }
  }
  public void failCreate(com.runwaysdk.system.ontology.ClassifierDTO dto, java.lang.String parentId) throws java.io.IOException, javax.servlet.ServletException
  {
    req.setAttribute("item", dto);
    render("createComponent.jsp");
  }
  public void delete(com.runwaysdk.system.ontology.ClassifierDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    try
    {
      dto.delete();
      this.viewAll();
    }
    catch(com.runwaysdk.ProblemExceptionDTO e)
    {
      this.failDelete(dto);
    }
  }
  public void failDelete(com.runwaysdk.system.ontology.ClassifierDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    req.setAttribute("item", dto);
    render("editComponent.jsp");
  }
  public void edit(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.system.ontology.ClassifierDTO dto = com.runwaysdk.system.ontology.ClassifierDTO.lock(super.getClientRequest(), id);
    req.setAttribute("item", dto);
    render("editComponent.jsp");
  }
  public void failEdit(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    this.view(id);
  }
  public void getDirectDescendants(java.lang.String parentId, java.lang.Integer pageNum, java.lang.Integer pageSize) throws java.io.IOException, javax.servlet.ServletException
  {
    try {
      JSONArray array = new JSONArray();
      
      TermAndRelDTO[] tnrs = TermUtilDTO.getDirectDescendants(getClientRequest(), parentId, new String[]{ClassifierIsARelationshipDTO.CLASS});
      for (TermAndRelDTO tnr : tnrs) {
        array.put(tnr.toJSON());
      }
      
      resp.getWriter().print(new JSONReturnObject(array).toString());
    }
    catch(Throwable t) {
      ErrorUtility.prepareAjaxThrowable(t, resp);
    }
  }
  public void failGetDirectDescendants(java.lang.String parentId, java.lang.String pageNum, java.lang.String pageSize) throws java.io.IOException, javax.servlet.ServletException
  {
    resp.sendError(500);
  }
  public void newInstance() throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.constants.ClientRequestIF clientRequest = super.getClientRequest();
    com.runwaysdk.system.ontology.ClassifierDTO dto = new com.runwaysdk.system.ontology.ClassifierDTO(clientRequest);
    req.setAttribute("item", dto);
    render("createComponent.jsp");
  }
  public void failNewInstance() throws java.io.IOException, javax.servlet.ServletException
  {
    this.viewAll();
  }
  public void update(com.runwaysdk.system.ontology.ClassifierDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    try
    {
      dto.apply();
      
      String ret = BusinessDTOToJSON.getConverter(dto).populate().toString();
      this.resp.getWriter().print(new JSONReturnObject(ret).toString());
    }
    catch(Throwable t)
    {
      boolean needsRedirect = ErrorUtility.handleFormError(t, req, resp);

      if (needsRedirect)
      {
        this.viewUpdate(dto.getId());
      }
    }
  }
  public void failUpdate(com.runwaysdk.system.ontology.ClassifierDTO dto) throws java.io.IOException, javax.servlet.ServletException
  {
    req.setAttribute("item", dto);
    render("editComponent.jsp");
  }
  public void view(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.constants.ClientRequestIF clientRequest = super.getClientRequest();
    req.setAttribute("item", com.runwaysdk.system.ontology.ClassifierDTO.get(clientRequest, id));
    render("viewComponent.jsp");
  }
  public void failView(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    this.viewAll();
  }
  public void viewAll() throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.constants.ClientRequestIF clientRequest = super.getClientRequest();
    com.runwaysdk.system.ontology.ClassifierQueryDTO query = com.runwaysdk.system.ontology.ClassifierDTO.getAllInstances(clientRequest, null, true, 20, 1);
    req.setAttribute("query", query);
    render("viewAllComponent.jsp");
  }
  public void failViewAll() throws java.io.IOException, javax.servlet.ServletException
  {
    resp.sendError(500);
  }
  public void viewCreate() throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.constants.ClientRequestIF clientRequest = super.getClientRequest();
    ClassifierDTO dto = new ClassifierDTO(clientRequest);
    req.setAttribute("item", dto);
    render("createComponent.jsp");
  }
  public void failViewCreate() throws java.io.IOException, javax.servlet.ServletException
  {
    resp.sendError(500);
  }
  public void viewPage(java.lang.String sortAttribute, java.lang.Boolean isAscending, java.lang.Integer pageSize, java.lang.Integer pageNumber) throws java.io.IOException, javax.servlet.ServletException
  {
    com.runwaysdk.constants.ClientRequestIF clientRequest = super.getClientRequest();
    com.runwaysdk.system.ontology.ClassifierQueryDTO query = com.runwaysdk.system.ontology.ClassifierDTO.getAllInstances(clientRequest, sortAttribute, isAscending, pageSize, pageNumber);
    req.setAttribute("query", query);
    render("viewAllComponent.jsp");
  }
  public void failViewPage(java.lang.String sortAttribute, java.lang.String isAscending, java.lang.String pageSize, java.lang.String pageNumber) throws java.io.IOException, javax.servlet.ServletException
  {
    resp.sendError(500);
  }
  @Override
  public void viewUpdate(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    ClassifierDTO dto = ClassifierDTO.lock(super.getClientRequest(), id);
    req.setAttribute("item", dto);
    render("editComponent.jsp");
  }
  public void failViewUpdate(java.lang.String id) throws java.io.IOException, javax.servlet.ServletException
  {
    resp.sendError(500);
  }
}
