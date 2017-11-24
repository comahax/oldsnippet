package com.gmcc.pboss.model.constant;

/**
 * IbGlSysparamId entity. @author MyEclipse Persistence Tools
 */

public class IbGlSysparamId extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private Long systemid;
	private String paramtype;

	// Constructors

	/** default constructor */
	public IbGlSysparamId() {
	}

	/** full constructor */
	public IbGlSysparamId(Long systemid, String paramtype) {
		this.systemid = systemid;
		this.paramtype = paramtype;
	}

	// Property accessors

	public Long getSystemid() {
		return this.systemid;
	}

	public void setSystemid(Long systemid) {
		this.systemid = systemid;
	}

	public String getParamtype() {
		return this.paramtype;
	}

	public void setParamtype(String paramtype) {
		this.paramtype = paramtype;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IbGlSysparamId))
			return false;
		IbGlSysparamId castOther = (IbGlSysparamId) other;

		return ((this.getSystemid() == castOther.getSystemid()) || (this
				.getSystemid() != null
				&& castOther.getSystemid() != null && this.getSystemid()
				.equals(castOther.getSystemid())))
				&& ((this.getParamtype() == castOther.getParamtype()) || (this
						.getParamtype() != null
						&& castOther.getParamtype() != null && this
						.getParamtype().equals(castOther.getParamtype())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSystemid() == null ? 0 : this.getSystemid().hashCode());
		result = 37 * result
				+ (getParamtype() == null ? 0 : this.getParamtype().hashCode());
		return result;
	}

}