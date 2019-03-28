package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Voiture;

public interface IVoitureService {
	
	public List<Voiture> afficherListeVoitureService();
	
	public Voiture ajoutVoitureService(Voiture v);
	
	public void modifierVoitureService(Voiture v);
	
	public void supprVoitureService(Voiture v);
	
	public void supprVoitureByIdService (int id);
	
	public Voiture getVoitureByIdService (int id);

}
