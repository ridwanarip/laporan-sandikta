package net.sandikta.smp.aplikasi.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.sandikta.smp.aplikasi.entities.Guru;
import net.sandikta.smp.aplikasi.entities.UserAccount;

public class AppAccount {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		try {
			Transaction transaction = session.beginTransaction();
			
			Guru guru = new Guru();
			guru.setNik("10004");
			guru.setNama("Handoko");
			guru.setAlamat("Cipenjo City");
			
			Guru guru2 = new Guru();
			guru2.setNik("10005");
			guru2.setNama("Susanto");
			guru2.setAlamat("Gedong City");
			
			UserAccount ua = new UserAccount();
			ua.setUsername("handoko");
			ua.setPassword("lontong");
			ua.setGuru(guru);
			
			UserAccount ua2 = new UserAccount();
			ua2.setUsername("susanto");
			ua2.setPassword("balap");
			ua2.setGuru(guru2);
			
			session.save(ua);
			session.save(ua2);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
}