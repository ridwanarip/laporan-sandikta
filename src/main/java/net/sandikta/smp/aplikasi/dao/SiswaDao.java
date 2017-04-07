package net.sandikta.smp.aplikasi.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.Siswa;

public class SiswaDao implements Dao<Siswa> {

	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Siswa> findAll() {
		// List<Siswa> siswa = getSession().createCriteria(Siswa.class).list();
		CriteriaQuery<Siswa> cq = session.getCriteriaBuilder()
				.createQuery(Siswa.class);
		cq.from(Siswa.class);
		
		List<Siswa> siswa = session.createQuery(cq).getResultList();
		return siswa;
	}

	public void save(Siswa siswa) {
		this.session.saveOrUpdate(siswa);
	}

	public void delete(Siswa siswa) {
		this.session.delete(siswa);
	}

	public void flush() {
		this.session.flush();
	}

	public void clear() {
		this.session.clear();
	}
}