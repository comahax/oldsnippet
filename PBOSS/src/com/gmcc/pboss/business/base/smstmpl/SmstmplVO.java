package com.gmcc.pboss.business.base.smstmpl;

import com.gmcc.pboss.business.base.rolerightlog.RolerightlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SmstmplVO extends BaseVO implements Serializable, BusinessLog {

    /** identifier field */
    private String sid;

    /** nullable persistent field */
    private String sname;

    /** nullable persistent field */
    private String stype;

    /** nullable persistent field */
    private String sstate;

    /** nullable persistent field */
    private String scontent;

    /** nullable persistent field */
    private String smemo;

    /** full constructor */
    public SmstmplVO(java.lang.String sid, java.lang.String sname, java.lang.String stype, java.lang.String sstate, java.lang.String scontent, java.lang.String smemo) {
        this.sid = sid;
        this.sname = sname;
        this.stype = stype;
        this.sstate = sstate;
        this.scontent = scontent;
        this.smemo = smemo;
    }

    /** default constructor */
    public SmstmplVO() {
    }

    /** minimal constructor */
    public SmstmplVO(java.lang.String sid) {
        this.sid = sid;
    }

    public java.lang.String getSid() {
        return this.sid;
    }

    public void setSid(java.lang.String sid) {
        this.sid = sid;
    }

    public java.lang.String getSname() {
        return this.sname;
    }

    public void setSname(java.lang.String sname) {
        this.sname = sname;
    }

    public java.lang.String getStype() {
        return this.stype;
    }

    public void setStype(java.lang.String stype) {
        this.stype = stype;
    }

    public java.lang.String getSstate() {
        return this.sstate;
    }

    public void setSstate(java.lang.String sstate) {
        this.sstate = sstate;
    }

    public java.lang.String getScontent() {
        return this.scontent;
    }

    public void setScontent(java.lang.String scontent) {
        this.scontent = scontent;
    }

    public java.lang.String getSmemo() {
        return this.smemo;
    }

    public void setSmemo(java.lang.String smemo) {
        this.smemo = smemo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("sid", getSid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SmstmplVO) ) return false;
        SmstmplVO castOther = (SmstmplVO) other;
        return new EqualsBuilder()
            .append(this.getSid(), castOther.getSid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSid())
            .toHashCode();
    }

    public Class logVOClass(){
    	return SmstmplVO.class;
    }
}
