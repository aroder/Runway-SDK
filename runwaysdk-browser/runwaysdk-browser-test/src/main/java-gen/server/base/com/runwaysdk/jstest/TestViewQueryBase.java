package com.runwaysdk.jstest;

@com.runwaysdk.business.ClassSignature(hash = 969856748)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to TestView.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  abstract  class TestViewQueryBase extends com.runwaysdk.query.GeneratedViewQuery
 implements com.runwaysdk.generation.loader.Reloadable
{
private static final long serialVersionUID = 969856748;

  public TestViewQueryBase(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
  }

  public TestViewQueryBase(com.runwaysdk.query.QueryFactory componentQueryFactory, com.runwaysdk.query.ViewQueryBuilder viewQueryBuilder)
  {
    super(componentQueryFactory, viewQueryBuilder);
  }
  public String getClassType()
  {
    return com.runwaysdk.jstest.TestView.CLASS;
  }
  public com.runwaysdk.query.SelectableChar getId()
  {
    return getId(null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getSelectable(com.runwaysdk.jstest.TestView.ID, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getId(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getSelectable(com.runwaysdk.jstest.TestView.ID, alias, displayLabel);

  }
 
  public com.runwaysdk.query.SelectableChar getViewCharacter()
  {
    return getViewCharacter(null);

  }
 
  public com.runwaysdk.query.SelectableChar getViewCharacter(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getSelectable(com.runwaysdk.jstest.TestView.VIEWCHARACTER, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getViewCharacter(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getSelectable(com.runwaysdk.jstest.TestView.VIEWCHARACTER, alias, displayLabel);

  }
 
  public com.runwaysdk.system.PhoneNumberQuery.PhoneNumberQueryStructIF getViewPhone()
  {
    return getViewPhone(null);

  }
 
  public com.runwaysdk.system.PhoneNumberQuery.PhoneNumberQueryStructIF getViewPhone(String alias)
  {
    return (com.runwaysdk.system.PhoneNumberQuery.PhoneNumberQueryStructIF)this.getSelectable(com.runwaysdk.jstest.TestView.VIEWPHONE, alias, null);

  }
 
  public com.runwaysdk.system.PhoneNumberQuery.PhoneNumberQueryStructIF getViewPhone(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.PhoneNumberQuery.PhoneNumberQueryStructIF)this.getSelectable(com.runwaysdk.jstest.TestView.VIEWPHONE, alias, displayLabel);

  }
 
  public com.runwaysdk.jstest.RefClassQuery.RefClassQueryReferenceIF getViewReferenceObject()
  {
    return getViewReferenceObject(null);

  }
 
  public com.runwaysdk.jstest.RefClassQuery.RefClassQueryReferenceIF getViewReferenceObject(String alias)
  {

    return (com.runwaysdk.jstest.RefClassQuery.RefClassQueryReferenceIF)this.getSelectable(com.runwaysdk.jstest.TestView.VIEWREFERENCEOBJECT, alias, null);

  }
 
  public com.runwaysdk.jstest.RefClassQuery.RefClassQueryReferenceIF getViewReferenceObject(String alias, String displayLabel)
  {

    return (com.runwaysdk.jstest.RefClassQuery.RefClassQueryReferenceIF)this.getSelectable(com.runwaysdk.jstest.TestView.VIEWREFERENCEOBJECT, alias, displayLabel);

  }
  public com.runwaysdk.jstest.StateEnumQuery.StatesQueryIF getViewSingleState()
  {
    return getViewSingleState(null);

  }
 
  public com.runwaysdk.jstest.StateEnumQuery.StatesQueryIF getViewSingleState(String alias)
  {
    return (com.runwaysdk.jstest.StateEnumQuery.StatesQueryIF)this.getSelectable(com.runwaysdk.jstest.TestView.VIEWSINGLESTATE, alias, null);

  }
 
  public com.runwaysdk.jstest.StateEnumQuery.StatesQueryIF getViewSingleState(String alias, String displayLabel)
  {
    return (com.runwaysdk.jstest.StateEnumQuery.StatesQueryIF)this.getSelectable(com.runwaysdk.jstest.TestView.VIEWSINGLESTATE, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  @java.lang.SuppressWarnings("unchecked")
  public com.runwaysdk.query.OIterator<? extends TestView> getIterator()
  {
    com.runwaysdk.query.ValueIterator valueIterator;
    if (_pageSize != null && _pageNumber != null)
    {
      valueIterator = (com.runwaysdk.query.ValueIterator<com.runwaysdk.dataaccess.ValueObject>)this.getComponentQuery().getIterator(_pageSize, _pageNumber);
    }
    else
    {
      valueIterator = (com.runwaysdk.query.ValueIterator<com.runwaysdk.dataaccess.ValueObject>)this.getComponentQuery().getIterator();
    }
    return new com.runwaysdk.query.ViewIterator<TestView>(this.getMdClassIF(), valueIterator);
  }

}
