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

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


@Path("/components")
public class ComponentResource {
	
	public ComponentResource() {}
	
	@GET
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
		
		System.out.println("components list : " + componentsList);
		
		return componentsList;
	}
	
	@GET
	@Path("{id}")
	@Consumes("appication/x-www-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Component getComponentById(@PathParam("id") long id) {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		Component component = null;
		
		try {
			transaction = session.beginTransaction();
			component = (Component) session.createQuery("from Component where comp_id =: id").setParameter("id", id).uniqueResult();
			
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
		}
		
		return component;
	}
	
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Long createComponent(@FormParam("comp_name") String name, @FormParam("comp_type") String type, @FormParam("comp_ref") String ref) {
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
	
	@PUT
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Long updateComponent(@FormParam("comp_id") Long id, @FormParam("comp_name") String name, 
			@FormParam("comp_type") String type, @FormParam("comp_ref") String ref) {
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
	@Produces("application/x-www-form-urlencoded")
	public void deleteComponent(@FormParam("id") Long id) {
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
	
}
