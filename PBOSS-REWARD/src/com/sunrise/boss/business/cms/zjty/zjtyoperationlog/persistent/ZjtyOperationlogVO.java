package com.sunrise.boss.business.cms.zjty.zjtyoperationlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyOperationlogVO implements Serializable {

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

    /** persistent field */
    private String opnid;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String parentid;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private Short isbusi;

    /** nullable persistent field */
    private Short opnlevel;

    /** nullable persistent field */
    private Short busikind;

    /** nullable persistent field */
    private String busibelong;

    /** full constructor */
    public ZjtyOperationlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String opnid, java.lang.String name, java.lang.String parentid, java.lang.String remark, java.lang.Short state, java.util.Date startdate, java.util.Date enddate, java.lang.Short isbusi, java.lang.Short opnlevel, java.lang.Short busikind, java.lang.String busibelong) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.opnid = opnid;
        this.name = name;
        this.parentid = parentid;
        this.remark = remark;
        this.state = state;
        this.startdate = startdate;
        this.enddate = enddate;
        this.isbusi = isbusi;
        this.opnlevel = opnlevel;
        this.busikind = busikind;
        this.busibelong = busibelong;
    }

    /** default constructor */
    public ZjtyOperationlogVO() {
    }

    /** minimal constructor */
    public ZjtyOperationlogVO(java.lang.Long logid, java.lang.String opnid) {
        this.logid = logid;
        this.opnid = opnid;
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

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getParentid() {
        return this.parentid;
    }

    public void setParentid(java.lang.String parentid) {
        this.parentid = parentid;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.Short getIsbusi() {
        return this.isbusi;
    }

    public void setIsbusi(java.lang.Short isbusi) {
        this.isbusi = isbusi;
    }

    public java.lang.Short getOpnlevel() {
        return this.opnlevel;
    }

    public void setOpnlevel(java.lang.Short opnlevel) {
        this.opnlevel = opnlevel;
    }

    public java.lang.Short getBusikind() {
        return this.busikind;
    }

    public void setBusikind(java.lang.Short busikind) {
        this.busikind = busikind;
    }

    public java.lang.String getBusibelong() {
        return this.busibelong;
    }

    public void setBusibelong(java.lang.String busibelong) {
        this.busibelong = busibelong;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyOperationlogVO) ) return false;
        ZjtyOperationlogVO castOther = (ZjtyOperationlogVO) other;
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
