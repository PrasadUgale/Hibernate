package main.com.java.advance.association.model.one2one;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_ONE_ONE_FK_BI")
public class StudentFkBi implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String name;
	private String address;
	
	//One to One mapping
	@OneToOne(targetEntity = LibraryFkBi.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "library_id", referencedColumnName = "lid")
	private LibraryFkBi libraryFkBi;

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

	public LibraryFkBi getLibraryFkBi() {
		return libraryFkBi;
	}

	public void setLibraryFkBi(LibraryFkBi libraryFkBi) {
		this.libraryFkBi = libraryFkBi;
	}

	@Override
	public String toString() {
		return "StudentFkBi [sid=" + sid + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
}
