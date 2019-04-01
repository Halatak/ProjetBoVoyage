package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerMarkDao;
import fr.adaming.model.ConseillerMarketing;

@Service("conMarkService")
@Transactional
public class ConseillerMarketingServiceImpl implements IConseillerMarketingService {

	// transformation de l'association UML en JAVA
	@Autowired
	private IConseillerMarkDao conMarkDao;

	// le setter pour l'injection de dependance
	public void setConMarkDao(IConseillerMarkDao conMarkDao) {
		this.conMarkDao = conMarkDao;
	}

	@Override
	public ConseillerMarketing getConseillerMarkByMail(String mail) {
		return conMarkDao.getConsMarkByMail(mail);
	}

	@Override
	public List<ConseillerMarketing> afficherListeConseillerMarkService() {
		return conMarkDao.getAll();
	}

}
