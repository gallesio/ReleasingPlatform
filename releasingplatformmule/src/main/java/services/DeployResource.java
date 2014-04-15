package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/deploy")
public class DeployResource {
	
	String result = "Processing DEPLOY ...";
	
	public DeployResource() {}
	
	@GET
	public Response getDeploy() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}

}
