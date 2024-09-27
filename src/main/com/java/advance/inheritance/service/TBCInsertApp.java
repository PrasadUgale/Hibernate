package main.com.java.advance.inheritance.service;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.advance.inheritance.model.CardPayment;
import main.com.java.advance.inheritance.model.ChequePayment;
import main.com.java.advance.inheritance.util.InheritanceHibernateUtil;

public class TBCInsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = InheritanceHibernateUtil.getSession();
			transaction = session.beginTransaction();

			CardPayment cardPayment = new CardPayment();
			cardPayment.setCardNo(1234L);
			cardPayment.setCardType("debit");
			cardPayment.setPaymentGateWay("visa");
			cardPayment.setAmount(8000.0f);

			session.save(cardPayment);

			ChequePayment chequePayment = new ChequePayment();
			chequePayment.setAmount(9000.0f);
			chequePayment.setChequeNo(56456L);
			chequePayment.setChequeType("all");
			chequePayment.setExpriyDate(LocalDate.of(2025, 10, 25));

			session.save(chequePayment);
			/*
			 * i. Single Table Strategy:
			 * One table will be created with all fields from all subclasses as columns.
			 * Given subclass field will be set and another subclass fields will be null.
			 * So there is waste of memory.
			 * Another column will be created, i.e. specified in @DiscriminatorColumn in Parent class
			 * It will help in discriminating which object is available in the row.
			 * the value of the column will be the one specified for subclass in @DiscriminatorValue
			 * 
			 * ii. Table per Subclass Strategy:
			 * Seperate table for each parent and child class will be created.
			 * These classes are linked with foreign key which is primary key of Parent class.
			 * 
			 * iii. Table per concrete class
			 * As parent is abstract table will be created for implementation classes(concreate class)
			 * The parent info will also be available in the table created for child
			 * 
			 * 
			 */
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Record saved to database...");
			} else {
				transaction.rollback();
				System.out.println("Record not saved to database...");
			}
		}

	}
}
