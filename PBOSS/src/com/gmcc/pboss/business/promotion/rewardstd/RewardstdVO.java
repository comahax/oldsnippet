package com.gmcc.pboss.business.promotion.rewardstd;

import com.gmcc.pboss.business.promotion.rewardstdlog.RewardstdlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardstdVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String comcategory;

    /** identifier field */
    private Long ruleid;

    /** persistent field */
    private Double reward;

    /** full constructor */
    public RewardstdVO(java.lang.String comcategory, java.lang.Long ruleid, java.lang.Double reward) {
        this.comcategory = comcategory;
        this.ruleid = ruleid;
        this.reward = reward;
    }

    /** default constructor */
    public RewardstdVO() {
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Double getReward() {
        return this.reward;
    }

    public void setReward(java.lang.Double reward) {
        this.reward = reward;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comcategory", getComcategory())
            .append("ruleid", getRuleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardstdVO) ) return false;
        RewardstdVO castOther = (RewardstdVO) other;
        return new EqualsBuilder()
            .append(this.getComcategory(), castOther.getComcategory())
            .append(this.getRuleid(), castOther.getRuleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComcategory())
            .append(getRuleid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return RewardstdlogVO.class;
	}

}
