package com.sunrise.boss.business.cms.audit.waittmp.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WaittmpVO implements Serializable {

    /** identifier field */
    private Long streamno;

    /** nullable persistent field */
    private Short smtype;

    /** nullable persistent field */
    private java.sql.Timestamp creattime;

    /** nullable persistent field */
    private java.sql.Timestamp dealtime;

    /** nullable persistent field */
    private String message;

    /** nullable persistent field */
    private String sendno;

    /** nullable persistent field */
    private String recno;

    /** nullable persistent field */
    private Short smprior;

    /** nullable persistent field */
    private Short smstatu;

    /** nullable persistent field */
    private Short limitflag;

    /** nullable persistent field */
    private String sndtime;

    /** nullable persistent field */
    private java.sql.Timestamp deadtime;

    /** nullable persistent field */
    private Short maxtimes;

    /** nullable persistent field */
    private Short havetimes;

    /** nullable persistent field */
    private String resultcode;

    /** nullable persistent field */
    private String resultdesc;
    
    private Short pktotal;
    private Short pknumber;
    
    private Long delaymin;
    

    /** full constructor */
    public WaittmpVO(java.lang.Long streamno, java.lang.Short smtype, java.sql.Timestamp creattime, java.sql.Timestamp dealtime, java.lang.String message, java.lang.String sendno, java.lang.String recno, java.lang.Short smprior, java.lang.Short smstatu, java.lang.Short limitflag, java.lang.String sndtime, java.sql.Timestamp deadtime, java.lang.Short maxtimes, java.lang.Short havetimes, java.lang.String resultcode, java.lang.String resultdesc) {
        this.streamno = streamno;
        this.smtype = smtype;
        this.creattime = creattime;
        this.dealtime = dealtime;
        this.message = message;
        this.sendno = sendno;
        this.recno = recno;
        this.smprior = smprior;
        this.smstatu = smstatu;
        this.limitflag = limitflag;
        this.sndtime = sndtime;
        this.deadtime = deadtime;
        this.maxtimes = maxtimes;
        this.havetimes = havetimes;
        this.resultcode = resultcode;
        this.resultdesc = resultdesc;
    }

    /** default constructor */
    public WaittmpVO() {
    }

    /** minimal constructor */
    public WaittmpVO(java.lang.Long streamno) {
        this.streamno = streamno;
    }

    public java.lang.Long getStreamno() {
        return this.streamno;
    }

    public void setStreamno(java.lang.Long streamno) {
        this.streamno = streamno;
    }

    public java.lang.Short getSmtype() {
        return this.smtype;
    }

    public void setSmtype(java.lang.Short smtype) {
        this.smtype = smtype;
    }

    public java.sql.Timestamp getCreattime() {
        return this.creattime;
    }

    public void setCreattime(java.sql.Timestamp creattime) {
        this.creattime = creattime;
    }

    public java.sql.Timestamp getDealtime() {
        return this.dealtime;
    }

    public void setDealtime(java.sql.Timestamp dealtime) {
        this.dealtime = dealtime;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    public java.lang.String getSendno() {
        return this.sendno;
    }

    public void setSendno(java.lang.String sendno) {
        this.sendno = sendno;
    }

    public java.lang.String getRecno() {
        return this.recno;
    }

    public void setRecno(java.lang.String recno) {
        this.recno = recno;
    }

    public java.lang.Short getSmprior() {
        return this.smprior;
    }

    public void setSmprior(java.lang.Short smprior) {
        this.smprior = smprior;
    }

    public java.lang.Short getSmstatu() {
        return this.smstatu;
    }

    public void setSmstatu(java.lang.Short smstatu) {
        this.smstatu = smstatu;
    }

    public java.lang.Short getLimitflag() {
        return this.limitflag;
    }

    public void setLimitflag(java.lang.Short limitflag) {
        this.limitflag = limitflag;
    }

    public java.lang.String getSndtime() {
        return this.sndtime;
    }

    public void setSndtime(java.lang.String sndtime) {
        this.sndtime = sndtime;
    }

    public java.sql.Timestamp getDeadtime() {
        return this.deadtime;
    }

    public void setDeadtime(java.sql.Timestamp deadtime) {
        this.deadtime = deadtime;
    }

    public java.lang.Short getMaxtimes() {
        return this.maxtimes;
    }

    public void setMaxtimes(java.lang.Short maxtimes) {
        this.maxtimes = maxtimes;
    }

    public java.lang.Short getHavetimes() {
        return this.havetimes;
    }

    public void setHavetimes(java.lang.Short havetimes) {
        this.havetimes = havetimes;
    }

    public java.lang.String getResultcode() {
        return this.resultcode;
    }

    public void setResultcode(java.lang.String resultcode) {
        this.resultcode = resultcode;
    }

    public java.lang.String getResultdesc() {
        return this.resultdesc;
    }

    public void setResultdesc(java.lang.String resultdesc) {
        this.resultdesc = resultdesc;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("streamno", getStreamno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaittmpVO) ) return false;
        WaittmpVO castOther = (WaittmpVO) other;
        return new EqualsBuilder()
            .append(this.getStreamno(), castOther.getStreamno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStreamno())
            .toHashCode();
    }

	public Short getPknumber() {
		return pknumber;
	}

	public void setPknumber(Short pknumber) {
		this.pknumber = pknumber;
	}

	public Short getPktotal() {
		return pktotal;
	}

	public void setPktotal(Short pktotal) {
		this.pktotal = pktotal;
	}

	public Long getDelaymin() {
		return delaymin;
	}

	public void setDelaymin(Long delaymin) {
		this.delaymin = delaymin;
	}

}
