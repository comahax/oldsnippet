package com.sunrise.boss.business.cms.stdrewardbslog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StdrewardbslogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long rewardid;

    /** nullable persistent field */
    private String region;

    /** nullable persistent field */
    private Short islimt;

    /** nullable persistent field */
    private String slv;

    /** nullable persistent field */
    private Double citystd;

    /** nullable persistent field */
    private Double countrystd;
    
    private Short intvmonth;

    /** full constructor */
    public StdrewardbslogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long rewardid, java.lang.String region, java.lang.Short islimt, java.lang.String slv, java.lang.Double citystd, java.lang.Double countrystd,java.lang.Short   intvmonth) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.rewardid = rewardid;
        this.region = region;
        this.islimt = islimt;
        this.slv = slv;
        this.citystd = citystd;
        this.countrystd = countrystd;
        this.intvmonth=intvmonth;
    }

    /** default constructor */
    public StdrewardbslogVO() {
    }

    /** minimal constructor */
    public StdrewardbslogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.Short getIslimt() {
        return this.islimt;
    }

    public void setIslimt(java.lang.Short islimt) {
        this.islimt = islimt;
    }

    public java.lang.String getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.String slv) {
        this.slv = slv;
    }

    public java.lang.Double getCitystd() {
        return this.citystd;
    }

    public void setCitystd(java.lang.Double citystd) {
        this.citystd = citystd;
    }

    public java.lang.Double getCountrystd() {
        return this.countrystd;
    }

    public void setCountrystd(java.lang.Double countrystd) {
        this.countrystd = countrystd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardbslogVO) ) return false;
        StdrewardbslogVO castOther = (StdrewardbslogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Short getIntvmonth() {
		return intvmonth;
	}

	public void setIntvmonth(Short intvmonth) {
		this.intvmonth = intvmonth;
	}



}
