package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Voiture;

@Repository
public class VoitureDaoImpl extends AbstraitHibernateDao<Voiture> implements IVoitureDao   {

	@Autowired
	private SessionFactory sf;

	//Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Voiture> getAllPhoto() {

		// recuperer la liste
		List<Voiture> liste = getAll();
		//met l'image dans chaque element de la liste
		for(Voiture c:liste){
			c.setImg("data:image/png;base64,"+Base64.encodeBase64String(c.getPhoto()));
		}

		return liste;
	}

	@Override
	public Voiture getByIdPhoto(int id) {

		//recupere l'objet
		Voiture voiture= getById(id);
		//met l'image dans chaque element de la liste
		voiture.setImg("data:image/png;base64,"+Base64.encodeBase64String(voiture.getPhoto()));

		return voiture;
	}
}
