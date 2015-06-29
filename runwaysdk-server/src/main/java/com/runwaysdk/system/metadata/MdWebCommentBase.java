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
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -1406111006)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdWebComment.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MdWebCommentBase extends com.runwaysdk.system.metadata.MdWebField
{
  public final static String CLASS = "com.runwaysdk.system.metadata.MdWebComment";
  public static java.lang.String COMMENTTEXT = "commentText";
  private com.runwaysdk.business.Struct commentText = null;
  
  private static final long serialVersionUID = -1406111006;
  
  public MdWebCommentBase()
  {
    super();
    commentText = super.getStruct("commentText");
  }
  
  public com.runwaysdk.system.metadata.MdWebCommentCommentText getCommentText()
  {
    return (com.runwaysdk.system.metadata.MdWebCommentCommentText) commentText;
  }
  
  public void validateCommentText()
  {
    this.validateAttribute(COMMENTTEXT);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getCommentTextMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(com.runwaysdk.system.metadata.MdWebComment.CLASS);
    return mdClassIF.definesAttribute(COMMENTTEXT);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MdWebComment get(String id)
  {
    return (MdWebComment) com.runwaysdk.business.Business.get(id);
  }
  
  public static MdWebComment getByKey(String key)
  {
    return (MdWebComment) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static MdWebComment lock(java.lang.String id)
  {
    MdWebComment _instance = MdWebComment.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static MdWebComment unlock(java.lang.String id)
  {
    MdWebComment _instance = MdWebComment.get(id);
    _instance.unlock();
    
    return _instance;
  }
  
  public String toString()
  {
    if (this.isNew())
    {
      return "New: "+ this.getClassDisplayLabel();
    }
    else
    {
      return super.toString();
    }
  }
}
