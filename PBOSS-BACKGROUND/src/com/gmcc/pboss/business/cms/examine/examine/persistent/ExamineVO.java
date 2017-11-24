package com.gmcc.pboss.business.cms.examine.examine.persistent;


import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.cms.examine.examinelog.persistent.ExaminelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;


/** @author Hibernate CodeGenerator */
public class ExamineVO  extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long exmnid;

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
    public ExamineVO(java.lang.Long exmnid, java.lang.String exmnname, java.lang.String state, java.lang.String cityid, java.lang.String applycityid, java.lang.String adtype, java.lang.String starlevel, java.lang.String memo, java.lang.String rights) {
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
    public ExamineVO() {
    }

    /** minimal constructor */
    public ExamineVO(java.lang.Long exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.Long getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Long exmnid) {
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
            .append("exmnid", getExmnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExamineVO) ) return false;
        ExamineVO castOther = (ExamineVO) other;
        return new EqualsBuilder()
            .append(this.getExmnid(), castOther.getExmnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getExmnid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ExaminelogVO.class;
	}

}
