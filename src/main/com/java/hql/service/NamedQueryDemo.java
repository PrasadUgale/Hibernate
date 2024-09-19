package main.com.java.hql.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;


public class NamedQueryDemo {
	public static void main(String[] args) {
		Session session = null;
		Query<Student> query = null;
		Scanner sc = null;
		List<Student> list = null;
		
		try {
			session = HibernateUtil.getSession();
			sc = new Scanner(System.in);
			
			//Use named query defined in entity class
			query = session.getNamedQuery("SelectById");
			
			System.out.println("Enter Id to fetch: ");
			Integer id = sc.nextInt();
			
			query.setParameter("id", id);
			
			list = query.getResultList();
			
			if(list.isEmpty()) {
				System.out.println("No Record Found");
			} else {
				System.out.println("Record Found:");
				for(Student std: list) {
					System.out.println(std.toString());
				}
			}
			
		}catch (Exception e) {
			System.out.println("Someting went wrong!!");
		} finally {
			if(sc != null) {
				sc.close();
			} if( session!= null) {
				session.close();
			}
		}
		
	}
}
