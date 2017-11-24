package net.gmcc.pboss.domain.model.waycompact;

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
@Table(name = "CH_PW_WAYCOMPACT")//, schema = "PBOSS_ZS"
public class WaycompactVO implements java.io.Serializable {

	// Fields

	private String wayid;
	private String compactno;
	private String compactname;
	private Date begintime;
	private Date endtime;
	private Date signtime;
	private Short coptype;
	private String copbound;
	private String recomrule;
	private String compact;
	private Byte compacttype;
	private String compactpath;
	private String licenceno;
	private String licencepath;
	private Byte runareatype;
	private String principal;
	private Double bail;
	private Byte bailstatus;
	private Boolean isb2m;
	private Boolean isunpb;
	private Short calcumode;
	private String uniformtime;
	private Double taxrate;

	// Constructors

	/** default constructor */
	public WaycompactVO() {
	}

	/** minimal constructor */
	public WaycompactVO(String wayid, String compactno, String compactname,
			Date begintime, Date endtime, Date signtime) {
		this.wayid = wayid;
		this.compactno = compactno;
		this.compactname = compactname;
		this.begintime = begintime;
		this.endtime = endtime;
		this.signtime = signtime;
	}

	/** full constructor */
	public WaycompactVO(String wayid, String compactno, String compactname,
			Date begintime, Date endtime, Date signtime, Short coptype,
			String copbound, String recomrule, String compact,
			Byte compacttype, String compactpath, String licenceno,
			String licencepath, Byte runareatype, String principal,
			Double bail, Byte bailstatus, Boolean isb2m, Boolean isunpb,
			Short calcumode, String uniformtime, Double taxrate) {
		this.wayid = wayid;
		this.compactno = compactno;
		this.compactname = compactname;
		this.begintime = begintime;
		this.endtime = endtime;
		this.signtime = signtime;
		this.coptype = coptype;
		this.copbound = copbound;
		this.recomrule = recomrule;
		this.compact = compact;
		this.compacttype = compacttype;
		this.compactpath = compactpath;
		this.licenceno = licenceno;
		this.licencepath = licencepath;
		this.runareatype = runareatype;
		this.principal = principal;
		this.bail = bail;
		this.bailstatus = bailstatus;
		this.isb2m = isb2m;
		this.isunpb = isunpb;
		this.calcumode = calcumode;
		this.uniformtime = uniformtime;
		this.taxrate = taxrate;
	}

	// Property accessors
	@Id
	@Column(name = "WAYID", unique = true, nullable = false, length = 18)
	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	@Column(name = "COMPACTNO", nullable = false, length = 17)
	public String getCompactno() {
		return this.compactno;
	}

	public void setCompactno(String compactno) {
		this.compactno = compactno;
	}

	@Column(name = "COMPACTNAME", nullable = false)
	public String getCompactname() {
		return this.compactname;
	}

	public void setCompactname(String compactname) {
		this.compactname = compactname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGINTIME", nullable = false, length = 7)
	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDTIME", nullable = false, length = 7)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SIGNTIME", nullable = false, length = 7)
	public Date getSigntime() {
		return this.signtime;
	}

	public void setSigntime(Date signtime) {
		this.signtime = signtime;
	}

	@Column(name = "COPTYPE", precision = 3, scale = 0)
	public Short getCoptype() {
		return this.coptype;
	}

	public void setCoptype(Short coptype) {
		this.coptype = coptype;
	}

	@Column(name = "COPBOUND", length = 40)
	public String getCopbound() {
		return this.copbound;
	}

	public void setCopbound(String copbound) {
		this.copbound = copbound;
	}

	@Column(name = "RECOMRULE")
	public String getRecomrule() {
		return this.recomrule;
	}

	public void setRecomrule(String recomrule) {
		this.recomrule = recomrule;
	}

	@Column(name = "COMPACT")
	public String getCompact() {
		return this.compact;
	}

	public void setCompact(String compact) {
		this.compact = compact;
	}

	@Column(name = "COMPACTTYPE", precision = 2, scale = 0)
	public Byte getCompacttype() {
		return this.compacttype;
	}

	public void setCompacttype(Byte compacttype) {
		this.compacttype = compacttype;
	}

	@Column(name = "COMPACTPATH")
	public String getCompactpath() {
		return this.compactpath;
	}

	public void setCompactpath(String compactpath) {
		this.compactpath = compactpath;
	}

	@Column(name = "LICENCENO", length = 64)
	public String getLicenceno() {
		return this.licenceno;
	}

	public void setLicenceno(String licenceno) {
		this.licenceno = licenceno;
	}

	@Column(name = "LICENCEPATH")
	public String getLicencepath() {
		return this.licencepath;
	}

	public void setLicencepath(String licencepath) {
		this.licencepath = licencepath;
	}

	@Column(name = "RUNAREATYPE", precision = 2, scale = 0)
	public Byte getRunareatype() {
		return this.runareatype;
	}

	public void setRunareatype(Byte runareatype) {
		this.runareatype = runareatype;
	}

	@Column(name = "PRINCIPAL", length = 64)
	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	@Column(name = "BAIL", precision = 18)
	public Double getBail() {
		return this.bail;
	}

	public void setBail(Double bail) {
		this.bail = bail;
	}

	@Column(name = "BAILSTATUS", precision = 2, scale = 0)
	public Byte getBailstatus() {
		return this.bailstatus;
	}

	public void setBailstatus(Byte bailstatus) {
		this.bailstatus = bailstatus;
	}

	@Column(name = "ISB2M", precision = 1, scale = 0)
	public Boolean getIsb2m() {
		return this.isb2m;
	}

	public void setIsb2m(Boolean isb2m) {
		this.isb2m = isb2m;
	}

	@Column(name = "ISUNPB", precision = 1, scale = 0)
	public Boolean getIsunpb() {
		return this.isunpb;
	}

	public void setIsunpb(Boolean isunpb) {
		this.isunpb = isunpb;
	}

	@Column(name = "CALCUMODE", precision = 3, scale = 0)
	public Short getCalcumode() {
		return this.calcumode;
	}

	public void setCalcumode(Short calcumode) {
		this.calcumode = calcumode;
	}

	@Column(name = "UNIFORMTIME", length = 6)
	public String getUniformtime() {
		return this.uniformtime;
	}

	public void setUniformtime(String uniformtime) {
		this.uniformtime = uniformtime;
	}

	@Column(name = "TAXRATE", precision = 3)
	public Double getTaxrate() {
		return this.taxrate;
	}

	public void setTaxrate(Double taxrate) {
		this.taxrate = taxrate;
	}

}