package com.sunrise.boss.business.fee.common.prodinfo.persistent;

import java.io.Serializable;


public class ProdInfoVO implements Serializable {

	private String prodid	 ;
	private String brand	 ;
	private String prodname  ;
	private String cardtype  ;
	private String paytype   ;
	private Short  xzmode	 ;
	private String memo	     ;
	
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public Short getXzmode() {
		return xzmode;
	}
	public void setXzmode(Short xzmode) {
		this.xzmode = xzmode;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
