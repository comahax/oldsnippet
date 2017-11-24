package com.sunrise.boss.business.cms.reward.rulerellog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RulerellogVO implements Serializable {

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
    private String ruleid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private Short isdefault;
    
    private Long rulemodeid;
    
    private String paramer;

    /** full constructor */
    public RulerellogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String ruleitemid, java.lang.String ruleid, java.lang.String cityid, java.lang.Short state, java.lang.Short isdefault, java.lang.Long rulemodeid ,java.lang.String paramer) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.ruleitemid = ruleitemid;
        this.ruleid = ruleid;
        this.cityid = cityid;
        this.state = state;
        this.isdefault = isdefault;
        this.rulemodeid = rulemodeid;
        this.paramer =paramer;
    }

    public Long getRulemodeid() {
		return rulemodeid;
	}

	public void setRulemodeid(Long rulemodeid) {
		this.rulemodeid = rulemodeid;
	}

	/** default constructor */
    public RulerellogVO() {
    }

    /** minimal constructor */
    public RulerellogVO(java.lang.Long logid) {
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

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.Short getIsdefault() {
        return this.isdefault;
    }

    public void setIsdefault(java.lang.Short isdefault) {
        this.isdefault = isdefault;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RulerellogVO) ) return false;
        RulerellogVO castOther = (RulerellogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public String getParamer() {
		return paramer;
	}

	public void setParamer(String paramer) {
		this.paramer = paramer;
	}

    
}
