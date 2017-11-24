package com.gmcc.pboss.business.base.role;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.base.rolelog.RolelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class RoleVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String roleid;

    /** nullable persistent field */
    private String rolename;

    /** nullable persistent field */
    private Byte ispublic;

    /** nullable persistent field */
    private String operid;

    /** nullable persistent field */
    private String orgid;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** nullable persistent field */
    private Byte isback;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public RoleVO(java.lang.String roleid, java.lang.String rolename, java.lang.Byte ispublic, java.lang.String operid, java.lang.String orgid, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate, java.lang.Byte isback, java.lang.String memo) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.ispublic = ispublic;
        this.operid = operid;
        this.orgid = orgid;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
        this.isback = isback;
        this.memo = memo;
    }

    /** default constructor */
    public RoleVO() {
    }

    /** minimal constructor */
    public RoleVO(java.lang.String roleid) {
        this.roleid = roleid;
    }

    public java.lang.String getRoleid() {
        return this.roleid;
    }

    public void setRoleid(java.lang.String roleid) {
        this.roleid = roleid;
    }

    public java.lang.String getRolename() {
        return this.rolename;
    }

    public void setRolename(java.lang.String rolename) {
        this.rolename = rolename;
    }

    public java.lang.Byte getIspublic() {
        return this.ispublic;
    }

    public void setIspublic(java.lang.Byte ispublic) {
        this.ispublic = ispublic;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.lang.String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(java.lang.String orgid) {
        this.orgid = orgid;
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

    public java.lang.Byte getIsback() {
        return this.isback;
    }

    public void setIsback(java.lang.Byte isback) {
        this.isback = isback;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("roleid", getRoleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RoleVO) ) return false;
        RoleVO castOther = (RoleVO) other;
        return new EqualsBuilder()
            .append(this.getRoleid(), castOther.getRoleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRoleid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return RolelogVO.class;
    }

}
