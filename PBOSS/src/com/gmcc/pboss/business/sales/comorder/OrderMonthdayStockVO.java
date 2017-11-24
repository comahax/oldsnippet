package com.gmcc.pboss.business.sales.comorder;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

/**
 * 日月库存组合模式----MONDAYSTOCK
 * @author dxx
 *
 */
public class OrderMonthdayStockVO extends BaseVO implements Serializable {
	private String brand;
	//当月 可订购
	private Long orderMaxMonth;
	//当月 已订购
	private Long orderedMonth;
	//当月 剩余量
	private Long orderRemainMonth;
	//当天 可订购
	private Long orderMaxDay;
	//当天 已订购
	private Long orderedDay;
	//当天 剩余量
	private Long orderRemainDay;
	
	//基准库存
	private Long stdstock;
	//实际库存(当前库存)
	private Long nowstock;
	//当前最大订购量
	private Long orderMax;
	
	//最大订购量参考,最大订购量参考值取“当前最大订购量”、“当月剩余量”、“当天剩余量”三者中最小值
	private Long referData;
	
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
	public Long getStdstock() {
		return stdstock;
	}
	public void setStdstock(Long stdstock) {
		this.stdstock = stdstock;
	}
	public Long getReferData() {
		return referData;
	}
	public void setReferData(Long referData) {
		this.referData = referData;
	}
}
