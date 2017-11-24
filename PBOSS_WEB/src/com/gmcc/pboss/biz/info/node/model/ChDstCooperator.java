package com.gmcc.pboss.biz.info.node.model;

import java.util.Date;

/**
 * ChDstCooperator entity. @author MyEclipse Persistence Tools
 */

public class ChDstCooperator implements java.io.Serializable {

	// Fields

	private String cooperauid;
	private String cooperaname;
	private String cpabbrname;
	private String cocheckname;
	private String servman;
	private String cooperadel;
	private String postaddr;
	private String zipcode;
	private String conntel;
	private String connfaxno;
	private String usremail;
	private Double area;
	private String licenceid;
	private Date licvalidate;
	private String connpers;
	private String busconntel;
	private String sendaddr;
	private String recpers;
	private String recconntel;
	private String reccertno;
	private String smsmobileno;
	private String bankname;
	private String acctno;
	private String districtid;
	private Date intime;
	private String custmanager;
	private Date starttime;
	private String servpwd;
	private Short state;
	private String oldcoopera;
	private Double baillwrlmt;
	private String memo;
	private String waysubtype;
	private String cityid;
	private String countyid;
	private String svccode;
	private String mareacode;
	private Double cashdeposit;
	private Double cdradix;

	// Constructors

	/** default constructor */
	public ChDstCooperator() {
	}

	/** minimal constructor */
	public ChDstCooperator(String cooperauid, String cooperaname,
			String cpabbrname, String cooperadel, String conntel,
			String licenceid, Date licvalidate, String connpers,
			String busconntel, String bankname, String acctno, Date starttime,
			Short state, Double baillwrlmt) {
		this.cooperauid = cooperauid;
		this.cooperaname = cooperaname;
		this.cpabbrname = cpabbrname;
		this.cooperadel = cooperadel;
		this.conntel = conntel;
		this.licenceid = licenceid;
		this.licvalidate = licvalidate;
		this.connpers = connpers;
		this.busconntel = busconntel;
		this.bankname = bankname;
		this.acctno = acctno;
		this.starttime = starttime;
		this.state = state;
		this.baillwrlmt = baillwrlmt;
	}

	/** full constructor */
	public ChDstCooperator(String cooperauid, String cooperaname,
			String cpabbrname, String cocheckname, String servman,
			String cooperadel, String postaddr, String zipcode, String conntel,
			String connfaxno, String usremail, Double area, String licenceid,
			Date licvalidate, String connpers, String busconntel,
			String sendaddr, String recpers, String recconntel,
			String reccertno, String smsmobileno, String bankname,
			String acctno, String districtid, Date intime, String custmanager,
			Date starttime, String servpwd, Short state, String oldcoopera,
			Double baillwrlmt, String memo, String waysubtype, String cityid,
			String countyid, String svccode, String mareacode,
			Double cashdeposit, Double cdradix) {
		this.cooperauid = cooperauid;
		this.cooperaname = cooperaname;
		this.cpabbrname = cpabbrname;
		this.cocheckname = cocheckname;
		this.servman = servman;
		this.cooperadel = cooperadel;
		this.postaddr = postaddr;
		this.zipcode = zipcode;
		this.conntel = conntel;
		this.connfaxno = connfaxno;
		this.usremail = usremail;
		this.area = area;
		this.licenceid = licenceid;
		this.licvalidate = licvalidate;
		this.connpers = connpers;
		this.busconntel = busconntel;
		this.sendaddr = sendaddr;
		this.recpers = recpers;
		this.recconntel = recconntel;
		this.reccertno = reccertno;
		this.smsmobileno = smsmobileno;
		this.bankname = bankname;
		this.acctno = acctno;
		this.districtid = districtid;
		this.intime = intime;
		this.custmanager = custmanager;
		this.starttime = starttime;
		this.servpwd = servpwd;
		this.state = state;
		this.oldcoopera = oldcoopera;
		this.baillwrlmt = baillwrlmt;
		this.memo = memo;
		this.waysubtype = waysubtype;
		this.cityid = cityid;
		this.countyid = countyid;
		this.svccode = svccode;
		this.mareacode = mareacode;
		this.cashdeposit = cashdeposit;
		this.cdradix = cdradix;
	}

	// Property accessors

	public String getCooperauid() {
		return this.cooperauid;
	}

	public void setCooperauid(String cooperauid) {
		this.cooperauid = cooperauid;
	}

	public String getCooperaname() {
		return this.cooperaname;
	}

	public void setCooperaname(String cooperaname) {
		this.cooperaname = cooperaname;
	}

	public String getCpabbrname() {
		return this.cpabbrname;
	}

	public void setCpabbrname(String cpabbrname) {
		this.cpabbrname = cpabbrname;
	}

	public String getCocheckname() {
		return this.cocheckname;
	}

	public void setCocheckname(String cocheckname) {
		this.cocheckname = cocheckname;
	}

	public String getServman() {
		return this.servman;
	}

	public void setServman(String servman) {
		this.servman = servman;
	}

	public String getCooperadel() {
		return this.cooperadel;
	}

	public void setCooperadel(String cooperadel) {
		this.cooperadel = cooperadel;
	}

	public String getPostaddr() {
		return this.postaddr;
	}

	public void setPostaddr(String postaddr) {
		this.postaddr = postaddr;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getConntel() {
		return this.conntel;
	}

	public void setConntel(String conntel) {
		this.conntel = conntel;
	}

	public String getConnfaxno() {
		return this.connfaxno;
	}

	public void setConnfaxno(String connfaxno) {
		this.connfaxno = connfaxno;
	}

	public String getUsremail() {
		return this.usremail;
	}

	public void setUsremail(String usremail) {
		this.usremail = usremail;
	}

	public Double getArea() {
		return this.area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getLicenceid() {
		return this.licenceid;
	}

	public void setLicenceid(String licenceid) {
		this.licenceid = licenceid;
	}

	public Date getLicvalidate() {
		return this.licvalidate;
	}

	public void setLicvalidate(Date licvalidate) {
		this.licvalidate = licvalidate;
	}

	public String getConnpers() {
		return this.connpers;
	}

	public void setConnpers(String connpers) {
		this.connpers = connpers;
	}

	public String getBusconntel() {
		return this.busconntel;
	}

	public void setBusconntel(String busconntel) {
		this.busconntel = busconntel;
	}

	public String getSendaddr() {
		return this.sendaddr;
	}

	public void setSendaddr(String sendaddr) {
		this.sendaddr = sendaddr;
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

	public String getSmsmobileno() {
		return this.smsmobileno;
	}

	public void setSmsmobileno(String smsmobileno) {
		this.smsmobileno = smsmobileno;
	}

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAcctno() {
		return this.acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public String getDistrictid() {
		return this.districtid;
	}

	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}

	public Date getIntime() {
		return this.intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public String getCustmanager() {
		return this.custmanager;
	}

	public void setCustmanager(String custmanager) {
		this.custmanager = custmanager;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getServpwd() {
		return this.servpwd;
	}

	public void setServpwd(String servpwd) {
		this.servpwd = servpwd;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getOldcoopera() {
		return this.oldcoopera;
	}

	public void setOldcoopera(String oldcoopera) {
		this.oldcoopera = oldcoopera;
	}

	public Double getBaillwrlmt() {
		return this.baillwrlmt;
	}

	public void setBaillwrlmt(Double baillwrlmt) {
		this.baillwrlmt = baillwrlmt;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getWaysubtype() {
		return this.waysubtype;
	}

	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
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

	public Double getCashdeposit() {
		return this.cashdeposit;
	}

	public void setCashdeposit(Double cashdeposit) {
		this.cashdeposit = cashdeposit;
	}

	public Double getCdradix() {
		return this.cdradix;
	}

	public void setCdradix(Double cdradix) {
		this.cdradix = cdradix;
	}

}