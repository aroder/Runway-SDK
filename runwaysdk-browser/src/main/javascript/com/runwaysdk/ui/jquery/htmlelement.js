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
(function(){

  var RUNWAY_UI = Mojo.Meta.alias("com.runwaysdk.ui.*");
  Mojo.JQUERY_PACKAGE = Mojo.UI_PACKAGE+'jquery.';
  
  /**
   * @class com.runwaysdk.ui.jquery.HTMLElement
   * 
   * The JQuery wrapper around an HTMLElement.
   */
  var HTMLElement = Mojo.Meta.newClass(Mojo.JQUERY_PACKAGE+'HTMLElement', {
    
    Implements : RUNWAY_UI.HTMLElementIF,
    
    Extends : RUNWAY_UI.HTMLElementBase,
    
    Instance : {
      initialize : function(el, attributes, styles)
      {
        if (el instanceof jQuery) {
          this._impl = el;
          this._rawEl = el[0];
        }
        else {
          el = RUNWAY_UI.Util.stringToRawElement(el);
          this._rawEl = el;
          this._impl = $(el);
        }
        
        this.$initialize(el, attributes, styles);
      },
      /**
       * Override to generate the id based on the DOM element.
       */
      _generateId : function(){
        var id = RUNWAY_UI.DOMFacade.getAttribute(this.getRawEl(), 'id');
        return Mojo.Util.isString(id) && id.length > 0 ? id : this.$_generateId();
      },
      addClassName : function(name)
      {
        this.getImpl().addClass(name);
      },
      hasClassName : function(name)
      {
        return this.getImpl().hasClass(name);
      },
      removeClassName : function(name)
      {
        this.getImpl().removeClass(name);
      },
      getElementsByClassName : function(className, tag)
      {
        return this.getRawEl().getElementsByClassName(className, tag);
      },
      getRawEl : function()
      {
        return this._rawEl;
      },
      normalize : function()
      {
        this.getRawEl().normalize();
      },
      setInnerHTML : function (html)
      {
        com.runwaysdk.ui.DOMFacade.setInnerHTML(this.getRawEl(), html);
      },
      getInnerHTML : function ()
      {
        return com.runwaysdk.ui.DOMFacade.getInnerHTML(this.getRawEl());
      },
      getChildren : function() {
        return com.runwaysdk.ui.DOMFacade.getChildren(this.getRawEl());
      },
      getAttribute : function(name)
      {
        if (!this.hasAttribute(name)) {
          return null;
        }
        return this.getImpl().attr(name);
      },
      setAttribute : function(name, value)
      {
        this.getImpl().attr(name, String(value));
      },
      removeAttribute : function(name)
      {
        return this.getImpl().removeAttr(name);
      },
      appendChild : function(newChild)
      {
        if (com.runwaysdk.ui.Util.isComponentIF(newChild))
        {
          newChild.setParent(this);
        }
        var newChildRaw = com.runwaysdk.ui.Util.toRawElement(newChild);
        this.getImpl().append(newChildRaw);
        return newChild;
      },
      setStyle : function(property, value)
      {
        return this.getImpl().css(property, value);
      },
    }
  });
  
})();