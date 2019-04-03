package fr.adaming.dao;

import fr.adaming.model.Accompagnant;

public interface IAccompagnantDao extends IGeneriqueDao<Accompagnant> {
	
	public Accompagnant getAccompagnantByMail(String mail);

}
