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

//define(["../../ClassFramework", "../../Util", "../RunwaySDK_UI", "../factory/runway/widget/Widget", "../datatable/datasource/InstanceQueryDataSource", "./CronPicker", "prettycron"], function(ClassFramework, Util, UI, Widget, InstanceQueryDataSource, CronPicker) {
(function(){

  var ClassFramework = Mojo.Meta;
  var Util = Mojo.Util;
  var Widget = com.runwaysdk.ui.factory.runway.Widget;
  var InstanceQueryDataSource = com.runwaysdk.ui.datatable.datasource.InstanceQueryDataSource;
  var CronPicker = Mojo.Meta.alias("com.runwaysdk.ui.scheduler.*");

  var queryType = "com.runwaysdk.system.scheduler.ExecutableJob";
  
  var scheduler = ClassFramework.newClass('com.runwaysdk.ui.scheduler.Scheduler', {
    
    Extends : Widget,
    
    Instance : {
      
      initialize : function(cfg, oLanguage) {
        
        this.$initialize("table");
        this._oLanguage = oLanguage;
        
        if(this._oLanguage === null || this._oLanguage === undefined)
        {
          this._oLanguage = {
            oSchedule: {
              sStart: "Start",
              sStop: "Stop",
              sPause: "Pause",
              sResume: "Resume",
              sCompleted: "Completed",
              sStopped: "Stopped",
              sCanceled: "Canceled",
              sRunning: "Running",
              sPaused: "Paused",
              sEditJob: "Edit job",
              sDescription: "Description",
              sScheduledRun: "Scheduled run",
              sSubmit: "Submit",
              sCancel: "Cancel",
              sNever: "Never",
              sName: "Name",
              sDescription: "Description",
              sProgress: "Progress",
              sStatus: "Status"
            }
          };
        }        
      },
      
      _onClickStartJob : function(contextMenu, contextMenuItem, mouseEvent) {
        var row = contextMenu.getTarget();
        var table = row.getParentTable();
        var jobDTO = table.getDataSource().getResultsQueryDTO().getResultSet()[row.getRowNumber()];
        var that = this;
        
        jobDTO.start(new Mojo.ClientRequest({
          onSuccess : function() {
            
          },
          onFailure : function(ex) {
            that.handleException(ex);
          }
        }));
      },
      
      _onClickStopJob : function(contextMenu, contextMenuItem, mouseEvent) {
        var row = contextMenu.getTarget();
        var table = row.getParentTable();
        var resultsQueryDTO = table.getDataSource().getResultsQueryDTO();
        var jobDTO = table.getDataSource().getResultsQueryDTO().getResultSet()[row.getRowNumber()];
        var that = this;
        
        jobDTO.stop(new Mojo.ClientRequest({
          onSuccess : function() {
            
          },
          onFailure : function(ex) {
            that.handleException(ex);
          }
        }));
      },
      
      _onClickPauseJob : function(contextMenu, contextMenuItem, mouseEvent) {
        var row = contextMenu.getTarget();
        var table = row.getParentTable();
        var jobDTO = table.getDataSource().getResultsQueryDTO().getResultSet()[row.getRowNumber()];
        var that = this;
        
        jobDTO.pause(new Mojo.ClientRequest({
          onSuccess : function() {
            
          },
          onFailure : function(ex) {
            that.handleException(ex);
          }
        }));
      },
      
      _onClickResumeJob : function(contextMenu, contextMenuItem, mouseEvent) {
        var row = contextMenu.getTarget();
        var table = row.getParentTable();
        var jobDTO = table.getDataSource().getResultsQueryDTO().getResultSet()[row.getRowNumber()];
        var that = this;
        
        jobDTO.resume(new Mojo.ClientRequest({
          onSuccess : function() {
            
          },
          onFailure : function(ex) {
            that.handleException(ex);
          }
        }));
      },
      
      _openContextMenu : function(mouseEvent) {
        var fac = this.getFactory();
        var row = mouseEvent.getTarget().getParent();
        var statusRowNum = 3;
        
        var cm = fac.newContextMenu(row);
        var start = cm.addItem(this._oLanguage["oSchedule"]["sStart"], "add", Mojo.Util.bind(this, this._onClickStartJob));
        var stop = cm.addItem(this._oLanguage["oSchedule"]["sStop"], "delete", Mojo.Util.bind(this, this._onClickStopJob));
        var pause = cm.addItem(this._oLanguage["oSchedule"]["sPause"], "edit", Mojo.Util.bind(this, this._onClickPauseJob));
        var resume = cm.addItem(this._oLanguage["oSchedule"]["sResume"], "refresh", Mojo.Util.bind(this, this._onClickResumeJob));
        
        var status = row.getChildren()[statusRowNum].getInnerHTML();
        if (status === this._oLanguage["oSchedule"]["sCompleted"] || status === this._oLanguage["oSchedule"]["sStopped"] || status === this._oLanguage["oSchedule"]["sCanceled"]) {
          stop.setEnabled(false);
          pause.setEnabled(false);
          resume.setEnabled(false);
        }
        else if (status === this._oLanguage["oSchedule"]["sRunning"]) {
          start.setEnabled(false);
          resume.setEnabled(false);
        }
        else if (status === this._oLanguage["oSchedule"]["sPaused"]) {
          start.setEnabled(false);
          pause.setEnabled(false);
        }
        
        cm.render();
        
        row.addClassName("row_selected");
        cm.addDestroyEventListener(function() {
          row.removeClassName("row_selected");
        });
        
        return false; // Prevents default (displaying the browser context menu)
      },
      
      _openEditMenu : function(mouseEvent) {
        var fac = this.getFactory();
        var row = mouseEvent.getTarget().getParent();
        var table = row.getParentTable();
        var jobDTO = table.getDataSource().getResultsQueryDTO().getResultSet()[row.getRowNumber()];
        
        var dialog = fac.newDialog(this._oLanguage["oSchedule"]["sEditJob"], {width: "500px"});
        
        row.addClassName("row_selected");
        dialog.addDestroyEventListener(function() {
          row.removeClassName("row_selected");
        });
        
        var form = this.getFactory().newForm();
        
        var descriptionInput = this.getFactory().newFormControl('textarea', 'description');
        descriptionInput.setValue(jobDTO.getDescription().getLocalizedValue());
        form.addEntry(this._oLanguage["oSchedule"]["sDescription"], descriptionInput);
        
        var cronInput = new CronPicker.CronInput("cron");
        cronInput.setValue(jobDTO.getCronExpression());
        form.addEntry(this._oLanguage["oSchedule"]["sScheduledRun"], cronInput);
        
        dialog.appendContent(form);
        
        var Structure = com.runwaysdk.structure;
        var tq = new Structure.TaskQueue();
        
        var that = this;
        
        tq.addTask(new Structure.TaskIF({
          start : Mojo.Util.bind(this, function(){
            dialog.addButton(this._oLanguage["oSchedule"]["sSubmit"], function() { tq.next(); });
            
            var cancelCallback = function() {
              dialog.close();
              tq.stop();
            };
            dialog.addButton(this._oLanguage["oSchedule"]["sCancel"], cancelCallback);
            
            dialog.render();
          })
        }));
        
        tq.addTask(new Structure.TaskIF({
          start : Mojo.Util.bind(this, function(){
            dialog.close();
            
            var lockCallback = new Mojo.ClientRequest({
              onSuccess : function(retJobDTO) {
                jobDTO = retJobDTO;
                tq.next();
              },
              onFailure : function(ex) {
                tq.stop();
                that.handleException(ex);
              }
            });
            
//            jobDTO.lock(lockCallback);
            com.runwaysdk.Facade.lock(lockCallback, jobDTO.getId());
          })
        }));
        
        tq.addTask(new Structure.TaskIF({
          start : Mojo.Util.bind(this, function(){
            var values = form.accept(fac.newFormControl('FormVisitor'));
            
            jobDTO.getDescription().localizedValue = values.get("description");
            jobDTO.setCronExpression(values.get("cron"));
            
            var applyCallback = new Mojo.ClientRequest({
              onSuccess : function() {
                // Intentionally empty
              },
              onFailure : function(ex) {
                tq.stop();
                that.handleException(ex);
              }
            });
            
            jobDTO.apply(applyCallback);
          })
        }));
        
        tq.start();
        
        return false;
      },
      
      _onNewRowEvent : function(newRowEvent) {
        var fac = this.getFactory();
        var row = newRowEvent.getRow();
        
        var progressRowNum = 2;
        
        if (row.getRowNumber() == progressRowNum) {
          // TODO create a progress bar widget
        }
        
        row.addEventListener("dblclick", Mojo.Util.bind(this, this._openEditMenu));
        row.addEventListener("contextmenu", Mojo.Util.bind(this, this._openContextMenu));
      },
      
      formatStatus : function(jobDTO) {
        if (jobDTO.getRunning()) { return this._oLanguage["oSchedule"]["sRunning"]; }
        if (jobDTO.getCompleted()) { return this._oLanguage["oSchedule"]["sCompleted"]; }
        if (jobDTO.getPaused()) { return this._oLanguage["oSchedule"]["sPaused"]; }
        if (jobDTO.getCanceled()) { return this._oLanguage["oSchedule"]["sCanceled"]; }
          
        return this._oLanguage["oSchedule"]["sStopped"];
      },
      
      formatProgress : function(jobDTO) {
        if (jobDTO.getWorkTotal() == null || jobDTO.getWorkProgress() == null || jobDTO.getWorkTotal() == 0) {
          return null;
        }
        
        return ((jobDTO.getWorkProgress() / jobDTO.getWorkTotal()) * 100) + "%";
      },
      
      poll : function() {
        
        var that = this;
        setTimeout(function() {
          var callback = function(data) {
            for (var i = 0; i < data.aaData.length; ++i) {
              that._table.getImpl().fnUpdate(data.aaData[i], i, undefined, false, false);
            }
            
            that.poll();
          }
          
          that._table.getDataSource().getData(callback);
          
        }, 800);
      },
      
      formatScheduledRun : function(jobDTO) {
        var cronStr = jobDTO.getCronExpression();
        
        if (cronStr == null || cronStr === "") {
          return this._oLanguage["oSchedule"]["sNever"];
        }
        else {
          return prettyCron.toString(cronStr);
        }
      },
      
      render : function(parent) {
        
        var ds = new InstanceQueryDataSource({
          className: queryType,
          columns: [
            { header: this._oLanguage["oSchedule"]["sName"],  queryAttr: "jobId" },
            { header: this._oLanguage["oSchedule"]["sDescription"],  customFormatter: function(jobDTO){ return jobDTO.getDescription().getLocalizedValue(); } },
            { header: this._oLanguage["oSchedule"]["sProgress"], customFormatter: Mojo.Util.bind(this, this.formatProgress) },
            { header: this._oLanguage["oSchedule"]["sStatus"], customFormatter: Mojo.Util.bind(this, this.formatStatus) }
//            { header: "Scheduled Run", customFormatter: this.formatScheduledRun }
          ]
        });
        
        this._table = this.getFactory().newDataTable({
          el : this,
          dataSource : ds,
          oLanguage : this._oLanguage
        });
        
        this._table.addNewRowEventListener(Mojo.Util.bind(this, this._onNewRowEvent));
        
        this._table.render(parent);
        
        this.poll();
        
      }
      
    }
    
  });
  
  return scheduler;
  
})()
