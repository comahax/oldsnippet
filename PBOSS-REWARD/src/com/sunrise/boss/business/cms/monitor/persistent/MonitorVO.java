package com.sunrise.boss.business.cms.monitor.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MonitorVO implements Serializable {

    /** identifier field */
    private String abatchno;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String upperopnid;

    /** nullable persistent field */
    private java.util.Date lastdate;

    /** nullable persistent field */
    private Short status;

    /** nullable persistent field */
    private String conoprcode;

    /** nullable persistent field */
    private java.util.Date conoptime;
    
    private String paymonth;

    /** full constructor */
    public MonitorVO(java.lang.String abatchno, java.lang.Short cityid, java.lang.String rewardmonth, java.lang.String countyid, java.lang.String upperopnid, java.util.Date lastdate, java.lang.Short status, java.lang.String conoprcode, java.util.Date conoptime) {
        this.abatchno = abatchno;
        this.cityid = cityid;
        this.rewardmonth = rewardmonth;
        this.countyid = countyid;
        this.upperopnid = upperopnid;
        this.lastdate = lastdate;
        this.status = status;
        this.conoprcode = conoprcode;
        this.conoptime = conoptime;
    }

    public MonitorVO(String abatchno, Short cityid, String rewardmonth,
			String countyid, String upperopnid, Date lastdate, Short status,
			String conoprcode, Date conoptime, String paymonth) {
		super();
		this.abatchno = abatchno;
		this.cityid = cityid;
		this.rewardmonth = rewardmonth;
		this.countyid = countyid;
		this.upperopnid = upperopnid;
		this.lastdate = lastdate;
		this.status = status;
		this.conoprcode = conoprcode;
		this.conoptime = conoptime;
		this.paymonth = paymonth;
	}

	/** default constructor */
    public MonitorVO() {
    }

    /** minimal constructor */
    public MonitorVO(java.lang.String abatchno) {
        this.abatchno = abatchno;
    }

    public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public java.lang.String getAbatchno() {
        return this.abatchno;
    }

    public void setAbatchno(java.lang.String abatchno) {
        this.abatchno = abatchno;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getUpperopnid() {
        return this.upperopnid;
    }

    public void setUpperopnid(java.lang.String upperopnid) {
        this.upperopnid = upperopnid;
    }

    public java.util.Date getLastdate() {
        return this.lastdate;
    }

    public void setLastdate(java.util.Date lastdate) {
        this.lastdate = lastdate;
    }

    public java.lang.Short getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Short status) {
        this.status = status;
    }

    public java.lang.String getConoprcode() {
        return this.conoprcode;
    }

    public void setConoprcode(java.lang.String conoprcode) {
        this.conoprcode = conoprcode;
    }

    public java.util.Date getConoptime() {
        return this.conoptime;
    }

    public void setConoptime(java.util.Date conoptime) {
        this.conoptime = conoptime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("abatchno", getAbatchno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MonitorVO) ) return false;
        MonitorVO castOther = (MonitorVO) other;
        return new EqualsBuilder()
            .append(this.getAbatchno(), castOther.getAbatchno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAbatchno())
            .toHashCode();
    }

}
