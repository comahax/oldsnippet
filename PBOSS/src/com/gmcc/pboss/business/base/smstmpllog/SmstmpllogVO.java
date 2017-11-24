package com.gmcc.pboss.business.base.smstmpllog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SmstmpllogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
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
    public SmstmpllogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String sid, java.lang.String sname, java.lang.String stype, java.lang.String sstate, java.lang.String scontent, java.lang.String smemo) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.sid = sid;
        this.sname = sname;
        this.stype = stype;
        this.sstate = sstate;
        this.scontent = scontent;
        this.smemo = smemo;
    }

    /** default constructor */
    public SmstmpllogVO() {
    }

    /** minimal constructor */
    public SmstmpllogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SmstmpllogVO) ) return false;
        SmstmpllogVO castOther = (SmstmpllogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
