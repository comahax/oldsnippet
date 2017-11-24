package com.gmcc.pboss.business.reward.payway;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class VWayVO extends BaseVO {
	private String wayid;

	private String cityid;

	public VWayVO() {

	}

	public VWayVO(String wayid) {
		this.wayid = wayid;
	}
	
	public VWayVO(String wayid, String cityid) {
		this.wayid = wayid;
		this.cityid = cityid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("wayid", getWayid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof VWayVO))
			return false;
		VWayVO castOther = (VWayVO) other;
		return new EqualsBuilder()
				.append(this.getWayid(), castOther.getWayid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getWayid()).toHashCode();
	}

}
