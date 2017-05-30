package net.sandikta.smp.aplikasi.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface Dao<T, ID extends Serializable> {

	public void setSession(Session session);
	
	public T findByID(ID id);
	
	public List<T> findAll();
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public void update(T entity);

	public void flush();
	
//	public void clear();
}