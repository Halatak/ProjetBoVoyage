package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.ConseillerClientele;

public interface IConseillerClientDao {
	
	public ConseillerClientele getConsClientByMail(String mail);
	
	public List<ConseillerClientele> getAll();

}
