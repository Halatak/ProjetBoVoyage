package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voiture;

public interface IVoitureDao extends IGeneriqueDao<Voiture>{
	
	public List<Voiture> getAllPhoto();

	public Voiture getByIdPhoto(int id);

}
