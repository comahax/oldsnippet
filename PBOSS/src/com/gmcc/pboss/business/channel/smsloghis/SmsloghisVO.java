package com.gmcc.pboss.business.channel.smsloghis;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SmsloghisVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String smsno;

    /** nullable persistent field */
    private String commandid;

    /** nullable persistent field */
    private String smsseq;

    /** nullable persistent field */
    private String scontent;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Short sstate;

    /** nullable persistent field */
    private String remark;
    
    private Short smstype;

    /** full constructor */
    public SmsloghisVO(java.lang.String mobile, java.lang.String cityid, java.lang.String smsno, java.lang.String commandid, java.lang.String smsseq, java.lang.String scontent, java.util.Date oprtime, java.lang.Short sstate, java.lang.String remark, java.lang.Short smstype) {
        this.mobile = mobile;
        this.cityid = cityid;
        this.smsno = smsno;
        this.commandid = commandid;
        this.smsseq = smsseq;
        this.scontent = scontent;
        this.oprtime = oprtime;
        this.sstate = sstate;
        this.remark = remark;
        this.smstype = smstype;
    }

    /** default constructor */
    public SmsloghisVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getSmsno() {
        return this.smsno;
    }

    public void setSmsno(java.lang.String smsno) {
        this.smsno = smsno;
    }

    public java.lang.String getCommandid() {
        return this.commandid;
    }

    public void setCommandid(java.lang.String commandid) {
        this.commandid = commandid;
    }

    public java.lang.String getSmsseq() {
        return this.smsseq;
    }

    public void setSmsseq(java.lang.String smsseq) {
        this.smsseq = smsseq;
    }

    public java.lang.String getScontent() {
        return this.scontent;
    }

    public void setScontent(java.lang.String scontent) {
        this.scontent = scontent;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.Short getSstate() {
        return this.sstate;
    }

    public void setSstate(java.lang.Short sstate) {
        this.sstate = sstate;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public Short getSmstype() {
		return smstype;
	}

	public void setSmstype(Short smstype) {
		this.smstype = smstype;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SmsloghisVO) ) return false;
        SmsloghisVO castOther = (SmsloghisVO) other;
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
