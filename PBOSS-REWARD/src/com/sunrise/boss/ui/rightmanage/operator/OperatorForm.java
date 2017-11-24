/**
 * auto-generated code
 * Sat Oct 21 11:05:47 CST 2006
 */
package com.sunrise.boss.ui.rightmanage.operator;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2VO;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>
 * Title: OperatorForm
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
public class OperatorForm extends BaseActionForm {

	/** identifier field */
	private String operid;

	private String _se_operid;

	/** nullable persistent field */
	private Integer region;

	private String _ne_region;

	/** persistent field */
	private String opername;

	private String _se_opername;

	/** nullable persistent field */
	private String password;

	/** persistent field */
	private java.util.Date passchgdate;

	/** nullable persistent field */
	private String opergroup;

	private String _se_opergroup;

	/** persistent field */
	private String opertype;

	private String _se_opertype;

	/** nullable persistent field */
	private String operlevel;

	private String _se_operlevel;

	/** persistent field */
	private Byte ismanager;

	private String _ne_ismanager;

	/** nullable persistent field */
	private String contactphone;

	/** persistent field */
	private String orgid;

	private String _se_orgid;

	/** persistent field */
	private Byte isrestrict;

	/** persistent field */
	private Short starttime;

	/** persistent field */
	private Short endtime;

	/** persistent field */
	private Byte enablegprs;

	/** persistent field */
	private Short gprsstarttime;

	/** persistent field */
	private Short gprsendtime;

	/** persistent field */
	private Byte ischkmac;

	/** nullable persistent field */
	private String mac;

	/** nullable persistent field */
	private String notes;

	/** persistent field */
	private java.util.Date createdate;

	/** persistent field */
	private Byte status;

	private String createdate2;

	private String statusdate2;

	/** nullable persistent field */
	private java.util.Date statusdate;

	public String getContactphone() {
		return contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public java.util.Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public Byte getEnablegprs() {
		return enablegprs;
	}

	public void setEnablegprs(Byte enablegprs) {
		this.enablegprs = enablegprs;
	}

	public Short getEndtime() {
		return endtime;
	}

	public void setEndtime(Short endtime) {
		this.endtime = endtime;
	}

	public Short getGprsendtime() {
		return gprsendtime;
	}

	public void setGprsendtime(Short gprsendtime) {
		this.gprsendtime = gprsendtime;
	}

	public Short getGprsstarttime() {
		return gprsstarttime;
	}

	public void setGprsstarttime(Short gprsstarttime) {
		this.gprsstarttime = gprsstarttime;
	}

	public Byte getIschkmac() {
		return ischkmac;
	}

	public void setIschkmac(Byte ischkmac) {
		this.ischkmac = ischkmac;
	}

	public Byte getIsmanager() {
		return ismanager;
	}

	public void setIsmanager(Byte ismanager) {
		this.ismanager = ismanager;
	}

	public Byte getIsrestrict() {
		return isrestrict;
	}

	public void setIsrestrict(Byte isrestrict) {
		this.isrestrict = isrestrict;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOpergroup() {
		return opergroup;
	}

	public void setOpergroup(String opergroup) {
		this.opergroup = opergroup;
	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getOperlevel() {
		return operlevel;
	}

	public void setOperlevel(String operlevel) {
		this.operlevel = operlevel;
	}

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public String getOpertype() {
		return opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public java.util.Date getPasschgdate() {
		return passchgdate;
	}

	public void setPasschgdate(java.util.Date passchgdate) {
		this.passchgdate = passchgdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public Short getStarttime() {
		return starttime;
	}

	public void setStarttime(Short starttime) {
		this.starttime = starttime;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public java.util.Date getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(java.util.Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getStatusdate2() {
		String str = PublicUtils.formatUtilDate(this.statusdate, "yyyy-MM-dd");
		if (str == null || str.equals("")) {
			return statusdate2;
		} else
			return str;
	}

	public void setStatusdate2(String statusdate2) {
		try {
			this.statusdate = PublicUtils.UtilStrToDate(statusdate2,
					"yyyy-MM-dd");
		} catch (Exception e) {
			this.statusdate = new Date();
		}
	}

	public String getCreatedate2() {
		String str = PublicUtils.formatUtilDate(this.createdate, "yyyy-MM-dd");
		if (str == null || str.equals("")) {
			return createdate2;
		} else
			return str;
	}

	public void setCreatedate2(String createdate2) {
		try {
			this.createdate = PublicUtils.UtilStrToDate(createdate2,
					"yyyy-MM-dd");
		} catch (Exception e) {
			this.createdate = new Date();
		}
	}

	public String get_ne_ismanager() {
		return _ne_ismanager;
	}

	public void set_ne_ismanager(String _ne_ismanager) {
		this._ne_ismanager = _ne_ismanager;
	}

	public String get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}

	public String get_se_opergroup() {
		return _se_opergroup;
	}

	public void set_se_opergroup(String _se_opergroup) {
		this._se_opergroup = _se_opergroup;
	}

	public String get_se_operid() {
		return _se_operid;
	}

	public void set_se_operid(String _se_operid) {
		this._se_operid = _se_operid;
	}

	public String get_se_operlevel() {
		return _se_operlevel;
	}

	public void set_se_operlevel(String _se_operlevel) {
		this._se_operlevel = _se_operlevel;
	}

	public String get_se_opername() {
		return _se_opername;
	}

	public void set_se_opername(String _se_opername) {
		this._se_opername = _se_opername;
	}

	public String get_se_opertype() {
		return _se_opertype;
	}

	public void set_se_opertype(String _se_opertype) {
		this._se_opertype = _se_opertype;
	}

	public String get_se_orgid() {
		return _se_orgid;
	}

	public void set_se_orgid(String _se_orgid) {
		this._se_orgid = _se_orgid;
	}
}
