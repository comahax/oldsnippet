package com.sunrise.boss.business.cms.paymentbatch.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PaymentbatchVO implements Serializable {

    /** identifier field */
    private String batchno;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private Short paymentflag;

    /** nullable persistent field */
    private String paymentoprcode;

    /** nullable persistent field */
    private java.util.Date paymentoprtime;

    /** nullable persistent field */
    private Short listflag;

    /** nullable persistent field */
    private Short endflag;
    
    private String paymonth;
    
    private String endoprcode;
    
    private java.util.Date endtime;

    /** full constructor */
    public PaymentbatchVO(java.lang.String batchno, java.lang.Short cityid, java.lang.Short paymentflag, java.lang.String paymentoprcode, java.util.Date paymentoprtime, java.lang.Short listflag, java.lang.Short endflag) {
        this.batchno = batchno;
        this.cityid = cityid;
        this.paymentflag = paymentflag;
        this.paymentoprcode = paymentoprcode;
        this.paymentoprtime = paymentoprtime;
        this.listflag = listflag;
        this.endflag = endflag;
    }

    public PaymentbatchVO(String batchno, Short cityid, Short paymentflag,
			String paymentoprcode, Date paymentoprtime, Short listflag,
			Short endflag, String paymonth) {
		super();
		this.batchno = batchno;
		this.cityid = cityid;
		this.paymentflag = paymentflag;
		this.paymentoprcode = paymentoprcode;
		this.paymentoprtime = paymentoprtime;
		this.listflag = listflag;
		this.endflag = endflag;
		this.paymonth = paymonth;
	}

	/** default constructor */
    public PaymentbatchVO() {
    }

    /** minimal constructor */
    public PaymentbatchVO(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.Short getPaymentflag() {
        return this.paymentflag;
    }

    public void setPaymentflag(java.lang.Short paymentflag) {
        this.paymentflag = paymentflag;
    }

    public java.lang.String getPaymentoprcode() {
        return this.paymentoprcode;
    }

    public void setPaymentoprcode(java.lang.String paymentoprcode) {
        this.paymentoprcode = paymentoprcode;
    }

    public java.util.Date getPaymentoprtime() {
        return this.paymentoprtime;
    }

    public void setPaymentoprtime(java.util.Date paymentoprtime) {
        this.paymentoprtime = paymentoprtime;
    }

    public java.lang.Short getListflag() {
        return this.listflag;
    }

    public void setListflag(java.lang.Short listflag) {
        this.listflag = listflag;
    }

    public java.lang.Short getEndflag() {
        return this.endflag;
    }

    public void setEndflag(java.lang.Short endflag) {
        this.endflag = endflag;
    }

    public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("batchno", getBatchno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PaymentbatchVO) ) return false;
        PaymentbatchVO castOther = (PaymentbatchVO) other;
        return new EqualsBuilder()
            .append(this.getBatchno(), castOther.getBatchno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBatchno())
            .toHashCode();
    }

	public String getEndoprcode() {
		return endoprcode;
	}

	public void setEndoprcode(String endoprcode) {
		this.endoprcode = endoprcode;
	}

	public java.util.Date getEndtime() {
		return endtime;
	}

	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}

}
