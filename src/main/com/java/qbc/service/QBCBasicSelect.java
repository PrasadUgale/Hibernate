package main.com.java.qbc.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class QBCBasicSelect {
	public static void main(String[] args) {
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			//Create a builder Object
			CriteriaBuilder builer = session.getCriteriaBuilder();
			
			//Create CriteriaQuery Object
			CriteriaQuery<Student> cQuery = builer. createQuery(Student.class);
			
			//Create Root Object specifying entity class
			//(Table name from which data should be selected)
			Root<Student> root = cQuery.from(Student.class);
			
			//add root object to CriteriaQuery Object
			cQuery.select(root);
			
			//Prepare query Object having cQuery
			Query<Student> query = session.createQuery(cQuery);
			
			//Execute the query
			List<Student> result =  query.getResultList();
			result.forEach(System.out::println);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
