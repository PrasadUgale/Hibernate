package main.com.java.advance.componend.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.advance.componend.model.StudentInfo;
import main.com.java.advance.componend.util.ComponentMappingHibernateUtil;

public class ComponentMappingSelectApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {
			session = ComponentMappingHibernateUtil.getSession();
			Query<StudentInfo> query = session.createQuery("from StudentInfo where address.cityName=:city");
			query.setParameter("city", "Bengaluru");
			List<StudentInfo> students = query.getResultList();
			students.forEach(System.out::println);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ComponentMappingHibernateUtil.closeSession(session);
			ComponentMappingHibernateUtil.closeSessionFactory();
		}
	}
}
