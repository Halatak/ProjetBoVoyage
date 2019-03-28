package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.CarteBancaire;

@Repository
public class CarteBancaireDaoImpl extends AbstraitHibernateDao<CarteBancaire> implements ICarteBancaireDao{

	@Autowired
	private SessionFactory sf;
	
	//Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
}
