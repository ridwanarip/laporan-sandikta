package net.sandikta.smp.raportapp.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import net.sandikta.smp.raportapp.dao.interfaces.Dao;
import net.sandikta.smp.raportapp.entities.Siswa;

public class SiswaDao implements Dao<Siswa, Long> {

	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	public Siswa findByNoInduk(String noInduk) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Siswa> criteria = builder.createQuery(Siswa.class);
		Root<Siswa> from = criteria.from(Siswa.class);
		criteria.select(from);
		criteria.where(builder.equal(from.get(new Siswa().getNoInduk()), noInduk));
		TypedQuery<Siswa> typed = session.createQuery(criteria);
		
		return typed.getSingleResult();
	}
	
	@Override
	public Siswa findByID(Long id) {
		Siswa siswa = (Siswa) session.get(Siswa.class, id);
		return siswa;
	}

	@Override
	public List<Siswa> findAll() {
		CriteriaQuery<Siswa> cq = session.getCriteriaBuilder()
				.createQuery(Siswa.class);
		cq.from(Siswa.class);
		
		List<Siswa> siswa = session.createQuery(cq).getResultList();
		return siswa;
	}
	
	@Override
	public void save(Siswa siswa) {
		this.session.saveOrUpdate(siswa);
	}

	@Override
	public void delete(Siswa siswa) {
		this.session.delete(siswa);
	}

	@Override
	public void update(Siswa siswa) {
		this.session.update(siswa);
	}

	@Override
	public void flush() {
		this.session.flush();
	}
	
	@Override
	public void clear() {
		this.session.clear();
	}
}