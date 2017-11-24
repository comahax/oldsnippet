package com.gmcc.pboss.business.base.operrole;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.base.operrolelog.OperrolelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class OperroleVO extends BaseVO implements Serializable ,BusinessLog{

    /** identifier field */
    private String operid;

    /** identifier field */
    private String roleid;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public OperroleVO(java.lang.String operid, java.lang.String roleid, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate) {
        this.operid = operid;
        this.roleid = roleid;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public OperroleVO() {
    }

    /** minimal constructor */
    public OperroleVO(java.lang.String operid, java.lang.String roleid) {
        this.operid = operid;
        this.roleid = roleid;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.lang.String getRoleid() {
        return this.roleid;
    }

    public void setRoleid(java.lang.String roleid) {
        this.roleid = roleid;
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
            .append("operid", getOperid())
            .append("roleid", getRoleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OperroleVO) ) return false;
        OperroleVO castOther = (OperroleVO) other;
        return new EqualsBuilder()
            .append(this.getOperid(), castOther.getOperid())
            .append(this.getRoleid(), castOther.getRoleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOperid())
            .append(getRoleid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return OperrolelogVO.class;
    }

}
