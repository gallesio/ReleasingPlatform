package services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

@Path("/RM")
public class RM {
	
	String result = "Processing RM ...";
	
	public RM() {}
	
	@POST
	public String instanciateProcess(String input) {
		
		Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("kermit", "kermit"));
        WebResource webResource = client.resource("http://localhost:8080/activiti-rest/service/process-instance");
        
        System.out.println(result);

        ClientResponse response = webResource.post(ClientResponse.class, input);
        String output = response.getEntity(String.class);
        
        return output;
	}

}
