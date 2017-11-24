package com.gmcc.pboss.business.base.rolelog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RolelogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
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
    public RolelogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String roleid, java.lang.String rolename, java.lang.Byte ispublic, java.lang.String operid, java.lang.String orgid, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate, java.lang.Byte isback, java.lang.String memo) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
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
    public RolelogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RolelogVO) ) return false;
        RolelogVO castOther = (RolelogVO) other;
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
