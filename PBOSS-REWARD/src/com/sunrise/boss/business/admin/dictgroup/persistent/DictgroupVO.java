package com.sunrise.boss.business.admin.dictgroup.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <p>Title:ΚµΜε VO</p>
 *
 * <p>Description:</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: Maywide Tech Ltd.</p>
 *
 * @author Maywide CodeGenerator
 *
 * @version 1.0
 */
public class DictgroupVO implements Serializable {

    /** identifier field */
    private String groupid;

    /** nullable persistent field */
    private String groupname;

    /** nullable persistent field */
    private String grouptype;

    /** nullable persistent field */
    private Short managable;

    /** nullable persistent field */
    private Short status;

    /** nullable persistent field */
    private java.sql.Timestamp statusdate;

    /** full constructor */
    public DictgroupVO(java.lang.String groupid, java.lang.String groupname, java.lang.String grouptype, java.lang.Short managable, java.lang.Short status, java.sql.Timestamp statusdate) {
        this.groupid = groupid;
        this.groupname = groupname;
        this.grouptype = grouptype;
        this.managable = managable;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public DictgroupVO() {
    }

    /** minimal constructor */
    public DictgroupVO(java.lang.String groupid) {
        this.groupid = groupid;
    }

    public java.lang.String getGroupid() {
        return this.groupid;
    }

    public void setGroupid(java.lang.String groupid) {
        this.groupid = groupid;
    }

    public java.lang.String getGroupname() {
        return this.groupname;
    }

    public void setGroupname(java.lang.String groupname) {
        this.groupname = groupname;
    }

    public java.lang.String getGrouptype() {
        return this.grouptype;
    }

    public void setGrouptype(java.lang.String grouptype) {
        this.grouptype = grouptype;
    }

    public java.lang.Short getManagable() {
        return this.managable;
    }

    public void setManagable(java.lang.Short managable) {
        this.managable = managable;
    }

    public java.lang.Short getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Short status) {
        this.status = status;
    }

    public java.sql.Timestamp getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.sql.Timestamp statusdate) {
        this.statusdate = statusdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("groupid", getGroupid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DictgroupVO) ) return false;
        DictgroupVO castOther = (DictgroupVO) other;
        return new EqualsBuilder()
            .append(this.getGroupid(), castOther.getGroupid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGroupid())
            .toHashCode();
    }

}
