package com.sunrise.boss.business.fee.woff.eboxunit.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.ManageLog;

/**
 * <p>
 * Title: EBoxUnitVO
 * </p>
 * <p>
 * Description: EBox Unit VO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author xiefufeng
 * @version 1.0
 */

public class EBoxUnitVO implements Serializable ,ManageLog{

	// Fields

	private Long eboxunitid;

	private String eboxunitname;

	private Integer eboxunittype;

	private Short eboxunitstate;

	private Short canwithd;

	private Short canprintinv;

	private Short isneedpayway;

	private Short canjiezhuan;

	private Short iscommon;

	private Short canwoff;

	private Long woffpri;

	private Short canpaybehalf;

	private String brand;

	// Constructors

	/** default constructor */
	public EBoxUnitVO() {
	}

	/** minimal constructor */
	public EBoxUnitVO(Long eboxunitid) {
		this.eboxunitid = eboxunitid;
	}

	
	// Property accessors

	public EBoxUnitVO(Long eboxunitid, String eboxunitname, Integer eboxunittype, Short eboxunitstate, Short canwithd, Short canprintinv, Short isneedpayway, Short canjiezhuan, Short iscommon, Short canwoff, Long woffpri, Short canpaybehalf, String brand) {
		super();
		// TODO Auto-generated constructor stub
		this.eboxunitid = eboxunitid;
		this.eboxunitname = eboxunitname;
		this.eboxunittype = eboxunittype;
		this.eboxunitstate = eboxunitstate;
		this.canwithd = canwithd;
		this.canprintinv = canprintinv;
		this.isneedpayway = isneedpayway;
		this.canjiezhuan = canjiezhuan;
		this.iscommon = iscommon;
		this.canwoff = canwoff;
		this.woffpri = woffpri;
		this.canpaybehalf = canpaybehalf;
		this.brand = brand;
	}

	public Long getEboxunitid() {
		return this.eboxunitid;
	}

	public void setEboxunitid(Long eboxunitid) {
		this.eboxunitid = eboxunitid;
	}

	public String getEboxunitname() {
		return this.eboxunitname;
	}

	public void setEboxunitname(String eboxunitname) {
		this.eboxunitname = eboxunitname;
	}

	public Integer getEboxunittype() {
		return this.eboxunittype;
	}

	public void setEboxunittype(Integer eboxunittype) {
		this.eboxunittype = eboxunittype;
	}

	public Short getEboxunitstate() {
		return this.eboxunitstate;
	}

	public void setEboxunitstate(Short eboxunitstate) {
		this.eboxunitstate = eboxunitstate;
	}

	public Short getCanwithd() {
		return this.canwithd;
	}

	public void setCanwithd(Short canwithd) {
		this.canwithd = canwithd;
	}

	public Short getCanprintinv() {
		return this.canprintinv;
	}

	public void setCanprintinv(Short canprintinv) {
		this.canprintinv = canprintinv;
	}

	public Short getIsneedpayway() {
		return this.isneedpayway;
	}

	public void setIsneedpayway(Short isneedpayway) {
		this.isneedpayway = isneedpayway;
	}

	public Short getCanjiezhuan() {
		return this.canjiezhuan;
	}

	public void setCanjiezhuan(Short canjiezhuan) {
		this.canjiezhuan = canjiezhuan;
	}

	public Short getIscommon() {
		return this.iscommon;
	}

	public void setIscommon(Short iscommon) {
		this.iscommon = iscommon;
	}

	public Short getCanwoff() {
		return this.canwoff;
	}

	public void setCanwoff(Short canwoff) {
		this.canwoff = canwoff;
	}

	public Long getWoffpri() {
		return this.woffpri;
	}

	public void setWoffpri(Long woffpri) {
		this.woffpri = woffpri;
	}

	public Short getCanpaybehalf() {
		return this.canpaybehalf;
	}

	public void setCanpaybehalf(Short canpaybehalf) {
		this.canpaybehalf = canpaybehalf;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.getEboxunitid()).append("~").append(this.getEboxunitname()).append("~")
			.append(this.getEboxunittype()).append("~").append(this.getEboxunitstate()).append("~")
			.append(this.getCanwithd()).append("~").append(this.getCanprintinv()).append("~")
			.append(this.getIsneedpayway()).append("~").append(this.getCanjiezhuan()).append("~")
			.append(this.getIscommon()).append("~").append(this.getCanwoff()).append("~")
			.append(this.getWoffpri()).append("~").append(this.getCanpaybehalf()).append("~")
			.append(this.getBrand()).append("~");
		return buf.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof EBoxUnitVO))
			return false;
		EBoxUnitVO castOther = (EBoxUnitVO) other;
		return new EqualsBuilder().append(this.getEboxunitid(),
				castOther.getEboxunitid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getEboxunitid()).toHashCode();
	}

}
