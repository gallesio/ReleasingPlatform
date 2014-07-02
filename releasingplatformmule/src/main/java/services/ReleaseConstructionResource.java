package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Path("/releaseconstructions")
public class ReleaseConstructionResource {
	
	public ReleaseConstructionResource() {}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReleaseConstruction> getReleaseConstructionsList() {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<ReleaseConstruction> releaseConstructionsList = new ArrayList<ReleaseConstruction>();
		
		try {
			transaction = session.beginTransaction();
			releaseConstructionsList = session.createQuery("from Release_construction").list();
			
			for (Iterator<ReleaseConstruction> it = releaseConstructionsList.iterator(); it.hasNext();) {
				ReleaseConstruction releaseConstruction = (ReleaseConstruction) it.next();
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
		
		return releaseConstructionsList;
	}

}
