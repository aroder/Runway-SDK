package com.runwaysdk.system.metadata.ontology;

public abstract class DatabaseAllPathsStrategyDTO extends DatabaseAllPathsStrategyDTOBase
{
  private static final long serialVersionUID = 735912426;
  
  public DatabaseAllPathsStrategyDTO(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given BusinessDTO into a new DTO.
  * 
  * @param businessDTO The BusinessDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected DatabaseAllPathsStrategyDTO(com.runwaysdk.business.BusinessDTO businessDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(businessDTO, clientRequest);
  }
  
}
