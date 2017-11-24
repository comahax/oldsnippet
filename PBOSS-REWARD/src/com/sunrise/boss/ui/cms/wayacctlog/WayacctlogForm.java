/**
 * auto-generated code
 * Wed Oct 18 14:55:37 CST 2006
 */
package com.sunrise.boss.ui.cms.wayacctlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogVO;

/**
 * <p>
 * Title: WayacctlogForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author He Kun
 * @version 1.0
 */
public class WayacctlogForm extends BaseActionForm {
	private String _dnl_optime;

	private String _dnm_optime;

	private String _sk_oprcode;

	private String _se_oprtype;

	private String _se_success;

	private Long logid;

	private java.util.Date optime;

	private String oprcode;

	private String oprtype;

	private String success;

	private Integer accid;

	private String wayid;

	private Short chargetype;

	private Short accttype;

	private String acctno;

	private String acctname;

	private String bankname;

	private String dsbank;

	private String bankaddr;

	private String contact;

	private String contel;

	private java.util.Date rectime;

	private java.util.Date starttime;

	private java.util.Date endtime;

	private String memo;

	private String bossarea;

	private String acctfid;

	public String getAcctfid() {
		return acctfid;
	}

	public void setAcctfid(String acctfid) {
		this.acctfid = acctfid;
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

	public String get_sk_oprcode() {
		return _sk_oprcode;
	}

	public void set_sk_oprcode(String _sk_oprcode) {
		this._sk_oprcode = _sk_oprcode;
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

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public java.util.Date getOptime() {
		return optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
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

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Integer getAccid() {
		return accid;
	}

	public void setAccid(Integer accid) {
		this.accid = accid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Short getChargetype() {
		return chargetype;
	}

	public void setChargetype(Short chargetype) {
		this.chargetype = chargetype;
	}

	public Short getAccttype() {
		return accttype;
	}

	public void setAccttype(Short accttype) {
		this.accttype = accttype;
	}

	public String getAcctno() {
		return acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public String getAcctname() {
		return acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getDsbank() {
		return dsbank;
	}

	public void setDsbank(String dsbank) {
		this.dsbank = dsbank;
	}

	public String getBankaddr() {
		return bankaddr;
	}

	public void setBankaddr(String bankaddr) {
		this.bankaddr = bankaddr;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContel() {
		return contel;
	}

	public void setContel(String contel) {
		this.contel = contel;
	}

	public java.util.Date getRectime() {
		return rectime;
	}

	public void setRectime(java.util.Date rectime) {
		this.rectime = rectime;
	}

	public java.util.Date getStarttime() {
		return starttime;
	}

	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}

	public java.util.Date getEndtime() {
		return endtime;
	}

	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getBossarea() {
		return bossarea;
	}

	public void setBossarea(String bossarea) {
		this.bossarea = bossarea;
	}

}
