package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Accompagnant;

public interface IAccompagnantService {
	
public List<Accompagnant> afficherListeAccompagnantService();
	
	public Accompagnant ajoutAccompagnantService(Accompagnant v);
	
	public void modifierAccompagnantService(Accompagnant v);
	
	public void supprAccompagnantService(Accompagnant v);
	
	public void supprAccompagnantByIdService (int id);
	
	public Accompagnant getAccompagnantByIdService (int id);

}
