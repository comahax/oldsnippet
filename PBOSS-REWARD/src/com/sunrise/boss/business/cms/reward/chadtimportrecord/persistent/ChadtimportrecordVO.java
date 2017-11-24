package com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChadtimportrecordVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Long importtype;

    /** nullable persistent field */
    private java.util.Date runtime;

    /** nullable persistent field */
    private String opercode;
    
    private Double amt;
    
    private Double assegrade;
    
    private String remark;

    
    public Double getAssegrade() {
		return assegrade;
	}

	public void setAssegrade(Double assegrade) {
		this.assegrade = assegrade;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

	/** full constructor */
    public ChadtimportrecordVO(java.lang.String wayid, java.lang.String mobile, java.lang.String opnid, java.util.Date oprtime, java.lang.Long importtype, java.util.Date runtime, java.lang.String opercode) {
        this.wayid = wayid;
        this.mobile = mobile;
        this.opnid = opnid;
        this.oprtime = oprtime;
        this.importtype = importtype;
        this.runtime = runtime;
        this.opercode = opercode;
    }
    
    public ChadtimportrecordVO(java.lang.String wayid, java.lang.String mobile, java.lang.String opnid, java.util.Date oprtime, 
    		java.lang.Long importtype, java.util.Date runtime, java.lang.String opercode, Double amt, Double assegrade, String remark) {
        this.wayid = wayid;
        this.mobile = mobile;
        this.opnid = opnid;
        this.oprtime = oprtime;
        this.importtype = importtype;
        this.runtime = runtime;
        this.opercode = opercode;
        this.amt = amt;
        this.assegrade = assegrade;
        this.remark = remark;
    }

    /** default constructor */
    public ChadtimportrecordVO() {
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

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.Long getImporttype() {
        return this.importtype;
    }

    public void setImporttype(java.lang.Long importtype) {
        this.importtype = importtype;
    }

    public java.util.Date getRuntime() {
        return this.runtime;
    }

    public void setRuntime(java.util.Date runtime) {
        this.runtime = runtime;
    }

    public java.lang.String getOpercode() {
        return this.opercode;
    }

    public void setOpercode(java.lang.String opercode) {
        this.opercode = opercode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChadtimportrecordVO) ) return false;
        ChadtimportrecordVO castOther = (ChadtimportrecordVO) other;
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
