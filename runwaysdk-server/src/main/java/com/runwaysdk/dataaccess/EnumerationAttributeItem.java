/**
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
package com.runwaysdk.dataaccess;

import java.util.Map;

import com.runwaysdk.constants.ComponentInfo;
import com.runwaysdk.dataaccess.attributes.entity.Attribute;


public class EnumerationAttributeItem extends TreeDAO implements SpecializedDAOImplementationIF
{

  /**
   * Generated by Eclipse.
   */
  private static final long serialVersionUID = 238176507795865128L;

  public EnumerationAttributeItem(String parentId, String childId, Map<String, Attribute> attributeMap, String relationshipType)
  {
    super(parentId, childId, attributeMap, relationshipType);
  }


  /**
   * This method is a hook for TransactionManagement.aj
   */
  public String save(boolean validateRequired)
  {
    String id = this.getId();

    Attribute keyAttribute = this.getAttribute(ComponentInfo.KEY);

    if (!keyAttribute.isModified() && keyAttribute.getValue().equals(""))
    {
      this.setKey(id);
    }

    return super.save(validateRequired);
  }

  /**
   * This method is a hook for TransactionManagement.aj
   *
   * @param businessContext true if this is being called from a business context, false
   * otherwise. If true then cascading deletes of other Entity objects will happen at the Business
   * layer instead of the data access layer.
   *
   */
  public void delete(boolean businessContext)
  {
    super.delete(businessContext);
  }

  /**
   * Returns MdEnumerationIF that includes the option from the master list.
   *
   * @return the MdEnumerationIF that includes the option from the master list.
   */
  public MdEnumerationDAOIF getMdEnumerationDAO()
  {
    return (MdEnumerationDAOIF)this.getParent();
  }

}
