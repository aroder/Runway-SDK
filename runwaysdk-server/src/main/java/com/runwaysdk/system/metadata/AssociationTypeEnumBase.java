package com.runwaysdk.system.metadata;

@com.runwaysdk.business.ClassSignature(hash = -1709352786)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to AssociationTypeEnum.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class AssociationTypeEnumBase extends com.runwaysdk.system.EnumerationMaster
{
  public final static String CLASS = "com.runwaysdk.system.metadata.AssociationTypeEnum";
  private static final long serialVersionUID = -1709352786;
  
  public AssociationTypeEnumBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static AssociationTypeEnum get(String id)
  {
    return (AssociationTypeEnum) com.runwaysdk.business.Business.get(id);
  }
  
  public static AssociationTypeEnum getByKey(String key)
  {
    return (AssociationTypeEnum) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static AssociationTypeEnum getEnumeration(String enumName)
  {
    return (AssociationTypeEnum) com.runwaysdk.business.Business.getEnumeration(com.runwaysdk.system.metadata.AssociationTypeEnum.CLASS ,enumName);
  }
  
  public static AssociationTypeEnum lock(java.lang.String id)
  {
    AssociationTypeEnum _instance = AssociationTypeEnum.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static AssociationTypeEnum unlock(java.lang.String id)
  {
    AssociationTypeEnum _instance = AssociationTypeEnum.get(id);
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
