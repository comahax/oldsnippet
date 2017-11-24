package com.gmcc.pboss.business.communication.questionnaire;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class QuestionnaireVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long advinfoid;

    /** nullable persistent field */
    private String title;

    /** nullable persistent field */
    private String content;

    /** nullable persistent field */
    private Short type;

    /** nullable persistent field */
    private java.util.Date releasetime;

    /** nullable persistent field */
    private java.util.Date plantime;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private Short desttype;

    /** nullable persistent field */
    private Short smsnotify;

    /** nullable persistent field */
    private Short ndapproval;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private Short state;

    /** full constructor */
    public QuestionnaireVO(java.lang.String title, java.lang.String content, java.lang.Short type, java.util.Date releasetime, java.util.Date plantime, java.util.Date enddate, java.lang.Short desttype, java.lang.Short smsnotify, java.lang.Short ndapproval, java.lang.String oprcode, java.lang.Short state) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.releasetime = releasetime;
        this.plantime = plantime;
        this.enddate = enddate;
        this.desttype = desttype;
        this.smsnotify = smsnotify;
        this.ndapproval = ndapproval;
        this.oprcode = oprcode;
        this.state = state;
    }

    /** default constructor */
    public QuestionnaireVO() {
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

    public java.lang.Short getType() {
        return this.type;
    }

    public void setType(java.lang.Short type) {
        this.type = type;
    }

    public java.util.Date getReleasetime() {
        return this.releasetime;
    }

    public void setReleasetime(java.util.Date releasetime) {
        this.releasetime = releasetime;
    }

    public java.util.Date getPlantime() {
        return this.plantime;
    }

    public void setPlantime(java.util.Date plantime) {
        this.plantime = plantime;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.Short getDesttype() {
        return this.desttype;
    }

    public void setDesttype(java.lang.Short desttype) {
        this.desttype = desttype;
    }

    public java.lang.Short getSmsnotify() {
        return this.smsnotify;
    }

    public void setSmsnotify(java.lang.Short smsnotify) {
        this.smsnotify = smsnotify;
    }

    public java.lang.Short getNdapproval() {
        return this.ndapproval;
    }

    public void setNdapproval(java.lang.Short ndapproval) {
        this.ndapproval = ndapproval;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
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
        if ( !(other instanceof AdvinfoVO) ) return false;
        AdvinfoVO castOther = (AdvinfoVO) other;
        return new EqualsBuilder()
            .append(this.getAdvinfoid(), castOther.getAdvinfoid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAdvinfoid())
            .toHashCode();
    }

}
