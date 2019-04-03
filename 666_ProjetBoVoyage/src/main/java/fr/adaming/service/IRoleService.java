package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Role;

public interface IRoleService {
	
	public List<Role> afficherListeRoleService();
	
	public Role ajoutRoleService(Role r);
	
	public void modifierRoleService(Role r);
	
	public void supprRoleService(Role r);
	
	public void supprRoleByIdService (int id);
	
	public Role getRoleByIdService (int id);

}
