package com.sunrise.boss.business.zifee.acct.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AcctVO implements Serializable {

    /** identifier field */
    private Long acctid;

    /** nullable persistent field */
    private String acctname;

    /** nullable persistent field */
    private Short accttype;

    /** nullable persistent field */
    private Short acctstate;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private java.util.Date stoptime;

    /** nullable persistent field */
    private Short acctlevle;

    /** persistent field */
    private Byte canhang;

    /** nullable persistent field */
    private Long woffpri;

    /** nullable persistent field */
    private Byte caninc;

    /** nullable persistent field */
    private Byte iscommon;

    /** full constructor */
    public AcctVO(java.lang.Long acctid, java.lang.String acctname, java.lang.Short accttype, java.lang.Short acctstate, java.util.Date starttime, java.util.Date stoptime, java.lang.Short acctlevle, java.lang.Byte canhang, java.lang.Long woffpri, java.lang.Byte caninc, java.lang.Byte iscommon) {
        this.acctid = acctid;
        this.acctname = acctname;
        this.accttype = accttype;
        this.acctstate = acctstate;
        this.starttime = starttime;
        this.stoptime = stoptime;
        this.acctlevle = acctlevle;
        this.canhang = canhang;
        this.woffpri = woffpri;
        this.caninc = caninc;
        this.iscommon = iscommon;
    }

    /** default constructor */
    public AcctVO() {
    }

    /** minimal constructor */
    public AcctVO(java.lang.Long acctid, java.lang.Byte canhang) {
        this.acctid = acctid;
        this.canhang = canhang;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.String getAcctname() {
        return this.acctname;
    }

    public void setAcctname(java.lang.String acctname) {
        this.acctname = acctname;
    }

    public java.lang.Short getAccttype() {
        return this.accttype;
    }

    public void setAccttype(java.lang.Short accttype) {
        this.accttype = accttype;
    }

    public java.lang.Short getAcctstate() {
        return this.acctstate;
    }

    public void setAcctstate(java.lang.Short acctstate) {
        this.acctstate = acctstate;
    }

    public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.util.Date getStoptime() {
        return this.stoptime;
    }

    public void setStoptime(java.util.Date stoptime) {
        this.stoptime = stoptime;
    }

    public java.lang.Short getAcctlevle() {
        return this.acctlevle;
    }

    public void setAcctlevle(java.lang.Short acctlevle) {
        this.acctlevle = acctlevle;
    }

    public java.lang.Byte getCanhang() {
        return this.canhang;
    }

    public void setCanhang(java.lang.Byte canhang) {
        this.canhang = canhang;
    }

    public java.lang.Long getWoffpri() {
        return this.woffpri;
    }

    public void setWoffpri(java.lang.Long woffpri) {
        this.woffpri = woffpri;
    }

    public java.lang.Byte getCaninc() {
        return this.caninc;
    }

    public void setCaninc(java.lang.Byte caninc) {
        this.caninc = caninc;
    }

    public java.lang.Byte getIscommon() {
        return this.iscommon;
    }

    public void setIscommon(java.lang.Byte iscommon) {
        this.iscommon = iscommon;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("acctid", getAcctid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AcctVO) ) return false;
        AcctVO castOther = (AcctVO) other;
        return new EqualsBuilder()
            .append(this.getAcctid(), castOther.getAcctid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAcctid())
            .toHashCode();
    }

}
