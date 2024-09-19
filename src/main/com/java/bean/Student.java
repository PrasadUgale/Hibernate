package main.com.java.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity			//Specifies class is an entity and is mapped to a table
@Table(name = "student")		//Specifies table name associated with entity
@NamedQuery(name = "SelectById", 
			query = "From main.com.java.bean.Student WHERE sid=:id") //HQL named query
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id							//Specifies Primary Key
	@Column(name = "sid")		//Column name for field
	@GeneratedValue(strategy = GenerationType.SEQUENCE)   //AutoIncreament
	private Integer sid;
	
	@Column(name = "sname")
	private String sname;
	
	@Column(name = "sage")
	private Integer sage;
	
	@Column(name = "saddress")
	private String saddress;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}
	
	
}
