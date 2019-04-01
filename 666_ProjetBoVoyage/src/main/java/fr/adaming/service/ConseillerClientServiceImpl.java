package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerClientDao;
import fr.adaming.model.ConseillerClientele;
@Service("conClientService")
@Transactional
public class ConseillerClientServiceImpl implements IConseillerClientService{

	//transformation de l'association UML en JAVA
	@Autowired
	private IConseillerClientDao conClientDao;
	
	//le setter pour l'injection de dependance
	public void setConClientDao(IConseillerClientDao conClientDao) {
		this.conClientDao = conClientDao;
	}
	
	@Override
	public ConseillerClientele getConsClientByMail(String mail) {
		return conClientDao.getConsClientByMail(mail);
	}

	@Override
	public List<ConseillerClientele> afficherListeConseillerClientService() {
		return conClientDao.getAll();
	}

}
