package com.sunrise.boss.business.resmanage.simplebossconfig.simpleboss.persistent;

public class SimpleBossVO implements java.io.Serializable {

	private String wayid;
	private Long cityid;
	private String oprcode;
	private Long state;
	
	public SimpleBossVO() {}
	
	public SimpleBossVO(Long cityid,String wayid ) {
		this.cityid = cityid;
		this.wayid = wayid;
	}
	
	public SimpleBossVO(Long cityid,String wayid,String oprcode, Long state) {
		this.cityid = cityid;
		this.wayid = wayid;
		this.oprcode = oprcode;
		this.state = state;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public String getWayid() {
		return wayid;
	}



	public void setWayid(String wayid) {
		this.wayid = wayid;
	}



	public Long getCityid() {
		return cityid;
	}



	public void setCityid(Long cityid) {
		this.cityid = cityid;
	}



	public String getOprcode() {
		return oprcode;
	}



	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}



}