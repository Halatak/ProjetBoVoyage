package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyage;

@Repository
public class VoyageDaoImpl extends AbstraitHibernateDao<Voyage> implements IVoyageDao  {
	
	@Autowired
	private SessionFactory sf;
	
	//Setter pour l'injection de depances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


}
