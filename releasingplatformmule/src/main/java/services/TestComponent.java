package services;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import services.Component;
import services.SessionFactoryUtil;

public class TestComponent {

	private static void queryPerson(Session session) {

		Query query = session.createQuery("from Person");      

		List <Component>list = query.list();
		Iterator<Component> iter = list.iterator();

		while (iter.hasNext()) {
			Component component = iter.next();
			System.out.println("Person: " + component.getName() +", " + component.getType() +", " +component.getRef());
		}
		session.getTransaction().commit();
	}

	public static void createPerson(Session session) {
		Component component = new Component();
		component.setName("NAME");
		component.setType("TYPE");      
		component.setRef("REF");      

		session.save(component);
	}


	public static void main(String[] args) {

		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		createPerson(session);
		queryPerson(session);
	}

}
