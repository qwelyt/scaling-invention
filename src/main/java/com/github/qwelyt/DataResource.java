package com.github.qwelyt;

import com.github.qwelyt.util.factorial.Factorial;
import com.github.qwelyt.util.factorial.FactorialBig;
import com.github.qwelyt.util.factorial.FactorialSmall;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.Random;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/data")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public final class DataResource {

   @GET
   @Path("logged-in")
   public Response loggedIn() {
      final int i = new Random().nextInt();
      return respond(String.valueOf(i < 0 ? i*-1 : i));
   }

   @GET
   @Path("factorial/{number}")
   public Response factorial(@PathParam("number") final Integer number){
      System.out.println("Calculating factorial for: "+number);
      final BigInteger result = Factorial.of(number);
      return respond(String.valueOf(result));
   }

   private Response respond(final String str) {
      return Response.ok().entity(str).build();
   }
}
