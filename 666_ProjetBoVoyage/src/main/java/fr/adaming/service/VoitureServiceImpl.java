package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.dao.IVoitureDao;
import fr.adaming.model.Voiture;

@Service("voitureService")
@Transactional
public class VoitureServiceImpl implements IVoitureService{

	//transformation uml en java
	private IVoitureDao voitureDao;

	//setters
	@Autowired
	public void setVoitureDao(IVoitureDao voitureDao) {
		this.voitureDao = voitureDao;
		voitureDao.setClazz(Voiture.class);
	}
	public IGeneriqueDao<Voiture> getVoitureDao() {
		return voitureDao;
	}

	@Override
	public List<Voiture> afficherListeVoitureService() {
		return voitureDao.getAllPhoto();
	}

	@Override
	public Voiture ajoutVoitureService(Voiture v) {
		return voitureDao.ajout(v);
	}

	@Override
	public void modifierVoitureService(Voiture v) {
		voitureDao.modifier(v);

	}

	@Override
	public void supprVoitureService(Voiture v) {
		voitureDao.suppr(v);

	}

	@Override
	public void supprVoitureByIdService(int id) {
		voitureDao.supprById(id);

	}

	@Override
	public Voiture getVoitureByIdService(int id) {
		return voitureDao.getByIdPhoto(id);
	}

}
