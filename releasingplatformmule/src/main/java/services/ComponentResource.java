package services;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;




@Path("/components")
public class ComponentResource {
	
	public ComponentResource() {}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Component> getComponentsList() {
		System.out.println("Trying to access to getComponentsList method ...");
		
		Component comp0 = new Component();
		Component comp1 = new Component(1, "hello", "how are", "you");
		Component comp2 = new Component(2, "I'm", "fine", "and you");
		
		List<Component> listComponents = new ArrayList<Component>();
		listComponents.add(comp0);
		listComponents.add(comp1);
		listComponents.add(comp2);
		
		return listComponents;
		
		//[comp0, comp1, comp2];
		
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/component_dev", "root", "");
//		Statement stmt = conn.createStatement();
//		String query = "SELECT * FROM component_table;";
//		ResultSet rs = stmt.executeQuery(query);
//		ResultSetMetaData resultMeta = rs.getMetaData();
		
//		String result = "";
//		
//		result += "[";
//		while(rs.next()) {
//			JSONObject json = new JSONObject();
//			
//			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
//				Object obj = rs.getObject(i);
//				json.put(resultMeta.getColumnName(i), (obj==null?"null":obj.toString()));
//			}
//			
//			result += json.toString();
//			
//			if(!rs.isLast())
//				result += ",";
//		}
//		result += "]";
//		
//		return result;
	}

}
