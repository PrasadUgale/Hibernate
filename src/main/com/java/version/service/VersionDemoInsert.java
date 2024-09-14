package main.com.java.version.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.date.model.DateData;
import main.com.java.version.model.VersionDemo;
import main.com.java.version.util.VersionDemoUtil;

public class VersionDemoInsert {
	
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = VersionDemoUtil.getSession();
			transaction = session.beginTransaction();
			
			VersionDemo data = new VersionDemo();
			
			data.setAddress("pune");
			data.setId(1);
			data.setName("Madara");
			data.setPincode("510067");
			
			//Saving the changes
			session.save(data);
			
			flag = true;
			
		} catch (HibernateException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if(transaction !=null) {
				if(flag == true) {
					transaction.commit();
					System.out.println("Data Insert Succesfully");
				} else {
					System.out.println("Data Cannot be inserted");
				}
				
				VersionDemoUtil.closeSessionFactory();
				
				if(session !=null) {
					session.close();
				}
			}
		}
	}
	
}
