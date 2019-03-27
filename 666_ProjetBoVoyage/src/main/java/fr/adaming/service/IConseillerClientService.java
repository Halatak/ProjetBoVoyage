package fr.adaming.service;

import fr.adaming.model.ConseillerClientele;
import fr.adaming.model.ConseillerMarketing;

public interface IConseillerClientService {
	
	public ConseillerClientele getConsClientByMail(String mail);

}
