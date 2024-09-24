package main.com.java.qbc.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class QBCUpdate {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag= false;
		long count = 0;

		try {
			//update student set address = "America" ,age ='23' where name="sachin";
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaUpdate<Student> criteriaUpdate = builder.createCriteriaUpdate(Student.class);
			Root<Student> root = criteriaUpdate.from(Student.class);
			
			//update operation
			criteriaUpdate.set(root.get("saddress"),"America")
					      .set(root.get("sage"), 23)
					      .where(builder.greaterThan(root.get("sname"), "sachin"));
			
			
			Query<Integer> query = session.createQuery(criteriaUpdate);
			count = query.executeUpdate();
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records updated is :: "+count);
			} else {
				transaction.rollback();
				System.out.println("No records found to update");
			}
			
			HibernateUtil.closeSessionFactory();
		}

	}

}
