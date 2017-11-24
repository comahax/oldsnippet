package com.gmcc.pboss.business.sales.comorder;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class OrderStdstockVO extends BaseVO implements Serializable {
	private String brand;
	private Long stdstock;
	private Long nowstock;
	private Long orderMax;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getStdstock() {
		return stdstock;
	}
	public void setStdstock(Long stdstock) {
		this.stdstock = stdstock;
	}
	public Long getNowstock() {
		return nowstock;
	}
	public void setNowstock(Long nowstock) {
		this.nowstock = nowstock;
	}
	public Long getOrderMax() {
		return orderMax;
	}
	public void setOrderMax(Long orderMax) {
		this.orderMax = orderMax;
	}
}
