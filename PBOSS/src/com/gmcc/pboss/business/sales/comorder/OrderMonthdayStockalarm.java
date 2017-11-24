package com.gmcc.pboss.business.sales.comorder;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class OrderMonthdayStockalarm extends BaseVO implements Serializable {
	private String brand;
	private Long orderMaxMonth;
	private Long orderedMonth;
	private Long orderRemainMonth;
	private Long orderMaxDay;
	private Long orderedDay;
	private Long orderRemainDay;
	
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
	public Long getOrderMaxMonth() {
		return orderMaxMonth;
	}
	public void setOrderMaxMonth(Long orderMaxMonth) {
		this.orderMaxMonth = orderMaxMonth;
	}
	public Long getOrderedMonth() {
		return orderedMonth;
	}
	public void setOrderedMonth(Long orderedMonth) {
		this.orderedMonth = orderedMonth;
	}
	public Long getOrderRemainMonth() {
		return orderRemainMonth;
	}
	public void setOrderRemainMonth(Long orderRemainMonth) {
		this.orderRemainMonth = orderRemainMonth;
	}
	public Long getOrderMaxDay() {
		return orderMaxDay;
	}
	public void setOrderMaxDay(Long orderMaxDay) {
		this.orderMaxDay = orderMaxDay;
	}
	public Long getOrderedDay() {
		return orderedDay;
	}
	public void setOrderedDay(Long orderedDay) {
		this.orderedDay = orderedDay;
	}
	public Long getOrderRemainDay() {
		return orderRemainDay;
	}
	public void setOrderRemainDay(Long orderRemainDay) {
		this.orderRemainDay = orderRemainDay;
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
