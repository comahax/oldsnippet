package com.gmcc.pboss.business.base.sysparam;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.base.sysparamlog.SysparamlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class SysparamVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String paramtype;

    /** identifier field */
    private Long systemid;

    /** persistent field */
    private java.util.Date begintime;

    /** persistent field */
    private java.util.Date endtime;

    /** persistent field */
    private String paramname;

    /** persistent field */
    private String paramvalue;

    /** persistent field */
    private String memo;

    /** full constructor */
    public SysparamVO(java.lang.String paramtype, java.lang.Long systemid, java.util.Date begintime, java.util.Date endtime, java.lang.String paramname, java.lang.String paramvalue, java.lang.String memo) {
        this.paramtype = paramtype;
        this.systemid = systemid;
        this.begintime = begintime;
        this.endtime = endtime;
        this.paramname = paramname;
        this.paramvalue = paramvalue;
        this.memo = memo;
    }

    /** default constructor */
    public SysparamVO() {
    }

    public java.lang.String getParamtype() {
        return this.paramtype;
    }

    public void setParamtype(java.lang.String paramtype) {
        this.paramtype = paramtype;
    }

    public java.lang.Long getSystemid() {
        return this.systemid;
    }

    public void setSystemid(java.lang.Long systemid) {
        this.systemid = systemid;
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
            .append("paramtype", getParamtype())
            .append("systemid", getSystemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SysparamVO) ) return false;
        SysparamVO castOther = (SysparamVO) other;
        return new EqualsBuilder()
            .append(this.getParamtype(), castOther.getParamtype())
            .append(this.getSystemid(), castOther.getSystemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getParamtype())
            .append(getSystemid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return SysparamlogVO.class;
    }

}
