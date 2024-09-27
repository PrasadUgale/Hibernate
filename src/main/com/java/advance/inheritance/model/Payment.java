package main.com.java.advance.inheritance.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_TBC")

//Single table strategy
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "payment_mode", discriminatorType = DiscriminatorType.STRING, length = 20) //For Single table strategy

/* Table per subclass strategy
 * @Inheritance(strategy = InheritanceType.JOINED)
 */

/*
 * Table per Concrete class
 * Class should be abstract implements serializable
 * Table will not be created for abstract class, so table info should not be provided by annotations 
 * @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
 */


public abstract class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private Float amount;

	static {
		System.out.println("Payment.class file is loading...");
	}

	public Payment() {
		System.out.println("Hibernate creating an object of Payment...");
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", amount=" + amount + "]";
	}
}
