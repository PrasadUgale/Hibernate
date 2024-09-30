package main.com.java.advance.association.service;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import main.com.java.advance.association.model.one2many.Person;
import main.com.java.advance.association.model.one2many.PersonBi;
import main.com.java.advance.association.model.one2many.PhoneNumberBi;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class FetchPersonO2MBi {
	
	public static void main(String[] args) {

		Session session = null;

		try {
			session = AssociationHibernateUtil.getSession();
			
			Query<PersonBi> query = session.createQuery("from PersonBi");
			List<PersonBi> parents = query.getResultList();
			
			parents.forEach(parent -> {
				System.out.println(parent);
			});
			
			Query<PhoneNumberBi> query2 = session.createQuery("From PhoneNumberBi");
			List<PhoneNumberBi> child = query2.getResultList();
			
			child.forEach(children -> { 
				System.out.println(children);
				System.out.println(children.getPerson());
			});
			
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
