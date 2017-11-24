package com.sunrise.boss.business.cms.reward.stdrewardut.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VStdrewardutVO implements Serializable {

    /** identifier field */
    private String region;
    
    private Date startdate;
    
    private Date stopdate;

    /** identifier field */
    private Long rewardid;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Short islimt;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Long intvmonth;

    /** nullable persistent field */
    private Long integralnum;

    /** nullable persistent field */
    private Double unitprice;

    /** nullable persistent field */
    private String relateitem;
    
    private String rewardname;
    
    private Short rewardtype;

    /** full constructor */
    public VStdrewardutVO(java.lang.String region, java.lang.Long rewardid, java.lang.String wayid, java.lang.Short islimt, java.lang.Double rewardstd, java.lang.Long intvmonth, java.lang.Long integralnum, java.lang.Double unitprice, java.lang.String relateitem, java.lang.String rewardname, java.lang.Short rewardtype) {
        this.region = region;
        this.rewardid = rewardid;
        this.wayid = wayid;
        this.islimt = islimt;
        this.rewardstd = rewardstd;
        this.intvmonth = intvmonth;
        this.integralnum = integralnum;
        this.unitprice = unitprice;
        this.relateitem = relateitem;
        this.rewardname = rewardname;
        this.rewardtype = rewardtype;
    }

    /** default constructor */
    public VStdrewardutVO() {
    }

    /** minimal constructor */
    public VStdrewardutVO(java.lang.String region, java.lang.Long rewardid, java.lang.String wayid) {
        this.region = region;
        this.rewardid = rewardid;
        this.wayid = wayid;
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

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getIslimt() {
        return this.islimt;
    }

    public void setIslimt(java.lang.Short islimt) {
        this.islimt = islimt;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Long getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Long intvmonth) {
        this.intvmonth = intvmonth;
    }

    public java.lang.Long getIntegralnum() {
        return this.integralnum;
    }

    public void setIntegralnum(java.lang.Long integralnum) {
        this.integralnum = integralnum;
    }

    public java.lang.Double getUnitprice() {
        return this.unitprice;
    }

    public void setUnitprice(java.lang.Double unitprice) {
        this.unitprice = unitprice;
    }

    public java.lang.String getRelateitem() {
        return this.relateitem;
    }

    public void setRelateitem(java.lang.String relateitem) {
        this.relateitem = relateitem;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardutVO) ) return false;
        StdrewardutVO castOther = (StdrewardutVO) other;
        return new EqualsBuilder()
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegion())
            .append(getRewardid())
            .append(getWayid())
            .toHashCode();
    }

	public String getRewardname() {
		return rewardname;
	}

	public void setRewardname(String rewardname) {
		this.rewardname = rewardname;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getStopdate() {
		return stopdate;
	}

	public void setStopdate(Date stopdate) {
		this.stopdate = stopdate;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}
   

}
