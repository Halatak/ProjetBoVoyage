package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICarteBancaireDao;
import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Client;

@Service("carteBancaireService")
@Transactional
public class CarteBancaireServiceImpl implements ICarteBancaireService {

	// transformation uml en java
	private ICarteBancaireDao carteBancaireDao;

	// setters
	@Autowired
	public void setCarteBancaireDao(ICarteBancaireDao carteBancaireDao) {
		this.carteBancaireDao = carteBancaireDao;
		carteBancaireDao.setClazz(CarteBancaire.class);
	}

	public IGeneriqueDao<CarteBancaire> getCarteBancaireDao() {
		return carteBancaireDao;
	}

	@Override
	public List<CarteBancaire> afficherListeCarteBancaireService() {
		return carteBancaireDao.getAll();
	}

	@Override
	public CarteBancaire ajoutCarteBancaireService(CarteBancaire cb) {
		return carteBancaireDao.ajout(cb);
	}

	@Override
	public void modifierCarteBancaireService(CarteBancaire cb) {
		carteBancaireDao.modifier(cb);

	}

	@Override
	public void supprCarteBancaireService(CarteBancaire cb) {
		carteBancaireDao.suppr(cb);

	}

	@Override
	public void supprCarteBancaireByIdService(int id) {
		carteBancaireDao.supprById(id);

	}

	@Override
	public CarteBancaire getCarteBancaireByIdService(int id) {
		return carteBancaireDao.getById(id);
	}

	@Override
	public CarteBancaire getCBByClient(Client c) {
		return carteBancaireDao.getCBByClient(c);
	}

}
