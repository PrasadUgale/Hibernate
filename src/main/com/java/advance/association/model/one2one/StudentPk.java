package main.com.java.advance.association.model.one2one;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_ONE_ONE_PK_BI")
public class StudentPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String name;
	private String address;
	
	//One to One mapping
	@OneToOne(targetEntity = LibraryPk.class, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "lid", referencedColumnName = "sid")
	private LibraryPk libraryPk;

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

	public LibraryPk getLibraryPk() {
		return libraryPk;
	}

	public void setLibraryPk(LibraryPk libraryPk) {
		this.libraryPk = libraryPk;
	}

	@Override
	public String toString() {
		return "StudentPk [sid=" + sid + ", name=" + name + ", address=" + address + ", libraryPk=" + libraryPk + "]";
	}
	
	
	
}
