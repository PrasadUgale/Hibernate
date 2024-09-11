package main.com.java.file_upload.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileData {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Lob
	@Column(name = "resume")
	private char[] resume;
	
	@Lob
	@Column(name = "photo")
	private byte[] photo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char[] getResume() {
		return resume;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "FileData [id=" + id + ", name=" + name + ", resume=" + "]";
	}
	
	
	
}
