package main.com.java.advance.association.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import main.com.java.advance.association.model.many2many.Doctor;
import main.com.java.advance.association.model.one2one.StudentPk;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class FetchO2OPk {
	
	public static void main(String[] args) {

		Session session = null;

		try {
			session = AssociationHibernateUtil.getSession();
			
			//Fetching Data from Parent(StudentPk)
			Query<StudentPk> query = session.createQuery("from StudentPk");
			List<StudentPk> students = query.getResultList();
			
			students.forEach(s -> {
				System.out.println(s);
				});
			System.out.println("______________________________________");
			
			
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
