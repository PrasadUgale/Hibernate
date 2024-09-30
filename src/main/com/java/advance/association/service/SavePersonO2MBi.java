package main.com.java.advance.association.service;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.advance.association.model.one2many.PersonBi;
import main.com.java.advance.association.model.one2many.PhoneNumberBi;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class SavePersonO2MBi {
	
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = AssociationHibernateUtil.getSession();
			transaction = session.beginTransaction();

			//Child Objects
			PhoneNumberBi phoneNumber = new PhoneNumberBi();
			phoneNumber.setMobileNo(4123213124L);
			phoneNumber.setProvider("VI");
			phoneNumber.setType("Work");
			
			PhoneNumberBi phoneNumber2 = new PhoneNumberBi();
			phoneNumber2.setMobileNo(1223213124L);
			phoneNumber2.setProvider("LI");
			phoneNumber2.setType("Home");
			
			//Parent Object
			PersonBi person = new PersonBi();
			person.setPaddress("mumbai");
			person.setPname("darshan");
			
			//Linking Parent to child
			person.setPhoneNos(Set.of(phoneNumber, phoneNumber2));
			 
			//Linking Child to Parent
			phoneNumber.setPerson(person);
			phoneNumber2.setPerson(person);
			
			//saving child objects
			session.save(phoneNumber);
			session.save(phoneNumber2);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using childs...");
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
