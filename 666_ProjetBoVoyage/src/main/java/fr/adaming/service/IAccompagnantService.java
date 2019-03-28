package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Accompagnant;

public interface IAccompagnantService {
	
public List<Accompagnant> afficherListeAccompagnantService();
	
	public Accompagnant ajoutAccompagnantService(Accompagnant a);
	
	public void modifierAccompagnantService(Accompagnant a);
	
	public void supprAccompagnantService(Accompagnant a);
	
	public void supprAccompagnantByIdService (int id);
	
	public Accompagnant getAccompagnantByIdService (int id);

}
