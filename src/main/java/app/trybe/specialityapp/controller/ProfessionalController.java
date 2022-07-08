package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
import java.util.NoSuchElementException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



/**
 * Professional Controller.
 */
@Controller
@Path("/api/professional")
public class ProfessionalController {
  @Autowired
  private ProfessionalService service;

  /**
   * Get All.
   */
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAll() {
    List<Professional> professionals = service.getAllProfessionals();

    if (professionals.size() == 0) {
      return Response.status(404)
          .entity(
              new ApplicationError(Response.Status.NOT_FOUND, "Nenhum registro foi encontrado!"))
          .build();
    }
    return Response.ok(professionals).build();
  }

  /**
   * Create .
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response insert(Professional data) {
    Professional professional = service.createProfessional(data);
    return Response.status(201).entity(professional).build();
  }

  /**
   * Update.
   */
  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response edit(@PathParam("id") Integer id, Professional data) {
    try {
      Professional professional = service.editProfessional(id, data);
      return Response.ok(professional).build();
    } catch (NoSuchElementException e) {
      return Response.status(404)
          .entity(
              new ApplicationError(Response.Status.NOT_FOUND, "Nenhum registro foi encontrado!"))
          .build();
    }
  }

  /**
   * Delete.
   */
  @DELETE
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response delete(@PathParam("id") Integer id) {
    try {
      service.deleteProfessional(id);
      return Response.ok().build();
    } catch (NoSuchElementException e) {
      return Response.status(404)
          .entity(
              new ApplicationError(Response.Status.NOT_FOUND, "Nenhum registro foi encontrado!"))
          .build();
    }
  }

}
