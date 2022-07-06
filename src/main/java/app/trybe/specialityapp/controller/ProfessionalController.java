package app.trybe.specialityapp.controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;

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
  @Consumes("application/json")
  @Produces("application/json")
  public Response findAll() {
    List<Professional> professionals = service.getAllProfessionals();
    return Response.ok(professionals).build();
  }
  //
  // /**
  // * Get by id.
  // */
  // @GET
  // @Path("/{id}")
  // @Consumes("application/json")
  // @Produces("application/json")
  // public Response findById(@PathParam("id") UUID id) {
  // try {
  // Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();
  // return Response.ok(book).build();
  // } catch (NoSuchElementException e) {
  // return Response.status(404).build();
  // }
  // }
  //
  // /**
  // * Create book.
  // */
  // @POST
  // @Consumes("application/json")
  // @Produces("application/json")
  // public Response add(Book book) {
  // return Response.ok(book).build();
  // }
  //
  //
  // /**
  // * Update by id.
  // */
  // @PUT
  // @Path("/{id}")
  // @Consumes("application/json")
  // @Produces("application/json")
  // public Response update(@PathParam("id") UUID id, Book data) {
  // try {
  // Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();
  //
  // book.setAuthor(data.getAuthor());
  // book.setName(data.getName());
  // return Response.ok(books.get(books.indexOf(book))).build();
  // } catch (NoSuchElementException e) {
  // return Response.status(404).build();
  // }
  // }
  //
  // /**
  // * Delete by id.
  // */
  // @DELETE
  // @Path("/{id}")
  // @Consumes("application/json")
  // @Produces("application/json")
  // public Response remove(@PathParam("id") UUID id) {
  // try {
  // Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();
  // books.remove(book);
  // return Response.ok(book).build();
  // } catch (NoSuchElementException e) {
  // return Response.status(404).build();
  // }
  // }

}
