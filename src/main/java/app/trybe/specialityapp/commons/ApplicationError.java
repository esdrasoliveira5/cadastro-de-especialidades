package app.trybe.specialityapp.commons;

import javax.ws.rs.core.Response.Status;

/**
 * Aplication Error.
 */
public class ApplicationError {

  private Status status;

  private String message;

  public ApplicationError(Status status, String message) {

  }

  public String getMessage() {
    return message;
  }


  public Status getStatus() {
    return status;
  }

}
