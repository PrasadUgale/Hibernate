package main.com.java.compositekey.operation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.compositekey.model.ProgramProjId;
import main.com.java.compositekey.model.ProgrammerProjectInfo;
import main.com.java.compositekey.utility.CompositeHibernateUtil;

public class SimpleInsert {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		Boolean flag = false;

		try {
			session = CompositeHibernateUtil.getSession();
			transaction = session.beginTransaction();

			ProgrammerProjectInfo info = new ProgrammerProjectInfo();
			info.setPname("kohli");
			info.setProjName("amazon");

			ProgramProjId id = new ProgramProjId();
			id.setPid(101);
			id.setProjId(501);
			info.setId(id);

			session.save(info);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record inserted/updated succesfully...");
				} else {
					transaction.rollback();
					System.out.println("Record failed for updation...");
				}

				CompositeHibernateUtil.closeSessionFactory();
				if (session != null) {
					session.close();
				}
			}
		}
	}
}
