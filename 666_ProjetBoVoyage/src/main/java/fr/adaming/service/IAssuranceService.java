package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Assurance;

public interface IAssuranceService {
	
	public List<Assurance> afficherListeAssuranceService();
	
	public void ajoutAssuranceService(Assurance a);
	
	public void modifierAssuranceService(Assurance a);
	
	public void supprAssuranceService(Assurance a);
	
	public void supprAssuranceByIdService (int id);
	
	public Assurance getAssuranceByIdService (int id);

}
