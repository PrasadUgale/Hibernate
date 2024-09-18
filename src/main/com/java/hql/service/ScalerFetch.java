package main.com.java.hql.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class ScalerFetch {
	
	public static void main(String[] args) {
		Session session = null;
		//Reult will be unpredictable as we use scaler query, it might not be instance of object always
		Query query = null;
		
		try {
			session = HibernateUtil.getSession();
			
			//We can select specific column from records
			query = session.createQuery("SELECT sid,sname,sage FROM main.com.java.bean.Student");
			//We can collect the records in List of Object array and fetch them by position
			List<Object[]> list = query.getResultList();
			
			if(list.isEmpty()) {
				System.out.println("No Record Found");
			} else {
				System.out.println("Record Found");
				Object[] obj = list.get(0);
				System.out.println(obj[0] + " "+ obj[1]+" "+obj[2]);
			}
			
			//We can use SQL function in HQL But the result will be unknown so we can use List<?> here
			query = session.createQuery("SELECT count(*) FROM main.com.java.bean.Student");
			List<?> countList = query.getResultList();
			if(!countList.isEmpty()) {
				System.out.println("Total Records found are: "+(Long)countList.get(0));
			}
			
			
		}catch (Exception e) {
			System.out.println("Something went wrong!!");
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
}
