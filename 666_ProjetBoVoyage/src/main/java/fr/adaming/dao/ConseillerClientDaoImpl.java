package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ConseillerClientele;

@Repository
public class ConseillerClientDaoImpl implements IConseillerClientDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public ConseillerClientele getConsClientByMail(String mail) {
		Session s=sf.getCurrentSession();
		
		String req="FROM ConseillerClientele cons WHERE cons.mail=:pMail";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pMail", mail);
		return (ConseillerClientele) query.uniqueResult();
	}
}
