package com.sunrise.boss.business.cms.reward.busiwayrel.persistent;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.busiwayrellog.persistent.BusiwayrellogVO;

import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BusiwayrelVO implements OperationLog {

    /** identifier field */
    private String opnid;

    /** identifier field */
    private String wayid;

    /** full constructor */
    public BusiwayrelVO(java.lang.String opnid, java.lang.String wayid) {
        this.opnid = opnid;
        this.wayid = wayid;
    }

    /** default constructor */
    public BusiwayrelVO() {
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusiwayrelVO) ) return false;
        BusiwayrelVO castOther = (BusiwayrelVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .append(getWayid())
            .toHashCode();
    }
    public Class logVOClass() {
		// TODO Auto-generated method stub
		return BusiwayrellogVO.class;
	}

}
