package com.runwaysdk.system.scheduler;

@com.runwaysdk.business.ClassSignature(hash = 799527032)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to QualifiedTypeJob.java
 *
 * @author Autogenerated by RunwaySDK
 */
public class QualifiedTypeJobQueryDTO extends com.runwaysdk.system.scheduler.ExecutableJobQueryDTO
{
private static final long serialVersionUID = 799527032;

  protected QualifiedTypeJobQueryDTO(String type)
  {
    super(type);
  }

@SuppressWarnings("unchecked")
public java.util.List<? extends com.runwaysdk.system.scheduler.QualifiedTypeJobDTO> getResultSet()
{
  return (java.util.List<? extends com.runwaysdk.system.scheduler.QualifiedTypeJobDTO>)super.getResultSet();
}
}