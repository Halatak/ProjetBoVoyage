package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Hebergement;
import fr.adaming.model.Voyage;

public interface IHebergementService {
	
	public List<Hebergement> afficherListeHebergementService();
	
	public void ajoutHebergementService(Hebergement h);
	
	public void modifierHebergementService(Hebergement h);
	
	public void supprHebergementService(Hebergement h);
	
	public void supprHebergementByIdService (int id);
	
	public Voyage getHebergementByIdService (int id);

}
