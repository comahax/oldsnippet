package com.sunrise.boss.business.cms.bbc.unvrc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class UnvrcVO implements Serializable {

    /** identifier field */
    private String rcid;

    /** nullable persistent field */
    private String rcno;

    /** nullable persistent field */
    private String rcname;

    /** nullable persistent field */
    private java.util.Date regdate;

    /** nullable persistent field */
    private Short rcstate;

    /** full constructor */
    public UnvrcVO(java.lang.String rcid, java.lang.String rcno, java.lang.String rcname, java.util.Date regdate, java.lang.Short rcstate) {
        this.rcid = rcid;
        this.rcno = rcno;
        this.rcname = rcname;
        this.regdate = regdate;
        this.rcstate = rcstate;
    }

    /** default constructor */
    public UnvrcVO() {
    }

    /** minimal constructor */
    public UnvrcVO(java.lang.String rcid) {
        this.rcid = rcid;
    }

    public java.lang.String getRcid() {
        return this.rcid;
    }

    public void setRcid(java.lang.String rcid) {
        this.rcid = rcid;
    }

    public java.lang.String getRcno() {
        return this.rcno;
    }

    public void setRcno(java.lang.String rcno) {
        this.rcno = rcno;
    }

    public java.lang.String getRcname() {
        return this.rcname;
    }

    public void setRcname(java.lang.String rcname) {
        this.rcname = rcname;
    }

    public java.util.Date getRegdate() {
        return this.regdate;
    }

    public void setRegdate(java.util.Date regdate) {
        this.regdate = regdate;
    }

    public java.lang.Short getRcstate() {
        return this.rcstate;
    }

    public void setRcstate(java.lang.Short rcstate) {
        this.rcstate = rcstate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rcid", getRcid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof UnvrcVO) ) return false;
        UnvrcVO castOther = (UnvrcVO) other;
        return new EqualsBuilder()
            .append(this.getRcid(), castOther.getRcid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRcid())
            .toHashCode();
    }

}
