package main.com.java.version.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

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
		Scanner sc = null;
		boolean flag = false;
		
		try {
			session = VersionDemoUtil.getSession();
			transaction = session.beginTransaction();
			sc = new Scanner(System.in);
			
			VersionDemo data = new VersionDemo();
			
			data.setId(1);
			System.out.println("Please Enter Values to insert");
			System.out.println("Enter Address:: ");
			data.setAddress(sc.next());
			System.out.println("Enter Name:: ");
			data.setName(sc.next());
			System.out.println("Enter Pin code:: ");
			data.setPincode(sc.next());
			
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
