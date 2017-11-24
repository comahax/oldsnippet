package com.sunrise.boss.business.cms.reward.terminalsucc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TerminalsuccVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private Long srcseq;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private Byte brand;

    /** nullable persistent field */
    private java.util.Date creattime;

    /** nullable persistent field */
    private java.util.Date adtttime;

    /** nullable persistent field */
    private String src;

    /** nullable persistent field */
    private String calcopnid;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private String ruleitemid;

    /** nullable persistent field */
    private Short adtflag;

    /** nullable persistent field */
    private String adtcode;

    /** nullable persistent field */
    private String adtremark;

    /** nullable persistent field */
    private Long oid;

    /** nullable persistent field */
    private Short rewardflag;

    /** nullable persistent field */
    private String repairmonth;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private Short noncyc;

    /** nullable persistent field */
    private String imei;

    /** nullable persistent field */
    private String comid;

    /** full constructor */
    public TerminalsuccVO(java.lang.Long srcseq, java.lang.String cityid, java.lang.String opnid, java.lang.String wayid, java.lang.String oprcode, java.util.Date oprtime, java.lang.String mobile, java.lang.Double busivalue, java.lang.Byte brand, java.util.Date creattime, java.util.Date adtttime, java.lang.String src, java.lang.String calcopnid, java.lang.String calcmonth, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.Short adtflag, java.lang.String adtcode, java.lang.String adtremark, java.lang.Long oid, java.lang.Short rewardflag, java.lang.String repairmonth, java.lang.String batchno, java.lang.Short noncyc, java.lang.String imei, java.lang.String comid) {
        this.srcseq = srcseq;
        this.cityid = cityid;
        this.opnid = opnid;
        this.wayid = wayid;
        this.oprcode = oprcode;
        this.oprtime = oprtime;
        this.mobile = mobile;
        this.busivalue = busivalue;
        this.brand = brand;
        this.creattime = creattime;
        this.adtttime = adtttime;
        this.src = src;
        this.calcopnid = calcopnid;
        this.calcmonth = calcmonth;
        this.ruleid = ruleid;
        this.ruleitemid = ruleitemid;
        this.adtflag = adtflag;
        this.adtcode = adtcode;
        this.adtremark = adtremark;
        this.oid = oid;
        this.rewardflag = rewardflag;
        this.repairmonth = repairmonth;
        this.batchno = batchno;
        this.noncyc = noncyc;
        this.imei = imei;
        this.comid = comid;
    }

    /** default constructor */
    public TerminalsuccVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSrcseq() {
        return this.srcseq;
    }

    public void setSrcseq(java.lang.Long srcseq) {
        this.srcseq = srcseq;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.Byte getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Byte brand) {
        this.brand = brand;
    }

    public java.util.Date getCreattime() {
        return this.creattime;
    }

    public void setCreattime(java.util.Date creattime) {
        this.creattime = creattime;
    }

    public java.util.Date getAdtttime() {
        return this.adtttime;
    }

    public void setAdtttime(java.util.Date adtttime) {
        this.adtttime = adtttime;
    }

    public java.lang.String getSrc() {
        return this.src;
    }

    public void setSrc(java.lang.String src) {
        this.src = src;
    }

    public java.lang.String getCalcopnid() {
        return this.calcopnid;
    }

    public void setCalcopnid(java.lang.String calcopnid) {
        this.calcopnid = calcopnid;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getRuleitemid() {
        return this.ruleitemid;
    }

    public void setRuleitemid(java.lang.String ruleitemid) {
        this.ruleitemid = ruleitemid;
    }

    public java.lang.Short getAdtflag() {
        return this.adtflag;
    }

    public void setAdtflag(java.lang.Short adtflag) {
        this.adtflag = adtflag;
    }

    public java.lang.String getAdtcode() {
        return this.adtcode;
    }

    public void setAdtcode(java.lang.String adtcode) {
        this.adtcode = adtcode;
    }

    public java.lang.String getAdtremark() {
        return this.adtremark;
    }

    public void setAdtremark(java.lang.String adtremark) {
        this.adtremark = adtremark;
    }

    public java.lang.Long getOid() {
        return this.oid;
    }

    public void setOid(java.lang.Long oid) {
        this.oid = oid;
    }

    public java.lang.Short getRewardflag() {
        return this.rewardflag;
    }

    public void setRewardflag(java.lang.Short rewardflag) {
        this.rewardflag = rewardflag;
    }

    public java.lang.String getRepairmonth() {
        return this.repairmonth;
    }

    public void setRepairmonth(java.lang.String repairmonth) {
        this.repairmonth = repairmonth;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.Short getNoncyc() {
        return this.noncyc;
    }

    public void setNoncyc(java.lang.Short noncyc) {
        this.noncyc = noncyc;
    }

    public java.lang.String getImei() {
        return this.imei;
    }

    public void setImei(java.lang.String imei) {
        this.imei = imei;
    }

    public java.lang.String getComid() {
        return this.comid;
    }

    public void setComid(java.lang.String comid) {
        this.comid = comid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TerminalsuccVO) ) return false;
        TerminalsuccVO castOther = (TerminalsuccVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
