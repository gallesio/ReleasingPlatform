package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import services.ComponentResource;

@Path("/features")
public class FeatureResource {

	public FeatureResource() {}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Feature> listFeatures() {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<Feature> featuresList = new ArrayList<Feature>();
		
		try {
			transaction = session.beginTransaction();
			featuresList = session.createQuery("from Feature").list();
			
			for (Iterator<Feature> it = featuresList.iterator(); it.hasNext();) {
				Feature feature = (Feature) it.next();
				//System.out.println(feature.getName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
		}
		
		return featuresList;
	}
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Long createFeature(@FormParam("feat_name") String name, 
			@FormParam("comp_id") long comp_id) {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		Long featId = null;
		Component component = null;
		
		try {
			transaction = session.beginTransaction();
			component = (Component) session.createQuery("from Component where comp_id = :comp_id").setParameter("comp_id", comp_id).uniqueResult();
			
			Feature feature = new Feature();
			feature.setName(name);
			feature.setComponent(component);

			featId = (Long) session.save(feature);
			
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
		}
		
		return featId;
	}
	
	

}
