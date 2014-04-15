package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/checkout")
public class CheckOutResource {

	public CheckOutResource() {}
	
	@GET
	public Response getCheckOut() {
		System.out.println("Processing CHECK OUT ...");
		return Response.status(Status.OK).entity("Processing CHECK OUT ...").build();
	}

}


