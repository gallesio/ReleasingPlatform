package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/compilation")
public class CompilationResource {
	
	public CompilationResource() {}
	
	@GET
	public Response getCompilation() {
		System.out.println("Processing COMPILATION ...");
		return Response.status(Status.OK).entity("Processing COMPILATION ...").build();
	}

}
