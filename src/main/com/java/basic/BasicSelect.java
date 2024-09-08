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
				/*
				 * we can use .load for select operations.
				 * The difference is .get will check in cache and if not there it will directly run select query and fetch the data
				 * while for load it will provide a proxy object which will be null, until some data if requested from that proxy object.
				 * eg. it will return an proxy object when called .load()
				 * 		when we can .getSname() on that proxy object, then it will execute Select query and return a real object
				 */
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
