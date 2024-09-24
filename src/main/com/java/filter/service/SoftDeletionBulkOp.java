package main.com.java.filter.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.com.java.filter.model.BankAccount;
import main.com.java.filter.util.HibernateUtil;

public class SoftDeletionBulkOp {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Query<BankAccount> query = session.createQuery("update BankAccount set status='blocked' where accNo=:no");
			query.setParameter("no",3);
			query.executeUpdate();

			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("Account closed(soft deletion)");
			} else {
				transaction.rollback();
				System.out.println("Account not closed");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
