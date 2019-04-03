package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Accompagnant;

@Repository
public class AccompagnantDaoImpl extends AbstraitHibernateDao<Accompagnant> implements IAccompagnantDao  {
	
	@Autowired
	private SessionFactory sf;
	
	//Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Accompagnant getAccompagnantByMail(String mail) {
		Session s = sf.getCurrentSession();

		String req = "FROM Accompagnant acc WHERE acc.mail=:pMail";

		Query query = s.createQuery(req);

		query.setParameter("pMail", mail);
		return (Accompagnant) query.uniqueResult();
	}
}
