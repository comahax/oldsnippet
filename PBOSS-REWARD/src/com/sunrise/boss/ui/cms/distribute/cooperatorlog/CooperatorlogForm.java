/**
 * auto-generated code
 * Thu Dec 28 19:50:30 CST 2006
 */
package com.sunrise.boss.ui.cms.distribute.cooperatorlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.persistent.CooperatorlogVO;

/**
 * <p>
 * Title: CooperatorlogForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class CooperatorlogForm extends BaseActionForm {
	private String _dnl_optime;

	private String _dnm_optime;

	private String _sk_oprcode;

	private String _se_oprtype;

	private String _se_success;

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

	public String get_dnl_optime() {
		return _dnl_optime;
	}

	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}

	public String get_dnm_optime() {
		return _dnm_optime;
	}

	public void set_dnm_optime(String _dnm_optime) {
		this._dnm_optime = _dnm_optime;
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_success() {
		return _se_success;
	}

	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}

	public String get_sk_oprcode() {
		return _sk_oprcode;
	}

	public void set_sk_oprcode(String _sk_oprcode) {
		this._sk_oprcode = _sk_oprcode;
	}

	public String getAcctno() {
		return acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBusconntel() {
		return busconntel;
	}

	public void setBusconntel(String busconntel) {
		this.busconntel = busconntel;
	}

	public String getCocheckname() {
		return cocheckname;
	}

	public void setCocheckname(String cocheckname) {
		this.cocheckname = cocheckname;
	}

	public String getConnfaxno() {
		return connfaxno;
	}

	public void setConnfaxno(String connfaxno) {
		this.connfaxno = connfaxno;
	}

	public String getConnpers() {
		return connpers;
	}

	public void setConnpers(String connpers) {
		this.connpers = connpers;
	}

	public String getConntel() {
		return conntel;
	}

	public void setConntel(String conntel) {
		this.conntel = conntel;
	}

	public String getCooperadel() {
		return cooperadel;
	}

	public void setCooperadel(String cooperadel) {
		this.cooperadel = cooperadel;
	}

	public String getCooperaname() {
		return cooperaname;
	}

	public void setCooperaname(String cooperaname) {
		this.cooperaname = cooperaname;
	}

	public String getCooperauid() {
		return cooperauid;
	}

	public void setCooperauid(String cooperauid) {
		this.cooperauid = cooperauid;
	}

	public String getCpabbrname() {
		return cpabbrname;
	}

	public void setCpabbrname(String cpabbrname) {
		this.cpabbrname = cpabbrname;
	}

	public String getCustmanager() {
		return custmanager;
	}

	public void setCustmanager(String custmanager) {
		this.custmanager = custmanager;
	}

	public Short getDistrictid() {
		return districtid;
	}

	public void setDistrictid(Short districtid) {
		this.districtid = districtid;
	}

	public java.util.Date getIntime() {
		return intime;
	}

	public void setIntime(java.util.Date intime) {
		this.intime = intime;
	}

	public String getLicenceid() {
		return licenceid;
	}

	public void setLicenceid(String licenceid) {
		this.licenceid = licenceid;
	}

	public java.util.Date getLicvalidate() {
		return licvalidate;
	}

	public void setLicvalidate(java.util.Date licvalidate) {
		this.licvalidate = licvalidate;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOldcoopera() {
		return oldcoopera;
	}

	public void setOldcoopera(String oldcoopera) {
		this.oldcoopera = oldcoopera;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public java.util.Date getOptime() {
		return optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
	}

	public String getPostaddr() {
		return postaddr;
	}

	public void setPostaddr(String postaddr) {
		this.postaddr = postaddr;
	}

	public String getReccertno() {
		return reccertno;
	}

	public void setReccertno(String reccertno) {
		this.reccertno = reccertno;
	}

	public String getRecconntel() {
		return recconntel;
	}

	public void setRecconntel(String recconntel) {
		this.recconntel = recconntel;
	}

	public String getRecpers() {
		return recpers;
	}

	public void setRecpers(String recpers) {
		this.recpers = recpers;
	}

	public String getSendaddr() {
		return sendaddr;
	}

	public void setSendaddr(String sendaddr) {
		this.sendaddr = sendaddr;
	}

	public String getServpwd() {
		return servpwd;
	}

	public void setServpwd(String servpwd) {
		this.servpwd = servpwd;
	}

	public String getSmsmobileno() {
		return smsmobileno;
	}

	public void setSmsmobileno(String smsmobileno) {
		this.smsmobileno = smsmobileno;
	}

	public java.util.Date getStarttime() {
		return starttime;
	}

	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getUsremail() {
		return usremail;
	}

	public void setUsremail(String usremail) {
		this.usremail = usremail;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
