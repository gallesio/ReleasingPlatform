package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/deliver")
public class DeliverResource {
	
	public DeliverResource() {}
	
	@GET
	public Response getDeliver() {
		System.out.println("Processing DELIVER ...");
		return Response.status(Status.OK).entity("Processing DELIVER ...").build();
	}

}
