package com.gmcc.pboss.business.base.smsobjectlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SmsobjectlogVO extends BaseVO implements Serializable {

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

    /** persistent field */
    private Long seqid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String objecttype;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String busitype;

    /** full constructor */
    public SmsobjectlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.String countyid, java.lang.String objecttype, java.lang.String name, java.lang.String mobile, java.lang.String busitype) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.countyid = countyid;
        this.objecttype = objecttype;
        this.name = name;
        this.mobile = mobile;
        this.busitype = busitype;
    }

    /** default constructor */
    public SmsobjectlogVO() {
    }

    /** minimal constructor */
    public SmsobjectlogVO(java.lang.Long seqid) {
        this.seqid = seqid;
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

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getObjecttype() {
        return this.objecttype;
    }

    public void setObjecttype(java.lang.String objecttype) {
        this.objecttype = objecttype;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getBusitype() {
        return this.busitype;
    }

    public void setBusitype(java.lang.String busitype) {
        this.busitype = busitype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SmsobjectlogVO) ) return false;
        SmsobjectlogVO castOther = (SmsobjectlogVO) other;
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
