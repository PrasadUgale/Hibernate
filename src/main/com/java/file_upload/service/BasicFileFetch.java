package main.com.java.file_upload.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.com.java.date.util.DateDataUtil;
import main.com.java.file_upload.model.FileData;
import main.com.java.file_upload.util.FileUploadUtil;

public class BasicFileFetch {
	
	public static void main(String[] args) {
		
		//Change location where you want to save file
		String photo = "C:\\Users\\prasa\\Pictures\\Application\\KakashiPhoto.jpg";
		String resume = "C:\\Users\\prasa\\Pictures\\Application\\KakashiResume.txt";
		
		Session session = null;
		//DB should have a record with given id::
		Integer id = 1;

		try {
			session = FileUploadUtil.getSession();

			FileData data = new FileData();

			data = session.get(FileData.class, id);
			
			if (data != null) {
				System.out.println("Id :: "+ data.getId());
				System.out.println("Name :: "+ data.getName());
				
				try(FileWriter fw = new FileWriter(new File(resume)); 
						FileOutputStream fos = new FileOutputStream(new File(photo))){
					fw.write(data.getResume());
					fw.flush();
					System.out.println("Resume Stored at:: "+ resume);
					
					fos.write(data.getPhoto());
					fos.flush();
					System.out.println("Photo Stored at:: "+photo);
				}
				
				
			} else {
				System.out.println("Record not found for the id :: " + id);
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DateDataUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}
	
}
