package net.gmcc.pboss.domain.model.sysparam;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SysparamVOId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class SysparamVOId implements java.io.Serializable {

	// Fields

	private Long systemid;
	private String paramtype;

	// Constructors

	/** default constructor */
	public SysparamVOId() {
	}

	/** full constructor */
	public SysparamVOId(Long systemid, String paramtype) {
		this.systemid = systemid;
		this.paramtype = paramtype;
	}

	// Property accessors

	@Column(name = "SYSTEMID", nullable = false, precision = 14, scale = 0)
	public Long getSystemid() {
		return this.systemid;
	}

	public void setSystemid(Long systemid) {
		this.systemid = systemid;
	}

	@Column(name = "PARAMTYPE", nullable = false, length = 16)
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
		if (!(other instanceof SysparamVOId))
			return false;
		SysparamVOId castOther = (SysparamVOId) other;

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