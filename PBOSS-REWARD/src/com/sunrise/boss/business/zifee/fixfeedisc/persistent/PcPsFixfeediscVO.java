package com.sunrise.boss.business.zifee.fixfeedisc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeedislogVO;

/** @author Hibernate CodeGenerator */
public class PcPsFixfeediscVO implements Serializable, OperationLog {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {    	
    	return PcPsFixfeedislogVO.class;
    }
	/** identifier field */
    private Long fixfeediscid;

    /** identifier field */
    private Long yxplanid;

    /** nullable persistent field */
    private Long acctid;
    
    private Long disctype;

    /** nullable persistent field */
    private Float recdisamt;

    /** nullable persistent field */
    private Float disccount;


    /** full constructor */
    public PcPsFixfeediscVO(java.lang.Long fixfeediscid, java.lang.Long yxplanid, java.lang.Long acctid,java.lang.Long disctype, java.lang.Float recdisamt, java.lang.Float disccount, java.lang.String disccondiotion) {
        this.fixfeediscid = fixfeediscid;
        this.yxplanid = yxplanid;
        this.acctid = acctid;
        this.disctype = disctype;
        this.recdisamt = recdisamt;
        this.disccount = disccount;
    }

    /** default constructor */
    public PcPsFixfeediscVO() {
    }

    /** minimal constructor */
    public PcPsFixfeediscVO(java.lang.Long fixfeediscid, java.lang.Long yxplanid) {
        this.fixfeediscid = fixfeediscid;
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getFixfeediscid() {
        return this.fixfeediscid;
    }

    public void setFixfeediscid(java.lang.Long fixfeediscid) {
        this.fixfeediscid = fixfeediscid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }
    
    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }   
    public java.lang.Long getDisctype() {
        return this.disctype;
    }

    public void setDisctype(java.lang.Long disctype) {
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("fixfeediscid", getFixfeediscid())
            .append("yxplanid", getYxplanid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PcPsFixfeediscVO) ) return false;
        PcPsFixfeediscVO castOther = (PcPsFixfeediscVO) other;
        return new EqualsBuilder()
            .append(this.getFixfeediscid(), castOther.getFixfeediscid())
            .append(this.getYxplanid(), castOther.getYxplanid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFixfeediscid())
            .append(getYxplanid())
            .toHashCode();
    }

}
