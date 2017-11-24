package com.gmcc.pboss.business.base.operfunction;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class OperfunctionVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String functionid;

    /** identifier field */
    private String operid;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** nullable persistent field */
    private Byte isdefault;

    /** nullable persistent field */
    private Byte flag;

    /** full constructor */
    public OperfunctionVO(java.lang.String functionid, java.lang.String operid, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate, java.lang.Byte isdefault, java.lang.Byte flag) {
        this.functionid = functionid;
        this.operid = operid;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
        this.isdefault = isdefault;
        this.flag = flag;
    }

    /** default constructor */
    public OperfunctionVO() {
    }

    /** minimal constructor */
    public OperfunctionVO(java.lang.String functionid, java.lang.String operid) {
        this.functionid = functionid;
        this.operid = operid;
    }

    public java.lang.String getFunctionid() {
        return this.functionid;
    }

    public void setFunctionid(java.lang.String functionid) {
        this.functionid = functionid;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.Byte getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }

    public java.util.Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.util.Date statusdate) {
        this.statusdate = statusdate;
    }

    public java.lang.Byte getIsdefault() {
        return this.isdefault;
    }

    public void setIsdefault(java.lang.Byte isdefault) {
        this.isdefault = isdefault;
    }

    public java.lang.Byte getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.Byte flag) {
        this.flag = flag;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("functionid", getFunctionid())
            .append("operid", getOperid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OperfunctionVO) ) return false;
        OperfunctionVO castOther = (OperfunctionVO) other;
        return new EqualsBuilder()
            .append(this.getFunctionid(), castOther.getFunctionid())
            .append(this.getOperid(), castOther.getOperid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFunctionid())
            .append(getOperid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return OperfunctionlogVO.class;
    }

}
