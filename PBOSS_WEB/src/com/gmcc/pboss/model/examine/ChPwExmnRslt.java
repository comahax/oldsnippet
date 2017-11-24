package com.gmcc.pboss.model.examine;

import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ChKhExmnrslt entity. @author MyEclipse Persistence Tools
 */

public class ChPwExmnRslt implements java.io.Serializable {

	// Fields

	private String wayid;
	private Integer exmnid;
	private String exmnperiod;

	private Double exmnmark;

	private Set details;

	// Property accessors

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Integer getExmnid() {
		return exmnid;
	}

	public void setExmnid(Integer exmnid) {
		this.exmnid = exmnid;
	}

	public String getExmnperiod() {
		return exmnperiod;
	}

	public void setExmnperiod(String exmnperiod) {
		this.exmnperiod = exmnperiod;
	}

	public Double getExmnmark() {
		return exmnmark;
	}

	public void setExmnmark(Double exmnmark) {
		this.exmnmark = exmnmark;
	}

	public Set getDetails() {
		return details;
	}

	public void setDetails(Set details) {
		this.details = details;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exmnid == null) ? 0 : exmnid.hashCode());
		result = prime * result
				+ ((exmnperiod == null) ? 0 : exmnperiod.hashCode());
		result = prime * result + ((wayid == null) ? 0 : wayid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ChPwExmnRslt other = (ChPwExmnRslt) obj;
		if (exmnid == null) {
			if (other.exmnid != null)
				return false;
		} else if (!exmnid.equals(other.exmnid))
			return false;
		if (exmnperiod == null) {
			if (other.exmnperiod != null)
				return false;
		} else if (!exmnperiod.equals(other.exmnperiod))
			return false;
		if (wayid == null) {
			if (other.wayid != null)
				return false;
		} else if (!wayid.equals(other.wayid))
			return false;
		return true;
	}
}