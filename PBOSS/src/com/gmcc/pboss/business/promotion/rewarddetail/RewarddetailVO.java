package com.gmcc.pboss.business.promotion.rewarddetail;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewarddetailVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private java.util.Date creatingtime;

    /** nullable persistent field */
    private Long pid;

    /** nullable persistent field */
    private Long ruleid;

    /** nullable persistent field */
    private String sourceid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String rwdtype;

    /** nullable persistent field */
    private Double stdamount;

    /** nullable persistent field */
    private Double amount;

    /** full constructor */
    public RewarddetailVO(java.util.Date creatingtime, java.lang.Long pid, java.lang.Long ruleid, java.lang.String sourceid, java.lang.String opnid, java.lang.String mobile, java.util.Date oprtime, java.lang.String wayid, java.lang.String calcmonth, java.lang.String comcategory, java.lang.String rwdtype, java.lang.Double stdamount, java.lang.Double amount) {
        this.creatingtime = creatingtime;
        this.pid = pid;
        this.ruleid = ruleid;
        this.sourceid = sourceid;
        this.opnid = opnid;
        this.mobile = mobile;
        this.oprtime = oprtime;
        this.wayid = wayid;
        this.calcmonth = calcmonth;
        this.comcategory = comcategory;
        this.rwdtype = rwdtype;
        this.stdamount = stdamount;
        this.amount = amount;
    }

    /** default constructor */
    public RewarddetailVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.util.Date getCreatingtime() {
        return this.creatingtime;
    }

    public void setCreatingtime(java.util.Date creatingtime) {
        this.creatingtime = creatingtime;
    }

    public java.lang.Long getPid() {
        return this.pid;
    }

    public void setPid(java.lang.Long pid) {
        this.pid = pid;
    }

    public java.lang.Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getSourceid() {
        return this.sourceid;
    }

    public void setSourceid(java.lang.String sourceid) {
        this.sourceid = sourceid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getRwdtype() {
        return this.rwdtype;
    }

    public void setRwdtype(java.lang.String rwdtype) {
        this.rwdtype = rwdtype;
    }

    public java.lang.Double getStdamount() {
        return this.stdamount;
    }

    public void setStdamount(java.lang.Double stdamount) {
        this.stdamount = stdamount;
    }

    public java.lang.Double getAmount() {
        return this.amount;
    }

    public void setAmount(java.lang.Double amount) {
        this.amount = amount;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewarddetailVO) ) return false;
        RewarddetailVO castOther = (RewarddetailVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
