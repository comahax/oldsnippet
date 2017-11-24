package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

public class StockalarmInfo implements Serializable{

	private String brandName;		//品牌名称
	private String  alarmValue;		//预警阀值字符串（请保存翻译后的值）
	private int orderStock; 		//在订库存
	private long maxStock;			//最高库存
	private long nowstock;			//当前库存
	private long orderMax;			//最大订购量
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
