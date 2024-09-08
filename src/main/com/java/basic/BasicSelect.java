package main.com.java.basic;

import java.util.Scanner;

import org.hibernate.Session;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class BasicSelect {
	
	public static void main(String[] args) {
		Student std = null;
		Integer stdId = 0;
		Scanner scanner = null;
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			scanner = new Scanner(System.in);
			if(session != null && scanner != null) {
				System.out.println("Enter Student id to get the data: ");
				stdId = scanner.nextInt();
				
				// Perform read operation on database
				std = session.get(Student.class, stdId);
			}
			
			if(std != null) {
				System.out.println("Record Found! ");
				System.out.println("Student Name: "+ std.getSname());
				System.out.println("Student Address: "+std.getSaddress());
				System.out.println("Student Age: "+std.getSage());
			} else {
				System.out.println("No Record Found for given id! ");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
