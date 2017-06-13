package com.runwaysdk.system.metadata;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = -489418287)
public enum IndicatorAggregateFunctionDTO implements com.runwaysdk.business.EnumerationDTOIF
{
  AVG(),
  
  COUNT(),
  
  MAX(),
  
  MIN(),
  
  STDEV(),
  
  SUM();
  
  public final static String CLASS = "com.runwaysdk.system.metadata.IndicatorAggregateFunction";
  
  
  public com.runwaysdk.system.metadata.AggregationFunctionDTO item(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (com.runwaysdk.system.metadata.AggregationFunctionDTO) clientRequest.getEnumeration(com.runwaysdk.system.metadata.IndicatorAggregateFunctionDTO.CLASS, this.name());
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.system.metadata.AggregationFunctionDTO> items(com.runwaysdk.constants.ClientRequestIF clientRequest, IndicatorAggregateFunctionDTO ... items)
  {
    java.lang.String[] itemNames = new java.lang.String[items.length];
    for(int i=0; i<items.length; i++)
    {
      itemNames[i] = items[i].name();
    }
    return (java.util.List<com.runwaysdk.system.metadata.AggregationFunctionDTO>) clientRequest.getEnumerations(com.runwaysdk.system.metadata.IndicatorAggregateFunctionDTO.CLASS, itemNames);
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.system.metadata.AggregationFunctionDTO> allItems(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (java.util.List<com.runwaysdk.system.metadata.AggregationFunctionDTO>) clientRequest.getAllEnumerations(com.runwaysdk.system.metadata.IndicatorAggregateFunctionDTO.CLASS);
  }
  
  public java.lang.String getName()
  {
    return this.name();
  }
}
