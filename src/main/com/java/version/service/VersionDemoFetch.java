package main.com.java.version.service;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.com.java.date.util.DateDataUtil;
import main.com.java.version.model.VersionDemo;
import main.com.java.version.util.VersionDemoUtil;

public class VersionDemoFetch {
	
	public static void main(String[] args) {
		Session session = null;
		//DB should have a record with given id::
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id for record to fetch");
		Integer id = sc.nextInt();

		try {
			session = VersionDemoUtil.getSession();

			VersionDemo data = null;
			
			data = session.get(VersionDemo.class, id);
			if (data != null) {
				System.out.println(data);
			} else {
				System.out.println("Record not found for the id :: " + id);
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DateDataUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}
}
