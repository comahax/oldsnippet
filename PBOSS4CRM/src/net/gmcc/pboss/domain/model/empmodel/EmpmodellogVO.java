package net.gmcc.pboss.domain.model.empmodel;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_PW_EMPMODELLOG")//, schema = "PBOSS_ZS"
public class EmpmodellogVO implements java.io.Serializable {

	// Fields

	private Long logid;
	private Long empmodelid;
	private String employeeid;
	private String model;
	private Short state;
	private Date optime;
	private String oprcode;
	private String oprtype;
	private String success;

	// Constructors

	/** default constructor */
	public EmpmodellogVO() {
	}

	/** minimal constructor */
	public EmpmodellogVO(Date optime, String oprcode, String oprtype) {
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
	}

	/** full constructor */
	public EmpmodellogVO(Long empmodelid, String employeeid, String model,
			Short state, Date optime, String oprcode, String oprtype,
			String success) {
		this.empmodelid = empmodelid;
		this.employeeid = employeeid;
		this.model = model;
		this.state = state;
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
	}

	// Property accessors
	@Id
//	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
//	@SequenceGenerator(name = "generator")
	@GeneratedValue(strategy = SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = "CH_PW_EMPMODELLOG_SEQ", allocationSize=1)
	@Column(name = "LOGID", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	@Column(name = "EMPMODELID", precision = 14, scale = 0)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPTIME", nullable = false, length = 7)
	public Date getOptime() {
		return this.optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	@Column(name = "OPRCODE", nullable = false, length = 15)
	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	@Column(name = "OPRTYPE", nullable = false, length = 8)
	public String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	@Column(name = "SUCCESS", length = 8)
	public String getSuccess() {
		return this.success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

}