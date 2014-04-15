package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/validation")
public class ValidationResource {
	
	String result = "Processing VALIDATION ...";
	
	public ValidationResource() {}
	
	@GET
	public Response getValidation() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}

}
