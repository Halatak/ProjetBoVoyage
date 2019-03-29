package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Destination;

public interface IDestinationDao extends IGeneriqueDao<Destination> {
	
	public List<Destination> getAllPhoto();
	
	public Destination getByIdPhoto(int id);

}
