package main.com.java.advance.collection.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.advance.collection.model.Employee;
import main.com.java.advance.collection.util.CollectionHibernateUtil;

public class CollectionMappingSelectApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {
			session = CollectionHibernateUtil.getSession();

			Query<Employee> query = session.createQuery("from Employee");
			List<Employee> employees = query.getResultList();
			employees.forEach(employee -> System.out.println(employee));

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CollectionHibernateUtil.closeSession(session);
			CollectionHibernateUtil.closeSessionFactory();
		}
	}
}
