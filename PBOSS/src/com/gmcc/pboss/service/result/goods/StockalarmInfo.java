package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

public class StockalarmInfo implements Serializable{

	private String brandName;		//Ʒ������
	private String  alarmValue;		//Ԥ����ֵ�ַ������뱣�淭����ֵ��
	private int orderStock; 		//�ڶ����
	private long maxStock;			//��߿��
	private long nowstock;			//��ǰ���
	private long orderMax;			//��󶩹���
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getAlarmValue() {
		return alarmValue;
	}
	public void setAlarmValue(String alarmValue) {
		this.alarmValue = alarmValue;
	}
	public int getOrderStock() {
		return orderStock;
	}
	public void setOrderStock(int orderStock) {
		this.orderStock = orderStock;
	}
	public long getMaxStock() {
		return maxStock;
	}
	public void setMaxStock(long maxStock) {
		this.maxStock = maxStock;
	}
	public long getNowstock() {
		return nowstock;
	}
	public void setNowstock(long nowstock) {
		this.nowstock = nowstock;
	}
	public long getOrderMax() {
		return orderMax;
	}
	public void setOrderMax(long orderMax) {
		this.orderMax = orderMax;
	}
	
	
}
