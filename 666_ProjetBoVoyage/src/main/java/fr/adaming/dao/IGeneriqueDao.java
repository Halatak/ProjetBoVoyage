package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

public interface IGeneriqueDao<T extends Serializable> {

	T getById(final long id);

	List<T> getAll();

	void ajout(final T entity);

	void modifier(final T entity);

	void suppr(final T entity);

	void supprById(final long entityId);

}
