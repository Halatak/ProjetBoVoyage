package fr.adaming.service;

import fr.adaming.model.Client;
import fr.adaming.model.Dossier;

public interface IPDFService {

	public int creerPDF(Dossier dossier, Client client, int numero);
	
}
