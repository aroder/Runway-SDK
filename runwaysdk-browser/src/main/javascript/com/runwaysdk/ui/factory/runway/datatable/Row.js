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

define(["../../../../ClassFramework", "../widget/Widget"], function(ClassFramework, Widget){

  var RW = ClassFramework.alias(Mojo.RW_PACKAGE + "*");
  var UI = ClassFramework.alias(Mojo.UI_PACKAGE + "*");
  
  var Row = ClassFramework.newClass(Mojo.RW_PACKAGE+'Row', {
    
    Extends : Widget,
      
    Instance : {
      initialize : function(config) {
        this.$initialize("tr");
        
        if (config) {
          this.resizable = config.resizable || true;
          this.draggable = config.draggable || true;
          this.isHeader = config.isHeader || false;
          this.rowNumber = config.rowNumber;
          this.parentTable = config.parentTable;
          
          if (config.data)
            this.addData(config.data);
        }
        
        if (this.isHeader) {
          this.addClassName("headerrow");
        }
        else {
          if (this.rowNumber % 2 == 0) 
            this.addClassName("evenrow");
          else 
            this.addClassName("oddrow");
        }
        
        this._rowData = [];
      },
  
      addData : function(data)
      {
        var td;
        if (this.isHeader) {
          td = this.getFactory().newElement("th");
        }
        else {
          td = this.getFactory().newElement("td");
        }
        
        this._rowData.push(td);
        
        if (Mojo.Util.isObject(data)) {
          td.appendChild(data);
        }
        else {
          UI.DOMFacade.appendInnerHTML(td, data);
        }
        
        this.appendChild(td);
      },
      
      getRowNumber : function() {
        return this.rowNumber;
      },
      
      getParentTable : function() {
        return this.parentTable;
      },
      
      getCell : function(num) {
        return this.getFactory().wrapElement(this._rowData[num-1]);
      },
      
      // FIXME : is the speed enhancement worth it?
      // This is a psuedo-private method intended to only be used by the column class
      // in order to optimize the column's setStyle method. This should not be called by end users.
      _getRawCell : function(num) {
        return this._rowData[num-1];
      }
    }
  });
  
  return Row;
  
});
