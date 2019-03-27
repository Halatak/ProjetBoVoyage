package fr.adaming.dao;

import fr.adaming.model.ConseillerClientele;

public interface IConseillerClientDao {
	
	public ConseillerClientele getConsClientByMail(String mail);

}
