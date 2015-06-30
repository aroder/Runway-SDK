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
package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -2100936213)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MdMobileComment.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class MdMobileCommentQuery extends com.runwaysdk.system.metadata.MdMobileFieldQuery

{

  public MdMobileCommentQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public MdMobileCommentQuery(com.runwaysdk.query.ValueQuery valueQuery)
  {
    super(valueQuery);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = new com.runwaysdk.business.BusinessQuery(valueQuery, this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public String getClassType()
  {
    return com.runwaysdk.system.metadata.MdMobileComment.CLASS;
  }
  public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText()
  {
    return getCommentText(null);

  }
 
  public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT);

    return (com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT);

    return (com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF)this.getComponentQuery().internalAttributeFactory(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeLocal localFactory( com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdLocalStructDAOIF mdLocalStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT)) 
    {
       return new com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStruct((com.runwaysdk.dataaccess.MdAttributeLocalDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.localFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends MdMobileComment> getIterator()
  {
    this.checkNotUsedInValueQuery();
    String sqlStmt;
    if (_limit != null && _skip != null)
    {
      sqlStmt = this.getComponentQuery().getSQL(_limit, _skip);
    }
    else
    {
      sqlStmt = this.getComponentQuery().getSQL();
    }
    java.util.Map<String, com.runwaysdk.query.ColumnInfo> columnInfoMap = this.getComponentQuery().getColumnInfoMap();

    java.sql.ResultSet results = com.runwaysdk.dataaccess.database.Database.query(sqlStmt);
    return new com.runwaysdk.business.BusinessIterator<MdMobileComment>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdMobileCommentQueryReferenceIF extends com.runwaysdk.system.metadata.MdMobileFieldQuery.MdMobileFieldQueryReferenceIF
  {

    public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText();
    public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias);
    public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdMobileComment mdMobileComment);

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdMobileComment mdMobileComment);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdMobileCommentQueryReference extends com.runwaysdk.system.metadata.MdMobileFieldQuery.MdMobileFieldQueryReference
 implements MdMobileCommentQueryReferenceIF

  {

  public MdMobileCommentQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(com.runwaysdk.system.metadata.MdMobileComment mdMobileComment)
    {
      if(mdMobileComment == null) return this.EQ((java.lang.String)null);
      return this.EQ(mdMobileComment.getId());
    }

    public com.runwaysdk.query.BasicCondition NE(com.runwaysdk.system.metadata.MdMobileComment mdMobileComment)
    {
      if(mdMobileComment == null) return this.NE((java.lang.String)null);
      return this.NE(mdMobileComment.getId());
    }

  public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText()
  {
    return getCommentText(null);

  }
 
  public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias)
  {
    return (com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF)this.attributeFactory(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT, com.runwaysdk.system.metadata.MdAttributeLocalText.CLASS, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF)this.attributeFactory(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT, com.runwaysdk.system.metadata.MdAttributeLocalText.CLASS, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeLocal localFactory( com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdLocalStructDAOIF mdLocalStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT)) 
    {
       return new com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStruct((com.runwaysdk.dataaccess.MdAttributeLocalDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.localFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface MdMobileCommentQueryMultiReferenceIF extends com.runwaysdk.system.metadata.MdMobileFieldQuery.MdMobileFieldQueryMultiReferenceIF
  {

    public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText();
    public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias);
    public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment);
    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment);
    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment);
    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment);
    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class MdMobileCommentQueryMultiReference extends com.runwaysdk.system.metadata.MdMobileFieldQuery.MdMobileFieldQueryMultiReference
 implements MdMobileCommentQueryMultiReferenceIF

  {

  public MdMobileCommentQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment)  {

      String[] itemIdArray = new String[mdMobileComment.length]; 

      for (int i=0; i<mdMobileComment.length; i++)
      {
        itemIdArray[i] = mdMobileComment[i].getId();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment)  {

      String[] itemIdArray = new String[mdMobileComment.length]; 

      for (int i=0; i<mdMobileComment.length; i++)
      {
        itemIdArray[i] = mdMobileComment[i].getId();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment)  {

      String[] itemIdArray = new String[mdMobileComment.length]; 

      for (int i=0; i<mdMobileComment.length; i++)
      {
        itemIdArray[i] = mdMobileComment[i].getId();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment)  {

      String[] itemIdArray = new String[mdMobileComment.length]; 

      for (int i=0; i<mdMobileComment.length; i++)
      {
        itemIdArray[i] = mdMobileComment[i].getId();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(com.runwaysdk.system.metadata.MdMobileComment ... mdMobileComment)  {

      String[] itemIdArray = new String[mdMobileComment.length]; 

      for (int i=0; i<mdMobileComment.length; i++)
      {
        itemIdArray[i] = mdMobileComment[i].getId();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText()
  {
    return getCommentText(null);

  }
 
  public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias)
  {
    return (com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF)this.attributeFactory(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT, com.runwaysdk.system.metadata.MdAttributeLocalText.CLASS, alias, null);

  }
 
  public com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF getCommentText(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStructIF)this.attributeFactory(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT, com.runwaysdk.system.metadata.MdAttributeLocalText.CLASS, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeLocal localFactory( com.runwaysdk.dataaccess.MdAttributeLocalDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdLocalStructDAOIF mdLocalStructIF, String structTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(com.runwaysdk.system.metadata.MdMobileComment.COMMENTTEXT)) 
    {
       return new com.runwaysdk.system.metadata.MdMobileCommentCommentTextQuery.MdMobileCommentCommentTextQueryStruct((com.runwaysdk.dataaccess.MdAttributeLocalDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.localFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdLocalStructIF, structTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
