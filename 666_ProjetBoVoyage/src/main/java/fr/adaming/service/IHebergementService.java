package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Hebergement;

public interface IHebergementService {
	
	public List<Hebergement> afficherListeHebergementService();
	
	public Hebergement ajoutHebergementService(Hebergement h);
	
	public void modifierHebergementService(Hebergement h);
	
	public void supprHebergementService(Hebergement h);
	
	public void supprHebergementByIdService (int id);
	
	public Hebergement getHebergementByIdService (int id);

}
