package net.sandikta.smp.aplikasi.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

public interface Dao<T> {

	public List<T> findAll();
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public void flush();
	
	public void clear();
	
	public void setSession(Session session);
}