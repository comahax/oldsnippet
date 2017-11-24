package com.gmcc.pboss.business.base.dbloginlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DbLoginlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private java.util.Date logintime;

    /** nullable persistent field */
    private String clientname;

    /** nullable persistent field */
    private String macaddress;

    /** nullable persistent field */
    private String ipaddress;

    /** nullable persistent field */
    private String logintype;

    /** nullable persistent field */
    private Short issuccess;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public DbLoginlogVO(java.lang.Long logid, java.lang.String oprcode, java.lang.String wayid, java.lang.String cityid, java.util.Date logintime, java.lang.String clientname, java.lang.String macaddress, java.lang.String ipaddress, java.lang.String logintype, java.lang.Short issuccess, java.lang.String memo) {
        this.logid = logid;
        this.oprcode = oprcode;
        this.wayid = wayid;
        this.cityid = cityid;
        this.logintime = logintime;
        this.clientname = clientname;
        this.macaddress = macaddress;
        this.ipaddress = ipaddress;
        this.logintype = logintype;
        this.issuccess = issuccess;
        this.memo = memo;
    }

    /** default constructor */
    public DbLoginlogVO() {
    }

    /** minimal constructor */
    public DbLoginlogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.util.Date getLogintime() {
        return this.logintime;
    }

    public void setLogintime(java.util.Date logintime) {
        this.logintime = logintime;
    }

    public java.lang.String getClientname() {
        return this.clientname;
    }

    public void setClientname(java.lang.String clientname) {
        this.clientname = clientname;
    }

    public java.lang.String getMacaddress() {
        return this.macaddress;
    }

    public void setMacaddress(java.lang.String macaddress) {
        this.macaddress = macaddress;
    }

    public java.lang.String getIpaddress() {
        return this.ipaddress;
    }

    public void setIpaddress(java.lang.String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public java.lang.String getLogintype() {
        return this.logintype;
    }

    public void setLogintype(java.lang.String logintype) {
        this.logintype = logintype;
    }

    public java.lang.Short getIssuccess() {
        return this.issuccess;
    }

    public void setIssuccess(java.lang.Short issuccess) {
        this.issuccess = issuccess;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DbLoginlogVO) ) return false;
        DbLoginlogVO castOther = (DbLoginlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
