package main.com.java.advance.association.model.one2many;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_ONE_MANY_UNI")
public class Person implements Serializable {
	
	/* Need to create link from Parent to children
	 * use @JoinColumn to create the link
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String pname;
	private String paddress;
	
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "person_id", referencedColumnName = "pid") //Created Foreign Key in Phone Number table
	private Set<PhoneNumber> numbers;  //Holds multiple phone number records for 1 person

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public Set<PhoneNumber> getPhoneNos() {
		return numbers;
	}

	public void setPhoneNos(Set<PhoneNumber> phoneNos) {
		this.numbers = phoneNos;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", phoneNos=" + numbers + "]";
	}
	
	
}
