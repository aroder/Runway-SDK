package com.runwaysdk.system.metadata;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = 2110021969)
public enum IndicatorAggregateFunction implements com.runwaysdk.business.BusinessEnumeration
{
  AVG(),
  
  COUNT(),
  
  MAX(),
  
  MIN(),
  
  STDEV(),
  
  SUM();
  
  public static final java.lang.String CLASS = "com.runwaysdk.system.metadata.IndicatorAggregateFunction";
  private com.runwaysdk.system.metadata.AggregationFunction enumeration;
  
  private synchronized void loadEnumeration()
  {
    com.runwaysdk.system.metadata.AggregationFunction enu = com.runwaysdk.system.metadata.AggregationFunction.getEnumeration(this.name());
    setEnumeration(enu);
  }
  
  private synchronized void setEnumeration(com.runwaysdk.system.metadata.AggregationFunction enumeration)
  {
    this.enumeration = enumeration;
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
  
  public static IndicatorAggregateFunction get(String id)
  {
    for (IndicatorAggregateFunction e : IndicatorAggregateFunction.values())
    {
      if (e.getId().equals(id))
      {
        return e;
      }
    }
    return null;
  }
  
}