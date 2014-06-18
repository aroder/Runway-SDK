/*******************************************************************************
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
 ******************************************************************************/
/**
 * Created on Aug 29, 2005
 *
 */
package com.runwaysdk.dataaccess.metadata;

import com.runwaysdk.constants.DatabaseProperties;
import com.runwaysdk.constants.EntityInfo;
import com.runwaysdk.constants.MdAttributeCharacterInfo;
import com.runwaysdk.dataaccess.AttributeIF;
import com.runwaysdk.dataaccess.database.Database;

/**
 * @author nathan
 *
 */
public class MdAttributeCharacter_E extends MdAttributeConcrete_E
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = 7151262644959678739L;

  /**
   * @param mdAttribute
   */
  public MdAttributeCharacter_E(MdAttributeConcreteDAO mdAttribute)
  {
    super(mdAttribute);
  }

  /**
   * Returns the MdAttribute.
   *
   * @return the MdAttribute
   */
  protected MdAttributeCharacterDAO getMdAttribute()
  {
    return (MdAttributeCharacterDAO)this.mdAttribute;
  }

  /**
   * Returns the formated DB column type used in the database in the syntax of the current DB vendor.
   * @return formated DB column type used in the database in the syntax of the current DB vendor.
   */
  protected String getDbColumnType()
  {
    String dbType = DatabaseProperties.getDatabaseType(this.getMdAttribute());
    return Database.formatCharacterField(dbType, this.getMdAttribute().getSize());
  }


  /**
   * Adds a column in the database to the given table.
   *
   * <br/><b>Precondition:</b>  tableName != null
   * <br/><b>Precondition:</b>  !tableName.trim().equals("")
   *
   */
  protected void createDbColumn(String tableName)
  {
    // physically add the column to the database, but only if the attribute is not an
    // id field, as that is done when the defining table is created
    if (this.getMdAttribute().definesAttribute().equalsIgnoreCase(EntityInfo.ID))
    {
      return;
    }

    super.createDbColumn(tableName);
  }

  /**
   * Modifies the column definition in the database to the given table, if such a
   * modification is necessary.
   *
   * <br/><b>Precondition:</b>  tableName != null
   * <br/><b>Precondition:</b>  !tableName.trim().equals("")
   *
   */
  protected void modifyDbColumn(String tableName)
  {
    AttributeIF attributeSize = this.getMdAttribute().getAttributeIF(MdAttributeCharacterInfo.SIZE);

    // if the size field has not been modified, then do nothing
    if (attributeSize.isModified())
    {
      Database.alterFieldType(tableName, this.getMdAttribute().getColumnName(),
                                    this.getDbColumnType(), this.dbColumnType);
    }
  }

}
