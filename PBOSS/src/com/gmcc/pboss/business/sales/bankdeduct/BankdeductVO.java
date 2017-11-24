package com.gmcc.pboss.business.sales.bankdeduct;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BankdeductVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long deductid;

    /** persistent field */
    private String orderid;

    /** nullable persistent field */
    private String bankid;

    /** nullable persistent field */
    private String acctnum;

    /** nullable persistent field */
    private Short accttype;

    /** nullable persistent field */
    private String acctname;

    /** nullable persistent field */
    private Double deductamt;

    /** nullable persistent field */
    private java.util.Date creatdate;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private java.util.Date statechgtime;

    /** nullable persistent field */
    private String shopnum;

    /** nullable persistent field */
    private String terminalnum;

    /** nullable persistent field */
    private String respcode;

    /** nullable persistent field */
    private String callnum;
    
    private Short formtype;
    
    private String errmsg;

    private String reqsn;
    
   

    public BankdeductVO(Long deductid, String orderid, String bankid,
			String acctnum, Short accttype, String acctname, Double deductamt,
			Date creatdate, String state, Date statechgtime, String shopnum,
			String terminalnum, String respcode, String callnum,
			Short formtype, String errmsg, String reqsn) {
		super();
		this.deductid = deductid;
		this.orderid = orderid;
		this.bankid = bankid;
		this.acctnum = acctnum;
		this.accttype = accttype;
		this.acctname = acctname;
		this.deductamt = deductamt;
		this.creatdate = creatdate;
		this.state = state;
		this.statechgtime = statechgtime;
		this.shopnum = shopnum;
		this.terminalnum = terminalnum;
		this.respcode = respcode;
		this.callnum = callnum;
		this.formtype = formtype;
		this.errmsg = errmsg;
		this.reqsn = reqsn;
	}

	/** default constructor */
    public BankdeductVO() {
    }

    /** minimal constructor */
    public BankdeductVO(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.Long getDeductid() {
        return this.deductid;
    }

    public void setDeductid(java.lang.Long deductid) {
        this.deductid = deductid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getBankid() {
        return this.bankid;
    }

    public void setBankid(java.lang.String bankid) {
        this.bankid = bankid;
    }

    public java.lang.String getAcctnum() {
        return this.acctnum;
    }

    public void setAcctnum(java.lang.String acctnum) {
        this.acctnum = acctnum;
    }

    public java.lang.Short getAccttype() {
        return this.accttype;
    }

    public void setAccttype(java.lang.Short accttype) {
        this.accttype = accttype;
    }

    public java.lang.String getAcctname() {
        return this.acctname;
    }

    public void setAcctname(java.lang.String acctname) {
        this.acctname = acctname;
    }

    public java.lang.Double getDeductamt() {
        return this.deductamt;
    }

    public void setDeductamt(java.lang.Double deductamt) {
        this.deductamt = deductamt;
    }

    public java.util.Date getCreatdate() {
        return this.creatdate;
    }

    public void setCreatdate(java.util.Date creatdate) {
        this.creatdate = creatdate;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public java.util.Date getStatechgtime() {
        return this.statechgtime;
    }

    public void setStatechgtime(java.util.Date statechgtime) {
        this.statechgtime = statechgtime;
    }

    public java.lang.String getShopnum() {
        return this.shopnum;
    }

    public void setShopnum(java.lang.String shopnum) {
        this.shopnum = shopnum;
    }

    public java.lang.String getTerminalnum() {
        return this.terminalnum;
    }

    public void setTerminalnum(java.lang.String terminalnum) {
        this.terminalnum = terminalnum;
    }

    public java.lang.String getRespcode() {
        return this.respcode;
    }

    public void setRespcode(java.lang.String respcode) {
        this.respcode = respcode;
    }

    public java.lang.String getCallnum() {
        return this.callnum;
    }

    public void setCallnum(java.lang.String callnum) {
        this.callnum = callnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("deductid", getDeductid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BankdeductVO) ) return false;
        BankdeductVO castOther = (BankdeductVO) other;
        return new EqualsBuilder()
            .append(this.getDeductid(), castOther.getDeductid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDeductid())
            .toHashCode();
    }

	public Short getFormtype() {
		return formtype;
	}

	public void setFormtype(Short formtype) {
		this.formtype = formtype;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getReqsn() {
		return reqsn;
	}

	public void setReqsn(String reqsn) {
		this.reqsn = reqsn;
	}

}
