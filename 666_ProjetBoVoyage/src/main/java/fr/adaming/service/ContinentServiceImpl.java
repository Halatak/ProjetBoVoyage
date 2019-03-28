package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Continent;

@Service("continentService")
@Transactional
public class ContinentServiceImpl implements IContinentService{

	//transformation uml en java
	private IGeneriqueDao< Continent > continentDao;

	//setters
	@Autowired
	public void setContinentDao(IGeneriqueDao<Continent> continentDao) {
		this.continentDao = continentDao;
		continentDao.setClazz(Continent.class);
	}
	public IGeneriqueDao<Continent> getContinentDao() {
		return continentDao;
	}

	@Override
	public List<Continent> afficherListeContinentService() {
		return continentDao.getAll();
	}

	@Override
	public Continent ajoutContinentService(Continent c) {
		return continentDao.ajout(c);

	}

	@Override
	public void modifierContinentService(Continent c) {
		continentDao.modifier(c);

	}

	@Override
	public void supprContinentService(Continent c) {
		continentDao.suppr(c);

	}

	@Override
	public void supprContinentByIdService(int id) {
		continentDao.supprById(id);

	}

	@Override
	public Continent getContinentByIdService(int id) {
		return continentDao.getById(id);
	}

}
