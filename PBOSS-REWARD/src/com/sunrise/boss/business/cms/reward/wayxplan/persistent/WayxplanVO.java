package com.sunrise.boss.business.cms.reward.wayxplan.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.wayxplanlog.persistent.WayxplanlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class WayxplanVO implements OperationLog {

    /** identifier field */
    private String wayid;

    /** identifier field */
    private Long yxplanid;

    /** full constructor */
    public WayxplanVO(java.lang.String wayid, java.lang.Long yxplanid) {
        this.wayid = wayid;
        this.yxplanid = yxplanid;
    }

    /** default constructor */
    public WayxplanVO() {
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .append("yxplanid", getYxplanid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayxplanVO) ) return false;
        WayxplanVO castOther = (WayxplanVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .append(this.getYxplanid(), castOther.getYxplanid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .append(getYxplanid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return WayxplanlogVO.class;
	}

}
