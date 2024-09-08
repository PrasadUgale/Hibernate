package main.com.java.basic;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class InsertUsingUtil {
	
	public static void main(String[] args) {
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = 0;
		
		try {
			session = HibernateUtil.getSession();
			if(session != null) {
				transaction = session.beginTransaction();
			}
			if(transaction != null) {
				Student std = new Student();
				std.setSaddress("Malkapur");
				std.setSage(12);
				std.setSid(102);
				std.setSname("Pakya");
				
				id = (Integer) session.save(std);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(flag) {
					transaction.commit();
					System.out.println("Data Saved Sucessfully in table with id: "+id);
				} else {
					transaction.rollback();
					System.out.println("Something went wrong. Data cannot be inserted");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(session != null) {
				session.close();
			}
			
		}
	}
	
}
