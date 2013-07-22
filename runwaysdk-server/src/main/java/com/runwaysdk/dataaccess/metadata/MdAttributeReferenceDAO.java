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
package com.runwaysdk.dataaccess.metadata;

import java.util.List;
import java.util.Map;

import com.runwaysdk.constants.MdAttributeReferenceInfo;
import com.runwaysdk.dataaccess.BusinessDAO;
import com.runwaysdk.dataaccess.EntityDAO;
import com.runwaysdk.dataaccess.EntityGenerator;
import com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF;
import com.runwaysdk.dataaccess.MdBusinessDAOIF;
import com.runwaysdk.dataaccess.MdEntityDAOIF;
import com.runwaysdk.dataaccess.attributes.entity.Attribute;
import com.runwaysdk.dataaccess.attributes.entity.AttributeReference;
import com.runwaysdk.session.Session;
import com.runwaysdk.transport.metadata.AttributeReferenceMdDTO;
import com.runwaysdk.transport.metadata.caching.AttributeMdSession;
import com.runwaysdk.transport.metadata.caching.AttributeReferenceMdSession;

public class MdAttributeReferenceDAO extends MdAttributeConcreteDAO implements MdAttributeReferenceDAOIF
{
  /**
   *
   */
  private static final long serialVersionUID = -1190940752817998922L;

  public MdAttributeReferenceDAO()
  {
    super();
  }

  /**
   * Returns the signature of the metadata.
   *
   * @return signature of the metadata.
   */
  public String getSignature()
  {
    return super.getSignature()+" ReferenceTypeVisibility: "+Boolean.toString(this.getReferenceMdBusinessDAO().isPublished())+" ReferenceType:"+this.getReferenceMdBusinessDAO().definesType();
  }

  /**
   * Constructs a MdAttributeReference from the given hashtable of Attributes.
   *
   * <br/><b>Precondition:</b>   attributeMap != null
   * <br/><b>Precondition:</b>   classType != null
   *
   *
   * @param attributeMap
   * @param classType
   */
  public MdAttributeReferenceDAO(Map<String, Attribute> attributeMap, String classType)
  {
    super(attributeMap, classType);
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#create(java.util.Hashtable)
   */
  public MdAttributeReferenceDAO create(Map<String, Attribute> attributeMap, String classType)
  {
    return new MdAttributeReferenceDAO(attributeMap, classType);
  }

  /**
   * Returns the default value for the attribute that this metadata defines. If
   * no default value has been defined, an empty string is returned.
   *
   * @return the default value for the attribute that this metadata defines.
   */
  public String getDefaultValue()
  {
    return getDefaultValue(this.getAttributeIF(MdAttributeReferenceInfo.DEFAULT_VALUE).getValue());
  }

  /**
   *Returns the metadata object that defines the MdBusiness type that this attribute referenes,
   * or null if it does not reference anything.
   *
   * @return the metadata object that defines the MdBusiness type that this attribute referenes,
   * or null if it does not reference anything.
   */
  public MdBusinessDAOIF getReferenceMdBusinessDAO()
  {
    if (this.getAttributeIF(MdAttributeReferenceInfo.REF_MD_BUSINESS).getValue().trim().equals(""))
    {
      return null;
    }
    else
    {
      AttributeReference attributeReference =
        (AttributeReference)this.getAttributeIF(MdAttributeReferenceInfo.REF_MD_BUSINESS);

      return (MdBusinessDAOIF)attributeReference.dereference();
    }
  }


  @Override
  protected void initializeStrategyObject()
  {
    if (this.definedByClass() instanceof MdEntityDAOIF)
    {
      this.mdAttributeStrategy = new MdAttributeReference_E(this);
    }
    else
    {
      this.mdAttributeStrategy = new MdAttributeConcrete_S(this);
    }
  }

  /**
   * Called for java class generation.  Returns the java type of the object
   * this attribute references, which is used in the generated classes for type
   * safety.
   *
   * @return The java type of the object this attribute references
   */
  public String javaType(boolean isDTO)
  {
    return this.getReferenceMdBusinessDAO().definesType();
  }

  @Override
  protected String generatedServerSetter(String attributeName)
  {
    return this.setterWrapper(attributeName, "value.getId()");
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.metadata.MdAttribute#generateTypesafeFormatting(java.lang.String)
   */
  protected String generateTypesafeFormatting(String formatMe)
  {
    return this.getReferenceMdBusinessDAO().definesType() + ".get(" + formatMe + ")";
  }


  /**
   * Special case for generating an id getter for reference attributes.
   *
   * @return reference id getter.
   */
  public String generatedServerGetterRefId()
  {
    return "getValue(" + this.definesAttribute().toUpperCase() + ")";
  }

  /**
   * Special case for generating an id getter for reference attributes.
   *
   * @return reference id getter.
   */
  public String generatedClientGetterRefId()
  {
    return this.generatedServerGetterRefId();
  }

  /**
   * Returns a string representing the query attribute class for attributes of this type.
   *
   * @return string representing the query attribute class for attributes of this type.
   */
  public String queryAttributeClass()
  {
    return com.runwaysdk.query.SelectableReference.class.getName();
  }

  public void setRandomValue(EntityDAO object)
  {
    List<String> referenceIDs = EntityDAO.getEntityIdsDB(this.getReferenceMdBusinessDAO().definesType());
    int index = EntityGenerator.getRandom().nextInt(referenceIDs.size());
    object.setValue(definesAttribute(), referenceIDs.get(index));
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#getBusinessDAO()
   */
  public MdAttributeReferenceDAO getBusinessDAO()
  {
    return (MdAttributeReferenceDAO) super.getBusinessDAO();
  }

  /**
   * Returns a new MdAttributeReference.
   * Some attributes will contain default values, as defined in the attribute
   * metadata. Otherwise, the attributes will be blank.
   *
   * @return MdAttributeReference.
   */
  public static MdAttributeReferenceDAO newInstance()
  {
    return (MdAttributeReferenceDAO) BusinessDAO.newInstance(MdAttributeReferenceInfo.CLASS);
  }

  /* (non-Javadoc)
   * @see com.runwaysdk.dataaccess.BusinessDAO#get(java.lang.String)
   */
  public static MdAttributeReferenceDAOIF get(String id)
  {
    return (MdAttributeReferenceDAOIF) BusinessDAO.get(id);
  }

  @Override
  public String attributeMdDTOType()
  {
    return AttributeReferenceMdDTO.class.getName();
  }

  @Override
  public void accept(MdAttributeDAOVisitor visitor)
  {
    visitor.visitReference(this);
  }
  
  /**
   * Used for client-side metadata caching.
   */
  @Override
  public AttributeMdSession getAttributeMdSession() {
    AttributeReferenceMdSession attrSes = new AttributeReferenceMdSession(this.getReferenceMdBusinessDAO().getId(), this.getReferenceMdBusinessDAO().getDisplayLabel(Session.getCurrentLocale()));
    super.populateAttributeMdSession(attrSes);
    return attrSes;
  }
}