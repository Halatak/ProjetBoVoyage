package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstraitHibernateDao <T extends Serializable>{

	private Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	//methode getById
	public T getById( int id ){
		return (T) getCurrentSession().get(clazz, id);
	}


	public List< T > getAll(){
		return getCurrentSession().createQuery( "FROM " + clazz.getName()).list();
	}

	public void ajout( T entity ){
		//creation de la requete
		getCurrentSession().save(entity);

	}

	public void modifier( T entity ){
		//creation de la requete
		getCurrentSession().merge(entity);
	}

	public void suppr( T entity ){
		//creation de la requete
		getCurrentSession().delete( entity );
	}
	public void supprById( int entityId ) {
		T entity = getById( entityId );
		suppr( entity );
	}


}

