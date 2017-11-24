package com.gmcc.pboss.biz.info.salesDetail.model;

/**
 * ChPwOperationsmsId entity. @author MyEclipse Persistence Tools
 */
public class ChPwOperationsmsId implements java.io.Serializable {
	// Fields
	private String cityid;
	private String opnid;
	private String smsno;
	private Short opntype;
	
	// Constructors

	/** default constructor */
	public ChPwOperationsmsId() {
	}

	public ChPwOperationsmsId(String cityid, String smsno,Short opntype){
		this.cityid = cityid;
		this.smsno = smsno;
		this.opntype = opntype;
	}
	/** full constructor */
	public ChPwOperationsmsId(String cityid, String opnid, String smsno,
			Short opntype) {
		this.cityid = cityid;
		this.opnid = opnid;
		this.smsno = smsno;
		this.opntype = opntype;
	}

	// Property accessors

	public String getCityid() {
		return this.cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getSmsno() {
		return this.smsno;
	}

	public void setSmsno(String smsno) {
		this.smsno = smsno;
	}

	public Short getOpntype() {
		return this.opntype;
	}

	public void setOpntype(Short opntype) {
		this.opntype = opntype;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ChPwOperationsmsId))
			return false;
		ChPwOperationsmsId castOther = (ChPwOperationsmsId) other;
		return ((this.getCityid() == castOther.getCityid()) || (this
				.getCityid() != null
				&& castOther.getCityid() != null && this.getCityid().equals(
				castOther.getCityid())))
				&& ((this.getOpnid() == castOther.getOpnid()) || (this
						.getOpnid() != null
						&& castOther.getOpnid() != null && this.getOpnid()
						.equals(castOther.getOpnid())))
				&& ((this.getSmsno() == castOther.getSmsno()) || (this
						.getSmsno() != null
						&& castOther.getSmsno() != null && this.getSmsno()
						.equals(castOther.getSmsno())))
				&& ((this.getOpntype() == castOther.getOpntype()) || (this
						.getOpntype() != null
						&& castOther.getOpntype() != null && this.getOpntype()
						.equals(castOther.getOpntype())));
	}

	public int hashCode() {
		int result = 17;
		result = 37 * result
				+ (getCityid() == null ? 0 : this.getCityid().hashCode());
		result = 37 * result
				+ (getOpnid() == null ? 0 : this.getOpnid().hashCode());
		result = 37 * result
				+ (getSmsno() == null ? 0 : this.getSmsno().hashCode());
		result = 37 * result
				+ (getOpntype() == null ? 0 : this.getOpntype().hashCode());
		return result;
	}
}
