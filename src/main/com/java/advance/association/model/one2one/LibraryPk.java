package main.com.java.advance.association.model.one2one;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY_ONE_ONE_PK_BI")
public class LibraryPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lid;
	private String type;
	private LocalDate date;
	
	//One to One mapping
	// We can alter mappedBy and @PrimaryKeyJoinColumn in one 2 one
	@OneToOne(targetEntity = StudentPk.class, cascade = CascadeType.ALL, mappedBy = "libraryPk")
	private StudentPk studentPk;

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public StudentPk getStudentPk() {
		return studentPk;
	}

	public void setStudentPk(StudentPk studentPk) {
		this.studentPk = studentPk;
	}

	@Override
	public String toString() {
		return "LibraryPk [lid=" + lid + ", type=" + type + ", date=" + date + "]";
	}
	
	
}
