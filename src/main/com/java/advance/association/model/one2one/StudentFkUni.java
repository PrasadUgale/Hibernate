package main.com.java.advance.association.model.one2one;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_ONE_ONE_FK_UNI")
public class StudentFkUni implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String name;
	private String address;
	
	@OneToOne(targetEntity = LibraryFkUni.class, cascade = CascadeType.ALL)
	private LibraryFkUni libraryFkUni;
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LibraryFkUni getLibraryFkUni() {
		return libraryFkUni;
	}

	public void setLibraryFkUni(LibraryFkUni libraryFkUni) {
		this.libraryFkUni = libraryFkUni;
	}

	@Override
	public String toString() {
		return "StudentFkUni [sid=" + sid + ", name=" + name + ", address=" + address + ", libraryFkUni=" + libraryFkUni
				+ "]";
	}
	
}
