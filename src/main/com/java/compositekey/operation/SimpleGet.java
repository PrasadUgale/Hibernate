package main.com.java.compositekey.operation;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.com.java.compositekey.model.ProgramProjId;
import main.com.java.compositekey.model.ProgrammerProjectInfo;
import main.com.java.compositekey.utility.CompositeHibernateUtil;

public class SimpleGet {
	
	public static void main(String[] args) {

		Session session = null;

		try {
			session = CompositeHibernateUtil.getSession();

			ProgramProjId id = new ProgramProjId();
			id.setPid(101);
			id.setProjId(501);

			ProgrammerProjectInfo info = session.get(ProgrammerProjectInfo.class, id);
			if (info != null) {
				System.out.println(info);
			} else {
				System.out.println("Record not found for the id :: " + id);
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			CompositeHibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}

}
