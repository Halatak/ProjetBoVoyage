package fr.adaming.dao;

import fr.adaming.model.Client;

public interface IClientDao extends IGeneriqueDao<Client>{
	
	public Client getClientByMail(String mail);

}
