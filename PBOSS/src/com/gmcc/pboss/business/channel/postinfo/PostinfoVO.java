package com.gmcc.pboss.business.channel.postinfo;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PostinfoVO extends BaseVO implements Serializable {

    /** identifier field */
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
    public PostinfoVO(java.lang.Long postid, java.lang.String postname, java.lang.Short postkind, java.lang.Long parentpost, java.lang.String way, java.lang.String waykind, java.util.Date startime, java.util.Date overtime, java.lang.Short status, java.lang.Short workkind, java.lang.String purviewmemo) {
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
    public PostinfoVO() {
    }

    /** minimal constructor */
    public PostinfoVO(java.lang.Long postid) {
        this.postid = postid;
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
            .append("postid", getPostid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PostinfoVO) ) return false;
        PostinfoVO castOther = (PostinfoVO) other;
        return new EqualsBuilder()
            .append(this.getPostid(), castOther.getPostid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPostid())
            .toHashCode();
    }

}
