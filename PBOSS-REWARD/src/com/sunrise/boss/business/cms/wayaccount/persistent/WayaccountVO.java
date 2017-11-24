package com.sunrise.boss.business.cms.wayaccount.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.wayacctlog.persistent.*;
import com.sunrise.boss.business.common.dblog.*;

/** @author Hibernate CodeGenerator */
public class WayaccountVO implements OperationLog {

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
	private java.sql.Date rectime;

	/** nullable persistent field */
	private java.sql.Date starttime;

	/** nullable persistent field */
	private java.sql.Date endtime;

	/** nullable persistent field */
	private String memo;

	/** nullable persistent field */
	private String bossarea;

	private String acctfid;

	private String deacctno;

	private String deacctname;

	private String debankname;

	public String getAcctfid() {
		return acctfid;
	}

	public void setAcctfid(String acctfid) {
		this.acctfid = acctfid;
	}

	/** full constructor */
	public WayaccountVO(java.lang.Integer accid, java.lang.String wayid,
			java.lang.Short chargetype, java.lang.Short accttype,
			java.lang.String acctno, java.lang.String acctname,
			java.lang.String bankname, java.lang.String dsbank,
			java.lang.String bankaddr, java.lang.String contact,
			java.lang.String contel, java.sql.Date rectime,
			java.sql.Date starttime, java.sql.Date endtime,
			java.lang.String memo, java.lang.String bossarea, String acctfid) {
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
	}

	/** default constructor */
	public WayaccountVO() {
	}

	/** minimal constructor */
	public WayaccountVO(java.lang.Integer accid, java.lang.String wayid,
			java.lang.Short chargetype, java.lang.Short accttype,
			java.lang.String bankname) {
		this.accid = accid;
		this.wayid = wayid;
		this.chargetype = chargetype;
		this.accttype = accttype;
		this.bankname = bankname;
	}

	public java.lang.Integer getAccid() {
		return this.accid;
	}

	public void setAccid(java.lang.Integer accid) {
		this.accid = accid;
	}

	public java.lang.String getWayid() {
		return this.wayid;
	}

	public void setWayid(java.lang.String wayid) {
		this.wayid = wayid;
	}

	public java.lang.Short getChargetype() {
		return this.chargetype;
	}

	public void setChargetype(java.lang.Short chargetype) {
		this.chargetype = chargetype;
	}

	public java.lang.Short getAccttype() {
		return this.accttype;
	}

	public void setAccttype(java.lang.Short accttype) {
		this.accttype = accttype;
	}

	public java.lang.String getAcctno() {
		return this.acctno;
	}

	public void setAcctno(java.lang.String acctno) {
		this.acctno = acctno;
	}

	public java.lang.String getAcctname() {
		return this.acctname;
	}

	public void setAcctname(java.lang.String acctname) {
		this.acctname = acctname;
	}

	public java.lang.String getBankname() {
		return this.bankname;
	}

	public void setBankname(java.lang.String bankname) {
		this.bankname = bankname;
	}

	public java.lang.String getDsbank() {
		return this.dsbank;
	}

	public void setDsbank(java.lang.String dsbank) {
		this.dsbank = dsbank;
	}

	public java.lang.String getBankaddr() {
		return this.bankaddr;
	}

	public void setBankaddr(java.lang.String bankaddr) {
		this.bankaddr = bankaddr;
	}

	public java.lang.String getContact() {
		return this.contact;
	}

	public void setContact(java.lang.String contact) {
		this.contact = contact;
	}

	public java.lang.String getContel() {
		return this.contel;
	}

	public void setContel(java.lang.String contel) {
		this.contel = contel;
	}

	public java.sql.Date getRectime() {
		return this.rectime;
	}

	public void setRectime(java.sql.Date rectime) {
		this.rectime = rectime;
	}

	public java.sql.Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(java.sql.Date starttime) {
		this.starttime = starttime;
	}

	public java.sql.Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(java.sql.Date endtime) {
		this.endtime = endtime;
	}

	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public java.lang.String getBossarea() {
		return this.bossarea;
	}

	public void setBossarea(java.lang.String bossarea) {
		this.bossarea = bossarea;
	}

	public String toString() {
		return new ToStringBuilder(this).append("accid", getAccid()).append(
				"wayid", getWayid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof WayaccountVO))
			return false;
		WayaccountVO castOther = (WayaccountVO) other;
		return new EqualsBuilder()
				.append(this.getAccid(), castOther.getAccid()).append(
						this.getWayid(), castOther.getWayid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getAccid()).append(getWayid())
				.toHashCode();
	}

	public Class logVOClass() {
		return WayacctlogVO.class;
	}

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
}
