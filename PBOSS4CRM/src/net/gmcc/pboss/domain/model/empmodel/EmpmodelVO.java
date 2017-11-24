package net.gmcc.pboss.domain.model.empmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_PW_EMPMODEL")//, schema = "PBOSS_ZS"
public class EmpmodelVO implements java.io.Serializable {

	// Fields

	private Long empmodelid;
	private String employeeid;
	private String model;
	private Short state;

	// Constructors

	/** default constructor */
	public EmpmodelVO() {
	}

	/** full constructor */
	public EmpmodelVO(String employeeid, String model, Short state) {
		this.employeeid = employeeid;
		this.model = model;
		this.state = state;
	}

	// Property accessors
	@Id
//	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
//	@SequenceGenerator(name = "generator")
	@GeneratedValue(strategy = SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = "CH_PW_EMPMODEL_SEQ", allocationSize=1)
	@Column(name = "EMPMODELID", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getEmpmodelid() {
		return this.empmodelid;
	}

	public void setEmpmodelid(Long empmodelid) {
		this.empmodelid = empmodelid;
	}

	@Column(name = "EMPLOYEEID", length = 18)
	public String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	@Column(name = "MODEL", length = 12)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "STATE", precision = 3, scale = 0)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

}