package com.gmcc.pboss.business.reward.cardrewdettotal;

import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CardrewdettotalVO extends BaseVO implements Serializable {

	private Long rowcountid;
	
    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String rechargemonth;

    /** nullable persistent field */
    private String activemonth;

    /** nullable persistent field */
    private Long rewardtype;

    /** nullable persistent field */
    private Double rewardtotal;

    /** nullable persistent field */
    private String cmonth;

    
    public Long getRowcountid() {
		return rowcountid;
	}

	public void setRowcountid(Long rowcountid) {
		this.rowcountid = rowcountid;
	}

	/** full constructor */
    public CardrewdettotalVO(java.lang.String wayid, java.lang.String rechargemonth, java.lang.String activemonth, java.lang.Long rewardtype, java.lang.Double rewardtotal, java.lang.String cmonth) {
        this.wayid = wayid;
        this.rechargemonth = rechargemonth;
        this.activemonth = activemonth;
        this.rewardtype = rewardtype;
        this.rewardtotal = rewardtotal;
        this.cmonth = cmonth;
    }

    /** default constructor */
    public CardrewdettotalVO() {
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getRechargemonth() {
        return this.rechargemonth;
    }

    public void setRechargemonth(java.lang.String rechargemonth) {
        this.rechargemonth = rechargemonth;
    }

    public java.lang.String getActivemonth() {
        return this.activemonth;
    }

    public void setActivemonth(java.lang.String activemonth) {
        this.activemonth = activemonth;
    }

    public java.lang.Long getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Long rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Double getRewardtotal() {
        return this.rewardtotal;
    }

    public void setRewardtotal(java.lang.Double rewardtotal) {
        this.rewardtotal = rewardtotal;
    }

    public java.lang.String getCmonth() {
        return this.cmonth;
    }

    public void setCmonth(java.lang.String cmonth) {
        this.cmonth = cmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rowcountid", getRowcountid())
            .toString();
    }
    public boolean equals(Object other) {
        if ( !(other instanceof CardrewdettotalVO) ) return false;
        CardrewdettotalVO castOther = (CardrewdettotalVO) other;
        return new EqualsBuilder()
            .append(this.getRowcountid(), castOther.getRowcountid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRowcountid())
            .toHashCode();
    }

}
