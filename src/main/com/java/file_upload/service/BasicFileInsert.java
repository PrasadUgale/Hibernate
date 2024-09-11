package main.com.java.file_upload.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.com.java.date.util.DateDataUtil;
import main.com.java.file_upload.model.FileData;
import main.com.java.file_upload.util.FileUploadUtil;

public class BasicFileInsert {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		//Change the path to files for local
		String resume = "C:\\Users\\prasa\\Pictures\\KakashiResume.txt"; 
		String photo = "C:\\Users\\prasa\\Pictures\\KakashiPhoto.jpg";
		
		try {
			session = FileUploadUtil.getSession();
			transaction = session.beginTransaction();
			
			
			FileData data = new FileData();
			data.setId(1);
			data.setName("kakashi");
			
			FileInputStream fis = null;
			BufferedReader br = null;
			
			//Core java to set file data
			try {
				
				fis = new FileInputStream(photo);
				int photo_size = fis.available();
				byte[] photo_upload = new byte[photo_size];
				fis.read(photo_upload);
				data.setPhoto(photo_upload);
				
				File file = new File(resume);
				br = new BufferedReader(new FileReader(file));
				char[] resume_upload = new char[(int)file.length()];
				br.read(resume_upload);
				data.setResume(resume_upload);
				
				//Saving the changes
				session.save(data);
				
				flag = true;
				
			}catch (Exception e) {
				System.out.println("Unable to get file input");
				e.printStackTrace();
			} finally {
				if(fis != null)
					fis.close();
				if(br != null)
					br.close();
			} 			
		} catch (HibernateException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if(transaction !=null) {
				if(flag == true) {
					transaction.commit();
					System.out.println("Data Insert Succesfully");
				} else {
					System.out.println("Data Cannot be inserted");
				}
				
				DateDataUtil.closeSessionFactory();
				
				if(session !=null) {
					session.close();
				}
			}
		}
	}
}
