package com.gmcc.pboss.business.communication.chpwcomsrcvobj;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPwComsrcvobjVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long rvcobjid;

    /** nullable persistent field */
    private Long advinfoid;

    /** nullable persistent field */
    private String objid;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private java.util.Date checktime;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String objname;

    /** full constructor */
    public ChPwComsrcvobjVO(java.lang.Long rvcobjid, java.lang.Long advinfoid, java.lang.String objid, java.lang.Short state, java.util.Date checktime, java.lang.String cityid, java.lang.String objname) {
        this.rvcobjid = rvcobjid;
        this.advinfoid = advinfoid;
        this.objid = objid;
        this.state = state;
        this.checktime = checktime;
        this.cityid = cityid;
        this.objname = objname;
    }

    /** default constructor */
    public ChPwComsrcvobjVO() {
    }

    /** minimal constructor */
    public ChPwComsrcvobjVO(java.lang.Long rvcobjid) {
        this.rvcobjid = rvcobjid;
    }

    public java.lang.Long getRvcobjid() {
        return this.rvcobjid;
    }

    public void setRvcobjid(java.lang.Long rvcobjid) {
        this.rvcobjid = rvcobjid;
    }

    public java.lang.Long getAdvinfoid() {
        return this.advinfoid;
    }

    public void setAdvinfoid(java.lang.Long advinfoid) {
        this.advinfoid = advinfoid;
    }

    public java.lang.String getObjid() {
        return this.objid;
    }

    public void setObjid(java.lang.String objid) {
        this.objid = objid;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.util.Date getChecktime() {
        return this.checktime;
    }

    public void setChecktime(java.util.Date checktime) {
        this.checktime = checktime;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getObjname() {
        return this.objname;
    }

    public void setObjname(java.lang.String objname) {
        this.objname = objname;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rvcobjid", getRvcobjid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwComsrcvobjVO) ) return false;
        ChPwComsrcvobjVO castOther = (ChPwComsrcvobjVO) other;
        return new EqualsBuilder()
            .append(this.getRvcobjid(), castOther.getRvcobjid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRvcobjid())
            .toHashCode();
    }

}
