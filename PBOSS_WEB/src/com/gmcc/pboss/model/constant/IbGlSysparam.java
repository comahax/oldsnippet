package com.gmcc.pboss.model.constant;

import java.util.Date;

/**
 * IbGlSysparam entity. @author MyEclipse Persistence Tools
 */

public class IbGlSysparam extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private IbGlSysparamId id;
	private Date begintime;
	private Date endtime;
	private String paramname;
	private String paramvalue;
	private String memo;

	// Constructors

	/** default constructor */
	public IbGlSysparam() {
	}

	/** minimal constructor */
	public IbGlSysparam(IbGlSysparamId id) {
		this.id = id;
	}

	/** full constructor */
	public IbGlSysparam(IbGlSysparamId id, Date begintime, Date endtime,
			String paramname, String paramvalue, String memo) {
		this.id = id;
		this.begintime = begintime;
		this.endtime = endtime;
		this.paramname = paramname;
		this.paramvalue = paramvalue;
		this.memo = memo;
	}

	// Property accessors

	public IbGlSysparamId getId() {
		return this.id;
	}

	public void setId(IbGlSysparamId id) {
		this.id = id;
	}

	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getParamname() {
		return this.paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}