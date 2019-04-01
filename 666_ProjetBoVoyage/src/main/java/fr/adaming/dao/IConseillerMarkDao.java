package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.ConseillerMarketing;

public interface IConseillerMarkDao {
	
	public ConseillerMarketing getConsMarkByMail(String mail);
	
	public List<ConseillerMarketing> getAll();

}
