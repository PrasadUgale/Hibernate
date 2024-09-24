package main.com.java.qbc.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class QBCDelete {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag= false;
		long count = 0;

		try {
			//delete from project where sage between(50 , 70)
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaDelete<Student> criteriaDelete = builder.createCriteriaDelete(Student.class);
			Root<Student> root = criteriaDelete.from(Student.class);
			
			//delete operation
			criteriaDelete.where(builder.between(root.get("sage"), 50, 70));
			Query<Integer> query = session.createQuery(criteriaDelete);
			count = query.executeUpdate();
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records deleted is :: "+count);
			} else {
				transaction.rollback();
				System.out.println("No records found to delete");
			}
			
			HibernateUtil.closeSessionFactory();
		}

	}

}	
