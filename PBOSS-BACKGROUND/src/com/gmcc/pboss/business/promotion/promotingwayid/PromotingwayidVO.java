package com.gmcc.pboss.business.promotion.promotingwayid;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class PromotingwayidVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long pid;

    /** identifier field */
    private Long ruleid;

    /** identifier field */
    private String wayid;

    /** full constructor */
    public PromotingwayidVO(java.lang.Long pid, java.lang.Long ruleid, java.lang.String wayid) {
        this.pid = pid;
        this.ruleid = ruleid;
        this.wayid = wayid;
    }

    /** default constructor */
    public PromotingwayidVO() {
    }

    public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getRuleid() {
		return ruleid;
	}

	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
	}

	public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pid", getPid())
            .append("ruleid", getRuleid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PromotingwayidVO) ) return false;
        PromotingwayidVO castOther = (PromotingwayidVO) other;
        return new EqualsBuilder()
            .append(this.getPid(), castOther.getPid())
            .append(this.getRuleid(), castOther.getRuleid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPid())
            .append(getRuleid())
            .append(getWayid())
            .toHashCode();
    }

}
