package com.sunrise.boss.business.fee.persistent.creditreq;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CreditReqVO implements Serializable {

    /** identifier field */
    private Long creditreqid;

    /** persistent field */
    private Long subsid;

    /** nullable persistent field */
    private Long eboxid;

    /** persistent field */
    private Short reqtype;
    private Short reqsource;

    /** persistent field */
    private java.util.Date reqtime;

    /** nullable persistent field */
    private Short dealstate;

    /** persistent field */
    private Long ruleid;

    /** nullable persistent field */
    private String param;
   
    private String opercode;
    

    
   

	

	/** default constructor */
    public CreditReqVO() {
    }

  

    public java.lang.Long getCreditreqid() {
        return this.creditreqid;
    }

    public void setCreditreqid(java.lang.Long creditreqid) {
        this.creditreqid = creditreqid;
    }

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.Long getEboxid() {
        return this.eboxid;
    }

    public void setEboxid(java.lang.Long eboxid) {
        this.eboxid = eboxid;
    }

    public java.lang.Short getReqtype() {
        return this.reqtype;
    }

    public void setReqtype(java.lang.Short reqtype) {
        this.reqtype = reqtype;
    }

    public java.util.Date getReqtime() {
        return this.reqtime;
    }

    public void setReqtime(java.util.Date reqtime) {
        this.reqtime = reqtime;
    }

    public java.lang.Short getDealstate() {
        return this.dealstate;
    }

    public void setDealstate(java.lang.Short dealstate) {
        this.dealstate = dealstate;
    }

    public java.lang.Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getParam() {
        return this.param;
    }

    public void setParam(java.lang.String param) {
        this.param = param;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("creditreqid", getCreditreqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CreditReqVO) ) return false;
        CreditReqVO castOther = (CreditReqVO) other;
        return new EqualsBuilder()
            .append(this.getCreditreqid(), castOther.getCreditreqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCreditreqid())
            .toHashCode();
    }

	public Short getReqsource() {
		return reqsource;
	}

	public void setReqsource(Short reqsource) {
		this.reqsource = reqsource;
	}

	public String getOpercode() {
		return opercode;
	}

	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}



}
