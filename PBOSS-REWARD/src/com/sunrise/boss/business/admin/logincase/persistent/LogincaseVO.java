package com.sunrise.boss.business.admin.logincase.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LogincaseVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String module;

    /** identifier field */
    private String operid;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String roleid;

    /** full constructor */
    public LogincaseVO(java.lang.String cityid, java.lang.String module, java.lang.String operid, java.lang.String wayid, java.util.Date createtime, java.lang.String roleid) {
        this.cityid = cityid;
        this.module = module;
        this.operid = operid;
        this.wayid = wayid;
        this.createtime = createtime;
        this.roleid = roleid;
    }

    /** default constructor */
    public LogincaseVO() {
    }

    /** minimal constructor */
    public LogincaseVO(java.lang.String cityid, java.lang.String module, java.lang.String operid, java.lang.String wayid) {
        this.cityid = cityid;
        this.module = module;
        this.operid = operid;
        this.wayid = wayid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getModule() {
        return this.module;
    }

    public void setModule(java.lang.String module) {
        this.module = module;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getRoleid() {
        return this.roleid;
    }

    public void setRoleid(java.lang.String roleid) {
        this.roleid = roleid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("module", getModule())
            .append("operid", getOperid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LogincaseVO) ) return false;
        LogincaseVO castOther = (LogincaseVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getModule(), castOther.getModule())
            .append(this.getOperid(), castOther.getOperid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getModule())
            .append(getOperid())
            .append(getWayid())
            .toHashCode();
    }

}
