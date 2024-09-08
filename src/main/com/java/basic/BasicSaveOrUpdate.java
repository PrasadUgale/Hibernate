package main.com.java.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class BasicSaveOrUpdate {
	
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Student std = null;
		Integer id = null;
		Boolean flag = false;
		BufferedReader br = null;
		String name=null, address=null;
		Integer age = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			session = HibernateUtil.getSession();
			if(session != null && br != null) {
				System.out.println("Enter student id to edit::");
				id = Integer.parseInt(br.readLine());
				
				//Fetching data related to gien id
				std = session.get(Student.class, id);	
			}
			if(std != null) {
				transaction = session.beginTransaction();
				if(transaction != null) {
						System.out.println("Editing record of student with id:: "+ id);
						
						System.out.println("Student Name:: Previous value: "+std.getSname()+"  || Enter new value:");
						name = br.readLine();
						if(name != null && !name.equals("") && !name.equals(std.getSname())) {
							std.setSname(name);
						}
						
						System.out.println("Student Age:: Previous value: "+std.getSage()+"  || Enter new value:");
						age = Integer.parseInt(br.readLine());
						if(age != null && !age.equals(0) && !age.equals(std.getSage())) {
							std.setSage(age);
						}
						
						System.out.println("Student Address:: Previous value: "+std.getSaddress()+"  || Enter new value:");
						address = br.readLine();
						if(address != null && !address.equals("") && !address.equals(std.getSaddress())) {
							std.setSaddress(address);;
						}
						
						session.saveOrUpdate(std);
						
						flag = true;
				}
			} else {
				System.out.println("No Record found with given Id");
			}
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record Updated Succesfully");
			} else {
				System.out.println("Something went wrong!");
			}
		}
		
		
	}
	
}

