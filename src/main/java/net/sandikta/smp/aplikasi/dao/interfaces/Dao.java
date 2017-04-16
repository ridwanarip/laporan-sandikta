package net.sandikta.smp.aplikasi.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface Dao<T, ID extends Serializable> {

	public List<T> findAll();
	
	public T findByID(ID id);
	
	public void save(T entity);
	
	public void delete(T entity);

	public void setSession(Session session);
	
//	public void flush();
//	
//	public void clear();
}