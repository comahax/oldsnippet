package com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent.ChPdRprewardrecordlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChPdRprewardrecordVO implements OperationLog {

    /** identifier field */
    private Long rpseqid;

    /** nullable persistent field */
    private String provagentid;

    /** nullable persistent field */
    private String prodno;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private Short phase;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Double rpmoney;

    /** nullable persistent field */
    private Long adcrewardid;

    /** full constructor */
    public ChPdRprewardrecordVO(java.lang.Long rpseqid, java.lang.String provagentid, java.lang.String prodno, java.lang.String rewardmonth, java.lang.Short phase, java.lang.String cityid, java.lang.Double rpmoney, java.lang.Long adcrewardid) {
        this.rpseqid = rpseqid;
        this.provagentid = provagentid;
        this.prodno = prodno;
        this.rewardmonth = rewardmonth;
        this.phase = phase;
        this.cityid = cityid;
        this.rpmoney = rpmoney;
        this.adcrewardid = adcrewardid;
    }

    /** default constructor */
    public ChPdRprewardrecordVO() {
    }

    /** minimal constructor */
    public ChPdRprewardrecordVO(java.lang.Long rpseqid) {
        this.rpseqid = rpseqid;
    }

    public java.lang.Long getRpseqid() {
        return this.rpseqid;
    }

    public void setRpseqid(java.lang.Long rpseqid) {
        this.rpseqid = rpseqid;
    }

    public java.lang.String getProvagentid() {
        return this.provagentid;
    }

    public void setProvagentid(java.lang.String provagentid) {
        this.provagentid = provagentid;
    }

    public java.lang.String getProdno() {
        return this.prodno;
    }

    public void setProdno(java.lang.String prodno) {
        this.prodno = prodno;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.Short getPhase() {
        return this.phase;
    }

    public void setPhase(java.lang.Short phase) {
        this.phase = phase;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Double getRpmoney() {
        return this.rpmoney;
    }

    public void setRpmoney(java.lang.Double rpmoney) {
        this.rpmoney = rpmoney;
    }

    public java.lang.Long getAdcrewardid() {
        return this.adcrewardid;
    }

    public void setAdcrewardid(java.lang.Long adcrewardid) {
        this.adcrewardid = adcrewardid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rpseqid", getRpseqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdRprewardrecordVO) ) return false;
        ChPdRprewardrecordVO castOther = (ChPdRprewardrecordVO) other;
        return new EqualsBuilder()
            .append(this.getRpseqid(), castOther.getRpseqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRpseqid())
            .toHashCode();
    }
    public Class logVOClass() {
		return ChPdRprewardrecordlogVO.class;
	}
}
