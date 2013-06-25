package com.vinJersey.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vinJersey.Business;

@Path("/contact")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Business getTrackInJSON() {

		Business bus = new Business();
		bus.setName("Google");
		bus.setIdNumber("001");
		bus.setMobile("8181818181");

		return bus;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Business bus) {

		String result = mobileHelper(bus);
		return Response.status(201).entity(result).build();
		
	}
	
	public String mobileHelper(Business bus){
		String val = null;
		if(bus.getName().equalsIgnoreCase("Google") && bus.getIdNumber().equalsIgnoreCase("001")){
			val = "81818182";
		}
		
		System.out.println("val : "+val);
		
		return val;
	}
	
}