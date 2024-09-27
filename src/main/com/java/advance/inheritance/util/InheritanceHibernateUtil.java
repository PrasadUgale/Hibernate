package main.com.java.advance.inheritance.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.com.java.advance.inheritance.model.CardPayment;
import main.com.java.advance.inheritance.model.ChequePayment;
import main.com.java.advance.inheritance.model.Payment;

public class InheritanceHibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
							.configure()
							.addAnnotatedClass(Payment.class)
							.addAnnotatedClass(CardPayment.class)
							.addAnnotatedClass(ChequePayment.class)
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

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
