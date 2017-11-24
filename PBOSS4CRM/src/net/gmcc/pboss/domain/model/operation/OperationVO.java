package net.gmcc.pboss.domain.model.operation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OperationVO entity.
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_PW_OPERATION")//, schema = "PBOSS"
public class OperationVO implements	java.io.Serializable {

	// Fields

	private String opnid;
	private String name;
	private String parentid;
	private String remark;
	private Byte state;
	private Date startdate;
	private Date enddate;
	private Boolean isbusi;
	private Boolean busikind;
	private String busibelong;
	private Short opnlevel;
	private Short sflag;
	private String approveid;

	// Constructors

	/** default constructor */
	public OperationVO() {
	}

	/** minimal constructor */
	public OperationVO(String opnid) {
		this.opnid = opnid;
	}

	/** full constructor */
	public OperationVO(String opnid, String name, String parentid,
			String remark, Byte state, Date startdate, Date enddate,
			Boolean isbusi, Boolean busikind, String busibelong,
			Short opnlevel, Short sflag, String approveid) {
		this.opnid = opnid;
		this.name = name;
		this.parentid = parentid;
		this.remark = remark;
		this.state = state;
		this.startdate = startdate;
		this.enddate = enddate;
		this.isbusi = isbusi;
		this.busikind = busikind;
		this.busibelong = busibelong;
		this.opnlevel = opnlevel;
		this.sflag = sflag;
		this.approveid = approveid;
	}

	// Property accessors
	@Id
	@Column(name = "OPNID", unique = true, nullable = false, length = 18)
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "STATE", precision = 2, scale = 0)
	public Byte getState() {
		return this.state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", length = 7)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Temporal(TemporalType.TIMESTAMP)//@Temporal(TemporalType.DATE)
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

	@Column(name = "OPNLEVEL", precision = 3, scale = 0)
	public Short getOpnlevel() {
		return this.opnlevel;
	}

	public void setOpnlevel(Short opnlevel) {
		this.opnlevel = opnlevel;
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
