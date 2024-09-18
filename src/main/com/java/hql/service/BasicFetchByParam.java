package main.com.java.hql.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class BasicFetchByParam {
	
	public static void main(String[] args) {
		Session session = null;
		Query<Student> query = null;
		Scanner sc = null;
		List<Student> list = null;
		
		try {
			session = HibernateUtil.getSession();
			sc = new Scanner(System.in);
			
			/*
			 * We can use clauses in HQL like WEHRE, LIKE etc
			 * use :<paramter name> to create a parameter
			 * Set it either by position or by name in .setParameter
			 */
			query = session.createQuery("From main.com.java.bean.Student WHERE sid=:id");
			
			System.out.println("Enter Id to fetch: ");
			Integer id = sc.nextInt();
			
			//set named parameters value
			query.setParameter("id", id);
			// Below methods are depricated:
			// query.setInteger(1, id)
			// query.setInteger("id", id);
			
//			//Query Using mulyiple parameters
//			
//			query = session.createQuery("From main.com.java.bean.Student WHERE sname IN (:name1, :name2)");
//			
//			System.out.println("Enter name 1");
//			query.setParameter("name1", sc.nextLine());
//			System.out.println("Enter name 2");
//			query.setParameter("name2", sc.nextLine());
			
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
