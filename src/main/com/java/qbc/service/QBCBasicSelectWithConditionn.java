package main.com.java.qbc.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class QBCBasicSelectWithConditionn {
	public static void main(String[] args) {
		Session session = null;

		try {

			session = HibernateUtil.getSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Student> cquery = builder.createQuery(Student.class);

			Root<Student> root = cquery.from(Student.class);
			
			
			
			/*
			 *  //This is the expanded version of query
			 *  
			 * 	ParameterExpression<Integer> param1 = builder.parameter(Integer.class);
			 *  ParameterExpression<Integer> param2 = builder.parameter(Integer.class);
			 *  
			 *  Predicate p1 = builder.ge(root.get("sage"), param1);
			 *  Predicate p2 = builder.le(root.get("sage"), param2);
			 *  
			 *  Predicate finalCond = builder.and(p1, p2);
			 *  
			 *  cquery.where(finalCond);
			 *  
			 *  Order order = builder.desc(root.get("sname"));
			 *  cquery.orderBy(order);
			 *  
			 */
			
			cquery.select(root)
					.where(builder.and(builder.ge(root.get("sid"), 20), builder.le(root.get("sid"), 40)))
					.orderBy(builder.desc(root.get("sname")));
			
			Query<Student> query = session.createQuery(cquery);
			List<Student> list = query.getResultList();
			list.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
			HibernateUtil.closeSessionFactory();
		}

		/*
		 * try {
		 * 
		 * 	session = HibernateUtil.getSession();
		 * 
		 * 	CriteriaBuilder builder = session.getCriteriaBuilder();
		 * 
		 * 	CriteriaQuery<Student> cquery = builder.createQuery(Student.class);
		 * 
		 * 	Root<Student> root = cquery.from(Student.class);
		 * 
		 * 
		 *  // Predicate in = root.get("saddress").in("shegaon", "pune", "nagpur")
		 *  //cquery.where(in)
		 *  
		 * 	cquery.select(root) 
		 * 		.where(root.get("saddress").in("shegaon", "pune", "nagpur")) 
		 * 		.orderBy(builder.asc(root.get("sname")));
		 * 
		 * 
		 * 	Query<Student> query = session.createQuery(cquery); 
		 * 	List<Project> list = query.getResultList(); 
		 * 	list.forEach(System.out::println);
		 * 
		 * } catch (HibernateException he) { 
		 * 		he.printStackTrace(); 
		 * } finally {
		 *		HibernateUtil.closeSession(session); 
		 * 		HibernateUtil.closeSessionFactory(); 
		 * }
		 */

		/*
		 * try {
		 * 
		 * 	session = HibernateUtil.getSession();
		 * 
		 * 	CriteriaBuilder builder = session.getCriteriaBuilder();
		 * 
		 * 	CriteriaQuery<Project> cquery = builder.createQuery(Project.class);
		 * 
		 * 	Root<Project> root = cquery.from(Project.class);
		 * 
		 * 	cquery.select(root)
		 * 		.where(builder.and(builder.between(root.get("teamSize"), 10, 20), builder.like(root.get("projName"), "s%")));
		 * 
		 * 	Query<Student> query = session.createQuery(cquery); 
		 * 	List<Project> list = query.getResultList(); 
		 * 	list.forEach(System.out::println);
		 * 
		 * } catch (HibernateException he) { 
		 * 		he.printStackTrace(); 
		 * } finally {
		 * 		HibernateUtil.closeSession(session); 
		 * 		HibernateUtil.closeSessionFactory(); 
		 * }
		 * 
		 */
	}

}
