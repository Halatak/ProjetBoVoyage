package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;
import fr.adaming.model.Dossier;

@Repository
public class DossierDaoImpl extends AbstraitHibernateDao<Dossier> implements IDossierDao {

	@Autowired
	private SessionFactory sf;

	// Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Dossier getDossierByIdClientDao(Client c) {
		Session s = sf.getCurrentSession();

		String req = "FROM Dossier do WHERE do.client=:pClient";

		Query query = s.createQuery(req);

		query.setParameter("pClient", c);
		return (Dossier) query.uniqueResult();
	}

}
