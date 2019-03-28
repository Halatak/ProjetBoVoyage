package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDossierDao;
import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Dossier;

@Service("dossierService")
@Transactional
public class DossierServiceImpl implements IDossierService{

	//transformation uml en java
	private IDossierDao dossierDao;

	//setters
	@Autowired
	public void setDossierDao(IDossierDao dossierDao) {
		this.dossierDao = dossierDao;
		dossierDao.setClazz(Dossier.class);
	}
	public IGeneriqueDao<Dossier> getDossierDao() {
		return dossierDao;
	}

	@Override
	public List<Dossier> afficherListeDossierService() {
		return dossierDao.getAll();
	}

	@Override
	public Dossier ajoutDossierService(Dossier d) {
		return dossierDao.ajout(d);
	}

	@Override
	public void modifierDossierService(Dossier d) {
		dossierDao.modifier(d);

	}

	@Override
	public void supprDossierService(Dossier d) {
		dossierDao.suppr(d);

	}

	@Override
	public void supprDossierByIdService(int id) {
		dossierDao.supprById(id);

	}

	@Override
	public Dossier getDossierByIdService(int id) {
		return dossierDao.getById(id);
	}

}
