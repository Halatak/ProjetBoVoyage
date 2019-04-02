package fr.adaming.dao;

import fr.adaming.model.Client;
import fr.adaming.model.Dossier;

public interface IDossierDao extends IGeneriqueDao<Dossier>{
	
	public Dossier getDossierByIdClientDao(Client c);

}
