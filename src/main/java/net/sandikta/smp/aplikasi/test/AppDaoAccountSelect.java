package net.sandikta.smp.aplikasi.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.sandikta.smp.aplikasi.dao.AccountDao;
import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.Guru;
import net.sandikta.smp.aplikasi.entities.UserAccount;

public class AppDaoAccountSelect {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<UserAccount, Long> daoUser = new AccountDao();
			daoUser.setSession(session);

			List<UserAccount> userAccount = daoUser.findAll();
			for (UserAccount s : userAccount) {
				System.out.println("\nUsername: " + s.getUsername());
				System.out.println("Passowrd: " + s.getPassword());
				
				List<Guru> guru = new ArrayList<Guru>();
				guru.add(s.getGuru());
				
				System.out.println("\nData Guru:");
				for (Guru g : guru) {
					System.out.println("\tNama: " + g.getNama());
					System.out.println("\tNIK: " + g.getNik());
					System.out.println("\tAlamat: " + g.getAlamat() + "\n");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}