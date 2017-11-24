package com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RbEboxChgLogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private Long subsid;

    /** nullable persistent field */
    private Short baltype;

    /** nullable persistent field */
    private Long chgamt;

    /** nullable persistent field */
    private Long afterchgamt;

    /** nullable persistent field */
    private String opercode;

    /** nullable persistent field */
    private String reason;

    /** nullable persistent field */
    private String reason2;

    /** nullable persistent field */
    private java.util.Date chgtime;

    /** nullable persistent field */
    private Long yxplanid;

    /** nullable persistent field */
    private Long baseamt;

    /** nullable persistent field */
    private Long presentamt;

    /** nullable persistent field */
    private Long invalidamt;

    /** nullable persistent field */
    private Short billflag;

    /** nullable persistent field */
    private String memo;
    
    /** nullable persistent field */
    private Short logtype;


    /** full constructor */
    public RbEboxChgLogVO(java.lang.Long logid, java.lang.Long subsid, java.lang.Short baltype, java.lang.Long chgamt, java.lang.Long afterchgamt, java.lang.String opercode, java.lang.String reason, java.lang.String reason2, java.util.Date chgtime, java.lang.Long yxplanid, java.lang.Long baseamt, java.lang.Long presentamt, java.lang.Long invalidamt, java.lang.Short billflag, java.lang.String memo,java.lang.Short logtype) {
        this.logid = logid;
        this.subsid = subsid;
        this.baltype = baltype;
        this.chgamt = chgamt;
        this.afterchgamt = afterchgamt;
        this.opercode = opercode;
        this.reason = reason;
        this.reason2 = reason2;
        this.chgtime = chgtime;
        this.yxplanid = yxplanid;
        this.baseamt = baseamt;
        this.presentamt = presentamt;
        this.invalidamt = invalidamt;
        this.billflag = billflag;
        this.memo = memo;
        this.logtype = logtype;
    }

    /** default constructor */
    public RbEboxChgLogVO() {
    }

    /** minimal constructor */
    public RbEboxChgLogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.Short getBaltype() {
        return this.baltype;
    }

    public void setBaltype(java.lang.Short baltype) {
        this.baltype = baltype;
    }

    public java.lang.Long getChgamt() {
        return this.chgamt;
    }

    public void setChgamt(java.lang.Long chgamt) {
        this.chgamt = chgamt;
    }

    public java.lang.Long getAfterchgamt() {
        return this.afterchgamt;
    }

    public void setAfterchgamt(java.lang.Long afterchgamt) {
        this.afterchgamt = afterchgamt;
    }

    public java.lang.String getOpercode() {
        return this.opercode;
    }

    public void setOpercode(java.lang.String opercode) {
        this.opercode = opercode;
    }

    public java.lang.String getReason() {
        return this.reason;
    }

    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    public java.lang.String getReason2() {
        return this.reason2;
    }

    public void setReason2(java.lang.String reason2) {
        this.reason2 = reason2;
    }

    public java.util.Date getChgtime() {
        return this.chgtime;
    }

    public void setChgtime(java.util.Date chgtime) {
        this.chgtime = chgtime;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getBaseamt() {
        return this.baseamt;
    }

    public void setBaseamt(java.lang.Long baseamt) {
        this.baseamt = baseamt;
    }

    public java.lang.Long getPresentamt() {
        return this.presentamt;
    }

    public void setPresentamt(java.lang.Long presentamt) {
        this.presentamt = presentamt;
    }

    public java.lang.Long getInvalidamt() {
        return this.invalidamt;
    }

    public void setInvalidamt(java.lang.Long invalidamt) {
        this.invalidamt = invalidamt;
    }

    public java.lang.Short getBillflag() {
        return this.billflag;
    }

    public void setBillflag(java.lang.Short billflag) {
        this.billflag = billflag;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RbEboxChgLogVO) ) return false;
        RbEboxChgLogVO castOther = (RbEboxChgLogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Short getLogtype() {
		return logtype;
	}

	public void setLogtype(Short logtype) {
		this.logtype = logtype;
	}

}
