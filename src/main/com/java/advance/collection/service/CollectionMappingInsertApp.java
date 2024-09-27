package main.com.java.advance.collection.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.advance.collection.model.Employee;
import main.com.java.advance.collection.util.CollectionHibernateUtil;

public class CollectionMappingInsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = CollectionHibernateUtil.getSession();
			transaction = session.beginTransaction();

			Employee employee = new Employee("sachin", "MI", 
					List.of("dravid", "saurav", "sehwagh"),
					Set.of(999888777L, 666555444L, 777888555L),
					Map.of("SBI",55544466L, "HDFC",6575657L,"ICICI",8877799L));
			session.save(employee);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Record saved to database...");
			} else {
				transaction.rollback();
				System.out.println("Record not saved to database...");
			}
		}

	}
}
