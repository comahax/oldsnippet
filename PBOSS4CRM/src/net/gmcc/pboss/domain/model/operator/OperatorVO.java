package net.gmcc.pboss.domain.model.operator;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "SA_SO_OPERATOR")//, schema = "PBOSS"
public class OperatorVO implements java.io.Serializable {

	// Fields

	private String operid;
	private Integer region;
	private String opername;
	private String password;
	private Date passchgdate;
	private String opergroup;
	private String opertype;
	private String operlevel;
	private Boolean ismanager;
	private String contactphone;
	private String orgid;
	private Boolean isrestrict;
	private Byte starttime;
	private Byte endtime;
	private Boolean enablegprs;
	private Byte gprsstarttime;
	private Byte gprsendtime;
	private Boolean ischkmac;
	private String mac;
	private String notes;
	private Date createdate;
	private Boolean status;
	private Date statusdate;
	private String releStaffId;
	private Boolean smnotityflag;
	private String cspStaffNo;
	private String systemtype;
	private Date startUsingTime;
	private Date endUsingTime;
	private String logintype;

	// Constructors

	/** default constructor */
	public OperatorVO() {
	}

	/** minimal constructor */
	public OperatorVO(String operid) {
		this.operid = operid;
	}

	/** full constructor */
	public OperatorVO(String operid, Integer region, String opername,
			String password, Date passchgdate, String opergroup,
			String opertype, String operlevel, Boolean ismanager,
			String contactphone, String orgid, Boolean isrestrict,
			Byte starttime, Byte endtime, Boolean enablegprs,
			Byte gprsstarttime, Byte gprsendtime, Boolean ischkmac, String mac,
			String notes, Date createdate, Boolean status, Date statusdate,
			String releStaffId, Boolean smnotityflag, String cspStaffNo,
			String systemtype, Date startUsingTime, Date endUsingTime,
			String logintype) {
		this.operid = operid;
		this.region = region;
		this.opername = opername;
		this.password = password;
		this.passchgdate = passchgdate;
		this.opergroup = opergroup;
		this.opertype = opertype;
		this.operlevel = operlevel;
		this.ismanager = ismanager;
		this.contactphone = contactphone;
		this.orgid = orgid;
		this.isrestrict = isrestrict;
		this.starttime = starttime;
		this.endtime = endtime;
		this.enablegprs = enablegprs;
		this.gprsstarttime = gprsstarttime;
		this.gprsendtime = gprsendtime;
		this.ischkmac = ischkmac;
		this.mac = mac;
		this.notes = notes;
		this.createdate = createdate;
		this.status = status;
		this.statusdate = statusdate;
		this.releStaffId = releStaffId;
		this.smnotityflag = smnotityflag;
		this.cspStaffNo = cspStaffNo;
		this.systemtype = systemtype;
		this.startUsingTime = startUsingTime;
		this.endUsingTime = endUsingTime;
		this.logintype = logintype;
	}

	// Property accessors
	@Id
	@Column(name = "OPERID", unique = true, nullable = false, length = 16)
	public String getOperid() {
		return this.operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	@Column(name = "REGION", precision = 5, scale = 0)
	public Integer getRegion() {
		return this.region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	@Column(name = "OPERNAME", length = 64)
	public String getOpername() {
		return this.opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	@Column(name = "PASSWORD", length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "PASSCHGDATE", length = 7)
	public Date getPasschgdate() {
		return this.passchgdate;
	}

	public void setPasschgdate(Date passchgdate) {
		this.passchgdate = passchgdate;
	}

	@Column(name = "OPERGROUP", length = 16)
	public String getOpergroup() {
		return this.opergroup;
	}

	public void setOpergroup(String opergroup) {
		this.opergroup = opergroup;
	}

	@Column(name = "OPERTYPE", length = 16)
	public String getOpertype() {
		return this.opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	@Column(name = "OPERLEVEL", length = 16)
	public String getOperlevel() {
		return this.operlevel;
	}

	public void setOperlevel(String operlevel) {
		this.operlevel = operlevel;
	}

	@Column(name = "ISMANAGER", precision = 1, scale = 0)
	public Boolean getIsmanager() {
		return this.ismanager;
	}

	public void setIsmanager(Boolean ismanager) {
		this.ismanager = ismanager;
	}

	@Column(name = "CONTACTPHONE", length = 20)
	public String getContactphone() {
		return this.contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	@Column(name = "ORGID", length = 32)
	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	@Column(name = "ISRESTRICT", precision = 1, scale = 0)
	public Boolean getIsrestrict() {
		return this.isrestrict;
	}

	public void setIsrestrict(Boolean isrestrict) {
		this.isrestrict = isrestrict;
	}

	@Column(name = "STARTTIME", precision = 2, scale = 0)
	public Byte getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Byte starttime) {
		this.starttime = starttime;
	}

	@Column(name = "ENDTIME", precision = 2, scale = 0)
	public Byte getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Byte endtime) {
		this.endtime = endtime;
	}

	@Column(name = "ENABLEGPRS", precision = 1, scale = 0)
	public Boolean getEnablegprs() {
		return this.enablegprs;
	}

	public void setEnablegprs(Boolean enablegprs) {
		this.enablegprs = enablegprs;
	}

	@Column(name = "GPRSSTARTTIME", precision = 2, scale = 0)
	public Byte getGprsstarttime() {
		return this.gprsstarttime;
	}

	public void setGprsstarttime(Byte gprsstarttime) {
		this.gprsstarttime = gprsstarttime;
	}

	@Column(name = "GPRSENDTIME", precision = 2, scale = 0)
	public Byte getGprsendtime() {
		return this.gprsendtime;
	}

	public void setGprsendtime(Byte gprsendtime) {
		this.gprsendtime = gprsendtime;
	}

	@Column(name = "ISCHKMAC", precision = 1, scale = 0)
	public Boolean getIschkmac() {
		return this.ischkmac;
	}

	public void setIschkmac(Boolean ischkmac) {
		this.ischkmac = ischkmac;
	}

	@Column(name = "MAC", length = 32)
	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Column(name = "NOTES", length = 256)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "CREATEDATE", length = 7)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "STATUS", precision = 1, scale = 0)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "STATUSDATE", length = 7)
	public Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	@Column(name = "RELE_STAFF_ID", length = 16)
	public String getReleStaffId() {
		return this.releStaffId;
	}

	public void setReleStaffId(String releStaffId) {
		this.releStaffId = releStaffId;
	}

	@Column(name = "SMNOTITYFLAG", precision = 1, scale = 0)
	public Boolean getSmnotityflag() {
		return this.smnotityflag;
	}

	public void setSmnotityflag(Boolean smnotityflag) {
		this.smnotityflag = smnotityflag;
	}

	@Column(name = "CSP_STAFF_NO", length = 15)
	public String getCspStaffNo() {
		return this.cspStaffNo;
	}

	public void setCspStaffNo(String cspStaffNo) {
		this.cspStaffNo = cspStaffNo;
	}

	@Column(name = "SYSTEMTYPE", length = 10)
	public String getSystemtype() {
		return this.systemtype;
	}

	public void setSystemtype(String systemtype) {
		this.systemtype = systemtype;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "START_USING_TIME", length = 7)
	public Date getStartUsingTime() {
		return this.startUsingTime;
	}

	public void setStartUsingTime(Date startUsingTime) {
		this.startUsingTime = startUsingTime;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "END_USING_TIME", length = 7)
	public Date getEndUsingTime() {
		return this.endUsingTime;
	}

	public void setEndUsingTime(Date endUsingTime) {
		this.endUsingTime = endUsingTime;
	}

	@Column(name = "LOGINTYPE", length = 16)
	public String getLogintype() {
		return this.logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

}