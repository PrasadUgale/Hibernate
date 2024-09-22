package main.com.java.nativeSql;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import main.com.java.util.HibernateUtil;

public class NativeSQLScalarQueryApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			// ScalarQuery -> NATIVE SQL QUERY WITHOUT MAPPING TO ENTITY CLASS
			session = HibernateUtil.getSession();
			NativeQuery<Object[]> query1 = session
					.createSQLQuery("select sid,sname,sage, saddress from student where sage>=:age");

			// setting the value to namedparameter(max1 and max2)
			query1.setParameter("age", 20);

			List<Object[]> list = query1.getResultList();
			list.forEach(object -> {
				for (Object row : object) {
					System.out.print(row+" ");
				}
				System.out.println();
			});
			
			System.out.println("**********************************************");

			NativeQuery<String> query2 = session
					.createSQLQuery("select sname from student where sage>=:age");

			// setting the value to namedparameter(max1 and max2)
			query2.setParameter("age", 20);

			List<String> result = query2.getResultList();
			result.forEach(System.out::println);
	
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
