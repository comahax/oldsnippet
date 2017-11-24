package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

public class ComresscardOrderInfo implements Serializable{
	private String comcategory;//商品种类
	private Long orderMaxMonth;//当月可订购量
	private Long orderedMonth;//当月已订购量
	private Long orderRemainMonth;//当月剩余订购量
	private Long orderMaxDay;//当日可订购量
	private Long orderedDay;//当日已订购量
	private Long orderRemainDay;//当日剩余订购量
	public String getComcategory() {
		return comcategory;
	}
	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
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
	
	
}
