/**
 * auto-generated code
 * Tue Dec 26 19:35:31 CST 2006
 */
package com.sunrise.boss.ui.cms.distribute.cooperator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.common.utils.PWDHandle;

/**
 * <p>
 * Title: CooperatorForm
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
public class CooperatorForm extends BaseActionForm {
	// LIST查询调价
	private String _sk_cooperauid; // =合作商编号

	private String _sk_cooperaname; // like 合作商名称

	private String _sk_cpabbrname; // 合作商简称

	private String _se_state; // 合作商状态

	private String _se_districtid; // 所属营业区域

	// SELECTCOOPERATOR 过滤
	// private String _nne_state;

	// EDIT属性
	// private String againpassword;
	// private String newpassword;

	/** identifier field */
	private String cooperauid;

	/** persistent field */
	private String cooperaname;

	/** persistent field */
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

	/** persistent field */
	private String districtid;

	/** persistent field */
	private java.util.Date intime;

	/** persistent field */
	private String custmanager;

	/** persistent field */
	private java.util.Date starttime;

	/** persistent field */
	private String servpwd = "123456";

	/** persistent field */
	private Short state;

	/** persistent field */
	private String oldcoopera;

	private Double baillwrlmt = new Double(100);

	// 合作商负责人
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
	public CooperatorForm(java.lang.String cooperauid,
			java.lang.String cooperaname, java.lang.String cpabbrname,
			java.lang.String cocheckname, java.lang.String cooperadel,
			java.lang.String postaddr, java.lang.String zipcode,
			java.lang.String conntel, java.lang.String connfaxno,
			java.lang.String usremail, java.lang.Double area,
			java.lang.String licenceid, java.util.Date licvalidate,
			java.lang.String connpers, java.lang.String busconntel,
			java.lang.String sendaddr, java.lang.String recpers,
			java.lang.String recconntel, java.lang.String reccertno,
			java.lang.String smsmobileno, java.lang.String bankname,
			java.lang.String acctno, java.lang.String districtid,
			java.util.Date intime, java.lang.String custmanager,
			java.util.Date starttime, java.lang.String servpwd,
			java.lang.Short state, java.lang.String oldcoopera,
			java.lang.String memo) {
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
		if (servpwd != null && !"".equals(servpwd)) {
			this.servpwd = PWDHandle.decrypt(servpwd);
		} else {
			this.servpwd = servpwd;
		}
		this.state = state;
		this.oldcoopera = oldcoopera;
		this.memo = memo;
	}

	/** default constructor */
	public CooperatorForm() {
	}

	/** minimal constructor */
	public CooperatorForm(java.lang.String cooperauid,
			java.lang.String cooperaname, java.lang.String cpabbrname,
			java.lang.String cooperadel, java.lang.String postaddr,
			java.lang.String zipcode, java.lang.String conntel,
			java.lang.String connfaxno, java.lang.String usremail,
			java.lang.Double area, java.lang.String licenceid,
			java.util.Date licvalidate, java.lang.String connpers,
			java.lang.String busconntel, java.lang.String sendaddr,
			java.lang.String recpers, java.lang.String recconntel,
			java.lang.String reccertno, java.lang.String smsmobileno,
			java.lang.String bankname, java.lang.String acctno,
			java.lang.String districtid, java.util.Date intime,
			java.lang.String custmanager, java.util.Date starttime,
			java.lang.String servpwd, java.lang.Short state,
			java.lang.String oldcoopera) {
		this.cooperauid = cooperauid;
		this.cooperaname = cooperaname;
		this.cpabbrname = cpabbrname;
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
		if (servpwd != null && !"".equals(servpwd)) {
			this.servpwd = PWDHandle.decrypt(servpwd);
		} else {
			this.servpwd = servpwd;
		}
		this.state = state;
		this.oldcoopera = oldcoopera;
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

	public java.lang.String getDistrictid() {
		return this.districtid;
	}

	public void setDistrictid(java.lang.String districtid) {
		this.districtid = districtid;
	}

	public java.util.Date getIntime() {
		return this.intime;
	}

	public void setIntime(java.util.Date intime) {
		this.intime = intime;
	}

	public String getCustmanager() {
		return custmanager;
	}

	public void setCustmanager(String custmanager) {
		this.custmanager = custmanager;
	}

	public java.util.Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}

	public java.lang.String getServpwd() {
		return PWDHandle.encrypt(servpwd);
	}

	public void setServpwd(java.lang.String servpwd) {
		if (servpwd != null && !"".equals(servpwd)) {
			this.servpwd = PWDHandle.decrypt(servpwd);
		} else {
			this.servpwd = servpwd;
		}
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
		return new ToStringBuilder(this).append("cooperauid", getCooperauid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof CooperatorVO))
			return false;
		CooperatorVO castOther = (CooperatorVO) other;
		return new EqualsBuilder().append(this.getCooperauid(),
				castOther.getCooperauid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCooperauid()).toHashCode();
	}

	public String get_sk_cooperaname() {
		return _sk_cooperaname;
	}

	public void set_sk_cooperaname(String _sk_cooperaname) {
		this._sk_cooperaname = _sk_cooperaname;
	}

	public String get_sk_cooperauid() {
		return _sk_cooperauid;
	}

	public void set_sk_cooperauid(String _sk_cooperauid) {
		this._sk_cooperauid = _sk_cooperauid;
	}

	public String get_sk_cpabbrname() {
		return _sk_cpabbrname;
	}

	public void set_sk_cpabbrname(String _sk_cpabbrname) {
		this._sk_cpabbrname = _sk_cpabbrname;
	}

	public String get_se_state() {
		return _se_state;
	}

	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}

	public String get_se_districtid() {
		return _se_districtid;
	}

	public void set_se_districtid(String _se_districtid) {
		this._se_districtid = _se_districtid;
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
