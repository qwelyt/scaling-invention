package com.github.qwelyt;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Random;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/data")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class DataResource {

   @GET
   @Path("logged-in")
   public Response loggedIn() {
      final int i = new Random().nextInt();
      return respond(String.valueOf(i < 0 ? i*-1 : i));
   }

   private Response respond(final String str) {
      return Response.ok().entity(str).build();
   }
}
