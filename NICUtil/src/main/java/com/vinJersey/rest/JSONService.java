package com.vinJersey.rest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.MultiPart;
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
		bus.setMobile("8181818182");

		return bus;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Business bus) {

		String result = mobileHelper(bus);
		return Response.status(201).entity(result).build();

	}

	public String mobileHelper(Business bus) {
		String val = null;
		if (bus.getName().equalsIgnoreCase("Google")
				&& bus.getIdNumber().equalsIgnoreCase("001")) {
			val = "81818183";
		}

		System.out.println("val : " + val);

		return val;
	}
	
	@POST
	@Consumes("multipart/mixed")
	@Path("/upload")
	public Response post(MultiPart multiPart) {

		BodyPartEntity bpe = (BodyPartEntity) multiPart.getBodyParts().get(0)
				.getEntity();
		String id = UUID.randomUUID().toString();
		
		boolean isProcessed = false;
		String message = null;
		try {
			InputStream source = bpe.getInputStream();
			BufferedImage bi = ImageIO.read(source);

			File file = new File("E:/Goodies/svinbass/git/vinbass/theinventory/src/main/webapp/resources/images/VIN.jpg");

			// storing the image to file system.
			if (file.isDirectory()) {
				ImageIO.write(bi, "jpg", file);
			} else {
				file.mkdirs();
				ImageIO.write(bi, "jpg", file);
			}
			isProcessed = true;

		} catch (Exception e) {
			message = e.getMessage();
		}
		if (isProcessed) {
			return Response.status(Response.Status.ACCEPTED)
					.entity(id)
					.type(MediaType.TEXT_PLAIN).build();
		}

		return Response.status(Response.Status.BAD_REQUEST)
				.entity("Failed to process attachments. Reason : " + message)
				.type(MediaType.TEXT_PLAIN).build();
	}


	
}