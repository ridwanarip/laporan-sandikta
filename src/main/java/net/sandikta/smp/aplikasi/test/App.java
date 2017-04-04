package net.sandikta.smp.aplikasi.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}