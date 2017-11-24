package com.sunrise.boss.business.cms.rewardpunishlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardpunishlogVO implements Serializable {

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
    private Long recordid;

    /** nullable persistent field */
    private String objectid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String waytype;

    /** nullable persistent field */
    private java.util.Date rptime;

    /** nullable persistent field */
    private String rpname;

    /** nullable persistent field */
    private String rpcause;

    /** nullable persistent field */
    private String rpplan;

    /** full constructor */
    public RewardpunishlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long recordid, java.lang.String objectid, java.lang.String wayid, java.lang.String waytype, java.util.Date rptime, java.lang.String rpname, java.lang.String rpcause, java.lang.String rpplan) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.recordid = recordid;
        this.objectid = objectid;
        this.wayid = wayid;
        this.waytype = waytype;
        this.rptime = rptime;
        this.rpname = rpname;
        this.rpcause = rpcause;
        this.rpplan = rpplan;
    }

    /** default constructor */
    public RewardpunishlogVO() {
    }

    /** minimal constructor */
    public RewardpunishlogVO(java.lang.Long logid) {
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

    public java.lang.Long getRecordid() {
        return this.recordid;
    }

    public void setRecordid(java.lang.Long recordid) {
        this.recordid = recordid;
    }

    public java.lang.String getObjectid() {
        return this.objectid;
    }

    public void setObjectid(java.lang.String objectid) {
        this.objectid = objectid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWaytype() {
        return this.waytype;
    }

    public void setWaytype(java.lang.String waytype) {
        this.waytype = waytype;
    }

    public java.util.Date getRptime() {
        return this.rptime;
    }

    public void setRptime(java.util.Date rptime) {
        this.rptime = rptime;
    }

    public java.lang.String getRpname() {
        return this.rpname;
    }

    public void setRpname(java.lang.String rpname) {
        this.rpname = rpname;
    }

    public java.lang.String getRpcause() {
        return this.rpcause;
    }

    public void setRpcause(java.lang.String rpcause) {
        this.rpcause = rpcause;
    }

    public java.lang.String getRpplan() {
        return this.rpplan;
    }

    public void setRpplan(java.lang.String rpplan) {
        this.rpplan = rpplan;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardpunishlogVO) ) return false;
        RewardpunishlogVO castOther = (RewardpunishlogVO) other;
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
