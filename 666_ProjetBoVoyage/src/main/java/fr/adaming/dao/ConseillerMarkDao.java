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

	@Override
	public ConseillerMarketing getConsMarkByMail(String mail) {
		Session s=sf.getCurrentSession();
		
		String req="FROM ConseillerMarketing cons WHERE cons.mail=:pMail";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pMail", mail);
		return (ConseillerMarketing) query.uniqueResult();
	}
	
	

	
}
