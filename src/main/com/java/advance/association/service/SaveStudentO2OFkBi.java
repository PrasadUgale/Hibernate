package main.com.java.advance.association.service;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.advance.association.model.one2one.LibraryFkBi;
import main.com.java.advance.association.model.one2one.LibraryFkUni;
import main.com.java.advance.association.model.one2one.LibraryPk;
import main.com.java.advance.association.model.one2one.StudentFkBi;
import main.com.java.advance.association.model.one2one.StudentFkUni;
import main.com.java.advance.association.model.one2one.StudentPk;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class SaveStudentO2OFkBi {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = AssociationHibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			StudentFkBi student = new StudentFkBi();
			student.setAddress("Janori");
			student.setName("Dhiraj");
			
			LibraryFkBi library = new LibraryFkBi();
			library.setType("genral");
			library.setDate(LocalDate.now());
			
			//Linking Library to Student
			student.setLibraryFkBi(library);
			
			//Linking Student to Library
			library.setStudentFkBi(student);
			
			//Saving using Student
			session.save(student);
			
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database...");
				} else {
					transaction.rollback();
					System.out.println("Record not saved to database...");
				}
			} else {
				System.out.println("Something went wrong");
			}
		}
	}
}
