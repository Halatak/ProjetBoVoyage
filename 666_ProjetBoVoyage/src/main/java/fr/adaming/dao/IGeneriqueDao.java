package fr.adaming.dao;


import java.util.List;

public interface IGeneriqueDao<T>{
	
	public void setClazz(Class<T> clazzToSet);
	
	public T getById(final int id);

	public List<T> getAll();

	public T ajout(final T entity);

	public void modifier(final T entity);

	public void suppr(final T entity);

	public void supprById(final int entityId);

}
