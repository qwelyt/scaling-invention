package com.github.qwelyt;

@Path("/data")
public class DataResource {

	@Path("logged-in")
	public Response loggedIn(){
		return respond(String.valueOf(new Random()));
	}


	private Response repsond(final String str){
		return Response.ok().entity(str).build();
	}
}
