package services;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

@Path("/RCM")
public class RCM {
	
	String result = "Processing RCM ...";
	
	public RCM() {}
	
	@POST
	@Path("/instProc")
    public String instanciateProcess(String input) {
		
		System.out.println("input = " + input);
		
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("kermit", "kermit"));
        WebResource webResource = client.resource("http://localhost:8080/activiti-rest/service/process-instance");
        
        System.out.println(result);
        
        ClientResponse response = webResource.post(ClientResponse.class, input);
        String output = response.getEntity(String.class);
        
        return output;    
    }
	
	@GET
	@Path("/findProcInst")
	public String findProcessInstance(String input) {
		
		System.out.println("input = " + input);
		
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("kermit", "kermit"));
        WebResource webResource = client.resource("http://localhost:8080/activiti-rest/service/process-instances&processDefinitionId=" + input);
        
        System.out.println(result);
        
        ClientResponse response = webResource.get(ClientResponse.class);
        String output = response.getEntity(String.class);
        
        return output;
	}
	
	@GET
	@Path("/listActProcInst")
	public String getProcessInstances() {
		
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("kermit", "kermit"));
		WebResource webResource = client.resource("http://localhost:8080/activiti-rest/service/process-instances?size=100");
		
		System.out.println(result);
		
		ClientResponse response = webResource.get(ClientResponse.class);
		String output = response.getEntity(String.class);
		
		return output;
	}
	
	@GET
	@Path("/listFinProcInst")
	public String getProcessInstancesHistory() {
		
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("kermit", "kermit"));
		WebResource webResource = client.resource("http://localhost:8080/activiti-rest/service/history/historic-process-instances?size=1000");
		
		System.out.println(result);
		
		ClientResponse response = webResource.get(ClientResponse.class);
		String output = response.getEntity(String.class);
		
		return output;
	}
}
