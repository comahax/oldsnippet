package com.sunrise.boss.business.cms.reward.assess.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AssessVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Long assesstype;

    /** nullable persistent field */
    private Double value;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private String opercode;

    /** nullable persistent field */
    private String opertype;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String calcmonth;

    /** full constructor */
    public AssessVO(java.lang.String wayid, java.lang.Long assesstype, java.lang.Double value, java.lang.String remark, java.lang.String opercode, java.lang.String opertype, java.util.Date oprtime, java.lang.String calcmonth) {
        this.wayid = wayid;
        this.assesstype = assesstype;
        this.value = value;
        this.remark = remark;
        this.opercode = opercode;
        this.opertype = opertype;
        this.oprtime = oprtime;
        this.calcmonth = calcmonth;
    }

    /** default constructor */
    public AssessVO() {
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

    public java.lang.Long getAssesstype() {
        return this.assesstype;
    }

    public void setAssesstype(java.lang.Long assesstype) {
        this.assesstype = assesstype;
    }

    public java.lang.Double getValue() {
        return this.value;
    }

    public void setValue(java.lang.Double value) {
        this.value = value;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.String getOpercode() {
        return this.opercode;
    }

    public void setOpercode(java.lang.String opercode) {
        this.opercode = opercode;
    }


    public String getOpertype() {
		return opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AssessVO) ) return false;
        AssessVO castOther = (AssessVO) other;
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
