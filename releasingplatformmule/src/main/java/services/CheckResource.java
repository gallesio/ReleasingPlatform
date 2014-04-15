package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/check")
public class CheckResource {
	
	String result = "Processing CHECK ...";
	
	public CheckResource() {}
	
	@GET
	public Response getCheck() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}

}
