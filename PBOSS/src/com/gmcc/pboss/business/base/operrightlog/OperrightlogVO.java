package com.gmcc.pboss.business.base.operrightlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OperrightlogVO extends BaseVO implements Serializable {

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
    private String operid;

    /** nullable persistent field */
    private String rightid;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private Byte flag;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public OperrightlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String operid, java.lang.String rightid, java.lang.Byte status, java.util.Date createdate, java.lang.Short sortorder, java.lang.Byte flag, java.util.Date statusdate) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.operid = operid;
        this.rightid = rightid;
        this.status = status;
        this.createdate = createdate;
        this.sortorder = sortorder;
        this.flag = flag;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public OperrightlogVO() {
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

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.lang.String getRightid() {
        return this.rightid;
    }

    public void setRightid(java.lang.String rightid) {
        this.rightid = rightid;
    }

    public java.lang.Byte getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.Short getSortorder() {
        return this.sortorder;
    }

    public void setSortorder(java.lang.Short sortorder) {
        this.sortorder = sortorder;
    }

    public java.lang.Byte getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.Byte flag) {
        this.flag = flag;
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
        if ( !(other instanceof OperrightlogVO) ) return false;
        OperrightlogVO castOther = (OperrightlogVO) other;
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
