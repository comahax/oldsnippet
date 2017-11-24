package com.gmcc.pboss.business.reward.stype;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class VstypeVO extends BaseVO {

	/** identifier field */
	private String seq;
	
	/** identifier field */
	private String stype;

	/** nullable persistent field */
	private String ltype;

	/** nullable persistent field */
	private String optype;

	/** nullable persistent field */
	private String cityid;

	/** full constructor */
	public VstypeVO(java.lang.String seq, java.lang.String stype,
			java.lang.String ltype, java.lang.String optype) {
		this.seq = seq;
		this.stype = stype;
		this.ltype = ltype;
		this.optype = optype;
	}

	/** default constructor */
	public VstypeVO() {
	}

	/** minimal constructor */
	public VstypeVO(java.lang.String seq) {
		this.seq = seq;
	}

	public java.lang.String getStype() {
		return this.stype;
	}

	public void setStype(java.lang.String stype) {
		this.stype = stype;
	}

	public java.lang.String getLtype() {
		return this.ltype;
	}

	public void setLtype(java.lang.String ltype) {
		this.ltype = ltype;
	}

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String toString() {
		return new ToStringBuilder(this).append("seq", getSeq()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof VstypeVO))
			return false;
		VstypeVO castOther = (VstypeVO) other;
		return new EqualsBuilder().append(this.getSeq(), castOther.getSeq())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSeq()).toHashCode();
	}

}
