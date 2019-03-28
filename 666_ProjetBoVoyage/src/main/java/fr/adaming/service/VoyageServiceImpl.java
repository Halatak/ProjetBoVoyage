package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Voyage;

@Service("voyageService")
@Transactional
public class VoyageServiceImpl implements IVoyageService {

	//transformation uml en java
	@Autowired
	private IVoyageDao voyageDao;
	
	//setters
	public void setVoyageDao(IVoyageDao voyageDao) {
		this.voyageDao = voyageDao;
	}


	@Override
	public List<Voyage> afficherListeVoyageService() {
		return voyageDao.afficherListeVoyageDao();
	}

}
