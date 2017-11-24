package com.gmcc.pboss.business.promotion.elmtinstlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ElmtinstlogVO extends BaseVO implements Serializable {

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
    private Integer instid;

    /** nullable persistent field */
    private String instname;

    /** nullable persistent field */
    private Integer tmplid;

    /** nullable persistent field */
    private String params;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ElmtinstlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer instid, java.lang.String instname, java.lang.Integer tmplid, java.lang.String params, java.lang.String memo) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.instid = instid;
        this.instname = instname;
        this.tmplid = tmplid;
        this.params = params;
        this.memo = memo;
    }

    /** default constructor */
    public ElmtinstlogVO() {
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

    public java.lang.Integer getInstid() {
        return this.instid;
    }

    public void setInstid(java.lang.Integer instid) {
        this.instid = instid;
    }

    public java.lang.String getInstname() {
        return this.instname;
    }

    public void setInstname(java.lang.String instname) {
        this.instname = instname;
    }

    public java.lang.Integer getTmplid() {
        return this.tmplid;
    }

    public void setTmplid(java.lang.Integer tmplid) {
        this.tmplid = tmplid;
    }

    public java.lang.String getParams() {
        return this.params;
    }

    public void setParams(java.lang.String params) {
        this.params = params;
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
        if ( !(other instanceof ElmtinstlogVO) ) return false;
        ElmtinstlogVO castOther = (ElmtinstlogVO) other;
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
