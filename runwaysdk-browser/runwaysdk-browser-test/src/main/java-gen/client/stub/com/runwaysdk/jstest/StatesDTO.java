package com.runwaysdk.jstest;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = 506907076)
public enum StatesDTO implements com.runwaysdk.business.EnumerationDTOIF, com.runwaysdk.generation.loader.Reloadable
{
  CA(),
  
  CO(),
  
  CT();
  
  public final static String CLASS = "com.runwaysdk.jstest.States";
  
  
  public com.runwaysdk.jstest.StateEnumDTO item(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (com.runwaysdk.jstest.StateEnumDTO) clientRequest.getEnumeration(com.runwaysdk.jstest.StatesDTO.CLASS, this.name());
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.jstest.StateEnumDTO> items(com.runwaysdk.constants.ClientRequestIF clientRequest, StatesDTO ... items)
  {
    java.lang.String[] itemNames = new java.lang.String[items.length];
    for(int i=0; i<items.length; i++)
    {
      itemNames[i] = items[i].name();
    }
    return (java.util.List<com.runwaysdk.jstest.StateEnumDTO>) clientRequest.getEnumerations(com.runwaysdk.jstest.StatesDTO.CLASS, itemNames);
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<com.runwaysdk.jstest.StateEnumDTO> allItems(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (java.util.List<com.runwaysdk.jstest.StateEnumDTO>) clientRequest.getAllEnumerations(com.runwaysdk.jstest.StatesDTO.CLASS);
  }
  
  public java.lang.String getName()
  {
    return this.name();
  }
}
