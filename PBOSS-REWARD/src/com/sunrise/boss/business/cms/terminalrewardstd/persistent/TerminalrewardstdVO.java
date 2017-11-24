package com.sunrise.boss.business.cms.terminalrewardstd.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TerminalrewardstdVO implements Serializable {

    /** identifier field */
    private Short citycode;

    /** identifier field */
    private String comid;

    /** identifier field */
    private Short rewardtype;

    /** nullable persistent field */
    private Double rewardstd; 
    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private String adtremark;

    /** nullable persistent field */
    private java.util.Date createtime;
    private java.lang.Double standardprice;

    /** full constructor */
    public TerminalrewardstdVO(java.lang.Short citycode, java.lang.String comid, java.lang.Short rewardtype, java.lang.Double rewardstd, java.lang.Short acctype, java.lang.String adtremark, java.util.Date createtime,java.lang.Double standardprice) {
        this.citycode = citycode;
        this.comid = comid;
        this.rewardtype = rewardtype;
        this.rewardstd = rewardstd; 
        this.acctype = acctype;
        this.adtremark = adtremark;
        this.createtime = createtime;
        this.standardprice = standardprice;
    }

    /** default constructor */
    public TerminalrewardstdVO() {
    }

    /** minimal constructor */
    public TerminalrewardstdVO(java.lang.Short citycode, java.lang.String comid,java.lang.Short rewardtype) {
        this.citycode = citycode;
        this.comid = comid;
        this.rewardtype = rewardtype;
    }

    public java.lang.Short getCitycode() {
        return this.citycode;
    }

    public void setCitycode(java.lang.Short citycode) {
        this.citycode = citycode;
    }

    public java.lang.String getComid() {
        return this.comid;
    }

    public void setComid(java.lang.String comid) {
        this.comid = comid;
    } 
	public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
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

    public java.lang.String getAdtremark() {
        return this.adtremark;
    }

    public void setAdtremark(java.lang.String adtremark) {
        this.adtremark = adtremark;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("citycode", getCitycode())
            .append("comid", getComid())
            .append("rewardtype", getRewardtype())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TerminalrewardstdVO) ) return false;
        TerminalrewardstdVO castOther = (TerminalrewardstdVO) other;
        return new EqualsBuilder()
            .append(this.getCitycode(), castOther.getCitycode())
            .append(this.getComid(), castOther.getComid())
            .append(this.getRewardtype(), castOther.getRewardtype())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCitycode())
            .append(getComid())
            .append(getRewardtype())
            .toHashCode();
    }

	public java.lang.Double getStandardprice() {
		return standardprice;
	}

	public void setStandardprice(java.lang.Double standardprice) {
		this.standardprice = standardprice;
	}

}
