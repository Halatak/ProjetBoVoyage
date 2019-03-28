package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Voyage;

public interface IVoyageService {
	
	public List<Voyage> afficherListeVoyageService();
	
	public Voyage ajoutVoyageService(Voyage v);
	
	public void modifierVoyageService(Voyage v);
	
	public void supprVoyageService(Voyage v);
	
	public void supprVoyageByIdService (int id);
	
	public Voyage getVoyageByIdService (int id);

}
