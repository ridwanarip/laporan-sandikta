package net.sandikta.smp.aplikasi.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.TahunPelajaran;

public class TahunPelajaranDao implements Dao<TahunPelajaran, Long> {

	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public TahunPelajaran findByID(Long id) {
		TahunPelajaran tahunPelajaran = (TahunPelajaran) session.
				get(TahunPelajaran.class, id);
		return tahunPelajaran;
	}

	@Override
	public List<TahunPelajaran> findAll() {
		CriteriaQuery<TahunPelajaran> cq = session.getCriteriaBuilder().
				createQuery(TahunPelajaran.class);
		cq.from(TahunPelajaran.class);
		
		List<TahunPelajaran> tahunPelajaran = session.createQuery(cq).getResultList();
		return tahunPelajaran;
	}

	@Override
	public void save(TahunPelajaran tahunPelajaran) {
		this.session.saveOrUpdate(tahunPelajaran);
	}

	@Override
	public void delete(TahunPelajaran tahunPelajaran) {
		this.session.delete(tahunPelajaran);
	}
}