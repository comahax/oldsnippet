package com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyclog.persistent.StdrewardbjnoncyclogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class StdrewardbjnoncycVO implements OperationLog {

    /** identifier field */
    private Short noncyc;

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private Integer intvmonth;

    /** full constructor */
    public StdrewardbjnoncycVO(java.lang.Short noncyc, java.lang.String region, java.lang.Long rewardid, java.lang.String opnid, java.lang.Short acctype, java.lang.Double rewardstd, java.lang.String ruleid, java.lang.Integer intvmonth) {
        this.noncyc = noncyc;
        this.region = region;
        this.rewardid = rewardid;
        this.opnid = opnid;
        this.acctype = acctype;
        this.rewardstd = rewardstd;
        this.ruleid = ruleid;
        this.intvmonth = intvmonth;
    }

    /** default constructor */
    public StdrewardbjnoncycVO() {
    }

    /** minimal constructor */
    public StdrewardbjnoncycVO(java.lang.Short noncyc, java.lang.String region, java.lang.Long rewardid) {
        this.noncyc = noncyc;
        this.region = region;
        this.rewardid = rewardid;
    }

    public java.lang.Short getNoncyc() {
        return this.noncyc;
    }

    public void setNoncyc(java.lang.Short noncyc) {
        this.noncyc = noncyc;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Integer getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Integer intvmonth) {
        this.intvmonth = intvmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("noncyc", getNoncyc())
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardbjnoncycVO) ) return false;
        StdrewardbjnoncycVO castOther = (StdrewardbjnoncycVO) other;
        return new EqualsBuilder()
            .append(this.getNoncyc(), castOther.getNoncyc())
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getNoncyc())
            .append(getRegion())
            .append(getRewardid())
            .toHashCode();
    }
    
    public Class logVOClass() {
    	return StdrewardbjnoncyclogVO.class;
    }

}
