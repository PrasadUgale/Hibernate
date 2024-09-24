package main.com.java.filter.service;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.filter.model.BankAccount;
import main.com.java.filter.util.HibernateUtil;

public class GetDataByFilter {
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// Enabling the Filter on Entity class called "BankAccount"
			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
			filter.setParameter("param1", "blocked");
			filter.setParameter("param2", "closed");

			// HQL
			Query<BankAccount> query = session.createQuery("from BankAccount where balance>=:amt");
			query.setParameter("amt", 15000.0f);
			List<BankAccount> accounts = query.getResultList();
			accounts.forEach(System.out::println);
			
			System.out.println("--------------------------");
			
			//Disable the Filter on Entity class called "BankAccount"
			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			Query<BankAccount> query1 = session.createQuery("from BankAccount where balance>=:amt");
			query1.setParameter("amt", 15000.0f);
			List<BankAccount> accounts1 = query1.getResultList();
			accounts1.forEach(System.out::println);
			

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
