package br.laab.askgo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface IDAO<T, I extends Serializable> {

	public T save(T entity);

	public void remove(T entity);

	public T getById(Class<T> classe, I pk);

	public List<T> getAll();

	public EntityManager getEntityManager();
}