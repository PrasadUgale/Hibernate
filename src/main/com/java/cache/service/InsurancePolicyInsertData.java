package main.com.java.cache.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.com.java.bean.Student;
import main.com.java.cache.model.InsurancePolicy;
import main.com.java.cache.util.HibernateUtil;

public class InsurancePolicyInsertData {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		InsurancePolicy insurancePolicy = new InsurancePolicy();
		insurancePolicy.setPolicyId(1L);
		insurancePolicy.setPolicyName("Temp");
		insurancePolicy.setPolicyType("New");
		insurancePolicy.setTenure(5);
		
		session.save(insurancePolicy);
		
		transaction.commit();
		
		session.close();
		
	}
}	
