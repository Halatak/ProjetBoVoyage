package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl extends AbstraitHibernateDao<Client> implements IClientDao  {
	

	@Autowired
	private SessionFactory sf;
	
	//Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Client getClientByMail(String mail) {
		Session s = sf.getCurrentSession();

		String req = "FROM Client cl WHERE cl.mail=:pMail";

		Query query = s.createQuery(req);

		query.setParameter("pMail", mail);
		return (Client) query.uniqueResult();
	}

}
