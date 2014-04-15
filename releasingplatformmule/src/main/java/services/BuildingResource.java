package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/building")
public class BuildingResource {

	String result = "Processing BUILDING ...";
	
	public BuildingResource() {}
	
	@GET
	public Response getBuilding() {
		System.out.println(result);
		return Response.status(Status.OK).entity(result).build();
	}
	
	
}
