package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Destination;

public interface IDestinationService {
	
	public List<Destination> afficherListeDestinationService();
	
	public void ajoutDestinationService(Destination d);
	
	public void modifierDestinationService(Destination d);
	
	public void supprDestinationService(Destination d);
	
	public void supprDestinationByIdService (int id);
	
	public Destination getDestinationByIdService (int id);

}
