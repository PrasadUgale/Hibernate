package main.com.java.hql.joins.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import main.com.java.advance.association.model.one2many.Person;
import main.com.java.advance.association.util.AssociationHibernateUtil;
import main.com.java.cache.model.InsurancePolicy;

public class JoinsDemo {
	
	private static Session session = null;

	public static void main(String[] args) {
		
		try {
			session = AssociationHibernateUtil.getSession();

			//Inner Join
			//Fetches records that have matching entries in both tables (entities).
			String HQL_INNER_JOIN = "select per.pid, per.pname, per.paddress,"  //Parent Attributes
			 			+ " num.regNo, num.mobileNo, num.type, num.provider "     //Child Attributes
			 			+ "from PersonBi per "   //Parent
			  			+ "inner join"        //Join Type
			 			+ " per.numbers num";   //Child
			 
			
			// Left Join
			//Fetches all records from the left entity and matching records from the right entity. If no match is found, NULL is returned for the right entity
			String HQL_LEFT_JOIN = "select per.pid, per.pname, per.paddress,num.regNo, num.mobileNo, num.type, num.provider from PersonBi per left join per.numbers num";   
			 
			// Right Join
			//Fetches all records from the right entity and matching records from the left entity. If no match is found, NULL is returned for the left entity.
			String HQL_RIGHT_JOIN = "select per.pid, per.pname, per.paddress,num.regNo, num.mobileNo, num.type, num.provider from PhoneNumberBi num right join num.person per";   
				
			
			testJoin(HQL_RIGHT_JOIN);
			
			
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			AssociationHibernateUtil.closeSession(session);
			AssociationHibernateUtil.closeSessionFactory();
		}

	}
	
	public static void testJoin(String joinQuery) {
		
		Query<Object[]> query = session.createQuery(joinQuery);
		List<Object[]> result = query.getResultList();
		
		result.forEach(objects -> {
			for(Object obj : objects){
				System.out.print(obj + " : ");
			}
			System.out.println();
		});
	}
	
	
}
