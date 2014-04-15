package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/publish")
public class PublishResource {
	
	String result = "Processing PUBLISH ...";
	
	public PublishResource() {}
	
	@GET
	public Response getPublish() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}

}
