/**
 * auto-generated code
 * Sat Aug 26 10:44:13 CST 2006
 */
package com.sunrise.boss.ui.cms.wayaccount;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: WayaccountForm
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
public class WayaccountForm extends BaseActionForm {
	private Integer _ne_accid;

	private String _se_wayid;

	/** identifier field */
	private Integer accid;

	/** identifier field */
	private String wayid;

	/** persistent field */
	private Short chargetype;

	/** persistent field */
	private Short accttype;

	/** nullable persistent field */
	private String acctno;

	/** nullable persistent field */
	private String acctname;

	/** persistent field */
	private String bankname;

	/** nullable persistent field */
	private String dsbank;

	/** nullable persistent field */
	private String bankaddr;

	/** nullable persistent field */
	private String contact;

	/** nullable persistent field */
	private String contel;

	/** nullable persistent field */
	private java.util.Date rectime;

	/** nullable persistent field */
	private java.util.Date starttime;

	/** nullable persistent field */
	private java.util.Date endtime;

	/** nullable persistent field */
	private String memo;

	/** nullable persistent field */
	private String bossarea;

	private String acctfid;

	// ÐÂÔö
	private String subtype;

	private String deacctno;

	private String deacctname;

	private String debankname;

	public String getDeacctname() {
		return deacctname;
	}

	public void setDeacctname(String deacctname) {
		this.deacctname = deacctname;
	}

	public String getDeacctno() {
		return deacctno;
	}

	public void setDeacctno(String deacctno) {
		this.deacctno = deacctno;
	}

	public String getDebankname() {
		return debankname;
	}

	public void setDebankname(String debankname) {
		this.debankname = debankname;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getAcctfid() {
		return acctfid;
	}

	public void setAcctfid(String acctfid) {
		this.acctfid = acctfid;
	}

	/**
	 * @return Returns the _ne_accid.
	 */
	public Integer get_ne_accid() {
		return _ne_accid;
	}

	/**
	 * @param _ne_accid
	 *            The _ne_accid to set.
	 */
	public void set_ne_accid(Integer _ne_accid) {
		this._ne_accid = _ne_accid;
	}

	/**
	 * @return Returns the _se_wayid.
	 */
	public String get_se_wayid() {
		return _se_wayid;
	}

	/**
	 * @param _se_wayid
	 *            The _se_wayid to set.
	 */
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	/**
	 * @return Returns the accid.
	 */
	public Integer getAccid() {
		return accid;
	}

	/**
	 * @param accid
	 *            The accid to set.
	 */
	public void setAccid(Integer accid) {
		this.accid = accid;
	}

	/**
	 * @return Returns the acctname.
	 */
	public String getAcctname() {
		return acctname;
	}

	/**
	 * @param acctname
	 *            The acctname to set.
	 */
	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	/**
	 * @return Returns the acctno.
	 */
	public String getAcctno() {
		return acctno;
	}

	/**
	 * @param acctno
	 *            The acctno to set.
	 */
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	/**
	 * @return Returns the accttype.
	 */
	public Short getAccttype() {
		return accttype;
	}

	/**
	 * @param accttype
	 *            The accttype to set.
	 */
	public void setAccttype(Short accttype) {
		this.accttype = accttype;
	}

	/**
	 * @return Returns the bankaddr.
	 */
	public String getBankaddr() {
		return bankaddr;
	}

	/**
	 * @param bankaddr
	 *            The bankaddr to set.
	 */
	public void setBankaddr(String bankaddr) {
		this.bankaddr = bankaddr;
	}

	/**
	 * @return Returns the bankname.
	 */
	public String getBankname() {
		return bankname;
	}

	/**
	 * @param bankname
	 *            The bankname to set.
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	/**
	 * @return Returns the bossarea.
	 */
	public String getBossarea() {
		return bossarea;
	}

	/**
	 * @param bossarea
	 *            The bossarea to set.
	 */
	public void setBossarea(String bossarea) {
		this.bossarea = bossarea;
	}

	/**
	 * @return Returns the chargetype.
	 */
	public Short getChargetype() {
		return chargetype;
	}

	/**
	 * @param chargetype
	 *            The chargetype to set.
	 */
	public void setChargetype(Short chargetype) {
		this.chargetype = chargetype;
	}

	/**
	 * @return Returns the contact.
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            The contact to set.
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return Returns the contel.
	 */
	public String getContel() {
		return contel;
	}

	/**
	 * @param contel
	 *            The contel to set.
	 */
	public void setContel(String contel) {
		this.contel = contel;
	}

	/**
	 * @return Returns the dsbank.
	 */
	public String getDsbank() {
		return dsbank;
	}

	/**
	 * @param dsbank
	 *            The dsbank to set.
	 */
	public void setDsbank(String dsbank) {
		this.dsbank = dsbank;
	}

	/**
	 * @return Returns the endtime.
	 */
	public java.util.Date getEndtime() {
		return endtime;
	}

	/**
	 * @param endtime
	 *            The endtime to set.
	 */
	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}

	/**
	 * @return Returns the memo.
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            The memo to set.
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return Returns the rectime.
	 */
	public java.util.Date getRectime() {
		return rectime;
	}

	/**
	 * @param rectime
	 *            The rectime to set.
	 */
	public void setRectime(java.util.Date rectime) {
		this.rectime = rectime;
	}

	/**
	 * @return Returns the starttime.
	 */
	public java.util.Date getStarttime() {
		return starttime;
	}

	/**
	 * @param starttime
	 *            The starttime to set.
	 */
	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return Returns the wayid.
	 */
	public String getWayid() {
		return wayid;
	}

	/**
	 * @param wayid
	 *            The wayid to set.
	 */
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

}
