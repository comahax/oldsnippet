package com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent.ZjtyRwddtllogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ZjtyRewarddetailVO implements Serializable, OperationLog {

    /** identifier field */
    private Long rewardlistid;

    /** nullable persistent field */
    private Long operseq;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayopercode;

    /** nullable persistent field */
    private Long rewardid;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Double coef1;

    /** nullable persistent field */
    private Double coef2;

    /** nullable persistent field */
    private Double coef3;

    /** nullable persistent field */
    private Double coef4;

    /** nullable persistent field */
    private String rewardmont;

    /** nullable persistent field */
    private Double totalsum;

    /** nullable persistent field */
    private Double paysum;

    /** nullable persistent field */
    private String batchnum;

    /** full constructor */
    public ZjtyRewarddetailVO(java.lang.Long operseq, java.lang.String opnid, java.lang.String wayid, java.lang.String wayopercode, java.lang.Long rewardid, java.lang.Short rewardtype, java.lang.Double rewardstd, java.lang.Short acctype, java.lang.Double coef1, java.lang.Double coef2, java.lang.Double coef3, java.lang.Double coef4, java.lang.String rewardmont, java.lang.Double totalsum, java.lang.Double paysum, java.lang.String batchnum) {
        this.operseq = operseq;
        this.opnid = opnid;
        this.wayid = wayid;
        this.wayopercode = wayopercode;
        this.rewardid = rewardid;
        this.rewardtype = rewardtype;
        this.rewardstd = rewardstd;
        this.acctype = acctype;
        this.coef1 = coef1;
        this.coef2 = coef2;
        this.coef3 = coef3;
        this.coef4 = coef4;
        this.rewardmont = rewardmont;
        this.totalsum = totalsum;
        this.paysum = paysum;
        this.batchnum = batchnum;
    }

    /** default constructor */
    public ZjtyRewarddetailVO() {
    }

    public java.lang.Long getRewardlistid() {
        return this.rewardlistid;
    }

    public void setRewardlistid(java.lang.Long rewardlistid) {
        this.rewardlistid = rewardlistid;
    }

    public java.lang.Long getOperseq() {
        return this.operseq;
    }

    public void setOperseq(java.lang.Long operseq) {
        this.operseq = operseq;
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

    public java.lang.String getWayopercode() {
        return this.wayopercode;
    }

    public void setWayopercode(java.lang.String wayopercode) {
        this.wayopercode = wayopercode;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.Double getCoef1() {
        return this.coef1;
    }

    public void setCoef1(java.lang.Double coef1) {
        this.coef1 = coef1;
    }

    public java.lang.Double getCoef2() {
        return this.coef2;
    }

    public void setCoef2(java.lang.Double coef2) {
        this.coef2 = coef2;
    }

    public java.lang.Double getCoef3() {
        return this.coef3;
    }

    public void setCoef3(java.lang.Double coef3) {
        this.coef3 = coef3;
    }

    public java.lang.Double getCoef4() {
        return this.coef4;
    }

    public void setCoef4(java.lang.Double coef4) {
        this.coef4 = coef4;
    }

    public java.lang.String getRewardmont() {
        return this.rewardmont;
    }

    public void setRewardmont(java.lang.String rewardmont) {
        this.rewardmont = rewardmont;
    }

    public java.lang.Double getTotalsum() {
        return this.totalsum;
    }

    public void setTotalsum(java.lang.Double totalsum) {
        this.totalsum = totalsum;
    }

    public java.lang.Double getPaysum() {
        return this.paysum;
    }

    public void setPaysum(java.lang.Double paysum) {
        this.paysum = paysum;
    }

    public java.lang.String getBatchnum() {
        return this.batchnum;
    }

    public void setBatchnum(java.lang.String batchnum) {
        this.batchnum = batchnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rewardlistid", getRewardlistid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyRewarddetailVO) ) return false;
        ZjtyRewarddetailVO castOther = (ZjtyRewarddetailVO) other;
        return new EqualsBuilder()
            .append(this.getRewardlistid(), castOther.getRewardlistid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRewardlistid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ZjtyRwddtllogVO.class;
	}

}
