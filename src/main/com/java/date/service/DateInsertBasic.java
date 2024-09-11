package main.com.java.date.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.date.model.DateData;
import main.com.java.date.util.DateDataUtil;

public class DateInsertBasic {
	
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = DateDataUtil.getSession();
			transaction = session.beginTransaction();
			
			DateData data = new DateData();
			data.setId(1);
			data.setName("Demo");
			
			//Setting Data fields
			data.setDob(LocalDate.now());
			data.setDoj(LocalTime.now());
			data.setDom(LocalDateTime.now());
			
			//Saving the changes
			session.save(data);
			
			flag = true;
			
		} catch (HibernateException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if(transaction !=null) {
				if(flag == true) {
					transaction.commit();
					System.out.println("Data Insert Succesfully");
				} else {
					System.out.println("Data Cannot be inserted");
				}
				
				DateDataUtil.closeSessionFactory();
				
				if(session !=null) {
					session.close();
				}
			}
		}
	}
	
}
