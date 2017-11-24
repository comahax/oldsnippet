package com.sunrise.boss.business.zifee.eboxdisc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.eboxdisclog.persistent.EboxdisclogVO;

/** @author Hibernate CodeGenerator */
public class EboxdiscVO implements Serializable,OperationLog {

    /** identifier field */
    private Long eboxdiscid;

    /** identifier field */
    private Long yxplanid;

    /** nullable persistent field */
    private Long eboxunitid;

    /** nullable persistent field */
    private Long inplanid;

    /** nullable persistent field */
    private String effectivetype;

    /** nullable persistent field */
    private java.util.Date effectivedate;

    /** nullable persistent field */
    private Integer effectiveinterval;

    /** nullable persistent field */
    private Byte ispostpone;

    /** nullable persistent field */
    private Integer paytimes;

    /** nullable persistent field */
    private Long amount;

    /** nullable persistent field */
    private Byte enterunitdetflag;

    /** nullable persistent field */
    private String disctype;

    /** nullable persistent field */
    private String rollovertype;

    /** nullable persistent field */
    private Integer expiredcycles;

    /** nullable persistent field */
    private java.util.Date expireddate;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private Byte ispresent;

    /** nullable persistent field */
    private Integer effectivecycles;

    /** nullable persistent field */
    private String presenttype;

    /** nullable persistent field */
    private Long reladiscid;

    /** nullable persistent field */
    private String affixid;

    /** nullable persistent field */
    private String feesourcetype;

    /** nullable persistent field */
    private Long feesourceid;

    /** nullable persistent field */
    private Integer payinterval;
    
    /** nullable persistent field */
    private Integer validity;
    
    private Long pesenteboxunitid;

    /** full constructor */
    public EboxdiscVO(java.lang.Long eboxdiscid, java.lang.Long yxplanid, java.lang.Long eboxunitid, java.lang.Long inplanid, java.lang.String effectivetype, java.util.Date effectivedate, java.lang.Integer effectiveinterval, java.lang.Byte ispostpone, java.lang.Integer paytimes, java.lang.Long amount, java.lang.Byte enterunitdetflag, java.lang.String disctype, java.lang.String rollovertype, java.lang.Integer expiredcycles, java.util.Date expireddate, java.lang.String remark, java.lang.Byte ispresent, java.lang.Integer effectivecycles, java.lang.String presenttype, java.lang.Long reladiscid, java.lang.String affixid, java.lang.String feesourcetype, java.lang.Long feesourceid, java.lang.Integer payinterval, java.lang.Integer validity) {
        this.eboxdiscid = eboxdiscid;
        this.yxplanid = yxplanid;
        this.eboxunitid = eboxunitid;
        this.inplanid = inplanid;
        this.effectivetype = effectivetype;
        this.effectivedate = effectivedate;
        this.effectiveinterval = effectiveinterval;
        this.ispostpone = ispostpone;
        this.paytimes = paytimes;
        this.amount = amount;
        this.enterunitdetflag = enterunitdetflag;
        this.disctype = disctype;
        this.rollovertype = rollovertype;
        this.expiredcycles = expiredcycles;
        this.expireddate = expireddate;
        this.remark = remark;
        this.ispresent = ispresent;
        this.effectivecycles = effectivecycles;
        this.presenttype = presenttype;
        this.reladiscid = reladiscid;
        this.affixid = affixid;
        this.feesourcetype = feesourcetype;
        this.feesourceid = feesourceid;
        this.payinterval = payinterval;
        this.validity =  validity;
    }

    /** default constructor */
    public EboxdiscVO() {
    }

    
    public Long getPesenteboxunitid() {
		return pesenteboxunitid;
	}

	public void setPesenteboxunitid(Long pesenteboxunitid) {
		this.pesenteboxunitid = pesenteboxunitid;
	}

	/** minimal constructor */
    public EboxdiscVO(java.lang.Long eboxdiscid, java.lang.Long yxplanid) {
        this.eboxdiscid = eboxdiscid;
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getEboxdiscid() {
        return this.eboxdiscid;
    }

    public void setEboxdiscid(java.lang.Long eboxdiscid) {
        this.eboxdiscid = eboxdiscid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getEboxunitid() {
        return this.eboxunitid;
    }

    public void setEboxunitid(java.lang.Long eboxunitid) {
        this.eboxunitid = eboxunitid;
    }

    public java.lang.Long getInplanid() {
        return this.inplanid;
    }

    public void setInplanid(java.lang.Long inplanid) {
        this.inplanid = inplanid;
    }

    public java.lang.String getEffectivetype() {
        return this.effectivetype;
    }

    public void setEffectivetype(java.lang.String effectivetype) {
        this.effectivetype = effectivetype;
    }

    public java.util.Date getEffectivedate() {
        return this.effectivedate;
    }

    public void setEffectivedate(java.util.Date effectivedate) {
        this.effectivedate = effectivedate;
    }

    public java.lang.Integer getEffectiveinterval() {
        return this.effectiveinterval;
    }

    public void setEffectiveinterval(java.lang.Integer effectiveinterval) {
        this.effectiveinterval = effectiveinterval;
    }

    public java.lang.Byte getIspostpone() {
        return this.ispostpone;
    }

    public void setIspostpone(java.lang.Byte ispostpone) {
        this.ispostpone = ispostpone;
    }

    public java.lang.Integer getPaytimes() {
        return this.paytimes;
    }

    public void setPaytimes(java.lang.Integer paytimes) {
        this.paytimes = paytimes;
    }

    public java.lang.Long getAmount() {
        return this.amount;
    }

    public void setAmount(java.lang.Long amount) {
        this.amount = amount;
    }

    public java.lang.Byte getEnterunitdetflag() {
        return this.enterunitdetflag;
    }

    public void setEnterunitdetflag(java.lang.Byte enterunitdetflag) {
        this.enterunitdetflag = enterunitdetflag;
    }

    public java.lang.String getDisctype() {
        return this.disctype;
    }

    public void setDisctype(java.lang.String disctype) {
        this.disctype = disctype;
    }

    public java.lang.String getRollovertype() {
        return this.rollovertype;
    }

    public void setRollovertype(java.lang.String rollovertype) {
        this.rollovertype = rollovertype;
    }

    public java.lang.Integer getExpiredcycles() {
        return this.expiredcycles;
    }

    public void setExpiredcycles(java.lang.Integer expiredcycles) {
        this.expiredcycles = expiredcycles;
    }

    public java.util.Date getExpireddate() {
        return this.expireddate;
    }

    public void setExpireddate(java.util.Date expireddate) {
        this.expireddate = expireddate;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.Byte getIspresent() {
        return this.ispresent;
    }

    public void setIspresent(java.lang.Byte ispresent) {
        this.ispresent = ispresent;
    }

    public java.lang.Integer getEffectivecycles() {
        return this.effectivecycles;
    }

    public void setEffectivecycles(java.lang.Integer effectivecycles) {
        this.effectivecycles = effectivecycles;
    }

    public java.lang.String getPresenttype() {
        return this.presenttype;
    }

    public void setPresenttype(java.lang.String presenttype) {
        this.presenttype = presenttype;
    }

    public java.lang.Long getReladiscid() {
        return this.reladiscid;
    }

    public void setReladiscid(java.lang.Long reladiscid) {
        this.reladiscid = reladiscid;
    }

    public java.lang.String getAffixid() {
        return this.affixid;
    }

    public void setAffixid(java.lang.String affixid) {
        this.affixid = affixid;
    }

    public java.lang.String getFeesourcetype() {
        return this.feesourcetype;
    }

    public void setFeesourcetype(java.lang.String feesourcetype) {
        this.feesourcetype = feesourcetype;
    }

    public java.lang.Long getFeesourceid() {
        return this.feesourceid;
    }

    public void setFeesourceid(java.lang.Long feesourceid) {
        this.feesourceid = feesourceid;
    }

    public java.lang.Integer getPayinterval() {
        return this.payinterval;
    }

    public void setPayinterval(java.lang.Integer payinterval) {
        this.payinterval = payinterval;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("eboxdiscid", getEboxdiscid())
            .append("yxplanid", getYxplanid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EboxdiscVO) ) return false;
        EboxdiscVO castOther = (EboxdiscVO) other;
        return new EqualsBuilder()
            .append(this.getEboxdiscid(), castOther.getEboxdiscid())
            .append(this.getYxplanid(), castOther.getYxplanid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEboxdiscid())
            .append(getYxplanid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return EboxdisclogVO.class;
	}

	public Integer getValidity() {
		return validity;
	}

	public void setValidity(Integer validity) {
		this.validity = validity;
	}

}
