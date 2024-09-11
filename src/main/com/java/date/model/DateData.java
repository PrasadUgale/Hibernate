package main.com.java.date.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DateData {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	private LocalDate dob;
	private LocalTime doj;
	private LocalDateTime dom;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalTime getDoj() {
		return doj;
	}
	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}
	public LocalDateTime getDom() {
		return dom;
	}
	public void setDom(LocalDateTime dom) {
		this.dom = dom;
	}
	@Override
	public String toString() {
		return "DateData [id=" + id + ", name=" + name + ", dob=" + dob + ", doj=" + doj + ", dom=" + dom + "]";
	}
	
	
}
