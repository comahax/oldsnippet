package com.gmcc.pboss.business.base.sysparamlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SysparamlogVO extends BaseVO implements Serializable {

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
    private Long systemid;

    /** nullable persistent field */
    private String paramtype;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private String paramname;

    /** nullable persistent field */
    private String paramvalue;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public SysparamlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long systemid, java.lang.String paramtype, java.util.Date begintime, java.util.Date endtime, java.lang.String paramname, java.lang.String paramvalue, java.lang.String memo) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.systemid = systemid;
        this.paramtype = paramtype;
        this.begintime = begintime;
        this.endtime = endtime;
        this.paramname = paramname;
        this.paramvalue = paramvalue;
        this.memo = memo;
    }

    /** default constructor */
    public SysparamlogVO() {
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

    public java.lang.Long getSystemid() {
        return this.systemid;
    }

    public void setSystemid(java.lang.Long systemid) {
        this.systemid = systemid;
    }

    public java.lang.String getParamtype() {
        return this.paramtype;
    }

    public void setParamtype(java.lang.String paramtype) {
        this.paramtype = paramtype;
    }

    public java.util.Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }

    public java.lang.String getParamname() {
        return this.paramname;
    }

    public void setParamname(java.lang.String paramname) {
        this.paramname = paramname;
    }

    public java.lang.String getParamvalue() {
        return this.paramvalue;
    }

    public void setParamvalue(java.lang.String paramvalue) {
        this.paramvalue = paramvalue;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SysparamlogVO) ) return false;
        SysparamlogVO castOther = (SysparamlogVO) other;
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
