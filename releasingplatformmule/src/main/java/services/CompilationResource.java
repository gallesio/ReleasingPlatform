package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/compilation")
public class CompilationResource {
	
	String result = "Processing COMPILATION ...";
	
	public CompilationResource() {}
	
	@GET
	public Response getCompilation() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}

}
