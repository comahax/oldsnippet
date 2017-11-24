package com.gmcc.pboss.business.promotion.ppzlnptnr;

import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PpzlnptnrVO extends BaseVO implements BusinessLog, Serializable {

    /** identifier field */
    private Long pid;

    /** identifier field */
    private String wayid;

    /** full constructor */
    public PpzlnptnrVO(java.lang.Long pid, java.lang.String wayid) {
        this.pid = pid;
        this.wayid = wayid;
    }

    /** default constructor */
    public PpzlnptnrVO() {
    }

    public java.lang.Long getPid() {
        return this.pid;
    }

    public void setPid(java.lang.Long pid) {
        this.pid = pid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pid", getPid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PpzlnptnrVO) ) return false;
        PpzlnptnrVO castOther = (PpzlnptnrVO) other;
        return new EqualsBuilder()
            .append(this.getPid(), castOther.getPid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPid())
            .append(getWayid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PpzlnptnrlogVO.class;
	}

}
