package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

public class MondaystockInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String brandName;				//品牌名称
	private int  canBookNonceMonth;			//本月可订购量，单位：套
	private int bookedNonceMonth; 			//本月已订购量，单位：套
	private int surBookNonceMonth;			//本月剩余订购量，单位：套
	private int canBookToday;				//今天可订购量，单位：套
	private int bookedToday;				//今天已订购量，单位：套
	private int surBookToday;				//今天剩余订购量，单位：套
	private int basicStock;					//基准库存，单位：套
	private int nonceStock;					//当前库存，单位：套
	private int nonceMaxStock;				//当前最大库存量，单位：套
	private int refMaxStock;				//最大订购量参考，单位：套
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getCanBookNonceMonth() {
		return canBookNonceMonth;
	}
	public void setCanBookNonceMonth(int canBookNonceMonth) {
		this.canBookNonceMonth = canBookNonceMonth;
	}
	public int getBookedNonceMonth() {
		return bookedNonceMonth;
	}
	public void setBookedNonceMonth(int bookedNonceMonth) {
		this.bookedNonceMonth = bookedNonceMonth;
	}
	public int getSurBookNonceMonth() {
		return surBookNonceMonth;
	}
	public void setSurBookNonceMonth(int surBookNonceMonth) {
		this.surBookNonceMonth = surBookNonceMonth;
	}
	public int getCanBookToday() {
		return canBookToday;
	}
	public void setCanBookToday(int canBookToday) {
		this.canBookToday = canBookToday;
	}
	public int getBookedToday() {
		return bookedToday;
	}
	public void setBookedToday(int bookedToday) {
		this.bookedToday = bookedToday;
	}
	public int getSurBookToday() {
		return surBookToday;
	}
	public void setSurBookToday(int surBookToday) {
		this.surBookToday = surBookToday;
	}
	public int getBasicStock() {
		return basicStock;
	}
	public void setBasicStock(int basicStock) {
		this.basicStock = basicStock;
	}
	public int getNonceStock() {
		return nonceStock;
	}
	public void setNonceStock(int nonceStock) {
		this.nonceStock = nonceStock;
	}
	public int getNonceMaxStock() {
		return nonceMaxStock;
	}
	public void setNonceMaxStock(int nonceMaxStock) {
		this.nonceMaxStock = nonceMaxStock;
	}
	public int getRefMaxStock() {
		return refMaxStock;
	}
	public void setRefMaxStock(int refMaxStock) {
		this.refMaxStock = refMaxStock;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	

}
