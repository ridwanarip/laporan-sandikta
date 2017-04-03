package net.sandikta.smp.aplikasi.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.sandikta.smp.aplikasi.entities.Siswa;

public class AppSelectSiswa {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		try {
			
			Transaction transaction = session.beginTransaction();
			
			Siswa siswa = session.get(Siswa.class, 1L);
			System.out.println("Method executed");
			System.out.println(siswa.getNama());
			
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
}