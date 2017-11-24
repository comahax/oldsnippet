package com.sunrise.boss.business.fee.persistent.chkhangadj;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChkHangAdjVO implements Serializable {

    /** identifier field */
    private Long logdetid;

    /** persistent field */
    private Long billchecklogid;

    /** persistent field */
    private Long eboxid;

    /** persistent field */
    private Long subsid;

    /** persistent field */
    private Long acctid;

    /** persistent field */
    private Integer validbillcyc;

    /** nullable persistent field */
    private Double hangamt;

    /** nullable persistent field */
    private String hangoprcode;

    /** nullable persistent field */
    private String checkercode;

    /** nullable persistent field */
    private java.util.Date hangtime;

    /** nullable persistent field */
    private java.util.Date dealtime;

    /** nullable persistent field */
    private Short hangadjtype;

    /** nullable persistent field */
    private Double checkdecr;

    /** nullable persistent field */
    private Long incdecrid;

    /** nullable persistent field */
    private String lrsncode;

    /** nullable persistent field */
    private String srsncode;

    /** nullable persistent field */
    private Byte isicp;

    /** nullable persistent field */
    private String portid;

    /** nullable persistent field */
    private String icptype;

    /** nullable persistent field */
    private String lodge;

    /** nullable persistent field */
    private Short isaward;

    /** full constructor */
    public ChkHangAdjVO(java.lang.Long logdetid, java.lang.Long billchecklogid, java.lang.Long eboxid, java.lang.Long subsid, java.lang.Long acctid, java.lang.Integer validbillcyc, java.lang.Double hangamt, java.lang.String hangoprcode, java.lang.String checkercode, java.util.Date hangtime, java.util.Date dealtime, java.lang.Short hangadjtype, java.lang.Double checkdecr, java.lang.Long incdecrid, java.lang.String lrsncode, java.lang.String srsncode, java.lang.Byte isicp, java.lang.String portid, java.lang.String icptype, java.lang.String lodge, java.lang.Short isaward) {
        this.logdetid = logdetid;
        this.billchecklogid = billchecklogid;
        this.eboxid = eboxid;
        this.subsid = subsid;
        this.acctid = acctid;
        this.validbillcyc = validbillcyc;
        this.hangamt = hangamt;
        this.hangoprcode = hangoprcode;
        this.checkercode = checkercode;
        this.hangtime = hangtime;
        this.dealtime = dealtime;
        this.hangadjtype = hangadjtype;
        this.checkdecr = checkdecr;
        this.incdecrid = incdecrid;
        this.lrsncode = lrsncode;
        this.srsncode = srsncode;
        this.isicp = isicp;
        this.portid = portid;
        this.icptype = icptype;
        this.lodge = lodge;
        this.isaward = isaward;
    }

    /** default constructor */
    public ChkHangAdjVO() {
    }

    /** minimal constructor */
    public ChkHangAdjVO(java.lang.Long logdetid, java.lang.Long billchecklogid, java.lang.Long eboxid, java.lang.Long subsid, java.lang.Long acctid, java.lang.Integer validbillcyc) {
        this.logdetid = logdetid;
        this.billchecklogid = billchecklogid;
        this.eboxid = eboxid;
        this.subsid = subsid;
        this.acctid = acctid;
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Long getLogdetid() {
        return this.logdetid;
    }

    public void setLogdetid(java.lang.Long logdetid) {
        this.logdetid = logdetid;
    }

    public java.lang.Long getBillchecklogid() {
        return this.billchecklogid;
    }

    public void setBillchecklogid(java.lang.Long billchecklogid) {
        this.billchecklogid = billchecklogid;
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

    public java.lang.Double getHangamt() {
        return this.hangamt;
    }

    public void setHangamt(java.lang.Double hangamt) {
        this.hangamt = hangamt;
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

    public java.util.Date getHangtime() {
        return this.hangtime;
    }

    public void setHangtime(java.util.Date hangtime) {
        this.hangtime = hangtime;
    }

    public java.util.Date getDealtime() {
        return this.dealtime;
    }

    public void setDealtime(java.util.Date dealtime) {
        this.dealtime = dealtime;
    }

    public java.lang.Short getHangadjtype() {
        return this.hangadjtype;
    }

    public void setHangadjtype(java.lang.Short hangadjtype) {
        this.hangadjtype = hangadjtype;
    }

    public java.lang.Double getCheckdecr() {
        return this.checkdecr;
    }

    public void setCheckdecr(java.lang.Double checkdecr) {
        this.checkdecr = checkdecr;
    }

    public java.lang.Long getIncdecrid() {
        return this.incdecrid;
    }

    public void setIncdecrid(java.lang.Long incdecrid) {
        this.incdecrid = incdecrid;
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

    public java.lang.Byte getIsicp() {
        return this.isicp;
    }

    public void setIsicp(java.lang.Byte isicp) {
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

    public java.lang.Short getIsaward() {
        return this.isaward;
    }

    public void setIsaward(java.lang.Short isaward) {
        this.isaward = isaward;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logdetid", getLogdetid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChkHangAdjVO) ) return false;
        ChkHangAdjVO castOther = (ChkHangAdjVO) other;
        return new EqualsBuilder()
            .append(this.getLogdetid(), castOther.getLogdetid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogdetid())
            .toHashCode();
    }

}
