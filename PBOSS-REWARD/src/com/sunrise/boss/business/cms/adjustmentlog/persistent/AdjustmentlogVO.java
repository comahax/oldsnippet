package com.sunrise.boss.business.cms.adjustmentlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AdjustmentlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long id;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Double paysum;

    /** nullable persistent field */
    private Double taxmoney;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private String confirmoprcode;

    /** nullable persistent field */
    private java.util.Date confirmptime;

    /** nullable persistent field */
    private String taxoprcode;

    /** nullable persistent field */
    private java.util.Date taxoptime;
    
    private Double rpmoney;
    
    private Double fees;
    
    private String upperopnid;

    /** full constructor */
    public AdjustmentlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, 
    		java.lang.String success, java.lang.Long id, java.lang.String countyid, java.lang.String rewardmonth, 
    		java.lang.String wayid, java.lang.Double paysum, java.lang.Double taxmoney, java.lang.String batchno,
    		java.lang.String remark, java.lang.String confirmoprcode, java.util.Date confirmptime,
    		java.lang.String taxoprcode, java.util.Date taxoptime, java.lang.Double rpmoney,java.lang.Double fees,
    		String upperopnid) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.id = id;
        this.countyid = countyid;
        this.rewardmonth = rewardmonth;
        this.wayid = wayid;
        this.paysum = paysum;
        this.taxmoney = taxmoney;
        this.batchno = batchno;
        this.remark = remark;
        this.confirmoprcode = confirmoprcode;
        this.confirmptime = confirmptime;
        this.taxoprcode = taxoprcode;
        this.taxoptime = taxoptime;
        this.rpmoney = rpmoney;
        this.fees = fees;
        this.upperopnid = upperopnid;
    }

    /** default constructor */
    public AdjustmentlogVO() {
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

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Double getPaysum() {
        return this.paysum;
    }

    public void setPaysum(java.lang.Double paysum) {
        this.paysum = paysum;
    }

    public java.lang.Double getTaxmoney() {
        return this.taxmoney;
    }

    public void setTaxmoney(java.lang.Double taxmoney) {
        this.taxmoney = taxmoney;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.String getConfirmoprcode() {
        return this.confirmoprcode;
    }

    public void setConfirmoprcode(java.lang.String confirmoprcode) {
        this.confirmoprcode = confirmoprcode;
    }

    public java.util.Date getConfirmptime() {
        return this.confirmptime;
    }

    public void setConfirmptime(java.util.Date confirmptime) {
        this.confirmptime = confirmptime;
    }

    public java.lang.String getTaxoprcode() {
        return this.taxoprcode;
    }

    public void setTaxoprcode(java.lang.String taxoprcode) {
        this.taxoprcode = taxoprcode;
    }

    public java.util.Date getTaxoptime() {
        return this.taxoptime;
    }

    public void setTaxoptime(java.util.Date taxoptime) {
        this.taxoptime = taxoptime;
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AdjustmentlogVO) ) return false;
        AdjustmentlogVO castOther = (AdjustmentlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Double getRpmoney() {
		return rpmoney;
	}

	public void setRpmoney(Double rpmoney) {
		this.rpmoney = rpmoney;
	}
}
