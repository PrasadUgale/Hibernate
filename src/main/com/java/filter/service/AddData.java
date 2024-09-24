package main.com.java.filter.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.filter.model.BankAccount;
import main.com.java.filter.util.HibernateUtil;

public class AddData {
	
	public static void main(String[] args) {
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			if(session != null) {
				transaction = session.beginTransaction();
			}
			if(transaction != null) {
				BankAccount ba1 = new BankAccount();
				ba1.setAccNo(101);
				ba1.setBalance(10000F);
				ba1.setHolderName("Vijay");
				ba1.setStatus("blocked");
				session.save(ba1);
				
				BankAccount ba2 = new BankAccount();
				ba2.setAccNo(102);
				ba2.setBalance(1200F);
				ba2.setHolderName("Keshav");
				ba2.setStatus("active");
				session.save(ba2);
				
				BankAccount ba3 = new BankAccount();
				ba3.setAccNo(103);
				ba3.setBalance(1012100F);
				ba3.setHolderName("Ganesh");
				ba3.setStatus("closed");
				session.save(ba3);
				
				BankAccount ba4 = new BankAccount();
				ba4.setAccNo(104);
				ba4.setBalance(1001200F);
				ba4.setHolderName("Dhiraj");
				ba4.setStatus("active");
				session.save(ba4);
				
				BankAccount ba5 = new BankAccount();
				ba5.setAccNo(105);
				ba5.setBalance(100F);
				ba5.setHolderName("Mangesh");
				ba5.setStatus("active");
				session.save(ba5);
				
				BankAccount ba6 = new BankAccount();
				ba6.setAccNo(106);
				ba6.setBalance(10F);
				ba6.setHolderName("manoj");
				ba6.setStatus("closed");
				session.save(ba6);
				
				
				flag = true;
				
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(flag) {
					transaction.commit();
					System.out.println("Data Saved Sucessfully");
				} else {
					transaction.rollback();
					System.out.println("Something went wrong. Data cannot be inserted");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(session != null) {
				session.close();
			}
			
		}
	}
}
