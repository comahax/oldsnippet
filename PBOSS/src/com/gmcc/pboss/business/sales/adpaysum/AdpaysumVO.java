package com.gmcc.pboss.business.sales.adpaysum;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AdpaysumVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long sumid;

    /** nullable persistent field */
    private String discomcode;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private Double orderamt;

    /** nullable persistent field */
    private Double cancelamt;

    /** nullable persistent field */
    private Double recamt;

    /** nullable persistent field */
    private String submitcode;

    /** nullable persistent field */
    private java.util.Date submittime;

    /** nullable persistent field */
    private String confirmcode;

    /** nullable persistent field */
    private java.util.Date confirmtime;

    /** nullable persistent field */
    private java.util.Date createtime;
    
    private String paymentcode;
    private java.util.Date paymenttime;
    private String paymentmode;
    private Double prepaidlamt;

    /** full constructor */
    public AdpaysumVO(java.lang.String discomcode, java.util.Date begintime, java.util.Date endtime, java.lang.String state, java.lang.Double orderamt, java.lang.Double cancelamt, java.lang.Double recamt, java.lang.String submitcode, java.util.Date submittime, java.lang.String confirmcode, java.util.Date confirmtime, java.util.Date createtime) {
        this.discomcode = discomcode;
        this.begintime = begintime;
        this.endtime = endtime;
        this.state = state;
        this.orderamt = orderamt;
        this.cancelamt = cancelamt;
        this.recamt = recamt;
        this.submitcode = submitcode;
        this.submittime = submittime;
        this.confirmcode = confirmcode;
        this.confirmtime = confirmtime;
        this.createtime = createtime;
    }
    public AdpaysumVO(Long sumid, String discomcode, Date begintime,
			Date endtime, String state, Double orderamt, Double cancelamt,
			Double recamt, String submitcode, Date submittime,
			String confirmcode, Date confirmtime, Date createtime,
			String paymentcode, Date paymenttime, String paymentmode,
			Double prepaidlamt) {
		super();
		this.sumid = sumid;
		this.discomcode = discomcode;
		this.begintime = begintime;
		this.endtime = endtime;
		this.state = state;
		this.orderamt = orderamt;
		this.cancelamt = cancelamt;
		this.recamt = recamt;
		this.submitcode = submitcode;
		this.submittime = submittime;
		this.confirmcode = confirmcode;
		this.confirmtime = confirmtime;
		this.createtime = createtime;
		this.paymentcode = paymentcode;
		this.paymenttime = paymenttime;
		this.paymentmode = paymentmode;
		this.prepaidlamt = prepaidlamt;
	}

	/** default constructor */
    public AdpaysumVO() {
    }

    public java.lang.Long getSumid() {
        return this.sumid;
    }

    public void setSumid(java.lang.Long sumid) {
        this.sumid = sumid;
    }

    public java.lang.String getDiscomcode() {
        return this.discomcode;
    }

    public void setDiscomcode(java.lang.String discomcode) {
        this.discomcode = discomcode;
    }

    public java.util.Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public java.lang.Double getOrderamt() {
        return this.orderamt;
    }

    public void setOrderamt(java.lang.Double orderamt) {
        this.orderamt = orderamt;
    }

    public java.lang.Double getCancelamt() {
        return this.cancelamt;
    }

    public void setCancelamt(java.lang.Double cancelamt) {
        this.cancelamt = cancelamt;
    }

    public java.lang.Double getRecamt() {
        return this.recamt;
    }

    public void setRecamt(java.lang.Double recamt) {
        this.recamt = recamt;
    }

    public java.lang.String getSubmitcode() {
        return this.submitcode;
    }

    public void setSubmitcode(java.lang.String submitcode) {
        this.submitcode = submitcode;
    }

    public java.util.Date getSubmittime() {
        return this.submittime;
    }

    public void setSubmittime(java.util.Date submittime) {
        this.submittime = submittime;
    }

    public java.lang.String getConfirmcode() {
        return this.confirmcode;
    }

    public void setConfirmcode(java.lang.String confirmcode) {
        this.confirmcode = confirmcode;
    }

    public java.util.Date getConfirmtime() {
        return this.confirmtime;
    }

    public void setConfirmtime(java.util.Date confirmtime) {
        this.confirmtime = confirmtime;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }
    public String getPaymentcode() {
		return paymentcode;
	}
	public void setPaymentcode(String paymentcode) {
		this.paymentcode = paymentcode;
	}
	public java.util.Date getPaymenttime() {
		return paymenttime;
	}
	public void setPaymenttime(java.util.Date paymenttime) {
		this.paymenttime = paymenttime;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public Double getPrepaidlamt() {
		return prepaidlamt;
	}
	public void setPrepaidlamt(Double prepaidlamt) {
		this.prepaidlamt = prepaidlamt;
	}
	public String toString() {
        return new ToStringBuilder(this)
            .append("sumid", getSumid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AdpaysumVO) ) return false;
        AdpaysumVO castOther = (AdpaysumVO) other;
        return new EqualsBuilder()
            .append(this.getSumid(), castOther.getSumid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSumid())
            .toHashCode();
    }

}
