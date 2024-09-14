package main.com.java.version.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.version.model.VersionDemo;
import main.com.java.version.util.VersionDemoUtil;

public class VersionDemoUpdate {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		VersionDemo versionDemo = null;
		Integer id = null;
		Boolean flag = false;
		BufferedReader br = null;
		String name=null, address=null, pincode =null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			session = VersionDemoUtil.getSession();
			if(session != null && br != null) {
				System.out.println("Enter id to edit::");
				id = Integer.parseInt(br.readLine());
				
				//Fetching data related to gien id
				versionDemo = session.get(VersionDemo.class, id);	
			}
			if(versionDemo != null) {
				transaction = session.beginTransaction();
				if(transaction != null) {
						System.out.println("Editing record for id:: "+ id);
						
						System.out.println("Name:: Previous value: "+ versionDemo.getName() +"  || Enter new value:");
						name = br.readLine();
						if(name != null && !name.isBlank() && !name.equals(versionDemo.getName())) {
							versionDemo.setName(name);
						}
						
						System.out.println("Address:: Previous value: "+versionDemo.getAddress()+"  || Enter new value:");
						address = br.readLine();
						if(address != null && !address.isBlank() && !address.equals(versionDemo.getAddress())) {
							versionDemo.setAddress(address);
						}
						
						System.out.println("Pincode:: Previous value: "+versionDemo.getPincode()+"  || Enter new value:");
						pincode = br.readLine();
						if(pincode != null && !pincode.isBlank() && !pincode.equals(versionDemo.getPincode())) {
							versionDemo.setPincode(pincode);
						}
						
						session.saveOrUpdate(versionDemo);
						
						flag = true;
				}
			} else {
				System.out.println("No Record found with given Id");
			}
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record Updated Succesfully");
				/*
				 * Version value will be increamented by 1 every time you make any update to that record.
				 */
				System.out.println("New Value of version is: "+ versionDemo.getVersion_number());
			} else {
				System.out.println("Something went wrong!");
			}
		}
	}
}
