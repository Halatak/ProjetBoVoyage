package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormuleDao;
import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Formule;

@Service("formuleService")
@Transactional
public class FormuleServiceImpl implements IFormuleService{

	//transformation uml en java
	private IFormuleDao formuleDao;

	//setters
	@Autowired
	public void setFormuleDao(IFormuleDao formuleDao) {
		this.formuleDao = formuleDao;
		formuleDao.setClazz(Formule.class);
	}
	public IGeneriqueDao<Formule> getFormuleDao() {
		return formuleDao;
	}


	@Override
	public List<Formule> afficherListeFormuleService() {
		return formuleDao.getAll();
	}

	@Override
	public Formule ajoutFormuleService(Formule f) {
		return formuleDao.ajout(f);

	}

	@Override
	public void modifierFormuleService(Formule f) {
		formuleDao.modifier(f);

	}

	@Override
	public void supprFormuleService(Formule f) {
		formuleDao.suppr(f);

	}

	@Override
	public void supprFormuleByIdService(int id) {
		formuleDao.supprById(id);

	}

	@Override
	public Formule getFormuleByIdService(int id) {
		return formuleDao.getById(id);
	}
	@Override
	public List<Formule> getFormuleByVoyage(int id) {
		
		return formuleDao.getFormuleByVoyage(id);
	}

}
