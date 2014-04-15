package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/copy")
public class CopyResource {

	String result = "Processing COPY ...";
	
	public CopyResource() {}
	
	@GET
	public Response getCopy() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}
	
}
