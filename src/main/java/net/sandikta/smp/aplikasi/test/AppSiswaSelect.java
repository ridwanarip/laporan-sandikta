package net.sandikta.smp.aplikasi.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.SiswaDao;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.Siswa;

public class AppSiswaSelect {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<Siswa, Long> daoSiswa = new SiswaDao();
			daoSiswa.setSession(session);
			
			Siswa sis = ((SiswaDao) daoSiswa).findByNoInduk("201314");
			System.out.println("Nama: " + sis.getNama());

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}