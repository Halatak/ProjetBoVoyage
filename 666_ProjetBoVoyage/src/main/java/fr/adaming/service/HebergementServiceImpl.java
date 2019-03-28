package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.dao.IHebergementDao;
import fr.adaming.model.Hebergement;

@Service("hebergementService")
@Transactional
public class HebergementServiceImpl implements IHebergementService{

	//transformation uml en java
	private IHebergementDao hebergementDao;

	//setters
	@Autowired
	public void setHebergementDao(IHebergementDao hebergementDao) {
		this.hebergementDao = hebergementDao;
		hebergementDao.setClazz(Hebergement.class);
	}
	public IGeneriqueDao<Hebergement> getHebergementDao() {
		return hebergementDao;
	}

	@Override
	public List<Hebergement> afficherListeHebergementService() {
		return hebergementDao.getAll();
	}

	@Override
	public Hebergement ajoutHebergementService(Hebergement h) {
		return hebergementDao.ajout(h);

	}

	@Override
	public void modifierHebergementService(Hebergement h) {
		hebergementDao.modifier(h);

	}

	@Override
	public void supprHebergementService(Hebergement h) {
		hebergementDao.suppr(h);

	}

	@Override
	public void supprHebergementByIdService(int id) {
		hebergementDao.supprById(id);

	}

	@Override
	public Hebergement getHebergementByIdService(int id) {
		return hebergementDao.getById(id);
	}

}
