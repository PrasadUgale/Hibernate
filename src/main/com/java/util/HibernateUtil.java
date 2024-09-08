package main.com.java.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.com.java.bean.Student;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		if(sessionFactory == null)
			sessionFactory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
	}
	
	public static Session getSession() {
		if(session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory != null) {
			sessionFactory.close();
		}
	}
	
}
