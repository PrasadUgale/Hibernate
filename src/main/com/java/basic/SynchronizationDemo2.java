package main.com.java.basic;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class SynchronizationDemo2 {
	
	public static void main(String[] args) {

		Session session = null;
		Student student = null;
		boolean flag = false;
		Transaction transaction = null;
		//DB should contain a record with the below id
		int id = 1;

		try {
			session = HibernateUtil.getSession();

			// Getting the record in the form of student object(session)
			student = session.get(Student.class, id);
			System.out.println("Before modification :: " + student);

			//application in pausing state
			System.in.read();
			
			if (student != null) {
				transaction = session.beginTransaction();

				// modifying the data
				student.setSname("dhoni");

				flag = true;

			} else {
				System.out.println("Record not found for the id :: " + id);
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				//Transaction is commited without saving implicitly.
				transaction.commit();
				
				//We can see the changes reflecting in object as well as in DB
				System.out.println("After modification :: " + student);
			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}

	}

}
