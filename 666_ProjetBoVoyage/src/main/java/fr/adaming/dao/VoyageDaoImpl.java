package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyage;

@Repository
public class VoyageDaoImpl extends AbstraitHibernateDao<Voyage> implements IVoyageDao  {
	
	@Autowired
	private SessionFactory sf;
	
	//Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


}
