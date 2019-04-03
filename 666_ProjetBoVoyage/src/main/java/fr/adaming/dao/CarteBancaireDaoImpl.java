package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Client;
import fr.adaming.model.Dossier;

@Repository
public class CarteBancaireDaoImpl extends AbstraitHibernateDao<CarteBancaire> implements ICarteBancaireDao {

	@Autowired
	private SessionFactory sf;

	// Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public CarteBancaire getCBByClient(Client c) {
		Session s = sf.getCurrentSession();

		String req = "FROM CarteBancaire cb WHERE cb.client=:pClient";

		Query query = s.createQuery(req);

		query.setParameter("pClient", c);
		return (CarteBancaire) query.uniqueResult();
	}

}
