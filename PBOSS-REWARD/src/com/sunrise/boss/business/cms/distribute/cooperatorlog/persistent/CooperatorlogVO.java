package com.sunrise.boss.business.cms.distribute.cooperatorlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CooperatorlogVO implements Serializable {

	/** identifier field */
	private Long logid;

	/** persistent field */
	private String oprcode;

	/** persistent field */
	private java.util.Date optime;

	/** persistent field */
	private String oprtype;

	/** nullable persistent field */
	private String success;

	/** persistent field */
	private String cooperauid;

	/** persistent field */
	private String cooperaname;

	/** nullable persistent field */
	private String cpabbrname;

	/** nullable persistent field */
	private String cocheckname;

	/** persistent field */
	private String cooperadel;

	/** persistent field */
	private String postaddr;

	/** persistent field */
	private String zipcode;

	/** persistent field */
	private String conntel;

	/** persistent field */
	private String connfaxno;

	/** persistent field */
	private String usremail;

	/** persistent field */
	private Double area;

	/** persistent field */
	private String licenceid;

	/** persistent field */
	private java.util.Date licvalidate;

	/** persistent field */
	private String connpers;

	/** persistent field */
	private String busconntel;

	/** persistent field */
	private String sendaddr;

	/** persistent field */
	private String recpers;

	/** persistent field */
	private String recconntel;

	/** persistent field */
	private String reccertno;

	/** persistent field */
	private String smsmobileno;

	/** persistent field */
	private String bankname;

	/** persistent field */
	private String acctno;

	/** nullable persistent field */
	private Short districtid;

	/** persistent field */
	private java.util.Date intime;

	/** persistent field */
	private String custmanager;

	/** persistent field */
	private java.util.Date starttime;

	/** persistent field */
	private String servpwd;

	/** persistent field */
	private Short state;

	/** nullable persistent field */
	private String oldcoopera;

	private Double baillwrlmt;

	private String servman;

	/** nullable persistent field */
	private String memo;

	// 新增加五个字段
	private String waysubtype;

	private String cityid;

	private String countyid;

	private String svccode;

	private String mareacode;
	
	private Double cashdeposit;
	
	private Double cdradix;

	/** full constructor */
	public CooperatorlogVO(java.lang.String oprcode, java.util.Date optime,
			java.lang.String oprtype, java.lang.String success,
			java.lang.String cooperauid, java.lang.String cooperaname,
			java.lang.String cpabbrname, java.lang.String cocheckname,
			java.lang.String cooperadel, java.lang.String postaddr,
			java.lang.String zipcode, java.lang.String conntel,
			java.lang.String connfaxno, java.lang.String usremail,
			java.lang.Double area, java.lang.String licenceid,
			java.util.Date licvalidate, java.lang.String connpers,
			java.lang.String busconntel, java.lang.String sendaddr,
			java.lang.String recpers, java.lang.String recconntel,
			java.lang.String reccertno, java.lang.String smsmobileno,
			java.lang.String bankname, java.lang.String acctno,
			java.lang.Short districtid, java.util.Date intime,
			java.lang.String custmanager, java.util.Date starttime,
			java.lang.String servpwd, java.lang.Short state,
			java.lang.String oldcoopera, java.lang.String memo) {
		this.oprcode = oprcode;
		this.optime = optime;
		this.oprtype = oprtype;
		this.success = success;
		this.cooperauid = cooperauid;
		this.cooperaname = cooperaname;
		this.cpabbrname = cpabbrname;
		this.cocheckname = cocheckname;
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
		this.memo = memo;
	}

	/** default constructor */
	public CooperatorlogVO() {
	}

	/** minimal constructor */
	public CooperatorlogVO(java.lang.String oprcode, java.util.Date optime,
			java.lang.String oprtype, java.lang.String cooperauid,
			java.lang.String cooperaname, java.lang.String cooperadel,
			java.lang.String postaddr, java.lang.String zipcode,
			java.lang.String conntel, java.lang.String connfaxno,
			java.lang.String usremail, java.lang.Double area,
			java.lang.String licenceid, java.util.Date licvalidate,
			java.lang.String connpers, java.lang.String busconntel,
			java.lang.String sendaddr, java.lang.String recpers,
			java.lang.String recconntel, java.lang.String reccertno,
			java.lang.String smsmobileno, java.lang.String bankname,
			java.lang.String acctno, java.util.Date intime,
			java.lang.String custmanager, java.util.Date starttime,
			java.lang.String servpwd, java.lang.Short state) {
		this.oprcode = oprcode;
		this.optime = optime;
		this.oprtype = oprtype;
		this.cooperauid = cooperauid;
		this.cooperaname = cooperaname;
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
		this.intime = intime;
		this.custmanager = custmanager;
		this.starttime = starttime;
		this.servpwd = servpwd;
		this.state = state;
	}
	
	public Double getCashdeposit() {
		return cashdeposit;
	}

	public void setCashdeposit(Double cashdeposit) {
		this.cashdeposit = cashdeposit;
	}

	public Double getCdradix() {
		return cdradix;
	}

	public void setCdradix(Double cdradix) {
		this.cdradix = cdradix;
	}

	public java.lang.Long getLogid() {
		return this.logid;
	}

	public void setLogid(java.lang.Long logid) {
		this.logid = logid;
	}

	public java.lang.String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(java.lang.String oprcode) {
		this.oprcode = oprcode;
	}

	public java.util.Date getOptime() {
		return this.optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
	}

	public java.lang.String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(java.lang.String oprtype) {
		this.oprtype = oprtype;
	}

	public java.lang.String getSuccess() {
		return this.success;
	}

	public void setSuccess(java.lang.String success) {
		this.success = success;
	}

	public java.lang.String getCooperauid() {
		return this.cooperauid;
	}

	public void setCooperauid(java.lang.String cooperauid) {
		this.cooperauid = cooperauid;
	}

	public java.lang.String getCooperaname() {
		return this.cooperaname;
	}

	public void setCooperaname(java.lang.String cooperaname) {
		this.cooperaname = cooperaname;
	}

	public java.lang.String getCpabbrname() {
		return this.cpabbrname;
	}

	public void setCpabbrname(java.lang.String cpabbrname) {
		this.cpabbrname = cpabbrname;
	}

	public java.lang.String getCocheckname() {
		return this.cocheckname;
	}

	public void setCocheckname(java.lang.String cocheckname) {
		this.cocheckname = cocheckname;
	}

	public java.lang.String getCooperadel() {
		return this.cooperadel;
	}

	public void setCooperadel(java.lang.String cooperadel) {
		this.cooperadel = cooperadel;
	}

	public java.lang.String getPostaddr() {
		return this.postaddr;
	}

	public void setPostaddr(java.lang.String postaddr) {
		this.postaddr = postaddr;
	}

	public java.lang.String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(java.lang.String zipcode) {
		this.zipcode = zipcode;
	}

	public java.lang.String getConntel() {
		return this.conntel;
	}

	public void setConntel(java.lang.String conntel) {
		this.conntel = conntel;
	}

	public java.lang.String getConnfaxno() {
		return this.connfaxno;
	}

	public void setConnfaxno(java.lang.String connfaxno) {
		this.connfaxno = connfaxno;
	}

	public java.lang.String getUsremail() {
		return this.usremail;
	}

	public void setUsremail(java.lang.String usremail) {
		this.usremail = usremail;
	}

	public java.lang.Double getArea() {
		return this.area;
	}

	public void setArea(java.lang.Double area) {
		this.area = area;
	}

	public java.lang.String getLicenceid() {
		return this.licenceid;
	}

	public void setLicenceid(java.lang.String licenceid) {
		this.licenceid = licenceid;
	}

	public java.util.Date getLicvalidate() {
		return this.licvalidate;
	}

	public void setLicvalidate(java.util.Date licvalidate) {
		this.licvalidate = licvalidate;
	}

	public java.lang.String getConnpers() {
		return this.connpers;
	}

	public void setConnpers(java.lang.String connpers) {
		this.connpers = connpers;
	}

	public java.lang.String getBusconntel() {
		return this.busconntel;
	}

	public void setBusconntel(java.lang.String busconntel) {
		this.busconntel = busconntel;
	}

	public java.lang.String getSendaddr() {
		return this.sendaddr;
	}

	public void setSendaddr(java.lang.String sendaddr) {
		this.sendaddr = sendaddr;
	}

	public java.lang.String getRecpers() {
		return this.recpers;
	}

	public void setRecpers(java.lang.String recpers) {
		this.recpers = recpers;
	}

	public java.lang.String getRecconntel() {
		return this.recconntel;
	}

	public void setRecconntel(java.lang.String recconntel) {
		this.recconntel = recconntel;
	}

	public java.lang.String getReccertno() {
		return this.reccertno;
	}

	public void setReccertno(java.lang.String reccertno) {
		this.reccertno = reccertno;
	}

	public java.lang.String getSmsmobileno() {
		return this.smsmobileno;
	}

	public void setSmsmobileno(java.lang.String smsmobileno) {
		this.smsmobileno = smsmobileno;
	}

	public java.lang.String getBankname() {
		return this.bankname;
	}

	public void setBankname(java.lang.String bankname) {
		this.bankname = bankname;
	}

	public java.lang.String getAcctno() {
		return this.acctno;
	}

	public void setAcctno(java.lang.String acctno) {
		this.acctno = acctno;
	}

	public java.lang.Short getDistrictid() {
		return this.districtid;
	}

	public void setDistrictid(java.lang.Short districtid) {
		this.districtid = districtid;
	}

	public java.util.Date getIntime() {
		return this.intime;
	}

	public void setIntime(java.util.Date intime) {
		this.intime = intime;
	}

	public java.lang.String getCustmanager() {
		return this.custmanager;
	}

	public void setCustmanager(java.lang.String custmanager) {
		this.custmanager = custmanager;
	}

	public java.util.Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}

	public java.lang.String getServpwd() {
		return this.servpwd;
	}

	public void setServpwd(java.lang.String servpwd) {
		this.servpwd = servpwd;
	}

	public java.lang.Short getState() {
		return this.state;
	}

	public void setState(java.lang.Short state) {
		this.state = state;
	}

	public java.lang.String getOldcoopera() {
		return this.oldcoopera;
	}

	public void setOldcoopera(java.lang.String oldcoopera) {
		this.oldcoopera = oldcoopera;
	}

	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public String toString() {
		return new ToStringBuilder(this).append("logid", getLogid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof CooperatorlogVO))
			return false;
		CooperatorlogVO castOther = (CooperatorlogVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}

	public Double getBaillwrlmt() {
		return baillwrlmt;
	}

	public void setBaillwrlmt(Double baillwrlmt) {
		this.baillwrlmt = baillwrlmt;
	}

	public String getServman() {
		return servman;
	}

	public void setServman(String servman) {
		this.servman = servman;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getWaysubtype() {
		return waysubtype;
	}

	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
	}

}
