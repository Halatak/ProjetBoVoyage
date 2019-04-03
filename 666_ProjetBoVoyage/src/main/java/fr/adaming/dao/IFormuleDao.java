package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Formule;

public interface IFormuleDao extends IGeneriqueDao<Formule> {

	public List<Formule> getFormuleByVoyage(int id);
}
