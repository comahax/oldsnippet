package com.gmcc.pboss.business.resource.emptysim;

public class EmptysimTableVO {
	private String countyid;
	private String wayid;
	private String ncount;
	private String usestate;
	//附加属性 为页面分组显示用 
	private int countyCount = 1; 
	private int wayCount = 1;
	private int usestateCount = 1;
	
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
	public String getNcount() {
		return ncount;
	}
	public void setNcount(String ncount) {
		this.ncount = ncount;
	}
	public String getUsestate() {
		return usestate;
	}
	public void setUsestate(String usestate) {
		this.usestate = usestate;
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
	public int getUsestateCount() {
		return usestateCount;
	}
	public void setUsestateCount(int usestateCount) {
		this.usestateCount = usestateCount;
	}

}
