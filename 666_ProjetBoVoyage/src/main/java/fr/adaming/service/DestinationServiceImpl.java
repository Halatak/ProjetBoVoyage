package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Destination;

@Service("destinationService")
@Transactional
public class DestinationServiceImpl implements IDestinationService{

	//transformation uml en java
	private IGeneriqueDao< Destination > destinationDao;

	//setters
	@Autowired
	public void setDestinationDao(IGeneriqueDao<Destination> destinationDao) {
		this.destinationDao = destinationDao;
		destinationDao.setClazz(Destination.class);
	}
	public IGeneriqueDao<Destination> getDestinationDao() {
		return destinationDao;
	}

	@Override
	public List<Destination> afficherListeDestinationService() {
		return destinationDao.getAll();
	}

	@Override
	public Destination ajoutDestinationService(Destination d) {
		return destinationDao.ajout(d);

	}

	@Override
	public void modifierDestinationService(Destination d) {
		destinationDao.modifier(d);

	}

	@Override
	public void supprDestinationService(Destination d) {
		destinationDao.suppr(d);

	}

	@Override
	public void supprDestinationByIdService(int id) {
		destinationDao.supprById(id);

	}

	@Override
	public Destination getDestinationByIdService(int id) {
		return destinationDao.getById(id);
	}

}
