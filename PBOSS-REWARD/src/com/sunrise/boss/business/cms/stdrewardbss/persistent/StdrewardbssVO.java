package com.sunrise.boss.business.cms.stdrewardbss.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.sunrise.boss.business.cms.stdrewardbsslog.persistent.StdrewardbsslogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class StdrewardbssVO implements OperationLog {

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** identifier field */
    private String slv;

    /** nullable persistent field */
    private Double mpcitystd;

    /** nullable persistent field */
    private Double mpcountrystd;

    /** nullable persistent field */
    private Integer mpintvmonth;

    /** nullable persistent field */
    private Double secitystd;

    /** nullable persistent field */
    private Double secountrystd;

    /** nullable persistent field */
    private Integer seintvmonth;

    /** full constructor */
    public StdrewardbssVO(java.lang.String region, java.lang.Long rewardid, java.lang.String slv, java.lang.Double mpcitystd, java.lang.Double mpcountrystd, java.lang.Integer mpintvmonth, java.lang.Double secitystd, java.lang.Double secountrystd, java.lang.Integer seintvmonth) {
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
        this.mpcitystd = mpcitystd;
        this.mpcountrystd = mpcountrystd;
        this.mpintvmonth = mpintvmonth;
        this.secitystd = secitystd;
        this.secountrystd = secountrystd;
        this.seintvmonth = seintvmonth;
    }

    /** default constructor */
    public StdrewardbssVO() {
    }

    /** minimal constructor */
    public StdrewardbssVO(java.lang.String region, java.lang.Long rewardid, java.lang.String slv) {
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
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

    public java.lang.String getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.String slv) {
        this.slv = slv;
    }

    public java.lang.Double getMpcitystd() {
        return this.mpcitystd;
    }

    public void setMpcitystd(java.lang.Double mpcitystd) {
        this.mpcitystd = mpcitystd;
    }

    public java.lang.Double getMpcountrystd() {
        return this.mpcountrystd;
    }

    public void setMpcountrystd(java.lang.Double mpcountrystd) {
        this.mpcountrystd = mpcountrystd;
    }

    public java.lang.Integer getMpintvmonth() {
        return this.mpintvmonth;
    }

    public void setMpintvmonth(java.lang.Integer mpintvmonth) {
        this.mpintvmonth = mpintvmonth;
    }

    public java.lang.Double getSecitystd() {
        return this.secitystd;
    }

    public void setSecitystd(java.lang.Double secitystd) {
        this.secitystd = secitystd;
    }

    public java.lang.Double getSecountrystd() {
        return this.secountrystd;
    }

    public void setSecountrystd(java.lang.Double secountrystd) {
        this.secountrystd = secountrystd;
    }

    public java.lang.Integer getSeintvmonth() {
        return this.seintvmonth;
    }

    public void setSeintvmonth(java.lang.Integer seintvmonth) {
        this.seintvmonth = seintvmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .append("slv", getSlv())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardbssVO) ) return false;
        StdrewardbssVO castOther = (StdrewardbssVO) other;
        return new EqualsBuilder()
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .append(this.getSlv(), castOther.getSlv())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegion())
            .append(getRewardid())
            .append(getSlv())
            .toHashCode();
    }

	public Class logVOClass() {
		return StdrewardbsslogVO.class;
	}

}
