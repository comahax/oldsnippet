package com.sunrise.boss.business.cms.postinfolog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PostinfologVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long postid;

    /** nullable persistent field */
    private String postname;

    /** nullable persistent field */
    private Short postkind;

    /** nullable persistent field */
    private Long parentpost;

    /** nullable persistent field */
    private String way;

    /** nullable persistent field */
    private String waykind;

    /** nullable persistent field */
    private java.util.Date startime;

    /** nullable persistent field */
    private java.util.Date overtime;

    /** nullable persistent field */
    private Short status;

    /** nullable persistent field */
    private Short workkind;

    /** nullable persistent field */
    private String purviewmemo;

    /** full constructor */
    public PostinfologVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long postid, java.lang.String postname, java.lang.Short postkind, java.lang.Long parentpost, java.lang.String way, java.lang.String waykind, java.util.Date startime, java.util.Date overtime, java.lang.Short status, java.lang.Short workkind, java.lang.String purviewmemo) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.postid = postid;
        this.postname = postname;
        this.postkind = postkind;
        this.parentpost = parentpost;
        this.way = way;
        this.waykind = waykind;
        this.startime = startime;
        this.overtime = overtime;
        this.status = status;
        this.workkind = workkind;
        this.purviewmemo = purviewmemo;
    }

    /** default constructor */
    public PostinfologVO() {
    }

    /** minimal constructor */
    public PostinfologVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
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

    public java.lang.Long getPostid() {
        return this.postid;
    }

    public void setPostid(java.lang.Long postid) {
        this.postid = postid;
    }

    public java.lang.String getPostname() {
        return this.postname;
    }

    public void setPostname(java.lang.String postname) {
        this.postname = postname;
    }

    public java.lang.Short getPostkind() {
        return this.postkind;
    }

    public void setPostkind(java.lang.Short postkind) {
        this.postkind = postkind;
    }

    public java.lang.Long getParentpost() {
        return this.parentpost;
    }

    public void setParentpost(java.lang.Long parentpost) {
        this.parentpost = parentpost;
    }

    public java.lang.String getWay() {
        return this.way;
    }

    public void setWay(java.lang.String way) {
        this.way = way;
    }

    public java.lang.String getWaykind() {
        return this.waykind;
    }

    public void setWaykind(java.lang.String waykind) {
        this.waykind = waykind;
    }

    public java.util.Date getStartime() {
        return this.startime;
    }

    public void setStartime(java.util.Date startime) {
        this.startime = startime;
    }

    public java.util.Date getOvertime() {
        return this.overtime;
    }

    public void setOvertime(java.util.Date overtime) {
        this.overtime = overtime;
    }

    public java.lang.Short getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Short status) {
        this.status = status;
    }

    public java.lang.Short getWorkkind() {
        return this.workkind;
    }

    public void setWorkkind(java.lang.Short workkind) {
        this.workkind = workkind;
    }

    public java.lang.String getPurviewmemo() {
        return this.purviewmemo;
    }

    public void setPurviewmemo(java.lang.String purviewmemo) {
        this.purviewmemo = purviewmemo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PostinfologVO) ) return false;
        PostinfologVO castOther = (PostinfologVO) other;
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
