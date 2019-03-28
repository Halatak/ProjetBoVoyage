package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Continent;

public interface IContinentService {
	
	public List<Continent> afficherListeContinentService();
	
	public void ajoutContinentService(Continent c);
	
	public void modifierContinentService(Continent c);
	
	public void supprContinentService(Continent c);
	
	public void supprContinentByIdService (int id);
	
	public Continent getContinentByIdService (int id);

}
