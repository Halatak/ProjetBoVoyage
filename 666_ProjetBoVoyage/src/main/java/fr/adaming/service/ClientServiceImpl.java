package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.Client;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements IClientService{

	//transformation uml en java
	private IGeneriqueDao< Client > clientDao;

	//setters
	@Autowired
	public void setClientDao(IGeneriqueDao<Client> clientDao) {
		this.clientDao = clientDao;
		clientDao.setClazz(Client.class);
	}
	public IGeneriqueDao<Client> getClientDao() {
		return clientDao;
	}


	@Override
	public List<Client> afficherListeClientService() {
		return clientDao.getAll();
	}

	@Override
	public Client ajoutClientService(Client c) {
		return clientDao.ajout(c);

	}

	@Override
	public void modifierClientService(Client c) {
		clientDao.modifier(c);

	}

	@Override
	public void supprClientService(Client c) {
		clientDao.suppr(c);

	}

	@Override
	public void supprClientByIdService(int id) {
		clientDao.supprById(id);

	}

	@Override
	public Client getClientByIdService(int id) {
		return clientDao.getById(id);
	}

}
