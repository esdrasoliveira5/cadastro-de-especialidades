package app.trybe.specialityapp.commons;

/**
 * Aplication Error.
 */
public class ApplicationError {

  private Integer status;

  private String message;

  public ApplicationError(Integer status, String message) {

  }

  public String getMessage() {
    return message;
  }


  public Integer getStatus() {
    return status;
  }

}
