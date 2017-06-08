package net.sandikta.smp.raportapp.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import net.sandikta.smp.raportapp.dao.interfaces.Dao;
import net.sandikta.smp.raportapp.entities.TahunPelajaran;
import net.sandikta.smp.raportapp.entities.enums.Kelas;
import net.sandikta.smp.raportapp.entities.enums.Semester;

public class TahunPelajaranDao implements Dao<TahunPelajaran, Long> {

	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	
	public List<TahunPelajaran> findAllById(Long id) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TahunPelajaran> criteriaQuery = builder.createQuery(TahunPelajaran.class);
		Root<TahunPelajaran> root = criteriaQuery.from(TahunPelajaran.class);
		criteriaQuery.select(root).where(builder.equal(root.get("siswa"), id));
		TypedQuery<TahunPelajaran> query = session.createQuery(criteriaQuery);
		
		List<TahunPelajaran> tahunPelajaran = query.getResultList();
		return tahunPelajaran;
	}
	
	public List<TahunPelajaran> findByTahun(Kelas kelas, Semester sms, String tahun) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TahunPelajaran> criteriaQuery = builder.createQuery(TahunPelajaran.class);
		Root<TahunPelajaran> root = criteriaQuery.from(TahunPelajaran.class);
		Path<Kelas> idKelas = root.get("kelas");
		Path<Semester> idSemester = root.get("semester");
		Path<String> idTahun = root.get("tahun");
		criteriaQuery.select(root)
				.where(builder.and(builder.equal(idKelas, kelas), 
						builder.equal(idSemester, sms),
						builder.equal(idTahun, tahun)));
		TypedQuery<TahunPelajaran> query = session.createQuery(criteriaQuery);
		
		List<TahunPelajaran> tahunPelajaran = query.getResultList();
		return tahunPelajaran;
	}

	@Override
	public TahunPelajaran findByID(Long id) {
		TahunPelajaran tahunPelajaran = (TahunPelajaran) session.
				get(TahunPelajaran.class, id);
		return tahunPelajaran;
	}

	@Override
	public List<TahunPelajaran> findAll() {
		CriteriaQuery<TahunPelajaran> criteriaQuery = session.getCriteriaBuilder().
				createQuery(TahunPelajaran.class);
		criteriaQuery.from(TahunPelajaran.class);
		
		List<TahunPelajaran> tahunPelajaran = session.createQuery(criteriaQuery).getResultList();
		return tahunPelajaran;
	}

	@Override
	public void save(TahunPelajaran tahunPelajaran) {
		this.session.save(tahunPelajaran);
	}

	@Override
	public void delete(TahunPelajaran tahunPelajaran) {
		this.session.delete(tahunPelajaran);
	}

	@Override
	public void update(TahunPelajaran tahunPelajaran) {
		this.session.merge(tahunPelajaran);
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