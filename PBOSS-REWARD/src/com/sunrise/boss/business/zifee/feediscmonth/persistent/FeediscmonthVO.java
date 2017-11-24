package com.sunrise.boss.business.zifee.feediscmonth.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.feediscmolog.persistent.FeediscmologVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeedislogVO;

/** @author Hibernate CodeGenerator */
public class FeediscmonthVO implements Serializable, OperationLog {

    /** identifier field */
    private Long discid;

    /** persistent field */
    private Long yxplanid;

    /** persistent field */
    private Short disctype;

    /** persistent field */
    private Double discvalue;

    /** nullable persistent field */
    private Integer presentprio;

    /** persistent field */
    private Byte presentbalanceflag;

    /** nullable persistent field */
    private String discbill;

    /** nullable persistent field */
    private String excludebill;

    /** full constructor */
    public FeediscmonthVO(java.lang.Long discid, java.lang.Long yxplanid, java.lang.Short disctype, java.lang.Double discvalue, java.lang.Integer presentprio, java.lang.Byte presentbalanceflag, java.lang.String discbill, java.lang.String excludebill) {
        this.discid = discid;
        this.yxplanid = yxplanid;
        this.disctype = disctype;
        this.discvalue = discvalue;
        this.presentprio = presentprio;
        this.presentbalanceflag = presentbalanceflag;
        this.discbill = discbill;
        this.excludebill = excludebill;
    }

    /** default constructor */
    public FeediscmonthVO() {
    }

    /** minimal constructor */
    public FeediscmonthVO(java.lang.Long discid, java.lang.Long yxplanid, java.lang.Short disctype, java.lang.Double discvalue, java.lang.Byte presentbalanceflag) {
        this.discid = discid;
        this.yxplanid = yxplanid;
        this.disctype = disctype;
        this.discvalue = discvalue;
        this.presentbalanceflag = presentbalanceflag;
    }

    public java.lang.Long getDiscid() {
        return this.discid;
    }

    public void setDiscid(java.lang.Long discid) {
        this.discid = discid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Short getDisctype() {
        return this.disctype;
    }

    public void setDisctype(java.lang.Short disctype) {
        this.disctype = disctype;
    }

    public java.lang.Double getDiscvalue() {
    	
        return this.discvalue;
    }

    public void setDiscvalue(java.lang.Double discvalue) {
    	
        this.discvalue = discvalue;
    }

    public java.lang.Integer getPresentprio() {
        return this.presentprio;
    }

    public void setPresentprio(java.lang.Integer presentprio) {
        this.presentprio = presentprio;
    }

    public java.lang.Byte getPresentbalanceflag() {
        return this.presentbalanceflag;
    }

    public void setPresentbalanceflag(java.lang.Byte presentbalanceflag) {
        this.presentbalanceflag = presentbalanceflag;
    }

    public java.lang.String getDiscbill() {
        return this.discbill;
    }

    public void setDiscbill(java.lang.String discbill) {
        this.discbill = discbill;
    }

    public java.lang.String getExcludebill() {
        return this.excludebill;
    }

    public void setExcludebill(java.lang.String excludebill) {
        this.excludebill = excludebill;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("discid", getDiscid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FeediscmonthVO) ) return false;
        FeediscmonthVO castOther = (FeediscmonthVO) other;
        return new EqualsBuilder()
            .append(this.getDiscid(), castOther.getDiscid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDiscid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return FeediscmologVO.class;
	}

}
