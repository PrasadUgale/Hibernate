package main.com.java.basic;

import java.util.Scanner;

import org.hibernate.Session;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class CacheDemo {
	
	public static void main(String[] args) {
		
		Session session = null;
		Student std1 = null;
		Student std2 = null;
		Student std3 = null;
		Student std4 = null;
		Student std5 = null;
		
		try {
			//Get Session from SesisonFactory
			session = HibernateUtil.getSession();
				
			// Perform read operation on database with sid "1"
			std1 = session.get(Student.class, 1);
			if(std1 != null) {
				
				//  Perform read operation on db with same sid "1"
				std2 = session.get(Student.class, 1);
				std3 = session.get(Student.class, 1);
				
				/*
				 * Hashcode will be same for all objects.
				 * It shows, same object is cached and supplied without hitting db again and again
				 */
				System.out.println("std1 hashcode:: "+std1.hashCode());
				System.out.println("std2 hashcode:: "+std2.hashCode());
				System.out.println("std3 hashcode:: "+std3.hashCode());
				
				//You can clear all the cache by .clear() 
				session.clear();
				//If you want to clear epecific object use .evict()
				
				std4 = session.get(Student.class, 1);
				System.out.println("std4 hashcode (After session clear):: "+std4.hashCode());
			} else {
				System.out.println("No Record found with Id:: 1");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
