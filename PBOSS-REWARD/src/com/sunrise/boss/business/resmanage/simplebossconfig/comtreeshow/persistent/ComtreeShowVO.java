package com.sunrise.boss.business.resmanage.simplebossconfig.comtreeshow.persistent;

public class ComtreeShowVO implements java.io.Serializable {

	private Long comclassid;
	private Long comtype;
	private String wayid;
	private Long cityid;
	private String oprcode;
	private Long state;
	
	public ComtreeShowVO() {}
	
	public ComtreeShowVO(Long comclassid, Long comtype, String wayid, Long cityid){
		this.comclassid = comclassid;
		this.comtype = comtype;
		this.wayid = wayid;
		this.cityid = cityid;
	}
	
	
	public ComtreeShowVO(Long comclassid, Long comtype, String wayid, Long cityid,
			String oprcode, Long state) {
		this.comclassid = comclassid;
		this.comtype = comtype;
		this.wayid = wayid;
		this.cityid = cityid;
		this.oprcode = oprcode;
		this.state = state;
	}



	public Long getComclassid() {
		return comclassid;
	}



	public void setComclassid(Long comclassid) {
		this.comclassid = comclassid;
	}



	public Long getComtype() {
		return comtype;
	}



	public void setComtype(Long comtype) {
		this.comtype = comtype;
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

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

}