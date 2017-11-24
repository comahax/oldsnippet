package com.sunrise.boss.business.cms.examine.examinestdlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ExaminestdlogVO implements Serializable {

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
    private Integer exmnstdid;

    /** nullable persistent field */
    private String exmnstdname;

    /** nullable persistent field */
    private String markmode;

    /** nullable persistent field */
    private String syslogic;

    /** full constructor */
    public ExaminestdlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer exmnstdid, java.lang.String exmnstdname, java.lang.String markmode, java.lang.String syslogic) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.exmnstdid = exmnstdid;
        this.exmnstdname = exmnstdname;
        this.markmode = markmode;
        this.syslogic = syslogic;
    }

    /** default constructor */
    public ExaminestdlogVO() {
    }

    /** minimal constructor */
    public ExaminestdlogVO(java.lang.Long logid) {
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

    public java.lang.Integer getExmnstdid() {
        return this.exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid) {
        this.exmnstdid = exmnstdid;
    }

    public java.lang.String getExmnstdname() {
        return this.exmnstdname;
    }

    public void setExmnstdname(java.lang.String exmnstdname) {
        this.exmnstdname = exmnstdname;
    }

    public java.lang.String getMarkmode() {
        return this.markmode;
    }

    public void setMarkmode(java.lang.String markmode) {
        this.markmode = markmode;
    }

    public java.lang.String getSyslogic() {
        return this.syslogic;
    }

    public void setSyslogic(java.lang.String syslogic) {
        this.syslogic = syslogic;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExaminestdlogVO) ) return false;
        ExaminestdlogVO castOther = (ExaminestdlogVO) other;
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
