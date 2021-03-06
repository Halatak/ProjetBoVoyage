package fr.adaming.service;

import java.util.List;

import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Client;

public interface ICarteBancaireService {

public List<CarteBancaire> afficherListeCarteBancaireService();
	
	public CarteBancaire ajoutCarteBancaireService(CarteBancaire cb);
	
	public void modifierCarteBancaireService(CarteBancaire cb);
	
	public void supprCarteBancaireService(CarteBancaire cb);
	
	public void supprCarteBancaireByIdService (int id);
	
	public CarteBancaire getCarteBancaireByIdService (int id);
	
	public CarteBancaire getCBByClient(Client c);
	
}
