package com.sunrise.boss.business.fee.integral.custinte.persistent;

import java.io.Serializable;
import java.util.Date;


public class VCustInteVO implements Serializable {

	private String id;
	private Long custid;
	private Long integralcyc;
	private Long integral;
	private Long availintegral;
	private Long moveint;
	private Long competencyinte;
	private Long saleint;
	private Date starttime;
	private Date stoptime; 
	private Date updatetime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getAvailintegral() {
		return availintegral;
	}
	public void setAvailintegral(Long availintegral) {
		this.availintegral = availintegral;
	}
	
	public Long getCompetencyinte() {
		return competencyinte;
	}
	public void setCompetencyinte(Long competencyinte) {
		this.competencyinte = competencyinte;
	}
	public Long getCustid() {
		return custid;
	}
	public void setCustid(Long custid) {
		this.custid = custid;
	}
	public Long getIntegral() {
		return integral;
	}
	public void setIntegral(Long integral) {
		this.integral = integral;
	}
	public Long getIntegralcyc() {
		return integralcyc;
	}
	public void setIntegralcyc(Long integralcyc) {
		this.integralcyc = integralcyc;
	}
	public Long getMoveint() {
		return moveint;
	}
	public void setMoveint(Long moveint) {
		this.moveint = moveint;
	}
	public Long getSaleint() {
		return saleint;
	}
	public void setSaleint(Long saleint) {
		this.saleint = saleint;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getStoptime() {
		return stoptime;
	}
	public void setStoptime(Date stoptime) {
		this.stoptime = stoptime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	
	

}
