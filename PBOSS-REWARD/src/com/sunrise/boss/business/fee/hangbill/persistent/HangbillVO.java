package com.sunrise.boss.business.fee.hangbill.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class HangbillVO implements Serializable {

    /** identifier field */
    private Long hangid;

    /** persistent field */
    private Long eboxid;

    /** persistent field */
    private Long subsid;

    /** persistent field */
    private Long acctid;

    /** persistent field */
    private Integer validbillcyc;

    /** persistent field */
    private Integer hangstate;

    /** nullable persistent field */
    private Double hangamt;

    /** nullable persistent field */
    private Double dispute;

    /** persistent field */
    private  Integer hangtype;

    /** nullable persistent field */
    private String hangoprcode;

    /** nullable persistent field */
    private String checkercode;

    /** nullable persistent field */
    private java.sql.Timestamp hangtime;

    /** nullable persistent field */
    private java.util.Date back;

    /** nullable persistent field */
    private Double checkdecr;

    /** nullable persistent field */
    private String unite;

    /** nullable persistent field */
    private Long billchecklogid;

    /** nullable persistent field */
    private String lrsncode;

    /** nullable persistent field */
    private String srsncode;

    /** nullable persistent field */
    private Integer isicp;

    /** nullable persistent field */
    private String portid;

    /** nullable persistent field */
    private String icptype;

    /** nullable persistent field */
    private String lodge;

    /** nullable persistent field */
    private Integer isaward;

    /** nullable persistent field */
    private String memo;

    private String mobileno;
    
    public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	/** full constructor */
    public HangbillVO(java.lang.Long hangid, java.lang.Long eboxid, java.lang.Long subsid, java.lang.Long acctid, java.lang.Integer validbillcyc, java.lang.Integer hangstate, java.lang.Double hangamt, java.lang.Double dispute, java.lang.Integer hangtype, java.lang.String hangoprcode, java.lang.String checkercode, java.sql.Timestamp hangtime, java.util.Date back, java.lang.Double checkdecr, java.lang.String unite, java.lang.Long billchecklogid, java.lang.String lrsncode, java.lang.String srsncode, java.lang.Integer isicp, java.lang.String portid, java.lang.String icptype, java.lang.String lodge, java.lang.Integer isaward, java.lang.String memo) {
        this.hangid = hangid;
        this.eboxid = eboxid;
        this.subsid = subsid;
        this.acctid = acctid;
        this.validbillcyc = validbillcyc;
        this.hangstate = hangstate;
        this.hangamt = hangamt;
        this.dispute = dispute;
        this.hangtype = hangtype;
        this.hangoprcode = hangoprcode;
        this.checkercode = checkercode;
        this.hangtime = hangtime;
        this.back = back;
        this.checkdecr = checkdecr;
        this.unite = unite;
        this.billchecklogid = billchecklogid;
        this.lrsncode = lrsncode;
        this.srsncode = srsncode;
        this.isicp = isicp;
        this.portid = portid;
        this.icptype = icptype;
        this.lodge = lodge;
        this.isaward = isaward;
        this.memo = memo;
    }

    /** default constructor */
    public HangbillVO() {
    }

    /** minimal constructor */
    public HangbillVO(java.lang.Long hangid, java.lang.Long eboxid, java.lang.Long subsid, java.lang.Long acctid, java.lang.Integer validbillcyc, java.lang.Integer hangstate, java.lang.Integer hangtype) {
        this.hangid = hangid;
        this.eboxid = eboxid;
        this.subsid = subsid;
        this.acctid = acctid;
        this.validbillcyc = validbillcyc;
        this.hangstate = hangstate;
        this.hangtype = hangtype;
    }

    public java.lang.Long getHangid() {
        return this.hangid;
    }

    public void setHangid(java.lang.Long hangid) {
        this.hangid = hangid;
    }

    public java.lang.Long getEboxid() {
        return this.eboxid;
    }

    public void setEboxid(java.lang.Long eboxid) {
        this.eboxid = eboxid;
    }

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.Integer getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.Integer validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public Integer getHangstate() {
        return this.hangstate;
    }

    public void setHangstate(Integer hangstate) {
        this.hangstate = hangstate;
    }

    public java.lang.Double getHangamt() {
        return this.hangamt;
    }

    public void setHangamt(java.lang.Double hangamt) {
        this.hangamt = hangamt;
    }

    public java.lang.Double getDispute() {
        return this.dispute;
    }

    public void setDispute(java.lang.Double dispute) {
        this.dispute = dispute;
    }

    public java.lang.Integer getHangtype() {
        return this.hangtype;
    }

    public void setHangtype(java.lang.Integer hangtype) {
        this.hangtype = hangtype;
    }

    public java.lang.String getHangoprcode() {
        return this.hangoprcode;
    }

    public void setHangoprcode(java.lang.String hangoprcode) {
        this.hangoprcode = hangoprcode;
    }

    public java.lang.String getCheckercode() {
        return this.checkercode;
    }

    public void setCheckercode(java.lang.String checkercode) {
        this.checkercode = checkercode;
    }

    public java.sql.Timestamp getHangtime() {
        return this.hangtime;
    }

    public void setHangtime(java.sql.Timestamp hangtime) {
        this.hangtime = hangtime;
    }

    public java.util.Date getBack() {
        return this.back;
    }

    public void setBack(java.util.Date back) {
        this.back = back;
    }

    public java.lang.Double getCheckdecr() {
        return this.checkdecr;
    }

    public void setCheckdecr(java.lang.Double checkdecr) {
        this.checkdecr = checkdecr;
    }

    public java.lang.String getUnite() {
        return this.unite;
    }

    public void setUnite(java.lang.String unite) {
        this.unite = unite;
    }

    public java.lang.Long getBillchecklogid() {
        return this.billchecklogid;
    }

    public void setBillchecklogid(java.lang.Long billchecklogid) {
        this.billchecklogid = billchecklogid;
    }

    public java.lang.String getLrsncode() {
        return this.lrsncode;
    }

    public void setLrsncode(java.lang.String lrsncode) {
        this.lrsncode = lrsncode;
    }

    public java.lang.String getSrsncode() {
        return this.srsncode;
    }

    public void setSrsncode(java.lang.String srsncode) {
        this.srsncode = srsncode;
    }

    public java.lang.Integer getIsicp() {
        return this.isicp;
    }

    public void setIsicp(java.lang.Integer isicp) {
        this.isicp = isicp;
    }

    public java.lang.String getPortid() {
        return this.portid;
    }

    public void setPortid(java.lang.String portid) {
        this.portid = portid;
    }

    public java.lang.String getIcptype() {
        return this.icptype;
    }

    public void setIcptype(java.lang.String icptype) {
        this.icptype = icptype;
    }

    public java.lang.String getLodge() {
        return this.lodge;
    }

    public void setLodge(java.lang.String lodge) {
        this.lodge = lodge;
    }

    public java.lang.Integer getIsaward() {
        return this.isaward;
    }

    public void setIsaward(java.lang.Integer isaward) {
        this.isaward = isaward;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hangid", getHangid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof HangbillVO) ) return false;
        HangbillVO castOther = (HangbillVO) other;
        return new EqualsBuilder()
            .append(this.getHangid(), castOther.getHangid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHangid())
            .toHashCode();
    }

}