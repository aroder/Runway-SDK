package com.runwaysdk.system.scheduler;

public class JobDisplayLabelDTO extends JobDisplayLabelDTOBase
{
  private static final long serialVersionUID = 508278350;
  
  public JobDisplayLabelDTO(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given LocalStructDTO into a new DTO.
  * 
  * @param localStructDTO The LocalStructDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected JobDisplayLabelDTO(com.runwaysdk.business.LocalStructDTO localStructDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(localStructDTO, clientRequest);
  }
  
}
