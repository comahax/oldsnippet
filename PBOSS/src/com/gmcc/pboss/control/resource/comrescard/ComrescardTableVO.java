package com.gmcc.pboss.control.resource.comrescard;

public class ComrescardTableVO {
	private String countyid;
	private String wayid;
	private String comcategory;
	private String comstate;
	private String ncount;
	
	//附加属性 为页面分组显示用 
	private int countyCount = 1; 
	private int wayCount = 1;
	private int comcateCount = 1;
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getComcategory() {
		return comcategory;
	}
	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	public String getNcount() {
		return ncount;
	}
	public void setNcount(String ncount) {
		this.ncount = ncount;
	}
	public int getCountyCount() {
		return countyCount;
	}
	public void setCountyCount(int countyCount) {
		this.countyCount = countyCount;
	}
	public int getWayCount() {
		return wayCount;
	}
	public void setWayCount(int wayCount) {
		this.wayCount = wayCount;
	}
	public String getComstate() {
		return comstate;
	}
	public void setComstate(String comstate) {
		this.comstate = comstate;
	}
	public int getComcateCount() {
		return comcateCount;
	}
	public void setComcateCount(int comcateCount) {
		this.comcateCount = comcateCount;
	}

}
