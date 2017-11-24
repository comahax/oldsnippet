package com.sunrise.boss.business.cms.chadtsales.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.chadtsaleslog.persistent.ChAdtSaleslogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChAdtSalesVO implements Serializable,OperationLog {

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayattr;

    /** nullable persistent field */
    private Long sales;

    /** nullable persistent field */
    private Double rewardstd;

    /** full constructor */
    public ChAdtSalesVO(java.lang.Short cityid, java.lang.String opnid, java.lang.String wayattr, java.lang.Long sales, java.lang.Double rewardstd) {
        this.cityid = cityid;
        this.opnid = opnid;
        this.wayattr = wayattr;
        this.sales = sales;
        this.rewardstd = rewardstd;
    }

    /** default constructor */
    public ChAdtSalesVO() {
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getWayattr() {
        return this.wayattr;
    }

    public void setWayattr(java.lang.String wayattr) {
        this.wayattr = wayattr;
    }

    public java.lang.Long getSales() {
        return this.sales;
    }

    public void setSales(java.lang.Long sales) {
        this.sales = sales;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ChAdtSaleslogVO.class;
	}

}
