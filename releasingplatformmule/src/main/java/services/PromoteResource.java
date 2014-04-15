package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/promote")
public class PromoteResource {

	String result = "Processing PROMOTE ...";
	
	public PromoteResource() {}
	
	@GET
	public Response getPromote() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}
	
}
