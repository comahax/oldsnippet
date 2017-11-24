package com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StdrewardbjstarlogVO implements Serializable {

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
    private String opnid;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private Short star;
    
    private Short ispt;
    
    private Double singlept;
    
    private Double diploidpt;

    /** full constructor */
    public StdrewardbjstarlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long rewardid, java.lang.String region, java.lang.String opnid, java.lang.Double rewardstd, java.lang.Short acctype, java.lang.String ruleid, java.lang.Short star) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.rewardid = rewardid;
        this.region = region;
        this.opnid = opnid;
        this.rewardstd = rewardstd;
        this.acctype = acctype;
        this.ruleid = ruleid;
        this.star = star;
    }

    /** default constructor */
    public StdrewardbjstarlogVO() {
    }

    /** minimal constructor */
    public StdrewardbjstarlogVO(java.lang.Long logid) {
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

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Short getStar() {
        return this.star;
    }

    public void setStar(java.lang.Short star) {
        this.star = star;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardbjstarlogVO) ) return false;
        StdrewardbjstarlogVO castOther = (StdrewardbjstarlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Double getDiploidpt() {
		return diploidpt;
	}

	public void setDiploidpt(Double diploidpt) {
		this.diploidpt = diploidpt;
	}

	public Short getIspt() {
		return ispt;
	}

	public void setIspt(Short ispt) {
		this.ispt = ispt;
	}

	public Double getSinglept() {
		return singlept;
	}

	public void setSinglept(Double singlept) {
		this.singlept = singlept;
	}

}
