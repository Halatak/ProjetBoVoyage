package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ConseillerMarketing;

@Repository
public class ConseillerMarkDao implements IConseillerMarkDao {

	@Autowired
	private SessionFactory sf;
	
	// le setter pour l'injection dépendance
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

	@Override
	public ConseillerMarketing isExist(ConseillerMarketing conMark) {

		//récupérer la session
		Session s = sf.getCurrentSession();
		
		//requete HQL
		String req = "FROM ConseillerMarketing as conMark WHERE conMark.mail=:pMail AND conMark.mdp=:pMdp";
		
		//Récupérer un objet de type query
		Query query = s.createQuery(req);
				
		//passage des paramètres
		query.setParameter("pMail", conMark.getMail());
		query.setParameter("pMail", conMark.getMdp());
		
		try {
			return (ConseillerMarketing) query.uniqueResult();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return null;
	}
}
