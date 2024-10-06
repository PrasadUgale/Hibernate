package main.com.java.advance.association.model.many2many;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DOCTOR_MANY_MANY")
public class Doctor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer docId;
	private String name;
	private String specialization;
	private String hospital;
	
	/* Many to Many mapping
	 * @JoinTable defines the join table for a many-to-many relationship.
	 * name = "DOC_PAT_M2M": The join table name.
	 * joinColumns: Refers to the owning side (Doctor) with DOC_ID as the foreign key to docId.
	 * inverseJoinColumns: Refers to the inverse side (Patient) with PAT_ID as the foreign key to patId
	 */
	@ManyToMany(targetEntity = Patient.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "DOC_PAT_M2M", 
				joinColumns = @JoinColumn(name= "DOC_ID", referencedColumnName = "docId"), 
				inverseJoinColumns = @JoinColumn(name = "PAT_ID", referencedColumnName = "patId") )
	private Set<Patient> patients;

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctore [docId=" + docId + ", name=" + name + ", specialization=" + specialization + ", hospital="
				+ hospital +  "]";
	}
	
	
}
