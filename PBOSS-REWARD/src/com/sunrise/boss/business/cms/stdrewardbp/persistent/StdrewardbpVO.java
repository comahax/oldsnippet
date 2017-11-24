package com.sunrise.boss.business.cms.stdrewardbp.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.stdrewardbplog.persistent.StdrewardbplogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class StdrewardbpVO implements OperationLog {

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** nullable persistent field */
    private String slv;

    /** nullable persistent field */
    private Double rewardstd;

    /** full constructor */
    public StdrewardbpVO(java.lang.String region, java.lang.Long rewardid, java.lang.String slv, java.lang.Double rewardstd) {
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
        this.rewardstd = rewardstd;
    }

    /** default constructor */
    public StdrewardbpVO() {
    }

    /** minimal constructor */
    public StdrewardbpVO(java.lang.String region, java.lang.Long rewardid) {
        this.region = region;
        this.rewardid = rewardid;
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

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardbpVO) ) return false;
        StdrewardbpVO castOther = (StdrewardbpVO) other;
        return new EqualsBuilder()
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegion())
            .append(getRewardid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return StdrewardbplogVO.class;
	}

}
