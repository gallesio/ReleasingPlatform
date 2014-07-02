package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

@Path("/releases")
public class ReleaseResource {
	
	public ReleaseResource() {}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Release> getReleasesList() {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<Release> releasesList = new ArrayList<Release>();
		
		try {
			transaction = session.beginTransaction();
			releasesList = session.createQuery("from Release").list();
			
			for (Iterator<Release> it = releasesList.iterator(); it.hasNext();) {
				Release release = (Release) it.next();
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
		
		return releasesList;
	}
	
	
	// ATTENTION IL FAUT DES LISTES EN PARAMETRES POUR LES FEATURES ET LES COMPOSANTS !!!!
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public long createRelease(
			@FormParam("release_name") String name, @FormParam("release_owner") String owner, @FormParam("release_status") String status) {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		Long release_id = null;
		//Component component = null;
		//Feature feature = null;
		
		try {
			transaction = session.beginTransaction();
			//component = (Component) session.createQuery("from Component where comp_id = :comp_id").setParameter("comp_id", comp_id).uniqueResult();
			//feature   = (Feature)   session.createQuery("from Feature where feat_id = :feat_id").setParameter("feat_id", feat_id).uniqueResult();
			
			Release release = new Release();
			release.setName(name);
			release.setOwner(owner);
			release.setStatus(status);
			
			Set<Component> componentsList = new HashSet<Component> ();
//			componentsList.add(component);
//			Set<Feature> featuresList = new HashSet<Feature>();
//			featuresList.add(feature);
			
			//release.setComponentsList(componentsList);
			//release.setFeaturesList(featuresList);
			
			release_id = (Long) session.save(release);
			
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
		}
		
		return release_id;
	}

}
