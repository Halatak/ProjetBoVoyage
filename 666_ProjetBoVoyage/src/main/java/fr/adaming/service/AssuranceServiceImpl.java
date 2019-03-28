package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Assurance;

@Service("assuranceService")
@Transactional
public class AssuranceServiceImpl implements IAssuranceService{

	//transformation uml en java
	private IGeneriqueDao< Assurance > assuranceDao;

	//setters
	@Autowired
	public void setVoyageDao(IGeneriqueDao<Assurance> assuranceDao) {
		this.assuranceDao = assuranceDao;
		assuranceDao.setClazz(Assurance.class);
	}
	public IGeneriqueDao<Assurance> getAssuranceDao() {
		return assuranceDao;
	}
	
	
	@Override
	public List<Assurance> afficherListeAssuranceService() {
		return assuranceDao.getAll();
	}

	@Override
	public Assurance ajoutAssuranceService(Assurance a) {
		return assuranceDao.ajout(a);

	}

	@Override
	public void modifierAssuranceService(Assurance a) {
		assuranceDao.modifier(a);

	}

	@Override
	public void supprAssuranceService(Assurance a) {
		assuranceDao.suppr(a);

	}

	@Override
	public void supprAssuranceByIdService(int id) {
		assuranceDao.supprById(id);

	}

	@Override
	public Assurance getAssuranceByIdService(int id) {
		return assuranceDao.getById(id);
	}

}
