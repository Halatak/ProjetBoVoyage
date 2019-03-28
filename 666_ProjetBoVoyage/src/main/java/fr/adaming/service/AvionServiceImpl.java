package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Avion;

@Service("avionService")
@Transactional
public class AvionServiceImpl implements IAvionService{

	//transformation uml en java
	private IGeneriqueDao< Avion > avionDao;

	//setters
	@Autowired
	public void setAvionDao(IGeneriqueDao<Avion> avionDao) {
		this.avionDao = avionDao;
		avionDao.setClazz(Avion.class);
	}
	public IGeneriqueDao<Avion> getAvionDao() {
		return avionDao;
	}


	@Override
	public List<Avion> afficherListeAvionService() {
		return avionDao.getAll();
	}

	@Override
	public void ajoutAvionService(Avion a) {
		avionDao.ajout(a);		
	}

	@Override
	public void modifierAvionService(Avion a) {
		avionDao.modifier(a);		
	}

	@Override
	public void supprAvionService(Avion a) {
		avionDao.suppr(a);
	}

	@Override
	public void supprAvionByIdService(int id) {
		avionDao.supprById(id);
	}

	@Override
	public Avion getAvionByIdService(int id) {
		return avionDao.getById(id);
	}

}
