package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Avion;

public interface IAvionService {
	
	public List<Avion> afficherListeAvionService();
	
	public void ajoutAvionService(Avion a);
	
	public void modifierAvionService(Avion a);
	
	public void supprAvionService(Avion a);
	
	public void supprAvionByIdService (int id);
	
	public Avion getAvionByIdService (int id);

}
