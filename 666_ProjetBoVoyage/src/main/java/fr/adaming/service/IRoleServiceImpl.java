package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.dao.IRoleDao;
import fr.adaming.model.Role;

@Service("roleService")
@Transactional
public class IRoleServiceImpl implements IRoleService{

	//transformation uml en java
	private IRoleDao roleDao;

	//setters
	@Autowired
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
		roleDao.setClazz(Role.class);
	}
	public IGeneriqueDao<Role> getRoleDao() {
		return roleDao;
	}

	@Override
	public List<Role> afficherListeRoleService() {
		return roleDao.getAll();
	}

	@Override
	public Role ajoutRoleService(Role r) {
		return roleDao.ajout(r);
	}

	@Override
	public void modifierRoleService(Role r) {
		roleDao.modifier(r);

	}

	@Override
	public void supprRoleService(Role r) {
		roleDao.suppr(r);
	}

	@Override
	public void supprRoleByIdService(int id) {
		roleDao.supprById(id);

	}

	@Override
	public Role getRoleByIdService(int id) {
		return roleDao.getById(id);
	}

}
