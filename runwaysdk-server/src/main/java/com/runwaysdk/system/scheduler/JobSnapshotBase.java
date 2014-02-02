package com.runwaysdk.system.scheduler;

@com.runwaysdk.business.ClassSignature(hash = -298552566)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to JobSnapshot.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class JobSnapshotBase extends com.runwaysdk.system.scheduler.AbstractJob
{
  public final static String CLASS = "com.runwaysdk.system.scheduler.JobSnapshot";
  private static final long serialVersionUID = -298552566;
  
  public JobSnapshotBase()
  {
    super();
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static JobSnapshot get(String id)
  {
    return (JobSnapshot) com.runwaysdk.business.Business.get(id);
  }
  
  public static JobSnapshot getByKey(String key)
  {
    return (JobSnapshot) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static JobSnapshot lock(java.lang.String id)
  {
    JobSnapshot _instance = JobSnapshot.get(id);
    _instance.lock();
    
    return _instance;
  }
  
  public static JobSnapshot unlock(java.lang.String id)
  {
    JobSnapshot _instance = JobSnapshot.get(id);
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
