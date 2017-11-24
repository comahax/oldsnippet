package com.gmcc.pboss.business.sales.comorder;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

/**
 * ���¿�����ģʽ----MONDAYSTOCK
 * @author dxx
 *
 */
public class OrderMonthdayStockVO extends BaseVO implements Serializable {
	private String brand;
	//���� �ɶ���
	private Long orderMaxMonth;
	//���� �Ѷ���
	private Long orderedMonth;
	//���� ʣ����
	private Long orderRemainMonth;
	//���� �ɶ���
	private Long orderMaxDay;
	//���� �Ѷ���
	private Long orderedDay;
	//���� ʣ����
	private Long orderRemainDay;
	
	//��׼���
	private Long stdstock;
	//ʵ�ʿ��(��ǰ���)
	private Long nowstock;
	//��ǰ��󶩹���
	private Long orderMax;
	
	//��󶩹����ο�,��󶩹����ο�ֵȡ����ǰ��󶩹�������������ʣ��������������ʣ��������������Сֵ
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
