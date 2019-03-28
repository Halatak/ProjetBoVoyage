package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Voyage;

@Service("voyageService")
@Transactional
public class VoyageServiceImpl implements IVoyageService {

	//transformation uml en java
	
	private IGeneriqueDao< Voyage > voyageDao;
	
	//setters
	@Autowired
	public void setVoyageDao(IGeneriqueDao<Voyage> voyageDao) {
		this.voyageDao = voyageDao;
		voyageDao.setClazz(Voyage.class);
	}

	public IGeneriqueDao<Voyage> getVoyageDao() {
		return voyageDao;
	}


	@Override
	public List<Voyage> afficherListeVoyageService() {
		return voyageDao.getAll();
	}

	@Override
	public void ajoutVoyageService(Voyage v) {
		voyageDao.ajout(v);
	}

	@Override
	public void modifierVoyageService(Voyage v) {
		voyageDao.modifier(v);
		
	}

	@Override
	public void supprVoyageService(Voyage v) {
		voyageDao.suppr(v);
		
	}

	@Override
	public void supprVoyageByIdService(int id) {
		voyageDao.supprById(id);
		
	}

	@Override
	public Voyage getVoyageByIdService(int id) {
		return voyageDao.getById(id);
	}

	

}
