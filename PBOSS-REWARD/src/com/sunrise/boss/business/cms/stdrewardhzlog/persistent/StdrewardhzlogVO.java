package com.sunrise.boss.business.cms.stdrewardhzlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StdrewardhzlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private Long rewardid;

    /** nullable persistent field */
    private String region;

    /** nullable persistent field */
    private Short slv;

    /** nullable persistent field */
    private Short years;

    /** nullable persistent field */
    private Double lmtstd;

    /** nullable persistent field */
    private Double citystd;

    /** nullable persistent field */
    private String success;
    
    private String relateitem;

    /** full constructor */
    public StdrewardhzlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.Long rewardid, java.lang.String region, java.lang.Short slv, java.lang.Short years, java.lang.Double lmtstd, java.lang.Double citystd, java.lang.String success, java.lang.String relateitem) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.rewardid = rewardid;
        this.region = region;
        this.slv = slv;
        this.years = years;
        this.lmtstd = lmtstd;
        this.citystd = citystd;
        this.success = success;
        this.relateitem = relateitem;
    }

    /** default constructor */
    public StdrewardhzlogVO() {
    }

    /** minimal constructor */
    public StdrewardhzlogVO(java.lang.Long logid) {
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

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.Short getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.Short slv) {
        this.slv = slv;
    }

    public java.lang.Short getYears() {
        return this.years;
    }

    public void setYears(java.lang.Short years) {
        this.years = years;
    }

    public java.lang.Double getLmtstd() {
        return this.lmtstd;
    }

    public void setLmtstd(java.lang.Double lmtstd) {
        this.lmtstd = lmtstd;
    }

    public java.lang.Double getCitystd() {
        return this.citystd;
    }

    public void setCitystd(java.lang.Double citystd) {
        this.citystd = citystd;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardhzlogVO) ) return false;
        StdrewardhzlogVO castOther = (StdrewardhzlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public String getRelateitem() {
		return relateitem;
	}

	public void setRelateitem(String relateitem) {
		this.relateitem = relateitem;
	}

}
