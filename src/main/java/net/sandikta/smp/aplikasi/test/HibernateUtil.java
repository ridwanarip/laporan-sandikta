package net.sandikta.smp.aplikasi.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {

			// Configuration configuration = new Configuration();
			// ServiceRegistry sr = new StandardServiceRegistryBuilder()
			// .applySettings(configuration.getProperties())
			// .build();
			// return configuration.buildSessionFactory(sr);

			// Configuration configuration = new Configuration();
			// configuration.configure();
			// return configuration.buildSessionFactory(
			// new StandardServiceRegistryBuilder()
			// .applySettings(
			// configuration.getProperties())
			// .build());
			//
			 return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"There was an error building the factory");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}