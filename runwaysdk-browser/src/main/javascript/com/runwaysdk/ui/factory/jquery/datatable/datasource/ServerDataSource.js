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

//define(["../../../../../ClassFramework", "../../../../../Util", "../../../../RunwaySDK_UI", "../../../generic/datatable/datasource/BaseServerDataSource"], function(ClassFramework, Util, Runway_UI, BaseServerDataSource) {
(function(){

  var ClassFramework = Mojo.Meta;
  var Util = Mojo.Util;
  var BaseServerDataSource = com.runwaysdk.ui.factory.generic.datatable.datasource.BaseServerDataSource;
  
  var RW = ClassFramework.alias(Mojo.RW_PACKAGE + "*");
  var UI = ClassFramework.alias(Mojo.UI_PACKAGE + "*");
  var STRUCT = ClassFramework.alias(Mojo.STRUCTURE_PACKAGE + "*");
  
  var serverDataSource = ClassFramework.newClass(Mojo.JQUERY_PACKAGE+'datatable.datasource.ServerDataSource', {
    
    Extends : BaseServerDataSource,
    
    Instance : {
      initialize : function(config) {
        this.$initialize(config);
        
        this._genericDataSource = config.genericDataSource;
      },
      
      getConfig : function() {
        
        return {
          "bProcessing": true,
          "bServerSide": true,
          "sAjaxSource": "",
          "fnServerData": Util.bind(this, this.__fnServerData),
          aoColumns: this.getColumns()
        };
      },
      
      __fnServerData : function(sSource, aoData, fnCallback, oSettings) {
        var displayStart;
        var displayLen;
        var sEcho;
        for (var i = 0; i < aoData.length; ++i) {
          if (aoData[i].name === "iDisplayLength") {
            displayLen = aoData[i].value;
          }
          else if (aoData[i].name === "iDisplayStart") {
            displayStart = aoData[i].value;
          }
          else if (aoData[i].name === "sEcho") {
            sEcho = aoData[i].value;
          }
          
          if (displayStart != null && displayLen != null) { break; }
        }
        
        this._sSource = sSource;
        this._sEcho = sEcho;
        this._fnCallback = fnCallback;
        
        this._genericDataSource.setPageNumber(displayStart / displayLen + 1);
        this._genericDataSource.setPageSize(displayLen);
        this._genericDataSource.getData({onSuccess: fnCallback, onFailure: this.handleException});
      },
      
      formatResponse : function(response) {
        var count = this.getTotalResults();
        
        return {
          sEcho : this._sEcho,
          iTotalRecords: count,
          iTotalDisplayRecords: count,
          aaData: response
//          aoColumns: this.getColumns()
        };
      }
    }
  });
  
  return serverDataSource;
})();
