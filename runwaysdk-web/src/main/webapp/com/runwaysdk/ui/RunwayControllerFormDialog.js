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
  
  var runwayFormName = "com.runwaysdk.ui.RunwayControllerFormDialog";
  
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
   * Wraps the RunwayControllerForm into a dialog.
   */
  var runwayForm = ClassFramework.newClass(runwayFormName, {
    
    Extends : com.runwaysdk.ui.RunwayControllerForm,
    
    Instance : {
      
      initialize : function(config) {
        this._config = config || {};
        
        var that = this;
        
        var submitBind = Util.bind(this, this._onClickSubmit);
        var cancelBind = Util.bind(this, this._onClickCancel);
        
        var defaultConfig = {
          width: 550,
          height: 300,
          modal: true,
          resizable: false,
          buttons: [
                    { text: that.localize("submit"), click: submitBind},
                    { text: that.localize("cancel"), click: cancelBind}
                    ]
        };
        Mojo.Util.deepMerge(defaultConfig, this._config);
        
        // Forcefully override only the click listeners, otherwise it holds references to the old listeners.
        this._config.buttons[0].click = submitBind;
        this._config.buttons[1].click = cancelBind;
        
        this.$initialize(config);
        
        this._dialog = this.getFactory().newDialog("", this._config);
        this._dialog.appendContent(this);
      },
      
      // @Override
      _appendButtons : function() {
        // We're adding the buttons to the dialog (not the form), so we don't use this function because it adds them everytime we get a view from the server.
      },
      
      // @Override
      _onViewSuccess : function(html) {
//        if (!this._dialog.isRendered()) {
//          console.log("Rendering Dialog: " + this._dialog.toString());
//          this._dialog.render();
//        }
        this._dialog.setTitle(this.getTitle());
        
        this.$_onViewSuccess(html);
        
        this._dialog.show();
      },
      
      // @Override
      _onActionSuccess : function(type) {
        this.$_onActionSuccess(type);
        this.destroy();
//        this._dialog.destroy();
      },
      
      // @Override
      _onClickCancel : function() {
        console.log("Destroying Dialog: " + this._dialog.toString() + "\nThis Ref = " + this.toString());
        
        this.$_onClickCancel();
        this.destroy();
//        this._dialog.destroy();
      },
      
      destroy : function() {
        if (!this.isDestroyed() && !this._dialog.isDestroyed()) {
          this.$destroy();
          this._dialog.destroy();
        }
      },
      
      render : function(parent) {
//        this._dialog.addButton(this.localize("submit"), Util.bind(this, this._onClickSubmit));
//        this._dialog.addButton(this.localize("cancel"), Util.bind(this, this._onClickCancel));
//        this._dialog.hide();
//        this._dialog.render();
        if (!this.isRendered() && !this._dialog.isRendered()) {
          console.log("Rendering dialog " + this._dialog.toString());
          this.$render(this._dialog);
          this._dialog.render(parent);
        }
      }

    }
  });
  
  return runwayForm;
  
})();