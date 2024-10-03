package main.com.java.advance.association.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import main.com.java.advance.association.model.one2one.LibraryFkBi;
import main.com.java.advance.association.model.one2one.StudentFkBi;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class FetchStudentO2OFkBi {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Session session = null;

		try {
			session = AssociationHibernateUtil.getSession();
			
			//Fetching Data from Parent(StudentFkBi)
			Query<StudentFkBi> query = session.createQuery("from StudentFkBi");
			List<StudentFkBi> students = query.getResultList();
			
			System.out.println("Student Fetching");
			students.forEach(s->{
				System.out.println(s);
				System.out.println(s.getLibraryFkBi());
				});
			System.out.println("______________________________________");

			//Fetching Data from Child(LibraryFkBi)
			Query<LibraryFkBi> query2 = session.createQuery("from LibraryFkBi");
			List<LibraryFkBi> libraryFkUnis = query2.getResultList();

			System.out.println("Library Fetching");
			libraryFkUnis.forEach(s-> {
				System.out.println(s);
				System.out.println(s.getStudentFkBi());
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
