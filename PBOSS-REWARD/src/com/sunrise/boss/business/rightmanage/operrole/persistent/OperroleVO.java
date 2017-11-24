package com.sunrise.boss.business.rightmanage.operrole.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OperroleVO implements Serializable {

    /** identifier field */
    private String operid;

    /** identifier field */
    private String roleid;

    /** identifier field */
    private Byte status;

    /** identifier field */
    private java.util.Date statusdate;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** full constructor */
    public OperroleVO(java.lang.String operid, java.lang.String roleid, Byte status, java.util.Date statusdate, java.util.Date createdate) {
        this.operid = operid;
        this.roleid = roleid;
        this.status = status;
        this.statusdate = statusdate;
        this.createdate = createdate;
    }

    /** default constructor */
    public OperroleVO() {
    }

    /** minimal constructor */
    public OperroleVO(java.lang.String operid, java.lang.String roleid, Byte status, java.util.Date statusdate) {
        this.operid = operid;
        this.roleid = roleid;
        this.status = status;
        this.statusdate = statusdate;
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

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("operid", getOperid())
            .append("roleid", getRoleid())
            .append("status", getStatus())
            .append("statusdate", getStatusdate())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OperroleVO) ) return false;
        OperroleVO castOther = (OperroleVO) other;
        return new EqualsBuilder()
            .append(this.getOperid(), castOther.getOperid())
            .append(this.getRoleid(), castOther.getRoleid())
            .append(this.getStatus(), castOther.getStatus())
            .append(this.getStatusdate(), castOther.getStatusdate())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOperid())
            .append(getRoleid())
            .append(getStatus())
            .append(getStatusdate())
            .toHashCode();
    }

}
