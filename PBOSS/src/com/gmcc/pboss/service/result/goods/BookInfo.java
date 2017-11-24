/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

/**
 * 订购信息
 * 
 * @author hbm
 */
public class BookInfo implements Serializable {
	private String brandName;// 品牌名称
	private int canBookNonceMonth;// 本月可订购量，单位：套
	private int bookedNonceMonth;// 本月已订购量，单位：套
	private int surBookNonceMonth;// 本月剩余订购量，单位：套
	private int canBookToday;// 今天可订购量，单位：套
	private int bookedToday;// 今天已订购量，单位：套
	private int surBookToday;// 今天剩余订购量，单位：套

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

}
