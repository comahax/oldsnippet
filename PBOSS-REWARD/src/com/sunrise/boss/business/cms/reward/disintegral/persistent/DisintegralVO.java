package com.sunrise.boss.business.cms.reward.disintegral.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.disintegrallog.persistent.DisintegrallogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class DisintegralVO implements OperationLog,Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String calmonth;

    /** nullable persistent field */
    private Short integraltype;

    /** nullable persistent field */
    private Long integralnum;

    /** full constructor */
    public DisintegralVO(java.lang.String wayid, java.lang.String calmonth, java.lang.Short integraltype, java.lang.Long integralnum) {
        this.wayid = wayid;
        this.calmonth = calmonth;
        this.integraltype = integraltype;
        this.integralnum = integralnum;
    }

    /** default constructor */
    public DisintegralVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCalmonth() {
        return this.calmonth;
    }

    public void setCalmonth(java.lang.String calmonth) {
        this.calmonth = calmonth;
    }

    public java.lang.Short getIntegraltype() {
        return this.integraltype;
    }

    public void setIntegraltype(java.lang.Short integraltype) {
        this.integraltype = integraltype;
    }

    public java.lang.Long getIntegralnum() {
        return this.integralnum;
    }

    public void setIntegralnum(java.lang.Long integralnum) {
        this.integralnum = integralnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisintegralVO) ) return false;
        DisintegralVO castOther = (DisintegralVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return DisintegrallogVO.class;
	}

}
