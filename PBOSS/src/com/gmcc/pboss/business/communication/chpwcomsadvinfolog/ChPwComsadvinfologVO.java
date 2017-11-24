package com.gmcc.pboss.business.communication.chpwcomsadvinfolog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPwComsadvinfologVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private String optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long advinfoid;

    /** nullable persistent field */
    private String title;

    /** nullable persistent field */
    private String content;

    /** nullable persistent field */
    private java.util.Date releasetime;

    /** nullable persistent field */
    private Short smsnotify;

    /** nullable persistent field */
    private String affixname;

    /** nullable persistent field */
    private String affixpath;

    /** nullable persistent field */
    private String releasecode;

    /** nullable persistent field */
    private String rcvobjtype;

    /** nullable persistent field */
    private Short state;

    /** full constructor */
    public ChPwComsadvinfologVO(java.lang.String optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long advinfoid, java.lang.String title, java.lang.String content, java.util.Date releasetime, java.lang.Short smsnotify, java.lang.String affixname, java.lang.String affixpath, java.lang.String releasecode, java.lang.String rcvobjtype, java.lang.Short state) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.advinfoid = advinfoid;
        this.title = title;
        this.content = content;
        this.releasetime = releasetime;
        this.smsnotify = smsnotify;
        this.affixname = affixname;
        this.affixpath = affixpath;
        this.releasecode = releasecode;
        this.rcvobjtype = rcvobjtype;
        this.state = state;
    }

    /** default constructor */
    public ChPwComsadvinfologVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.String getOptime() {
        return this.optime;
    }

    public void setOptime(java.lang.String optime) {
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

    public java.lang.Long getAdvinfoid() {
        return this.advinfoid;
    }

    public void setAdvinfoid(java.lang.Long advinfoid) {
        this.advinfoid = advinfoid;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String content) {
        this.content = content;
    }

    public java.util.Date getReleasetime() {
        return this.releasetime;
    }

    public void setReleasetime(java.util.Date releasetime) {
        this.releasetime = releasetime;
    }

    public java.lang.Short getSmsnotify() {
        return this.smsnotify;
    }

    public void setSmsnotify(java.lang.Short smsnotify) {
        this.smsnotify = smsnotify;
    }

    public java.lang.String getAffixname() {
        return this.affixname;
    }

    public void setAffixname(java.lang.String affixname) {
        this.affixname = affixname;
    }

    public java.lang.String getAffixpath() {
        return this.affixpath;
    }

    public void setAffixpath(java.lang.String affixpath) {
        this.affixpath = affixpath;
    }

    public java.lang.String getReleasecode() {
        return this.releasecode;
    }

    public void setReleasecode(java.lang.String releasecode) {
        this.releasecode = releasecode;
    }

    public java.lang.String getRcvobjtype() {
        return this.rcvobjtype;
    }

    public void setRcvobjtype(java.lang.String rcvobjtype) {
        this.rcvobjtype = rcvobjtype;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwComsadvinfologVO) ) return false;
        ChPwComsadvinfologVO castOther = (ChPwComsadvinfologVO) other;
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
