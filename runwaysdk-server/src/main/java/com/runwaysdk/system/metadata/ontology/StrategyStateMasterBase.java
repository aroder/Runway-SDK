package com.runwaysdk.system.metadata.ontology;

@com.runwaysdk.business.ClassSignature(hash = -1649200872)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to StrategyStateMaster.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class StrategyStateMasterBase extends com.runwaysdk.system.EnumerationMaster
{
  public final static String CLASS = "com.runwaysdk.system.metadata.ontology.StrategyStateMaster";
  private static final long serialVersionUID = -1649200872;
  
  public StrategyStateMasterBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static StrategyStateMaster get(String id)
  {
    return (StrategyStateMaster) com.runwaysdk.business.Business.get(id);
  }
  
  public static StrategyStateMaster getByKey(String key)
  {
    return (StrategyStateMaster) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static StrategyStateMaster getEnumeration(String enumName)
  {
    return (StrategyStateMaster) com.runwaysdk.business.Business.getEnumeration(com.runwaysdk.system.metadata.ontology.StrategyStateMaster.CLASS ,enumName);
  }
  
  public static StrategyStateMaster lock(java.lang.String id)
  {
    StrategyStateMaster _instance = StrategyStateMaster.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static StrategyStateMaster unlock(java.lang.String id)
  {
    StrategyStateMaster _instance = StrategyStateMaster.get(id);
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
