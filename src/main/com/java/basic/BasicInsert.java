package main.com.java.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.com.java.bean.Student;

public class BasicInsert {
	public static void main(String[] args) {
		
		/*
		 * Bootstrapping the Hibernate
		 * Create org.hibernate.cfg.Configuration Object and use .configure
		 * Build org.hibernate.SessionFactory Object through Configuration.buildSessionFactory()
		 * Create a org.hibernate.Session from SessionFactory.openSession() and use it for Transaction
		 */
		Configuration config = new Configuration();
		config.configure();
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// Using session object to perform transaction
		
		Transaction transaction = session.beginTransaction();
		
		Student std = new Student();
		std.setSaddress("Shegaon");
		std.setSage(23);
		std.setSid(105);
		std.setSname("DJ");
		
		/*
		 * We can use .save or .persist for insert operation.
		 * .save returns the generated id. while .persist is void
		 * .save can be called outside transaction scope. while .persist can not
		 */
		session.save(std);
		
		/*
		 * .commit() commits the current transaction, making its changes permanent.
		 * .rollback() rolls back the current transaction, canceling its changes.
		 */
		transaction.commit();
		
		session.close();
		
	}
}
