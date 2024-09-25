package main.com.java.cache.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.com.java.cache.model.InsurancePolicy;
import main.com.java.cache.util.HibernateUtil;

public class RetrieveRecordApp {

	public static void main(String[] args) {

		Session session = null;
		InsurancePolicy policy = null;
		try {
			session = HibernateUtil.getSession();

			policy = session.get(InsurancePolicy.class, 1L);// gets from DB put in L2 and L1
			System.out.println(policy);

			System.out.println("-----------------");

			policy = session.get(InsurancePolicy.class, 1L);// get from L1
			System.out.println(policy);

			session.clear();// clearing L1 cache memory

			policy = session.get(InsurancePolicy.class, 1L);// get from L2 (if configured) and keep it in L1 cache 
			System.out.println(policy);

			session.clear();// clearing L1 cache memory
			try {
				Thread.sleep(20000);// 20 sec :: removed object from L2 cache
			} catch (Exception e) {
			}

			System.out.println("-----------------------");
			policy = session.get(InsurancePolicy.class, 1L);// get from db, keep in L2 and L1 cache
			System.out.println(policy);
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
