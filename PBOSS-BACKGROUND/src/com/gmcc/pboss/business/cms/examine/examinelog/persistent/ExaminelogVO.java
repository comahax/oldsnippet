package com.gmcc.pboss.business.cms.examine.examinelog.persistent;


import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class ExaminelogVO  extends BaseVO implements Serializable {

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
    private Integer exmnid;

    /** nullable persistent field */
    private String exmnname;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String applycityid;

    /** nullable persistent field */
    private String adtype;

    /** nullable persistent field */
    private String starlevel;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String rights;

    /** full constructor */
    public ExaminelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer exmnid, java.lang.String exmnname, java.lang.String state, java.lang.String cityid, java.lang.String applycityid, java.lang.String adtype, java.lang.String starlevel, java.lang.String memo, java.lang.String rights) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.exmnid = exmnid;
        this.exmnname = exmnname;
        this.state = state;
        this.cityid = cityid;
        this.applycityid = applycityid;
        this.adtype = adtype;
        this.starlevel = starlevel;
        this.memo = memo;
        this.rights = rights;
    }

    /** default constructor */
    public ExaminelogVO() {
    }

    /** minimal constructor */
    public ExaminelogVO(java.lang.Long logid) {
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

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.String getExmnname() {
        return this.exmnname;
    }

    public void setExmnname(java.lang.String exmnname) {
        this.exmnname = exmnname;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getApplycityid() {
        return this.applycityid;
    }

    public void setApplycityid(java.lang.String applycityid) {
        this.applycityid = applycityid;
    }

    public java.lang.String getAdtype() {
        return this.adtype;
    }

    public void setAdtype(java.lang.String adtype) {
        this.adtype = adtype;
    }

    public java.lang.String getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.String starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getRights() {
        return this.rights;
    }

    public void setRights(java.lang.String rights) {
        this.rights = rights;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExaminelogVO) ) return false;
        ExaminelogVO castOther = (ExaminelogVO) other;
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
