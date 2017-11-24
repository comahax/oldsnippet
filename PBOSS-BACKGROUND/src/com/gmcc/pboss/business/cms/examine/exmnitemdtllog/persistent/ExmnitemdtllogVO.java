package com.gmcc.pboss.business.cms.examine.exmnitemdtllog.persistent;


import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class ExmnitemdtllogVO  extends BaseVO implements Serializable {

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
    private Long seqid;

    /** nullable persistent field */
    private Integer exmnid;

    /** nullable persistent field */
    private Integer exmnstdid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String marktype;

    /** nullable persistent field */
    private Float basemk;

    /** nullable persistent field */
    private Float dynamicmk;

    /** nullable persistent field */
    private Float leastcrtcl;

    /** nullable persistent field */
    private Float largestcrtcl;

    /** nullable persistent field */
    private Long pseqid;

    /** full constructor */
    public ExmnitemdtllogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.Integer exmnid, java.lang.Integer exmnstdid, java.lang.String cityid, java.lang.String marktype, java.lang.Float basemk, java.lang.Float dynamicmk, java.lang.Float leastcrtcl, java.lang.Float largestcrtcl, java.lang.Long pseqid) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.exmnid = exmnid;
        this.exmnstdid = exmnstdid;
        this.cityid = cityid;
        this.marktype = marktype;
        this.basemk = basemk;
        this.dynamicmk = dynamicmk;
        this.leastcrtcl = leastcrtcl;
        this.largestcrtcl = largestcrtcl;
        this.pseqid = pseqid;
    }

    /** default constructor */
    public ExmnitemdtllogVO() {
    }

    /** minimal constructor */
    public ExmnitemdtllogVO(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.Integer getExmnstdid() {
        return this.exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid) {
        this.exmnstdid = exmnstdid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getMarktype() {
        return this.marktype;
    }

    public void setMarktype(java.lang.String marktype) {
        this.marktype = marktype;
    }

    public java.lang.Float getBasemk() {
        return this.basemk;
    }

    public void setBasemk(java.lang.Float basemk) {
        this.basemk = basemk;
    }

    public java.lang.Float getDynamicmk() {
        return this.dynamicmk;
    }

    public void setDynamicmk(java.lang.Float dynamicmk) {
        this.dynamicmk = dynamicmk;
    }

    public java.lang.Float getLeastcrtcl() {
        return this.leastcrtcl;
    }

    public void setLeastcrtcl(java.lang.Float leastcrtcl) {
        this.leastcrtcl = leastcrtcl;
    }

    public java.lang.Float getLargestcrtcl() {
        return this.largestcrtcl;
    }

    public void setLargestcrtcl(java.lang.Float largestcrtcl) {
        this.largestcrtcl = largestcrtcl;
    }

    public java.lang.Long getPseqid() {
        return this.pseqid;
    }

    public void setPseqid(java.lang.Long pseqid) {
        this.pseqid = pseqid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExmnitemdtllogVO) ) return false;
        ExmnitemdtllogVO castOther = (ExmnitemdtllogVO) other;
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
