package com.gmcc.pboss.biz.info.reward.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ChBbcOperation entity. @author MyEclipse Persistence Tools
 */

public class BbcOperation implements java.io.Serializable {

	// Fields

	private String opnid;
	private String name;
	private String parentid;
	private String remark;
	private Byte state;
	private Date startdate;
	private Date enddate;
	private Boolean isbusi;
	private Short opnlevel;
	private Boolean busikind;
	private String busibelong;

	// Constructors

	/** default constructor */
	public BbcOperation() {
	}

	/** minimal constructor */
	public BbcOperation(String opnid) {
		this.opnid = opnid;
	}

	/** full constructor */
	public BbcOperation(String opnid, String name, String parentid, String remark, Byte state, Date startdate, Date enddate, Boolean isbusi, Short opnlevel,
			Boolean busikind, String busibelong) {
		this.opnid = opnid;
		this.name = name;
		this.parentid = parentid;
		this.remark = remark;
		this.state = state;
		this.startdate = startdate;
		this.enddate = enddate;
		this.isbusi = isbusi;
		this.opnlevel = opnlevel;
		this.busikind = busikind;
		this.busibelong = busibelong;
	}

	// Property accessors

	public String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Byte getState() {
		return this.state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Boolean getIsbusi() {
		return this.isbusi;
	}

	public void setIsbusi(Boolean isbusi) {
		this.isbusi = isbusi;
	}

	public Short getOpnlevel() {
		return this.opnlevel;
	}

	public void setOpnlevel(Short opnlevel) {
		this.opnlevel = opnlevel;
	}

	public Boolean getBusikind() {
		return this.busikind;
	}

	public void setBusikind(Boolean busikind) {
		this.busikind = busikind;
	}

	public String getBusibelong() {
		return this.busibelong;
	}

	public void setBusibelong(String busibelong) {
		this.busibelong = busibelong;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}