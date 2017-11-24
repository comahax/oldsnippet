package com.gmcc.pboss.business.channel.wayaccount;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class WayaccountVO extends BaseVO implements Serializable ,BusinessLog{

    /** identifier field */
    private Integer accid;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Short chargetype;

    /** nullable persistent field */
    private Short accttype;

    /** nullable persistent field */
    private String acctno;

    /** nullable persistent field */
    private String acctname;

    /** nullable persistent field */
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

    /** nullable persistent field */
    private String acctfid;

    /** nullable persistent field */
    private String deacctno;

    /** nullable persistent field */
    private String deacctname;

    /** nullable persistent field */
    private String debankname;
    
    private String debankid;

	private Byte destate;

    /** full constructor */
    public WayaccountVO(java.lang.Integer accid, java.lang.String wayid, java.lang.Short chargetype, java.lang.Short accttype, java.lang.String acctno, java.lang.String acctname, java.lang.String bankname, java.lang.String dsbank, java.lang.String bankaddr, java.lang.String contact, java.lang.String contel, java.util.Date rectime, java.util.Date starttime, java.util.Date endtime, java.lang.String memo, java.lang.String bossarea, java.lang.String acctfid, java.lang.String deacctno, java.lang.String deacctname, java.lang.String debankname) {
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

    /** default constructor */
    public WayaccountVO() {
    }

    /** minimal constructor */
    public WayaccountVO(java.lang.Integer accid, java.lang.String wayid) {
        this.accid = accid;
        this.wayid = wayid;
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

    public java.util.Date getRectime() {
        return this.rectime;
    }

    public void setRectime(java.util.Date rectime) {
        this.rectime = rectime;
    }

    public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
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

    public java.lang.String getAcctfid() {
        return this.acctfid;
    }

    public void setAcctfid(java.lang.String acctfid) {
        this.acctfid = acctfid;
    }

    public java.lang.String getDeacctno() {
        return this.deacctno;
    }

    public void setDeacctno(java.lang.String deacctno) {
        this.deacctno = deacctno;
    }

    public java.lang.String getDeacctname() {
        return this.deacctname;
    }

    public void setDeacctname(java.lang.String deacctname) {
        this.deacctname = deacctname;
    }

    public java.lang.String getDebankname() {
        return this.debankname;
    }

    public void setDebankname(java.lang.String debankname) {
        this.debankname = debankname;
    }

    public String getDebankid() {
		return debankid;
	}

	public void setDebankid(String debankid) {
		this.debankid = debankid;
	}

	public Byte getDestate() {
		return destate;
	}

	public void setDestate(Byte destate) {
		this.destate = destate;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("accid", getAccid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayaccountVO) ) return false;
        WayaccountVO castOther = (WayaccountVO) other;
        return new EqualsBuilder()
            .append(this.getAccid(), castOther.getAccid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAccid())
            .append(getWayid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return WayacctlogVO.class;
    }

}
