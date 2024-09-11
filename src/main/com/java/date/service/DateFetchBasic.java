package main.com.java.date.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.com.java.date.model.DateData;
import main.com.java.date.util.DateDataUtil;

public class DateFetchBasic {
		
	public static void main(String[] args) {
		
		Session session = null;
		//DB should have a record with given id::
		Integer id = 1;

		try {
			session = DateDataUtil.getSession();

			DateData data = null;

			data = session.get(DateData.class, id);
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
