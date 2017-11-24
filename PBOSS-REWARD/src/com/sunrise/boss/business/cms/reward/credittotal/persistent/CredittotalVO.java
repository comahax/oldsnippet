package com.sunrise.boss.business.cms.reward.credittotal.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CredittotalVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private Long slv;

    /** nullable persistent field */
    private Double creditaccount;

    /** nullable persistent field */
    private Long adtypecode;

    /** nullable persistent field */
    private Double creditlev;

    /** nullable persistent field */
    private Double cardsale;

    /** nullable persistent field */
    private Double salelev;

    /** nullable persistent field */
    private String iscreditlev;

    /** nullable persistent field */
    private String issalelev;
    
    private Double manageassess;
    private Double assess;
    private Double assegrade;
    private Double saleassess;
    private Short noncyc;

    public Short getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Short noncyc) {
		this.noncyc = noncyc;
	}

	/** full constructor */
    public CredittotalVO(java.lang.Long seq, java.lang.String wayid, java.lang.String calcmonth, java.lang.Long slv, java.lang.Double creditaccount, java.lang.Long adtypecode, java.lang.Double creditlev, java.lang.Double cardsale, java.lang.Double salelev, java.lang.String iscreditlev, java.lang.String issalelev,
    		java.lang.Double manageassess ,java.lang.Double assess ,
    		java.lang.Double assegrade ,java.lang.Double saleassess ) {
        this.seq = seq;
        this.wayid = wayid;
        this.calcmonth = calcmonth;
        this.slv = slv;
        this.creditaccount = creditaccount;
        this.adtypecode = adtypecode;
        this.creditlev = creditlev;
        this.cardsale = cardsale;
        this.salelev = salelev;
        this.iscreditlev = iscreditlev;
        this.issalelev = issalelev;
        this.manageassess=manageassess;
        this.assess=assess;
        this.assegrade=assegrade;
        this.saleassess=saleassess;
    }

    /** default constructor */
    public CredittotalVO() {
    }

    /** minimal constructor */
    public CredittotalVO(java.lang.Long seq) {
        this.seq = seq;
    }

    
    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.Long getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.Long slv) {
        this.slv = slv;
    }

    public java.lang.Double getCreditaccount() {
        return this.creditaccount;
    }

    public void setCreditaccount(java.lang.Double creditaccount) {
        this.creditaccount = creditaccount;
    }

    public java.lang.Long getAdtypecode() {
        return this.adtypecode;
    }

    public void setAdtypecode(java.lang.Long adtypecode) {
        this.adtypecode = adtypecode;
    }

    public java.lang.Double getCreditlev() {
        return this.creditlev;
    }

    public void setCreditlev(java.lang.Double creditlev) {
        this.creditlev = creditlev;
    }

    public java.lang.Double getCardsale() {
        return this.cardsale;
    }

    public void setCardsale(java.lang.Double cardsale) {
        this.cardsale = cardsale;
    }

    public java.lang.Double getSalelev() {
        return this.salelev;
    }

    public void setSalelev(java.lang.Double salelev) {
        this.salelev = salelev;
    }

    public java.lang.String getIscreditlev() {
        return this.iscreditlev;
    }

    public void setIscreditlev(java.lang.String iscreditlev) {
        this.iscreditlev = iscreditlev;
    }

    public java.lang.String getIssalelev() {
        return this.issalelev;
    }

    public void setIssalelev(java.lang.String issalelev) {
        this.issalelev = issalelev;
    }

    
    public Double getManageassess() {
		return manageassess;
	}

	public void setManageassess(Double manageassess) {
		this.manageassess = manageassess;
	}

	public Double getAssess() {
		return assess;
	}

	public void setAssess(Double assess) {
		this.assess = assess;
	}

	public Double getAssegrade() {
		return assegrade;
	}

	public void setAssegrade(Double assegrade) {
		this.assegrade = assegrade;
	}

	public Double getSaleassess() {
		return saleassess;
	}

	public void setSaleassess(Double saleassess) {
		this.saleassess = saleassess;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CredittotalVO) ) return false;
        CredittotalVO castOther = (CredittotalVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
