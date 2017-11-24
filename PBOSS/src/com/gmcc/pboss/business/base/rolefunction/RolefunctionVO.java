package com.gmcc.pboss.business.base.rolefunction;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.base.rolefunctionlog.RolefunctionlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class RolefunctionVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String functionid;

    /** identifier field */
    private String itemid;

    /** nullable persistent field */
    private Byte operatetype;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public RolefunctionVO(java.lang.String functionid, java.lang.String itemid, java.lang.Byte operatetype, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate) {
        this.functionid = functionid;
        this.itemid = itemid;
        this.operatetype = operatetype;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public RolefunctionVO() {
    }

    /** minimal constructor */
    public RolefunctionVO(java.lang.String functionid, java.lang.String itemid) {
        this.functionid = functionid;
        this.itemid = itemid;
    }

    public java.lang.String getFunctionid() {
        return this.functionid;
    }

    public void setFunctionid(java.lang.String functionid) {
        this.functionid = functionid;
    }

    public java.lang.String getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.String itemid) {
        this.itemid = itemid;
    }

    public java.lang.Byte getOperatetype() {
        return this.operatetype;
    }

    public void setOperatetype(java.lang.Byte operatetype) {
        this.operatetype = operatetype;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("functionid", getFunctionid())
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RolefunctionVO) ) return false;
        RolefunctionVO castOther = (RolefunctionVO) other;
        return new EqualsBuilder()
            .append(this.getFunctionid(), castOther.getFunctionid())
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFunctionid())
            .append(getItemid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return RolefunctionlogVO.class;
    }

}
