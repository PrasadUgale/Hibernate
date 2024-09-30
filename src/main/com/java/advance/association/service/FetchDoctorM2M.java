package main.com.java.advance.association.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import main.com.java.advance.association.model.many2many.Doctor;
import main.com.java.advance.association.model.one2many.PersonBi;
import main.com.java.advance.association.model.one2many.PhoneNumberBi;
import main.com.java.advance.association.util.AssociationHibernateUtil;

public class FetchDoctorM2M {
	
	public static void main(String[] args) {

		Session session = null;

		try {
			session = AssociationHibernateUtil.getSession();
			
			Query<Doctor> query = session.createQuery("from Doctor");
			List<Doctor> doctors = query.getResultList();
			
			doctors.forEach(doctor -> {
				System.out.println(doctor);
				doctor.getPatients().forEach(patient -> {
					System.out.println(patient);
				});
				System.out.println("______________________________________");
			});
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AssociationHibernateUtil.closeSession(session);
			AssociationHibernateUtil.closeSessionFactory();
		}
	}
}
