package com.sunrise.boss.business.cms.bbc.directory.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DirectoryVO implements Serializable {

    /** identifier field */
    private String opnid;

    /** nullable persistent field */
    private String firstlevel;

    /** nullable persistent field */
    private String secondlevel;

    /** nullable persistent field */
    private String thirdlevel;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String servicecode;

    /** nullable persistent field */
    private String reward;

    /** nullable persistent field */
    private Float rewardstd;

    /** nullable persistent field */
    private String rule;

    /** full constructor */
    public DirectoryVO(java.lang.String opnid, java.lang.String firstlevel, java.lang.String secondlevel, java.lang.String thirdlevel, java.lang.String name, java.lang.String servicecode, java.lang.String reward, java.lang.Float rewardstd, java.lang.String rule) {
        this.opnid = opnid;
        this.firstlevel = firstlevel;
        this.secondlevel = secondlevel;
        this.thirdlevel = thirdlevel;
        this.name = name;
        this.servicecode = servicecode;
        this.reward = reward;
        this.rewardstd = rewardstd;
        this.rule = rule;
    }

    /** default constructor */
    public DirectoryVO() {
    }

    /** minimal constructor */
    public DirectoryVO(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getFirstlevel() {
        return this.firstlevel;
    }

    public void setFirstlevel(java.lang.String firstlevel) {
        this.firstlevel = firstlevel;
    }

    public java.lang.String getSecondlevel() {
        return this.secondlevel;
    }

    public void setSecondlevel(java.lang.String secondlevel) {
        this.secondlevel = secondlevel;
    }

    public java.lang.String getThirdlevel() {
        return this.thirdlevel;
    }

    public void setThirdlevel(java.lang.String thirdlevel) {
        this.thirdlevel = thirdlevel;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getServicecode() {
        return this.servicecode;
    }

    public void setServicecode(java.lang.String servicecode) {
        this.servicecode = servicecode;
    }

    public java.lang.String getReward() {
        return this.reward;
    }

    public void setReward(java.lang.String reward) {
        this.reward = reward;
    }

    public java.lang.Float getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Float rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.String getRule() {
        return this.rule;
    }

    public void setRule(java.lang.String rule) {
        this.rule = rule;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DirectoryVO) ) return false;
        DirectoryVO castOther = (DirectoryVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .toHashCode();
    }

}
