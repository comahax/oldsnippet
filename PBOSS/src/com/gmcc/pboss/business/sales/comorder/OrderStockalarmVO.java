package com.gmcc.pboss.business.sales.comorder;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class OrderStockalarmVO extends BaseVO implements Serializable {
	private String brand;
	private String alarmValue;
	private Long maxStock;
	private Long nowstock;
	private Long orderMax;
	private String brandsName;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getAlarmValue() {
		return alarmValue;
	}
	public void setAlarmValue(String alarmValue) {
		this.alarmValue = alarmValue;
	}
	public Long getMaxStock() {
		return maxStock;
	}
	public void setMaxStock(Long maxStock) {
		this.maxStock = maxStock;
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
	public String getBrandsName() {
		return brandsName;
	}
	public void setBrandsName(String brandsName) {
		this.brandsName = brandsName;
	}
}
