package com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.persistent.ZjtyCompcoeflogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ZjtyCompcoefVO implements OperationLog,Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Float compcoef;

    /** full constructor */
    public ZjtyCompcoefVO(java.lang.String wayid, java.lang.Float compcoef) {
        this.wayid = wayid;
        this.compcoef = compcoef;
    }

    /** default constructor */
    public ZjtyCompcoefVO() {
    }

    /** minimal constructor */
    public ZjtyCompcoefVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Float getCompcoef() {
        return this.compcoef;
    }

    public void setCompcoef(java.lang.Float compcoef) {
        this.compcoef = compcoef;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyCompcoefVO) ) return false;
        ZjtyCompcoefVO castOther = (ZjtyCompcoefVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ZjtyCompcoeflogVO.class;
	}

}
