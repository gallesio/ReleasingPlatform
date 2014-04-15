package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/checkout")
public class CheckOutResource {
	
	String result = "Processing CHECK OUT ...";

	public CheckOutResource() {}
	
	@GET
	public Response getCheckOut() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}

}


