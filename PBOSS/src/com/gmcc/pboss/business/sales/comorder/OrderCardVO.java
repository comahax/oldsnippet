package com.gmcc.pboss.business.sales.comorder;

import java.io.Serializable;
import com.sunrise.jop.infrastructure.db.BaseVO;

public class OrderCardVO extends BaseVO implements Serializable{
	private String comcategory;
	private Long orderMaxMonth;
	private Long orderedMonth;
	private Long orderRemainMonth;
	private Long orderMaxDay;
	private Long orderedDay;
	private Long orderRemainDay;
	private Long oncelimit;
	
	public Long getOncelimit() {
		return oncelimit;
	}
	public void setOncelimit(Long oncelimit) {
		this.oncelimit = oncelimit;
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
	public String getComcategory() {
		return comcategory;
	}
	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
}
