/*
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

//define(["../../ClassFramework", "../../Util", "../RunwaySDK_UI", "../factory/runway/widget/Widget", "../datatable/datasource/InstanceQueryDataSource"], function(ClassFramework, Util, UI, Widget, InstanceQueryDataSource) {
(function(){  

  var Util = Mojo.Util;
  var ClassFramework = Mojo.Meta;
  var Widget = com.runwaysdk.ui.factory.runway.Widget;
  
  var runwayFormName = "com.runwaysdk.ui.RunwayControllerForm";
  
  /**
   * LANGUAGE
   */
  com.runwaysdk.Localize.defineLanguage(runwayFormName, {
    "create" : "Create",
    "update" : "Update",
    "submit" : "Submit",
    "cancel" : "Cancel"
  });
  
  /**
   * This class creates a form with localizable submit/cancel buttons and requests the fields from the server
   * for the given type as well as an automatic submit behavior that invokes a controller action.
   */
  var runwayForm = ClassFramework.newClass(runwayFormName, {
    
    Extends : Widget,
    
    Instance : {
      
      initialize : function(config) {
        
        this.requireParameter("type", config.type, "string");
        this.requireParameter("action", config.action, "string");
        this.requireParameter("onSuccess", config.onSuccess, "function");
        this.requireParameter("onFailure", config.onFailure, "function");
        this.requireParameter("onCancel", config.onCancel, "function");
        config.viewParams = config.viewParams || {};
        config.actionParams = config.actionParams || {};
        this._config = config;
        
        if (config.action === "update") {
          this.requireParameter("id", config.id, "string");
          config.viewParams.id = config.id;
        }
//        else if (config.viewAction != null) {
//          
//        }
        
        this.$initialize("div");
        
        var that = this;
        this._request = new Mojo.ClientRequest({onSuccess: Util.bind(this, this._onSuccess), onFailure: Util.bind(this, this._onFailure)});
      },
      
      getTitle : function() {
        var newType = eval("new " + this._config.type + "()");
        var label = newType.getMd().getDisplayLabel();
        
        return this.localize(this._config.action) + " " + label;
      },
      
      _onSuccess : function(retval) {
        // TODO : We should be reading the response type here.
        
        // Instead, check if html form stuff exists in the response
        if (retval.indexOf("form") != -1 || retval.indexOf("input") != -1 || retval.indexOf('type="hidden"') != -1) {
          this.setInnerHTML(Mojo.Util.removeScripts(retval));
          
//          if (this._config.viewAction != null) {
            this._appendButtons();
//          }
//          else {
//            eval(Mojo.Util.extractScripts(retval));
//          }
        }
        else {
          // Else assume its JSON that we can convert into a type.
          this._config.onSuccess(com.runwaysdk.DTOUtil.convertToType(Mojo.Util.getObject(retval)));
        }
      },
      
      _appendButtons : function() {
        var fac = this.getFactory();
        
        var submit = fac.newButton(this.localize("submit"), Util.bind(this, this._onClickSubmit));
        this.appendChild(submit);
        
        var cancel = fac.newButton(this.localize("cancel"), Util.bind(this, this._onClickCancel));
        this.appendChild(cancel);
      },
      
      _onClickSubmit : function() {
        var that = this;
        
        var params = Mojo.Util.collectFormValues(this._config.type + '.form.id');
        Util.merge(this._config.actionParams, params);
        
        Util.invokeControllerAction(this._config.type, this._config.action, Mojo.Util.convertMapToQueryString(params), this._request);
      },
      
      _onClickCancel : function() {
        this._config.onCancel.apply(this, arguments);
      },
      
      _onFailure : function(e) {
        this._config.onFailure(e);
      },
      
      _createOrUpdateListener : function(params, action) {
        return this._request;
      },
      
      _cancelListener : function() {
        this._config.onCancel.apply(this, arguments);
      },

      _deleteListener : function() {
        
      },
      
      getHtmlFromController : function() {
        
//        var controller = Mojo.Meta.findClass(this._config.type + "Controller");
//        
//        if (this._config.action === "create") {
//          controller.setCreateListener(Mojo.Util.bind(this, this._createOrUpdateListener));
//          controller.setCancelListener(Mojo.Util.bind(this, this._cancelListener));
//          controller.newInstance(this._request);
//        }
//        else if (this._config.action === "update") {
//          controller.setDeleteListener(Mojo.Util.bind(this, this._deleteListener));
//          controller.setUpdateListener(Mojo.Util.bind(this, this._createOrUpdateListener));
//          controller.setCancelListener(Mojo.Util.bind(this, this._cancelListener));
//          controller.edit(this._request, this._config.id);
//        }
//        else if (this._config.viewAction != null) {
//          Util.invokeControllerAction(this._config.type, this._config.viewAction, this._config.viewParams, this._request);
//        }
//        else {
//          throw new com.runwaysdk.Exception("Invalid action: [" + this._config.action + "].");
//        }
        
        // default = viewCreate, viewUpdate, etc.
        var viewAction = this._config.viewAction == null ? "view" + this._config.action.charAt(0).toUpperCase() + this._config.action.slice(1) : this._config.viewAction;
        
        Util.invokeControllerAction(this._config.type, viewAction, Mojo.Util.convertMapToQueryString(this._config.viewParams), this._request);
        
      },
      
      render : function(parent) {
        
        this.getHtmlFromController();
        
        this.$render(parent);
        
      }

    }
  });
  
  return runwayForm;
  
})();