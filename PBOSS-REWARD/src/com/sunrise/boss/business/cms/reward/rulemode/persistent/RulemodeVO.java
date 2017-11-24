package com.sunrise.boss.business.cms.reward.rulemode.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.rulemodelog.persistent.RulemodelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class RulemodeVO implements OperationLog {

    /** identifier field */
    private Long rulemodeid;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String rulemodename;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public RulemodeVO(java.lang.Long rulemodeid, java.lang.String ruleid, java.lang.String cityid, java.lang.String rulemodename, java.util.Date startdate, java.util.Date enddate, java.lang.String remark) {
        this.rulemodeid = rulemodeid;
        this.ruleid = ruleid;
        this.cityid = cityid;
        this.rulemodename = rulemodename;
        this.startdate = startdate;
        this.enddate = enddate;
        this.remark = remark;
    }

    /** default constructor */
    public RulemodeVO() {
    }

    /** minimal constructor */
    public RulemodeVO(java.lang.Long rulemodeid) {
        this.rulemodeid = rulemodeid;
    }

    public java.lang.Long getRulemodeid() {
        return this.rulemodeid;
    }

    public void setRulemodeid(java.lang.Long rulemodeid) {
        this.rulemodeid = rulemodeid;
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

    public java.lang.String getRulemodename() {
        return this.rulemodename;
    }

    public void setRulemodename(java.lang.String rulemodename) {
        this.rulemodename = rulemodename;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("rulemodeid", getRulemodeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RulemodeVO) ) return false;
        RulemodeVO castOther = (RulemodeVO) other;
        return new EqualsBuilder()
            .append(this.getRulemodeid(), castOther.getRulemodeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRulemodeid())
            .toHashCode();
    }

	public Class logVOClass() {
		return RulemodelogVO.class;
	}

}
