package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.CarteBancaire;

@Service("carteBancaireService")
@Transactional
public class CarteBancaireServiceImpl implements ICarteBancaireService{

	//transformation uml en java
	private IGeneriqueDao< CarteBancaire > carteBancaireDao;

	//setters
	@Autowired
	public void setCarteBancaireDao(IGeneriqueDao<CarteBancaire> carteBancaireDao) {
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

}
