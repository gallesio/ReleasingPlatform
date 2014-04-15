package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.Base64;

@Path("/RCM")
public class RCM {
	
	String result = "Processing RCM ...";
	
	public RCM() {}
	
	@POST
    public String instanciateProcess(String input) {
        
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("kermit", "kermit"));
        WebResource webResource = client.resource("http://localhost:8080/activiti-rest/service/process-instance");
        //WebResource webResource = client.resource("http://localhost:8080/activiti-rest/service/process-instances");
        
        System.out.println(result);
        
        
        //String input = "{\"processDefinitionKey\":\"releasingProcess\"}";
        //String auth  = new String(Base64.encode("kermit:kermit"));
        
        //ClientResponse response = webResource.header("Authorization", "Basic" + auth).type("application/json").post(ClientResponse.class, input);
        ClientResponse response = webResource.post(ClientResponse.class, input);
        //ClientResponse response = webResource.get(ClientResponse.class);
        
        String output = response.getEntity(String.class);
        
        return output;    
    }

}
