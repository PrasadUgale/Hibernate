package main.com.java.advance.association.service;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.advance.association.model.many2many.Doctor;
import main.com.java.advance.association.model.many2many.Patient;
import main.com.java.advance.association.model.one2many.PersonBi;
import main.com.java.advance.association.model.one2many.PhoneNumberBi;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class SaveDoctorM2M {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = AssociationHibernateUtil.getSession();
			transaction = session.beginTransaction();

			//Declaring Doctor Objects
			
			Doctor doc1 = new Doctor();
			doc1.setHospital("Kia");
			doc1.setName("Prakash");
			doc1.setSpecialization("Eye");
			
			Doctor doc2 = new Doctor();
			doc2.setHospital("Jaya");
			doc2.setName("Vikash");
			doc2.setSpecialization("Skin");
			
			Patient pat1 = new Patient();
			pat1.setAddress("Malkapur");
			pat1.setName("Brijbhushan");
			pat1.setProblem("Eye");
			
			Patient pat2 = new Patient();
			pat2.setAddress("Baliya");
			pat2.setName("Prahlad");
			pat2.setProblem("Skin");
			
			Patient pat3 = new Patient();
			pat3.setAddress("Nellore");
			pat3.setName("Jagan");
			pat3.setProblem("Eye & Skin");
			
			Patient pat4 = new Patient();
			pat4.setAddress("Khandesh");
			pat4.setName("Naman");
			pat4.setProblem("Eye");

			//Linking child to parent
			doc1.setPatients(Set.of(pat1, pat3, pat4));
			doc2.setPatients(Set.of(pat2, pat3));
			
			//Linking parent to child
			pat1.setDoctors(Set.of(doc1));
			pat2.setDoctors(Set.of(doc2));
			pat3.setDoctors(Set.of(doc1, doc2));
			pat4.setDoctors(Set.of(doc1));
			
			//Saving data using parent
			session.save(doc1);
			session.save(doc2);
			
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
