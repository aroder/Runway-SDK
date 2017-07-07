package com.runwaysdk.system.metadata;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = 177080567)
public enum IndicatorOperator implements com.runwaysdk.business.BusinessEnumeration
{
  DIV();
  
  public static final java.lang.String CLASS = "com.runwaysdk.system.metadata.IndicatorOperator";
  private com.runwaysdk.system.metadata.MathOperator enumeration;
  
  private synchronized void loadEnumeration()
  {
    com.runwaysdk.system.metadata.MathOperator enu = com.runwaysdk.system.metadata.MathOperator.getEnumeration(this.name());
    setEnumeration(enu);
  }
  
  private synchronized void setEnumeration(com.runwaysdk.system.metadata.MathOperator enumeration)
  {
    this.enumeration = enumeration;
  }
  
  public String getOperatorSymbol()
  {
    loadEnumeration();
    return enumeration.getOperatorSymbol();
  }
  
  public java.lang.String getId()
  {
    loadEnumeration();
    return enumeration.getId();
  }
  
  public java.lang.String getEnumName()
  {
    loadEnumeration();
    return enumeration.getEnumName();
  }
  
  public java.lang.String getDisplayLabel()
  {
    loadEnumeration();
    return enumeration.getDisplayLabel().getValue(com.runwaysdk.session.Session.getCurrentLocale());
  }
  
  public static IndicatorOperator get(String id)
  {
    for (IndicatorOperator e : IndicatorOperator.values())
    {
      if (e.getId().equals(id))
      {
        return e;
      }
    }
    return null;
  }
  
}
