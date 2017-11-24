package com.sunrise.boss.business.cms.rewardpunish.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.rewardpunishlog.persistent.RewardpunishlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class RewardpunishVO implements OperationLog {

    /** identifier field */
    private Long recordid;

    /** persistent field */
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
    public RewardpunishVO(java.lang.String objectid, java.lang.String wayid, java.lang.String waytype, java.util.Date rptime, java.lang.String rpname, java.lang.String rpcause, java.lang.String rpplan) {
        this.objectid = objectid;
        this.wayid = wayid;
        this.waytype = waytype;
        this.rptime = rptime;
        this.rpname = rpname;
        this.rpcause = rpcause;
        this.rpplan = rpplan;
    }

    /** default constructor */
    public RewardpunishVO() {
    }

    /** minimal constructor */
    public RewardpunishVO(java.lang.String objectid) {
        this.objectid = objectid;
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
            .append("recordid", getRecordid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardpunishVO) ) return false;
        RewardpunishVO castOther = (RewardpunishVO) other;
        return new EqualsBuilder()
            .append(this.getRecordid(), castOther.getRecordid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecordid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return RewardpunishlogVO.class;
	}

}
