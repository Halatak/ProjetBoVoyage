package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;
import fr.adaming.model.ConseillerMarketing;

public interface IConseillerClientService {
	
	public ConseillerClientele getConsClientByMail(String mail);
	
	public List<ConseillerClientele> afficherListeConseillerClientService();

}
