package com.runwaysdk.constants;

public interface RatioPrimitiveInfo extends RatioElementInfo
{
  /**
   * Interface {@link RatioPrimitiveInfo}.
   */
  public static final String CLASS_NAME              = "RatioPrimitive";
  
  public static final String CLASS                   = Constants.SYSTEM_PACKAGE + "." + CLASS_NAME;
  
  /**
   * ID.
   */
  public static final String ID_VALUE                = "i3obk3gttdjxbk2ko1x7gor2e9y5zlig00000000000000000000000000000001";
  
  /**
   * Reference to an attribute definition.
   */
  public static final String MD_ATTRIBUTE_PRIMITIVE  = "mdAttributePrimitive";
  
  
  // Heads up: Test: Move to RatioPrimitiveDAOIF
  /**
   * The column name on the defining type that stores the reference to the object instance. This is used to retrieve
   * the attribute defined on this ratio on that object.
   */
  public static final String COLUMN_NAME             = "columnName";
  
  /**
   * This is the sequence number of this ratio primitive within a ratio object.
   */
  public static final String SEQUENCE                = "attribute_seq";
}
