package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyage;

@Repository
public class VoyageDaoImpl implements IVoyageDao {
	
	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Voyage> afficherListeVoyageDao() {
		// recuperer le bus(session de hibernate)
			Session s=sf.getCurrentSession();
				
			//requete HQL
			String req="FROM Voyage";
				
			//recuperer le query
			Query query=s.createQuery(req);
				
			List<Voyage> listeEtudiant=query.list();
				
			return listeEtudiant;
	}

}
