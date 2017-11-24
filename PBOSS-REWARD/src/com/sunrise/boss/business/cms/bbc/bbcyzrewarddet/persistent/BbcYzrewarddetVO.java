package com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BbcYzrewarddetVO implements Serializable {

    /** identifier field */
    private String batchno;

    /** identifier field */
    private String cityid;

    /** identifier field */
    private Long rptmon;

    /** identifier field */
    private Integer tztype;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Integer num;

    /** nullable persistent field */
    private java.lang.Double yzreward;

    /** nullable persistent field */
    private java.lang.Double adjreward;

    /** full constructor */
    public BbcYzrewarddetVO(java.lang.String batchno, java.lang.String cityid, java.lang.Long rptmon, java.lang.Integer tztype, java.lang.String wayid, java.lang.Integer num, java.lang.Double yzreward, java.lang.Double adjreward) {
        this.batchno = batchno;
        this.cityid = cityid;
        this.rptmon = rptmon;
        this.tztype = tztype;
        this.wayid = wayid;
        this.num = num;
        this.yzreward = yzreward;
        this.adjreward = adjreward;
    }

    /** default constructor */
    public BbcYzrewarddetVO() {
    }

    /** minimal constructor */
    public BbcYzrewarddetVO(java.lang.String batchno, java.lang.String cityid, java.lang.Long rptmon, java.lang.Integer tztype, java.lang.String wayid) {
        this.batchno = batchno;
        this.cityid = cityid;
        this.rptmon = rptmon;
        this.tztype = tztype;
        this.wayid = wayid;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getRptmon() {
        return this.rptmon;
    }

    public void setRptmon(java.lang.Long rptmon) {
        this.rptmon = rptmon;
    }

    public java.lang.Integer getTztype() {
        return this.tztype;
    }

    public void setTztype(java.lang.Integer tztype) {
        this.tztype = tztype;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Integer getNum() {
        return this.num;
    }

    public void setNum(java.lang.Integer num) {
        this.num = num;
    }


    public java.lang.Double getAdjreward() {
		return adjreward;
	}

	public void setAdjreward(java.lang.Double adjreward) {
		this.adjreward = adjreward;
	}

	public java.lang.Double getYzreward() {
		return yzreward;
	}

	public void setYzreward(java.lang.Double yzreward) {
		this.yzreward = yzreward;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("batchno", getBatchno())
            .append("cityid", getCityid())
            .append("rptmon", getRptmon())
            .append("tztype", getTztype())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BbcYzrewarddetVO) ) return false;
        BbcYzrewarddetVO castOther = (BbcYzrewarddetVO) other;
        return new EqualsBuilder()
            .append(this.getBatchno(), castOther.getBatchno())
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getRptmon(), castOther.getRptmon())
            .append(this.getTztype(), castOther.getTztype())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBatchno())
            .append(getCityid())
            .append(getRptmon())
            .append(getTztype())
            .append(getWayid())
            .toHashCode();
    }

}
