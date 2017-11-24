package com.gmcc.pboss.business.sales.ressum;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class RessumVO extends BaseVO implements Serializable {
    private String wayid;
    private String wayname;
    private String comid;
    private String comname;
    private Integer amount;
    
    private Double recamt;
    private Double actamt;
    private Double comprice;
    private Double relprice;
    
    private String recamtFormat;
    private String actamtFormat;
    private String compriceFormat;
    private String relpriceFormat;
    
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
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
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
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public Double getComprice() {
		return comprice;
	}
	public void setComprice(Double comprice) {
		this.comprice = comprice;
	}
	public Double getRelprice() {
		return relprice;
	}
	public void setRelprice(Double relprice) {
		this.relprice = relprice;
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
	public String getCompriceFormat() {
		return compriceFormat;
	}
	public void setCompriceFormat(String compriceFormat) {
		this.compriceFormat = compriceFormat;
	}
	public String getRelpriceFormat() {
		return relpriceFormat;
	}
	public void setRelpriceFormat(String relpriceFormat) {
		this.relpriceFormat = relpriceFormat;
	}
}
