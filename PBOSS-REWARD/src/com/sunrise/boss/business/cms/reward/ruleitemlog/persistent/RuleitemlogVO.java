package com.sunrise.boss.business.cms.reward.ruleitemlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RuleitemlogVO implements Serializable {

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
    private String ruleitemid;

    /** nullable persistent field */
    private String ruleitemname;

    /** nullable persistent field */
    private String backruleitemid;

    /** nullable persistent field */
    private String contype;

    /** nullable persistent field */
    private Byte specflag;

    /** full constructor */
    public RuleitemlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String ruleitemid, java.lang.String ruleitemname, java.lang.String backruleitemid, java.lang.String contype, java.lang.Byte specflag) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.ruleitemid = ruleitemid;
        this.ruleitemname = ruleitemname;
        this.backruleitemid = backruleitemid;
        this.contype = contype;
        this.specflag = specflag;
    }

    /** default constructor */
    public RuleitemlogVO() {
    }

    /** minimal constructor */
    public RuleitemlogVO(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.String getRuleitemid() {
        return this.ruleitemid;
    }

    public void setRuleitemid(java.lang.String ruleitemid) {
        this.ruleitemid = ruleitemid;
    }

    public java.lang.String getRuleitemname() {
        return this.ruleitemname;
    }

    public void setRuleitemname(java.lang.String ruleitemname) {
        this.ruleitemname = ruleitemname;
    }

    public java.lang.String getBackruleitemid() {
        return this.backruleitemid;
    }

    public void setBackruleitemid(java.lang.String backruleitemid) {
        this.backruleitemid = backruleitemid;
    }

    public java.lang.String getContype() {
        return this.contype;
    }

    public void setContype(java.lang.String contype) {
        this.contype = contype;
    }

    public java.lang.Byte getSpecflag() {
        return this.specflag;
    }

    public void setSpecflag(java.lang.Byte specflag) {
        this.specflag = specflag;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RuleitemlogVO) ) return false;
        RuleitemlogVO castOther = (RuleitemlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
