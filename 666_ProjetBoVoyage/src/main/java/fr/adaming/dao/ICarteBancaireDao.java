package fr.adaming.dao;

import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Client;

public interface ICarteBancaireDao extends IGeneriqueDao<CarteBancaire>{

	public CarteBancaire getCBByClient(Client c);
	
}
