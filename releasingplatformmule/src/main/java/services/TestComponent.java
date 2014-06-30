package services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import services.Component;
import services.Feature;
import services.SessionFactoryUtil;

public class TestComponent {

	public static void main(String[] args) {

		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Component component = new Component("TEST_COMP_NAME_MAIN", "TEST_COMP_TYPE_MAIN", "TEST_COMP_REF_MAIN");
			
			Feature feature1 = new Feature("TEST_FEAT_NAME_MAIN1", component);
			Feature feature2 = new Feature("TEST_FEAT_NAME_MAIN2", component);
			session.save(feature1);
			session.save(feature2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
