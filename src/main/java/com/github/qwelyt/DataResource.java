package com.github.qwelyt;

import com.github.qwelyt.util.Fibonacci;
import com.github.qwelyt.util.factorial.Factorial;
import com.github.qwelyt.util.primes.Factors;
import com.github.qwelyt.util.primes.Primes;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

   @GET
   @Path("primes/{start}/{primes}")
   public Response primes(@PathParam("start") final Integer start, @PathParam("primes") final Integer primes) {
      System.out.println("Getting " + primes + " prime numbers starting at " + start);
      final List<Integer> primes1 = Primes.primes(start, primes);
      return respond(primes1.stream().map(String::valueOf).collect(Collectors.joining(", ")));
   }

   @GET
   @Path("primes/factors/{number}")
   public Response primeFactors(@PathParam("number") final Integer number) {
      System.out.println("Calculating prime factors for " + number);
      final List<Integer> factors = Factors.of(number);
      return respond(factors.stream().map(String::valueOf).collect(Collectors.joining(", ")));
   }

   @GET
   @Path("fibonacci/{number}")
   public Response fibonacci(@PathParam("number") final Integer number) {
      System.out.println("Getting the " + number + " first numbers in the fibonacci sequence");
      final List<BigInteger> fibs = Fibonacci.fibs(number);
      return respond(fibs.stream().map(String::valueOf).collect(Collectors.joining(", ")));
   }

   private Response respond(final String str) {
      return Response.ok().entity(str).build();
   }
}
