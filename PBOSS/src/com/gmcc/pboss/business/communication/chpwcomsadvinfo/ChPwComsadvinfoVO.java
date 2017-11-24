package com.gmcc.pboss.business.communication.chpwcomsadvinfo;

import com.gmcc.pboss.business.communication.chpwcomsadvinfolog.ChPwComsadvinfologVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPwComsadvinfoVO extends BaseVO implements Serializable, BusinessLog {

    /** identifier field */
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
    public ChPwComsadvinfoVO(java.lang.String title, java.lang.String content, java.util.Date releasetime, java.lang.Short smsnotify, java.lang.String affixname, java.lang.String affixpath, java.lang.String releasecode, java.lang.String rcvobjtype, java.lang.Short state) {
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
    public ChPwComsadvinfoVO() {
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
            .append("advinfoid", getAdvinfoid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwComsadvinfoVO) ) return false;
        ChPwComsadvinfoVO castOther = (ChPwComsadvinfoVO) other;
        return new EqualsBuilder()
            .append(this.getAdvinfoid(), castOther.getAdvinfoid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAdvinfoid())
            .toHashCode();
    }

	public Class logVOClass() {
		return ChPwComsadvinfologVO.class;
	}

}
