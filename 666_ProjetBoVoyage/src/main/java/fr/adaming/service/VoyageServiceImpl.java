package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Voyage;

@Service("voyageService")
@Transactional
public class VoyageServiceImpl implements IVoyageService {

	//transformation uml en java
	@Autowired
	private IGeneriqueDao< Voyage > voyageDao;
	
	//setters
	public void setVoyageDao(IGeneriqueDao<Voyage> voyageDao) {
		this.voyageDao = voyageDao;
	}

	@Override
	public List<Voyage> afficherListeVoyageService() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
