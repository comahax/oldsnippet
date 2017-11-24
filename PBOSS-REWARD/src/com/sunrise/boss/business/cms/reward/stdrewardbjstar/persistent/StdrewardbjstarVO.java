package com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.persistent.StdrewardbjstarlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class StdrewardbjstarVO implements OperationLog {

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** identifier field */
    private Short star;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private String ruleid;
    
    private Short ispt;
    
    private Double singlept;
    
    private Double diploidpt;

    private boolean updateFlag = false;
    private boolean deleteFlag = false;
    
    /** full constructor */
    public StdrewardbjstarVO(java.lang.String region, java.lang.Long rewardid, java.lang.Short star, java.lang.String opnid, java.lang.Short acctype, java.lang.Double rewardstd, java.lang.String ruleid, java.lang.Short ispt, java.lang.Double singlept, java.lang.Double diploidpt) {
        this.region = region;
        this.rewardid = rewardid;
        this.star = star;
        this.opnid = opnid;
        this.acctype = acctype;
        this.rewardstd = rewardstd;
        this.ruleid = ruleid;
        this.ispt = ispt;
        this.singlept = singlept;
        this.diploidpt = diploidpt;
    }

    /** default constructor */
    public StdrewardbjstarVO() {
    }

    /** minimal constructor */
    public StdrewardbjstarVO(java.lang.String region, java.lang.Long rewardid, java.lang.Short star) {
        this.region = region;
        this.rewardid = rewardid;
        this.star = star;
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

    public java.lang.Short getStar() {
        return this.star;
    }

    public void setStar(java.lang.Short star) {
        this.star = star;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .append("star", getStar())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardbjstarVO) ) return false;
        StdrewardbjstarVO castOther = (StdrewardbjstarVO) other;
        return new EqualsBuilder()
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .append(this.getStar(), castOther.getStar())
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getAcctype(), castOther.getAcctype())
            .append(this.getRuleid(), castOther.getRuleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegion())
            .append(getRewardid())
            .append(getStar())
            .toHashCode();
    }

	public boolean isUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(boolean updateFlag) {
		this.updateFlag = updateFlag;
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return StdrewardbjstarlogVO.class;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
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
