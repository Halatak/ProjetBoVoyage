package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Role;

@Repository
public class RoleDaoImpl extends AbstraitHibernateDao<Role> implements IRoleDao {

}
