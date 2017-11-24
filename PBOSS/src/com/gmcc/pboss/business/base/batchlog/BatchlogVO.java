package com.gmcc.pboss.business.base.batchlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BatchlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprwayid;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String batchname;

    /** nullable persistent field */
    private String uploadpath;

    /** nullable persistent field */
    private String resultpath;

    /** full constructor */
    public BatchlogVO(java.util.Date optime, java.lang.String oprtype, java.lang.String oprcode, java.lang.String oprwayid, java.lang.String success, java.lang.String batchname, java.lang.String uploadpath, java.lang.String resultpath) {
        this.optime = optime;
        this.oprtype = oprtype;
        this.oprcode = oprcode;
        this.oprwayid = oprwayid;
        this.success = success;
        this.batchname = batchname;
        this.uploadpath = uploadpath;
        this.resultpath = resultpath;
    }

    /** default constructor */
    public BatchlogVO() {
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

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprwayid() {
        return this.oprwayid;
    }

    public void setOprwayid(java.lang.String oprwayid) {
        this.oprwayid = oprwayid;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.String getBatchname() {
        return this.batchname;
    }

    public void setBatchname(java.lang.String batchname) {
        this.batchname = batchname;
    }

    public java.lang.String getUploadpath() {
        return this.uploadpath;
    }

    public void setUploadpath(java.lang.String uploadpath) {
        this.uploadpath = uploadpath;
    }

    public java.lang.String getResultpath() {
        return this.resultpath;
    }

    public void setResultpath(java.lang.String resultpath) {
        this.resultpath = resultpath;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BatchlogVO) ) return false;
        BatchlogVO castOther = (BatchlogVO) other;
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
