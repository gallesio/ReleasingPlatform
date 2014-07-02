package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import services.SessionFactoryUtil;

public class TestComponent {

	public static void main(String[] args) {

		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		List<Release> releasesList = new ArrayList<Release>();
		
		
		try {
			transaction = session.beginTransaction();
			
			// TEST CREATION COMPONENT AND FEATURES :
//			Component component = new Component("TEST_COMP_NAME_MAIN", "TEST_COMP_TYPE_MAIN", "TEST_COMP_REF_MAIN");
//			
//			Feature feature1 = new Feature("TEST_FEAT_NAME_MAIN1", component);
//			Feature feature2 = new Feature("TEST_FEAT_NAME_MAIN2", component);
//			session.save(feature1);
//			session.save(feature2);
			
			// TEST CREATION RELEASE WITHOUT REFERENCES TO COMPONENT OR FEATURES :
			Release release = new Release("NAME", "OWNER", "STATUS");
			session.save(release);
			
			// TEST CREATION RELEASE CONSTRUCTION WITHOUT REFERENCE TO RELEASE :
//			ReleaseConstruction releaseConstruction = new ReleaseConstruction("NAME", "OWNER", "STATUS", "CODELEVEL");
//			session.save(releaseConstruction);
			
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
