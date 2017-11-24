package com.gmcc.pboss.business.base.rolefunctionlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RolefunctionlogVO extends BaseVO implements Serializable {

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
    private String itemid;

    /** nullable persistent field */
    private String functionid;

    /** nullable persistent field */
    private Byte operatetype;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public RolefunctionlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String itemid, java.lang.String functionid, java.lang.Byte operatetype, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.itemid = itemid;
        this.functionid = functionid;
        this.operatetype = operatetype;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public RolefunctionlogVO() {
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

    public java.lang.String getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.String itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getFunctionid() {
        return this.functionid;
    }

    public void setFunctionid(java.lang.String functionid) {
        this.functionid = functionid;
    }

    public java.lang.Byte getOperatetype() {
        return this.operatetype;
    }

    public void setOperatetype(java.lang.Byte operatetype) {
        this.operatetype = operatetype;
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RolefunctionlogVO) ) return false;
        RolefunctionlogVO castOther = (RolefunctionlogVO) other;
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
