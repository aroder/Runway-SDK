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

//define(["../../../../ClassFramework", "../../../../Util", "./datasource/DataSourceFactory", "./../../generic/datatable/Events", "../../generic/datatable/datasource/DataSourceIF", "../../generic/datatable/Row", "../../generic/datatable/Column", "jquery-datatables", "../../runway/widget/Widget", "../Factory"], function(ClassFramework, Util, DataSourceFactory, TableEvents, DataSourceIF, Row, Column) {
(function(){

  var RW = Mojo.Meta.alias(Mojo.RW_PACKAGE + "*");
  var UI = Mojo.Meta.alias(Mojo.UI_PACKAGE + "*");
  
  var ClassFramework = Mojo.Meta;
  var Util = Mojo.Util;
  var DataSourceFactory = com.runwaysdk.ui.factory.jquery.datatable.datasource.DataSourceFactory; 
  var TableEvents = Mojo.Meta.alias("com.runwaysdk.ui.factory.generic.datatable.events.*");
  var DataSourceIF = com.runwaysdk.ui.factory.generic.datatable.datasource.DataSourceIF;
  var Row = com.runwaysdk.ui.factory.generic.datatable.Row;
  var Column = com.runwaysdk.ui.factory.generic.datatable.Column;
  var Widget = com.runwaysdk.ui.factory.runway.Widget;
  
  /*
   * This datatables.net plugin is needed for refresh, otherwise refresh resets the page number to 0.
   * http://datatables.net/plug-ins/api#fnStandingRedraw
   */
  $.fn.dataTableExt.oApi.fnStandingRedraw = function(oSettings) {
    if(oSettings.oFeatures.bServerSide === false){
        var before = oSettings._iDisplayStart;
 
        oSettings.oApi._fnReDraw(oSettings);
 
        // iDisplayStart has been reset to zero - so lets change it back
        oSettings._iDisplayStart = before;
        oSettings.oApi._fnCalculateEnd(oSettings);
    }
    
    // draw the 'current' page
    oSettings.oApi._fnDraw(oSettings);
  };
  
  var DataTable = ClassFramework.newClass(Mojo.JQUERY_PACKAGE+'datatable.DataTable', {
    
    Extends : Widget,
    
    Instance : {
      
      initialize : function(config)
      {
        config = config || {};
        
        this._language = com.runwaysdk.Localize.getLanguage("com.runwaysdk.ui.factory.generic.datatable.DataTable");
       
        var defaultConfig = {
          el : "table",
          oLanguage : {
            oAria: {
              sSortAscending: this._language.get("sortAscending"),
              sSortDescending: this._language.get("sortDescending")
            },
            oPaginate: {
              sFirst: this._language.get("first"),
              sLast: this._language.get("last"),
              sNext: this._language.get("next"),
              sPrevious: this._language.get("previous")
            },
            sEmptyTable: this._language.get("emptyTable"),
            sInfo: this._language.get("info"),
            sInfoEmpty: this._language.get("infoEmpty"),
            sInfoFiltered: this._language.get("infoFiltered"),
            sLengthMenu: this._language.get("lengthMenu"),
            sLoadingRecords: this._language.get("loadingRecords"),
            sProcessing: this._language.get("processing"),
            sSearch: this._language.get("search"),
            sZeroRecords: this._language.get("zeroRecords")
          }
        };
        this._config = Mojo.Util.deepMerge(defaultConfig, config);
        
        this.$initialize(config.el);
        
        if (DataSourceIF.getMetaClass().isInstance(config.dataSource)) {
          this._dataSource = config.dataSource;
        }
        else {
          config.dataSource.dataTable = this;
          this._dataSource = DataSourceFactory.newDataSource(config.dataSource);
        }
        
        this._config = config;
        this._rows = [];
      },
      
      addRow : function(rowData) {
        if (this.isRendered()) {
          this.getImpl().fnAddData(rowData);
        }
        else {
          
        }
      },
      
      getNumberOfRows : function() {
        return this.getImpl().fnSettings().fnRecordsTotal();
      },
      
      addNewRowEventListener : function(fnListener) {
        this.addEventListener(TableEvents.NewRowEvent, {handleEvent: fnListener});
      },
      
      addNewHeaderRowEventListener : function(fnListener) {
        this.addEventListener(TableEvents.NewHeaderRowEvent, {handleEvent: fnListener});
      },
      
      deleteRow : function(rowNum) {
        if (this.isRendered()) {
          this.getImpl().fnDeleteRow(rowNum);
        }
        else {
          
        }
      },
      
      getDataSource : function() {
        return this._dataSource;
      },
      
      getImpl : function() {
        return this._impl;
      },
      
      __addChildElements : function() {
        // Header
        var thead = this.getFactory().newElement("thead");
      
        var headRow = new Row({isHeader: true, parentTable: this});
        for (var i = 0; i < this._columnHeaders.length; ++i) {
          headRow.addData(this._columnHeaders[i]);
        }
        thead.appendChild(headRow);
        this.dispatchEvent(new TableEvents.NewHeaderRowEvent(headRow));
        
        this.appendChild(thead);
        
//        <tbody>
//          <tr>
//            <td colspan="5" class="dataTables_empty">Loading data from server</td>
//          </tr>
//        </tbody>
        var tbody = this.getFactory().newElement("tbody");
        this.appendChild(tbody);
        var tr = new Row({isHeader: false, parentTable: this});
        tbody.appendChild(tr);
        var td = tr.addData(this._language.get("loadingData"));
        td.addClassName("dataTables_empty");
        td.setAttribute("colspan", "5");
      },
      
      refresh : function(callback) {
        if (this.getImpl() != null) {
          if (callback == null) {
            callback = {onSuccess:function(){}, onFailure:function(){}};
          }
          
          this.getDataSource().getImpl().setDataTablesCallback(callback);
          
          this.getImpl().fnStandingRedraw();
        }
        else {
          callback.onSuccess();
        }
      },
      
      updateRow : function(rowData, rowNum) {
        this.getImpl().fnUpdate(rowData, rowNum, undefined, false, false);
      },
      
      render : function(parent) {
        this.$render(parent);
        
        var that = this
        
        that._dataSource.initialSetup({
          onSuccess: function() {
            var cfg = that._dataSource.getConfig();
            var columns = that._dataSource.getColumns();
            
            Util.merge(that._config, cfg);
            
            that._columnHeaders = columns;
            that.__addChildElements();
            
            var fnRowCallback = function (tr, aData, iDisplayIndex) {
              var row = new Row({
                el: tr,
                isHeader: true,
                parentTable: that,
                rowNumber: iDisplayIndex
              });
              row.setComponents(row.getChildNodes());
              
              that.dispatchEvent(new TableEvents.NewRowEvent(row));
            };
            cfg.fnRowCallback = fnRowCallback;

            cfg.oLanguage = cfg.oLanguage || {};
            Util.merge(cfg.language || {}, cfg.oLanguage);
            that._impl = $(that.getRawEl()).dataTable(cfg);
            
            $("#" + that.getId() + "_wrapper").css("padding-bottom", "10px");
          },
          onFailure: function(ex) {
            that.handleException(ex);
          }
        });
      },
      
      destroy : function() {
        $("#" + this.getId() + "_wrapper.dataTables_wrapper").remove();
        
        this.$destroy();
      }
      
    }
  
  });
  
})();