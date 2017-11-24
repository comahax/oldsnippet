package com.gmcc.pboss.business.base.dictgroup;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DictgroupVO extends BaseVO implements Serializable {

    /** identifier field */
    private String groupid;

    /** nullable persistent field */
    private String groupname;

    /** nullable persistent field */
    private String grouptype;

    /** nullable persistent field */
    private Byte managable;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public DictgroupVO(java.lang.String groupid, java.lang.String groupname, java.lang.String grouptype, java.lang.Byte managable, java.lang.Byte status, java.util.Date statusdate) {
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

    public java.lang.Byte getManagable() {
        return this.managable;
    }

    public void setManagable(java.lang.Byte managable) {
        this.managable = managable;
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
