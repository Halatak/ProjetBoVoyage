package fr.adaming.dao;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GeneriqueHibernateDao<T extends Serializable> extends AbstraitHibernateDao<T> implements IGeneriqueDao<T> {
	//
}
