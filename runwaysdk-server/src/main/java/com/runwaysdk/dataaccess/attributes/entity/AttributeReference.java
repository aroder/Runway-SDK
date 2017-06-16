/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
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
/*
 * Created on Jun 15, 2005
 */
package com.runwaysdk.dataaccess.attributes.entity;

import com.runwaysdk.constants.BusinessInfo;
import com.runwaysdk.constants.CommonProperties;
import com.runwaysdk.constants.EntityInfo;
import com.runwaysdk.constants.MdAttributeReferenceInfo;
import com.runwaysdk.dataaccess.AttributeReferenceIF;
import com.runwaysdk.dataaccess.BusinessDAO;
import com.runwaysdk.dataaccess.BusinessDAOIF;
import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.MdAttributeRefDAOIF;
import com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF;
import com.runwaysdk.dataaccess.MdBusinessDAOIF;
import com.runwaysdk.dataaccess.MdClassDAOIF;
import com.runwaysdk.dataaccess.attributes.InvalidReferenceException;
import com.runwaysdk.dataaccess.metadata.MdBusinessDAO;
import com.runwaysdk.dataaccess.metadata.MdClassDAO;
import com.runwaysdk.dataaccess.metadata.ReferenceAttributeNotReferencingClassException;
import com.runwaysdk.query.BusinessDAOQuery;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.util.IdParser;

/**
 * @author nathan
 * 
 * @version $Revision: 1.12 $
 * @since 1.4
 */
public class AttributeReference extends Attribute implements AttributeReferenceIF
{
  /**
   * Generated by Eclipse
   */
  private static final long serialVersionUID = -6379058307075026002L;

  public AttributeReference(String name, String mdAttributeKey, String definingEntityType)
  {
    super(name, mdAttributeKey, definingEntityType);
  }

  /**
   * 
   * @param name
   * @param mdAttributeKey
   *          key of the defining attribute metadata.
   * @param definingEntityType
   * @param value
   */
  public AttributeReference(String name, String mdAttributeKey, String definingEntityType, String value)
  {
    super(name, mdAttributeKey, definingEntityType, value);
  }

  /**
   * Returns the BusinessDAO that defines the this attribute.
   * 
   * <br>
   * <b>Precondition: </b> true <br>
   * <b>Postcondition: </b> true
   * 
   * @return BusinessDAO that defines the this attribute
   */
  public MdAttributeReferenceDAOIF getMdAttribute()
  {
    return (MdAttributeReferenceDAOIF) super.getMdAttribute();
  }

  /**
   * Returns the concrete attribute metadata that defines this attribute. If
   * this is defined by aa concrete attribute, this object is returned. If it is
   * a virtual attribute, then the concrete attribute it references is returned.
   * 
   * @return MdAttributeReferenceDAOIF that defines the this attribute
   */
  public MdAttributeReferenceDAOIF getMdAttributeConcrete()
  {
    return this.getMdAttribute();
  }

  /**
   * 
   * @param mdAttribute
   *          the defining Metadata object of the class that contains this
   *          Attribute
   * @return boolean value representing the validity of the input
   */
  protected void validate(String valueToValidate, MdAttributeDAOIF mdAttribute)
  {
    super.validate(valueToValidate, mdAttribute);

    MdAttributeReferenceDAOIF mdAttributeReference = (MdAttributeReferenceDAOIF) mdAttribute;

    validateReference(valueToValidate, mdAttributeReference);
  }

  public static void validateReference(String valueToValidate, MdAttributeRefDAOIF mdAttributeReference)
  {
    // if it is not required to have a reference and none is provided, then
    // there is no need to check further.
    if (!mdAttributeReference.isRequired() && valueToValidate.trim().equals(""))
    {
      return;
    }

    // if the attribute is configured to reference another BusinessDAO, make
    // sure
    // it is a valid reference
    MdBusinessDAOIF refMdBusinessIF = mdAttributeReference.getReferenceMdBusinessDAO();

    if (refMdBusinessIF != null)
    {
      QueryFactory qFactory = new QueryFactory();
      BusinessDAOQuery doQ = null;

      if (refMdBusinessIF.definesType().equals(BusinessInfo.CLASS))
      {
        MdClassDAOIF mdClassIF = MdClassDAO.getMdClassByRootId(IdParser.parseMdTypeRootIdFromId(valueToValidate));
        doQ = qFactory.businessDAOQuery(mdClassIF.definesType());
        doQ.WHERE(doQ.aCharacter(EntityInfo.ID).EQ(valueToValidate));
      }
      else
      {
        doQ = qFactory.businessDAOQuery(refMdBusinessIF.definesType());
        doQ.WHERE(doQ.aCharacter(EntityInfo.ID).EQ(valueToValidate));
      }

      if (doQ.getCount() == 0)
      {
        String errMsg = "Attribute [" + mdAttributeReference.definesAttribute() + "] on type [" + mdAttributeReference.definedByClass().definesType() + "] does not reference a valid [" + refMdBusinessIF.definesType() + "]";
        throw new InvalidReferenceException(errMsg, mdAttributeReference);
      }
    }
    else if (valueToValidate.trim().equals(""))
    {
      MdClassDAOIF definingMdClassIF = mdAttributeReference.definedByClass();
      String errMsg = "Attribute [" + mdAttributeReference.getDisplayLabel(CommonProperties.getDefaultLocale()) + "] on type [" + definingMdClassIF.definesType() + "] is a reference but " + "is not configured to reference anything. It cannot contain a value.";
      throw new ReferenceAttributeNotReferencingClassException(errMsg, mdAttributeReference, definingMdClassIF);
    }
  }

  /**
   * 
   * @return
   */
  public BusinessDAOIF dereference()
  {
    MdAttributeReferenceDAOIF mdAttribute = getMdAttribute();

    return dereference(this.getValue(), mdAttribute);
  }

  public static BusinessDAOIF dereference(String referenceId, MdAttributeReferenceDAOIF mdAttribute)
  {
    if (referenceId.trim().equals(""))
    {
      // do not dereference the reference (as you normally would), as it
      // produces an infinite loop within this method
      MdBusinessDAOIF refMdBusinessIF = MdBusinessDAO.get(mdAttribute.getAttributeIF(MdAttributeReferenceInfo.REF_MD_ENTITY).getValue());

      String errMsg = "Attribute [" + mdAttribute.getDisplayLabel(CommonProperties.getDefaultLocale()) + "] on type [" + mdAttribute.definedByClass().definesType() + "] does not reference a valid [" + refMdBusinessIF.definesType() + "]";
      throw new InvalidReferenceException(errMsg, mdAttribute);
    }

    // The class of the referenced object cannot be derived from the metadata.
    // The runtime class of the object
    // may be a sublcass of the class specified in the metadata.
    return BusinessDAO.get(referenceId);
  }

  /**
   * Returns a deep clone of this attribute.
   * 
   * <br/>
   * <b>Precondition:</b> true <br/>
   * <b>Postcondition:</b> true
   * 
   * @return a deep clone of this Attribute
   */
  @Override
  public Attribute attributeClone()
  {
    return new AttributeReference(this.getName(), this.mdAttributeKey, this.getDefiningClassType(), new String(this.getRawValue()));
  }
}
