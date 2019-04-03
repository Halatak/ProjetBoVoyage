package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Formule;

public interface IFormuleService {
	
	public List<Formule> afficherListeFormuleService();
	
	public Formule ajoutFormuleService(Formule f);
	
	public void modifierFormuleService(Formule f);
	
	public void supprFormuleService(Formule f);
	
	public void supprFormuleByIdService (int id);
	
	public Formule getFormuleByIdService (int id);
	
	public List<Formule> getFormuleByVoyage(int id);

}
