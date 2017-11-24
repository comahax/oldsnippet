package com.sunrise.boss.business.fee.hangbill.persistent;


import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class WoffCusthisVO implements Serializable {
	/** identifier field */
    private Long acctid;

    /** identifier field */
    private Long eboxid;

    /** identifier field */
    private Long subsid;

    /** identifier field */
    private Integer validbillcyc;

    /** persistent field */
    private Double recamt;

    /** persistent field */
    private Double paiclupamt;

    /** persistent field */
    private Short state;
    
    private Double sumrecamt;
    private Double sumpaiclupamt;
    
    
    /** full constructor */
    public WoffCusthisVO(java.lang.Long acctid, java.lang.Long eboxid, java.lang.Long subsid, java.lang.Integer validbillcyc, java.lang.Double recamt, java.lang.Double paiclupamt, java.lang.Short state) {
        this.acctid = acctid;
        this.eboxid = eboxid;
        this.subsid = subsid;
        this.validbillcyc = validbillcyc;
        this.recamt = recamt;
        this.paiclupamt = paiclupamt;
        this.state = state;
    }

    /** default constructor */
    public WoffCusthisVO() {
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.Long getEboxid() {
        return this.eboxid;
    }

    public void setEboxid(java.lang.Long eboxid) {
        this.eboxid = eboxid;
    }

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.Integer getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.Integer validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Double getRecamt() {
        return this.recamt;
    }

    public void setRecamt(java.lang.Double recamt) {
        this.recamt = recamt;
    }

    public java.lang.Double getPaiclupamt() {
        return this.paiclupamt;
    }

    public void setPaiclupamt(java.lang.Double paiclupamt) {
        this.paiclupamt = paiclupamt;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public Double getSumpaiclupamt() {
		return sumpaiclupamt;
	}

	public void setSumpaiclupamt(Double sumpaiclupamt) {
		this.sumpaiclupamt = sumpaiclupamt;
	}

	public Double getSumrecamt() {
		return sumrecamt;
	}

	public void setSumrecamt(Double sumrecamt) {
		this.sumrecamt = sumrecamt;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("acctid", getAcctid())
            .append("eboxid", getEboxid())
            .append("subsid", getSubsid())
            .append("validbillcyc", getValidbillcyc())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WoffCusthisVO) ) return false;
        WoffCusthisVO castOther = (WoffCusthisVO) other;
        return new EqualsBuilder()
            .append(this.getAcctid(), castOther.getAcctid())
            .append(this.getEboxid(), castOther.getEboxid())
            .append(this.getSubsid(), castOther.getSubsid())
            .append(this.getValidbillcyc(), castOther.getValidbillcyc())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAcctid())
            .append(getEboxid())
            .append(getSubsid())
            .append(getValidbillcyc())
            .toHashCode();
    }

}
