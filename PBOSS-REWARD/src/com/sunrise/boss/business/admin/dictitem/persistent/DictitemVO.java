package com.sunrise.boss.business.admin.dictitem.persistent;

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
public class DictitemVO implements Serializable {

    /** identifier field */
    private String dictid;

    /** identifier field */
    private String groupid;

    /** nullable persistent field */
    private String dictname;

    /** nullable persistent field */
    private String description;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private Short status;

    /** nullable persistent field */
    private java.sql.Timestamp statusdate;

    /** full constructor */
    public DictitemVO(java.lang.String dictid, java.lang.String groupid, java.lang.String dictname, java.lang.String description, java.lang.Short sortorder, java.lang.Short status, java.sql.Timestamp statusdate) {
        this.dictid = dictid;
        this.groupid = groupid;
        this.dictname = dictname;
        this.description = description;
        this.sortorder = sortorder;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public DictitemVO() {
    }

    /** minimal constructor */
    public DictitemVO(java.lang.String dictid, java.lang.String groupid) {
        this.dictid = dictid;
        this.groupid = groupid;
    }

    public java.lang.String getDictid() {
        return this.dictid;
    }

    public void setDictid(java.lang.String dictid) {
        this.dictid = dictid;
    }

    public java.lang.String getGroupid() {
        return this.groupid;
    }

    public void setGroupid(java.lang.String groupid) {
        this.groupid = groupid;
    }

    public java.lang.String getDictname() {
        return this.dictname;
    }

    public void setDictname(java.lang.String dictname) {
        this.dictname = dictname;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.lang.Short getSortorder() {
        return this.sortorder;
    }

    public void setSortorder(java.lang.Short sortorder) {
        this.sortorder = sortorder;
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
            .append("dictid", getDictid())
            .append("groupid", getGroupid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DictitemVO) ) return false;
        DictitemVO castOther = (DictitemVO) other;
        return new EqualsBuilder()
            .append(this.getDictid(), castOther.getDictid())
            .append(this.getGroupid(), castOther.getGroupid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDictid())
            .append(getGroupid())
            .toHashCode();
    }

}
