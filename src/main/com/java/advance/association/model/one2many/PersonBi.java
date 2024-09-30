package main.com.java.advance.association.model.one2many;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_ONE_MANY_BI")
public class PersonBi implements Serializable {
	
	/* Need to create a link from both side 
	 * We can use @JoinColummn by both side to create link
	 * Or use mappedBy on one side and @joinColumn on other 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String pname;
	private String paddress;
	
	@OneToMany(targetEntity = PhoneNumberBi.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "person")
	// We can either use @JoinColumn or direclty use mapped by in associatation annotation for linking
	// @JoinColumn(name = "person_id", referencedColumnName = "pid")
	private Set<PhoneNumberBi> numbers;

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

	public Set<PhoneNumberBi> getPhoneNos() {
		return numbers;
	}

	public void setPhoneNos(Set<PhoneNumberBi> phoneNos) {
		this.numbers = phoneNos;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", phoneNos=" + numbers + "]";
	}
	
	
}
