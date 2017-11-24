package com.gmcc.pboss.business.channel.ctilog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CtilogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String scontent;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Short smstype;

    /** full constructor */
    public CtilogVO(java.lang.String mobile, java.lang.String cityid, java.lang.String scontent, java.util.Date oprtime, java.lang.Short smstype) {
        this.mobile = mobile;
        this.cityid = cityid;
        this.scontent = scontent;
        this.oprtime = oprtime;
        this.smstype = smstype;
    }

    /** default constructor */
    public CtilogVO() {
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

    public java.lang.Short getSmstype() {
        return this.smstype;
    }

    public void setSmstype(java.lang.Short smstype) {
        this.smstype = smstype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CtilogVO) ) return false;
        CtilogVO castOther = (CtilogVO) other;
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
