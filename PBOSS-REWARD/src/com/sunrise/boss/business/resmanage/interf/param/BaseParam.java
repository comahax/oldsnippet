package com.sunrise.boss.business.resmanage.interf.param;

import java.io.Serializable;

/**
 * <p>
 * Title: BOSS1.5
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Rodney
 * @version ÏÂÎç03:24:282006-8-30
 */
public class BaseParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cityid;

	private String oprcode;

	private String cmd;

	private Long restype;

	private String wayid;

	private Long oprtype;

	private String path;

	Long getOprtype() {
		return oprtype;
	}

	public void setOprtype(Long oprtype) {
		this.oprtype = oprtype;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getRestype() {
		return restype;
	}

	public void setRestype(Long restype) {
		this.restype = restype;
	}
}
