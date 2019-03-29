package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Destination;

@Repository
public class DestinationDaoImpl extends AbstraitHibernateDao<Destination> implements IDestinationDao{
	
	@Autowired
	private SessionFactory sf;
	
	//Setter pour l'injection de dependances
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Destination> getAllPhoto() {
		// recuperer la liste
		List<Destination> liste = getAll();
		
		for(Destination c:liste){
			c.setImg("data:image/png;base64,"+Base64.encodeBase64String(c.getPhoto()));
		}
		
		return liste;
	}

	@Override
	public Destination getByIdPhoto(int id) {

		Destination dest = getById(id);
		dest.setImg("data:image/png;base64,"+Base64.encodeBase64String(dest.getPhoto()));
		
		return dest;
	}

}
