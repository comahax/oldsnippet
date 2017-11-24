package com.gmcc.pboss.business.base.config;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class ConfigVO extends BaseVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6521587756883729193L;

	private String key;

	private String value;

	private String explain;

	public ConfigVO() {

	}
	
	public ConfigVO(String key) {
		this.key = key;
	}

	public ConfigVO(String key, String value, String explain) {
		this.key = key;
		this.value = value;
		this.explain = explain;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String toString() {
		return new ToStringBuilder(this).append("key", getKey()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof ConfigVO))
			return false;
		ConfigVO castOther = (ConfigVO) other;
		return new EqualsBuilder().append(this.getKey(), castOther.getKey())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getKey()).toHashCode();
	}
}
