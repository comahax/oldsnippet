package com.gmcc.pboss.business.sales.chargesum;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class ChargesumVO extends BaseVO implements Serializable {
    private String wayid;
    private String wayname;
    private String paytype;
    private Double recamt;
    private Double actamt;
    
    private String recamtFormat;
    private String actamtFormat;
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
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public Double getRecamt() {
		return recamt;
	}
	public void setRecamt(Double recamt) {
		this.recamt = recamt;
	}
	public Double getActamt() {
		return actamt;
	}
	public void setActamt(Double actamt) {
		this.actamt = actamt;
	}
	public String getRecamtFormat() {
		return recamtFormat;
	}
	public void setRecamtFormat(String recamtFormat) {
		this.recamtFormat = recamtFormat;
	}
	public String getActamtFormat() {
		return actamtFormat;
	}
	public void setActamtFormat(String actamtFormat) {
		this.actamtFormat = actamtFormat;
	}

}
