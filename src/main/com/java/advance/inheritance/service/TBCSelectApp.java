package main.com.java.advance.inheritance.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.advance.inheritance.model.CardPayment;
import main.com.java.advance.inheritance.model.ChequePayment;
import main.com.java.advance.inheritance.model.Payment;
import main.com.java.advance.inheritance.util.InheritanceHibernateUtil;

public class TBCSelectApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {
			session = InheritanceHibernateUtil.getSession();
			Query<Payment> query1 = session.createQuery("from Payment");
			List<Payment> payments = query1.getResultList();
			payments.forEach(System.out::println);

			System.in.read();
			
			// selecting child classes
			Query<CardPayment> query2 = session.createQuery("from CardPayment");
			List<CardPayment> card = query2.getResultList();
			card.forEach(System.out::println);

			System.in.read();
			
			// selecting child classes
			Query<ChequePayment> query3 = session.createQuery("from ChequePayment");
			List<ChequePayment> cheque = query3.getResultList();
			cheque.forEach(System.out::println);
			
			/*
			 * i. Single Table Strategy: 
			 * Depends on the Discriminator Column value, it will return a object which is stored
			 * We cant get Parent details as we only get child object 
			 * 
			 * ii. Table per subclass strategy
			 * use inner joins for retrieving records
			 * Cant get Parent class details
			 * 
			 * ii. Table per concrete class
			 * parenct class info can be accessed as it is stored in same table
			 * 
			 * 
			 */

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			InheritanceHibernateUtil.closeSession(session);
			InheritanceHibernateUtil.closeSessionFactory();
		}
	}
}
