package main.com.java.nativeSql;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;


public class NativeSQLApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			// EntityQuery -> NATIVE SQL QUERY WITHOUT MAPPING TO ENTITY CLASS
			session = HibernateUtil.getSession();
			NativeQuery<Student> query1 = session
					.createSQLQuery("select * from student where sage>=:age");

			// setting the value to namedparameter(max1 and max2)
			query1.setParameter("age", 20);

			//Mapping the Entity class to Table
			query1.addEntity(Student.class);

			// execute the query and get the Result
			List<Student> list = query1.getResultList();
			list.forEach(System.out::println);

			System.out.println("*********************************************");

			// EntityQuery -> NATIVE SQL QUERY WITHOUT MAPPING TO ENTITY CLASS	
			NativeQuery<Object[]> query2 = session
					.createSQLQuery("select * from student where sage>=:age");

			// setting the value to namedparameter(max1 and max2)
			query2.setParameter("age", 20);

			// execute the query and get the Result
			List<Object[]> objects = query2.getResultList();
			objects.forEach(object -> {
				for (Object data : object) {
					System.out.print(data + " ");
				}
				System.out.println();
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}

	}

}
