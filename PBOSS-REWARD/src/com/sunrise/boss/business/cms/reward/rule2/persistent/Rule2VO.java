package com.sunrise.boss.business.cms.reward.rule2.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class Rule2VO implements Serializable {

	/** identifier field */
	private String ruleid;

	/** nullable persistent field */
	private String rulename;

	/** nullable persistent field */
	private java.util.Date startdate;

	/** nullable persistent field */
	private java.util.Date enddate;

	/** nullable persistent field */
	private String remark;

	/** nullable persistent field */
	private String ruleitemid;

	/** nullable persistent field */
	private String ruleitemname;

	private String opnid;

	private String name;
	
	private Short state;
	
	/** extend fields */
	private String ruletype;

	public String getRuletype() {
		return ruletype;
	}

	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/** full constructor */
	public Rule2VO(java.lang.String ruleid, java.lang.String rulename,
			java.util.Date startdate, java.util.Date enddate,
			java.lang.String remark, java.lang.String ruleitemid,
			java.lang.String ruleitemname, String opnid) {
		this.ruleid = ruleid;
		this.rulename = rulename;
		this.startdate = startdate;
		this.enddate = enddate;
		this.remark = remark;
		this.ruleitemid = ruleitemid;
		this.ruleitemname = ruleitemname;
		this.opnid = opnid;
	}

	/** default constructor */
	public Rule2VO() {
	}

	/** minimal constructor */
	public Rule2VO(java.lang.String ruleid) {
		this.ruleid = ruleid;
	}

	public java.lang.String getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(java.lang.String ruleid) {
		this.ruleid = ruleid;
	}

	public java.lang.String getRulename() {
		return this.rulename;
	}

	public void setRulename(java.lang.String rulename) {
		this.rulename = rulename;
	}

	public java.util.Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public java.util.Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(java.util.Date enddate) {
		this.enddate = enddate;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
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

	public String toString() {
		return new ToStringBuilder(this).append("ruleid", getRuleid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof Rule2VO))
			return false;
		Rule2VO castOther = (Rule2VO) other;
		return new EqualsBuilder().append(this.getRuleid(),
				castOther.getRuleid()).append(this.getRuleitemid(), castOther.getRuleitemid()).append(this.getOpnid(), castOther.getOpnid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRuleid()).append(getRuleitemid()).append(getOpnid()).toHashCode();
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

}
