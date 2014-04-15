package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/declaration")
public class DeclarationResource {

	String result = "Processing DECLARATION ...";
	
	public DeclarationResource() {}
	
	@GET
	public Response getDeclaration() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}
}
