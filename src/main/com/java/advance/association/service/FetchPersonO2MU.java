package main.com.java.advance.association.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.com.java.advance.association.model.one2many.Person;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class FetchPersonO2MU {
	
	public static void main(String[] args) {

		Session session = null;

		try {
			session = AssociationHibernateUtil.getSession();
			
//			Query<Person> query = session.createQuery("from Person");
//			
//			List<Person> students = query.getResultList();
//			students.forEach(System.out::println);
			
			Person  person = session.get(Person.class, 1);
			System.out.println(person);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AssociationHibernateUtil.closeSession(session);
			AssociationHibernateUtil.closeSessionFactory();
		}
	}
}
