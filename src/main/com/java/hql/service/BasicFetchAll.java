package main.com.java.hql.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;


public class BasicFetchAll {
	
	public static void main(String[] args) {
		Session session = null;
		Query<Student> query = null;
		try {
			session = HibernateUtil.getSession();
			
			/*
			 * Basic HQL Query to fetch all records for given entity from db
			 */
			query = session.createQuery("FROM main.com.java.bean.Student");
			
			//Pagination
			
			//setFirstResult specify starting position from records. O means first record
			query.setFirstResult(0);  
			
			//setMaxResults specifies no of results to fetch
			query.setMaxResults(5);
			
			List<Student> std = query.getResultList();
			
			if(std.isEmpty()) {
				System.out.println("No Record Found!\n Please add some records for student entity");
			}else {
				System.out.println("Printing Result from Retrived List");
				for(Student std1 : std) {
					System.out.println(std1);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Something Went wrong!!");
		} finally {
			if(session != null) {
				session.close();
			}
			
		}
		
	}
}
