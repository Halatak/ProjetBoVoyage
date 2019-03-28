package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	public List<Client> afficherListeClientService();
	
	public void ajoutClientService(Client c);
	
	public void modifierClientService(Client c);
	
	public void supprClientService(Client c);
	
	public void supprClientByIdService (int id);
	
	public Client getClientByIdService (int id);

}
