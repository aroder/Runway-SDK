package com.runwaysdk.system;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = -1504380575)
public enum RatioOperatorDTO implements com.runwaysdk.business.EnumerationDTOIF
{
  DIV();
  
  public final static String CLASS = "com.runwaysdk.system.RatioOperator";
  
  
  public com.runwaysdk.system.MathOperatorDTO item(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (com.runwaysdk.system.MathOperatorDTO) clientRequest.getEnumeration(com.runwaysdk.system.RatioOperatorDTO.CLASS, this.name());
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.system.MathOperatorDTO> items(com.runwaysdk.constants.ClientRequestIF clientRequest, RatioOperatorDTO ... items)
  {
    java.lang.String[] itemNames = new java.lang.String[items.length];
    for(int i=0; i<items.length; i++)
    {
      itemNames[i] = items[i].name();
    }
    return (java.util.List<com.runwaysdk.system.MathOperatorDTO>) clientRequest.getEnumerations(com.runwaysdk.system.RatioOperatorDTO.CLASS, itemNames);
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.system.MathOperatorDTO> allItems(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (java.util.List<com.runwaysdk.system.MathOperatorDTO>) clientRequest.getAllEnumerations(com.runwaysdk.system.RatioOperatorDTO.CLASS);
  }
  
  public java.lang.String getName()
  {
    return this.name();
  }
}
