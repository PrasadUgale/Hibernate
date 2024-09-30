package main.com.java.advance.association.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.com.java.advance.association.model.many2many.Doctor;
import main.com.java.advance.association.model.many2many.Patient;
import main.com.java.advance.association.model.one2many.Person;
import main.com.java.advance.association.model.one2many.PersonBi;
import main.com.java.advance.association.model.one2many.PhoneNumber;
import main.com.java.advance.association.model.one2many.PhoneNumberBi;

public class AssociationHibernateUtil {
	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
							.configure()
							.addAnnotatedClass(Person.class)
							.addAnnotatedClass(PhoneNumber.class)
							.addAnnotatedClass(PersonBi.class)
							.addAnnotatedClass(PhoneNumberBi.class)
							.addAnnotatedClass(Doctor.class)
							.addAnnotatedClass(Patient.class)
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