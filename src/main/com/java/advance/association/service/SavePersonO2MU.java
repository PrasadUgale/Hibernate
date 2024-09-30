package main.com.java.advance.association.service;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.advance.association.model.one2many.Person;
import main.com.java.advance.association.model.one2many.PhoneNumber;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class SavePersonO2MU {
	
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = AssociationHibernateUtil.getSession();
			transaction = session.beginTransaction();

			Person person = new Person();
			person.setPaddress("Delhi");
			person.setPname("Babu Kaliya");
			
			PhoneNumber pno1 = new PhoneNumber();
			pno1.setRegNo(1234);
			pno1.setMobileNo(9735126645L);
			pno1.setProvider("Aircel");
			pno1.setType("Personal");
			
			PhoneNumber pno2 = new PhoneNumber();
			pno2.setRegNo(1221);
			pno2.setMobileNo(8362136532L);
			pno2.setProvider("TSNL");
			pno2.setType("Business");
			
			//linking child object to parent object
			person.setPhoneNos(Set.of(pno1, pno2));
			
			//saving parent object
			session.save(person);

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
