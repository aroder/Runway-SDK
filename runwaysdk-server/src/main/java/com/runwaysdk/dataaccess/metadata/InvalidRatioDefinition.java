package com.runwaysdk.dataaccess.metadata;

import com.runwaysdk.ServerExceptionMessageLocalizer;

public class InvalidRatioDefinition extends MetadataException
{
  /**
   * 
   */
  private static final long serialVersionUID = -6521886282744211727L;
  private String localizedRatioDisplayLabel;
  
  /**
   * Constructs a new {@link InvalidRatioDefinition} with the specified developer message.
   * 
   * @param _devMessage
   *          The non-localized developer error message. Contains specific data
   *          access layer information useful for application debugging. The
   *          developer message is saved for later retrieval by the
   *          {@link #getMessage()} method.     
   * @param _localizedRatioLabel
   *        Localized Ratio Display Label
   */
  public InvalidRatioDefinition(String _devMessage, String _localizedRatioLabel)
  {
    super(_devMessage);
    
    this.localizedRatioDisplayLabel = _localizedRatioLabel;
  }

  /**
   * Constructs a new {@link InvalidRatioDefinition} with the specified developer message and
   * cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i>
   * automatically incorporated in this MetaDataException's detail message.
   * 
   * @param devMe_devMessagessage
   *          The non-localized developer error message. Contains specific data
   *          access layer information useful for application debugging. The
   *          developer message is saved for later retrieval by the
   *          {@link #getMessage()} method.
   * @param _cause
   *          the cause (which is saved for later retrieval by the
   *          {@link #getCause()} method). (A <tt>null</tt> value is
   *          permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   * @param _localizedRatioLabel
   *        Localized Ratio Display Label
   */
  public InvalidRatioDefinition(String _devMessage, Throwable _cause, String _localizedRatioLabel)
  {
    super(_devMessage, _cause);
    this.localizedRatioDisplayLabel = _localizedRatioLabel;
  }

  /**
   * Constructs a new  {@link InvalidRatioDefinition} with the specified cause and a developer
   * message taken from the cause. This constructor is useful if the
   * MetaDataException is a wrapper for another throwable.
   * 
   * @param cause
   *          the cause (which is saved for later retrieval by the
   *          {@link #getCause()} method). (A <tt>null</tt> value is
   *          permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   * @param _localizedRatioLabel
   *        Localized Ratio Display Label
   */
  public InvalidRatioDefinition(Throwable _cause, String _localizedRatioLabel)
  {
    super(_cause);
    this.localizedRatioDisplayLabel = _localizedRatioLabel;
  }
  /**
   * Uses the stored parameters and the given Locale to produce an error message
   * suitable for display to end users.
   * 
   */
  public String getLocalizedMessage()
  {
    return ServerExceptionMessageLocalizer.invalidRatioDefinition(this.getLocale(), this.localizedRatioDisplayLabel);
  }

}
