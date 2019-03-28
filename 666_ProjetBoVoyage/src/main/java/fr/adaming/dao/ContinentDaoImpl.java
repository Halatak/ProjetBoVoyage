package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Continent;

@Repository
public class ContinentDaoImpl extends AbstraitHibernateDao<Continent> implements IContinentDao{

	@Autowired
	private SessionFactory sf;
	
	//Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
}
