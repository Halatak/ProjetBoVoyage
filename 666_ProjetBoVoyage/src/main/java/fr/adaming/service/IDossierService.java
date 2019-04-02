package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Dossier;

public interface IDossierService {
	
public List<Dossier> afficherListeDossierService();
	
	public Dossier ajoutDossierService(Dossier d);
	
	public void modifierDossierService(Dossier d);
	
	public void supprDossierService(Dossier d);
	
	public void supprDossierByIdService (int id);
	
	public Dossier getDossierByIdService (int id);
	
	public Dossier getDossierByIdClientDao(Client c);

}
