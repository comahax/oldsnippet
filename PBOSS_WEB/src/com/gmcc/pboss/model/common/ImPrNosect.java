package com.gmcc.pboss.model.common;

import java.util.Date;

/**
 * ImPrNosect entity. @author MyEclipse Persistence Tools
 */

public class ImPrNosect extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private Integer nosectid;
	private Date starttime;
	private Date intime;
	private String beginno;
	private String endno;
	private Short nosectstate;
	private Integer imsisectid;
	private Integer nogroupid;
	private Integer scpid;
	private String bossarea;
	private String originbrandid;
	private Integer vpmnid;
	private String platformtype;

	// Constructors

	/** default constructor */
	public ImPrNosect() {
	}

	/** minimal constructor */
	public ImPrNosect(Integer nosectid) {
		this.nosectid = nosectid;
	}

	/** full constructor */
	public ImPrNosect(Integer nosectid, Date starttime, Date intime,
			String beginno, String endno, Short nosectstate,
			Integer imsisectid, Integer nogroupid, Integer scpid,
			String bossarea, String originbrandid, Integer vpmnid,
			String platformtype) {
		this.nosectid = nosectid;
		this.starttime = starttime;
		this.intime = intime;
		this.beginno = beginno;
		this.endno = endno;
		this.nosectstate = nosectstate;
		this.imsisectid = imsisectid;
		this.nogroupid = nogroupid;
		this.scpid = scpid;
		this.bossarea = bossarea;
		this.originbrandid = originbrandid;
		this.vpmnid = vpmnid;
		this.platformtype = platformtype;
	}

	// Property accessors

	public Integer getNosectid() {
		return this.nosectid;
	}

	public void setNosectid(Integer nosectid) {
		this.nosectid = nosectid;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getIntime() {
		return this.intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public String getBeginno() {
		return this.beginno;
	}

	public void setBeginno(String beginno) {
		this.beginno = beginno;
	}

	public String getEndno() {
		return this.endno;
	}

	public void setEndno(String endno) {
		this.endno = endno;
	}

	public Short getNosectstate() {
		return this.nosectstate;
	}

	public void setNosectstate(Short nosectstate) {
		this.nosectstate = nosectstate;
	}

	public Integer getImsisectid() {
		return this.imsisectid;
	}

	public void setImsisectid(Integer imsisectid) {
		this.imsisectid = imsisectid;
	}

	public Integer getNogroupid() {
		return this.nogroupid;
	}

	public void setNogroupid(Integer nogroupid) {
		this.nogroupid = nogroupid;
	}

	public Integer getScpid() {
		return this.scpid;
	}

	public void setScpid(Integer scpid) {
		this.scpid = scpid;
	}

	public String getBossarea() {
		return this.bossarea;
	}

	public void setBossarea(String bossarea) {
		this.bossarea = bossarea;
	}

	public String getOriginbrandid() {
		return this.originbrandid;
	}

	public void setOriginbrandid(String originbrandid) {
		this.originbrandid = originbrandid;
	}

	public Integer getVpmnid() {
		return this.vpmnid;
	}

	public void setVpmnid(Integer vpmnid) {
		this.vpmnid = vpmnid;
	}

	public String getPlatformtype() {
		return this.platformtype;
	}

	public void setPlatformtype(String platformtype) {
		this.platformtype = platformtype;
	}

}