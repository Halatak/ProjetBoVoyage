package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Hotel;


@Service("hotelService")
@Transactional
public class HotelServiceImpl implements IHotelService{

	//transformation uml en java
	private IGeneriqueDao< Hotel > hotelDao;

	//setters
	@Autowired
	public void setHotelDao(IGeneriqueDao<Hotel> hotelDao) {
		this.hotelDao = hotelDao;
		hotelDao.setClazz(Hotel.class);
	}
	public IGeneriqueDao<Hotel> getHotelDao() {
		return hotelDao;
	}

	@Override
	public List<Hotel> afficherListeHotelService() {
		return hotelDao.getAll();
	}

	@Override
	public Hotel ajoutHotelService(Hotel h) {
		return hotelDao.ajout(h);
	}

	@Override
	public void modifierHotelService(Hotel h) {
		hotelDao.modifier(h);

	}

	@Override
	public void supprHotelService(Hotel h) {
		hotelDao.suppr(h);

	}

	@Override
	public void supprHotelByIdService(int id) {
		hotelDao.supprById(id);

	}

	@Override
	public Hotel getHotelByIdService(int id) {
		return hotelDao.getById(id);
	}

}
