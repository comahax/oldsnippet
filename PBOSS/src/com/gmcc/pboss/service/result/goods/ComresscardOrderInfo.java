package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

public class ComresscardOrderInfo implements Serializable{
	private String comcategory;//��Ʒ����
	private Long orderMaxMonth;//���¿ɶ�����
	private Long orderedMonth;//�����Ѷ�����
	private Long orderRemainMonth;//����ʣ�ඩ����
	private Long orderMaxDay;//���տɶ�����
	private Long orderedDay;//�����Ѷ�����
	private Long orderRemainDay;//����ʣ�ඩ����
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
