package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	public List<Client> afficherListeClientService();
	
	public Client ajoutClientService(Client c);
	
	public void modifierClientService(Client c);
	
	public void supprClientService(Client c);
	
	public void supprClientByIdService (int id);
	
	public Client getClientByIdService (int id);
	
	public Client getClientByMail(String mail);

}
