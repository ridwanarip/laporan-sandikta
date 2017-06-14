package net.sandikta.smp.raportapp.console;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.close();
		sessionFactory.close();
	}
}