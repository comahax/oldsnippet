package com.sunrise.boss.business.cms.adjustment.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VAdjustmentVO implements Serializable {

    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private Double paysum;

    /** nullable persistent field */
    private Double invoicesum;

    /** nullable persistent field */
    private Double taxmoney;

    /** nullable persistent field */
    private Double realpay;

    /** nullable persistent field */
    private String remark;
    
    private Double rpmoney;
    
    private Short accttype;
    
    private String chainhead;
    private String batchno;
    
    private Double fees;
    
    private String upperopnid;

    /** full constructor */
    public VAdjustmentVO(java.lang.Long id, java.lang.String wayid, java.lang.String rewardmonth, 
    		java.lang.String countyid, java.lang.String wayname, java.lang.Short starlevel, java.lang.Double paysum,
    		java.lang.Double invoicesum, java.lang.Double taxmoney, java.lang.Double realpay, 
    		java.lang.String remark, java.lang.Double rpmoney, java.lang.Short accttype,
    		java.lang.String chainhead, java.lang.String batchno,java.lang.Double fees, String upperopnid) {
        this.id = id;
        this.wayid = wayid;
        this.rewardmonth = rewardmonth;
        this.countyid = countyid;
        this.wayname = wayname;
        this.starlevel = starlevel;
        this.paysum = paysum;
        this.invoicesum = invoicesum;
        this.taxmoney = taxmoney;
        this.realpay = realpay;
        this.remark = remark;
        this.rpmoney = rpmoney;
        this.accttype = accttype;
        this.chainhead = chainhead;
        this.batchno = batchno;
        this.fees = fees;
        this.upperopnid = upperopnid;
    }

    /** default constructor */
    public VAdjustmentVO() {
    }

    /** minimal constructor */
    public VAdjustmentVO(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.Double getPaysum() {
        return this.paysum;
    }

    public void setPaysum(java.lang.Double paysum) {
        this.paysum = paysum;
    }

    public java.lang.Double getInvoicesum() {
        return this.invoicesum;
    }

    public void setInvoicesum(java.lang.Double invoicesum) {
        this.invoicesum = invoicesum;
    }

    public java.lang.Double getTaxmoney() {
        return this.taxmoney;
    }

    public void setTaxmoney(java.lang.Double taxmoney) {
        this.taxmoney = taxmoney;
    }

    public java.lang.Double getRealpay() {
        return this.realpay;
    }

    public void setRealpay(java.lang.Double realpay) {
        this.realpay = realpay;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public Short getAccttype() {
		return accttype;
	}

	public void setAccttype(Short accttype) {
		this.accttype = accttype;
	}

	public String getChainhead() {
		return chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	
	public String getUpperopnid() {
		return upperopnid;
	}

	public void setUpperopnid(String upperopnid) {
		this.upperopnid = upperopnid;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VAdjustmentVO) ) return false;
        VAdjustmentVO castOther = (VAdjustmentVO) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

	public Double getRpmoney() {
		return rpmoney;
	}

	public void setRpmoney(Double rpmoney) {
		this.rpmoney = rpmoney;
	}

    
}
