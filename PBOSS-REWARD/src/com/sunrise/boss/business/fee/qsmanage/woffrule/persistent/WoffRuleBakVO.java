package com.sunrise.boss.business.fee.qsmanage.woffrule.persistent;


import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.pub.tools.PublicUtils;

/** @author Hibernate CodeGenerator */
public class WoffRuleBakVO implements Serializable {

    /** identifier field */
    private Long acctid;

    /** identifier field */
    private Long eboxunitid;

    /** nullable persistent field */
    private Short type;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private Long pri;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public WoffRuleBakVO(java.lang.Long acctid, java.lang.Long eboxunitid, java.lang.Short type, java.util.Date begintime, java.util.Date endtime, java.lang.Long pri, java.lang.String memo) {
        this.acctid = acctid;
        this.eboxunitid = eboxunitid;
        this.type = type;
        this.begintime = begintime;
        this.endtime = endtime;
        this.pri = pri;
        this.memo = memo;
    }

    /** default constructor */
    public WoffRuleBakVO() {
    }

    /** minimal constructor */
    public WoffRuleBakVO(java.lang.Long acctid, java.lang.Long eboxunitid) {
        this.acctid = acctid;
        this.eboxunitid = eboxunitid;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.Long getEboxunitid() {
        return this.eboxunitid;
    }

    public void setEboxunitid(java.lang.Long eboxunitid) {
        this.eboxunitid = eboxunitid;
    }

    public java.lang.Short getType() {
        return this.type;
    }

    public void setType(Short short1) {
        this.type = short1;
    }

    public java.util.Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }

    public java.lang.Long getPri() {
        return this.pri;
    }

    public void setPri(java.lang.Long pri) {
        this.pri = pri;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }
	private String strBegintime;
	
	private String strEndtime;

	public String getStrBegintime() {
		
		return PublicUtils.utilDateToStr(begintime);
	}

	public void setStrBegintime(String strBegintime) throws Exception {

		begintime=PublicUtils.UtilStrToDate(strBegintime);
		this.strBegintime = strBegintime;
	}
	public String getStrEndtime() {
		
		return PublicUtils.utilDateToStr(endtime);
	}

	public void setStrEndtime(String strEndtime) throws Exception {
		endtime=PublicUtils.UtilStrToDate(strEndtime);
			this.strEndtime = strEndtime;
	}
    public String toString() {
        StringBuffer buf = new StringBuffer();
		buf.append(this.getAcctid()).append("~").append(this.getEboxunitid()).append("~")
		.append(this.getType()).append("~").append(PublicUtils.utilDateToStr(this.getBegintime())).append("~")
		.append(PublicUtils.utilDateToStr(this.getEndtime())).append("~").append(this.getPri()).append("~")
		.append(this.getMemo()).append("~");
		return buf.toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WoffRuleBakVO) ) return false;
        WoffRuleBakVO castOther = (WoffRuleBakVO) other;
        return new EqualsBuilder()
            .append(this.getAcctid(), castOther.getAcctid())
            .append(this.getEboxunitid(), castOther.getEboxunitid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAcctid())
            .append(getEboxunitid())
            .toHashCode();
    }

}
