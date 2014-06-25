package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.common.util.ReflectionInvokationHandler.UnwrapParam;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@Path("/components")
public class ComponentResource {
	
	public ComponentResource() {}
	
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Long createComponent(@FormParam("name") String name, @FormParam("type") String type, @FormParam("ref") String ref) {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		Long compId = null;
		
		try {
			transaction = session.beginTransaction();
			
			Component component = new Component();
			component.setName(name);
			component.setType(type);
			component.setRef(ref);
			compId = (Long) session.save(component);
			
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
		}
		
		return compId;
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Component> listComponents() {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<Component> componentsList = new ArrayList<Component>();
		
		try {
			transaction = session.beginTransaction();
			componentsList = session.createQuery("from Component").list();
			
			for (Iterator<Component> it = componentsList.iterator(); it.hasNext();) {
				Component component = (Component) it.next();
				//System.out.println(component.getName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
		}
		
		return componentsList;
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Long updateComponent(Long id, String name, String type, String ref) {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		Long compId = null;
		
		try {
			transaction = session.beginTransaction();
			Component component = (Component) session.get(Component.class, id);
			component.setName(name);
			component.setType(type);
			component.setRef(ref);
			session.update(component);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
		}
		return compId;
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PathParam("{id}")
	public void deleteComponent(@PathParam("id") Long id) {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Component component = (Component) session.get(Component.class, id);
			session.delete(component);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
		}
		
		System.out.println("It has been deleted");
	}
	
	
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Component> getComponentsList2() {
//		System.out.println("Trying to access to getComponentsList method ...");
//		
//		Component comp0 = new Component();
////		Component comp1 = new Component(1, "hello", "how are", "you");
////		Component comp2 = new Component(2, "I'm", "fine", "and you");
//		
//		List<Component> listComponents = new ArrayList<Component>();
//		listComponents.add(comp0);
////		listComponents.add(comp1);
////		listComponents.add(comp2);
//		
//		return listComponents;
//		
//		//[comp0, comp1, comp2];
//		
////		Class.forName("com.mysql.jdbc.Driver");
////		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/component_dev", "root", "");
////		Statement stmt = conn.createStatement();
////		String query = "SELECT * FROM component_table;";
////		ResultSet rs = stmt.executeQuery(query);
////		ResultSetMetaData resultMeta = rs.getMetaData();
//		
////		String result = "";
////		
////		result += "[";
////		while(rs.next()) {
////			JSONObject json = new JSONObject();
////			
////			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
////				Object obj = rs.getObject(i);
////				json.put(resultMeta.getColumnName(i), (obj==null?"null":obj.toString()));
////			}
////			
////			result += json.toString();
////			
////			if(!rs.isLast())
////				result += ",";
////		}
////		result += "]";
////		
////		return result;
//	}

}
