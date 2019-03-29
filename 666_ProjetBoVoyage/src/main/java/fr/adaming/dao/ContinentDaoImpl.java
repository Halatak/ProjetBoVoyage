package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
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

	@Override
	public List<Continent> getAllPhoto() {
		// recuperer la liste
		List<Continent> liste = getAll();
		//met l'image dans chaque element de la liste
		for(Continent c:liste){
			c.setImg("data:image/png;base64,"+Base64.encodeBase64String(c.getPhoto()));
		}

		return liste;
	}

	@Override
	public Continent getByIdPhoto(int id) {

		//recupere l'objet
		Continent continent = getById(id);
		//met l'image dans chaque element de la liste
		continent.setImg("data:image/png;base64,"+Base64.encodeBase64String(continent.getPhoto()));

		return continent;
	}



}
