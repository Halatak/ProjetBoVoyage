package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ConseillerMarketing;

@Repository
public class ConseillerMarkDaoImpl implements IConseillerMarkDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public ConseillerMarketing getConsMarkByMail(String mail) {
		Session s = sf.getCurrentSession();

		String req = "FROM ConseillerMarketing cons WHERE cons.mail=:pMail";

		Query query = s.createQuery(req);

		query.setParameter("pMail", mail);
		return (ConseillerMarketing) query.uniqueResult();
	}

	@Override
	public List<ConseillerMarketing> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM ConseillerMarketing";
		Query query = s.createQuery(req);

		return query.list();
	}

}
