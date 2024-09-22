package main.com.java.nativeSql;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import main.com.java.bean.Student;
import main.com.java.util.HibernateUtil;

public class NamedNativeSQLQueryApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			NativeQuery<Student> nquery = session.getNamedNativeQuery("SelectAll");
			
			nquery.addEntity(Student.class);

			List<Student> list = nquery.getResultList();
			list.forEach(System.out::println);

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
