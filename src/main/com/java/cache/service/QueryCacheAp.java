package main.com.java.cache.service;

import java.util.List;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.com.java.cache.model.InsurancePolicy;
import main.com.java.cache.util.HibernateUtil;

public class QueryCacheAp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		SessionFactory factory = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			session = HibernateUtil.getSession();
			List<InsurancePolicy> policies = null;

			Query<InsurancePolicy> query = session.createQuery("from InsurancePolicy");

			//enable the cache and mark the region as "region1"
			query.setCacheable(true);
			query.setCacheRegion("region1");

			policies = query.getResultList();// get from DB keep in querycache of L2
			policies.forEach(System.out::println);

			System.out.println("----------");
			policies = query.getResultList();// get from query cache of L2
			policies.forEach(System.out::println);

			Cache cache = factory.getCache();
			cache.evictRegion("region1");//remove the querycache entry of L2

			System.out.println("----------");
			policies = query.getResultList();// get from DB keep in querycache of L2
			policies.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
