package main.com.java.advance.association.model.one2many;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE_ONE_MANY_BI")
public class PhoneNumberBi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regNo;
	private Long mobileNo;
	private String type;
	private String provider;
	
	@ManyToOne(targetEntity = PersonBi.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id", referencedColumnName = "pid")
	private PersonBi person;
	
	public Integer getRegNo() {
		return regNo;
	}
	public void setRegNo(Integer regNo) {
		this.regNo = regNo;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public PersonBi getPerson() {
		return person;
	}
	public void setPerson(PersonBi person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", mobileNo=" + mobileNo + ", type=" + type + ", provider=" + provider
				+ "]";
	}
	
}
