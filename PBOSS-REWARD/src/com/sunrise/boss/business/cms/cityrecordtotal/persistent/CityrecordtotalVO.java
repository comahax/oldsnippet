package com.sunrise.boss.business.cms.cityrecordtotal.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CityrecordtotalVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private Double sumbusivalue;

    /** nullable persistent field */
    private Double sumpaysum;

    /** nullable persistent field */
    private Double sumpaymoney;

    private String rewardtypename;
    
    public String getRewardtypename() {
		return rewardtypename;
	}

	public void setRewardtypename(String rewardtypename) {
		this.rewardtypename = rewardtypename;
	}

	/** full constructor */
    public CityrecordtotalVO(java.lang.Long seqid, java.lang.String wayid, java.lang.String opnid, java.lang.String rewardmonth, java.lang.Short rewardtype, java.lang.Double sumbusivalue, java.lang.Double sumpaysum, java.lang.Double sumpaymoney) {
        this.seqid = seqid;
        this.wayid = wayid;
        this.opnid = opnid;
        this.rewardmonth = rewardmonth;
        this.rewardtype = rewardtype;
        this.sumbusivalue = sumbusivalue;
        this.sumpaysum = sumpaysum;
        this.sumpaymoney = sumpaymoney;
    }

    /** default constructor */
    public CityrecordtotalVO() {
    }

    /** minimal constructor */
    public CityrecordtotalVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Double getSumbusivalue() {
        return this.sumbusivalue;
    }

    public void setSumbusivalue(java.lang.Double sumbusivalue) {
        this.sumbusivalue = sumbusivalue;
    }

    public java.lang.Double getSumpaysum() {
        return this.sumpaysum;
    }

    public void setSumpaysum(java.lang.Double sumpaysum) {
        this.sumpaysum = sumpaysum;
    }

    public java.lang.Double getSumpaymoney() {
        return this.sumpaymoney;
    }

    public void setSumpaymoney(java.lang.Double sumpaymoney) {
        this.sumpaymoney = sumpaymoney;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CityrecordtotalVO) ) return false;
        CityrecordtotalVO castOther = (CityrecordtotalVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
