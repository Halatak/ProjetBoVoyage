package fr.adaming.dao;

import fr.adaming.model.ConseillerMarketing;

public interface IConseillerMarkDao {
	
	public ConseillerMarketing getConsMarkByMail(String mail);

}
