package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Formule;

@Repository
public class FormuleDaoImpl extends AbstraitHibernateDao<Formule> implements IFormuleDao {

	@Autowired
	private SessionFactory sf;
	
	//Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Formule> getFormuleByVoyage(int id) {
		Session s = sf.getCurrentSession();

		String req = "FROM Formule f WHERE f.voyage.id=:pIdVoyage";

		Query query = s.createQuery(req);

		query.setParameter("pIdVoyage", id);
		return (List<Formule>) query.list();
	}
}
