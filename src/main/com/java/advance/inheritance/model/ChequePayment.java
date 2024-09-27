package main.com.java.advance.inheritance.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity

//Single table strategy
@DiscriminatorValue(value="cheque") 

/* //Table per subclass strategy
 * @PrimaryKeyJoinColumn(name = "payment_id", referencedColumnName = "pid") 
 * @Table(name = "CHEQUEPAYMENT_TBSC")
 */

public class ChequePayment extends Payment {
	private Long chequeNo;
	private String chequeType;
	private LocalDate expriyDate;
	
	static {
		System.out.println("ChequePayment.class file is loading...");
	}
	
	public ChequePayment() {
		System.out.println("Hibernate creating an object of ChequePayment...");
	}

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	public LocalDate getExpriyDate() {
		return expriyDate;
	}

	public void setExpriyDate(LocalDate expriyDate) {
		this.expriyDate = expriyDate;
	}

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expriyDate=" + expriyDate
				+ "]";
	}

}
