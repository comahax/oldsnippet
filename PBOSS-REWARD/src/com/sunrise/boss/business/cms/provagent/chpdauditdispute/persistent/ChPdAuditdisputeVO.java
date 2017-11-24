package com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.sunrise.boss.business.cms.provagent.chpdauditdisputelog.persistent.ChPdAuditdisputelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChPdAuditdisputeVO implements OperationLog {

    /** identifier field */
    private Long disputeid;

    /** persistent field */
    private Long rewardid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Byte auditrole;

    /** nullable persistent field */
    private String content;

    /** nullable persistent field */
    private String auditeename;

    /** nullable persistent field */
    private String telephone;

    /** nullable persistent field */
    private Byte isaccepted;

    /** nullable persistent field */
    private Byte isdealed;

    /** nullable persistent field */
    private Byte dealtype;

    /** nullable persistent field */
    private Long suppleseq;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private java.util.Date incomstime;

    /** full constructor */
    public ChPdAuditdisputeVO(java.lang.Long disputeid, java.lang.Long rewardid, java.lang.String cityid, java.lang.Byte auditrole, java.lang.String content, java.lang.String auditeename, java.lang.String telephone, java.lang.Byte isaccepted, java.lang.Byte isdealed, java.lang.Byte dealtype, java.lang.Long suppleseq, java.lang.String memo, java.util.Date incomstime) {
        this.disputeid = disputeid;
        this.rewardid = rewardid;
        this.cityid = cityid;
        this.auditrole = auditrole;
        this.content = content;
        this.auditeename = auditeename;
        this.telephone = telephone;
        this.isaccepted = isaccepted;
        this.isdealed = isdealed;
        this.dealtype = dealtype;
        this.suppleseq = suppleseq;
        this.memo = memo;
        this.incomstime = incomstime;
    }

    /** default constructor */
    public ChPdAuditdisputeVO() {
    }

    /** minimal constructor */
    public ChPdAuditdisputeVO(java.lang.Long disputeid, java.lang.Long rewardid) {
        this.disputeid = disputeid;
        this.rewardid = rewardid;
    }

    public java.lang.Long getDisputeid() {
        return this.disputeid;
    }

    public void setDisputeid(java.lang.Long disputeid) {
        this.disputeid = disputeid;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Byte getAuditrole() {
        return this.auditrole;
    }

    public void setAuditrole(java.lang.Byte auditrole) {
        this.auditrole = auditrole;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String content) {
        this.content = content;
    }

    public java.lang.String getAuditeename() {
        return this.auditeename;
    }

    public void setAuditeename(java.lang.String auditeename) {
        this.auditeename = auditeename;
    }

    public java.lang.String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(java.lang.String telephone) {
        this.telephone = telephone;
    }

    public java.lang.Byte getIsaccepted() {
        return this.isaccepted;
    }

    public void setIsaccepted(java.lang.Byte isaccepted) {
        this.isaccepted = isaccepted;
    }

    public java.lang.Byte getIsdealed() {
        return this.isdealed;
    }

    public void setIsdealed(java.lang.Byte isdealed) {
        this.isdealed = isdealed;
    }

    public java.lang.Byte getDealtype() {
        return this.dealtype;
    }

    public void setDealtype(java.lang.Byte dealtype) {
        this.dealtype = dealtype;
    }

    public java.lang.Long getSuppleseq() {
        return this.suppleseq;
    }

    public void setSuppleseq(java.lang.Long suppleseq) {
        this.suppleseq = suppleseq;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.util.Date getIncomstime() {
        return this.incomstime;
    }

    public void setIncomstime(java.util.Date incomstime) {
        this.incomstime = incomstime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("disputeid", getDisputeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdAuditdisputeVO) ) return false;
        ChPdAuditdisputeVO castOther = (ChPdAuditdisputeVO) other;
        return new EqualsBuilder()
            .append(this.getDisputeid(), castOther.getDisputeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDisputeid())
            .toHashCode();
    }

	public Class logVOClass() {
		return ChPdAuditdisputelogVO.class;
	}

}
