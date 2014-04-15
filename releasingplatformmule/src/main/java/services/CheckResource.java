package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/check")
public class CheckResource {
	
	public CheckResource() {}
	
	@GET
	public Response getCheck() {
		System.out.println("Processing CHECK ...");
		return Response.status(Status.OK).entity("Processing CHECK ...").build();
	}

}
