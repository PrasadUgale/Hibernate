package main.com.java.advance.association.service;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.advance.association.model.one2one.LibraryPk;
import main.com.java.advance.association.model.one2one.StudentPk;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class SaveStudentO2OPk {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = AssociationHibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			StudentPk studentPk = new StudentPk();
			studentPk.setAddress("Janori");
			studentPk.setName("Dhiraj");
			
			LibraryPk libraryPk = new LibraryPk();
			libraryPk.setType("genral");
			libraryPk.setDate(LocalDate.now());
			
			//Linking Student to Parent
			studentPk.setLibraryPk(libraryPk);
			
			//Linking Parent to Student
			libraryPk.setStudentPk(studentPk);
			
			//Saving using parent
			session.save(studentPk);
			
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using Parent...");
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
