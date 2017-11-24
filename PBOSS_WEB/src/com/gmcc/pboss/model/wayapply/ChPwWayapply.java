package com.gmcc.pboss.model.wayapply;

import java.util.Date;

import com.gmcc.pboss.common.bean.AutoLogBean;

/**
 * ChPwWayapply entity. @author MyEclipse Persistence Tools
 */

public class ChPwWayapply extends com.gmcc.pboss.common.bean.CodeReverse
		implements AutoLogBean {

	// Fields

	private Long applyno;
	private Date optime;
	private Byte auditstatus;
	private String description;
	private String wayid;
	private String wayname;
	private String waysubtype;
	private String upperwayid;
	private Byte starlevel;
	private Byte pt;
	private Short waystate;
	private String cityid;
	private String countyid;
	private String svccode;
	private String mareacode;
	private Byte isstraitprd;
	private Byte adtypecode;
	private String adacode;
	private Byte formtype;
	private Date starttime;
	private Integer buzarea;
	private String logiscode;
	private String waymagcode;
	private String bchlevel;
	private String officetel;
	private Long alarmbizamount;
	private String address;
	private String latitude;
	private String longtitude;
	private String principal;
	private String principaltel;
	private String principalphone;
	private String principalemail;
	private String sendaddr;
	private String acctno;
	private String acctname;
	private String bankname;
	private String acctfid;
	private String deacctno;
	private String deacctname;
	private String debankname;
	private Short accttype;
	private Date intime;
	private Byte catetype;
	private String chainhead;
	private String recpers;
	private String recconntel;
	private String reccertno;
	private Byte signstatus;
	private String provcode;
	private Byte bailtype;
	private Short servbound;
	private String compactno;
	private String compactname;
	private Date begintime;
	private Date endtime;
	private Date signtime;
	private Byte compacttype;
	private String licenceno;
	private Double bail;
	private Double baillwrlmt;
	private Date licvalidate;
	private Byte bailstatus;
	private Boolean isb2m;
	private Long smsmobileno;
	private String debankid;
	private Boolean destate;
	private String custtype;

	// Constructors

	/** default constructor */
	public ChPwWayapply() {
	}

	/** full constructor */
	public ChPwWayapply(Date optime, Byte auditstatus, String description,
			String wayid, String wayname, String waysubtype, String upperwayid,
			Byte starlevel, Byte pt, Short waystate, String cityid,
			String countyid, String svccode, String mareacode,
			Byte isstraitprd, Byte adtypecode, String adacode, Byte formtype,
			Date starttime, Integer buzarea, String logiscode,
			String waymagcode, String bchlevel, String officetel,
			Long alarmbizamount, String address, String latitude,
			String longtitude, String principal, String principaltel,
			String principalphone, String principalemail, String sendaddr,
			String acctno, String acctname, String bankname, String acctfid,
			String deacctno, String deacctname, String debankname,
			Short accttype, Date intime, Byte catetype, String chainhead,
			String recpers, String recconntel, String reccertno,
			Byte signstatus, String provcode, Byte bailtype, Short servbound,
			String compactno, String compactname, Date begintime, Date endtime,
			Date signtime, Byte compacttype, String licenceno, Double bail,
			Double baillwrlmt, Date licvalidate, Byte bailstatus,
			Boolean isb2m, Long smsmobileno, String debankid, Boolean destate,
			String custtype) {
		this.optime = optime;
		this.auditstatus = auditstatus;
		this.description = description;
		this.wayid = wayid;
		this.wayname = wayname;
		this.waysubtype = waysubtype;
		this.upperwayid = upperwayid;
		this.starlevel = starlevel;
		this.pt = pt;
		this.waystate = waystate;
		this.cityid = cityid;
		this.countyid = countyid;
		this.svccode = svccode;
		this.mareacode = mareacode;
		this.isstraitprd = isstraitprd;
		this.adtypecode = adtypecode;
		this.adacode = adacode;
		this.formtype = formtype;
		this.starttime = starttime;
		this.buzarea = buzarea;
		this.logiscode = logiscode;
		this.waymagcode = waymagcode;
		this.bchlevel = bchlevel;
		this.officetel = officetel;
		this.alarmbizamount = alarmbizamount;
		this.address = address;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.principal = principal;
		this.principaltel = principaltel;
		this.principalphone = principalphone;
		this.principalemail = principalemail;
		this.sendaddr = sendaddr;
		this.acctno = acctno;
		this.acctname = acctname;
		this.bankname = bankname;
		this.acctfid = acctfid;
		this.deacctno = deacctno;
		this.deacctname = deacctname;
		this.debankname = debankname;
		this.accttype = accttype;
		this.intime = intime;
		this.catetype = catetype;
		this.chainhead = chainhead;
		this.recpers = recpers;
		this.recconntel = recconntel;
		this.reccertno = reccertno;
		this.signstatus = signstatus;
		this.provcode = provcode;
		this.bailtype = bailtype;
		this.servbound = servbound;
		this.compactno = compactno;
		this.compactname = compactname;
		this.begintime = begintime;
		this.endtime = endtime;
		this.signtime = signtime;
		this.compacttype = compacttype;
		this.licenceno = licenceno;
		this.bail = bail;
		this.baillwrlmt = baillwrlmt;
		this.licvalidate = licvalidate;
		this.bailstatus = bailstatus;
		this.isb2m = isb2m;
		this.smsmobileno = smsmobileno;
		this.debankid = debankid;
		this.destate = destate;
		this.custtype = custtype;
	}

	// Property accessors

	public Long getApplyno() {
		return this.applyno;
	}

	public void setApplyno(Long applyno) {
		this.applyno = applyno;
	}

	public Date getOptime() {
		return this.optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	public Byte getAuditstatus() {
		return this.auditstatus;
	}

	public void setAuditstatus(Byte auditstatus) {
		this.auditstatus = auditstatus;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return this.wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getWaysubtype() {
		return this.waysubtype;
	}

	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
	}

	public String getUpperwayid() {
		return this.upperwayid;
	}

	public void setUpperwayid(String upperwayid) {
		this.upperwayid = upperwayid;
	}

	public Byte getStarlevel() {
		return this.starlevel;
	}

	public void setStarlevel(Byte starlevel) {
		this.starlevel = starlevel;
	}

	public Byte getPt() {
		return this.pt;
	}

	public void setPt(Byte pt) {
		this.pt = pt;
	}

	public Short getWaystate() {
		return this.waystate;
	}

	public void setWaystate(Short waystate) {
		this.waystate = waystate;
	}

	public String getCityid() {
		return this.cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCountyid() {
		return this.countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getSvccode() {
		return this.svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getMareacode() {
		return this.mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public Byte getIsstraitprd() {
		return this.isstraitprd;
	}

	public void setIsstraitprd(Byte isstraitprd) {
		this.isstraitprd = isstraitprd;
	}

	public Byte getAdtypecode() {
		return this.adtypecode;
	}

	public void setAdtypecode(Byte adtypecode) {
		this.adtypecode = adtypecode;
	}

	public String getAdacode() {
		return this.adacode;
	}

	public void setAdacode(String adacode) {
		this.adacode = adacode;
	}

	public Byte getFormtype() {
		return this.formtype;
	}

	public void setFormtype(Byte formtype) {
		this.formtype = formtype;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Integer getBuzarea() {
		return this.buzarea;
	}

	public void setBuzarea(Integer buzarea) {
		this.buzarea = buzarea;
	}

	public String getLogiscode() {
		return this.logiscode;
	}

	public void setLogiscode(String logiscode) {
		this.logiscode = logiscode;
	}

	public String getWaymagcode() {
		return this.waymagcode;
	}

	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}

	public String getBchlevel() {
		return this.bchlevel;
	}

	public void setBchlevel(String bchlevel) {
		this.bchlevel = bchlevel;
	}

	public String getOfficetel() {
		return this.officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public Long getAlarmbizamount() {
		return this.alarmbizamount;
	}

	public void setAlarmbizamount(Long alarmbizamount) {
		this.alarmbizamount = alarmbizamount;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongtitude() {
		return this.longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPrincipaltel() {
		return this.principaltel;
	}

	public void setPrincipaltel(String principaltel) {
		this.principaltel = principaltel;
	}

	public String getPrincipalphone() {
		return this.principalphone;
	}

	public void setPrincipalphone(String principalphone) {
		this.principalphone = principalphone;
	}

	public String getPrincipalemail() {
		return this.principalemail;
	}

	public void setPrincipalemail(String principalemail) {
		this.principalemail = principalemail;
	}

	public String getSendaddr() {
		return this.sendaddr;
	}

	public void setSendaddr(String sendaddr) {
		this.sendaddr = sendaddr;
	}

	public String getAcctno() {
		return this.acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public String getAcctname() {
		return this.acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAcctfid() {
		return this.acctfid;
	}

	public void setAcctfid(String acctfid) {
		this.acctfid = acctfid;
	}

	public String getDeacctno() {
		return this.deacctno;
	}

	public void setDeacctno(String deacctno) {
		this.deacctno = deacctno;
	}

	public String getDeacctname() {
		return this.deacctname;
	}

	public void setDeacctname(String deacctname) {
		this.deacctname = deacctname;
	}

	public String getDebankname() {
		return this.debankname;
	}

	public void setDebankname(String debankname) {
		this.debankname = debankname;
	}

	public Short getAccttype() {
		return this.accttype;
	}

	public void setAccttype(Short accttype) {
		this.accttype = accttype;
	}

	public Date getIntime() {
		return this.intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public Byte getCatetype() {
		return this.catetype;
	}

	public void setCatetype(Byte catetype) {
		this.catetype = catetype;
	}

	public String getChainhead() {
		return this.chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public String getRecpers() {
		return this.recpers;
	}

	public void setRecpers(String recpers) {
		this.recpers = recpers;
	}

	public String getRecconntel() {
		return this.recconntel;
	}

	public void setRecconntel(String recconntel) {
		this.recconntel = recconntel;
	}

	public String getReccertno() {
		return this.reccertno;
	}

	public void setReccertno(String reccertno) {
		this.reccertno = reccertno;
	}

	public Byte getSignstatus() {
		return this.signstatus;
	}

	public void setSignstatus(Byte signstatus) {
		this.signstatus = signstatus;
	}

	public String getProvcode() {
		return this.provcode;
	}

	public void setProvcode(String provcode) {
		this.provcode = provcode;
	}

	public Byte getBailtype() {
		return this.bailtype;
	}

	public void setBailtype(Byte bailtype) {
		this.bailtype = bailtype;
	}

	public Short getServbound() {
		return this.servbound;
	}

	public void setServbound(Short servbound) {
		this.servbound = servbound;
	}

	public String getCompactno() {
		return this.compactno;
	}

	public void setCompactno(String compactno) {
		this.compactno = compactno;
	}

	public String getCompactname() {
		return this.compactname;
	}

	public void setCompactname(String compactname) {
		this.compactname = compactname;
	}

	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getSigntime() {
		return this.signtime;
	}

	public void setSigntime(Date signtime) {
		this.signtime = signtime;
	}

	public Byte getCompacttype() {
		return this.compacttype;
	}

	public void setCompacttype(Byte compacttype) {
		this.compacttype = compacttype;
	}

	public String getLicenceno() {
		return this.licenceno;
	}

	public void setLicenceno(String licenceno) {
		this.licenceno = licenceno;
	}

	public Double getBail() {
		return this.bail;
	}

	public void setBail(Double bail) {
		this.bail = bail;
	}

	public Double getBaillwrlmt() {
		return this.baillwrlmt;
	}

	public void setBaillwrlmt(Double baillwrlmt) {
		this.baillwrlmt = baillwrlmt;
	}

	public Date getLicvalidate() {
		return this.licvalidate;
	}

	public void setLicvalidate(Date licvalidate) {
		this.licvalidate = licvalidate;
	}

	public Byte getBailstatus() {
		return this.bailstatus;
	}

	public void setBailstatus(Byte bailstatus) {
		this.bailstatus = bailstatus;
	}

	public Boolean getIsb2m() {
		return this.isb2m;
	}

	public void setIsb2m(Boolean isb2m) {
		this.isb2m = isb2m;
	}

	public Long getSmsmobileno() {
		return this.smsmobileno;
	}

	public void setSmsmobileno(Long smsmobileno) {
		this.smsmobileno = smsmobileno;
	}

	public String getDebankid() {
		return this.debankid;
	}

	public void setDebankid(String debankid) {
		this.debankid = debankid;
	}

	public Boolean getDestate() {
		return this.destate;
	}

	public void setDestate(Boolean destate) {
		this.destate = destate;
	}

	public String getCusttype() {
		return this.custtype;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

	public Class getLogClass() {
		// TODO Auto-generated method stub
		return ChPwWayapplylog.class;
	}

	public String[] getLogProperties() {
		// TODO Auto-generated method stub
		return AutoLogBean.logProperties;
	}

}