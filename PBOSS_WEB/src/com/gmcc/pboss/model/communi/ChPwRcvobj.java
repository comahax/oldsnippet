package com.gmcc.pboss.model.communi;

import java.util.Date;

/**
 * ChPwRcvobj entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ChPwRcvobj implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7195279948863368656L;
	private Long rvcobjid;
	private String objid;
	private Long state;
	private Date checktime;
	private Date statetime;
	/**
	 * 所属公告信息
	 */
	private ChPwAdvinfo advinfo;

	/** default constructor */
	public ChPwRcvobj() {
	}

	/** minimal constructor */
	public ChPwRcvobj(Long rvcobjid) {
		this.rvcobjid = rvcobjid;
	}

	/** full constructor */
	public ChPwRcvobj(Long rvcobjid, String objid, Long state,
			Date checktime, Date statetime) {
		this.rvcobjid = rvcobjid;
		this.objid = objid;
		this.state = state;
		this.checktime = checktime;
		this.statetime = statetime;
	}

	// Property accessors

	public Long getRvcobjid() {
		return this.rvcobjid;
	}

	public void setRvcobjid(Long rvcobjid) {
		this.rvcobjid = rvcobjid;
	}

	public String getObjid() {
		return this.objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}

	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Date getChecktime() {
		return this.checktime;
	}

	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}

	public Date getStatetime() {
		return this.statetime;
	}

	public void setStatetime(Date statetime) {
		this.statetime = statetime;
	}
	
	public ChPwAdvinfo getAdvinfo() {
		return advinfo;
	}

	public void setAdvinfo(ChPwAdvinfo advinfo) {
		this.advinfo = advinfo;
	}

}