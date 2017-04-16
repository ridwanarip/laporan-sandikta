package net.sandikta.smp.aplikasi.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.sandikta.smp.aplikasi.dao.AccountDao;
import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.Guru;
import net.sandikta.smp.aplikasi.entities.UserAccount;

public class AppDaoAccountInsert {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<UserAccount, Long> daoUser = new AccountDao();
			daoUser.setSession(session);

			tx = session.beginTransaction();
			
			UserAccount user1 = getUser1();
			UserAccount user2 = getUser2();
			daoUser.save(user1);
			daoUser.save(user2);
			
			List<UserAccount> user = daoUser.findAll();
			for (UserAccount u : user) {
				System.out.println("\nNama: " + u.getUsername());
				
				List<Guru> guru = new ArrayList<Guru>();
				guru.add(u.getGuru());
				
				for (Guru g : guru) {
					System.out.println("\tNama: " + g.getNama());
					System.out.println("\tNIK: " + g.getNik());
					System.out.println("\tAlamat: " + g.getAlamat());
				}
			}
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {		
			session.close();
			sessionFactory.close();
		}
	}
	
	public static UserAccount getUser1() {
		Guru guru = new Guru();
		guru.setNik("10004");
		guru.setNama("Handoko");
		guru.setAlamat("Cipenjo City");
		
		UserAccount ua = new UserAccount();
		ua.setUsername("handoko");
		ua.setPassword("lontong");
		ua.setGuru(guru);
		return ua;
	}
	
	public static UserAccount getUser2() {
		Guru guru = new Guru();
		guru.setNik("10005");
		guru.setNama("Susanto");
		guru.setAlamat("Gedong City");
		
		UserAccount ua = new UserAccount();
		ua.setUsername("susanto");
		ua.setPassword("balapan");
		ua.setGuru(guru);
		return ua;
	}
}