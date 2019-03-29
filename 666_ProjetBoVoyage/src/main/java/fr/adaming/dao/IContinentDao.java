package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Continent;

public interface IContinentDao extends IGeneriqueDao<Continent>{
	
	public List<Continent> getAllPhoto();

	public Continent getByIdPhoto(int id);

}
