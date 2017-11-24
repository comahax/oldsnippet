package com.sunrise.boss.business.rightmanage.role.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RoleVO implements Serializable {

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

    /** full constructor */
    public RoleVO(String  roleid, java.lang.String rolename, Byte ispublic, java.lang.String operid, java.lang.String orgid, java.util.Date createdate, Byte status, java.util.Date statusdate) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.ispublic = ispublic;
        this.operid = operid;
        this.orgid = orgid;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public RoleVO() {
    }

    /** minimal constructor */
    public RoleVO(String  roleid) {
        this.roleid = roleid;
    }

    public String getRoleid() {
        return this.roleid;
    }

    public void setRoleid(String  roleid) {
        this.roleid = roleid;
    }

    public java.lang.String getRolename() {
        return this.rolename;
    }

    public void setRolename(java.lang.String rolename) {
        this.rolename = rolename;
    }

    public Byte getIspublic() {
        return this.ispublic;
    }

    public void setIspublic(Byte ispublic) {
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

    public Byte getStatus() {
        return this.status;
    }

    public void setStatus(Byte status) {
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

}
