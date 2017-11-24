package com.sunrise.boss.business.cms.distribute.cpcomsalerl.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.sunrise.boss.business.common.dblog.ManageLog;

/** @author Hibernate CodeGenerator */
public class CpcomsalerlVO implements Serializable, ManageLog {

	/** identifier field */
	private Long cpsaleid;

	/** persistent field */
	private String cooperauid;

	/** persistent field */
	private Short fxtype;

	/** persistent field */
	private Long comid;

	/** persistent field */
	private Integer maxnum;

	/** persistent field */
	private Integer minnum;

	/** persistent field */
	private Short disctype;

	/** persistent field */
	private Double discount;

	/** nullable persistent field */
	private Integer ordbasenum;

	/** persistent field */
	private Double minactive;

	/** nullable persistent field */
	private String privid;

	/** full constructor */
	public CpcomsalerlVO(java.lang.Long cpsaleid, java.lang.String cooperauid,
			java.lang.Short fxtype, java.lang.Long comid,
			java.lang.Integer maxnum, java.lang.Integer minnum,
			java.lang.Short disctype, java.lang.Double discount,
			java.lang.Integer ordbasenum, java.lang.Double minactive,
			java.lang.String privid) {
		this.cpsaleid = cpsaleid;
		this.cooperauid = cooperauid;
		this.fxtype = fxtype;
		this.comid = comid;
		this.maxnum = maxnum;
		this.minnum = minnum;
		this.disctype = disctype;
		this.discount = discount;
		this.ordbasenum = ordbasenum;
		this.minactive = minactive;
		this.privid = privid;
	}

	/** default constructor */
	public CpcomsalerlVO() {
	}

	/** minimal constructor */
	public CpcomsalerlVO(java.lang.Long cpsaleid, java.lang.String cooperauid,
			java.lang.Short fxtype, java.lang.Long comid,
			java.lang.Integer maxnum, java.lang.Integer minnum,
			java.lang.Short disctype, java.lang.Double discount,
			java.lang.Double minactive) {
		this.cpsaleid = cpsaleid;
		this.cooperauid = cooperauid;
		this.fxtype = fxtype;
		this.comid = comid;
		this.maxnum = maxnum;
		this.minnum = minnum;
		this.disctype = disctype;
		this.discount = discount;
		this.minactive = minactive;
	}

	public java.lang.Long getCpsaleid() {
		return this.cpsaleid;
	}

	public void setCpsaleid(java.lang.Long cpsaleid) {
		this.cpsaleid = cpsaleid;
	}

	public java.lang.String getCooperauid() {
		return this.cooperauid;
	}

	public void setCooperauid(java.lang.String cooperauid) {
		this.cooperauid = cooperauid;
	}

	public java.lang.Short getFxtype() {
		return this.fxtype;
	}

	public void setFxtype(java.lang.Short fxtype) {
		this.fxtype = fxtype;
	}

	public java.lang.Integer getMaxnum() {
		return this.maxnum;
	}

	public void setMaxnum(java.lang.Integer maxnum) {
		this.maxnum = maxnum;
	}

	public java.lang.Integer getMinnum() {
		return this.minnum;
	}

	public void setMinnum(java.lang.Integer minnum) {
		this.minnum = minnum;
	}

	public java.lang.Short getDisctype() {
		return this.disctype;
	}

	public void setDisctype(java.lang.Short disctype) {
		this.disctype = disctype;
	}

	public java.lang.Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(java.lang.Double discount) {
		this.discount = discount;
	}

	public java.lang.Integer getOrdbasenum() {
		return this.ordbasenum;
	}

	public void setOrdbasenum(java.lang.Integer ordbasenum) {
		this.ordbasenum = ordbasenum;
	}

	public java.lang.Double getMinactive() {
		return this.minactive;
	}

	public void setMinactive(java.lang.Double minactive) {
		this.minactive = minactive;
	}

	public java.lang.String getPrivid() {
		return this.privid;
	}

	public void setPrivid(java.lang.String privid) {
		this.privid = privid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("cpsaleid", getCpsaleid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof CpcomsalerlVO))
			return false;
		CpcomsalerlVO castOther = (CpcomsalerlVO) other;
		return new EqualsBuilder().append(this.getCpsaleid(),
				castOther.getCpsaleid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCpsaleid()).toHashCode();
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public Long getComid() {
		return comid;
	}

}
