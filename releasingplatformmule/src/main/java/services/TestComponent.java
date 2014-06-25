package services;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import services.Component;
import services.SessionFactoryUtil;

public class TestComponent {

	private static void queryComponent(Session session) {

		Query query = session.createQuery("from Component");      

		List <Component>list = query.list();
		Iterator<Component> iter = list.iterator();

		while (iter.hasNext()) {
			Component component = iter.next();
			System.out.println("Component : " + component.getName() + ", " + component.getType() + ", " + component.getRef() + ", " + component.getId());
		}
		session.getTransaction().commit();
	}

	public static void createComponent(Session session) {
		Component component = new Component();
		component.setName("NAME");
		component.setType("TYPE");      
		component.setRef("REF");      

		session.save(component);
	}
	
	public static void listComponents(Session session) {
		
	}


	public static void main(String[] args) {

		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		createComponent(session);
		queryComponent(session);
	}

}
