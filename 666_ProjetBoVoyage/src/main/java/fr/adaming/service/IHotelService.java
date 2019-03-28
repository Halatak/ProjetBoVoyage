package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Hotel;

public interface IHotelService {
	
	public List<Hotel> afficherListeHotelService();
	
	public void ajoutHotelService(Hotel h);
	
	public void modifierHotelService(Hotel h);
	
	public void supprHotelService(Hotel h);
	
	public void supprHotelByIdService (int id);
	
	public Hotel getHotelByIdService (int id);

}
