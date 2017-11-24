package com.gmcc.pboss.biz.info.registernewcnt.support;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;

public class Registernewcnt {

	// 网点编码
	private String wayid;
	// 网点名称
	private String wayname;
	// 分公司
	private String countyid;
	private String countyName;
	// 星级
	private String starlevel;
	private String strstarlevel;
	// 数量
	private String cnt;
	
	public Registernewcnt() {
		super();
	}
	
	/**
	 * 
	 * @param wayid 网点编码
	 * @param wayname 网点名称
	 * @param countyid 分公司
	 * @param starlevel 星级
	 * @param cnt 数量
	 */
	public Registernewcnt(String wayid, String wayname, String countyid, String starlevel, String cnt) {
		super();
		this.wayid = wayid;
		this.wayname = wayname;
		this.countyid = countyid;
		if (countyid != null)
			this.countyName = Constant.getCountyidchName(countyid);
		this.starlevel = starlevel;
		if (starlevel != null)
			this.strstarlevel = Constant.getConstantName(ConstantsType.STARLEVEL,starlevel.toString());
		this.cnt = cnt;
	}
	
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public String getStarlevel() {
		return starlevel;
	}
	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getStrstarlevel() {
		return strstarlevel;
	}

	public void setStrstarlevel(String strstarlevel) {
		this.strstarlevel = strstarlevel;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
}
