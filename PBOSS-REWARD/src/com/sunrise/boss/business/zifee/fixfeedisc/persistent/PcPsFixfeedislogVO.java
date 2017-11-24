package com.sunrise.boss.business.zifee.fixfeedisc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PcPsFixfeedislogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.sql.Timestamp optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long yxplanid;

    /** nullable persistent field */
    private Long fixfeediscid;

    /** nullable persistent field */
    private Long acctid;

    /** nullable persistent field */
    private Byte disctype;

    /** nullable persistent field */
    private Float recdisamt;

    /** nullable persistent field */
    private Float disccount;

    /** nullable persistent field */
    private String disccondition;

    /** full constructor */
    public PcPsFixfeedislogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long yxplanid, java.lang.Long fixfeediscid, java.lang.Long acctid, java.lang.Byte disctype, java.lang.Float recdisamt, java.lang.Float disccount, java.lang.String disccondition) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.yxplanid = yxplanid;
        this.fixfeediscid = fixfeediscid;
        this.acctid = acctid;
        this.disctype = disctype;
        this.recdisamt = recdisamt;
        this.disccount = disccount;
        this.disccondition = disccondition;
    }

    /** default constructor */
    public PcPsFixfeedislogVO() {
    }

    /** minimal constructor */
    public PcPsFixfeedislogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.sql.Timestamp getOptime() {
        return this.optime;
    }

    public void setOptime(java.sql.Timestamp optime) {
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

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getFixfeediscid() {
        return this.fixfeediscid;
    }

    public void setFixfeediscid(java.lang.Long fixfeediscid) {
        this.fixfeediscid = fixfeediscid;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.Byte getDisctype() {
        return this.disctype;
    }

    public void setDisctype(java.lang.Byte disctype) {
        this.disctype = disctype;
    }

    public java.lang.Float getRecdisamt() {
        return this.recdisamt;
    }

    public void setRecdisamt(java.lang.Float recdisamt) {
        this.recdisamt = recdisamt;
    }

    public java.lang.Float getDisccount() {
        return this.disccount;
    }

    public void setDisccount(java.lang.Float disccount) {
        this.disccount = disccount;
    }

    public java.lang.String getDisccondition() {
        return this.disccondition;
    }

    public void setDisccondition(java.lang.String disccondition) {
        this.disccondition = disccondition;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PcPsFixfeedislogVO) ) return false;
        PcPsFixfeedislogVO castOther = (PcPsFixfeedislogVO) other;
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
