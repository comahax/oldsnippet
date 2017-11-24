package com.sunrise.boss.business.cms.rewardpoolrlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardpoolrlogVO implements Serializable {

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
    private Integer rewardtype;

    /** nullable persistent field */
    private String region;

    /** nullable persistent field */
    private String slv;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date stopdate;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String proportion;
    
    /** nullable persistent field */
    private String cycle;

    /** full constructor */
    public RewardpoolrlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer rewardtype, java.lang.String region, java.lang.String slv, java.util.Date startdate, java.util.Date stopdate, java.lang.String memo, java.lang.String proportion, java.lang.String cycle) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.rewardtype = rewardtype;
        this.region = region;
        this.slv = slv;
        this.startdate = startdate;
        this.stopdate = stopdate;
        this.memo = memo;
        this.proportion = proportion;
        this.cycle = cycle;
    }

    /** default constructor */
    public RewardpoolrlogVO() {
    }

    /** minimal constructor */
    public RewardpoolrlogVO(java.lang.Long logid) {
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

    public java.lang.Integer getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Integer rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.String getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.String slv) {
        this.slv = slv;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getStopdate() {
        return this.stopdate;
    }

    public void setStopdate(java.util.Date stopdate) {
        this.stopdate = stopdate;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardpoolrlogVO) ) return false;
        RewardpoolrlogVO castOther = (RewardpoolrlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
