package com.gmcc.pboss.control.resource.comressmp;

import java.io.Serializable;

public class ComressmpTableVO implements Serializable{
	
	private String countyid;
	private String wayid;
	private String brand;
	private String comcategory;
	private String comstate;
	private String ncount;
	
	//附加属性 为页面分组显示用 
	private int countyCount = 1; 
	private int wayCount = 1;
	private int brandCount = 1;
	private int comcateCount = 1;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return countyid+"|"+wayid+"|"+brand+"|"+comcategory+"|"+ncount;
	}

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getComstate() {
		return comstate;
	}

	public void setComstate(String comstate) {
		this.comstate = comstate;
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

	public int getBrandCount() {
		return brandCount;
	}

	public void setBrandCount(int brandCount) {
		this.brandCount = brandCount;
	}

	public int getComcateCount() {
		return comcateCount;
	}

	public void setComcateCount(int comcateCount) {
		this.comcateCount = comcateCount;
	}

}