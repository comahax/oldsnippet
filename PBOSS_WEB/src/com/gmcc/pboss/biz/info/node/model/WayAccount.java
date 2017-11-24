package com.gmcc.pboss.biz.info.node.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ChPwWayaccount entity. @author MyEclipse Persistence Tools
 */

public class WayAccount implements java.io.Serializable {

	// Fields

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
	private Date rectime;
	private Date starttime;
	private Date endtime;
	private String memo;
	private String bossarea;
	private String acctfid;
	private String deacctno;
	private String deacctname;
	private String debankname;
	//手工更新
	private String debankid;
	private Boolean destate;

	// Constructors

	/** default constructor */
	public WayAccount() {
	}

	/** full constructor */
	public WayAccount(Integer accid, String wayid, Short chargetype, Short accttype, String acctno, String acctname, String bankname, String dsbank,
			String bankaddr, String contact, String contel, Date rectime, Date starttime, Date endtime, String memo, String bossarea, String acctfid,
			String deacctno, String deacctname, String debankname) {
		this.accid = accid;
		this.wayid = wayid;
		this.chargetype = chargetype;
		this.accttype = accttype;
		this.acctno = acctno;
		this.acctname = acctname;
		this.bankname = bankname;
		this.dsbank = dsbank;
		this.bankaddr = bankaddr;
		this.contact = contact;
		this.contel = contel;
		this.rectime = rectime;
		this.starttime = starttime;
		this.endtime = endtime;
		this.memo = memo;
		this.bossarea = bossarea;
		this.acctfid = acctfid;
		this.deacctno = deacctno;
		this.deacctname = deacctname;
		this.debankname = debankname;
	}

	// Property accessors

	public Short getChargetype() {
		return this.chargetype;
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

	public void setChargetype(Short chargetype) {
		this.chargetype = chargetype;
	}

	public Short getAccttype() {
		return this.accttype;
	}

	public void setAccttype(Short accttype) {
		this.accttype = accttype;
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

	public String getDsbank() {
		return this.dsbank;
	}

	public void setDsbank(String dsbank) {
		this.dsbank = dsbank;
	}

	public String getBankaddr() {
		return this.bankaddr;
	}

	public void setBankaddr(String bankaddr) {
		this.bankaddr = bankaddr;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContel() {
		return this.contel;
	}

	public void setContel(String contel) {
		this.contel = contel;
	}

	public Date getRectime() {
		return this.rectime;
	}

	public void setRectime(Date rectime) {
		this.rectime = rectime;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getBossarea() {
		return this.bossarea;
	}

	public void setBossarea(String bossarea) {
		this.bossarea = bossarea;
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

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * @return the debankid
	 */
	public String getDebankid() {
		return debankid;
	}

	/**
	 * @param debankid the debankid to set
	 */
	public void setDebankid(String debankid) {
		this.debankid = debankid;
	}

	/**
	 * @return the destate
	 */
	public Boolean getDestate() {
		return destate;
	}

	/**
	 * @param destate the destate to set
	 */
	public void setDestate(Boolean destate) {
		this.destate = destate;
	}

}