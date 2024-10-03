package main.com.java.advance.association.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import main.com.java.advance.association.model.one2one.LibraryFkUni;
import main.com.java.advance.association.model.one2one.StudentFkUni;
import main.com.java.advance.association.model.one2one.StudentPk;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class FetchStudentO2OFkUni {
	public static void main(String[] args) {

		Session session = null;

		try {
			session = AssociationHibernateUtil.getSession();
			
			//Fetching Data from Parent(StudentFkUni)
			Query<StudentFkUni> query = session.createQuery("from StudentFkUni");
			List<StudentFkUni> students = query.getResultList();
			
			System.out.println("Student Fetching");
			students.forEach(s->System.out.println(s));
			System.out.println("______________________________________");

			//Fetching Data from Child(LibraryFkUni)
			Query<LibraryFkUni> query2 = session.createQuery("from LibraryFkUni");
			List<LibraryFkUni> libraryFkUnis = query2.getResultList();

			System.out.println("Library Fetching");
			libraryFkUnis.forEach(s->System.out.println(s));
			
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
