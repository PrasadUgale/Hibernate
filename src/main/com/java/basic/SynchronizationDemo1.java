package main.com.java.basic;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class SynchronizationDemo1 {
	
	public static void main(String[] args) {

		Session session = null;
		Student student = null;

		try {
			session = HibernateUtil.getSession();

			student = session.get(Student.class, 1);
			System.out.println("Before modification.....");
			System.out.println("Record with the id value :: " + student);
			
			System.in.read();
			//application is in pausing state
			//Create some changed in db for record with id:: 1 and continue flow to see changes
			
			//synchronization established b/w record to java object
			session.refresh(student);
			
			System.out.println("After modification....");
			System.out.println("Record with the id value :: "+student);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}

	}

}
