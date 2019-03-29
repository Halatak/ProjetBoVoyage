package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Hotel;

public interface IHotelDao extends IGeneriqueDao<Hotel>{

	public List<Hotel> getAllPhoto();

	public Hotel getByIdPhoto(int id);



}
