package com.gmcc.pboss.business.communication.rcvobj;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RcvobjVO extends BaseVO implements Serializable {

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
    private java.util.Date statetime;
    
    private String title;

    /** full constructor */
    public RcvobjVO(java.lang.Long advinfoid, java.lang.String objid, java.lang.Short state, java.util.Date checktime, java.util.Date statetime) {
        this.advinfoid = advinfoid;
        this.objid = objid;
        this.state = state;
        this.checktime = checktime;
        this.statetime = statetime;
    }

    /** default constructor */
    public RcvobjVO() {
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

    public java.util.Date getStatetime() {
        return this.statetime;
    }

    public void setStatetime(java.util.Date statetime) {
        this.statetime = statetime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rvcobjid", getRvcobjid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RcvobjVO) ) return false;
        RcvobjVO castOther = (RcvobjVO) other;
        return new EqualsBuilder()
            .append(this.getRvcobjid(), castOther.getRvcobjid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRvcobjid())
            .toHashCode();
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
