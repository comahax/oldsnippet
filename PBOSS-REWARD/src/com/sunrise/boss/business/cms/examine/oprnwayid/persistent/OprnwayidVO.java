package com.sunrise.boss.business.cms.examine.oprnwayid.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.examine.oprnwayidlog.persistent.OprnwayidlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class OprnwayidVO implements Serializable, OperationLog {

    /** identifier field */
    private String operid;

    /** identifier field */
    private String wayid;

    /** full constructor */
    public OprnwayidVO(java.lang.String operid, java.lang.String wayid) {
        this.operid = operid;
        this.wayid = wayid;
    }

    /** default constructor */
    public OprnwayidVO() {
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("operid", getOperid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OprnwayidVO) ) return false;
        OprnwayidVO castOther = (OprnwayidVO) other;
        return new EqualsBuilder()
            .append(this.getOperid(), castOther.getOperid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOperid())
            .append(getWayid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return OprnwayidlogVO.class;
	}

}
