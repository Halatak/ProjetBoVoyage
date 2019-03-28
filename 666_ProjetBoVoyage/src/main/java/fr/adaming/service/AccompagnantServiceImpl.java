package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Accompagnant;

@Service("accompagnantService")
@Transactional
public class AccompagnantServiceImpl implements IAccompagnantService{

	//transformation uml en java
	private IGeneriqueDao< Accompagnant > accompagnantDao;

	//setters
	@Autowired
	public void setAccompagnantDao(IGeneriqueDao<Accompagnant> accompagnantDao) {
		this.accompagnantDao = accompagnantDao;
		accompagnantDao.setClazz(Accompagnant.class);
	}
	public IGeneriqueDao<Accompagnant> getAccompagnantDao() {
		return accompagnantDao;
	}

	@Override
	public List<Accompagnant> afficherListeAccompagnantService() {
		return accompagnantDao.getAll();
	}

	@Override
	public Accompagnant ajoutAccompagnantService(Accompagnant a) {
		return accompagnantDao.ajout(a);
	}

	@Override
	public void modifierAccompagnantService(Accompagnant a) {
		accompagnantDao.modifier(a);

	}

	@Override
	public void supprAccompagnantService(Accompagnant a) {
		accompagnantDao.suppr(a);

	}

	@Override
	public void supprAccompagnantByIdService(int id) {
		accompagnantDao.supprById(id);

	}

	@Override
	public Accompagnant getAccompagnantByIdService(int id) {
		return accompagnantDao.getById(id);
	}

}
