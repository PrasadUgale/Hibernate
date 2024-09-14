package main.com.java.version.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.com.java.version.model.VersionDemo;

public class VersionDemoUtil {
	
	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
							.configure()
							.addAnnotatedClass(VersionDemo.class)
							.buildSessionFactory();
		}
	}

	public static Session getSession() {
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
