package net.gmcc.pboss.domain.model.operation;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OperationlogVO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_PW_OPERATIONLOG")//, schema = "PBOSS"
public class OperationlogVO implements java.io.Serializable {
	// Fields

	private Long logid;
	private Date optime;
	private String oprcode;
	private String oprtype;
	private String success;
	private String opnid;
	private String name;
	private String parentid;
	private Byte state;
	private String remark;
	private Date startdate;
	private Date enddate;
	private Boolean isbusi;
	private Short opnlevel;
	private Boolean busikind;
	private String busibelong;
	private Short sflag;
	private String approveid;

	// Constructors

	/** default constructor */
	public OperationlogVO() {
	}

	/** full constructor */
	public OperationlogVO(Date optime, String oprcode, String oprtype,
			String success, String opnid, String name, String parentid,
			Byte state, String remark, Date startdate, Date enddate,
			Boolean isbusi, Short opnlevel, Boolean busikind,
			String busibelong, Short sflag, String approveid) {
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.opnid = opnid;
		this.name = name;
		this.parentid = parentid;
		this.state = state;
		this.remark = remark;
		this.startdate = startdate;
		this.enddate = enddate;
		this.isbusi = isbusi;
		this.opnlevel = opnlevel;
		this.busikind = busikind;
		this.busibelong = busibelong;
		this.sflag = sflag;
		this.approveid = approveid;
	}

	// Property accessors
	@SequenceGenerator(name = "generator", sequenceName = "ch_pw_operationlog_seq", allocationSize=1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "LOGID", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	@Temporal(TemporalType.TIMESTAMP)//@Temporal(TemporalType.DATE)
	@Column(name = "OPTIME", length = 7)
	public Date getOptime() {
		return this.optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	@Column(name = "OPRCODE", length = 16)
	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	@Column(name = "OPRTYPE", length = 6)
	public String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	@Column(name = "SUCCESS", length = 6)
	public String getSuccess() {
		return this.success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	@Column(name = "OPNID", length = 18)
	public String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PARENTID", length = 18)
	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	@Column(name = "STATE", precision = 2, scale = 0)
	public Byte getState() {
		return this.state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", length = 7)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE", length = 7)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Column(name = "ISBUSI", precision = 1, scale = 0)
	public Boolean getIsbusi() {
		return this.isbusi;
	}

	public void setIsbusi(Boolean isbusi) {
		this.isbusi = isbusi;
	}

	@Column(name = "OPNLEVEL", precision = 3, scale = 0)
	public Short getOpnlevel() {
		return this.opnlevel;
	}

	public void setOpnlevel(Short opnlevel) {
		this.opnlevel = opnlevel;
	}

	@Column(name = "BUSIKIND", precision = 1, scale = 0)
	public Boolean getBusikind() {
		return this.busikind;
	}

	public void setBusikind(Boolean busikind) {
		this.busikind = busikind;
	}

	@Column(name = "BUSIBELONG", length = 32)
	public String getBusibelong() {
		return this.busibelong;
	}

	public void setBusibelong(String busibelong) {
		this.busibelong = busibelong;
	}

	@Column(name = "SFLAG", precision = 3, scale = 0)
	public Short getSflag() {
		return this.sflag;
	}

	public void setSflag(Short sflag) {
		this.sflag = sflag;
	}

	@Column(name = "APPROVEID", length = 32)
	public String getApproveid() {
		return this.approveid;
	}

	public void setApproveid(String approveid) {
		this.approveid = approveid;
	}
}
