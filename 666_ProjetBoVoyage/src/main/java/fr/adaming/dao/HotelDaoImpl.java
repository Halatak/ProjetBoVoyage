package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Hotel;

@Repository
public class HotelDaoImpl extends AbstraitHibernateDao<Hotel> implements IHotelDao  {

	@Autowired
	private SessionFactory sf;

	//Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Hotel> getAllPhoto() {
		
		// recuperer la liste
		List<Hotel> liste = getAll();
		//met l'image dans chaque element de la liste
		for(Hotel c:liste){
			c.setImg("data:image/png;base64,"+Base64.encodeBase64String(c.getPhoto()));
		}

		return liste;
	}

	@Override
	public Hotel getByIdPhoto(int id) {
		
		//recupere l'objet
		Hotel hotel = getById(id);
		//met l'image dans chaque element de la liste
		hotel.setImg("data:image/png;base64,"+Base64.encodeBase64String(hotel.getPhoto()));

		return hotel;
	}
}
